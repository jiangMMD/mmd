<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>员工维护详细 - 魔晶</title>
    <link rel="stylesheet" href="assets/css/select2.css"/>
<<<<<<< HEAD
=======
    <link rel="stylesheet" href="assets/css/chosen.css"/>
    <link rel="stylesheet" href="assets/css/bootstrap-datepicker3.css" />
    <link rel="stylesheet" href="assets/css/bootstrap-timepicker.css" />
    <link rel="stylesheet" href="assets/css/daterangepicker.css" />
    <link rel="stylesheet" href="assets/css/bootstrap-datetimepicker.css" />
    <link rel="stylesheet" href="assets/css/colorbox.css" />
>>>>>>> origin/master
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
        <form class="form-horizontal" id="validation-form-class" method="post">
            <input type="hidden" name="id" value="${message.id}">
            <div class="space-20"></div>
            <div class="widget-box">
                <div class="widget-header">
                    <h4 class="widget-title">新增消息</h4>
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
                                <label class="control-label">消息类型<span class="red">*</span></label>
                                <select id="type" name="type" class="chosen-select form-control"
                                        data-placeholder="选择消息类型...">
                                    <option value="0"></option>
                                    <option value="1">系统通知</option>
                                    <option value="2">个人消息</option>
                                </select>
                            </div>

                            <div id="userTypeId" class="col-xs-3 form-group">
<<<<<<< HEAD
                                <label class="control-label">用户<span class="red">*</span></label>
=======
                                <label class="control-label">用户<span class="red">*</span><span class="help-button" data-rel="popover" data-trigger="hover" data-placement="right" data-content="个人消息可不选择用户，作为发送给所有用户的个人消息。"
                                                                                               title="" data-original-title="设置说明">?</span></label>
>>>>>>> origin/master
                                <select class="form-control" id="userId" name="userId"></select>
                            </div>


                            <div class="col-xs-3 form-group">
                                <label class="control-label">消息主题<span class="red">*</span></label>
                                <input class="form-control" name="title" value="${message.title}">
                            </div>
                            <div class="col-xs-3 form-group">
                                <label class="control-label">消息内容<span class="red">*</span></label>
                                <input class="form-control" name="content" value="${message.content}">
                            </div>
                        </div>
<<<<<<< HEAD
=======
                        <div class="row">
                            <div class="col-xs-3 form-group">
                                <label class="control-label">内容图片<span class="red">*</span></label>
                                <c:if test="${empty message.picUrl}">
                                    <input type="file" id="picUrlFile" name="picUrlFile" accept="image/*"/>
                                    <ul class="ace-thumbnails clearfix" id="iconFile" style="display: none;">
                                        <li>
                                            <a href="${message.picUrl}" data-rel="colorbox">
                                                <img width="150" height="150" alt="150x150" src="${message.picUrl}" />
                                                <div class="text">
                                                    <div class="inner">点击查看详细</div>
                                                </div>
                                            </a>
                                            <div class="tools tools-bottom">
                                                <a href="#" onclick="">
                                                    <i class="ace-icon fa fa-pencil" title="重新上传" onclick="delImg('iconFile', 'picUrlFile')"></i>
                                                </a>
                                            </div>
                                        </li>
                                    </ul>
                                </c:if>
                                <c:if test="${!empty message.picUrl}">
                                    <input type="file" id="picUrlFile" name="picUrlFile" style="display: none;"/>
                                    <ul class="ace-thumbnails clearfix" id="iconFile">
                                        <li>
                                            <a href="${message.picUrl}" data-rel="colorbox">
                                                <img width="150" height="150" alt="150x150" src="${message.picUrl}" />
                                                <div class="text">
                                                    <div class="inner">点击查看详细</div>
                                                </div>
                                            </a>
                                            <div class="tools tools-bottom">
                                                <a href="#" onclick="">
                                                    <i class="ace-icon fa fa-pencil" title="重新上传" onclick="delImg('iconFile', 'picUrlFile')"></i>
                                                </a>
                                            </div>
                                        </li>
                                    </ul>
                                </c:if>

                            </div>
                        </div>
>>>>>>> origin/master
                    </div>
                </div>
            </div>

            <div class="space-12"></div>
            <div class="row" id="message_save_info">
                <div class="col-xs-4 col-xs-offset-5">
                    <input type="submit" class="btn btn-primary" id="message_save" value="发布">
                    <input type="reset" class="btn" style="margin-left: 20px;" onclick="resetForm()" value="重置表单">
                </div>
            </div>
        </form>
    </div>
</div>

<script>
    var scripts = [null,
<<<<<<< HEAD
        "assets/js/jquery.form.js",
        "assets/js/select2.js",
        null];
=======
        "assets/js/select2.js",
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

    //判断显示情况

    if('${message.picUrl}') {
        //如果有logo，那么就显示照片。否则不显示
        $("#picUrlFile").hide();
        $("#iconFile").show();
    }else{
        $("#picUrlFile").show();
        $("#iconFile").hide();
    }

>>>>>>> origin/master
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
<<<<<<< HEAD
=======

            $('[data-rel=popover]').popover({container:'body'});


>>>>>>> origin/master
            $("#userId").select2({
                ajax: {
                    url: projectUrl + '/user/getUserByKey',
                    delay: 250,
                    cache: true,
                    data: function (params) {
                        console.log(params);
                        var query = {
                            key: params
                        };
                        return query;
                    },
                    processResults: function (data, params) {
                        console.log(data);
                        return {
                            results: data.result
                        }
                    }

                },
                allowClear: true,
                placeholder: '输入姓名、手机号、昵称查询',
            });

            $("#validation-form-class").submit(function (e) {
                e.preventDefault();
                var flag = $("#validation-form-class").valid();
                if (flag) {
                    $(this).ajaxSubmit({
                        url: projectUrl + "/app/addMessage",
                        type: "post",
<<<<<<< HEAD
=======
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
>>>>>>> origin/master
                        success: function (result) {
                            bootbox.hideAll();
                            if (result.code === 1) {
                                showInfo("操作成功! 即将返回主列表")
                                $("#message_save_info").hide();
                                setTimeout(function(){
                                    history.back();
                                }, 4000);
                            } else {
                                showError("操作失败！错误信息：" + result.message);
                            }
                        },
                        error: function (err) {
                            bootbox.hideAll();
                            showErrorInfo("发布失败，" + err.statusText);
                        }
                    });
                }
                return false;
            });
        })
    })
    $(document).ready(function () {
        $("#type").change(function () {
            Selectchange();
        })
        function Selectchange() {
            var selectValue = $("#type").val();
            if(selectValue == 1) {
                $("#userTypeId").hide();
            }else{
                $("#userTypeId").show();
            }
            // alert(selectValue);
        }
        
    })
</script>
</body>
</html>
