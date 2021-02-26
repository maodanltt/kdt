<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>销售明细查询</title>
</head>
<script type="text/javascript" src="/js/jquery-3.4.1.js"></script>
<script type="text/javascript">
    $(function () {
        $("#shum").onkeyup(function () {
            if ($("#shum").val() == '') {
                $("#shumtip").css("display","none");
                return;
            }
            $.ajax({
                url : "",
                data : "",
                type : "",
                dataType : "",
                success : function (data) {

                }
            })
        })
    })
</script>
<body>
    书名：<input type="text" name="shum" id="shum">
    <div id="shumtip" style="background-color:white; border: 1px solid red;width:128px;position: absolute;top: 133px;left:944px;display:none" >
    </div>
</body>
</html>
