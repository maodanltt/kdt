<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">

    <link href="/js/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <link href="/js/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="/js/query.js"></script>
    <script type="text/javascript" src="/js/bootstrap_3.3.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
    <script type="text/javascript" src="/js/bootstrap-datetimepicker-master/locale/bootstrap-datetimepicker.zh-CN.js"></script>
    <script type="text/javascript">
    </script>
</head>
<body>
    <div font-size: small">
        <table>
            <tr style="font-size: medium">
                <td>书    名 : </td>
                <td>全国各类成人高等学校招生考试真题汇编及全真模拟：《英语（专科起点升本科）》</td>
            </tr>
            <tr style="font-size: medium">
                <td>物 流 码 : </td>
                <td>20200808</td>
            </tr>
            <tr style="font-size: medium">
                <td>当前库存 : </td>
                <td>3000</td>
            </tr>
        </table>
    </div>
    <hr>
    <div style="position: relative; height: 100%;">
        <div style="position: relative;top: 20px; font-size: small">
            <table class="table table-hover">
                <thead>
                    <tr style="color: blue; font-size: small">
                        <td>序</td>
                        <td>入库单号</td>
                        <td>入库日期</td>
                        <td>供应商名称</td>
                        <td>册数</td>
                    </tr>
                </thead>
                <tbody id="itemtbody">
                    <tr class="active" style="color: blue; font-size: small">
                        <td>1</td>
                        <td>CGRK20210000007</td>
                        <td>2021-03-01</td>
                        <td>河南天一文化传播股份有限公司</td>
                        <td>35</td>
                    </tr>
                    <tr class="active" style="color: blue; font-size: small">
                        <td colspan="4" align="center">汇总</td>
                        <td>35</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
