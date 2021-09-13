<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="/js/jquery-1.11.1-min.js"></script>
    <script type="text/javascript" src="/js/queryyzd.js"></script>
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
            $("#search").click(function () {
                queryDataList(1,5);
            })
        })

    </script>
</head>
<body>



<div style="position: relative; height: 100%;">
    <div class="btn-toolbar" role="toolbar" style="height: 80px; padding: 0 20px">
        <form role="form" action="/report/yzd/export.do" method="post" style="position: relative; top: 8%; left: 5px;font-size: medium" id="queryForm" target="iframe">
            <div class="row">
                <div class="form-group col-xs-3">
                    <div class="input-group input-group-sm" style="position: relative;">
                        <div class="input-group-addon" style="color: blue">
                            书名
                        </div>
                        <input class="form-control" type="text" id="query-shum">
                    </div>
                </div>

                <div class="form-group col-xs-3">
                    <div class="input-group input-group-sm" style="position: relative;">
                        <div class="input-group-addon" style="color: blue">付印单号</div>
                        <input class="form-control" type="text" id="query-fydh">
                    </div>
                </div>

                <div class="form-group col-xs-3">
                    <div class="input-group input-group-sm" style="position: relative;">
                        <div class="input-group-addon" style="color: blue">图书分类名称</div>
                        <input class="form-control" type="text" id="query-tsflmc">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-xs-3 col-md-3">
                    <div class="input-group input-group-sm" style="position: relative;">
                        <div class="input-group-addon" style="color: blue">开始日期</div>
                        <input class="form-control" type="date" id="query-startdate">
                    </div>
                </div>
                <div class="form-group col-xs-3 col-md-3">
                    <div class="input-group input-group-sm" style="position: relative;">
                        <div class="input-group-addon" style="color: blue">结束日期</div>
                        <input class="form-control" type="date" id="query-enddate">
                    </div>
                </div>
                <div class="form-group col-xs-6">
                    <button type="button" class="btn btn-primary btn-sm" id="search">
                        <span class="glyphicon glyphicon-search" aria-hidden="true">查询</span>
                    </button>
                </div>

            </div>
        </form>
        <iframe id="iframe" name="iframe" style="display:none;"></iframe>
    </div>
    <hr>
    <div style="position: relative;top: 20px; font-size: medium">
        <table class="table table-hover">
            <thead>
                <tr style="color: blue; font-size: x-small">
                    <th>序号</th>
                    <th>填写日期</th>
                    <th>印完日期</th>
                    <th>书名</th>
                    <th>自编号</th>
                    <th>印厂</th>
                    <th>书序号</th>
                    <th>付印单号</th>
                    <th>订单数量</th>
                    <th>已收册数</th>
                </tr>
            </thead>
            <tbody id="yzdtbody"></tbody>
<%--            <tfoot id="yzdtfoot"></tfoot>--%>
        </table>
    </div>

    <div style="height: 50px; position: relative; top:30px">
        <div id="yzdPage"></div>
    </div>
</div>

</body>
</html>
