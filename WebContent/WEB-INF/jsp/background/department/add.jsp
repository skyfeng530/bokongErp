<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="../../common/common-css.jsp"%>
</head>

<body>
	<div style="height: 100%;overflow-y: auto;">
		<br /> <br />
		<form
			action="${pageContext.servletContext.contextPath }/background/department/add.html"
			method="post">
			<table class="ttab" height="100" width="85%" border="0"
				cellpadding="0" cellspacing="1" align="center">
				<tr>
					<td height="30" colspan="4">
						<div align="center">
							<font color="blue" size="8"><b>添加分组信息</b>
							</font>
						</div></td>
				</tr>
				<tr>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">分组名称：</div></td>
					<td colspan="3">
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="dName" />
						</select>
						</div></td>
				</tr>
				<!-- <tr>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">分组类型：</div></td>
					<td colspan="3">
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input type="radio" name="departType" value="0" checked="checked"/>：虚拟分组
							<input type="radio" name="departType" value="1"/>：真实分组
						</div>
					</td>
				</tr> -->
				<tr>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">隶属科室：</div></td>
					<td colspan="3">
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<select name="membership" class="SelectStyle">
								<option value="物资供应科">物资供应科</option>
								<option value="装校中心">装校中心</option>
								<option value="工程管理科">工程管理科</option>
							</select>
						</div>
					</td>
				</tr>
				<tr>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">描述：</div></td>
					<td colspan="3">
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 670px" name="discribe" />
						</select>
						</div></td>
				</tr>
				<tr>
					<td colspan="4" style="padding: 10px">
						<div align="center">
							<input type="hidden" name="departType" value="1">
							<input type="submit" value="　保　存　" class="input_btn_style1" /> <input
								id="backBt" type="button" value="　返　回　" class="input_btn_style1"
								onclick="javascript:window.location.href='javascript:history.go(-1)'" />
						</div></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
