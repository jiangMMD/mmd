<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/erp/assets/css/chosen.css" />
    <link rel="stylesheet" href="/erp/assets/css/select2.css"/>
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
        <button class="btn btn-default btn-sm" onclick="history.back()">
            <i class="ace-icon fa fa-arrow-left"></i>
            返回
        </button>
    </h5>
</div>

<div class="row">
    <div class="col-xs-12">
        <form class="form-horizontal" id="validation-form-agency" method="post" enctype="multipart/form-data">
            <input type="hidden" name="aid" value="${agency.aid}">
            <div class="widget-box">
                <div class="widget-header">
                    <h4 class="widget-title">代理商信息</h4>
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
                                <label class="control-label" for="form-agency-anick">昵称<span
                                        class="red">*</span></label>
                                <input class="form-control" id="form-agency-anick" name="anick" value="${agency.anick}"
                                       placeholder="请输入代理商昵称">
                            </div>

                            <div class="col-xs-3  form-group">
                                <label for="form-agency-alogin_no">登录名<span class="red">*</span></label>
                                <input class="form-control" id="form-agency-alogin_no" name="alogin_no"
                                       value="${agency.alogin_no}"
                                       placeholder="请输入代理商登录名">
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-agency-alogin_password_source">登录密码<span
                                        class="red">*</span></label>
                                <input class="form-control" id="form-agency-alogin_password_source"
                                       name="alogin_password_source" value="${agency.alogin_password_source}"
                                       placeholder="请输入代理商登录密码"/>
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-agency-ano">代理商编号<span class="red">*</span></label>
                                <input class="form-control" id="form-agency-ano" name="ano" value="${agency.ano}"
                                       placeholder="请输入代理商公司名"/>
                            </div>

                        </div>

                        <div class="space-12"></div>

                        <div class="row">
                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-agency-aprefix">代理商前缀（订单号前缀）</label>
                                <input class="form-control" id="form-agency-aprefix" name="aprefix" value="${agency.aprefix}"
                                       placeholder="请输入代理商公司名"/>
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-agency-aname">代理商公司名</label>
                                <input class="form-control" id="form-agency-aname" name="aname" value="${agency.aname}"
                                       placeholder="请输入代理商公司名"/>
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-agency-alinkname">联系人名称</label>
                                <input class="form-control" id="form-agency-alinkname" name="alinkname"
                                       value="${agency.alinkname}"
                                       placeholder="请输入联系人名称"/>
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-agency-male">联系人性别</label>
                                <select class="form-control" id="form-agency-male" name="male">
                                    <option value="男">男</option>
                                    <option value="女">女</option>
                                </select>
                            </div>

                        </div>

                        <div class="space-12"></div>

                        <div class="row">

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-agency-alinkphone">联系人电话</label>
                                <input class="form-control" id="form-agency-alinkphone" name="alinkphone"
                                       value="${agency.alinkphone}"
                                       placeholder="请输入联系人电话"/>
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-agency-alinkweixin">联系人微信</label>
                                <input class="form-control" id="form-agency-alinkweixin" name="alinkweixin"
                                       value="${agency.alinkweixin}"
                                       placeholder="请输入联系人微信"/>
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-agency-alinkqq">联系人QQ</label>
                                <input class="form-control" id="form-agency-alinkqq" name="alinkqq"
                                       value="${agency.alinkqq}"
                                       placeholder="请输入联系人微信"/>
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-agency-legal">公司法人</label>
                                <input class="form-control" id="form-agency-legal" name="legal" value="${agency.legal}"
                                       placeholder="请输入公司法人名称"/>
                            </div>


                        </div>

                        <div class="space-12"></div>

                        <div class="row">
                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-agency-agency_city">代理城市<span class="red">*</span></label>
                                <%--<input class="form-control" id="form-agency-agency_city" name="agency_city"--%>
                                <%--value="${agency.agency_city}"--%>
                                <%--placeholder="请输入公司法人名称"/>--%>
                                <select id="form-agency-agency_city" name="agency_city" class="chosen-select form-control" data-placeholder="选择部门...">

                                </select>
                            </div>

                            <div class="col-xs-6 form-group">
                                <label class="control-label" for="form-agency-address">公司地址</label>
                                <input class="form-control" id="form-agency-address" name="address"
                                       value="${agency.address}"
                                       placeholder="请输入公司法人名称"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="space-20"></div>

            <div class="widget-box">
                <div class="widget-header">
                    <h4 class="widget-title">附件信息</h4>
                    <div class="widget-toolbar">
                        <a href="#" data-action="collapse">
                            <i class="ace-icon fa fa-chevron-up"></i>
                        </a>
                    </div>
                </div>
                <div class="widget-body" id="book_must_adjunct">
                    <div class="widget-main" style="min-height: 200px;">
                        <div class="row">
                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-agency-business">营业执照</label>
                                <input type="file" data-rule-required="true" id="form-agency-business"
                                       name="businessfile"/>
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-agency-contract">合同</label>
                                <input type="file" id="form-agency-contract" name="contractfile"/>
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-agency-otherdata">其他附件</label>
                                <input type="file" id="form-agency-otherdata" name="otherdatafile"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="space-12"></div>
            <div class="row">
                <div class="col-xs-4 col-xs-offset-5">
                    <input type="submit" class="btn btn-primary" id="agency_save">
                    <input class="btn" type="reset" style="margin-left: 20px;" onclick="resetForm()" value="重置表单"></input>
                </div>
            </div>
        </form>
    </div>
</div>

<script>
    var scripts = [null, "/erp/assets/js/jquery-ui.custom.js",
        "/erp/assets/js/date-time/bootstrap-datepicker.js",
        "/erp/assets/js/date-time/bootstrap-timepicker.js",
        "/erp/assets/js/date-time/daterangepicker.js",
        "/erp/assets/js/jquery.colorbox.js",
        "/erp/assets/js/jquery.validate.js",
        "/erp/assets/js/jquery.validate_zh.js",
        "/erp/assets/js/jquery.form.js",
        "/erp/assets/js/bootbox.js",
        "/erp/assets/js/chosen.jquery.js",
        "/erp/assets/js/date-time/bootstrap-datetimepicker.js", null];

    function resetForm() {
        $(".chosen-select").val('').trigger("chosen:updated");
    }

    function openFile(url) {
        var project = window.location.origin;
        window.open(project + "/nginxAgencyAccesstory/" + url);
    }

    $('.page-content-area').ace_ajax('loadScripts', scripts, function () {
        if('${agency}') {
            $("#form-agency-male").val('${agency.male}');
            if ('${agency.business}') {
                $('#form-agency-business').hide();
                var business = '${agency.business}';
                $('#form-agency-business').after('<a onclick="openFile(\''+business+'\')" class="blue2" style="display:block; cursor: pointer">文件已上传，点击查看</a>');
            } else {
                $('#form-agency-business').hide();
                $('#form-agency-business').after("<a class='grey' style='display:block;'>该项没有文件</a>");
            }

            if('${agency.contract}') {
                $('#form-agency-contract').hide();
                var contract = '${agency.contract}';
                $('#form-agency-contract').after('<a onclick="openFile(\''+contract+'\')" class="blue2" style="display:block; cursor: pointer">文件已上传，点击查看</a>');
            }else{
                $('#form-agency-contract').hide();
                $('#form-agency-contract').after("<a class='grey' style='display:block;'>该项没有文件</a>");
            }

            if('${agency.otherdata}') {
                $('#form-agency-otherdata').hide();
                var otherdata = '${agency.otherdata}';
                $('#form-agency-otherdata').after('<a onclick="openFile(\''+otherdata+'\')" class="blue2" style="display:block; cursor: pointer">文件已上传，点击查看</a>');
            }else{
                $('#form-agency-otherdata').hide();
                $('#form-agency-otherdata').after("<a class='grey' style='display:block;'>该项没有文件</a>");
            }

            $("#book_must_adjunct").find("a").after('<a class="orange reloadbookaccestory" style="cursor: pointer">重新上传</a>');

            $(".reloadbookaccestory").on("click", function(){
                $(this).parent().find("a").hide();
                $(this).hide();
                $(this).parent().find("input[type=file]").show();
                $(this).parent().find("input[type=file]").ace_file_input({
                    no_file: '选择文件...',
                    btn_choose: 'Choose',
                    btn_change: 'Change',
                    droppable: true,
                    onchange: null,
                    thumbnail: false
                });
            })
        }else{

            //合同
            $('#form-agency-business').ace_file_input({
                no_file: '选择文件...',
                btn_choose: 'Choose',
                btn_change: 'Change',
                droppable: true,
                onchange: null,
                thumbnail: false
            });
            //其他资料
            $('#form-agency-otherdata').ace_file_input({
                no_file: '选择文件...',
                btn_choose: 'Choose',
                btn_change: 'Change',
                droppable: true,
                onchange: null,
                thumbnail: false
            });
        }

        $("#validation-form-agency").validate({
            errorElement: 'div',
            errorClass: 'help-block',
            focusInvalid: false,
            ignore: ":hidden:not(select)",
            rules: {
                anick: {required: true},
                alogin_no: {required: true},
                alogin_password_source: {required: true},
                ano: {required: true},
                agency_city: {required: true},
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

        $("#validation-form-agency").submit(function (e) {
            e.preventDefault();
            var flag = $("#validation-form-agency").valid();
            if (flag) {
                $(this).ajaxSubmit({
                    url: projectUrl + "/agency/saveAgencyInfo",
                    type: "post",
                    uploadProgress: function (event, position, total, percentComplete) {
                        var html = "";
                        html += '<div class="center blue"><i class="ace-icon fa fa-spinner fa-spin orange"></i>上传中...请耐心等待</div>'
                        html += '<div class="progress pos-rel" style="margin-top:20px;" data-percent="' + percentComplete + '%">';
                        html += '<div class="progress-bar" style="width:' + percentComplete + '%;"></div>';
                        html += '</div>';
                        bootbox.dialog({
                            message: html,
                            closeButton: null,
                        })
                    },
                    success: function (result) {
                        bootbox.hideAll();
                        if (result.code === 1) {
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


        /**
         * 设置选择框
         */
        $("#form-agency-agency_city").chosen({allow_single_deselect:true});
        var depObj = [];
        var allDep = "";
        myAjax("/base/getAllCity", null, function(result){
            if(result.code == 1) {
                depObj = result.data;
                allDep = toSelectData(result.data, "id", "city");
                //设置选择框中信息
                createDepSelect(result.data);
            }else{
                showErrorInfo(result.message);
            }
        });

        function createDepSelect(data) {
            var html = '<option value="">&nbsp;</option>';
            data.forEach(function(info) {
                html += '<option value="'+info.id+'">'+info.city+'</option>';
            });
            $("#form-agency-agency_city").html(html);
            $("#form-agency-agency_city").trigger("chosen:updated");
            $("#form-agency-agency_city").val('${agency.agency_city}').trigger("chosen:updated");
        }

        $(document).on('settings.ace.chosen', function(e, event_name, event_val) {
            if(event_name != 'sidebar_collapsed') return;
            $('#form-agency-agency_city').each(function() {
                var $this = $(this);
                $this.next().css({'width': $this.parent().width()});
            })
        });

    })
</script>
</body>
</html>
