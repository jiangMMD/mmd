<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>订单查看详细 - 笑享租</title>
    <link rel="stylesheet" href="/erp/assets/css/colorbox.css"/>
    <link rel="stylesheet" href="/erp/assets/css/select2.css"/>
    <link rel="stylesheet" href="/erp/assets/css/chosen.css"/>
    <link rel="stylesheet" href="/erp/assets/css/bootstrap-datepicker3.css" />
    <link rel="stylesheet" href="/erp/assets/css/bootstrap-timepicker.css" />
    <link rel="stylesheet" href="/erp/assets/css/daterangepicker.css" />
    <link rel="stylesheet" href="/erp/assets/css/bootstrap-datetimepicker.css" />
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
        <form class="form-horizontal" id="validation-form-book" method="post" enctype="multipart/form-data">
            <input type="hidden" name="bid" value="${book.bid}">
            <div class="widget-box">
                <div class="widget-header">
                    <h4 class="widget-title">选择代理</h4>
                    <div class="widget-toolbar">
                        <a href="#" data-action="collapse">
                            <i class="ace-icon fa fa-chevron-up"></i>
                        </a>
                    </div>
                </div>
                <div class="widget-body">
                    <div class="widget-main">
                        <div class="row">
                            <div class="col-xs-4 form-group">
                                <label class="control-label" for="form-book-agency_id">代理商<span class="red">*</span></label>
                                <select id="form-book-agency_id" name="agency_id" class="form-control">
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="space-20"></div>

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
                                <label class="control-label" for="form-book-name">姓名<span class="red">*</span></label>
                                <input class="form-control" id="form-book-name" name="name" value="${book.name}"
                                       placeholder="请输入您的姓名">
                            </div>
                            <div class="col-xs-1  form-group">
                                <label for="form-book-sex">性别<span class="red">*</span></label>
                                <select name="sex" id="form-book-sex" class="form-control">
                                    <option value="男">男</option>
                                    <option value="女">女</option>
                                </select>
                            </div>

                            <div class="col-xs-1 form-group">
                                <label class="control-label" for="form-book-ethnic">名族<span class="red">*</span></label>
                                <input class="form-control" id="form-book-ethnic" name="ethnic" value="${book.ethnic}"
                                       placeholder="请输入您的名族"/>
                            </div>

                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-book-birth">出生年月<span
                                        class="red">*</span></label>
                                <input class="form-control date-picker" id="form-book-birth" type="text" name="birth"
                                       data-date-format="yyyy-mm-dd" value="${book.birth}" placeholder="请选择您的出生年月">
                            </div>

                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-book-identity">身份证号<span
                                        class="red">*</span></label>
                                <input class="form-control" id="form-book-identity" type="text" name="identity"
                                       value="${book.identity}"
                                       placeholder="请输入你的身份证号"/>
                            </div>

                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-book-place">籍贯<span class="red">*</span></label>
                                <input id="form-book-place" class="form-control" name="place" value="${book.place}"
                                       placeholder="请输入你的籍贯"/>
                            </div>
                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-book-familyphone">家庭电话<span class="red">*</span></label>
                                <input id="form-book-familyphone" class="form-control" value="${book.familyphone}"
                                       name="familyphone"
                                       placeholder="请输入你的家庭电话"/>
                            </div>
                        </div>
                        <div class="space-12"></div>
                        <!--第二行-->
                        <div class="row">
                            <div class="col-xs-4 form-group">
                                <label class="control-label" for="form-book-koseki">户籍地址<span
                                        class="red">*</span></label>
                                <input id="form-book-koseki" class="form-control" name="koseki" value="${book.koseki}"
                                       placeholder="请输入你的户籍地址"/>
                            </div>
                            <div class="col-xs-4 form-group">
                                <label class="control-label" for="form-book-nowaddress">现地址<span
                                        class="red">*</span></label>
                                <input id="form-book-nowaddress" class="form-control" name="nowaddress"
                                       value="${book.nowaddress}"
                                       placeholder="请输入你现居住地址"/>
                            </div>

                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-book-phone">手机<span class="red">*</span></label>
                                <input id="form-book-phone" class="form-control" name="phone" value="${book.phone}"
                                       placeholder="请输入您的手机号"/>
                            </div>
                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-book-phoneserviceno">手机服务密码<span
                                        class="red">*</span></label>
                                <input id="form-book-phoneserviceno" class="form-control" value="${book.phoneserviceno}"
                                       name="phoneserviceno"
                                       placeholder="请输入服务密码"/>
                            </div>

                        </div>

                        <div class="space-12 book_adult"></div>
                        <div class="row book_adult">
                            <div class="col-xs-4 form-group">
                                <label class="control-label" for="form-book-company">单位名称<span
                                        class="red">*</span></label>
                                <input id="form-book-company" class="form-control" name="company"
                                       value="${book.company}"
                                       placeholder="请输入你的单位名称"/>
                            </div>
                            <div class="col-xs-1 form-group">
                                <label class="control-label" for="form-book-income">月收入<span
                                        class="red">*</span></label>
                                <input id="form-book-income" class="form-control" name="income" value="${book.income}"
                                       placeholder="月收入"/>
                            </div>
                            <div class="col-xs-1 form-group">
                                <label class="control-label" for="form-book-consume">月消费<span
                                        class="red">*</span></label>
                                <input id="form-book-consume" class="form-control" name="consume"
                                       value="${book.consume}" placeholder="月消费"/>
                            </div>
                        </div>

                        <div class="space-12 book_student"></div>
                        <div class="row book_student">
                            <div class="col-xs-4 form-group">
                                <label class="control-label" for="form-book-school">学校名称<span
                                        class="red">*</span></label>
                                <input id="form-book-school" class="form-control" name="school" value="${book.school}"
                                       placeholder="请输入你的学校名称"/>
                            </div>
                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-book-indatestring">入校时间<span class="red">*</span></label>
                                <input class="form-control date-picker" id="form-book-indatestring" type="text"
                                       name="indatestring"
                                       data-date-format="yyyy-mm-dd" value="${book.indatestring}" placeholder="入校时间">
                            </div>
                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-book-studentcard">学生证编号<span class="red">*</span></label>
                                <input id="form-book-studentcard" class="form-control" name="studentcard"
                                       value="${book.studentcard}" placeholder="学生证编号"/>
                            </div>
                        </div>

                        <div class="space-12"></div>
                        <div class="row">

                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-book-weixin">微信号</label>
                                <input id="form-book-weixin" class="form-control" name="weixin" value="${book.weixin}"
                                       placeholder="请输入您的微信号"/>
                            </div>

                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-book-qq">QQ</label>
                                <input id="form-book-qq" class="form-control" name="qq" value="${book.qq}"
                                       placeholder="请输入你的QQ"/>
                            </div>
                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-book-email">邮箱</label>
                                <input id="form-book-email" class="form-control" name="email" value="${book.email}"
                                       placeholder="请输入你的邮箱"/>
                            </div>
                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-book-bankcard">银行卡号<span
                                        class="red">*</span></label>
                                <input id="form-book-bankcard" class="form-control" name="bankcard"
                                       value="${book.bankcard}"
                                       placeholder="请输入你的银行卡号"/>
                            </div>
                            <div class="col-xs-4 form-group">
                                <label class="control-label" for="form-book-bankaddress">银行卡开户行<span
                                        class="red">*</span></label>
                                <input id="form-book-bankaddress" class="form-control" name="bankaddress"
                                       value="${book.bankaddress}"
                                       placeholder="请输入你的开户行"/>
                            </div>
                        </div>
                        <div class="space-12"></div>
                        <div class="row">
                            <div class="col-xs-12 form-group">
                                <label class="control-label" for="form-book-memo">备注</label>
                                <input id="form-book-memo" class="form-control" name="memo" value="${book.memo}"
                                       placeholder="请输入500字以下备注信息"/>
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
                            <div class="col-xs-4 form-group">
                                <label class="control-label" for="form-book-product_name">商品名称<span class="red">*</span></label>
                                <input class="form-control" id="form-book-product_name" name="product_name"
                                       value="${book.product_name}" placeholder="请输入产品名称">
                            </div>
                            <div class="col-xs-4 form-group">
                                <label class="control-label" for="form-book-product_price">商品价值<span
                                        class="red">*</span></label>
                                <input class="form-control" id="form-book-product_price" name="product_price" value="${book.product_price}"
                                       placeholder="请输入商品价值"/>
                            </div>

                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-book-product_imei">IMEI号<span
                                        class="red">*</span></label>
                                <input class="form-control" id="form-book-product_imei" name="product_imei"
                                       value="${book.product_imei}" placeholder="请输入IMEI号">
                            </div>
                            <%--<div class="col-xs-2 form-group">--%>
                                <%--<label class="control-label" for="form-book-desposit">押金金额<span--%>
                                        <%--class="red">*</span></label>--%>
                                <%--<input class="form-control" id="form-book-desposit" name="desposit"--%>
                                       <%--value="${book.desposit}">--%>
                            <%--</div>--%>
                        </div>
                        <div class="space-12"></div>
                        <div class="row">
                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-book-leaseterm">租期<span
                                        class="red">*</span></label>
                                <select id="form-book-leaseterm" name="leaseterm" class="form-control">
                                    <option value="6">6</option>
                                    <option value="9" selected>9</option>
                                    <option value="12">12</option>
                                </select>
                            </div>

                            <%--<div class="col-xs-2 form-group">--%>
                                <%--<label class="control-label" for="form-book-despositrate">押金比例</label>--%>
                                <%--<input id="form-book-despositrate" class="form-control" name="despositrate"--%>
                                       <%--value="${book.despositrate}" disabled/>--%>
                            <%--</div>--%>

                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-book-monthrent">每期租金金额<span
                                        class="red">*</span></label>
                                <input readonly id="form-book-monthrent" class="form-control" name="monthrent"
                                       value="${book.monthrent}"/>
                            </div>

                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-book-monthrentrate">每期租金租金比例</label>
                                <input readonly id="form-book-monthrentrate" class="form-control" name="monthrentrate"
                                       value="${book.monthrentrate}" disabled/>
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
                                <label class="control-label" for="form-book-family_linkone">姓名<span class="red">*</span></label>
                                <input class="form-control" id="form-book-family_linkone" name="family_linkone"
                                       value="${book.family_linkone}">
                            </div>
                            <div class="col-xs-1 form-group">
                                <label class="control-label" class="form-book-family_linkone_sex">性别<span
                                        class="red">*</span></label>
                                <select class="form-control" id="form-book-family_linkone_sex"
                                        name="family_linkone_sex">
                                    <option value="男" selected>男</option>
                                    <option value="女">女</option>
                                </select>
                            </div>

                            <div class="col-xs-1 form-group">
                                <label class="control-label" for="form-book-family_linkone_relation">关系<span
                                        class="red">*</span></label>
                                <input class="form-control" id="form-book-family_linkone_relation"
                                       name="family_linkone_relation" value="${book.family_linkone_relation}"/>
                            </div>

                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-book-family_linkone_phone">手机<span
                                        class="red">*</span></label>
                                <input class="form-control" id="form-book-family_linkone_phone"
                                       name="family_linkone_phone" value="${book.family_linkone_phone}"/>
                            </div>

                            <div class="col-xs-6 form-group">
                                <label class="control-label" for="form-book-family_linkone_address">地址<span class="red">*</span></label>
                                <input class="form-control" id="form-book-family_linkone_address"
                                       name="family_linkone_address" value="${book.family_linkone_address}"/>
                            </div>
                        </div>
                        <div class="space-12"></div>
                        <div class="row">
                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-book-family_linktwo">姓名<span class="red">*</span></label>
                                <input class="form-control" id="form-book-family_linktwo" name="family_linktwo"
                                       value="${book.family_linktwo}">
                            </div>
                            <div class="col-xs-1 form-group">
                                <label class="control-label" for="form-book-family_linktwo_sex">性别<span
                                        class="red">*</span></label>
                                <select class="form-control" id="form-book-family_linktwo_sex"
                                        name="family_linktwo_sex">
                                    <option value="男" selected>男</option>
                                    <option value="女">女</option>
                                </select>
                            </div>

                            <div class="col-xs-1 form-group">
                                <label class="control-label" for="form-book-family_linktwo_relation">关系<span
                                        class="red">*</span></label>
                                <input class="form-control" id="form-book-family_linktwo_relation"
                                       name="family_linktwo_relation" value="${book.family_linktwo_relation}"/>
                            </div>

                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-book-family_linktwo_phone">手机<span
                                        class="red">*</span></label>
                                <input class="form-control" id="form-book-family_linktwo_phone"
                                       name="family_linktwo_phone" value="${book.family_linktwo_phone}"/>
                            </div>

                            <div class="col-xs-6 form-group">
                                <label class="control-label" for="form-book-family_linktwo_address">地址<span class="red">*</span></label>
                                <input class="form-control" id="form-book-family_linktwo_address"
                                       name="family_linktwo_address" value="${book.family_linktwo_address}"/>
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
                                <label class="control-label" for="form-book-lname1">姓名<span class="red">*</span></label>
                                <input class="form-control" id="form-book-lname1" name="lname1"
                                       value="${book.cusLinkList[0].lname}">
                            </div>
                            <div class="col-xs-1 form-group">
                                <label class="control-label" for="form-book-lsex1">性别<span class="red">*</span></label>
                                <select class="form-control" id="form-book-lsex1" name="lsex1">
                                    <option value="男" selected>男</option>
                                    <option value="女">女</option>
                                </select>
                            </div>

                            <div class="col-xs-1 form-group">
                                <label class="control-label" for="form-book-lrelation1">关系<span
                                        class="red">*</span></label>
                                <input class="form-control" id="form-book-lrelation1" name="lrelation1"
                                       value="${book.cusLinkList[0].lrelation}"/>
                            </div>

                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-book-lphone1">手机<span
                                        class="red">*</span></label>
                                <input class="form-control" id="form-book-lphone1" name="lphone1"
                                       value="${book.cusLinkList[0].lphone}"/>
                            </div>

                            <div class="col-xs-6 form-group">
                                <label class="control-label" for="form-book-lmemo1">备注<span class="red">*</span></label>
                                <input class="form-control" id="form-book-lmemo1" name="lmemo1"
                                       value="${book.cusLinkList[0].lmemo}"/>
                            </div>
                        </div>
                        <div class="space-12"></div>
                        <div class="row">
                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-book-lname2">姓名<span class="red">*</span></label>
                                <input class="form-control" id="form-book-lname2" name="lname2"
                                       value="${book.cusLinkList[1].lname}">
                            </div>
                            <div class="col-xs-1 form-group">
                                <label class="control-label" for="form-book-lsex2">性别<span class="red">*</span></label>
                                <select class="form-control" id="form-book-lsex2" name="lsex2">
                                    <option value="男" selected>男</option>
                                    <option value="女">女</option>
                                </select>
                            </div>

                            <div class="col-xs-1 form-group">
                                <label class="control-label" for="form-book-lrelation2">关系<span
                                        class="red">*</span></label>
                                <input class="form-control" id="form-book-lrelation2" name="lrelation2"
                                       value="${book.cusLinkList[1].lrelation}"/>
                            </div>

                            <div class="col-xs-2 form-group">
                                <label class="control-label" for="form-book-lphone2">手机<span
                                        class="red">*</span></label>
                                <input class="form-control" id="form-book-lphone2" name="lphone2"
                                       value="${book.cusLinkList[1].lphone}"/>
                            </div>

                            <div class="col-xs-6 form-group">
                                <label class="control-label" for="form-book-lmemo2">备注<span class="red">*</span></label>
                                <input class="form-control" id="form-book-lmemo2" name="lmemo2"
                                       value="${book.cusLinkList[1].lmemo}"/>
                            </div>
                        </div>
                        <!--联系人3-->
                        <div class="space-12"></div>
                        <div class="row">
                            <div class="col-xs-2">
                                <label for="form-book-lname3">姓名</label>
                                <input class="form-control" id="form-book-lname3" name="lname3"
                                       value="${book.cusLinkList[2].lname}">
                            </div>
                            <div class="col-xs-1">
                                <label for="form-book-lsex3">性别</label>
                                <select class="form-control" id="form-book-lsex3" name="lsex3">
                                    <option value="男" selected>男</option>
                                    <option value="女">女</option>
                                </select>
                            </div>

                            <div class="col-xs-1">
                                <label for="form-book-lrelation3">关系</label>
                                <input class="form-control" id="form-book-lrelation3" name="lrelation3"
                                       value="${book.cusLinkList[2].lrelation}"/>
                            </div>

                            <div class="col-xs-2">
                                <label for="form-book-lphone3">手机</label>
                                <input class="form-control" id="form-book-lphone3" name="lphone3"
                                       value="${book.cusLinkList[2].lphone}"/>
                            </div>

                            <div class="col-xs-6">
                                <label for="form-book-lmemo3">备注</label>
                                <input class="form-control" id="form-book-lmemo3" name="lmemo3"
                                       value="${book.cusLinkList[2].lmemo}"/>
                            </div>
                        </div>
                        <!--联系人4-->
                        <div class="space-12"></div>
                        <div class="row">
                            <div class="col-xs-2">
                                <label for="form-book-lname4">姓名</label>
                                <input class="form-control" id="form-book-lname4" name="lname4"
                                       value="${book.cusLinkList[3].lname}">
                            </div>
                            <div class="col-xs-1">
                                <label for="form-book-lsex4">性别</label>
                                <select class="form-control" id="form-book-lsex4" name="lsex4">
                                    <option value="男" selected>男</option>
                                    <option value="女">女</option>
                                </select>
                            </div>

                            <div class="col-xs-1">
                                <label for="form-book-lrelation4">关系</label>
                                <input class="form-control" id="form-book-lrelation4" name="lrelation4"
                                       value="${book.cusLinkList[3].lrelation}"/>
                            </div>

                            <div class="col-xs-2">
                                <label for="form-book-lphone4">手机</label>
                                <input class="form-control" id="form-book-lphone4" name="lphone4"
                                       value="${book.cusLinkList[3].lphone}"/>
                            </div>

                            <div class="col-xs-6">
                                <label for="form-book-lmemo4">备注</label>
                                <input class="form-control" id="form-book-lmemo4" name="lmemo4"
                                       value="${book.cusLinkList[3].lmemo}"/>
                            </div>
                        </div>

                        <!--联系人5-->
                        <div class="space-12"></div>
                        <div class="row">
                            <div class="col-xs-2">
                                <label for="form-book-lname5">姓名</label>
                                <input class="form-control" id="form-book-lname5" name="lname5"
                                       value="${book.cusLinkList[4].lname}">
                            </div>
                            <div class="col-xs-1">
                                <label for="form-book-lsex5">性别</label>
                                <select class="form-control" id="form-book-lsex5" name="lsex5">
                                    <option value="男" selected>男</option>
                                    <option value="女">女</option>
                                </select>
                            </div>

                            <div class="col-xs-1">
                                <label for="form-book-lrelation5">关系</label>
                                <input class="form-control" id="form-book-lrelation5" name="lrelation5"
                                       value="${book.cusLinkList[4].lrelation}"/>
                            </div>

                            <div class="col-xs-2">
                                <label for="form-book-lphone5">手机</label>
                                <input class="form-control" id="form-book-lphone5" name="lphone5"
                                       value="${book.cusLinkList[4].lphone}"/>
                            </div>

                            <div class="col-xs-6">
                                <label for="form-book-lmemo5">备注</label>
                                <input class="form-control" id="form-book-lmemo5" name="lmemo5"
                                       value="${book.cusLinkList[4].lmemo}"/>
                            </div>
                        </div>

                        <!--联系人6-->
                        <div class="space-12"></div>
                        <div class="row">
                            <div class="col-xs-2">
                                <label for="form-book-lname6">姓名</label>
                                <input class="form-control" id="form-book-lname6" name="lname6"
                                       value="${book.cusLinkList[5].lname}">
                            </div>
                            <div class="col-xs-1">
                                <label for="form-book-lsex6">性别</label>
                                <select class="form-control" id="form-book-lsex6" name="lsex6">
                                    <option value="男" selected>男</option>
                                    <option value="女">女</option>
                                </select>
                            </div>

                            <div class="col-xs-1">
                                <label for="form-book-lrelation6">关系</label>
                                <input class="form-control" id="form-book-lrelation6" name="lrelation6"
                                       value="${book.cusLinkList[5].lrelation}"/>
                            </div>

                            <div class="col-xs-2">
                                <label for="form-book-lphone6">手机</label>
                                <input class="form-control" id="form-book-lphone6" name="lphone6"
                                       value="${book.cusLinkList[5].lphone}"/>
                            </div>

                            <div class="col-xs-6">
                                <label for="form-book-lmemo6">备注</label>
                                <input class="form-control" id="form-book-lmemo6" name="lmemo6"
                                       value="${book.cusLinkList[5].lmemo}"/>
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
                        <input type="hidden" name="accessory_id" value="${book.accessory_id}">
                        <div class="row">
                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-book-identity_front">身份证正面<span
                                        class="red">*</span></label>
                                <input type="file" data-rule-required="true" id="form-book-identity_front"
                                       name="identity_front"/>
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-book-identity_reverse">身份证反面<span
                                        class="red">*</span></label>
                                <input type="file" id="form-book-identity_reverse" name="identity_reverse"/>
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-book-identity_inhand">手持身份证<span
                                        class="red">*</span></label>
                                <input type="file" id="form-book-identity_inhand" name="identity_inhand"/>
                            </div>

                            <c:if test="${book == null}">
                                <div class="col-xs-3 form-group">
                                    <label class="control-label" for="form-book-work_card">工作证<span class="red">*</span></label>
                                    <input type="file" id="form-book-work_card" name="work_card"/>
                                </div>

                                <div class="col-xs-3 form-group book_student">
                                    <label class="control-label" for="form-book-student_card">学生证<span
                                            class="red">*</span></label>
                                    <input type="file" id="form-book-student_card" name="student_card"/>
                                </div>
                            </c:if>

                            <c:if test="${book != null && book.type != '1'}">
                                <div class="col-xs-3 form-group">
                                    <label class="control-label" for="form-book-work_card">工作证<span class="red">*</span></label>
                                    <input type="file" id="form-book-work_card" name="work_card"/>
                                </div>
                            </c:if>

                            <c:if test="${book != null && book.type == '1'}">
                                <div class="col-xs-3 form-group">
                                    <label class="control-label" for="form-book-student_card">学生证<span
                                            class="red">*</span></label>
                                    <input type="file" id="form-book-student_card" name="student_card"/>
                                </div>
                            </c:if>
                        </div>

                        <div class="space-12"></div>

                        <div class="row">
                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-book-staff_photo">工作人员合影<span
                                        class="red">*</span></label>
                                <input type="file" id="form-book-staff_photo" name="staff_photo"/>
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-book-bank_card">银行卡<span
                                        class="red">*</span></label>
                                <input type="file" id="form-book-bank_card" name="bank_card"/>
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-book-taobao_address">淘宝收货地址截图<span
                                        class="red">*</span></label>
                                <input type="file" id="form-book-taobao_address" name="taobao_address"/>
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-book-zhifb_zmf">芝麻分查询视频<span class="red">*</span></label>
                                <input type="file" id="form-book-zhifb_zmf" name="zhifb_zmf"/>
                            </div>
                        </div>

                        <div class="space-12"></div>

                        <div class="row">
                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-book-memo_one">通话记录</label>
                                <input type="file" id="form-book-memo_one" name="memo_one"/>
                            </div>
                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="form-book-memo_two">备注文件</label>
                                <input type="file" id="form-book-memo_two" name="memo_two"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <div class="space-20"></div>
            <div class="widget-box">
                <div class="widget-header">
                    <h4 class="widget-title">补全附件信息</h4>
                    <div class="widget-toolbar">
                        <a href="#" data-action="collapse">
                            <i class="ace-icon fa fa-chevron-up"></i>
                        </a>
                    </div>
                </div>
                <div class="widget-body" id="book_must_readjunct">
                    <div class="widget-main" style="min-height: 200px;">
                        <div class="row">
                            <div class="col-xs-4 form-group">
                                <label class="control-label" for="form-book-imei">IMEI截图<span
                                        class="red">*</span></label>
                                <input type="file" data-rule-required="true" id="form-book-imei"
                                       name="imei"/>
                            </div>

                            <div class="col-xs-4 form-group">
                                <label class="control-label" for="form-book-contract_photo">合同拍照<span
                                        class="red">*</span></label>
                                <input type="file" data-rule-required="true" id="form-book-contract_photo"
                                       name="contract_photo"/>
                            </div>

                            <div class="col-xs-4 form-group">
                                <label class="control-label" for="form-book-operation_video">拆机视频<span
                                        class="red">*</span></label>
                                <input type="file" data-rule-required="true" id="form-book-operation_video"
                                       name="operation_video"/>
                            </div>
                        </div>
                    </div>
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

    function openFile(url) {
        var project = window.location.origin;
        window.open(project + "/nginxBookAccesstory/" + url);
    }

    $('.page-content-area').ace_ajax('loadScripts', scripts, function () {
        //获取url中的参数信息
        $(function () {
            $("#validation-form-book").find("input[type!=submit]").attr("readOnly", true);
            $("#validation-form-book").find("select").attr("readOnly", true);
            $("#validation-form-book").find("input[type=file]").attr("disabled", true);

            $("#book-student-flag").on("click", function () {
                if ($(this).is(":checked")) {
                    $(".book_student").show();
                    $(".book_adult").hide();
                    $("#stdorperId").html("学生");
                } else {
                    $(".book_adult").show();
                    $(".book_student").hide();
                    $("#stdorperId").html("成人");
                }
            });

            //如果有book信息，那么所有的框都需要设置为不可编辑状态
            if ('${book.bid}') {
                //设置不可切换学生
                if(${book.type == '1'}) { //表明是学生信息
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
                $("#book-student-flag").attr("disabled", true);
                //初始化值
                $("select[name=sex]").val('${book.sex}');
                $("select[name=leaseterm]").val('${book.leaseterm}');
                $("select[name=family_linkone_sex]").val('${book.family_linkone_sex}');
                $("select[name=family_linktwo_sex]").val('${book.family_linktwo_sex}');
                $("select[name=lsex1]").val('${book.cusLinkList[0].lsex}');
                $("select[name=lsex2]").val('${book.cusLinkList[1].lsex}');
                $("select[name=lsex3]").val('${book.cusLinkList[2].lsex}');
                $("select[name=lsex4]").val('${book.cusLinkList[3].lsex}');
                $("select[name=lsex5]").val('${book.cusLinkList[4].lsex}');
                $("select[name=lsex6]").val('${book.cusLinkList[5].lsex}');
                //设置租期
                $("select[name=leaseterm]").val('${book.leaseterm}');
            }

            //设置日期选择样式
            $('.date-picker').datepicker({
                autoclose: true,
                todayHighlight: true
            });

            $("#form-book-leaseterm").change(function(){
                var leaseterm = $("#form-book-leaseterm").val();
                var totalPrice = $("#form-book-product_price").val();
                if(totalPrice) {
                    //计算每期价格
                    $("#form-book-monthrent").val((totalPrice/leaseterm).toFixed(2));
                    $("#form-book-monthrentrate").val(Math.round(100/leaseterm) + "%");
                }
            });

            $("#form-book-product_price").change(function(){
                var leaseterm = $("#form-book-leaseterm").val();
                var totalPrice = $(this).val()
                if(totalPrice) {
                    //计算每期价格
                    $("#form-book-monthrent").val((totalPrice/leaseterm).toFixed(2));
                    $("#form-book-monthrentrate").val(Math.round(100/leaseterm) + "%");
                }
            })

            $("#validation-form-book").submit(function (e) {
                e.preventDefault();
                var flag = $("#validation-form-book").valid();
                if (flag) {
                    $(this).ajaxSubmit({
                        url: projectUrl + "/book/saveBookInfo",
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
            $("#validation-form-book").validate({
                errorElement: 'div',
                errorClass: 'help-block',
                focusInvalid: false,
                ignore: ":hidden:not(select)",
                rules: {
                    agency_id: {required:true},
                    name: {required: true},
                    phone: {required: true},
                    birth: {required: true},
                    ethnic: {required: true},
                    identity: {required: true, identity: true},
                    place: {required: true},
                    familyphone: {required: true},
                    koseki: {required: true},
                    nowaddress: {required: true},
                    phoneserviceno: {required: true, number: true},
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
                    lmemo1: {required: true},
                    lname2: {required: true},
                    lsex2: {required: true},
                    lrelation2: {required: true},
                    lphone2: {required: true},
                    lmemo2: {required: true},
                    //校验附件信息
                    identity_front: {required: true},
                    identity_reverse: {required: true},
                    identity_inhand: {required: true},
                    work_card: {required: true},
                    student_card: {required: true},
                    staff_photo: {required: true},
                    bank_card: {required: true},
                    taobao_address: {required: true},
                    zhifb_zmf: {required: true},
                    imei: {required: true},
                    contract_photo: {required: true},
                    operation_video: {required: true},
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

            //如果不存在book 信息， 那么就设置该文件能够上传
            if (!'${book.bid}') {
                //身份证正面
                $('#form-book-identity_front').ace_file_input({
                    no_file: '选择文件...',
                    btn_choose: 'Choose',
                    btn_change: 'Change',
                    droppable: true,
                    onchange: null,
                    thumbnail: false //| true | large
                });
                //身份证反面
                $('#form-book-identity_reverse').ace_file_input({
                    no_file: '选择文件...',
                    btn_choose: 'Choose',
                    btn_change: 'Change',
                    droppable: true,
                    onchange: null,
                    thumbnail: false
                });
                //手持身份证
                $('#form-book-identity_inhand').ace_file_input({
                    no_file: '选择文件...',
                    btn_choose: 'Choose',
                    btn_change: 'Change',
                    droppable: true,
                    onchange: null,
                    thumbnail: false
                });
                //工作证明
                $('#form-book-work_card').ace_file_input({
                    no_file: '选择文件...',
                    btn_choose: 'Choose',
                    btn_change: 'Change',
                    droppable: true,
                    onchange: null,
                    thumbnail: false
                });
                //学生证
                $('#form-book-student_card').ace_file_input({
                    no_file: '选择文件...',
                    btn_choose: 'Choose',
                    btn_change: 'Change',
                    droppable: true,
                    onchange: null,
                    thumbnail: false
                });
                //工作人员合影
                $("#form-book-staff_photo").ace_file_input({
                    no_file: '选择文件...',
                    btn_choose: 'Choose',
                    btn_change: 'Change',
                    droppable: true,
                    onchange: null,
                    thumbnail: false
                });
                //银行卡
                $("#form-book-bank_card").ace_file_input({
                    no_file: '选择文件...',
                    btn_choose: 'Choose',
                    btn_change: 'Change',
                    droppable: true,
                    onchange: null,
                    thumbnail: false
                });
                //淘宝收货地址截图
                $("#form-book-taobao_address").ace_file_input({
                    no_file: '选择文件...',
                    btn_choose: 'Choose',
                    btn_change: 'Change',
                    droppable: true,
                    onchange: null,
                    thumbnail: false
                });
                //芝麻分查询视频
                $("#form-book-zhifb_zmf").ace_file_input({
                    no_file: '选择文件...',
                    btn_choose: 'Choose',
                    btn_change: 'Change',
                    droppable: true,
                    onchange: null,
                    thumbnail: false
                });
                //备注文件一
                $("#form-book-memo_one").ace_file_input({
                    no_file: '选择文件...',
                    btn_choose: 'Choose',
                    btn_change: 'Change',
                    droppable: true,
                    onchange: null,
                    thumbnail: false
                });
                //备注文件二
                $("#form-book-memo_two").ace_file_input({
                    no_file: '选择文件...',
                    btn_choose: 'Choose',
                    btn_change: 'Change',
                    droppable: true,
                    onchange: null,
                    thumbnail: false
                });
            } else {
                //直接设置查看
                $('#form-book-identity_front').hide();
                var identity_front = '${book.accessory.identity_front}';
                $('#form-book-identity_front').after('<a onclick="openFile(\''+identity_front+'\')" class="blue2" style="display:block; cursor: pointer">文件已上传，点击查看</a>');
                $('#form-book-identity_reverse').hide();
                var identity_reverse = '${book.accessory.identity_reverse}';
                $('#form-book-identity_reverse').after('<a onclick="openFile(\''+identity_reverse+'\')" class="blue2" style="display:block; cursor: pointer">文件已上传，点击查看</a>');
                $('#form-book-identity_inhand').hide();
                var identity_inhand = '${book.accessory.identity_inhand}';
                $('#form-book-identity_inhand').after('<a onclick="openFile(\''+identity_inhand+'\')" class="blue2" style="display:block; cursor: pointer">文件已上传，点击查看</a>');
                $('#form-book-work_card').hide();
                var work_card = '${book.accessory.work_card}';
                $('#form-book-work_card').after('<a onclick="openFile(\''+work_card+'\')" class="blue2" style="display:block; cursor: pointer">文件已上传，点击查看</a>');
                $('#form-book-student_card').hide();
                var student_card = '${book.accessory.student_card}';
                $('#form-book-student_card').after('<a onclick="openFile(\''+student_card+'\')" class="blue2" style="display:block; cursor: pointer">文件已上传，点击查看</a>');
                $('#form-book-staff_photo').hide();
                var staff_photo = '${book.accessory.staff_photo}';
                $('#form-book-staff_photo').after('<a onclick="openFile(\''+staff_photo+'\')" class="blue2" style="display:block; cursor: pointer">文件已上传，点击查看</a>');
                $('#form-book-bank_card').hide();
                var bank_card = '${book.accessory.bank_card}';
                $('#form-book-bank_card').after('<a onclick="openFile(\''+bank_card+'\')" class="blue2" style="display:block; cursor: pointer">文件已上传，点击查看</a>');
                $('#form-book-zhifb_zmf').hide();
                var zhifb_zmf = '${book.accessory.zhifb_zmf}';
                $('#form-book-zhifb_zmf').after('<a onclick="openFile(\''+zhifb_zmf+'\')" class="blue2" style="display:block; cursor: pointer">文件已上传，点击查看</a>');
                <%--$('#form-book-taobao_address').hide();--%>
                <%--$('#form-book-taobao_address').after("<a href='/nginxBookAccesstory/${book.accessory.taobao_address}' class='blue2 book_img_show' style='display:block;cursor: pointer'>文件已上传，点击查看</a>");--%>
                $('#form-book-taobao_address').hide();
                var taobao_address = '${book.accessory.taobao_address}';
                $('#form-book-taobao_address').after('<a onclick="openFile(\''+taobao_address+'\')" class="blue2" style="display:block; cursor: pointer">文件已上传，点击查看</a>');

                <!--补全的附件-->

                //IMEI截图
                var imei = '${book.accessory.imei}';
                if(imei) {
                    $('#form-book-imei').hide();
                    $('#form-book-imei').after('<a onclick="openFile(\''+imei+'\')" class="blue2" style="display:block; cursor: pointer">文件已上传，点击查看</a>');
                }else{
                    $("#form-book-imei").ace_file_input({
                        no_file: '选择文件...',
                        btn_choose: 'Choose',
                        btn_change: 'Change',
                        droppable: true,
                        onchange: null,
                        thumbnail: false
                    });
                }
                //合同拍照
                var contract_photo = '${book.accessory.contract_photo}';
                if(contract_photo) {
                    $('#form-book-contract_photo').hide();
                    $('#form-book-contract_photo').after('<a onclick="openFile(\''+contract_photo+'\')" class="blue2" style="display:block; cursor: pointer">文件已上传，点击查看</a>');
                }else{
                    $("#form-book-contract_photo").ace_file_input({
                        no_file: '选择文件...',
                        btn_choose: 'Choose',
                        btn_change: 'Change',
                        droppable: true,
                        onchange: null,
                        thumbnail: false
                    });
                }
                //拆机视频
                var operation_video = '${book.accessory.operation_video}';
                if(operation_video) {
                    $('#form-book-operation_video').hide();
                    $('#form-book-operation_video').after('<a onclick="openFile(\''+operation_video+'\')" class="blue2" style="display:block; cursor: pointer">文件已上传，点击查看</a>');
                }else{
                    $("#form-book-operation_video").ace_file_input({
                        no_file: '选择文件...',
                        btn_choose: 'Choose',
                        btn_change: 'Change',
                        droppable: true,
                        onchange: null,
                        thumbnail: false
                    });
                }

                if ('${book.accessory.memo_one}') {
                    $('#form-book-memo_one').hide();
                    var memo_one = '${book.accessory.memo_one}';
                    $('#form-book-memo_one').after('<a onclick="openFile(\''+memo_one+'\')" class="blue2" style="display:block; cursor: pointer">文件已上传，点击查看</a>');
                } else {
                    $('#form-book-memo_one').hide();
                    $('#form-book-memo_one').after("<a class='grey' style='display:block;'>该项没有文件</a>");
                }
                if ('${book.accessory.memo_two}') {
                    $('#form-book-memo_two').hide();
                    var memo_two = '${book.accessory.memo_two}';
                    $('#form-book-memo_two').after('<a onclick="openFile(\''+memo_two+'\')" class="blue2" style="display:block; cursor: pointer">文件已上传，点击查看</a>');
                } else {
                    $('#form-book-memo_two').hide();
                    $('#form-book-memo_two').after("<a class='grey' style='display:block;'>该项没有文件</a>");
                }

                // bindShowBigImg();

                //如果是编辑状态下，那么就可以重新上传文件
                <%--if('${edit}') {--%>
                    <%--$("#book_must_adjunct").find("a").after('<a class="orange reloadbookaccestory" style="cursor: pointer">重新上传</a>');--%>
                <%--}--%>
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

            function bindShowBigImg() {
                var $overflow = '';
                var colorbox_params = {
                    reposition: true,
                    scalePhotos: true,
                    scrolling: false,
                    close: '&times;',
                    previous: '<i class="ace-icon fa fa-arrow-left"></i>',
                    next: '<i class="ace-icon fa fa-arrow-right"></i>',
                    current: '{current} of {total}',
                    // width: '600px', 0px',
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
                $('.book_img_show').colorbox(colorbox_params);
                $("#cboxLoadingGraphic").html("<i class='ace-icon fa fa-spinner orange fa-spin'></i>");//let's add a custom loading icon
            }



            /**
             * 设置选择框
             */
            $("#form-book-agency_id").chosen({allow_single_deselect: true});
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
                    html += '<option value="' + info.aid + '">' + info.aname + '</option>';
                });
                $("#form-book-agency_id").html(html);
                $("#form-book-agency_id").val('${book.agency_id}');
                $("#form-book-agency_id").trigger("chosen:updated");
            }

            $(document).on('settings.ace.chosen', function (e, event_name, event_val) {
                if (event_name != 'sidebar_collapsed') return;
                $('#form-book-agency_id').each(function () {
                    var $this = $(this);
                    $this.next().css({'width': $this.parent().width()});
                })
            });
        });

        //移除显示的dom
        $(document).one('ajaxloadstart.page', function (e) {
            $('#colorbox, #cboxOverlay').remove();
        });
    })
</script>
</body>
</html>
