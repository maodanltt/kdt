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
            $("#search").click(function (pageno,pagesize) {
                if ($.trim($("#query-startdate").val()) == '') {
                    alert("开始日期必须输入");
                    $("#query-startdate").focus();
                    return false;
                }
                if ($.trim($("#query-enddate").val()) == '') {
                    alert("结束日期必须输入");
                    $("#query-enddate").focus();
                    return false;
                }


            })

        })

            $("#addConfirm").click(function () {
                $.ajax({
                    url : "/hr/candidate/add.do",
                    data : {
                        "username" : $.trim($("#add-username").val()),
                        "sitename" : $.trim($("#add-sitename").val()),
                        "candidate" : $.trim($("#add-candidate").val()),
                        "jobtitle" : $.trim($("#add-jobtitle").val()),
                        "mobile" : $.trim($("#add-mobile").val()),
                        "appointdate" : $.trim($("#add-appointdate").val()),
                        "appointtime" : $.trim($("#add-appointtime").val()),
                        "communication" : $.trim($("#add-communication").val()),
                        "onepattern" : $.trim($("#add-onepattern").val()),
                        "onepass" : $.trim($("#add-onepass").val()),
                        "oneremark" : $.trim($("#add-oneremark").val()),
                        "secondpattern" : $.trim($("#add-secondpattern").val()),
                        "secondpass" : $.trim($("#add-secondpass").val()),
                        "secondremark" : $.trim($("#add-secondremark").val()),
                        "offered" : $.trim($("#add-offered").val()),
                        "entry" : $.trim($("#add-entry").val()),
                        "remark" : $.trim($("#add-remark").val()),
                    },
                    type : "post",
                    dataType : "json",
                    success : function() {
                        alert("添加成功")
                    }
                })
            })

            $("#update").click(function () {
                var $xz = $("input[name=xz]:checked");
                if($xz.length == 0) {
                    alert("请选择需要修改的记录");
                } else if($xz.length>1){
                    alert("只能选择一条记录进行修改");
                } else{
                    var id = $xz.val();
                    $.ajax({
                        url : "/hr/candidate/queryById.do",
                        data : {
                            "id" : id
                        },
                        type : "get",
                        dataType : "json",
                        success : function (data) {
                            $("#update-id").val(data.id);
                            $("#update-username").val(data.username);
                            $("#update-sitename").val(data.sitename);
                            $("#update-candidate").val(data.candidate);
                            $("#update-jobtitle").val(data.jobtitle);
                            $("#update-mobile").val(data.mobile);
                            $("#update-appointdate").val(data.appointdate);
                            $("#update-appointtime").val(data.appointtime);
                            $("#update-communication").val(data.communication);
                            $("#update-onepattern").val(data.onepattern);
                            $("#update-onepass").val(data.onepass);
                            $("#update-oneremark").val(data.oneremark);
                            $("#update-secondpattern").val(data.secondpattern);
                            $("#update-secondpass").val(data.secondpass);
                            $("#update-secondremark").val(data.secondremark);
                            $("#update-offered").val(data.offered);
                            $("#update-entry").val(data.entry);
                            $("#update-remark").val(data.remark);
                            //所有的值都填写好之后，打开修改操作的模态窗口
                            $("#updateModal").modal("show");
                        }
                    })
                }
            })

            $("#updateConfirm").click(function () {
                $.ajax({
                    url : "/hr/candidate/update.do",
                    data : {
                        "id" : $.trim($("#update-id").val()),
                        "username" : $.trim($("#update-username").val()),
                        "sitename" : $.trim($("#update-sitename").val()),
                        "candidate" : $.trim($("#update-candidate").val()),
                        "jobtitle" : $.trim($("#update-jobtitle").val()),
                        "mobile" : $.trim($("#update-mobile").val()),
                        "appointdate" : $.trim($("#update-appointdate").val()),
                        "appointtime" : $.trim($("#update-appointtime").val()),
                        "communication" : $.trim($("#update-communication").val()),
                        "onepattern" : $.trim($("#update-onepattern").val()),
                        "onepass" : $.trim($("#update-onepass").val()),
                        "oneremark" : $.trim($("#update-oneremark").val()),
                        "secondpattern" : $.trim($("#update-secondpattern").val()),
                        "secondpass" : $.trim($("#update-secondpass").val()),
                        "secondremark" : $.trim($("#update-secondremark").val()),
                        "offered" : $.trim($("#update-offered").val()),
                        "entry" : $.trim($("#update-entry").val()),
                        "remark" : $.trim($("#update-remark").val()),
                    },
                    type : "post",
                    dataType : "json",
                    success : function() {
                        alert("修改成功")
                    }
                })
            })

        })

    </script>
</head>
<body>
<!-- 创建模态窗口 -->
<div class="modal fade" id="addModal" role="dialog">
    <div class="modal-dialog" role="document" style="width: 85%;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" style="color: blue">新增应聘人员</h4>
            </div>
            <div class="modal-body">

                <form class="form-horizontal" role="form" id="addForm">
                    <div class="form-group">
                        <label class="col-sm-1 control-label" style="font-size: 10px">登记人<span style="font-size: 10px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 130px;">
                            <select class="form-control input-sm" id="add-username" style="font-size: 10px">
                                <option></option>
                                <option value="左传茹">左传茹</option>
                                <option value="张翠环">张翠环</option>
                                <option value="崔顽勇">崔顽勇</option>
                            </select>
                        </div>
                        <label class="col-sm-1 control-label" style="font-size: 10px">来源<span style="font-size: 15px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 130px;">
                            <select class="form-control input-sm" id="add-sitename" style="font-size: 10px">
                                <option></option>
                                <option value="智联">智联</option>
                                <option value="boss">boss</option>
                                <option value="58同城">58同城</option>
                                <option value="内部推荐">内部推荐</option>
                                <option value="其他">其他</option>
                            </select>
                        </div>
                    </div>
                    <h5 class="modal-title" style="font-size: 15px; color: blue">应聘人员基本信息</h5><hr>
                    <div class="form-group">
                        <label class="col-sm-1 control-label" style="font-size: 10px">姓名<span style="font-size: 15px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 130px;">
                            <input type="text" class="form-control input-sm" id="add-candidate" style="font-size: 10px">
                        </div>
                        <label class="col-sm-1 control-label" style="font-size: 10px">岗位<span style="font-size: 15px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 130px;">
                            <input type="text" class="form-control input-sm" id="add-jobtitle" style="font-size: 10px">
                        </div>
                        <label class="col-sm-1 control-label" style="font-size: 10px">电话<span style="font-size: 15px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 130px;">
                            <input type="text" class="form-control input-sm" id="add-mobile" style="font-size: 10px">
                        </div>

                        <label class="col-sm-1 control-label" style="font-size: 10px">预约日期</label>
                        <div class="col-sm-10" style="width: 150px;">
                            <input type="date" class="form-control input-sm" id="add-appointdate" style="font-size: 10px">
                        </div>
                        <label class="col-sm-1 control-label" style="font-size: 10px">时间</label>
                        <div class="col-sm-10" style="width: 150px;">
                            <input type="time" class="form-control input-sm" id="add-appointtime" style="font-size: 10px">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-1 control-label" style="font-size: 10px">沟通情况</label>
                        <div class="col-sm-10" style="width: 90%;">
                            <textarea class="form-control" rows="3" id="add-communication" style="font-size: 10px"></textarea>
                        </div>
                    </div>

                    <h5 class="modal-title" style="font-size: 15px;color: blue">初试情况</h5><hr>
                    <div class="form-group">
                        <label class="col-sm-1 control-label" style="font-size: 10px">面试形式</label>
                        <div class="col-sm-10" style="width: 130px;">
                            <select class="form-control input-sm" id="add-onepattern" style="font-size: 10px">
                                <option></option>
                                <option value="视频">视频</option>
                                <option value="面谈">面谈</option>
                            </select>
                        </div>
                        <label class="col-sm-1 control-label" style="font-size: 10px">通过</label>
                        <div class="col-sm-10" style="width: 130px;">
                            <select class="form-control input-sm" id="add-onepass" style="font-size: 10px">
                                <option></option>
                                <option value="是">是</option>
                                <option value="否">否</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-1 control-label" style="font-size: 10px">备注</label>
                        <div class="col-sm-10" style="width: 90%;">
                            <textarea class="form-control" rows="3" id="add-oneremark" style="font-size: 10px"></textarea>
                        </div>
                    </div>
                    <h5 class="modal-title" style="font-size: 15px; color: blue">复试情况</h5><hr>
                    <div class="form-group">
                        <label class="col-sm-1 control-label" style="font-size: 10px">面试形式</label>
                        <div class="col-sm-10" style="width: 130px;">
                            <select class="form-control input-sm" id="add-secondpattern" style="font-size: 10px">
                                <option></option>
                                <option value="视频">视频</option>
                                <option value="面谈">面谈</option>
                            </select>
                        </div>
                        <label class="col-sm-1 control-label" style="font-size: 10px">通过</label>
                        <div class="col-sm-10" style="width: 130px;">
                            <select class="form-control input-sm" id="add-secondpass" style="font-size: 10px">
                                <option></option>
                                <option value="是">是</option>
                                <option value="否">否</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-1 control-label" style="font-size: 10px">备注</label>
                        <div class="col-sm-10" style="width: 90%;">
                            <textarea class="form-control" rows="3" id="add-secondremark" style="font-size: 10px"></textarea>
                        </div>
                    </div>

                    <h5 class="modal-title" style="color: blue; font-size: 15px" >录用信息</h5><hr>
                    <div class="form-group">
                        <label class="col-sm-1 control-label" style="font-size: 10px">发放offer</label>
                        <div class="col-sm-10" style="width: 130px;">
                            <select class="form-control input-sm" id="add-offered" style="font-size: 10px">
                                <option></option>
                                <option value="是">是</option>
                                <option value="否">否</option>
                            </select>
                        </div>

                        <label class="col-sm-1 control-label" style="font-size: 10px">入职报到</label>
                        <div class="col-sm-10" style="width: 130px;">
                            <select class="form-control input-sm" id="add-entry" style="font-size: 10px">
                                <option></option>
                                <option value="是">是</option>
                                <option value="否">否</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-1 control-label" style="font-size: 10px">备注</label>
                        <div class="col-sm-10" style="width: 90%;">
                            <textarea class="form-control" rows="3" id="add-remark" style="font-size: 10px"></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" >关闭</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" id="addConfirm">保存</button>
            </div>
        </div>
    </div>
</div>
<!-- 创建模态窗口结束 -->

<!-- 修改模态窗口 -->
<div class="modal fade" id="updateModal" role="dialog">
    <div>
        <input type="hidden" id="update-id">
    </div>
    <div class="modal-dialog" role="document" style="width: 85%;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" style="color: blue">修改应聘人员信息</h4>
            </div>
            <div class="modal-body">

                <form class="form-horizontal" role="form" id="updateForm">
                    <div class="form-group">
                        <label class="col-sm-1 control-label" style="font-size: 10px">登记人<span style="font-size: 10px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 130px;">
                            <select class="form-control" id="update-username" style="font-size: 10px">
                                <option></option>
                                <option value="左传茹">左传茹</option>
                                <option value="张翠环">张翠环</option>
                                <option value="崔顽勇">崔顽勇</option>
                            </select>
                        </div>
                        <label class="col-sm-1 control-label" style="font-size: 10px">来源<span style="font-size: 15px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 130px;">
                            <select class="form-control" id="update-sitename" style="font-size: 10px">
                                <option></option>
                                <option value="智联">智联</option>
                                <option value="boss">boss</option>
                                <option value="58同城">58同城</option>
                                <option value="内部推荐">内部推荐</option>
                                <option value="其他">其他</option>
                            </select>
                        </div>
                    </div>
                    <h5 class="modal-title" style="font-size: 15px; color: blue">应聘人员基本信息</h5><hr>
                    <div class="form-group">
                        <label class="col-sm-1 control-label" style="font-size: 10px">姓名<span style="font-size: 15px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 130px;">
                            <input type="text" class="form-control" id="update-candidate" style="font-size: 10px">
                        </div>
                        <label class="col-sm-1 control-label" style="font-size: 10px">岗位<span style="font-size: 15px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 130px;">
                            <input type="text" class="form-control" id="update-jobtitle" style="font-size: 10px">
                        </div>
                        <label class="col-sm-1 control-label" style="font-size: 10px">电话<span style="font-size: 15px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 130px;">
                            <input type="text" class="form-control" id="update-mobile" style="font-size: 10px">
                        </div>

                        <label class="col-sm-1 control-label" style="font-size: 10px">预约日期</label>
                        <div class="col-sm-10" style="width: 150px;">
                            <input type="date" class="form-control" id="update-appointdate" style="font-size: 10px">
                        </div>
                        <label class="col-sm-1 control-label" style="font-size: 10px">时间</label>
                        <div class="col-sm-10" style="width: 150px;">
                            <input type="time" class="form-control" id="update-appointtime" style="font-size: 10px">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-1 control-label" style="font-size: 10px">沟通情况</label>
                        <div class="col-sm-10" style="width: 90%;">
                            <textarea class="form-control" rows="3" id="update-communication" style="font-size: 10px"></textarea>
                        </div>
                    </div>

                    <h5 class="modal-title" style="font-size: 15px;color: blue">初试情况</h5><hr>
                    <div class="form-group">
                        <label class="col-sm-1 control-label" style="font-size: 10px">面试形式</label>
                        <div class="col-sm-10" style="width: 130px;">
                            <select class="form-control" id="update-onepattern" style="font-size: 10px">
                                <option></option>
                                <option value="视频">视频</option>
                                <option value="面谈">面谈</option>
                            </select>
                        </div>
                        <label class="col-sm-1 control-label" style="font-size: 10px">通过</label>
                        <div class="col-sm-10" style="width: 130px;">
                            <select class="form-control" id="update-onepass" style="font-size: 10px">
                                <option></option>
                                <option value="是">是</option>
                                <option value="否">否</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-1 control-label" style="font-size: 10px">备注</label>
                        <div class="col-sm-10" style="width: 90%;">
                            <textarea class="form-control" rows="3" id="update-oneremark" style="font-size: 10px"></textarea>
                        </div>
                    </div>
                    <h5 class="modal-title" style="font-size: 15px; color: blue">复试情况</h5><hr>
                    <div class="form-group">
                        <label class="col-sm-1 control-label" style="font-size: 10px">面试形式</label>
                        <div class="col-sm-10" style="width: 130px;">
                            <select class="form-control" id="update-secondpattern" style="font-size: 10px">
                                <option></option>
                                <option value="视频">视频</option>
                                <option value="面谈">面谈</option>
                            </select>
                        </div>
                        <label class="col-sm-1 control-label" style="font-size: 10px">通过</label>
                        <div class="col-sm-10" style="width: 130px;">
                            <select class="form-control" id="update-secondpass" style="font-size: 10px">
                                <option></option>
                                <option value="是">是</option>
                                <option value="否">否</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-1 control-label" style="font-size: 10px">备注</label>
                        <div class="col-sm-10" style="width: 90%;">
                            <textarea class="form-control" rows="3" id="update-secondremark" style="font-size: 10px"></textarea>
                        </div>
                    </div>

                    <h5 class="modal-title" style="color: blue; font-size: 15px" >录用信息</h5><hr>
                    <div class="form-group">
                        <label class="col-sm-1 control-label" style="font-size: 10px">发放offer</label>
                        <div class="col-sm-10" style="width: 130px;">
                            <select class="form-control" id="update-offered" style="font-size: 10px">
                                <option></option>
                                <option value="是">是</option>
                                <option value="否">否</option>
                            </select>
                        </div>

                        <label class="col-sm-1 control-label" style="font-size: 10px">入职报到</label>
                        <div class="col-sm-10" style="width: 130px;">
                            <select class="form-control" id="update-entry" style="font-size: 10px">
                                <option></option>
                                <option value="是">是</option>
                                <option value="否">否</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-1 control-label" style="font-size: 10px">备注</label>
                        <div class="col-sm-10" style="width: 90%;">
                            <textarea class="form-control" rows="3" id="update-remark" style="font-size: 10px"></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" >关闭</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" id="updateConfirm">修改</button>
            </div>
        </div>
    </div>
</div>
<!-- 修改模态窗口结束 -->

<div style="position: relative; height: 100%;">
    <div class="btn-toolbar" role="toolbar" style="height: 80px; padding: 0 20px">
        <form role="form" action="/report/candidate/export.do" method="post" style="position: relative; top: 8%; left: 5px;font-size: medium" id="queryForm" target="iframe">
            <div class="row">
                <div class="form-group col-xs-3">
                    <div class="input-group input-group-sm" style="position: relative;">
                        <div class="input-group-addon" style="color: blue">
                            登记人
                        </div>
                        <input class="form-control" type="text" id="query-username">
                    </div>
                </div>

                <div class="form-group col-xs-3">
                    <div class="input-group input-group-sm" style="position: relative;">
                        <div class="input-group-addon" style="color: blue">应聘人姓名</div>
                        <input class="form-control" type="text" id="query-candidate">
                    </div>
                </div>

                <div class="form-group col-xs-3">
                    <div class="input-group input-group-sm" style="position: relative;">
                        <div class="input-group-addon" style="color: blue">岗位名称</div>
                        <input class="form-control" type="text" id="query-jobtitle">
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
                    <button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#addModal" id="add">
                        <span class="glyphicon glyphicon-plus" aria-hidden="true">新增</span>
                    </button>
                    <button type="button" class="btn btn-warning btn-sm" id="update">
                        <span class="glyphicon glyphicon-pencil" aria-hidden="true">修改</span>
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
                    <th><input type="checkbox"></th>
                    <th>序号</th>
                    <th>登记日期</th>
                    <th>登记人</th>
                    <th>来源</th>
                    <th>姓名</th>
                    <th>岗位</th>
                    <th>电话</th>
                    <th>预约日期</th>
                    <th>预约时间</th>
                    <th>沟通情况</th>
                    <th>形式</th>
                    <th>通过</th>
                    <th>备注</th>
                    <th>形式</th>
                    <th>通过</th>
                    <th>备注</th>
                    <th>愿意入职</th>
                    <th>入职报到</th>
                    <th>备注</th>
                </tr>
            </thead>
            <tbody id="candidatetbody"></tbody>
<%--            <tfoot id="candidatetfoot"></tfoot>--%>
        </table>
    </div>

    <div style="height: 50px; position: relative; top:30px">
        <div id="candidatePage"></div>
    </div>
</div>

</body>
</html>
