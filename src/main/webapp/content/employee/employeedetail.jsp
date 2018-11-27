<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>员工维护详细 - 笑享租</title>
    <link rel="stylesheet" href="assets/css/chosen.css"/>
    <link rel="stylesheet" href="assets/css/bootstrap-datepicker3.css" />
    <link rel="stylesheet" href="assets/css/bootstrap-timepicker.css" />
    <link rel="stylesheet" href="assets/css/daterangepicker.css" />
    <link rel="stylesheet" href="assets/css/bootstrap-datetimepicker.css" />
    <style>
        .form-group {
            margin-left: 0 !important;
            margin-right: 0 !important;
            margin-bottom: 0 !important;
        }
    </style>
</head>
<body>

<div class="page-header">
    <h5>
        <div class="row">
            <button class="btn btn-default btn-sm" onclick="history.back()">
                <i class="ace-icon fa fa-arrow-left"></i>
                返回
            </button>
        </div>
    </h5>
</div>
<div class="row">
    <div class="col-xs-12">
        <form class="form-horizontal" id="validation-form-employee" method="post">
            <input type="hidden" name="id" value="${requestScope.employee.id}">

            <div class="space-20"></div>

            <div class="widget-box">
                <div class="widget-header">
                    <h4 class="widget-title">员工信息</h4>
                    <div class="widget-toolbar">
                        <a href="#" data-action="collapse">
                            <i class="ace-icon fa fa-chevron-up"></i>s
                        </a>
                    </div>
                </div>
                <div class="widget-body">
                    <div class="widget-main" style="min-height: 200px;">
                        <div class="row">
                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-employee-loginNo">登录名<span class="red">*</span></label>
                                <input class="form-control" id="form-employee-loginNo" name="loginNo" value="${requestScope.employee.loginNo}">
                            </div>
                            <c:if test="${empty requestScope.employee}">
                                <div class="col-xs-3 form-group">
                                    <label class="control-label" for="form-employee-password">密码<span class="red">*</span></label>
                                    <input type="password" class="form-control" id="form-employee-password" name="password" value="${requestScope.employee.password}">
                                </div>
                            </c:if>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-employee-name">姓名<span class="red">*</span></label>
                                <input class="form-control" id="form-employee-name" name="name" value="${requestScope.employee.name}"/>
                            </div>

                            <div class="col-xs-3  form-group">
                                <label for="form-employee-sex">性别</label>
                                <select name="sex" id="form-employee-sex" class="form-control">
                                    <option value="1">男</option>
                                    <option value="2">女</option>
                                </select>
                            </div>

                        </div>

                        <div class="space-12"></div>

                        <div class="row">
                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-employee-birthday">生日</label>
                                <input class="form-control date-picker" id="form-employee-birthday" type="text" name="birthday"
                                       data-date-format="yyyy-mm-dd" value="${requestScope.employee.birthday}" placeholder="请选择您的出生年月">
                            </div>
                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-employee-cellphone">手机</label>
                                <input class="form-control" id="form-employee-cellphone" type="text" name="cellphone"
                                       value="${requestScope.employee.cellphone}"/>
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-employee-age">年龄</label>
                                <input id="form-employee-age" class="form-control" name="age" value="${requestScope.employee.age}"/>
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-employee-weixin">微信</label>
                                <input id="form-employee-weixin" class="form-control" value="${requestScope.employee.weixin}"
                                       name="weixin"/>
                            </div>

                        </div>

                        <div class="space-12"></div>
                        <div class="row">
                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-employee-qq">QQ</label>
                                <input id="form-employee-qq" class="form-control" value="${requestScope.employee.qq}"
                                       name="qq"/>
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-employee-depId">所属部门</label>
                                <select name="depId" id="form-employee-depId" class="form-control">
                                    <option value=""></option>
                                    <option value="1">财务部</option>
                                    <option value="2">市场部</option>
                                    <option value="3">营销部</option>
                                    <option value="4">贷后服务部</option>
                                    <option value="5">风控部</option>
                                    <option value="6">人事部</option>
                                    <option value="7">运营部</option>
                                    <option value="8">开发部</option>
                                </select>
                            </div>

                           <%-- <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-employee-postId">
                                    职位
                                    <span class="help-button" data-rel="popover" data-trigger="hover" data-placement="left" data-content="职位设置为经理、主管，可以查看所有客户订单信息， 设置为员工时，只能查看已分配的代理商上传的客户订单信息"
                                          title="" data-original-title="设置说明">?</span>
                                </label>
                                <select id="form-employee-postId" name="postId" class="form-control">
                                    <option value=""></option>
                                    <option value="1">主管</option>
                                    <option value="2">经理</option>
                                    <option value="3">员工</option>
                                </select>
                            </div>--%>
<%--
                            <div class="col-xs-3 form-group postshow">
                                <label class="control-label" for="form-user-agency_ids">代理商</label>
                                <select id="form-user-agency_ids" name="agency_ids" class="chosen-select form-control" multiple="multiple"
                                        data-placeholder="分配代理商...">
                                </select>
                            </div>--%>
                        </div>
                    </div>
                </div>
            </div>

            <div class="space-12"></div>
            <div class="row" id="employee_save_info">
                <div class="col-xs-4 col-xs-offset-5">
                    <input type="submit" class="btn btn-primary" id="employee_save" value="保存">
                    <input type="reset" class="btn" style="margin-left: 20px;" onclick="resetForm()" value="重置表单">
                </div>
            </div>
        </form>
    </div>
</div>
</body>
<script>
    var scripts = [null,
        "assets/js/date-time/bootstrap-datepicker.js",
        "assets/js/date-time/bootstrap-timepicker.js",
        "assets/js/date-time/daterangepicker.js",
        "assets/js/jquery.colorbox.js",
        "assets/js/jquery.validate.js",
        "assets/js/jquery.validate_zh.js",
        "assets/js/jquery.form.js",
        "assets/js/bootbox.js",
        "assets/js/chosen.jquery.js",
        "assets/js/date-time/bootstrap-datetimepicker.js", null];

    function resetForm() {
        $(".chosen-select").val('').trigger("chosen:updated");
    }

    $('.page-content-area').ace_ajax('loadScripts', scripts, function () {
        //获取url中的参数信息
        $(function () {
            $(document).on('settings.ace.chosen', function (e, event_name, event_val) {
                if (event_name != 'sidebar_collapsed') return;
                $('.chosen-select').each(function () {
                    var $this = $(this);
                    $this.next().css({'width': $this.parent().width()});
                })
            });

            $('[data-rel=popover]').popover({container:'body'});

            //设置日期选择样式
            $('.date-picker').datepicker({
                autoclose: true,
                todayHighlight: true
            });


            //先设置信息，在设置选择框信息
            $('.chosen-select').chosen({allow_single_deselect: true});

            // myAjax("/base/getAllAgency", null, function(result){
            //     if(result.code === 1) {
            //         createSelect(result.data);
            //     }else{
            //         showErrorInfo(result.message);
            //     }
            // });
            function createSelect(data) {
                var html = '<option value="">&nbsp;</option>';
             <%--var agency_ids = '${requestScope.employee.agency_ids}';--%>
                <%--data.forEach(function (info) {--%>
                    <%--if(agency_ids) {--%>
                        <%--if((','+agency_ids+',').indexOf(','+info.aid+',') > -1) {--%>
                            <%--html += '<option selected value="' + info.aid + '">'+info.agency_cityname+'----' + info.aname + '</option>';--%>
                        <%--}else{--%>
                            <%--html += '<option  value="' + info.aid + '">'+info.agency_cityname+'----' + info.aname + '</option>';--%>
                        <%--}--%>
                    <%--}else{--%>
                        <%--html += '<option value="' + info.aid + '">'+info.agency_cityname+'----' + info.aname + '</option>';--%>
                    <%--}--%>
                <%--});--%>
                // $("#form-emplyee-agency_ids").html(html);
                $(".chosen-select").trigger("chosen:updated");
            }

            if('${requestScope.employee.id}') {
                $("select[name=sex]").val('${requestScope.employee.sex}');
                $("select[name=depId]").val('${employee.depId}');
               <%--/* $("select[name=post_id]").val('${requestScope.employee.post_id}');*/--%>

            }
        });

        $("#validation-form-employee").submit(function (e) {
            e.preventDefault();
            var flag = $("#validation-form-employee").valid();
            if (flag) {
                $(this).ajaxSubmit({
                    url: projectUrl + "/employee/addUpdEmployee",
                    type: "post",
                    success: function (result) {
                        bootbox.hideAll();
                        if (result.code === 1) {
                            showInfo("操作成功! 即将返回主列表")
                            $("#employee_save_info").hide();
                            setTimeout(function(){
                                history.back();
                            }, 4000);
                        } else {
                            showErrorInfo("操作失败！错误信息：" + result.message);
                        }
                    },
                    error: function (err) {
                        bootbox.hideAll();
                        showErrorInfo("保存失败，" + err.statusText);
                    }
                });
            }
            return false;
        });

        $("#validation-form-employee").validate({
            errorElement: 'div',
            errorClass: 'help-block',
            focusInvalid: false,
            ignore: ":hidden:not(select)",
            rules: {
                loginNo: {required: true},
                name: {required: true},
                age: {number:true},
                cellphone: {number: true},
            },
            highlight: function (e) {
                $(e).closest('.form-group').removeClass('has-info').addClass('has-error');
            },
            success: function (e) {
                $(e).closest('.form-group').removeClass('has-error');//.addClass('has-info');
                $(e).remove();
            },
            errorPlacement: function (error, element) {
                if (element.is('input[type=checkbox]') || element.is('input[type=radio]')) {
                    var controls = element.closest('div[class*="col-"]');
                    if (controls.find(':checkbox,:radio').length > 1) controls.append(error);
                    else error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
                }
                else if (element.is('.select2')) {
                    error.insertAfter(element.siblings('[class*="select2-container"]:eq(0)'));
                }
                else if (element.is('.chosen-select')) {
                    error.insertAfter(element.siblings('[class*="chosen-container"]:eq(0)'));
                } else if (element.is('input[type=file]')) {
                    $(error).css("margin-top", "35px");
                    $(error).css("position", "absolute");
                    error.insertAfter(element);
                } else {
                    error.insertAfter(element)
                };
            }
        });
    });
</script>
</html>


