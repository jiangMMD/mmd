<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>客户详细</title>
    <link rel="stylesheet" href="/erp/assets/css/colorbox.css"/>
    <link rel="stylesheet" href="/erp/assets/css/select2.css"/>
    <link rel="stylesheet" href="/erp/assets/css/chosen.css"/>
    <link rel="stylesheet" href="/erp/assets/css/bootstrap-datepicker3.css"/>
    <link rel="stylesheet" href="/erp/assets/css/bootstrap-timepicker.css"/>
    <link rel="stylesheet" href="/erp/assets/css/daterangepicker.css"/>
    <link rel="stylesheet" href="/erp/assets/css/bootstrap-datetimepicker.css"/>
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
<div class="row">
    <div class="col-xs-12">
        <form class="form-horizontal" id="validation-form-custom" method="post" enctype="multipart/form-data">
            <input type="hidden" name="cid" value="${custom.cid}">
            <input type="hidden" name="type" value="${custom.type}">
            <div class="widget-box">
                <div class="widget-header">
                    <h4 class="widget-title">个人信息</h4>
                    <label class="inline" style="margin-left: 20px">
                        <strong class="muted orange">学生:</strong>
                        <input id="book-student-flag" type="checkbox" class="ace ace-switch ace-switch-5">
                        <span class="lbl middle"></span>
                    </label>
                    <span>(当前为<span id="stdorperId">成人</span>信息)</span>

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
                                <label class="control-label" for="form-custom-name">姓名<span class="red">*</span></label>
                                <input class="form-control" id="form-custom-name" name="name" value="${custom.name}"
                                       placeholder="请输入您的姓名">
                            </div>
                            <div class="col-xs-1  form-group">
                                <label for="form-custom-sex">性别<span class="red">*</span></label>
                                <select name="sex" id="form-custom-sex" class="form-control">
                                    <option value="男">男</option>
                                    <option value="女">女</option>
                                </select>
                            </div>

                            <div class="col-xs-1 form-group">
                                <label class="control-label" for="form-custom-ethnic">名族<span class="red">*</span></label>
                                <input class="form-control" id="form-custom-ethnic" name="ethnic" value="${custom.ethnic}"
                                       placeholder="请输入您的名族"/>
                            </div>

                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-custom-birth">出生年月<span
                                        class="red">*</span></label>
                                <input class="form-control date-picker" id="form-custom-birth" type="text" name="birthday"
                                       data-date-format="yyyy-mm-dd" value="${custom.birthday}" placeholder="请选择您的出生年月">
                            </div>

                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-custom-identity">身份证号<span
                                        class="red">*</span></label>
                                <input class="form-control" id="form-custom-identity" type="text" name="identity"
                                       value="${custom.identity}"
                                       placeholder="请输入你的身份证号"/>
                            </div>

                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-custom-place">籍贯<span class="red">*</span></label>
                                <input id="form-custom-place" class="form-control" name="nativeplace" value="${custom.nativeplace}"
                                       placeholder="请输入你的籍贯"/>
                            </div>

                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-custom-phone">手机<span class="red">*</span></label>
                                <input id="form-custom-phone" class="form-control" name="phone" value="${custom.phone}"
                                       placeholder="请输入您的手机号"/>
                            </div>
                        </div>
                        <div class="space-12"></div>
                        <!--第二行-->
                        <div class="row">
                            <div class="col-xs-6 form-group">
                                <label class="control-label" for="form-custom-koseki">户籍地址<span
                                        class="red">*</span></label>
                                <input id="form-custom-koseki" class="form-control" name="koseki" value="${custom.koseki}"
                                       placeholder="请输入你的户籍地址"/>
                            </div>
                            <div class="col-xs-6 form-group">
                                <label class="control-label" for="form-custom-nowaddress">现地址<span
                                        class="red">*</span></label>
                                <input id="form-custom-nowaddress" class="form-control" name="nowaddress"
                                       value="${custom.nowaddress}"
                                       placeholder="请输入你现居住地址"/>
                            </div>

                        </div>

                        <div class="space-12 book_adult"></div>
                        <div class="row book_adult">
                            <div class="col-xs-4 form-group">
                                <label class="control-label" for="form-custom-company">单位名称<span
                                        class="red">*</span></label>
                                <input id="form-custom-company" class="form-control" name="company"
                                       value="${custom.company}"
                                       placeholder="请输入你的单位名称"/>
                            </div>
                            <div class="col-xs-1 form-group">
                                <label class="control-label" for="form-custom-income">月收入<span
                                        class="red">*</span></label>
                                <input id="form-custom-income" class="form-control" name="income" value="${custom.income}"
                                       placeholder="月收入"/>
                            </div>
                            <div class="col-xs-1 form-group">
                                <label class="control-label" for="form-custom-consume">月消费<span
                                        class="red">*</span></label>
                                <input id="form-custom-consume" class="form-control" name="consume"
                                       value="${custom.consume}" placeholder="月消费"/>
                            </div>
                        </div>

                        <div class="space-12 book_student"></div>
                        <div class="row book_student">
                            <div class="col-xs-4 form-group">
                                <label class="control-label" for="form-custom-school">学校名称<span
                                        class="red">*</span></label>
                                <input id="form-custom-school" class="form-control" name="school" value="${custom.school}"
                                       placeholder="请输入你的学校名称"/>
                            </div>
                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-custom-indatestring">入校时间<span class="red">*</span></label>
                                <input class="form-control date-picker" id="form-custom-indatestring" type="text"
                                       name="indatestring"
                                       data-date-format="yyyy-mm-dd" value="${custom.indatestring}" placeholder="入校时间">
                            </div>
                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-custom-studentcard">学生证编号<span class="red">*</span></label>
                                <input id="form-custom-studentcard" class="form-control" name="studentcard"
                                       value="${custom.studentcard}" placeholder="学生证编号"/>
                            </div>
                        </div>

                        <div class="space-12"></div>
                        <div class="row">
                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-custom-bankcard">银行卡号<span
                                        class="red">*</span></label>
                                <input id="form-custom-bankcard" class="form-control" name="bankcard"
                                       value="${custom.bankcard}"
                                       placeholder="请输入你的银行卡号"/>
                            </div>
                            <div class="col-xs-4 form-group">
                                <label class="control-label" for="form-custom-bankaddress">银行卡开户行<span
                                        class="red">*</span></label>
                                <input id="form-custom-bankaddress" class="form-control" name="bankaddress"
                                       value="${custom.bankaddress}"
                                       placeholder="请输入你的开户行"/>
                            </div>

                            <!--收货地址-->
                            <div class="col-xs-6 form-group">
                                <label class="control-label" for="form-custom-bankaddress">收货地址<span
                                        class="red">*</span></label>
                                <input id="form-custom-shipaddress" class="form-control" name="shipaddress"
                                       value="${custom.shipaddress}"
                                       placeholder="请输入你的开户行"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="space-20"></div>

            <div class="widget-box">
                <div class="widget-header">
                    <h4 class="widget-title">亲属联系人信息</h4>
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
                                <label class="control-label" for="form-custom-family_linkone">姓名<span class="red">*</span></label>
                                <input class="form-control" id="form-custom-family_linkone" name="family_linkone_name"
                                       value="${custom.family_linkone_name}">
                            </div>
                            <div class="col-xs-1 form-group">
                                <label class="control-label" class="form-custom-family_linkone_sex">性别<span
                                        class="red">*</span></label>
                                <select class="form-control" id="form-custom-family_linkone_sex"
                                        name="family_linkone_sex">
                                    <option value="男" selected>男</option>
                                    <option value="女">女</option>
                                </select>
                            </div>

                            <div class="col-xs-1 form-group">
                                <label class="control-label" for="form-custom-family_linkone_relation">关系<span
                                        class="red">*</span></label>
                                <input class="form-control" id="form-custom-family_linkone_relation"
                                       name="family_linkone_relation" value="${custom.family_linkone_relation}"/>
                            </div>

                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-custom-family_linkone_phone">手机<span
                                        class="red">*</span></label>
                                <input class="form-control" id="form-custom-family_linkone_phone"
                                       name="family_linkone_phone" value="${custom.family_linkone_phone}"/>
                            </div>

                            <div class="col-xs-6 form-group">
                                <label class="control-label" for="form-custom-family_linkone_address">地址<span class="red">*</span></label>
                                <input class="form-control" id="form-custom-family_linkone_address"
                                       name="family_linkone_address" value="${custom.family_linkone_address}"/>
                            </div>
                        </div>
                        <div class="space-12"></div>
                        <div class="row">
                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-custom-family_linktwo">姓名<span class="red">*</span></label>
                                <input class="form-control" id="form-custom-family_linktwo" name="family_linktwo_name"
                                       value="${custom.family_linktwo_name}">
                            </div>
                            <div class="col-xs-1 form-group">
                                <label class="control-label" for="form-custom-family_linktwo_sex">性别<span
                                        class="red">*</span></label>
                                <select class="form-control" id="form-custom-family_linktwo_sex"
                                        name="family_linktwo_sex">
                                    <option value="男" selected>男</option>
                                    <option value="女">女</option>
                                </select>
                            </div>

                            <div class="col-xs-1 form-group">
                                <label class="control-label" for="form-custom-family_linktwo_relation">关系<span
                                        class="red">*</span></label>
                                <input class="form-control" id="form-custom-family_linktwo_relation"
                                       name="family_linktwo_relation" value="${custom.family_linktwo_relation}"/>
                            </div>

                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-custom-family_linktwo_phone">手机<span
                                        class="red">*</span></label>
                                <input class="form-control" id="form-custom-family_linktwo_phone"
                                       name="family_linktwo_phone" value="${custom.family_linktwo_phone}"/>
                            </div>

                            <div class="col-xs-6 form-group">
                                <label class="control-label" for="form-custom-family_linktwo_address">地址<span class="red">*</span></label>
                                <input class="form-control" id="form-custom-family_linktwo_address"
                                       name="family_linktwo_address" value="${custom.family_linktwo_address}"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="space-20"></div>
            <!--常用联系人信息-->
            <div class="widget-box">
                <div class="widget-header">
                    <h4 class="widget-title">常用联系人信息</h4>
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
                                <label class="control-label" for="form-custom-lname1">姓名<span class="red">*</span></label>
                                <input class="form-control" id="form-custom-lname1" name="lname1"
                                       value="${custom.cusLinkList[0].lname}">
                            </div>
                            <div class="col-xs-1 form-group">
                                <label class="control-label" for="form-book-lsex1">性别<span class="red">*</span></label>
                                <select class="form-control" id="form-book-lsex1" name="lsex1">
                                    <option value="男" selected>男</option>
                                    <option value="女">女</option>
                                </select>
                            </div>

                            <div class="col-xs-1 form-group">
                                <label class="control-label" for="form-custom-lrelation1">关系<span
                                        class="red">*</span></label>
                                <input class="form-control" id="form-custom-lrelation1" name="lrelation1"
                                       value="${custom.cusLinkList[0].lrelation}"/>
                            </div>

                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-custom-lphone1">手机<span
                                        class="red">*</span></label>
                                <input class="form-control" id="form-custom-lphone1" name="lphone1"
                                       value="${custom.cusLinkList[0].lphone}"/>
                            </div>

                            <div class="col-xs-6 form-group">
                                <label class="control-label" for="form-custom-lmemo1">备注</label>
                                <input class="form-control" id="form-custom-lmemo1" name="lmemo1"
                                       value="${custom.cusLinkList[0].lmemo}"/>
                            </div>
                        </div>
                        <div class="space-12"></div>
                        <div class="row">
                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-custom-lname2">姓名<span class="red">*</span></label>
                                <input class="form-control" id="form-custom-lname2" name="lname2"
                                       value="${custom.cusLinkList[1].lname}">
                            </div>
                            <div class="col-xs-1 form-group">
                                <label class="control-label" for="form-custom-lsex2">性别<span class="red">*</span></label>
                                <select class="form-control" id="form-custom-lsex2" name="lsex2">
                                    <option value="男" selected>男</option>
                                    <option value="女">女</option>
                                </select>
                            </div>

                            <div class="col-xs-1 form-group">
                                <label class="control-label" for="form-custom-lrelation2">关系<span
                                        class="red">*</span></label>
                                <input class="form-control" id="form-custom-lrelation2" name="lrelation2"
                                       value="${custom.cusLinkList[1].lrelation}"/>
                            </div>

                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-custom-lphone2">手机<span
                                        class="red">*</span></label>
                                <input class="form-control" id="form-custom-lphone2" name="lphone2"
                                       value="${custom.cusLinkList[1].lphone}"/>
                            </div>

                            <div class="col-xs-6 form-group">
                                <label class="control-label" for="form-custom-lmemo2">备注</label>
                                <input class="form-control" id="form-custom-lmemo2" name="lmemo2"
                                       value="${custom.cusLinkList[1].lmemo}"/>
                            </div>
                        </div>
                        <!--联系人3-->
                        <div class="space-12"></div>
                        <div class="row">
                            <div class="col-xs-2">
                                <label for="form-custom-lname3">姓名</label>
                                <input class="form-control" id="form-custom-lname3" name="lname3"
                                       value="${custom.cusLinkList[2].lname}">
                            </div>
                            <div class="col-xs-1">
                                <label for="form-custom-lsex3">性别</label>
                                <select class="form-control" id="form-custom-lsex3" name="lsex3">
                                    <option value="男" selected>男</option>
                                    <option value="女">女</option>
                                </select>
                            </div>

                            <div class="col-xs-1">
                                <label for="form-custom-lrelation3">关系</label>
                                <input class="form-control" id="form-custom-lrelation3" name="lrelation3"
                                       value="${custom.cusLinkList[2].lrelation}"/>
                            </div>

                            <div class="col-xs-2">
                                <label for="form-custom-lphone3">手机</label>
                                <input class="form-control" id="form-custom-lphone3" name="lphone3"
                                       value="${custom.cusLinkList[2].lphone}"/>
                            </div>

                            <div class="col-xs-6">
                                <label for="form-custom-lmemo3">备注</label>
                                <input class="form-control" id="form-custom-lmemo3" name="lmemo3"
                                       value="${custom.cusLinkList[2].lmemo}"/>
                            </div>
                        </div>
                        <!--联系人4-->
                        <div class="space-12"></div>
                        <div class="row">
                            <div class="col-xs-2">
                                <label for="form-custom-lname4">姓名</label>
                                <input class="form-control" id="form-custom-lname4" name="lname4"
                                       value="${custom.cusLinkList[3].lname}">
                            </div>
                            <div class="col-xs-1">
                                <label for="form-custom-lsex4">性别</label>
                                <select class="form-control" id="form-custom-lsex4" name="lsex4">
                                    <option value="男" selected>男</option>
                                    <option value="女">女</option>
                                </select>
                            </div>

                            <div class="col-xs-1">
                                <label for="form-custom-lrelation4">关系</label>
                                <input class="form-control" id="form-custom-lrelation4" name="lrelation4"
                                       value="${custom.cusLinkList[3].lrelation}"/>
                            </div>

                            <div class="col-xs-2">
                                <label for="form-custom-lphone4">手机</label>
                                <input class="form-control" id="form-custom-lphone4" name="lphone4"
                                       value="${custom.cusLinkList[3].lphone}"/>
                            </div>

                            <div class="col-xs-6">
                                <label for="form-custom-lmemo4">备注</label>
                                <input class="form-control" id="form-custom-lmemo4" name="lmemo4"
                                       value="${custom.cusLinkList[3].lmemo}"/>
                            </div>
                        </div>

                        <!--联系人5-->
                        <div class="space-12"></div>
                        <div class="row">
                            <div class="col-xs-2">
                                <label for="form-custom-lname5">姓名</label>
                                <input class="form-control" id="form-custom-lname5" name="lname5"
                                       value="${custom.cusLinkList[4].lname}">
                            </div>
                            <div class="col-xs-1">
                                <label for="form-custom-lsex5">性别</label>
                                <select class="form-control" id="form-custom-lsex5" name="lsex5">
                                    <option value="男" selected>男</option>
                                    <option value="女">女</option>
                                </select>
                            </div>

                            <div class="col-xs-1">
                                <label for="form-custom-lrelation5">关系</label>
                                <input class="form-control" id="form-custom-lrelation5" name="lrelation5"
                                       value="${custom.cusLinkList[4].lrelation}"/>
                            </div>

                            <div class="col-xs-2">
                                <label for="form-custom-lphone5">手机</label>
                                <input class="form-control" id="form-custom-lphone5" name="lphone5"
                                       value="${custom.cusLinkList[4].lphone}"/>
                            </div>

                            <div class="col-xs-6">
                                <label for="form-custom-lmemo5">备注</label>
                                <input class="form-control" id="form-custom-lmemo5" name="lmemo5"
                                       value="${custom.cusLinkList[4].lmemo}"/>
                            </div>
                        </div>

                        <!--联系人6-->
                        <div class="space-12"></div>
                        <div class="row">
                            <div class="col-xs-2">
                                <label for="form-custom-lname6">姓名</label>
                                <input class="form-control" id="form-custom-lname6" name="lname6"
                                       value="${custom.cusLinkList[5].lname}">
                            </div>
                            <div class="col-xs-1">
                                <label for="form-custom-lsex6">性别</label>
                                <select class="form-control" id="form-custom-lsex6" name="lsex6">
                                    <option value="男" selected>男</option>
                                    <option value="女">女</option>
                                </select>
                            </div>

                            <div class="col-xs-1">
                                <label for="form-custom-lrelation6">关系</label>
                                <input class="form-control" id="form-custom-lrelation6" name="lrelation6"
                                       value="${custom.cusLinkList[5].lrelation}"/>
                            </div>

                            <div class="col-xs-2">
                                <label for="form-custom-lphone6">手机</label>
                                <input class="form-control" id="form-custom-lphone6" name="lphone6"
                                       value="${custom.cusLinkList[5].lphone}"/>
                            </div>

                            <div class="col-xs-6">
                                <label for="form-custom-lmemo6">备注</label>
                                <input class="form-control" id="form-custom-lmemo6" name="lmemo6"
                                       value="${custom.cusLinkList[5].lmemo}"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="space-20"></div>
            <div class="widget-box">
                <div class="widget-header">
                    <h4 class="widget-title">认证状态</h4>
                    <div class="widget-toolbar">
                        <a href="#" data-action="collapse">
                            <i class="ace-icon fa fa-chevron-up"></i>
                        </a>
                    </div>
                </div>
                <div class="widget-body">
                    <div class="widget-main">
                        <div class="row">

                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-custom-mobileflg">运营商认证状态</label>
                                <select disabled class="form-control" id="form-custom-mobileflg" name="mobile_flg">
                                    <option value="1">已认证</option>
                                    <option value="2">未认证</option>
                                </select>
                            </div>

                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-custom-taobao_flg">淘宝认证状态</label>
                                <select disabled class="form-control" id="form-custom-taobao_flg" name="taobao_flg">
                                    <option value="1">已认证</option>
                                    <option value="2">未认证</option>
                                </select>
                            </div>

                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-custom-zhifb_flg">支付宝认证状态</label>
                                <select disabled class="form-control" id="form-custom-zhifb_flg" name="zhifb_flg">
                                    <option value="1">已认证</option>
                                    <option value="2">未认证</option>
                                </select>
                            </div>

                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-custom-student_flg">学信网认证状态</label>
                                <select disabled class="form-control" id="form-custom-student_flg" name="student_flg">
                                    <option value="1">已认证</option>
                                    <option value="2">未认证</option>
                                </select>
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
                                <label class="control-label" for="form-custom-identity_front">身份证正面<span
                                        class="red">*</span></label>
                                <input type="file" data-rule-required="true" id="form-custom-identity_front"
                                       name="identity_frontFile"/>
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-custom-identity_reverse">身份证反面<span
                                        class="red">*</span></label>
                                <input type="file" id="form-custom-identity_reverse" name="identity_reverseFile"/>
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-custom-cus_phone">个人照<span
                                        class="red">*</span></label>
                                <input type="file" id="form-custom-cus_phone" name="cus_photoFile"/>
                            </div>


                            <c:if test="${custom != null && custom.type == '1'}">
                                <div class="col-xs-3 form-group">
                                    <label class="control-label" for="form-custom-work_card">工作证<span class="red">*</span></label>
                                    <input type="file" id="form-custom-work_card" name="workcardFile"/>
                                </div>
                            </c:if>
                        </div>

                        <div class="space-12"></div>

                        <div class="row">
                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-custom-zhimfvideo">芝麻分查询视频<span class="red">*</span></label>
                                <input type="file" id="form-custom-zhimfvideo" name="zhimfvideoFile"/>
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


        if (!'${custom.cid}') {
            //身份证正面
            $('#form-custom-identity_front').ace_file_input({
                no_file: '选择文件...',
                btn_choose: 'Choose',
                btn_change: 'Change',
                droppable: true,
                onchange: null,
                thumbnail: false //| true | large
            });
            //身份证反面
            $('#form-custom-identity_reverse').ace_file_input({
                no_file: '选择文件...',
                btn_choose: 'Choose',
                btn_change: 'Change',
                droppable: true,
                onchange: null,
                thumbnail: false
            });
            //手持身份证
            $('#form-custom-cus_phone').ace_file_input({
                no_file: '选择文件...',
                btn_choose: 'Choose',
                btn_change: 'Change',
                droppable: true,
                onchange: null,
                thumbnail: false
            });
            //工作证明
            $('#form-custom-work_card').ace_file_input({
                no_file: '选择文件...',
                btn_choose: 'Choose',
                btn_change: 'Change',
                droppable: true,
                onchange: null,
                thumbnail: false
            });
            //芝麻分
            $('#form-custom-zhimfvideo').ace_file_input({
                no_file: '选择文件...',
                btn_choose: 'Choose',
                btn_change: 'Change',
                droppable: true,
                onchange: null,
                thumbnail: false
            });
        }else{
            //直接设置查看
            $('#form-custom-identity_front').hide();
            var identity_front = '${custom.identity_front}';
            $('#form-custom-identity_front').after('<a onclick="openFile(\''+identity_front+'\')" class="blue2" style="display:block; cursor: pointer">文件已上传，点击查看</a>');

            $('#form-custom-identity_reverse').hide();
            var identity_reverse = '${custom.identity_reverse}';
            $('#form-custom-identity_reverse').after('<a onclick="openFile(\''+identity_reverse+'\')" class="blue2" style="display:block; cursor: pointer">文件已上传，点击查看</a>');

            $('#form-custom-cus_phone').hide();
            var cus_photo = '${custom.cus_photo}';
            $('#form-custom-cus_phone').after('<a onclick="openFile(\''+cus_photo+'\')" class="blue2" style="display:block; cursor: pointer">文件已上传，点击查看</a>');

            $('#form-custom-work_card').hide();
            var workcard = '${custom.workcard}';
            $('#form-custom-work_card').after('<a onclick="openFile(\''+workcard+'\')" class="blue2" style="display:block; cursor: pointer">文件已上传，点击查看</a>');

            $('#form-custom-zhimfvideo').hide();
            var zhimfvideo = '${custom.zhimfvideo}';
            $('#form-custom-zhimfvideo').after('<a onclick="openFile(\''+zhimfvideo+'\')" class="blue2" style="display:block; cursor: pointer">文件已上传，点击查看</a>');

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
        }

        $("#validation-form-custom").submit(function (e) {
            e.preventDefault();
            var flag = $("#validation-form-custom").valid();
            if (flag) {
                $(this).ajaxSubmit({
                    url: projectUrl + "/custom/saveCustom",
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
