<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>购物车</title>
    <link rel="stylesheet" href="assets/css/chosen.css"/>
    <link rel="stylesheet" href="assets/css/bootstrap-datepicker3.css"/>
    <link rel="stylesheet" href="assets/css/bootstrap-timepicker.css"/>
    <link rel="stylesheet" href="assets/css/daterangepicker.css"/>
    <link rel="stylesheet" href="assets/css/colorbox.css"/>
    <link rel="stylesheet" href="assets/css/bootstrap-datetimepicker.css"/>
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
        <form class="form-horizontal" method="post">
            <input type="hidden" name="catId" value="${shopdetail.catId}">

            <div class="space-20"></div>

            <div class="widget-box">
                <div class="widget-header">
                    <h4 class="widget-title">购物车</h4>
                    <%--<div class="widget-toolbar">
                        <a href="#" data-action="collapse">
                            <i class="ace-icon fa fa-chevron-up"></i>s
                        </a>
                    </div>--%>
                    <div class="widget-toolbar">
                        <span class="badge badge-info">RMB:&nbsp;&nbsp;${shopdetail.rmbmoney}</span>&nbsp;&nbsp;&nbsp;
                        <span class="badge badge-info">MMD:&nbsp;&nbsp;${shopdetail.mmdmoney}</span>
                    </div>
                </div>
                <div class="widget-body">
                    <c:if test="${empty shopdetail.merNameList}"><div class="space-20"></div><div class="space-20"></div>
                        <div style="text-align: center"><span class="label label-info arrowed-in arrowed-in-right" style="font-size: 20px;height: 40px;">购物车为空</span></div></c:if>
                    <div class="widget-main" style="min-height: 200px;">
                        <c:forEach items="${shopdetail.merNameList}" varStatus="state" var="merInfo">
                            <div class="widget-box widget-color-blue2">
                                <!-- #section:custom/widget-box.options -->
                                <div class="widget-header">
                                    <h5 class="widget-title bigger lighter">
                                        <i class="ace-icon fa fa-table"></i>
                                            ${merInfo.merName}
                                    </h5>
                                    <div class="widget-toolbar widget-toolbar-light no-border">
                                        <select id="simple-colorpicker-1" class="hide">
                                            <option selected="" data-class="blue" value="#307ECC">#307ECC</option>
                                            <option data-class="blue2" value="#5090C1">#5090C1</option>
                                            <option data-class="blue3" value="#6379AA">#6379AA</option>
                                            <option data-class="green" value="#82AF6F">#82AF6F</option>
                                            <option data-class="green2" value="#2E8965">#2E8965</option>
                                            <option data-class="green3" value="#5FBC47">#5FBC47</option>
                                            <option data-class="red" value="#E2755F">#E2755F</option>
                                            <option data-class="red2" value="#E04141">#E04141</option>
                                            <option data-class="red3" value="#D15B47">#D15B47</option>
                                            <option data-class="orange" value="#FFC657">#FFC657</option>
                                            <option data-class="purple" value="#7E6EB0">#7E6EB0</option>
                                            <option data-class="pink" value="#CE6F9E">#CE6F9E</option>
                                            <option data-class="dark" value="#404040">#404040</option>
                                            <option data-class="grey" value="#848484">#848484</option>
                                            <option data-class="default" value="#EEE">#EEE</option>
                                        </select>
                                    </div>
                                </div>
                                <!-- /section:custom/widget-box.options -->
                                <div class="widget-body">
                                    <div class="widget-main no-padding">
                                        <table class="table table-striped table-bordered table-hover">
                                            <thead class="thin-border-bottom">
                                            <tr>
                                                <th width="20%">
                                                    商品名称
                                                </th>
                                                <th width="20%">
                                                    属性
                                                </th>
                                                <th width="20%">
                                                    首页图
                                                </th>
                                                <th width="15%">RMB单价</th>
                                                <th width="15%">MMD单价</th>
                                                <th width="10%">数量</th>
                                            </tr>
                                            </thead>

                                            <tbody>
                                            <c:forEach items="${merInfo.prodList}" varStatus="prodstate" var="prod">
                                                <tr>
                                                    <td class="">${prod.pname}</td>
                                                    <td class="">${prod.skuValname}</td>
                                                    <td>
                                                        <img id="homeimg" src="${prod.homeimg}" width="50px"
                                                             height="50px"
                                                             onclick="javascript:window.open(this.src)">
                                                    </td>

                                                    <td>
                                                        <a href="#">${prod.shopprice}</a>
                                                    </td>

                                                    <td>
                                                        <a href="#">${prod.shopmmdprice}</a>
                                                    </td>

                                                    <td>
                                                        <a href="#">${prod.num}</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div class="space-12"></div>
                        </c:forEach>
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

            $('[data-rel=popover]').popover({container: 'body'});

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

            if ('${requestScope.employee.id}') {
                $("select[name=sex]").val('${requestScope.employee.sex}');
                $("select[name=depId]").val('${employee.depId}');
                <%--/* $("select[name=post_id]").val('${requestScope.employee.post_id}');*/--%>

            }
        });

        $('#simple-colorpicker-1').ace_colorpicker({pull_right: true}).on('change', function () {
            var color_class = $(this).find('option:selected').data('class');
            var new_class = 'widget-box';
            if (color_class != 'default') new_class += ' widget-color-' + color_class;
            $(this).closest('.widget-box').attr('class', new_class);
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


