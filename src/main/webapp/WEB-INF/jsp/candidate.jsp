<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="/js/jquery-1.11.1-min.js"></script>
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

            $("#export").click(function () {
                $("#queryForm").submit();
            })

            $("#search").click(function () {
                if ($.trim($("#startdate").val()) == '') {
                    alert("开始日期必须输入");
                    $("#startdate").focus();
                    return false;
                }
                if ($.trim($("#enddate").val()) == '') {
                    alert("结束日期必须输入");
                    $("#enddate").focus();
                    return false;
                }
                $.ajax({
                    url : "/hr/candidate/list.do",
                    data : {
                        "username" : $.trim($("#username").val()),
                        "candidate" : $.trim($("#candidate").val()),
                        "startdate" : $.trim($("#startdate").val()),
                        "enddate" : $.trim($("#enddate").val()),
                    },
                    type : "post",
                    dataType : "json",
                    success : function(data) {
                        var tbodyHtml = "";
                        $.each(data.list,function(i,item) {
                            tbodyHtml += '<tr class="active" style="font-size: xx-small">';
                            tbodyHtml += '<td>' + (i + 1) +'</td>';
                            tbodyHtml += '<td>' + item.createdate +'</td>';
                            tbodyHtml += '<td>' + item.username +'</td>';
                            tbodyHtml += '<td>' + item.sitename +'</td>';
                            tbodyHtml += '<td>' + item.candidate +'</td>';
                            tbodyHtml += '<td>' + item.jobtitle +'</td>';
                            tbodyHtml += '<td>' + item.mobile +'</td>';
                            tbodyHtml += '<td>' + item.appointdate +'</td>';
                            tbodyHtml += '<td>' + item.appointtime +'</td>';
                            tbodyHtml += '</tr>';

                        })
                        $("#candidatetbody").html(tbodyHtml);
                        // var tfootHtml = '<tr class="active" style="font-size: small">';
                        // tfootHtml += '<td colspan="4" align="center" style="color: blue">汇总</td>';
                        // tfootHtml += '<td>' + data.zqckc +'</td>';
                        // tfootHtml += '<td>' + data.zqmkc +'</td>';
                        // tfootHtml += '<td>' + data.zxscs +'</td>';
                        // tfootHtml += '<td>--</td>';
                        // tfootHtml += '<td>--</td>';
                        // tfootHtml += '</tr>';
                        // $("#itemtfoot").html(tfootHtml);
                    }
                })

            })
        })

    </script>
</head>
<body>
<!-- 创建市场活动的模态窗口 -->
<div class="modal fade" id="addModal" role="dialog">
    <div class="modal-dialog" role="document" style="width: 85%;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalLabel1">新增应聘人员</h4>
            </div>
            <div class="modal-body">

                <form class="form-horizontal" role="form">

                    <div class="form-group">
                        <label for="create-marketActivityOwner" class="col-sm-2 control-label">登记人<span style="font-size: 15px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 300px;">
                            <select class="form-control" id="create-marketActivityOwner">
                                <option>左传茹</option>
                                <option>张翠环</option>
                                <option>崔顽勇</option>
                            </select>
                        </div>
                        <label for="create-marketActivityName" class="col-sm-2 control-label">名称<span style="font-size: 15px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="create-marketActivityName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="create-marketActivityOwner" class="col-sm-2 control-label">来源<span style="font-size: 15px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 300px;">
                            <select class="form-control" id="sitename">
                                <option>智联</option>
                                <option>boss</option>
                                <option>其他</option>
                            </select>
                        </div>
                        <label for="create-marketActivityName" class="col-sm-2 control-label">应聘人姓名<span style="font-size: 15px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="candidate">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="create-startTime" class="col-sm-2 control-label">开始日期</label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="create-startTime">
                        </div>
                        <label for="create-endTime" class="col-sm-2 control-label">结束日期</label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="create-endTime">
                        </div>
                    </div>
                    <div class="form-group">

                        <label for="create-cost" class="col-sm-2 control-label">成本</label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="create-cost">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="create-describe" class="col-sm-2 control-label">描述</label>
                        <div class="col-sm-10" style="width: 81%;">
                            <textarea class="form-control" rows="3" id="create-describe"></textarea>
                        </div>
                    </div>

                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal">保存</button>
            </div>
        </div>
    </div>
</div>

<div style="position: relative; height: 100%;">
    <div class="btn-toolbar" role="toolbar" style="height: 80px; padding: 0 20px">
        <form role="form" action="/report/candidate/export.do" method="post" style="position: relative; top: 8%; left: 5px;font-size: medium" id="queryForm" target="iframe">
            <div class="row">
                <div class="form-group col-xs-3">
                    <div class="input-group" style="position: relative;">
                        <div class="input-group-addon" style="color: blue">
                            登记人
                        </div>
                        <input class="form-control" type="text" name="username" id="username">
                    </div>
                </div>

                <div class="form-group col-xs-3">
                    <div class="input-group" style="position: relative;">
                        <div class="input-group-addon" style="color: blue">应聘人姓名</div>
                        <input class="form-control" type="text" name="candidate" id="candidate">
                    </div>
                </div>

                <div class="form-group col-xs-3">
                    <div class="input-group" style="position: relative;">
                        <div class="input-group-addon" style="color: blue">岗位分类</div>
                        <input class="form-control" type="text" name="jobtype" id="jobtype">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-xs-3 col-md-3">
                    <div class="input-group" style="position: relative;">
                        <div class="input-group-addon" style="color: blue">开始日期</div>
                        <input class="form-control" type="date" name="startdate" id="startdate">
                    </div>
                </div>
                <div class="form-group col-xs-3 col-md-3">
                    <div class="input-group" style="position: relative;">
                        <div class="input-group-addon" style="color: blue">结束日期</div>
                        <input class="form-control" type="date" name="enddate" id="enddate">
                    </div>
                </div>
                <div class="form-group col-xs-1">
                    <button type="button" class="btn btn-primary" id="search"> 查 询</button>
                </div>
                <div class="form-group col-xs-1">
                    <button type="button" class="btn btn-success" data-toggle="modal" data-target="#addModal" id="add"> 新 增</button>
                </div>

                <div class="form-group col-xs-1">
                    <button type="button" class="btn btn-info"  id="export"> 导出Excel</button>
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
                <td>序号</td>
                <td>登记日期</td>
                <td>登记人</td>
                <td>来源</td>
                <td>姓名</td>
                <td>岗位</td>
                <td>电话</td>
                <td>预约日期</td>
                <td>预约时间</td>
                <td>到面</td>
                <td>视频</td>
                <td>面试官</td>
                <td>通过</td>
                <td>视频</td>
                <td>面试官</td>
                <td>通过</td>
                <td>愿意入职</td>
                <td>报道时间</td>
                <td>原因</td>
                <td>备注</td>
            </tr>
            </thead>
            <tbody id="candidatetbody"></tbody>
<%--            <tfoot id="candidatetfoot"></tfoot>--%>
        </table>
    </div>

</div>


</body>
</html>
