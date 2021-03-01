<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="UTF-8">

<link href="/js/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="/js/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css" type="text/css" rel="stylesheet" />

<script type="text/javascript" src="/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="/js/bootstrap_3.3.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="/js/bootstrap-datetimepicker-master/locale/bootstrap-datetimepicker.zh-CN.js"></script>

<script type="text/javascript">
	$(function () {

		var data = {"shumList":[{'shum':'百'},{'shum':'百年'},{'shum':'百年方'},{'shum':'百年方成'}]};
		$("#shum").keyup(function () {
			if ($("#shum").val() == '') {
				$("#shumtip").css("display","none");
				return;
			}

			var newData = "{'list':[";
			$.each(data.shumList,function (i,n) {
				if ((n.shum).indexOf($("#shum").val()) != -1 ){
					if (i < data.shumList.length -1) {
						newData += "{'shum':'" + n.shum +"'},";
					} else {
						newData += "{'shum':'" + n.shum +"'}";
					}
				}
			})
			newData += "]}";
			window.eval("var newDataJson = " + newData);
			var html = "";
			$.each(newDataJson.list,function(i, n) {

				html += '<div onmouseover="changeBackColor_over(this)" onmouseout="changeBackColor_out(this)" onclick="clicked(this)">'
						+ n.shum + '</div>';
			})
			$("#shumtip").html(html);
			$("#shumtip").css("display","block")
		})
	})

	function changeBackColor_over(divDomObject) {
		$(divDomObject).css("background-color","#CCCCCC");
	}

	function changeBackColor_out(divDomObject) {
		$(divDomObject).css("background-color","");
	}

	function clicked(divDomObject) {
		$("#shum").val(divDomObject.innerHTML);
		$("#shumtip").css("display","none");
	}
</script>
</head>
<body>

	<div style="position: relative; top: -5px; left: 0px; width: 100%; height: 100%;">
		<div style="width: 100%; position: absolute;top: 5px; left: 10px;">
			<div class="btn-toolbar" role="toolbar" style="height: 80px;">
				<form class="form-inline" role="form" style="position: relative; top: 8%; left: 5px;">
					<div class="form-group">
				    <div class="input-group">
				      <div class="input-group-addon" style="color: blue">客户名称</div>
				      <input class="form-control" type="text" name="khmc" id="khmc">
				    </div>
				  </div>&nbsp;&nbsp;&nbsp;

					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon" style="color: blue">图书分类</div>
							<input class="form-control" type="text" name="tsfljc" id="tsfljc">
						</div>
					</div>&nbsp;&nbsp;&nbsp;
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon" style="color: blue">自&nbsp;&nbsp;编&nbsp;&nbsp;号</div>
							<input class="form-control" type="text" name="zbh" id="zbh">
						</div>
					</div>&nbsp;&nbsp;&nbsp;
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon" style="color: blue;">销售部门</div>
							<select class="form-control" name="xsbmmc" id="xsbmmc">
								<option value="chengjiao">成教营销中心</option>
								<option value="wenhua">文化出版事业部</option>
							</select>
						</div>
					</div>&nbsp;&nbsp;&nbsp;

					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon" style="color: blue">编辑部门</div>
							<select class="form-control" name="bjbmmc" id="bjbmmc">
								<option value="yibian">第一编辑部</option>
								<option value="erbian">第二编辑部</option>
								<option value="sanbian">第三编辑部</option>
								<option value="sibian">第四编辑部</option>
								<option value="wenhua">文化出版事业部</option>
								<option value="hezuo">合作初版编辑部</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon" style="color: blue">单据类型</div>
							<select class="form-control" name="djlx" id="djlx">
								<option value="批发">批发</option>
								<option value="赠送">赠送</option>
								<option value="退货">退货</option>
							</select>
						</div>
					</div>
					<br><br>
					<div class="form-group">
						<div class="input-group" style="position: relative;">
							<div class="input-group-addon" style="color: blue">书&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</div>
							<input class="form-control" type="text" name="shum" id="shum">
							<div id="shumtip" style="background-color:white; border: 1px solid cadetblue;width:100%;top: 34px;left:0;display:none;position: absolute;z-index: 100"></div>
						</div>
					</div>&nbsp;&nbsp;&nbsp;
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon" style="color: blue">大区经理</div>
							<input class="form-control" type="text" name="dqjl" id="dqjl">
						</div>
					</div>&nbsp;&nbsp;&nbsp;
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon" style="color: blue">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区</div>
							<input class="form-control" type="text" name="dq" id="dq">
						</div>
					</div>&nbsp;&nbsp;&nbsp;
				  <div class="form-group">
				    <div class="input-group">
				      <div class="input-group-addon" style="color: blue">开始日期</div>
					  <input class="form-control" type="date" id="startTime" name="startTime"/>
				    </div>
				  </div>
				  <div class="form-group">
				    <div class="input-group">
				      <div class="input-group-addon" style="color: blue">结束日期</div>
					  <input class="form-control" type="date" id="endTime" name="endTime">
				    </div>
				  </div>&nbsp;&nbsp;&nbsp;
				  
				  <button type="button" class="btn btn-default" style="color: blue">查询</button>
				  
				</form>
			</div>
			<hr>

			<div style="position: relative;top: 10px;">
				<table class="table table-hover">
					<thead>
						<tr style="color: blue;">
							<td>序</td>
							<td>发货单号</td>
							<td>发货状态</td>
                            <td>客户名称</td>
							<td>销售部门</td>
							<td>单据类型</td>
							<td>制单日期</td>
							<td>书序号</td>
							<td>书名</td>
							<td>编辑部门</td>
							<td>图书分类</td>
							<td>自编码</td>
							<td>定价</td>
							<td>册数</td>
							<td>码洋</td>
							<td>折扣</td>
							<td>实洋</td>
							<td>大区经理</td>
							<td>地区</td>
						</tr>
					</thead>
					<tbody>
						<tr class="active">
							<td>1</td>
							<td>TH2021000000215</td>
							<td>待发</td>
                            <td>北京美如林文化发展有限公司</td>
							<td>成教营销中心</td>
							<td>退货</td>
							<td>2021-03-01</td>
							<td>20200808</td>
							<td><a style="color: blue; cursor: pointer;" onclick="window.location.href='detail.html';">高等教育自学考试考纲解读与全真模拟演练：高等数学（一）</a></td>
							<td>第二编辑部</td>
							<td>考试类-自考考纲公课</td>
							<td>20171010112F1705</td>
							<td>28.00</td>
							<td>100</td>
							<td>100</td>
							<td>0.25</td>
							<td>25</td>
							<td>张琳</td>
							<td>北京</td>
						</tr>
					</tbody>
				</table>
			</div>
			
			<div style="height: 50px; position: relative;top: 30px;">
				<div>
					<button type="button" class="btn btn-default" style="cursor: default;">共<b>50</b>条记录</button>
				</div>
				<div class="btn-group" style="position: relative;top: -34px; left: 110px;">
					<button type="button" class="btn btn-default" style="cursor: default;">显示</button>
					<div class="btn-group">
						<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
							10
							<span class="caret"></span>
						</button>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">20</a></li>
							<li><a href="#">30</a></li>
						</ul>
					</div>
					<button type="button" class="btn btn-default" style="cursor: default;">条/页</button>
				</div>
				<div style="position: relative;top: -88px; left: 285px;">
					<nav>
						<ul class="pagination">
							<li class="disabled"><a href="#">首页</a></li>
							<li class="disabled"><a href="#">上一页</a></li>
							<li class="active" style="color: blue;"><a href="#">1</a></li>
							<li><a href="#" style="color: blue;">2</a></li>
							<li><a href="#" style="color: blue;">3</a></li>
							<li><a href="#" style="color: blue;">4</a></li>
							<li><a href="#" style="color: blue;">5</a></li>
							<li><a href="#">下一页</a></li>
							<li class="disabled"><a href="#">末页</a></li>
						</ul>
					</nav>
				</div>
			</div>
			
		</div>
		
	</div>
</body>
</html>
