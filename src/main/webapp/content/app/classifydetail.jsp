<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工维护详细 - 魔晶</title>
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
        <form class="form-horizontal" id="validation-form-class" method="post">
            <input type="hidden" name="dict_id" value="${classify.dict_id}">
            <input type="hidden" name="data_code" value="${classify.dict_code}">
            <div class="space-20"></div>
            <div class="widget-box">
                <div class="widget-header">
                    <h4 class="widget-title">首页分类</h4>
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
                                <label class="control-label">分类名称<span class="red">*</span></label>
                                <input class="form-control" name="data_name" value="${classify.data_name}">
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

<script>
    var scripts = [null,
        "assets/js/jquery.form.js",
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


            $("#validation-form-class").submit(function (e) {
                e.preventDefault();
                var flag = $("#validation-form-class").valid();
                if (flag) {
                    $(this).ajaxSubmit({
                        url: projectUrl + "/app/addOrUpdClassify",
                        type: "post",
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
        })
    })
</script>
</body>
</html>
