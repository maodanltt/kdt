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

            $("#save").click(function () {
                $.ajax({
                    url : "/hr/candidate/add.do",
                    data : {
                        "username" : $.trim($("#username").val()),
                        "sitename" : $.trim($("#sitename").val()),
                        "candidate" : $.trim($("#candidate").val()),
                        "jobtitle" : $.trim($("#jobtitle").val()),
                        "mobile" : $.trim($("#mobile").val()),
                        "appointdate" : $.trim($("#appointdate").val()),
                        "appointtime" : $.trim($("#appointtime").val()),
                        "communication" : $.trim($("#communication").val()),
                        "onepattern" : $.trim($("#onepattern").val()),
                        "onepass" : $.trim($("#onepass").val()),
                        "oneremark" : $.trim($("#oneremark").val()),
                        "secondpattern" : $.trim($("#secondpattern").val()),
                        "secondpass" : $.trim($("#secondpass").val()),
                        "secondremark" : $.trim($("#secondremark").val()),
                        "offerd" : $.trim($("#offerd").val()),
                        "entry" : $.trim($("#entry").val()),
                        "remark" : $.trim($("#remark").val()),
                    },
                    type : "post",
                    dataType : "json",
                    success : function() {
                        alert("添加成功")
                    }
                })
            })

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
                <h4 class="modal-title" id="myModalLabel1" style="color: blue">新增应聘人员</h4>
            </div>
            <div class="modal-body">

                <form class="form-horizontal" role="form" id="addForm">
                    <div class="form-group">
                        <label class="col-sm-1 control-label" style="font-size: 10px">登记人<span style="font-size: 10px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 130px;">
                            <select class="form-control" name="username" style="font-size: 10px">
                                <option></option>
                                <option value="左传茹">左传茹</option>
                                <option value="张翠环">张翠环</option>
                                <option value="崔顽勇">崔顽勇</option>
                            </select>
                        </div>
                        <label class="col-sm-1 control-label" style="font-size: 10px">来源<span style="font-size: 15px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 130px;">
                            <select class="form-control" name="sitename" style="font-size: 10px">
                                <option></option>
                                <option value="智联">智联</option>
                                <option value="boss">boss</option>
                                <option value="58同城">58同城</option>
                                <option value="内部推荐">内部推荐</option>
                                <option value="其他">其他</option>
                            </select>
                        </div>
                    </div>
                    <h5 class="modal-title" id="myModalLabel2" style="font-size: 15px; color: blue">应聘人员基本信息</h5><hr>
                    <div class="form-group">
                        <label class="col-sm-1 control-label" style="font-size: 10px">姓名<span style="font-size: 15px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 130px;">
                            <input type="text" class="form-control" name="candidate" style="font-size: 10px">
                        </div>
                        <label class="col-sm-1 control-label" style="font-size: 10px">岗位<span style="font-size: 15px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 130px;">
                            <input type="text" class="form-control" name="jobtitle" style="font-size: 10px">
                        </div>
                        <label class="col-sm-1 control-label" style="font-size: 10px">电话<span style="font-size: 15px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 130px;">
                            <input type="text" class="form-control" name="mobile" style="font-size: 10px">
                        </div>

                        <label class="col-sm-1 control-label" style="font-size: 10px">预约日期</label>
                        <div class="col-sm-10" style="width: 150px;">
                            <input type="date" class="form-control" name="appointdate" style="font-size: 10px">
                        </div>
                        <label class="col-sm-1 control-label" style="font-size: 10px">时间</label>
                        <div class="col-sm-10" style="width: 150px;">
                            <input type="time" class="form-control" name="appointtime" style="font-size: 10px">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-1 control-label" style="font-size: 10px">沟通情况</label>
                        <div class="col-sm-10" style="width: 90%;">
                            <textarea class="form-control" rows="3" name="communication" style="font-size: 10px"></textarea>
                        </div>
                    </div>

                    <h5 class="modal-title" id="myModalLabel3" style="font-size: 15px;color: blue">初试情况</h5><hr>
                    <div class="form-group">
                        <label class="col-sm-1 control-label" style="font-size: 10px">面试形式</label>
                        <div class="col-sm-10" style="width: 130px;">
                            <select class="form-control" name="onepattern" style="font-size: 10px">
                                <option></option>
                                <option value="0">视频</option>
                                <option value="1">面谈</option>
                            </select>
                        </div>
                        <label class="col-sm-1 control-label" style="font-size: 10px">通过</label>
                        <div class="col-sm-10" style="width: 130px;">
                            <select class="form-control" name="onepass" style="font-size: 10px">
                                <option></option>
                                <option value="0">是</option>
                                <option value="1">否</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-1 control-label" style="font-size: 10px">备注</label>
                        <div class="col-sm-10" style="width: 90%;">
                            <textarea class="form-control" rows="3" name="oneremark" style="font-size: 10px"></textarea>
                        </div>
                    </div>
                    <h5 class="modal-title" id="myModalLabel4" style="font-size: 15px; color: blue">复试情况</h5><hr>
                    <div class="form-group">
                        <label class="col-sm-1 control-label" style="font-size: 10px">面试形式</label>
                        <div class="col-sm-10" style="width: 130px;">
                            <select class="form-control" name="secondpattern" style="font-size: 10px">
                                <option></option>
                                <option value="0">视频</option>
                                <option value="1">面谈</option>
                            </select>
                        </div>
                        <label class="col-sm-1 control-label" style="font-size: 10px">通过</label>
                        <div class="col-sm-10" style="width: 130px;">
                            <select class="form-control" name="secondpass" style="font-size: 10px">
                                <option></option>
                                <option value="0">是</option>
                                <option value="1">否</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-1 control-label" style="font-size: 10px">备注</label>
                        <div class="col-sm-10" style="width: 90%;">
                            <textarea class="form-control" rows="3" name="secondremark" style="font-size: 10px"></textarea>
                        </div>
                    </div>

                    <h5 class="modal-title" id="myModalLabel5" style="color: blue; font-size: 15px" >录用信息</h5><hr>
                    <div class="form-group">
                        <label class="col-sm-1 control-label" style="font-size: 10px">发放offer</label>
                        <div class="col-sm-10" style="width: 130px;">
                            <select class="form-control" name="offered" style="font-size: 10px">
                                <option></option>
                                <option value="0">是</option>
                                <option value="1">否</option>
                            </select>
                        </div>

                        <label class="col-sm-1 control-label" style="font-size: 10px">入职报到</label>
                        <div class="col-sm-10" style="width: 130px;">
                            <select class="form-control" name="entry" style="font-size: 10px">
                                <option></option>
                                <option value="0">是</option>
                                <option value="1">否</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-1 control-label" style="font-size: 10px">备注</label>
                        <div class="col-sm-10" style="width: 90%;">
                            <textarea class="form-control" rows="3" name="remark" style="font-size: 10px"></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" >关闭</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" id="save">保存</button>
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
