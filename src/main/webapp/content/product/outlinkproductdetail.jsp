<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>IMEI外部链接详细 - 笑享租</title>
    <link rel="stylesheet" href="/erp/assets/css/chosen.css"/>
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
        <form class="form-horizontal" id="validation-form-iemi" method="post">
            <input type="hidden" name="lid" value="${outProduct.lid}">
            <input type="hidden" name="cid" value="${outProduct.cid}">
            <div class="widget-box">
                <div class="widget-header">
                    <h4 class="widget-title">外部申请产品</h4>
                    <div class="widget-toolbar">
                        <a href="#" data-action="collapse">
                            <i class="ace-icon fa fa-chevron-up"></i>
                        </a>
                    </div>
                </div>
                <div class="widget-body">
                    <div class="widget-main" style="min-height: 200px;">
                        <div class="row">
                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="outproduct_custom_name">申请客户</label>
                                <input readonly class="form-control" id="outproduct_custom_name" name="custom_name" value="${outProduct.custom_name}" />
                            </div>
                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="outproduct_state">状态</label>
                                <select readonly class="form-control" name="state" id="outproduct_state">
                                    <option value="">审核中</option>
                                    <option value="1">已通过</option>
                                    <option value="2">已拒绝</option>
                                </select>
                            </div>
                            <div class="col-xs-6 form-group">
                                <label class="control-label" for="outproduct_link">产品链接</label>
                                <input readonly class="form-control" id="outproduct_link" name="link" value="${outProduct.link}" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="space-20"></div>

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
                        <div class="row">
                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="outproduct_state">商品名<span class="red">*</span></label>
                                <input class="form-control" id="outproduct_product_name" name="product_name" value="${outProduct.product_name}" />
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="outproduct_storage">内存<span class="red">*</span></label>
                                <input class="form-control" id="outproduct_storage" name="storage" value="${outProduct.storage}" />
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="outproduct_color">颜色<span class="red">*</span></label>
                                <input class="form-control" id="outproduct_color" name="color" value="${outProduct.color}" />
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="outproduct_price">产品签约价<span class="red">*</span></label>
                                <input class="form-control" id="outproduct_price" name="product_signprice" value="${outProduct.product_signprice}" />
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="outproduct_product_lease">期数<span class="red">*</span></label>
                                <input class="form-control" id="outproduct_product_lease" name="product_lease" value="${outProduct.product_lease}" />
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="outproduct_eachprice">每期价格<span class="red">*</span></label>
                                <input class="form-control" id="outproduct_eachprice" name="product_eachprice" value="${outProduct.product_eachprice}" />
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="outproduct_imei">IMEI号<span class="red">*</span></label>
                                <input class="form-control" id="outproduct_imei" name="product_imei" value="${outProduct.product_imei}" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="space-12"></div>
            <div class="row" id="outProduct_save">
                <div class="col-xs-4 col-xs-offset-5">
                    <c:if test="${empty outProduct.msgid}">
                        <button type="button" class="btn btn-info" onclick="passAudit()">审核通过</button>
                        <button type="button" class="btn btn-danger" onclick="unpassAudit()">审核拒绝</button>
                    </c:if>
                    <c:if test="${not empty outProduct.msgid}">
                        <span class="grey">该产品已审核过，不可修改，如需修改请联系管理员</span>
                    </c:if>
                </div>
            </div>
        </form>
    </div>
</div>
</body>

<script>
    var scripts = [null, "/erp/assets/js/date-time/bootstrap-datepicker.js",
        "/erp/assets/js/chosen.jquery.js",
        "/erp/assets/js/jquery.form.js",
        "/erp/assets/js/jquery.validate.js",
        "/erp/assets/js/jquery.validate_zh.js",
        null]

    function resetForm() {
        $(".chosen-select").val('').trigger("chosen:updated");
    }

    function passAudit() {
        bootbox.confirm("确认审核通过？通过之后，客户将可以直接申请该产品", function(res) {
            if(res) {
                $("form").submit();
            }
        });
    }

    function unpassAudit() {
        bootbox.dialog({
            title: "审核拒绝",
            message: "<input id='unpass_reason'  class='form-control' placeholder='请输入拒绝原因？'/>",
            buttons: {
                ok: {
                    callback: function () {
                        var unpass_reason = $("#unpass_reason").val();
                        if (!unpass_reason) {
                            showWarnInfo("请输入拒绝原因", 2000);
                            return false;
                        }
                        myAjax("/product/unPassAuditOutPorduct", {
                            lid: $("input[name=lid]").val(), cid: $("input[name=cid]").val(),
                            link: $("input[name=link]").val(), unpass_reason: unpass_reason
                        }, function (result) {
                            if (result.code === 1) {
                                if (result.message) {
                                    showInfo(result.message);
                                } else {
                                    showSuccInfo("操作成功");
                                    $("#outProduct_save").hide();
                                }
                            } else {
                                showErrorInfo(result.message);
                            }
                        })
                    }
                }
            }
        })
    }

    $('.page-content-area').ace_ajax('loadScripts', scripts, function () {
        $(function(){
            $("#validation-form-iemi").submit(function (e) {
                e.preventDefault();
                var flag = $("#validation-form-iemi").valid();
                if (flag) {
                    $(this).ajaxSubmit({
                        url: projectUrl + "/product/passAuditOutProduct",
                        type: "post",
                        success: function (result) {
                            bootbox.hideAll();
                            if (result.code === 1) {
                                showSuccInfo("操作成功");
                                $("#outProduct_save").hide();
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


            jQuery.validator.addMethod("iemi", function (value, element) {
                return this.optional(element) || /^[0-9a-zA-Z,]+$/.test(value);
            }, "请输入有效IMEI，只能输入字母数字和英文逗号");

            $("#validation-form-iemi").validate({
                errorElement: 'div',
                errorClass: 'help-block',
                focusInvalid: false,
                ignore: ":hidden:not(select)",
                rules: {
                    product_name: {required: true},
                    product_imei: {required: true},
                    product_signprice: {required: true, number: true},
                    product_eachprice: {required: true, number: true},
                    storage: {required: true},
                    color: {required: true},
                    product_lease: {required: true, number:true},
                },
                highlight: function (e) {
                    $(e).closest('.form-group').removeClass('has-info').addClass('has-error');
                },
                success: function (e) {
                    $(e).closest('.form-group').removeClass('has-error');//.addClass('has-info');
                    $(e).remove();
                    // $(e).remove().addBack({
                    //     errorPlacement: function(error, element){
                    //         console.log(element.is['input[type=checkbo'])
                    //     }
                    // })
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
                },
            });
        });

        $(document).on('settings.ace.chosen', function (e, event_name, event_val) {
            if (event_name != 'sidebar_collapsed') return;
            $('.chosen-select').each(function () {
                var $this = $(this);
                $this.next().css({'width': $this.parent().width()});
            })
        });
    });
</script>
</html>
