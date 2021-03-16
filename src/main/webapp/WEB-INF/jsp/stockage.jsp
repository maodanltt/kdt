<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="/js/jquery-1.11.1-min.js"></script>
    <script type="text/javascript" src="/js/querystockage.js"></script>
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

            $("#search").click(function () {
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
                <td>书名</td>
                <td>图书分类</td>
                <td>编辑部</td>
                <td>印次</td>
                <td>当前库存</td>
                <td>0-30天</td>
                <td>31-60天</td>
                <td>61-180天</td>
                <td>181-365天</td>
                <td>1-2年</td>
                <td>2-3年</td>
                <td>3年以上</td>
            </tr>
            </thead>
            <tbody id="stockagebody"></tbody>
        </table>
    </div>

    <div style="height: 50px; position: relative; top:30px">
        <div id="activityPage"></div>
    </div>

</div>


</body>
</html>
