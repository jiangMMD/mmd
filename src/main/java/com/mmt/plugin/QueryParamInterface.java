package com.mmt.plugin;


import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.mmt.pjo.Page;
import com.mmt.pjo.QueryParam;
import com.mmt.pjo.Relation;
import com.mmt.utils.PublicUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.builder.StaticSqlSource;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.locks.Lock;

/**
 * mybatis 设置查询参数插件
 */
@Intercepts(@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}))
public class QueryParamInterface implements Interceptor {

    private static final ThreadLocal<Page> localPage = new ThreadLocal<>();

    public static void setLocalPage(Page page) {
        localPage.set(page);
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        try {
            if (localPage.get() == null || StringUtils.isEmpty(localPage.get().getFilters())) {
                return invocation.proceed();
            }
            MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
            BoundSql boundSql = mappedStatement.getBoundSql(invocation.getArgs()[1]);
            String sql = setParamSql(boundSql, mappedStatement);
            MappedStatement newMs = copyFormMappedStatement(mappedStatement, new StaticSqlSource(
                    mappedStatement.getConfiguration(), sql, boundSql.getParameterMappings()));
            invocation.getArgs()[0] = newMs;
        } finally {
            localPage.remove();
        }
        return invocation.proceed();
    }

    private MappedStatement copyFormMappedStatement(MappedStatement ms, SqlSource staticSqlSource) {
        MappedStatement.Builder builder = new MappedStatement.Builder(ms.getConfiguration(),
                ms.getId(), staticSqlSource, ms.getSqlCommandType());
        builder.resource(ms.getResource());
        builder.fetchSize(ms.getFetchSize());
        builder.statementType(ms.getStatementType());
        builder.keyGenerator(ms.getKeyGenerator());
        if (ms.getKeyProperties() != null && ms.getKeyProperties().length > 0) {
            builder.keyProperty(ms.getKeyProperties()[0]);
        }
        builder.timeout(ms.getTimeout());
        builder.parameterMap(ms.getParameterMap());
        builder.resultMaps(ms.getResultMaps());
        builder.resultSetType(ms.getResultSetType());
        builder.cache(ms.getCache());
        builder.flushCacheRequired(ms.isFlushCacheRequired());
        builder.useCache(ms.isUseCache());
        return builder.build();
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {
    }

    /**
     * 设置sql参数
     *
     * @param boundSql
     */
    public String setParamSql(BoundSql boundSql, MappedStatement mappedStatement) {
        Page page = localPage.get();
        String filters = page.getFilters();
        System.out.println(filters);
        //处理filters
        QueryParam queryParam = JSON.parseObject(filters, QueryParam.class);
        //多条件直接为And 关系
        StringBuilder paramsSql = new StringBuilder();
        List<ParameterMapping> paramterMappings = boundSql.getParameterMappings();
        System.out.println(".........");
        System.out.println(paramterMappings);
        if (Objects.equals(queryParam.getGroupOp(), QueryParam.AND)) {
            List<Relation> rules = queryParam.getRules();
            for (Relation rule : rules) {
                String nSql = createParSqlInfo("and", rule);
                paramsSql.append(nSql);
            }
        } else if (Objects.equals(queryParam.getGroupOp(), QueryParam.OR)) {
            List<Relation> rules = queryParam.getRules();
            for (Relation rule : rules) {
                String nSql = createParSqlInfo("or ", rule); //加一个空格，以便于从第四个位置开始
                paramsSql.append(nSql);
            }
        } else {
            //如果参数异常，那么直接返回原始内容
            return boundSql.getSql();
        }
        String newSql;
        if (paramsSql.length() > 0) {
            if(hasWhere(boundSql.getSql())) {
                newSql = boundSql.getSql() + paramsSql.substring(4);
            }else{
                newSql = boundSql.getSql() + " where " +paramsSql.substring(4);
            }
        } else {
            newSql = boundSql.getSql();
        }
        System.out.println(newSql);
        return newSql;
    }

    /**
     * 判断主表中是否已经where条件，不是子查询的where
     * @param sql
     * @return
     */
    private boolean hasWhere(String sql) {
        if(StringUtils.contains(sql, "where")) {
            if(sql.lastIndexOf("from") > sql.lastIndexOf("where")) {
                //说明是子查询中的where， 那么此情况标明没有where
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }


    /**
     *
     * @param rule
     *      关系条件
     * @return
     */
    private String createParSqlInfo(String main, Relation rule) {
        StringBuilder sbd = new StringBuilder();
        System.out.println(rule.getOp());
        if (Objects.equals(rule.getOp(), QueryParam.NN)) {
            //如果关系条件为存在
            sbd.append(" ");
            sbd.append(main);
            sbd.append(" ");
            sbd.append(rule.getField());
            sbd.append(" is not null ");
        } else if(Objects.equals(rule.getOp(), QueryParam.NU)) {
            System.out.println(">>KKKK");
            sbd.append(" ");
            sbd.append(main);
            sbd.append(" ");
            sbd.append(rule.getField());
            sbd.append(" is null ");
        } else if (StringUtils.isEmpty(rule.getData())) {
            //如果数据为空,那么该条件不做判断
            return "";
        } else {
            //数据不为空的时候，并且依赖数据的值的时候
            switch (rule.getOp()) {
                case QueryParam.EQ :
                    eq(main, sbd, rule.getField(), rule.getData());
                    break;
                case QueryParam.NE :
                    ne(main, sbd, rule.getField(), rule.getData());
                    break;
                case QueryParam.BW :
                    bw(main, sbd, rule.getField(), rule.getData());
                    break;
                case QueryParam.BN :
                    bn(main, sbd, rule.getField(), rule.getData());
                    break;
                case QueryParam.EW :
                    ew(main, sbd, rule.getField(), rule.getData());
                    break;
                case QueryParam.EN :
                    en(main, sbd, rule.getField(), rule.getData());
                    break;
                case QueryParam.CN :
                    cn(main, sbd, rule.getField(), rule.getData());
                    break;
                case QueryParam.NC :
                    nc(main, sbd, rule.getField(), rule.getData());
                    break;
                case QueryParam.IN :
                    in(main, sbd, rule.getField(), rule.getData());
                    break;
                case QueryParam.NI :
                    ni(main, sbd, rule.getField(), rule.getData());
                    break;
            }
        }
        return sbd.toString();
    }
    //等于的处理
    private void eq(String main, StringBuilder sb, String field, String data) {
        sb.append(" ");
        sb.append(main);
        sb.append(" ");
        sb.append(field);
        sb.append(" ");
        sb.append("=");
        sb.append(" '");
        sb.append(data);
        sb.append("'");
    }
    //不等于
    private void ne(String main, StringBuilder sb, String field, String data) {
        sb.append(" ");
        sb.append(main);
        sb.append(" ");
        sb.append(field);
        sb.append(" ");
        sb.append("<>");
        sb.append(" '");
        sb.append(data);
        sb.append("'");
    }
    //开始于
    private void bw(String main, StringBuilder sb, String field, String data) {
        sb.append(" ");
        sb.append(main);
        sb.append(" ");
        sb.append(field);
        sb.append(" like ");
        sb.append("'");
        sb.append(data);
        sb.append("%'");
    }
    //不开始于
    private void bn(String main, StringBuilder sb, String field, String data) {
        sb.append(" ");
        sb.append(main);
        sb.append(" ");
        sb.append(field);
        sb.append(" not like ");
        sb.append("'");
        sb.append(data);
        sb.append("%'");
    }
    //结束于
    private void ew(String main, StringBuilder sb, String field, String data) {
        sb.append(" ");
        sb.append(main);
        sb.append(" ");
        sb.append(field);
        sb.append(" like ");
        sb.append("'%");
        sb.append(data);
        sb.append("'");
    }
    //不结束于
    private void en(String main, StringBuilder sb, String field, String data) {
        sb.append(" ");
        sb.append(main);
        sb.append(" ");
        sb.append(field);
        sb.append(" not like ");
        sb.append("'%");
        sb.append(data);
        sb.append("'");
    }
    //包含
    private void cn(String main, StringBuilder sb, String field, String data) {
        sb.append(" ");
        sb.append(main);
        sb.append(" ");
        sb.append(field);
        sb.append(" like ");
        sb.append("'%");
        sb.append(data);
        sb.append("%'");
    }
    //不包含
    private void nc(String main, StringBuilder sb, String field, String data) {
        sb.append(" ");
        sb.append(main);
        sb.append(" ");
        sb.append(field);
        sb.append(" not like ");
        sb.append("'%");
        sb.append(data);
        sb.append("%'");
    }
    //属于
    private void in(String main, StringBuilder sb, String field, String data) {
        sb.append(" ");
        sb.append(main);
        sb.append(" ");
        sb.append(field);
        sb.append(" in ");
        sb.append("(");
        sb.append(PublicUtil.getIds(data));
        sb.append(")");
    }
    //不属于
    private void ni(String main, StringBuilder sb, String field, String data) {
        sb.append(" ");
        sb.append(main);
        sb.append(" ");
        sb.append(field);
        sb.append(" not in ");
        sb.append("(");
        sb.append(PublicUtil.getIds(data));
        sb.append(")");
    }
}
