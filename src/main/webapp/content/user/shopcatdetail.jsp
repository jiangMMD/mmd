<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>购物车</title>
    <link rel="stylesheet" href="assets/css/chosen.css"/>
    <link rel="stylesheet" href="assets/css/bootstrap-datepicker3.css" />
    <link rel="stylesheet" href="assets/css/bootstrap-timepicker.css" />
    <link rel="stylesheet" href="assets/css/daterangepicker.css" />
    <link rel="stylesheet" href="assets/css/colorbox.css"/>
    <link rel="stylesheet" href="assets/css/bootstrap-datetimepicker.css" />
    <style>
        .form-group {
            margin-left: 0 !important;
            margin-right: 0 !important;
            margin-bottom: 0 !important;
        }
    </style>
    <script>
        console.log('${shopdetail.catId}')
    </script>
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
        <form class="form-horizontal"  method="post">
            <input type="hidden" name="catId" value="${shopdetail.catId}">

            <div class="space-20"></div>

            <div class="widget-box">
                <div class="widget-header">
                    <h4 class="widget-title">购物车详情</h4>
                    <div class="widget-toolbar">
                        <a href="#" data-action="collapse">
                            <i class="ace-icon fa fa-chevron-up"></i>s
                        </a>
                    </div>
                </div>
                <div class="widget-body">
                    <div class="widget-main" style="min-height: 200px;">
                        <div class="row">
                            <c:forEach items="${shopdetail.merNameList}" varStatus="state" var="merInfo">
                                <div class="row">
                                    <label class="control-label">商家</label>
                                    <input class="form-control" readonly="readonly" name="merName"
                                           value="${merInfo.merName}">
                                    <c:forEach items="${merInfo.prodList}" varStatus="prodstate" var="prod">
                                    <div class="col-xs-3 form-group">
                                        <label class="control-label">商品名称</label>
                                        <input class="form-control" readonly="readonly" name="pname"
                                               value="${prod.pname}">
                                    </div>
                                    <div class="col-xs-3 form-group">
                                        <label class="control-label">首页图</label>
                                        <input type="file"  name="proHomeimg">
                                        <ul class="ace-thumbnails clearfix" style="display: none;">
                                            <li>
                                                <a href="${prod.homeimg}" data-rel="colorbox">
                                                    <img width="150" height="150" alt="150x150"
                                                         src="${prod.homeimg}"/>
                                                    <div class="text">
                                                        <div class="inner">点击查看详细</div>
                                                    </div>
                                                </a>
                                                <div class="tools tools-bottom">
                                                   <%-- <a href="#" onclick="">
                                                        <i class="ace-icon fa fa-pencil" title="重新上传"
                                                           onclick="delImg('imgFile${state.index + 1}', 'prodCarousalFile${state.index + 1}')"></i>
                                                    </a>--%>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="col-xs-3 form-group">
                                        <label class="control-label">RMB价格</label>
                                        <input class="form-control" readonly="readonly" name="shopprice"
                                               value="${prod.shopprice}">
                                    </div>
                                    <div class="col-xs-3 form-group">
                                        <label class="control-label">MMB价格</label>
                                        <input class="form-control" readonly="readonly" name="shopmmdprice"
                                               value="${prod.shopmmdprice}">
                                    </div>
                                    </c:forEach>
                                </div>
                                <div class="space-12"></div>
                            </c:forEach>
                        </div>
                        <div class="col-xs-3 form-group">
                            <label class="control-label">RMB总价</label>
                            <input class="form-control" readonly="readonly" name="shopprice"
                                   value="${shopdetail.shopprice}">
                        </div>
                        <div class="col-xs-3 form-group">
                            <label class="control-label">MMB总价</label>
                            <input class="form-control" readonly="readonly" name="shopmmdprice"
                                   value="${shopdetail.shopmmdprice}">
                        </div>
                    </div>
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

            // myAjax("/base/getAllAgency", null, function(result){
            //     if(result.code === 1) {
            //         createSelect(result.data);
            //     }else{
            //         showErrorInfo(result.message);
            //     }
            // });
            function createSelect(data) {
                var html = '<option value="">&nbsp;</option>';
                <%--var agency_ids = '${requestScope.employee.agency_ids}';--%>
                <%--data.forEach(function (info) {--%>
                <%--if(agency_ids) {--%>
                <%--if((','+agency_ids+',').indexOf(','+info.aid+',') > -1) {--%>
                <%--html += '<option selected value="' + info.aid + '">'+info.agency_cityname+'----' + info.aname + '</option>';--%>
                <%--}else{--%>
                <%--html += '<option  value="' + info.aid + '">'+info.agency_cityname+'----' + info.aname + '</option>';--%>
                <%--}--%>
                <%--}else{--%>
                <%--html += '<option value="' + info.aid + '">'+info.agency_cityname+'----' + info.aname + '</option>';--%>
                <%--}--%>
                <%--});--%>
                // $("#form-emplyee-agency_ids").html(html);
                $(".chosen-select").trigger("chosen:updated");
            }

            if('${requestScope.employee.id}') {
                $("select[name=sex]").val('${requestScope.employee.sex}');
                $("select[name=depId]").val('${employee.depId}');
                <%--/* $("select[name=post_id]").val('${requestScope.employee.post_id}');*/--%>

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


