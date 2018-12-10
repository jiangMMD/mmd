<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>商品维护 - 魔晶</title>
    <link rel="stylesheet" href="assets/css/chosen.css"/>
    <link rel="stylesheet" href="assets/css/bootstrap-datepicker3.css"/>
    <link rel="stylesheet" href="assets/css/bootstrap-timepicker.css"/>
    <link rel="stylesheet" href="assets/css/daterangepicker.css"/>
    <link rel="stylesheet" href="assets/css/bootstrap-datetimepicker.css"/>
    <link rel="stylesheet" href="assets/css/colorbox.css"/>
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
        <form class="form-horizontal" id="validation-form-productsinfo" method="post">
            <input type="hidden" name="pid" value="${productsinfo.pid}">
<%--            <input type="hidden" name="skuId" value="${prodSku.skuId}">--%>

            <div class="space-20"></div>

            <%--//商品信息--%>
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
                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="pname">商品名称<span class="red">*</span></label>
                                <input class="form-control" id="pname" name="pname" value="${productsinfo.pname}">
                            </div>
                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="title">商品标题<span class="red">*</span></label>
                                <input class="form-control" id="title" name="title" value="${productsinfo.title}">
                            </div>
                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="desc">商品简介<span class="red">*</span></label>
                                <input class="form-control" id="desc" name="desc" value="${productsinfo.desc}">
                            </div>

                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="categoryid">商品类别</label>
                                <select name="categoryid" id="categoryid" class="form-control">
                                    <option value=""></option>
                                    <option value="9">手表</option>
                                    <option value="10">项链</option>
                                    <option value="11">包包</option>
                                    <option value="12">香水</option>
                                    <option value="13">纺织品</option>
                                    <option value="14">古玩</option>
                                </select>
                            </div>
                        </div>

                        <div class="space-12"></div>
                        <div class="row">
                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="shopprice">商品价格<span class="red">*</span></label>
                                <input class="form-control" id="shopprice" name="shopprice" placeholder="RMB价格"
                                       onblur="test(this.value);" value="${productsinfo.shopprice}">
                            </div>
                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="shopmmdprice">商品价格</label>
                                <input name="isproportion" class="ace ace-checkbox-2" type="checkbox"/>
                                <input class="form-control" id="shopmmdprice" name="shopmmdprice" placeholder="MMD价格"
                                       value="${productsinfo.shopmmdprice}">
                            </div>
                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="costprice">商品成本价<span class="red">*</span></label>
                                <input class="form-control" id="costprice" name="costprice"
                                       value="${productsinfo.costprice}">
                            </div>
                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="weight">重量<span class="red">*</span></label>
                                <input class="form-control" id="weight" name="weight"
                                       value="${productsinfo.weight}">
                            </div>
                        </div>

                        <div class="space-12"></div>
                        <div class="row">
                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="volume">尺寸<span class="red">*</span></label>
                                <input class="form-control" id="volume" name="volume"
                                       value="${productsinfo.volume}">
                            </div>
                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="inventory">库存<span class="red">*</span></label>
                                <input class="form-control" id="inventory" name="inventory"
                                       value="${productsinfo.inventory}">
                            </div>
                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="sell">销量</label>
                                <input class="form-control" id="sell" name="sell"
                                       value="${productsinfo.sell}">
                            </div>
                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="commentcount">总评论数</label>
                                <input class="form-control" id="commentcount" name="commentcount"
                                       value="${productsinfo.commentcount}">
                            </div>
                        </div>

                        <div class="space-12"></div>
                        <div class="row">
                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="bestcount">好评数</label>
                                <input class="form-control" id="bestcount" name="bestcount"
                                       value="${productsinfo.bestcount}">
                            </div>
                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="mediumccount">中评数</label>
                                <input class="form-control" id="mediumccount" name="mediumccount"
                                       value="${productsinfo.mediumccount}">
                            </div>
                            <div class="col-xs-3 form-group">
                                <label class="control-label" for="badcount">差评数</label>
                                <input class="form-control" id="badcount" name="badcount"
                                       value="${productsinfo.badcount}">
                            </div>

                            <%-- 默认免运费
                             <div class="col-xs-3 form-group" style="float:left">
                                 <label class="control-label" for="expressfee">运费</label>
                                 <input style="float: left" class="form-control" id="expressfee" name="expressfee"
                                        placeholder="不填写默认包邮免快递费"
                                        value="${productsinfo.expressfee}">
                             </div>--%>
                        </div>

                        <div class="space-12"></div>
                        <div class="row">
                            <div class="col-xs-3 form-group">
                                <label class="control-label">首页图<span class="red">*</span></label>
                                <c:if test="${empty productsinfo.homeimg}">
                                    <input type="file" id="prodHomeimgFile" name="prodHomeimgFile" accept="image/*"/>
                                    <ul class="ace-thumbnails clearfix" id="imgFile" style="display: none;">
                                        <li>
                                            <a href="${productsinfo.homeimg}" data-rel="colorbox">
                                                <img width="150" height="150" alt="150x150"
                                                     src="${productsinfo.homeimg}"/>
                                                <div class="text">
                                                    <div class="inner">点击查看详细</div>
                                                </div>
                                            </a>
                                            <div class="tools tools-bottom">
                                                <a href="#" onclick="">
                                                    <i class="ace-icon fa fa-pencil" title="重新上传"
                                                       onclick="delImg('imgFile', 'prodHomeimgFile')"></i>
                                                </a>
                                            </div>
                                        </li>
                                    </ul>
                                </c:if>
                                <c:if test="${!empty productsinfo.homeimg}">
                                    <input type="file" id="prodHomeimgFile" name="prodHomeimgFile"
                                           style="display: none;"/>
                                    <ul class="ace-thumbnails clearfix" id="imgFile">
                                        <li>
                                            <a href="${productsinfo.homeimg}" data-rel="colorbox">
                                                <img width="150" height="150" alt="150x150"
                                                     src="${productsinfo.homeimg}"/>
                                                <div class="text">
                                                    <div class="inner">点击查看详细</div>
                                                </div>
                                            </a>
                                            <div class="tools tools-bottom">
                                                <a href="#" onclick="">
                                                    <i class="ace-icon fa fa-pencil" title="重新上传"
                                                       onclick="delImg('imgFile', 'prodHomeimgFile')"></i>
                                                </a>
                                            </div>
                                        </li>
                                    </ul>
                                </c:if>
                            </div>
                            <div class="col-xs-3 form-group">
                                <label class="control-label">商品参数图<span class="red">*</span></label>
                                <c:if test="${empty productsinfo.paramimg}">
                                    <input multiple="" type="file" id="prodParamimgFile" name="prodParamimgFile"
                                           accept="image/*"/>
                                    <ul class="ace-thumbnails clearfix" id="paramimgFile" style="display: none;">
                                        <li>
                                            <a href="${productsinfo.paramimg}" data-rel="colorbox">
                                                <img width="230" height="106" alt="150x150"
                                                     src="${productsinfo.paramimg}"/>
                                                <div class="text">
                                                    <div class="inner">点击查看详细</div>
                                                </div>
                                            </a>
                                            <div class="tools tools-bottom">
                                                <a href="#" onclick="">
                                                    <i class="ace-icon fa fa-pencil" title="重新上传"
                                                       onclick="delImg('paramimgFile', 'prodParamimgFile')"></i>
                                                </a>
                                            </div>
                                        </li>
                                    </ul>
                                </c:if>
                                <c:if test="${!empty productsinfo.paramimg}">
                                    <input multiple="" type="file" id="prodParamimgFile" name="prodParamimgFile"
                                           style="display: none;" accept="image/*"/>
                                    <ul class="ace-thumbnails clearfix" id="paramimgFile">
                                        <li>
                                            <a href="${productsinfo.paramimg}" data-rel="colorbox">
                                                <img width="230" height="106" alt="150x150"
                                                     src="${productsinfo.paramimg}"/>
                                                <div class="text">
                                                    <div class="inner">点击查看详细</div>
                                                </div>
                                            </a>
                                            <div class="tools tools-bottom">
                                                <a href="#" onclick="">
                                                    <i class="ace-icon fa fa-pencil" title="重新上传"
                                                       onclick="delImg('paramimgFile', 'prodParamimgFile')"></i>
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

            <%--//是否精品等--%>
            <div class="widget-box">
                <div class="widget-body">
                    <div class="widget-main" style="min-height: 80px;">
                        <div class="space-8"></div>
                        <div class="row">
                            <div class="col-xs-3 form-group">
                                <div class="checkbox">
                                    <label>
                                        <input name="isbest" class="ace ace-checkbox-2" type="checkbox"/>
                                        <span class="lbl">&nbsp;&nbsp;精品&nbsp;&nbsp;</span>
                                    </label>
                                </div>
                            </div>
                            <div class="col-xs-3 form-group">
                                <div class="checkbox">
                                    <label>
                                        <input name="ishot" class="ace ace-checkbox-2" type="checkbox"/>
                                        <span class="lbl">&nbsp;&nbsp;热销&nbsp;&nbsp;</span>
                                    </label>
                                </div>
                            </div>
                            <div class="col-xs-3 form-group">
                                <div class="checkbox">
                                    <label>
                                        <input name="isnew" class="ace ace-checkbox-2" type="checkbox"/>
                                        <span class="lbl">&nbsp;&nbsp;新品&nbsp;&nbsp;</span>
                                    </label>
                                </div>
                            </div>
                            <div class="col-xs-3 form-group">
                                <div class="checkbox">
                                    <label>
                                        <input name="isflashview" class="ace ace-checkbox-2" type="checkbox"/>
                                        <span class="lbl">&nbsp;&nbsp;首页轮播&nbsp;&nbsp;</span>
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <%--//产品轮播图--%>
            <div class="widget-box">
                <div class="widget-header">
                    <h4 class="widget-title">产品轮播图</h4>
                    <div class="widget-toolbar">
                        <a href="#" data-action="collapse">
                            <i class="ace-icon fa fa-chevron-up"></i>
                        </a>
                    </div>
                </div>
                <div class="widget-body">
                    <div class="widget-main" style="min-height: 200px;">
                        <div class="space-12"></div>
                        <div class="row">
                            <c:if test="${empty prodCarousal.id}">
                                <c:forEach begin="0" end="3" varStatus="state">
                                    <div class="col-xs-3 form-group">
                                        <label class="control-label">轮播图${state.index + 1}<span class="red">*</span></label>
                                        <input type="file" class="carousalFile" id="prodCarousalFile${state.index + 1}" name="prodCarousalFile${state.index + 1}"
                                               accept="image/*"/>
                                        <ul class="ace-thumbnails clearfix" style="display: none;">
                                            <li>
                                                <a href="${prodCarousal.pdUrl}" data-rel="colorbox">
                                                    <img width="150" height="150" alt="150x150"
                                                         src="${prodCarousal.pdUrl}"/>
                                                    <div class="text">
                                                        <div class="inner">点击查看详细</div>
                                                    </div>
                                                </a>
                                                <div class="tools tools-bottom">
                                                    <a href="#" onclick="">
                                                        <i class="ace-icon fa fa-pencil" title="重新上传"
                                                           onclick="delImg('imgFile${state.index + 1}', 'prodCarousalFile${state.index + 1}')"></i>
                                                    </a>
                                                </div>
                                            </li>
                                        </ul>

                                    </div>
                                </c:forEach>
                            </c:if>

                            <c:if test="${!empty prodCarousal.id}">
                                <c:forEach items="${prodCarousal.id}" var="carousal" varStatus="state">
                                    <div class="col-xs-3 form-group">
                                        <label class="control-label">轮播图${state.index + 1}<span class="red">*</span></label>
                                        <input type="file" id="prodCarousalFile${state.index + 1}" name="prodCarousalFile${state.index + 1}"
                                               style="display: none;"/>
                                        <ul class="ace-thumbnails clearfix" id="imgFile${state.index + 1}">
                                            <li>
                                                <a href="${prodCarousal.pdUrl}" data-rel="colorbox">
                                                    <img width="150" height="150" alt="150x150"
                                                         src="${prodCarousal.pdUrl}"/>
                                                    <div class="text">
                                                        <div class="inner">点击查看详细</div>
                                                    </div>
                                                </a>
                                                <div class="tools tools-bottom">
                                                    <a href="#" onclick="">
                                                        <i class="ace-icon fa fa-pencil" title="重新上传"
                                                           onclick="delImg('imgFile${state.index + 1}', 'prodCarousalFile${state.index + 1}')"></i>
                                                    </a>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                </c:forEach>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>

            <%--//产品服务--%>
            <div class="widget-box">
                <div class="widget-header">
                    <h4 class="widget-title">产品服务</h4>
                    <div class="widget-toolbar">
                        <a href="#" data-action="collapse">
                            <i class="ace-icon fa fa-chevron-up"></i>
                        </a>
                    </div>
                </div>
                <div class="widget-body">
                    <div class="widget-main" style="min-height: 80px;">
                        <div class="space-8"></div>
                        <div class="row">
                            <div class="col-xs-3 form-group">
                                <div class="checkbox">
                                    <label>
                                        <input name="proservice1" class="ace ace-checkbox-2" type="checkbox"/>
                                        <span class="lbl">&nbsp;&nbsp;100%正品&nbsp;&nbsp;</span>
                                    </label>
                                </div>
                            </div>
                            <div class="col-xs-3 form-group">
                                <div class="checkbox">
                                    <label>
                                        <input name="proservice2" class="ace ace-checkbox-2" type="checkbox"/>
                                        <span class="lbl">&nbsp;&nbsp;专业鉴定&nbsp;&nbsp;</span>
                                    </label>
                                </div>
                            </div>
                            <div class="col-xs-3 form-group">
                                <div class="checkbox">
                                    <label>
                                        <input name="proservice3" class="ace ace-checkbox-2" type="checkbox"/>
                                        <span class="lbl">&nbsp;&nbsp;假一赔三&nbsp;&nbsp;</span>
                                    </label>
                                </div>
                            </div>
                            <div class="col-xs-3 form-group">
                                <div class="checkbox">
                                    <label>
                                        <input name="proservice4" class="ace ace-checkbox-2" type="checkbox"/>
                                        <span class="lbl">&nbsp;&nbsp;品质保证&nbsp;&nbsp;</span>
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <%--//产品属性--%>
            <div class="widget-box">
                <div class="widget-header">
                    <h4 class="widget-title">产品属性</h4>
                    <div class="widget-toolbar">
                        <a href="#" data-action="collapse">
                            <i class="ace-icon fa fa-chevron-up"></i>
                        </a>
                    </div>
                </div>
                <div class="widget-body">
                    <div class="widget-main" style="min-height: 200px;">
                        <div class="space-8"></div>
                        <c:forEach begin="0" end="${prodSku.length}" varStatus="state">
                            <div class="row">
                                <div class="col-xs-2 form-group">
                                    <label class="control-label" for="color">颜色</label>
                                    <input class="form-control" id="color" name="color" value="${prodSku.color}">
                                </div>
                                <div class="col-xs-2 form-group">
                                    <label class="control-label" for="size">尺寸</label>
                                    <input class="form-control" id="size" name="color" value="${prodSku.size}">
                                </div>
                                <div class="col-xs-2 form-group">
                                    <label class="control-label" for="material">材质</label>
                                    <input class="form-control" id="material" name="material"
                                           value="${prodSku.material}">
                                </div>
                                <div class="col-xs-2 form-group">
                                    <label class="control-label" for="origin">产地</label>
                                    <input class="form-control" id="origin" name="origin" value="${prodSku.origin}">
                                </div>
                                <div class="col-xs-2 form-group">
                                    <label class="control-label" for="price">价格<span class="red">*</span></label>
                                    <input class="form-control" id="price" name="price" placeholder="RMB价格"
                                           value="${prodSku.price}">
                                </div>
                                <div class="col-xs-2 form-group">
                                    <label class="control-label" for="mmdprice">价格</label>
                                    <input class="form-control" id="mmdprice" name="mmdprice" placeholder="MMD价格"
                                           value="${prodSku.mmdprice}">
                                </div>
                            </div>
                            <div class="space-12"></div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </form>
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


    var shopprice = document.getElementById("shopprice").value;
    document.getElementById("shopmmdprice").value  = shopprice;
    function test (defaultVal) {
        document.getElementById("shopmmdprice").value = defaultVal;
    }

    //删除图片
    function delImg(parentid, id) {
        $("#" + parentid).hide();
        $('#' + id).ace_file_input({
            style: 'well',
            btn_choose: 'Drop files here or click to choose',
            btn_change: null,
            no_icon: 'ace-icon fa fa-cloud-upload',
            droppable: true,
            thumbnail: 'small',
            allowExt: ["jpeg", "jpg", "png", "gif", "bmp"],
            allowMime: ["image/jpg", "image/jpeg", "image/png", "image/gif", "image/bmp"],
            preview_error: function (filename, error_code) {
            }
        }).on('change', function () {
        });
    }

    if('${productsinfo.pid}') {
        $("select[name=categoryid]").val('${productsinfo.categoryid}');
        <%--/* $("select[name=post_id]").val('${requestScope.employee.post_id}');*/--%>

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

            //判断首页和参数图显示情况
            if ('${productsinfo.homeimg}') {
                //如果有logo，那么就显示照片。否则不显示
                $("#prodHomeimgFile").hide();
                $("#imgFile").show();
            } else {
                $("#prodHomeimgFile").show();
                $("#imgFile").hide();
            }
            if ('${productsinfo.paramimg}') {
                //如果有logo，那么就显示照片。否则不显示
                $("#prodParamimgFile").hide();
                $("#paramimgFile").show();
            } else {
                $("#prodParamimgFile").show();
                $("#paramimgFile").hide();
            }

            //判断轮播图显示情况
            if ('${productsinfo}') {
                $("#prodHomeimgFile${state.index + 1}").hide();
                $("#imgFile${state.index + 1}").show();
            } else {
                $("#prodHomeimgFile${state.index + 1}").show();
                $("#imgFile${state.index + 1}").hide();
            }

        });

        if (!'${productsinfo.pid}') {
            $('input[type=file]').ace_file_input({
                style: 'well',
                btn_choose: 'Drop files here or click to choose',
                btn_change: null,
                no_icon: 'ace-icon fa fa-cloud-upload',
                droppable: true,
                thumbnail: 'small',
                allowExt: ["jpeg", "jpg", "png", "gif", "bmp"],
                allowMime: ["image/jpg", "image/jpeg", "image/png", "image/gif", "image/bmp"],
                preview_error: function (filename, error_code) {
                }
            }).on('change', function () {
            });
        }


        $("#validation-form-productsinfo").submit(function (e) {
            e.preventDefault();
            var flag = $("#validation-form-productsinfo").valid();
            if (flag) {
                $(this).ajaxSubmit({
                    url: projectUrl + "/business/addOrUpdBusiness",
                    type: "post",
                    beforeSubmit: function () {
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
                        $(".progress").attr("data-percent", percentComplete + "%");
                        $(".progress-bar").css("width", percentComplete + "%");
                    },
                    success: function (result) {
                        bootbox.hideAll();
                        if (result.code === 1) {
                            showInfo("操作成功! 即将返回主列表")
                            $("#user_save_info").hide();
                            setTimeout(function () {
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
        $("#validation-form-productsinfo").validate({
            errorElement: 'div',
            errorClass: 'help-block',
            focusInvalid: false,
            ignore: ":hidden:not(select)",
            rules: {
                pname: {required: true},
                title: {required: true},
                desc: {required: true},
                homeimg: {required: true},
                paramimg: {required: true},
                weight: {number: true, required: true},
                volume: {required: true},
                inventory: {number: true, required: true},
                costprice: {number: true, required: true},
                categoryid: {required: true},
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
                }
                ;
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


