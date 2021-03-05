<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="/js/jquery-1.11.1-min.js"></script>
    <script type="text/javascript" src="/js/query.js"></script>
    <link href="/js/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <link href="/js/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="/js/bootstrap_3.3.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
    <script type="text/javascript" src="/js/bootstrap-datetimepicker-master/locale/bootstrap-datetimepicker.zh-CN.js"></script>
    <link rel="stylesheet" type="text/css" href="/js/bs_pagination/jquery.bs_pagination.min.css">
    <script type="text/javascript" src="/js/bs_pagination/jquery.bs_pagination.min.js"></script>
    <script type="text/javascript" src="/js/bs_pagination/en.js"></script>


    <script type="text/javascript">
        $(function () {

            $.ajax({
                url: "/search/queryKhmcList.do",
                type: "get",
                dataType: "json",
                success: function (khmcdata) {
                    $("#khmc").keyup(function () {
                        keyupcallback(this, $("#khmctip")[0], khmcdata)
                    });
                }
            })

            $.ajax({
                url: "/search/queryTsfljcList.do",
                type: "get",
                dataType: "json",
                success: function (tsfljcdata) {
                    $("#tsfljc").keyup(function () {
                        keyupcallback(this, $("#tsfljctip")[0], tsfljcdata)
                    });
                }
            })

            $.ajax({
                url: "/search/queryShumList.do",
                type: "get",
                dataType: "json",
                success: function (shumdata) {
                    $("#shum").keyup(function () {
                        keyupcallback(this, $("#shumtip")[0], shumdata)
                    });
                }
            })

            $.ajax({
                url: "/search/queryDqjlList.do",
                type: "get",
                dataType: "json",
                success: function (dqjldata) {
                    $("#dqjl").keyup(function () {
                        keyupcallback(this, $("#dqjltip")[0], dqjldata)
                    });
                }
            })

            $.ajax({
                url: "/search/queryDqList.do",
                type: "get",
                dataType: "json",
                success: function (dqdata) {
                    $("#dq").keyup(function () {
                        keyupcallback(this, $("#dqtip")[0], dqdata)
                    });
                }
            })

            $("#search").click(function () {
                if ($.trim($("#startdate").val()) == '') {
                    alert("开始日期必须输入");
                    $("#startdate").focus();
                    return false;
                }

                if ($.trim($("#startdate").val()) < '2020-01-01') {
                    alert("可查询2020年之后的数据，请修改开始日期");
                    $("#startdate").focus();
                    return false;
                }

                if ($.trim($("#enddate").val()) == '') {
                    alert("结束日期必须输入");
                    $("#enddate").focus();
                    return false;
                }

                if ($.trim($("#enddate").val()) > nowDate()) {
                    alert("结束日期不能大于当前日期");
                    $("#enddate").focus();
                    return false;
                }

                // queryDataList(1,20);
                queryDataList(1,20)

            })

        })

    </script>
    <style>
        .input-tips {
            background-color: white;
            border: 1px solid cadetblue;
            width: 100%;
            top: 34px;
            left: 0;
            max-height: 300px;
            overflow: auto;
            display: none;
            position: absolute;
            z-index: 100
        }
    </style>
</head>
<body>

<div style="position: relative; height: 100%;">

    <div class="btn-toolbar" role="toolbar" style="height: 80px; padding: 0 20px">
        <form role="form" style="position: relative; top: 8%; left: 5px;font-size: small">
            <div class="row">
                <div class="form-group col-xs-4">
                    <div class="input-group" style="position: relative;">
                        <div class="input-group-addon" style="color: blue">客户名称</div>
                        <input class="form-control" type="text" name="khmc" id="khmc">
                        <div id="khmctip" class="input-tips"></div>
                    </div>
                </div>

                <div class="form-group col-xs-5">
                    <div class="input-group" style="position: relative;">
                        <div class="input-group-addon" style="color: blue">
                            书名
                        </div>
                        <input class="form-control" type="text" name="shum" id="shum">
                        <div id="shumtip" class="input-tips"></div>
                    </div>
                </div>

                <div class="form-group col-xs-3">
                    <div class="input-group" style="position: relative;">
                        <div class="input-group-addon" style="color: blue">图书分类</div>
                        <input class="form-control" type="text" name="tsfljc" id="tsfljc">
                        <div id="tsfljctip" class="input-tips"></div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-xs-3 col-md-2">
                    <div class="input-group" style="position: relative;">
                        <div class="input-group-addon" style="color: blue">印次</div>
                        <input class="form-control" type="text" name="zbh" id="zbh">
                    </div>
                </div>
                <div class="form-group col-xs-3 col-md-3">
                    <div class="input-group" style="position: relative;">
                        <div class="input-group-addon" style="color: blue">编辑部门</div>
                        <input class="form-control" type="text" name="bmmc" id="bmmc">
                    </div>
                </div>
                <div class="form-group col-xs-3 col-md-2">
                    <div class="input-group" style="position: relative;">
                        <div class="input-group-addon" style="color: blue">单据类型</div>
                        <select class="form-control" name="djlx" id="djlx">
                            <option value="批发">批发</option>
                            <option value="赠送">赠送</option>
                            <option value="退货">退货</option>
                        </select>
                    </div>
                </div>
                <div class="form-group col-xs-3 col-md-2">
                    <div class="input-group" style="position: relative;">
                        <div class="input-group-addon" style="color: blue">大区经理</div>
                        <input class="form-control" type="text" name="dqjl" id="dqjl">
                        <div id="dqjltip" class="input-tips"></div>
                    </div>
                </div>
                <div class="form-group col-xs-3 col-md-2">
                    <div class="input-group" style="position: relative;">
                        <div class="input-group-addon" style="color: blue">
                            地&nbsp;&nbsp;区
                        </div>
                        <input class="form-control" type="text" name="dq" id="dq">
                        <div id="dqtip" class="input-tips"></div>
                    </div>
                </div>
                <div class="form-group col-xs-4 col-md-3">
                    <div class="input-group" style="position: relative;">
                        <div class="input-group-addon" style="color: blue">开始日期</div>
                        <input class="form-control" type="date" id="startdate" name="startdate"/>
                    </div>
                </div>
                <div class="form-group col-xs-4 col-md-3">
                    <div class="input-group" style="position: relative;">
                        <div class="input-group-addon" style="color: blue">结束日期</div>
                        <input class="form-control" type="date" id="enddate" name="enddate">
                    </div>
                </div>
                <div class="form-group col-xs-2">
                    <button type="button" class="btn btn-default" style="color: blue" id="search"> 查 询</button>
                </div>
            </div>
        </form>
    </div>
    <hr>

    <div style="position: relative;top: 20px; font-size: small">
        <table class="table table-hover">
            <thead>
            <tr style="color: blue; font-size: xx-small">
                <td>序</td>
                <td>发货单号</td>
                <td>客户名称</td>
                <td>制单日期</td>
                <td>书名</td>
                <td>印次</td>
                <td>定价</td>
                <td>册数</td>
                <td>码洋</td>
                <td>折扣</td>
                <td>实洋</td>
                <td>大区经理</td>
                <td>地区</td>
            </tr>
            </thead>
            <tbody id="itemtbody"></tbody>
        </table>
    </div>

    <div style="height: 50px; position: relative; top:30px">
        <div id="activityPage"></div>
    </div>

</div>


</body>
</html>
