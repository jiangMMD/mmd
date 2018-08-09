<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>产品出货详细单 - 笑享租</title>
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
            <input type="hidden" name="id" value="${iemi_turnover.id}">
            <div class="space-20"></div>
            <div class="widget-box">
                <div class="widget-header">
                    <h4 class="widget-title">出货单信息</h4>
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
                                <label class="control-label" for="product_name">商品名<span class="red">*</span></label>
                                <input class="form-control" id="product_name" name="product_name" value="${empty iemi_turnover.product_name ? "iphoneX" : iemi_turnover.product_name}">
                            </div>

                            <div class="col-xs-3  form-group">
                                <label class="control-label" for="agency_id">代理商（手机入库）<span class="red">*</span></label>
                                <select id="agency_id" name="agency_id"  class="form-control chosen-select"></select>
                            </div>
                        </div>

                        <div class="space-12"></div>

                        <div class="row">
                            <div class="col-xs-6 form-group">
                                <label class="control-label" for="imei_nos">IMEI号<span class="red">*</span></label>
                                <select id="imei_nos" name="imei_nos" multiple="multiple" class="form-control chosen-select" data-placeholder="选择本次出库的IMEI号">
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="space-12"></div>
            <div class="row" id="imei_save">
                <div class="col-xs-4 col-xs-offset-5">
                    <input type="submit" class="btn btn-primary">
                    <input class="btn" type="reset" style="margin-left: 20px;" onclick="resetForm()" value="重置表单" />
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

    $('.page-content-area').ace_ajax('loadScripts', scripts, function () {
        $(function(){

            $("#validation-form-iemi").submit(function (e) {
                e.preventDefault();
                var flag = $("#validation-form-iemi").valid();
                if (flag) {
                    $(this).ajaxSubmit({
                        url: projectUrl + "/book/saveImeiInfo",
                        type: "post",
                        success: function (result) {
                            bootbox.hideAll();
                            if (result.code === 1) {
                                $("#imei_save").hide();
                                showInfo("操作成功! 即将返回主列表", 3000);
                                setTimeout(function(){
                                    history.back();
                                }, 3000);
                            } else {
                                showError("操作失败！错误信息：" + result.message);
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


            $("#validation-form-iemi").validate({
                errorElement: 'div',
                errorClass: 'help-block',
                focusInvalid: false,
                ignore: ":hidden:not(select)",
                rules: {
                    product_name: {required: true},
                    agency_id: {required: true},
                    imei_nos: {required: true},
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

            //查询尚未出库的mei 号
            $("#imei_nos").chosen({allow_single_deselect: true});
            myAjax("/base/getAllImeiWithHas", {id:'${iemi_turnover.id}'}, function (result) {
                if (result.code == 1) {
                    //设置选择框中信息
                    createImeiSelect(result.data);
                } else {
                    showErrorInfo(result.message);
                }
            });
            function createImeiSelect(data) {
                var html = '<option value="">&nbsp;</option>';
                data.forEach(function (info) {
                    var imei_nos =  '${iemi_turnover.imei_nos}';
                    var noArr = imei_nos.split(",");
                    var flag = false;
                    for (var i=0 ; i<noArr.length; i++) {
                        if(noArr[i] == info.imei_no) {
                            flag = true;
                            break;
                        }
                    }
                    if(flag) {
                        html += '<option selected value="' + info.imei_no + '">' + info.imei_no + '</option>';
                    }else{
                        html += '<option value="' + info.imei_no + '">' + info.imei_no + '</option>';
                    }
                });
                $("#imei_nos").html(html);
                $("#imei_nos").trigger("chosen:updated");
            }

            /**
             * 设置选择框
             */
            $("#agency_id").chosen({allow_single_deselect: true});
            var depObj = [];
            var allDep = "";
            myAjax("/base/getAllAgency", null, function (result) {
                if (result.code == 1) {
                    depObj = result.data;
                    allDep = toSelectData(result.data, "aid", "aname");
                    //设置选择框中信息
                    createDepSelect(result.data);
                } else {
                    showErrorInfo(result.message);
                }
            });
            function createDepSelect(data) {
                var html = '<option value="">&nbsp;</option>';
                data.forEach(function (info) {
                    var agency_id =  '${iemi_turnover.agency_id}';
                    if(info.aid == agency_id) {
                        html += '<option selected value="' + info.aid + '">' + info.aname + '</option>';
                    }else{
                        html += '<option value="' + info.aid + '">' + info.aname + '</option>';
                    }
                });
                $("#agency_id").html(html);
                $("#agency_id").trigger("chosen:updated");
            }
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
