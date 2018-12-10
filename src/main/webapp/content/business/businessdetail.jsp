<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>商家维护 - 魔晶</title>
    <link rel="stylesheet" href="assets/css/chosen.css"/>
    <link rel="stylesheet" href="assets/css/bootstrap-datepicker3.css" />
    <link rel="stylesheet" href="assets/css/bootstrap-timepicker.css" />
    <link rel="stylesheet" href="assets/css/daterangepicker.css" />
    <link rel="stylesheet" href="assets/css/bootstrap-datetimepicker.css" />
    <link rel="stylesheet" href="assets/css/colorbox.css" />
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
        <form class="form-horizontal" id="validation-form-merchant" method="post">
            <input type="hidden" name="merId" value="${merchant.merId}">

            <div class="space-20"></div>

            <div class="widget-box">
                <div class="widget-header">
                    <h4 class="widget-title">商家信息</h4>
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
                                <label class="control-label" for="merName">店铺名称<span class="red">*</span></label>
                                <input class="form-control" id="merName" name="merName" value="${merchant.merName}">
                            </div>

                            <div class="col-xs-3  form-group">
                                <label class="control-label" for="merAddress">店铺地址<span class="red">*</span></label>
                                <input class="form-control" id="merAddress" name="merAddress" value="${merchant.merAddress}">
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-merchant-merShortname">中文简称<span class="red">*</span></label>
                                <input class="form-control" id="form-merchant-merShortname" type="text" name="merShortname"
                                       value="${merchant.merShortname}"/>
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-merchant-merEname">英文简称<span class="red">*</span></label>
                                <input id="form-merchant-merEname" class="form-control" name="merEname" value="${merchant.merEname}"/>
                            </div>

                        </div>

                        <div class="space-12"></div>

                        <div class="row">


                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-merchant-merWeixin">微信</label>
                                <input class="form-control" id="form-merchant-merWeixin" type="text" name="merWeixin"
                                       value="${merchant.merWeixin}"/>
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-merchant-merQq">QQ号</label>
                                <input id="form-merchant-merQq" class="form-control" name="merQq" value="${merchant.merQq}"/>
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-merchant-merLinkman">联系人<span class="red">*</span></label>
                                <input class="form-control" id="form-merchant-merLinkman" type="text" name="merLinkman"
                                       value="${merchant.merLinkman}"/>
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-merchant-merLinkphone">联系人电话<span class="red">*</span></label>
                                <input id="form-merchant-merLinkphone" class="form-control" name="merLinkphone" value="${merchant.merLinkphone}"/>
                            </div>
                        </div>

                        <div class="row">

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-merchant-hotval">热点度<span class="red">*</span><span class="help-button" data-rel="popover" data-trigger="hover" data-placement="right" data-content="热点度用于店铺展示排名，值为0-99，热点度越高，店铺展示越靠前"
                                                                                                                           title="" data-original-title="设置说明">?</span></label>
                                <input id="form-merchant-hotval" type="number" class="form-control" value="${(!empty merchant.hotval)?merchant.hotval:0}"
                                       name="hotval" placeholder="请输入0-99数值"/>
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-merchant-merDesc">店铺简介</label>
                                <textarea id="form-merchant-merDesc" class="form-control" value="${merchant.merDesc}"
                                          name="merDesc">${merchant.merDesc}</textarea>
                            </div>


                        </div>

                        <div class="space-12"></div>

                        <div class="row">
                            <div class="col-xs-3 form-group">
                                <label class="control-label">店铺LOGO<span class="red">*</span></label>
                                <c:if test="${empty merchant.merHomeicon}">
                                    <input type="file" id="mer_homeiconFile" name="mer_homeiconFile" accept="image/*"/>
                                    <ul class="ace-thumbnails clearfix" id="iconFile" style="display: none;">
                                        <li>
                                            <a href="${merchant.merHomeicon}" data-rel="colorbox">
                                                <img width="150" height="150" alt="150x150" src="${merchant.merHomeicon}" />
                                                <div class="text">
                                                    <div class="inner">点击查看详细</div>
                                                </div>
                                            </a>
                                            <div class="tools tools-bottom">
                                                <a href="#" onclick="">
                                                    <i class="ace-icon fa fa-pencil" title="重新上传" onclick="delImg('iconFile', 'mer_homeiconFile')"></i>
                                                </a>
                                            </div>
                                        </li>
                                    </ul>
                                </c:if>
                                <c:if test="${!empty merchant.merHomeicon}">
                                    <input type="file" id="mer_homeiconFile" name="mer_homeiconFile" style="display: none;"/>
                                    <ul class="ace-thumbnails clearfix" id="iconFile">
                                        <li>
                                            <a href="${merchant.merHomeicon}" data-rel="colorbox">
                                                <img width="150" height="150" alt="150x150" src="${merchant.merHomeicon}" />
                                                <div class="text">
                                                    <div class="inner">点击查看详细</div>
                                                </div>
                                            </a>
                                            <div class="tools tools-bottom">
                                                <a href="#" onclick="">
                                                    <i class="ace-icon fa fa-pencil" title="重新上传" onclick="delImg('iconFile', 'mer_homeiconFile')"></i>
                                                </a>
                                            </div>
                                        </li>
                                    </ul>
                                </c:if>

                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label">店铺展示照片(请上传高宽比为690*320的图片)<span class="red">*</span></label>
                                <c:if test="${empty merchant.merHomeimg}">
                                    <input multiple="" type="file" id="mer_homeimgFile" name="mer_homeimgFile" accept="image/*"/>
                                    <ul class="ace-thumbnails clearfix" id="imgFile" style="display: none;">
                                        <li>
                                            <a href="${merchant.merHomeimg}" data-rel="colorbox">
                                                <img width="230" height="106" alt="150x150" src="${merchant.merHomeimg}" />
                                                <div class="text">
                                                    <div class="inner">点击查看详细</div>
                                                </div>
                                            </a>
                                            <div class="tools tools-bottom">
                                                <a href="#" onclick="">
                                                    <i class="ace-icon fa fa-pencil" title="重新上传" onclick="delImg('imgFile', 'mer_homeimgFile')"></i>
                                                </a>
                                            </div>
                                        </li>
                                    </ul>
                                </c:if>
                                <c:if test="${!empty merchant.merHomeimg}">
                                    <input multiple="" type="file" id="mer_homeimgFile" name="mer_homeimgFile" style="display: none;" accept="image/*"/>
                                    <ul class="ace-thumbnails clearfix" id="imgFile" >
                                        <li>
                                            <a href="${merchant.merHomeimg}" data-rel="colorbox">
                                                <img width="230" height="106" alt="150x150" src="${merchant.merHomeimg}" />
                                                <div class="text">
                                                    <div class="inner">点击查看详细</div>
                                                </div>
                                            </a>
                                            <div class="tools tools-bottom">
                                                <a href="#" onclick="">
                                                    <i class="ace-icon fa fa-pencil" title="重新上传" onclick="delImg('imgFile', 'mer_homeimgFile')"></i>
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
            <div class="row" id="user_save_info">
                <div class="col-xs-4 col-xs-offset-5">
                    <input type="submit" class="btn btn-primary" id="user_save" value="保存">
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

    //删除图片
    function delImg(parentid, id) {
        $("#"+parentid).hide();
        $('#'+id).ace_file_input({
            style: 'well',
            btn_choose: 'Drop files here or click to choose',
            btn_change: null,
            no_icon: 'ace-icon fa fa-cloud-upload',
            droppable: true,
            thumbnail: 'small',
            allowExt: ["jpeg", "jpg", "png", "gif" , "bmp"],
            allowMime: ["image/jpg", "image/jpeg", "image/png", "image/gif", "image/bmp"],
            preview_error : function(filename, error_code) {
            }
        }).on('change', function(){
        });
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

            //判断显示情况

            if('${merchant.merHomeicon}') {
                //如果有logo，那么就显示照片。否则不显示
                $("#mer_homeiconFile").hide();
                $("#iconFile").show();
            }else{
                $("#mer_homeiconFile").show();
                $("#iconFile").hide();
            }
            if('${merchant.merHomeimg}') {
                //如果有logo，那么就显示照片。否则不显示
                $("#mer_homeimgFile").hide();
                $("#imgFile").show();
            }else{
                $("#mer_homeimgFile").show();
                $("#imgFile").hide();
            }

        });

        if(!'${merchant.merId}') {
            $('input[type=file]').ace_file_input({
                style: 'well',
                btn_choose: 'Drop files here or click to choose',
                btn_change: null,
                no_icon: 'ace-icon fa fa-cloud-upload',
                droppable: true,
                thumbnail: 'small',
                allowExt: ["jpeg", "jpg", "png", "gif" , "bmp"],
                allowMime: ["image/jpg", "image/jpeg", "image/png", "image/gif", "image/bmp"],
                preview_error : function(filename, error_code) {
                }
            }).on('change', function(){
            });
        }





        $("#validation-form-merchant").submit(function (e) {
            e.preventDefault();
            var flag = $("#validation-form-merchant").valid();
            if (flag) {
                $(this).ajaxSubmit({
                    url: projectUrl + "/business/addOrUpdBusiness",
                    type: "post",
                    beforeSubmit: function() {
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
                        $(".progress").attr("data-percent", percentComplete+"%");
                        $(".progress-bar").css("width", percentComplete+"%");
                    },
                    success: function (result) {
                        bootbox.hideAll();
                        if (result.code === 1) {
                            showInfo("操作成功! 即将返回主列表")
                            $("#user_save_info").hide();
                            setTimeout(function(){
                                history.back();
                            }, 4000);
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

        //表单校验
        $("#validation-form-merchant").validate({
            errorElement: 'div',
            errorClass: 'help-block',
            focusInvalid: false,
            ignore: ":hidden:not(select)",
            rules: {
                merName: {required: true},
                merAddress: {required: true},
                merLinkman: {required:true},
                merLinkphone: {number: true,required: true},
                merEname: {required: true},
                merShortname: {required: true},
                hotval: {required: true, number: true, max: 99}
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

            $(document).one('ajaxloadstart.page', function (e) {
                $('#colorbox, #cboxOverlay').remove();
            });
        }
    });
</script>
</html>


