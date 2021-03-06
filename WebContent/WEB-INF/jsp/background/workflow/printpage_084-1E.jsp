<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@include file="../../common/include.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>不合格品审理记录</title>
<script language="javascript"
	src="${pageContext.servletContext.contextPath }/js/workflow/ominstorage/printage_084.js"></script>
<script type="text/javascript">
	var projectName = '${projectName}';
	var taskName = '${taskName}';
	var figurename = '${figurename}';
	var figureno = '${figureno}';
	var checknum = '${checknum}';
	var totalnumber = '${totalnumber}';
	var unqualifiednum = '${unqualifiednum}';
	var unqualifiedgrade = '${unqualifiedgrade}';
	var reviewrst = '${reviewrst}';
	var reviewgrp = '${reviewgrp}';
	var reviewno = '${reviewno}';
</script>
<style type="text/css">
caption {
	text-align: center;
}

strong {
	font-weight: bold;
}

td, tr {
	font-size: 12px;
	border: 1px solid #000000;
	border-width: 1px 0px 0px 1px;
}

.tab {
	width: 600px;
	height: auto;
}

.tab li {
	width: 150px;
	height: 74px;
	border: 1px solid #000000;
	border-width: 0px 1px 0px 0px;
	list-style: none;
	float: left;
}

.tab1 {
	width: 600px;
	height: auto;
}

.tab1 li {
	width: 100px;
	height: 74px;
	border: 1px solid #000000;
	border-width: 0px 1px 0px 0px;
	list-style: none;
	float: left;
}
</style>
</head>

<body>
<input style="float:right;margin-right: 180px;margin-top: 30px;" value="打印本页" type="button" onclick="javascript:preview();"/>
<!--startprint--> 
<div
		style="border: 1px solid #000000; width: 794px; height: 1123px; margin-left: auto; margin-right: auto; padding-top: 50px;">
		<table width="649" height="978" cellpadding="3" cellspacing="1"
			style="border: 2px solid #000000;" align="center">
			<caption align="top">
				<strong>中国科学院西安光学精密机械研究所<br /> <u>不合格品审理记录</u></strong><br /> <br />
				<div style="float: left;">分类号：084-1E</div>
				<div id="reviewno_id" style="float: right;"></div>
			</caption>
			<tr>
				<td width="133" scope="row"><div align="center">项目名称</div></td>
				<td id="projectName_id" colspan="2"></td>
				<td width="112"><div align="center">项目代号</div></td>
				<td id="taskNo_id" colspan="3"></td>
			</tr>
			<tr>
				<td scope="row"><div align="center">
						<div>产品（或零部件）</div>
						<div>名称</div>
					</div></td>
				<td id="figurename_id" colspan="2"></td>
				<td><div align="center">
						<div>规格型号</div>
						<div>（或图号）</div>
					</div></td>
				<td id="figureno_id" colspan="3">&nbsp;</td>
			</tr>
			<tr>
				<td scope="row"><div align="center">产品送检总数</div></td>
				<td id="checknum_id" colspan="2"></td>
				<td><div align="center">不合格数</div></td>
				<td id="unqualifiednum_id" colspan="3"></td>
			</tr>
			<tr>
				<td height="54" scope="row"><div align="center">不合格品情况描述</div></td>
				<td colspan="6">&nbsp;</td>
			</tr>
			<tr>
				<td scope="row"><div align="center">不合格性质</div></td>
				<td colspan="6"><form id="form1" name="form1" method="post"
						action="">
						<label>一般不合格 <input id="unqualifiedgrade_id_1"
							type="checkbox" name="checkbox" value="checkbox" />
						</label> <label>严重不合格 <input id="unqualifiedgrade_id_2"
							type="checkbox" name="checkbox2" value="checkbox" />
						</label>
					</form></td>
			</tr>
			<tr>
				<td height="74" scope="row"><div align="center"
						style="width: 85px; margin-left: auto; margin-right: auto;">
						<div>检 验 人 员</div>
						<div>（签字、日期）</div>
					</div></td>
				<td width="73" colspan="6">
					<div class="tab">
						<li>
					  <li>
					  <li>
					</div>
				</td>
			</tr>
			<tr>
				<td scope="row"><div align="center">审理组织</div></td>
				<td colspan="6"><form id="form2" name="form2" method="post"
						action="">
						<label>审理小组 <input id="reviewgrp_id_1" type="checkbox"
							name="checkbox3" value="checkbox" />
						</label> <label>审理委员会 <input id="reviewgrp_id_2" type="checkbox"
							name="checkbox4" value="checkbox" />
						</label>
					</form></td>
			</tr>
			<tr>
				<td scope="row"><div align="center">不合格品审理结论</div></td>
				<td colspan="6"><form id="form3" name="form3" method="post"
						action="">
						<label>返工 <input id="reviewrst_id_1" type="checkbox"
							name="checkbox5" value="checkbox" />
						</label> <label>返修 <input id="reviewrst_id_2" type="checkbox"
							name="checkbox6" value="checkbox" />
						</label> <label>降级 <input id="reviewrst_id_3" type="checkbox"
							name="checkbox6" value="checkbox" />
						</label> <label>报废 <input id="reviewrst_id_4" type="checkbox"
							name="checkbox6" value="checkbox" />
						</label> <label>让步接收 <input id="reviewrst_id_5" type="checkbox"
							name="checkbox6" value="checkbox" />
						</label> <label>返回供方 <input id="reviewrst_id_6" type="checkbox"
							name="checkbox6" value="checkbox" />
						</label>
					</form></td>
			</tr>
			<tr>
				<td height="40" scope="row"><div align="center">
						<div>审理人员</div>
						<div>（签字、日期）</div>
					</div></td>
				<td colspan="6"><div class="tab1">
						<li>
				  <li>
				  <li><li><li>
					</div></td>
			</tr>
			<tr>
				<td scope="row"><div align="center">二次检验记录</div></td>
				<td colspan="6">&nbsp;</td>
			</tr>
			<tr>
				<td scope="row"><div align="center">
						<div>顾客意见</div>
						<div>（让步接收时）</div>
					</div></td>
				<td colspan="6">&nbsp;</td>
			</tr>
			<tr>
				<td scope="row"><div align="center">
						<div>主管所领导意见</div>
						<div>（改变意见时）</div>
					</div></td>
				<td colspan="6">&nbsp;</td>
			</tr>
			<tr>
				<td height="111" scope="row"><div align="center">备注</div></td>
				<td colspan="6">&nbsp;</td>
			</tr>
		</table>
</div>
<!--endprint--> 
</body>
</html>