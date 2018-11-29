<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>员工维护详细 - 魔晶</title>
    <link rel="stylesheet" href="assets/css/select2.css"/>
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
                                <label class="control-label">用户<span class="red">*</span></label>
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
        "assets/js/jquery.form.js",
        "assets/js/select2.js",
        null];
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
