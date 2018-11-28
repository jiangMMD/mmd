<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>用户详细</title>
    <link rel="stylesheet" href="/mmd/assets/css/colorbox.css"/>
    <link rel="stylesheet" href="/mmd/assets/css/select2.css"/>
    <link rel="stylesheet" href="/mmd/assets/css/chosen.css"/>
    <link rel="stylesheet" href="/mmd/assets/css/bootstrap-datepicker3.css"/>
    <link rel="stylesheet" href="/mmd/assets/css/bootstrap-timepicker.css"/>
    <link rel="stylesheet" href="/mmd/assets/css/daterangepicker.css"/>
    <link rel="stylesheet" href="/mmd/assets/css/bootstrap-datetimepicker.css"/>
    <style>
        .form-group {
            margin-left: 0 !important;
            margin-right: 0 !important;
            margin-bottom: 0 !important;
        }

        .book_student {
            display: none;
        }

        .ace-file-input input[type=file] {
            width: 1px;
            height: 1px;
        }

        .cboxPhoto {
            height: 100% !important;
            width: 100% !important;
            margin: 0 !important;
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
        <form class="form-horizontal" id="validation-form-custom" method="post" enctype="multipart/form-data">
            <input type="hidden" name="uId" value="${user.uId}">
            <div class="widget-box">
                <div class="widget-header">
                    <h4 class="widget-title">个人信息</h4>
                </div>

                <div class="widget-body">
                    <div class="widget-main" style="min-height: 200px;">
                        <div class="row">
                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-custom-name">姓名<span class="red">*</span></label>
                                <input class="form-control" id="form-custom-name" name="uName" value="${user.uName}"
                                       placeholder="请输入您的姓名">
                            </div>

                            <div class="col-xs-1  form-group">
                                <label for="form-custom-sex">性别<span class="red">*</span></label>
                                <select name="uSex" id="form-custom-sex" class="form-control">
                                    <option value="男">男</option>
                                    <option value="女">女</option>
                                </select>
                            </div>

                            <%--<div class="col-xs-2 form-group">--%>
                                <%--<label class="control-label" for="form-custom-birth">关联MMD的日期<span--%>
                                        <%--class="red">*</span></label>--%>
                                <%--<input class="form-control date-picker" id="form-custom-birth" type="text" name="uRelevancyDate"--%>
                                       <%--data-date-format="yyyy-mm-dd" value="${user.uRelevancyDate}" placeholder="请选择日期">--%>
                            <%--</div>--%>
                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-custom-identity">身份证号<span
                                        class="red">*</span></label>
                                <input class="form-control" id="form-custom-identity" type="text" name="uIdentity"
                                       value="${user.uIdentity}"
                                       placeholder="请输入你的身份证号"/>
                            </div>

                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-custom-place">昵称<span class="red">*</span></label>
                                <input id="form-custom-place" class="form-control" name="uNick" value="${user.uNick}"
                                       placeholder="请输入你的昵称"/>
                            </div>


                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-custom-ethnic">年龄<span class="red">*</span></label>
                                <input class="form-control" id="form-custom-ethnic" name="uAge" value="${user.uAge}"
                                       placeholder="请输入您的年龄"/>
                            </div>
                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-custom-phone">手机<span class="red">*</span></label>
                                <input id="form-custom-phone" class="form-control" name="uPhone" value="${user.uPhone}"
                                       placeholder="请输入您的手机号"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-6 form-group">
                                <label class="control-label" for="form-custom-koseki">用户家庭地址<span
                                        class="red">*</span></label>
                                <input id="form-custom-koseki" class="form-control" name="uAddress" value="${user.uAddress}"
                                       placeholder="请输入你的家庭地址"/>
                            </div>

                        </div>

                    </div>
                </div>
            </div>
            <div class="space-12"></div>
            <div class="row" id="book_save_info">
                <div class="col-xs-4 col-xs-offset-5">
                    <input type="submit" class="btn btn-primary" id="custom_save" value="保存">
                    <input type="reset" class="btn" style="margin-left: 20px;" value="重置表单">
                </div>
            </div>
        </form>
    </div>
</div>

<script>
    var scripts = [null, "/mmd/assets/js/jquery-ui.custom.js",
        "/mmd/assets/js/date-time/bootstrap-datepicker.js",
        "/mmd/assets/js/date-time/bootstrap-timepicker.js",
        "/mmd/assets/js/date-time/daterangepicker.js",
        "/mmd/assets/js/jquery.colorbox.js",
        "/mmd/assets/js/jquery.validate.js",
        "/mmd/assets/js/jquery.validate_zh.js",
        "/mmd/assets/js/jquery.form.js",
        "/mmd/assets/js/bootbox.js",
        "/mmd/assets/js/chosen.jquery.js",
        "/mmd/assets/js/date-time/bootstrap-datetimepicker.js", null];

    function resetForm() {
        $(".chosen-select").val('').trigger("chosen:updated");
    }

    function openFile(url) {
        var project = window.location.origin;
        window.open(project + "/nginxCustomAccesstory/" + url);
    }

    $('.page-content-area').ace_ajax('loadScripts', scripts, function () {
        if('${custom}') {
            //设置不可切换学生
            console.log('类型：${custom.type}');
            if(${custom.type == '2'}) { //表明是学生信息
                $("#book-student-flag").prop("checked", true);
                $(".book_student").show();
                $(".book_adult").hide();
                $("#stdorperId").html("学生");
            }else{
                $("#book-student-flag").prop("checked", false);
                $(".book_adult").show();
                $(".book_student").hide();
                $("#stdorperId").html("成人");
            }

            $("select[name=mobile_flg]").val('${custom.mobile_flg}');
            $("select[name=zhifb_flg]").val('${custom.zhifb_flg}');
            $("select[name=taobao_flg]").val('${custom.taobao_flg}');
            $("select[name=student_flg]").val('${custom.student_flg}');
            $("select[name=family_linkone_sex]").val('${custom.family_linkone_sex}');
            $("select[name=family_linktwo_sex]").val('${custom.family_linktwo_sex}');
            $("select[name=lsex1]").val('${custom.cusLinkList[0].lsex}');
            $("select[name=lsex2]").val('${custom.cusLinkList[1].lsex}');
            $("select[name=lsex3]").val('${custom.cusLinkList[2].lsex}');
            $("select[name=lsex4]").val('${custom.cusLinkList[3].lsex}');
            $("select[name=lsex5]").val('${custom.cusLinkList[4].lsex}');
            $("select[name=lsex6]").val('${custom.cusLinkList[5].lsex}');
        }

        $("#book-student-flag").on("click", function () {
            if ($(this).is(":checked")) {
                $(".book_student").show();
                $(".book_adult").hide();
                $("#stdorperId").html("学生");
                $("input[name=type]").val("2");
            } else {
                $(".book_adult").show();
                $(".book_student").hide();
                $("#stdorperId").html("成人");
                $("input[name=type]").val("1");
            }
        });


        //设置日期选择样式
        $('.date-picker').datepicker({
            autoclose: true,
            todayHighlight: true
        });


        $("#validation-form-custom").submit(function (e) {
            e.preventDefault();
            var flag = $("#validation-form-custom").valid();
            if (flag) {
                $(this).ajaxSubmit({
                    url: projectUrl + "/user/saveUserInfo",
                    type: "post",
                    // beforeSubmit: function() {
                    //     var html = "";
                    //     html += '<div class="center blue"><i class="ace-icon fa fa-spinner fa-spin orange"></i>上传中...请耐心等待</div>'
                    //     html += '<div class="progress pos-rel" style="margin-top:20px;" data-percent="0%">';
                    //     html += '<div class="progress-bar" style="width:0%;"></div>';
                    //     html += '</div>';
                    //     bootbox.dialog({
                    //         message: html,
                    //         closeButton: null,
                    //     })
                    // },
                    // uploadProgress: function (event, position, total, percentComplete) {
                    //     $(".progress").attr("data-percent", percentComplete+"%");
                    //     $(".progress-bar").css("width", percentComplete+"%");
                    // },
                    success: function (result) {
                        bootbox.hideAll();
                        if (result.code === 1) {
                            showInfo("操作成功! 即将返回主列表")
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

        //身份证验证
        jQuery.validator.addMethod("identity", function (value, element) {
            return this.optional(element) || /(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(value);
        }, "请输入有效身份证号码.");
        //做校验
        $("#validation-form-custom").validate({
            errorElement: 'div',
            errorClass: 'help-block',
            focusInvalid: false,
            ignore: ":hidden:not(select)",
            rules: {
                name: {required: true},
                phone: {required: true},
                birth: {required: true},
                ethnic: {required: true},
                identity: {required: true, identity: true},
                nativaplace: {required: true},
                familyphone: {required: true},
                koseki: {required: true},
                nowaddress: {required: true},
                bankcard: {required: true, number: true},
                bankaddress: {required: true},
                company: {required: true},
                income: {required: true, number: true},
                consume: {required: true, number: true},
                indatestring: {required: true},
                studentcard: {required: true},
                school: {required: true},
                //商品信息校验
                product_name: {required: true},
                product_imei: {required: true},
                product_price: {required: true, number:true},
                family_linkone: {required: true},
                family_linkone_sex: {required: true},
                family_linkone_relation: {required: true},
                family_linkone_phone: {required: true},
                family_linkone_address: {required: true},
                family_linktwo: {required: true},
                family_linktwo_sex: {required: true},
                family_linktwo_relation: {required: true},
                family_linktwo_phone: {required: true},
                family_linktwo_address: {required: true},
                //常用联系人校验
                lname1: {required: true},
                lsex1: {required: true},
                lrelation1: {required: true},
                lphone1: {required: true},
                lname2: {required: true},
                lsex2: {required: true},
                lrelation2: {required: true},
                lphone2: {required: true},
                //校验附件信息
                identity_front: {required: true},
                identity_reverse: {required: true},
                cus_phone: {required: true},
                work_card: {required: true},
                zhimfvideo: {required: true},
                shipaddress: {required: true},
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


        //移除显示的dom
        $(document).one('ajaxloadstart.page', function (e) {
            $('#colorbox, #cboxOverlay').remove();
        });
    });
</script>

</body>
</html>
