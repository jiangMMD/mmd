<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>商品维护 - 魔晶</title>
    <link rel="stylesheet" href="assets/css/select2.css"/>
    <link rel="stylesheet" href="assets/css/bootstrap-datepicker3.css"/>
    <link rel="stylesheet" href="assets/css/bootstrap-timepicker.css"/>
    <link rel="stylesheet" href="assets/css/daterangepicker.css"/>
    <link rel="stylesheet" href="assets/css/bootstrap-datetimepicker.css"/>
    <link rel="stylesheet" href="assets/css/colorbox.css"/>
    <link rel="stylesheet" href="assets/css/dropzone.css"/>
    <style>
        .form-group {
            margin-left: 0 !important;
            margin-right: 0 !important;
            margin-bottom: 0 !important;
        }
        /*.dropzone .dz-preview .dz-image {*/
            /*width:240px;*/
            /*height:120px;*/
        /*}*/
    </style>
</head>
<body>

<div class="page-header">
    <h5>
        <div class="row">
            <button type="button" class="btn btn-default btn-sm" onclick="history.back()">
                <i class="ace-icon fa fa-arrow-left"></i>
                返回
            </button>
        </div>
    </h5>
</div>
<div class="row">
    <div class="col-xs-12">
        <div class="tabbable">
            <ul class="nav nav-tabs padding-12 tab-color-blue background-blue" id="myTab4">
                <li class="active">
                    <a data-toggle="tab" href="#baseprod" aria-expanded="true">产品基本信息</a>
                </li>
                <li class="">
                    <a data-toggle="tab" href="#basecarousal" aria-expanded="false">产品轮播图</a>
                </li>
                <li class="">
                    <a data-toggle="tab" href="#basedetailimg" aria-expanded="false">产品详情图</a>
                </li>

                <li class="">
                    <a data-toggle="tab" href="#basesku" aria-expanded="false">产品SKU</a>
                </li>
            </ul>

            <div class="tab-content">
                <div id="baseprod" class="tab-pane active">
                    <form class="form-horizontal" id="validation-form-productsinfo" method="post">
                        <input type="hidden" name="pid" value="${productsinfo.pid}">
                        <!--产品信息-->
                        <div class="widget-box">
                            <div class="widget-header">
                                <h4 class="widget-title">商品信息</h4>
                                <div class="widget-toolbar">
                                    <a href="#" data-action="collapse">
                                        <i class="ace-icon fa fa-chevron-up"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="widget-body">
                                <div class="widget-main" style="min-height: 200px;">
                                    <c:if test="${empty productsinfo}">
                                        <div class="row">
                                            <div class="col-xs-6 form-group">
                                                <label class="control-label" for="pname">选择商家<span
                                                        class="red">*</span></label>
                                                <select name="mer_id" class="form-group"></select>
                                            </div>
                                        </div>
                                        <div class="space-12"></div>
                                    </c:if>
                                    <div class="row">
                                        <div class="col-xs-3 form-group">
                                            <label class="control-label" for="pname">商品名称<span
                                                    class="red">*</span></label>
                                            <input class="form-control" id="pname" name="pname"
                                                   value="${productsinfo.pname}">
                                        </div>
                                        <div class="col-xs-3 form-group">
                                            <label class="control-label" for="title">商品标题<span
                                                    class="red">*</span></label>
                                            <input class="form-control" id="title" name="title"
                                                   value="${productsinfo.title}">
                                        </div>

                                        <div class="col-xs-3 form-group">
                                            <label class="control-label" for="categoryid">商品类别<span class="red">*</span></label>
                                            <select name="categoryid" id="categoryid" class="form-control">
                                            </select>
                                        </div>

                                        <div class="col-xs-3 form-group">
                                            <label class="control-label" for="volume">尺寸</label>
                                            <input class="form-control" id="volume" name="volume"
                                                   value="${productsinfo.volume}">
                                        </div>
                                    </div>

                                    <div class="space-12"></div>
                                    <div class="row">
                                        <div class="col-xs-3 form-group">
                                            <label class="control-label" for="shopprice">商品价格<span class="red">*</span></label>
                                            <input class="form-control" id="shopprice" name="shopprice"
                                                   placeholder="RMB价格"
                                                   onchange="changePrice(this.value);"
                                                   value="${productsinfo.shopprice}">
                                        </div>
                                        <div class="col-xs-3 form-group">
                                            <label class="control-label" for="shopmmdprice">MMD价格</label>
                                            <div class="">
                                                <span style="margin-left:10px;">
                                                    <c:if test="${productsinfo.isproportion == 1}">
                                                        <input readonly style="width: 70%;"
                                                               class="col-xs-8 form-control" id="shopmmdprice"
                                                               name="shopmmdprice" placeholder="MMD价格"
                                                               value="${productsinfo.shopmmdprice}">
                                                        <input name="isproportion" type="checkbox" class="ace input-lg"
                                                               value="1" checked onclick="checkRate(this)"/>
                                                    </c:if>
                                                    <c:if test="${productsinfo.isproportion != 1}">
                                                        <input style="width: 70%;" class="col-xs-8 form-control"
                                                               id="shopmmdprice" name="shopmmdprice" placeholder="MMD价格"
                                                               value="${productsinfo.shopmmdprice}">
                                                        <input name="isproportion" type="checkbox" class="ace input-lg"
                                                               value="1" onclick="checkRate(this)"/>
                                                    </c:if>
                                                    <span class="lbl">按比例</span>
                                                    <span class="help-button" data-rel="popover" data-trigger="hover"
                                                          data-placement="right"
                                                          data-content="勾选后，将按照系统的RMB:MMD自动计算MMD价格" title=""
                                                          data-original-title="说明">?</span>
                                                </span>
                                            </div>
                                        </div>

                                        <div class="col-xs-3 form-group">
                                            <label class="control-label" for="costprice">商品成本价<span class="red">*</span></label>
                                            <input class="form-control" id="costprice" name="costprice"
                                                   value="${productsinfo.costprice}">
                                        </div>
                                        <div class="col-xs-3 form-group">
                                            <label class="control-label" for="weight">重量</label>
                                            <input class="form-control" id="weight" name="weight"
                                                   value="${productsinfo.weight}">
                                        </div>
                                    </div>

                                    <div class="space-12"></div>
                                    <div class="row">
                                        <div class="col-xs-6 form-group">
                                            <label class="control-label" for="desc">商品简介<span
                                                    class="red">*</span></label>
                                            <textarea class="form-control" id="desc" name="desc"
                                                      value="${productsinfo.desc}">${productsinfo.desc}</textarea>
                                        </div>
                                    </div>

                                    <div class="space-12"></div>
                                    <div class="row">
                                        <div class="col-xs-3 form-group">
                                            <label class="control-label">首页图<span class="red">*</span></label>
                                            <c:if test="${empty productsinfo.homeimg}">
                                                <input type="file" id="prodHomeimgFile" name="homeimgFile"
                                                       accept="image/*"/>
                                                <ul class="ace-thumbnails clearfix" id="imgFile" style="display: none;">
                                                    <li>
                                                        <a href="${productsinfo.homeimg}" data-rel="colorbox">
                                                            <img width="150" height="150" alt="产品首页图"
                                                                 src="${productsinfo.homeimg}"/>
                                                            <div class="text">
                                                                <div class="inner">点击查看详细</div>
                                                            </div>
                                                        </a>
                                                        <div class="tools tools-bottom">
                                                            <a href="#" onclick="">
                                                                <i class="ace-icon fa fa-pencil" title="重新上传"
                                                                   onclick="delImg('imgFile', 'prodHomeimgFile')"></i>
                                                            </a>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </c:if>
                                            <c:if test="${!empty productsinfo.homeimg}">
                                                <input type="file" id="prodHomeimgFile" name="homeimgFile"
                                                       style="display: none;"/>
                                                <ul class="ace-thumbnails clearfix" id="imgFile">
                                                    <li>
                                                        <a href="${productsinfo.homeimg}" data-rel="colorbox">
                                                            <img width="150" height="150" alt="产品首页图"
                                                                 src="${productsinfo.homeimg}"/>
                                                            <div class="text">
                                                                <div class="inner">点击查看详细</div>
                                                            </div>
                                                        </a>
                                                        <div class="tools tools-bottom">
                                                            <a href="#" onclick="">
                                                                <i class="ace-icon fa fa-pencil" title="重新上传"
                                                                   onclick="delImg('imgFile', 'prodHomeimgFile')"></i>
                                                            </a>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </c:if>
                                        </div>
                                        <div class="col-xs-3 form-group">
                                            <label class="control-label">商品参数图<span class="red">*</span></label>
                                            <c:if test="${empty productsinfo.paramimg}">
                                                <input multiple="" type="file" id="prodParamimgFile"
                                                       name="paramimgFile"
                                                       accept="image/*"/>
                                                <ul class="ace-thumbnails clearfix" id="paramimgFile"
                                                    style="display: none;">
                                                    <li>
                                                        <a href="${productsinfo.paramimg}" data-rel="colorbox">
                                                            <img width="230" height="106" alt="产品参数图"
                                                                 src="${productsinfo.paramimg}"/>
                                                            <div class="text">
                                                                <div class="inner">点击查看详细</div>
                                                            </div>
                                                        </a>
                                                        <div class="tools tools-bottom">
                                                            <a href="#" onclick="">
                                                                <i class="ace-icon fa fa-pencil" title="重新上传"
                                                                   onclick="delImg('paramimgFile', 'prodParamimgFile')"></i>
                                                            </a>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </c:if>
                                            <c:if test="${!empty productsinfo.paramimg}">
                                                <input multiple="" type="file" id="prodParamimgFile"
                                                       name="paramimgFile"
                                                       style="display: none;" accept="image/*"/>
                                                <ul class="ace-thumbnails clearfix" id="paramimgFile">
                                                    <li>
                                                        <a href="${productsinfo.paramimg}" data-rel="colorbox">
                                                            <img width="230" height="106" alt="150x150"
                                                                 src="${productsinfo.paramimg}"/>
                                                            <div class="text">
                                                                <div class="inner">点击查看详细</div>
                                                            </div>
                                                        </a>
                                                        <div class="tools tools-bottom">
                                                            <a href="#" onclick="">
                                                                <i class="ace-icon fa fa-pencil" title="重新上传"
                                                                   onclick="delImg('paramimgFile', 'prodParamimgFile')"></i>
                                                            </a>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="space-12"></div>
                        <%--提供的服务--%>
                        <div class="widget-box">
                            <div class="widget-header">
                                <h4 class="widget-title">产品服务<span class="orange">（产品提供哪些服务？）</span></h4>
                                <div class="widget-toolbar">
                                    <a href="#" data-action="collapse">
                                        <i class="ace-icon fa fa-chevron-up"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="widget-body">
                                <div class="widget-main" style="min-height: 80px;">
                                    <div class="space-8"></div>
                                    <div class="row">
                                        <c:forEach items="${allServices}" var="service">
                                            <div class="col-xs-2 form-group">
                                                <div class="checkbox">
                                                    <label>
                                                        <c:if test="${service.isexit == 1}">
                                                            <input value="${service.sid}" name="prodservice"
                                                                   class="ace ace-checkbox-2" type="checkbox" checked/>
                                                        </c:if>
                                                        <c:if test="${service.isexit == 0}">
                                                            <input value="${service.sid}" name="prodservice"
                                                                   class="ace ace-checkbox-2" type="checkbox"/>
                                                        </c:if>
                                                        <span class="lbl">&nbsp;&nbsp;${service.content}&nbsp;&nbsp;</span>
                                                    </label>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="space-12"></div>
                        <div class="row" id="user_save_info">
                            <div class="col-xs-4 col-xs-offset-5">
                                <input type="submit" class="btn btn-primary" id="prodr_save" value="保存">
                                <input type="reset" class="btn" style="margin-left: 20px;" onclick="resetForm()"
                                       value="重置表单">
                            </div>
                        </div>
                    </form>
                </div>

                <div id="basecarousal" class="tab-pane">
                    <%--产品轮播图--%>
                        <div class="widget-box">
                            <div class="widget-header">
                                <h4 class="widget-title">产品轮播图<span class="orange">(如需上传视频，请在第一个轮播图位置上传)</span></h4>
                                <div class="widget-toolbar">
                                    <a href="#" data-action="collapse">
                                        <i class="ace-icon fa fa-chevron-up"></i>
                                    </a>
                                </div>
                            </div>

                            <div class="widget-body">
                                <div class="widget-main" style="min-height: 200px;">
                                    <form  class="dropzone well" id="dropzone" method="post">
                                        <div class="fallback">
                                            <input name="file" type="file" multiple />
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                </div>

                <div id="basedetailimg" class="tab-pane">
                    <%--产品参数图--%>
                    <div class="widget-box">
                            <div class="widget-header">
                                <h4 class="widget-title">产品详细图<span class="orange">(产品详细图，请参考设计图)</span></h4>
                                <div class="widget-toolbar">
                                    <a href="#" data-action="collapse">
                                        <i class="ace-icon fa fa-chevron-up"></i>
                                    </a>
                                </div>
                            </div>

                            <div class="widget-body">
                                <div class="widget-main" style="min-height: 200px;">
                                    <form  class="dropzone well" id="dropzone2" method="post">
                                        <div class="fallback">
                                            <input name="file" type="file" multiple />
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                </div>

                <div id="basesku" class="tab-pane">
                    <%--产品的SKU--%>
                    <div class="widget-box">
                        <div class="widget-header">
                            <h4 class="widget-title">产品属性管理<span class="orange">（维护产品的SKU属性信息）</span></h4>
                            <div class="widget-toolbar">
                                <a href="#" data-action="collapse">
                                    <i class="ace-icon fa fa-chevron-up"></i>
                                </a>
                            </div>
                        </div>
                        <div class="widget-body">
                            <div class="widget-main">
                                <div class="space-8"></div>
                                <div id="skuContent">
                                    <c:forEach items="${prodSku}" var="sku">
                                        <div class="row" id="sku${sku.sku_id}">
                                            <div class="col-xs-2 form-group">
                                                <label class="control-label">产品属性</label>
                                                <div class="orange" id="skuValname" style="overflow: hidden"
                                                     title="${sku.sku_valname}">
                                                        ${sku.sku_valname}
                                                </div>
                                            </div>
                                            <div class="col-xs-2 form-group">
                                                <label class="control-label">RMB价格</label>
                                                <input name="price" class="form-control" type="number"
                                                       value="${sku.price}" readonly/>
                                            </div>

                                            <div class="col-xs-2 form-group">
                                                <label class="control-label">MMD价格</label>
                                                <input name="mmdprice" type="number" class="form-control"
                                                       value="${sku.mmdprice}" readonly/>
                                            </div>

                                            <div class="col-xs-2 form-group">
                                                <label class="control-label">剩余库存</label>
                                                <input name="repertory" type="number" class="form-control"
                                                       value="${sku.repertory}" readonly/>
                                            </div>

                                            <div class="col-xs-2">
                                                <label class="control-label"></label>
                                                <div style="line-height: 40px">
                                                    <button type="button" class="btn btn-sm btn-white btn-info btn-bold"
                                                            onclick="updSku('${sku.sku_id}')">
                                                        <i class="ace-icon fa fa-external-link bigger-90 blue"></i>
                                                        修改
                                                    </button>
                                                    <button type="button"
                                                            class="btn btn-sm btn-white btn-warning btn-bold"
                                                            onclick="delSku('${sku.sku_id}')">
                                                        <i class="ace-icon fa fa-trash-o bigger-90 orange"></i>
                                                        删除
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="space-6" id="space${sku.sku_id}"></div>
                                    </c:forEach>
                                </div>
                                <button type="button" class="col-xs-offset-2 btn btn-sm btn-white btn-info btn-bold"
                                        id="addskubtn">
                                    <i class="ace-icon glyphicon glyphicon-plus bigger-90 blue"></i>
                                    添加SKU
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
<script>
    var scripts = [null,
        "assets/js/dropzone.js",
        "assets/js/date-time/bootstrap-datepicker.js",
        "assets/js/date-time/bootstrap-timepicker.js",
        "assets/js/date-time/daterangepicker.js",
        "assets/js/select2.js",
        "assets/js/jquery.colorbox.js",
        "assets/js/jquery.validate.js",
        "assets/js/jquery.validate_zh.js",
        "assets/js/jquery.form.js",
        "assets/js/chosen.jquery.js",
        "assets/js/date-time/bootstrap-datetimepicker.js", null];

    function resetForm() {
        $(".chosen-select").val('').trigger("chosen:updated");
    }

    var MMDToPriceRate = "";

    function changePrice(defaultVal) {
        if ($("input[name=isproportion]").is(":checked")) {
            if (!MMDToPriceRate) {
                myAjax("/base/getPriceToMMDRate", null, function (res) {
                    MMDToPriceRate = res.data.rate;
                })
            }
            $("#shopmmdprice").val((Number(defaultVal) / Number(MMDToPriceRate)).toFixed(0));
        }
    }

    //改变比例
    function checkRate($this) {
        if (!$($this).is(":checked")) {
            $("#shopmmdprice").attr("readonly", false);
        } else {
            $("#shopmmdprice").attr("readonly", true);
            $("#shopprice").trigger("change");
        }
    }


    $("#addskubtn").click(function () {
        createSKUHtml();
    });

    /**
     * 更新sku信息
     */
    function updSku(id) {
        myAjax("/business/getProdSkuDetail", {sku_id: id}, function (res) {
            createSKUHtml(res, id);
        });
    }

    var propNameData = [];
    myAjax("/base/getPropData", null, function (res) {
        propNameData = res.data;
    });

    function createSKUHtml(res, sku_id) {
        var html = '<form class="form-horizontal" id="skuform">';
        html += '<div class="form-group" style="padding-bottom:10px !important;">';
        html += '<label class="col-xs-2 no-padding-right control-label">产品属性:</label>';
        html += '<div class="col-xs-9" id="propItems">';
        if (res) {
            res.data.skuProp.forEach(function (data) {
                html += '<div class="row propItem">';
                html += '<select name="sku_propname" class="skuSelect1 col-xs-5">';
                html += '<option value="' + data.prop_id + '">' + data.prop_name + '</option>';
                html += '</select>';
                html += '<select name="sku_propval" class="skuSelect2 col-xs-5">';
                html += '<option value="' + data.propval_id + '">' + data.prop_val + '</option>';
                html += '</select>';
                html += '<a href="javascript:void(0);" style="margin-left:10px;"><i class="ace-icon fa fa-trash-o bigger-120 orange"></i></a>';
                html += '<div class="space-6"></div>';
                html += '</div>';
            });
        } else {
            html += '<div class="row propItem">';
            html += '<select name="sku_propname" class="skuSelect1 col-xs-5">';
            html += '<option value=""></option>';
            html += '</select>';
            html += '<select name="sku_propval" class="skuSelect2 col-xs-5">';
            html += '<option value=""></option>';
            html += '</select>';
            html += '<a href="javascript:void(0);" style="margin-left:10px;"><i class="ace-icon fa fa-trash-o bigger-120 orange"></i></a>';
            html += '<div class="space-6"></div>';
            html += '</div>';
        }
        html += '</div>';
        html += '<button type="button" style="margin-left: 17%" class="col-xs-offset-2 btn btn-sm btn-white btn-warning btn-bold" id="propbtn">';
        html += '<i class="ace-icon glyphicon glyphicon-plus bigger-90 orange"></i>';
        html += '添加属性';
        html += '</button>';
        html += '</div>';
        html += '<div class="form-group" style="padding-bottom:10px !important;">';
        html += '<input type="hidden" name="sku_id" value="' + (res && res.data.sku_id ? res.data.sku_id : "") + '">'
        html += '<label class="col-xs-2 no-padding-right control-label" id="sku_price">RMB价格:</label>';
        html += '<input class="col-xs-8" id="sku_price" name="price" type="number" value="' + (res && res.data.price ? res.data.price : "") + '"/>';
        html += '</div>';
        html += '<div class="form-group" style="padding-bottom:10px !important;">';
        html += '<label class="col-xs-2 no-padding-right control-label" id="sku_mmdprice">MMD价格:</label>';
        html += '<input class="col-xs-8" id="sku_mmdprice" name="mmdprice" type="number" value="' + (res && res.data.mmdprice ? res.data.mmdprice : "") + '"/>';
        html += '</div>';
        html += '<div class="form-group" style="padding-bottom:10px !important;">';
        html += '<label class="col-xs-2 no-padding-right control-label" id="sku_repertory">SKU库存:</label>';
        html += '<input class="col-xs-8" id="sku_repertory" name="repertory" type="number" value="' + (res && res.data.repertory ? res.data.repertory : "") + '"/>';
        html += '</div>';
        html += '</form>';

        bootbox.dialog({
            title: "修改产品SKK信息<span class='orange'>(保存之后将立即生效)</span>",
            message: html,
            buttons: {
                ok: {
                    label: "保存",
                    className: 'btn-info',
                    callback: function () {
                        //如果是新增SKU，那么需要先新增产品信息
                        if (!'${productsinfo}') {
                            showErrorInfo("请先添加产品信息;在添加SKU");
                            return;
                        }
                        $("#skuform").validate({
                            errorElement: 'div',
                            errorClass: 'help-block',
                            focusInvalid: false,
                            ignore: ":hidden:not(select)",
                            rules: {
                                sku_propname: {required: true},
                                sku_propval: {required: true},
                                price: {required: true},
                                mmdprice: {required: true},
                                repertory: {required: true},
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
                                }
                                ;
                            }
                        });
                        var vlflg = $("#skuform").valid();
                        console.log(vlflg);
                        if (!vlflg) {
                            return false;
                        }
                        var formdata = $("#skuform").serializeJson();
                        var skuValname = "";
                        $(".skuSelect2").find("option:selected").each(function () {
                            skuValname += ";" + $(this).text();
                        });
                        formdata.skuValname = skuValname.substr(1);
                        formdata.pid = '${productsinfo.pid}';
                        formdata.sku_propname_id = formdata.sku_propname.join(",");
                        formdata.sku_propval_id = formdata.sku_propval.join(",");
                        //开始保存SKU信息；
                        myAjax("/business/saveProdSku", formdata, function (result) {
                            if (result.code === 1) {
                                var data = result.data;
                                if (sku_id) {
                                    console.log(sku_id);
                                    //修改，
                                    $("#sku" + sku_id).find("#skuValname").html(formdata.skuValname);
                                    $("#sku" + sku_id).find("input[name=price]").val(formdata.price);
                                    $("#sku" + sku_id).find("input[name=mmdprice]").val(formdata.mmdprice);
                                    $("#sku" + sku_id).find("input[name=repertory]").val(formdata.repertory);
                                } else {
                                    //新增
                                    addSkuInfoHtml(data);
                                }
                                showSuccInfo("操作成功！");
                            } else {
                                showErrorInfo("操作失败！");
                            }
                        })
                    }
                }
            }
        });
        createBind();
        bindPropSelect();
    }

    function addSkuInfoHtml(data) {
        var html = '<div class="row" id="sku' + data.sku_id + '">';
        html += '<div class="col-xs-2 form-group">';
        html += '<label class="control-label">产品属性</label>';
        html += '<div class="orange" id="skuValname" style="overflow: hidden" title="' + data.skuValname + '">';
        html += data.skuValname;
        html += '</div>';
        html += '</div>';
        html += '<div class="col-xs-2 form-group">';
        html += '<label class="control-label">RMB价格</label>';
        html += '<input name="price" class="form-control" type="number" value="' + data.price + '" readonly/>';
        html += '</div>';
        html += '<div class="col-xs-2 form-group">';
        html += '<label class="control-label">MMD价格</label>';
        html += '<input name="mmdprice" type="number" class="form-control" value="' + data.mmdprice + '" readonly/>';
        html += '</div>';
        html += '<div class="col-xs-2 form-group">';
        html += '<label class="control-label">剩余库存</label>';
        html += '<input name="repertory" type="number" class="form-control" value="' + data.repertory + '" readonly/>';
        html += '</div>';
        html += '<div class="col-xs-2">';
        html += '<label class="control-label"></label>';
        html += '<div style="line-height: 40px">';
        html += '<button type="button" class="btn btn-sm btn-white btn-info btn-bold" onclick="updSku(' + data.sku_id + ')">';
        html += '<i class="ace-icon fa fa-external-link bigger-90 blue"></i>';
        html += '修改';
        html += '</button>';
        html += '<button type="button" class="btn btn-sm btn-white btn-warning btn-bold" onclick="delSku(' + data.sku_id + ')">';
        html += '<i class="ace-icon fa fa-trash-o bigger-90 orange"></i>';
        html += '删除';
        html += '</button>';
        html += '</div>';
        html += '</div>';
        html += '</div>';
        html += '<div class="space-6" id="space' + data.sku_id + '"></div>';
        $("#skuContent").append(html);
    }


    function createBind() {
        $("#propbtn").click(function () {
            var html = "";
            html += '<div class="row propItem">';
            html += '<select name="sku_propname" class="skuSelect1 col-xs-5">';
            html += '<option value=""></option>';
            html += '</select>';
            html += '<select name="sku_propval" class="skuSelect2 col-xs-5">';
            html += '<option value=""></option>';
            html += '</select>';
            html += '<a href="javascript:void(0);" style="margin-left:10px;"><i class="ace-icon fa fa-trash-o bigger-120 orange"></i></a>';
            html += '<div class="space-6"></div>';
            html += '</div>';
            $("#propItems").append(html);
            bindPropSelect($("#propItems").find(".propItem:last").find(".skuSelect1"));
        });
    }

    //加载属性
    function bindPropSelect($this) {
        var dom = $this ? $this : $(".skuSelect1");
        console.log(dom);
        dom.select2({
            placeholder: "请选择属性名",
            data: propNameData,
            width: '45%'
        });
        //删除
        dom.parent().find("a").click(function () {
            $(this).parent().remove();
        });
        dom.each(function () {
            getPropValSelect2($(this), $(this).val(), true);
        });
        dom.on("change", function () {
            getPropValSelect2($(this), $(this).val());
        });
    }

    function getPropValSelect2($this, id, initflg) {
        var propNameData = [];
        myAjax("/base/getPropValByPropId", {prop_id: id}, function (res) {
            propNameData = res.data;
        });
        if (!initflg) {
            $this.parent().find(".skuSelect2").select2("destroy").empty();
        }
        $this.parent().find(".skuSelect2").select2({
            placeholder: "请选择对应属性值",
            data: propNameData,
            width: '45%'
        })
    }

    /**
     * 删除SKU
     * @param id
     */
    function delSku(id) {
        bootbox.confirm("确认删除该SKU？ 删除之后，将会立即生效。不可找回", function (res) {
            if (res) {
                //开始删除数据库
                myAjax("/business/delProdSku", {sku_id: id, pid: '${productsinfo.pid}'}, function (res) {
                    if (res.code == 1) {
                        $("#sku" + id).remove();
                        $("#space" + id).remove();
                        showSuccInfo("操作成功！");
                    } else {
                        showErrorInfo(res.message)
                    }
                })
            }
        })
    }

    //删除图片
    function delImg(parentid, id) {
        $("#" + parentid).hide();
        $('#' + id).ace_file_input({
            style: 'well',
            btn_choose: 'Drop files here or click to choose',
            btn_change: null,
            no_icon: 'ace-icon fa fa-cloud-upload',
            droppable: true,
            thumbnail: 'small',
            allowExt: ["jpeg", "jpg", "png", "gif", "bmp"],
            allowMime: ["image/jpg", "image/jpeg", "image/png", "image/gif", "image/bmp"],
            preview_error: function (filename, error_code) {
            }
        }).on('change', function () {
        });
    }

    $('.page-content-area').ace_ajax('loadScripts', scripts, function () {

        //加载商家
        $("select[name=mer_id]").select2({
            placeholder: "请选择商家名称检索",
            ajax: {
                url: projectUrl + '/base/getMerByKey',
                delay: 250,
                cache: true,
                data: function (params) {
                    console.log(params);
                    var query = {
                        key: params.term
                    };
                    return query;
                },
                processResults: function (data, params) {
                    return {
                        results: data.data
                    }
                }
            },
            width: '100%'
        });

        //获取url中的参数信息
        $(function () {
            $(document).on('settings.ace.chosen', function (e, event_name, event_val) {
                if (event_name != 'sidebar_collapsed') return;
                $('.chosen-select').each(function () {
                    var $this = $(this);
                    $this.next().css({'width': $this.parent().width()});
                })
            });

            $('[data-rel=popover]').popover({container: 'body'});

            //设置日期选择样式
            $('.date-picker').datepicker({
                autoclose: true,
                todayHighlight: true
            });

            //先设置信息，在设置选择框信息
            $('.chosen-select').chosen({allow_single_deselect: true});

        });

        if (!'${productsinfo.pid}') {
            $('input[type=file]').ace_file_input({
                style: 'well',
                btn_choose: 'Drop files here or click to choose',
                btn_change: null,
                no_icon: 'ace-icon fa fa-cloud-upload',
                droppable: true,
                thumbnail: 'small',
                allowExt: ["jpeg", "jpg", "png", "gif", "bmp"],
                allowMime: ["image/jpg", "image/jpeg", "image/png", "image/gif", "image/bmp"],
                preview_error: function (filename, error_code) {
                }
            }).on('change', function () {
            });
        }

        $("#validation-form-productsinfo").submit(function (e) {
            e.preventDefault();
            var flag = $("#validation-form-productsinfo").valid();
            var parData = $("#validation-form-productsinfo").serializeJson();
            console.log(parData)
            if (flag) {
                $(this).ajaxSubmit({
                    url: projectUrl + "/business/addOrUpdProd",
                    type: "post",
                    data: {serviceIds: parData.prodservice.join(",")},
                    beforeSubmit: function () {
                        var html = "";
                        html += '<div class="center blue"><i class="ace-icon fa fa-spinner fa-spin orange"></i>上传中...请耐心等待</div>'
                        html += '<div class="progress pos-rel" style="margin-top:20px;" data-percent="0%">';
                        html += '<div class="progress-bar" style="width:0%;"></div>';
                        html += '</div>';
                        bootbox.dialog({
                            message: html,
                            closeButton: null,
                        })
                    },
                    uploadProgress: function (event, position, total, percentComplete) {
                        $(".progress").attr("data-percent", percentComplete + "%");
                        $(".progress-bar").css("width", percentComplete + "%");
                    },
                    success: function (result) {
                        bootbox.hideAll();
                        if (result.code === 1) {
                            showInfo("操作成功! 即将返回主列表")
                            $("#user_save_info").hide();
                            setTimeout(function () {
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

        //表单校验
        $("#validation-form-productsinfo").validate({
            errorElement: 'div',
            errorClass: 'help-block',
            focusInvalid: false,
            ignore: ":hidden:not(select)",
            rules: {
                pname: {required: true},
                title: {required: true},
                desc: {required: true},
                homeimgFile: {required: true},
                paramimgFile: {required: true},
                shopprice: {required: true},
                // shopmmdprice: {required: true},
                inventory: {number: true, required: true},
                costprice: {number: true, required: true},
                categoryid: {required: true},
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
                }
                ;
            }
        });

        //加载商品类别
        myAjax("/base/getAllClassify", null, function (result) {
            var html = "<option></option>";
            result.data.forEach(function (data) {
                if ('${productsinfo.pid}' && data.id == '${productsinfo.categoryid}') {
                    html += '<option value="' + data.id + '" selected>' + data.name + '</option>';
                } else {
                    html += '<option value="' + data.id + '">' + data.name + '</option>';
                }
            })
            $("#categoryid").html(html);
        });

        $("#form-carousal").submit(function(e) {
            e.preventDefault();
            $(this).ajaxSubmit({
                url: projectUrl + "/business/addOrUpdCarousel",
                type: "post",
                beforeSubmit: function () {
                    var html = "";
                    html += '<div class="center blue"><i class="ace-icon fa fa-spinner fa-spin orange"></i>上传中...请耐心等待</div>'
                    html += '<div class="progress pos-rel" style="margin-top:20px;" data-percent="0%">';
                    html += '<div class="progress-bar" style="width:0%;"></div>';
                    html += '</div>';
                    bootbox.dialog({
                        message: html,
                        closeButton: null,
                    })
                },
                uploadProgress: function (event, position, total, percentComplete) {
                    $(".progress").attr("data-percent", percentComplete + "%");
                    $(".progress-bar").css("width", percentComplete + "%");
                },
                success: function (result) {
                    bootbox.hideAll();
                    if (result.code === 1) {
                        showInfo("操作成功! 即将返回主列表")
                        $("#user_save_info").hide();
                        setTimeout(function () {
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
        });


        imgFileFunction();

        //处理图片信息
        function imgFileFunction() {
            var $overflow = '';
            var colorbox_params = {
                rel: 'colorbox',
                reposition: true,
                scalePhotos: true,
                scrolling: false,
                // previous: '<i class="ace-icon fa fa-arrow-left"></i>',
                // next: '<i class="ace-icon fa fa-arrow-right"></i>',
                close: '&times;',
                // current: '{current} of {total}',
                maxWidth: '100%',
                maxHeight: '100%',
                onOpen: function () {
                    $overflow = document.body.style.overflow;
                    document.body.style.overflow = 'hidden';
                },
                onClosed: function () {
                    document.body.style.overflow = $overflow;
                },
                onComplete: function () {
                    $.colorbox.resize();
                }
            };

            $('.ace-thumbnails [data-rel="colorbox"]').colorbox(colorbox_params);
            $("#cboxLoadingGraphic").html("<i class='ace-icon fa fa-spinner orange fa-spin'></i>");//let's add a custom loading icon

            jQuery(function(){
                try {
                    var myDropzone = new Dropzone("#dropzone", {
                        url: projectUrl + "/business/uploadCarousel?pid="+'${productsinfo.pid}',
                        paramName: "carouselFile", // The name that will be used to transfer the file
                        maxFiles: 5,
                        dictMaxFilesExceeded: "只能上传{{maxFiles}}个文件",
                        dictResponseError: '上传出错!',
                        addRemoveLinks : true,
                        uploadMultiple: false,
                        dictDefaultMessage :
                            '<span class="bigger-150 bolder"><i class="ace-icon fa fa-caret-right red"></i> Drop files</span> to upload \
                            <span class="smaller-80 grey">(or click)</span> <br /> \
                            <i class="upload-icon ace-icon fa fa-cloud-upload blue fa-3x"></i>',
                        removedfile: function(file, nocallflg){ //自定义从列表删除元素时候执行的事件
                            var than = this;
                            if(file.accepted && !nocallflg) { //成功的元素
                                bootbox.confirm("确定要删除该轮播图，确定之后将会立即生效，并且不可找回", function(res) {
                                    if(res) {
                                        myAjax("/business/delCarousel", {filename:file.name, url:file.url, pid: '${productsinfo.pid}'}, function(res){
                                            if(res.code == 1) {
                                                showSuccInfo("操作成功！");
                                                var _ref;
                                                if (file.previewElement) {
                                                    if ((_ref = file.previewElement) != null) {
                                                        _ref.parentNode.removeChild(file.previewElement);
                                                    }
                                                }
                                                return than._updateMaxFilesReachedClass();
                                            }
                                        })
                                    }else{
                                        bootbox.hideAll();
                                    }
                                });
                            }else{
                                var _ref;
                                if (file.previewElement) {
                                    if ((_ref = file.previewElement) != null) {
                                        _ref.parentNode.removeChild(file.previewElement);
                                    }
                                }
                                return this._updateMaxFilesReachedClass();
                            }
                        },
                        init: function(){
                            var than = this;
                            if('${productsinfo}') {
                                myAjax("/business/getprodCarousal", {pid: '${productsinfo.pid}'}, function(res){
                                    if(res.data && res.data.length>0) {
                                        var urls = "";
                                        res.data.forEach(function(data){
                                            urls += "," + data.pdUrl;
                                        });
                                        than.emit("initimage", urls.substr(1));
                                    }
                                });
                            };
                            this.on("success", function(file, res) {
                                file.url = res.data;
                            })
                        },
                    });
                    $(document).one('ajaxloadstart.page', function (e) {
                        myDropzone.destroy();
                        $('#colorbox, #cboxOverlay').remove();
                    });

                } catch(e) {
                    console.log(e);
                    alert('Dropzone.js不支持你的浏览器，请更换其他浏览器尝试!');
                }
            });


            jQuery(function(){
                try {
                    var myDropzone2 = new Dropzone("#dropzone2", {
                        url: projectUrl + "/business/uploadDetailImg?pid="+'${productsinfo.pid}',
                        paramName: "detailimgFile", // The name that will be used to transfer the file
                        maxFiles: 10,
                        dictMaxFilesExceeded: "只能上传{{maxFiles}}个文件",
                        dictResponseError: '上传出错!',
                        addRemoveLinks : true,
                        uploadMultiple: false,
                        dictDefaultMessage :
                            '<span class="bigger-150 bolder"><i class="ace-icon fa fa-caret-right red"></i> Drop files</span> to upload \
                            <span class="smaller-80 grey">(or click)</span> <br /> \
                            <i class="upload-icon ace-icon fa fa-cloud-upload blue fa-3x"></i>',
                        removedfile: function(file, nocallflg){ //自定义从列表删除元素时候执行的事件
                            var than = this;
                            if(file.accepted && !nocallflg) { //成功的元素
                                bootbox.confirm("确定要删除该轮播图，确定之后将会立即生效，并且不可找回", function(res) {
                                    if(res) {
                                        myAjax("/business/delDetailimg", {filename:file.name, url:file.url, pid: '${productsinfo.pid}'}, function(res){
                                            if(res.code == 1) {
                                                showSuccInfo("操作成功！");
                                                var _ref;
                                                if (file.previewElement) {
                                                    if ((_ref = file.previewElement) != null) {
                                                        _ref.parentNode.removeChild(file.previewElement);
                                                    }
                                                }
                                                return than._updateMaxFilesReachedClass();
                                            }
                                        })
                                    }else{
                                        bootbox.hideAll();
                                    }
                                });
                            }else{
                                var _ref;
                                if (file.previewElement) {
                                    if ((_ref = file.previewElement) != null) {
                                        _ref.parentNode.removeChild(file.previewElement);
                                    }
                                }
                                return this._updateMaxFilesReachedClass();
                            }
                        },
                        init: function(){
                            var than = this;
                            if('${productsinfo}') {
                                myAjax("/business/getproddetailImg", {pid: '${productsinfo.pid}'}, function(res){
                                    if(res.data && res.data.length>0) {
                                        var urls = "";
                                        res.data.forEach(function(data){
                                            urls += "," + data.img;
                                        });
                                        than.emit("initimage", urls.substr(1));
                                    }
                                });
                            };
                            this.on("success", function(file, res) {
                                file.url = res.data;
                            })
                        },
                    });
                    
                    $(document).one('ajaxloadstart.page', function (e) {
                        myDropzone2.destroy();
                        $('#colorbox, #cboxOverlay').remove();
                    });
                } catch(e) {
                    console.log(e);
                    alert('Dropzone.js不支持你的浏览器，请更换其他浏览器尝试!');
                }
            })
        }
    });
</script>
</html>


