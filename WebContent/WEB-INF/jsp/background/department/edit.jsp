<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../common/taglib.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@include file="../../common/common-css.jsp" %>
  </head>
  
  <body>
  <div style="height: 100%;overflow-y: auto;">
<br/>
<br/>  
<form action="${pageContext.servletContext.contextPath }/background/department/update.html" method="post">
<input type="hidden" name="departId" value="${department.departId}">
		<table class="ttab" height="100" width="85%" border="0" cellpadding="0" cellspacing="1" align="center">
			<tr>
				<td height="30" colspan="4">
					<div align="center">
						<font color="blue" size="12"><b>修改分组信息</b>
						</font>
					</div>
				</td>
			</tr>
			<tr>
				<td height="30" width="10%">
					<div align="right" class="STYLE1">分组名称：</div></td>
				<td colspan="3">
					<div align="left" class="STYLE1" style="padding-left:10px;">
						<input style="height: 20px;width: 200px" name="dName" value="${department.dName}"/>
					</select>
					</div>
				</td>
			</tr>
			<%-- <tr>
				<td height="30" width="10%">
					<div align="right" class="STYLE1">分组类型：</div></td>
				<td colspan="3">
					<div align="left" class="STYLE1" style="padding-left:10px;">
						<input type="radio" name="departType" value="0" <c:if test="${department.departType eq 0}">checked="checked"</c:if>/>虚拟部门
						<input type="radio" name="departType" value="1" <c:if test="${department.departType eq 1}">checked="checked"</c:if>/>真实部门
					</div>
				</td>
			</tr> --%>
			<tr>
				<td height="30" width="10%">
					<div align="right" class="STYLE1">隶属科室：</div></td>
				<td colspan="3">
					<div align="left" class="STYLE1" style="padding-left:10px;">
						<select name="membership" class="SelectStyle">
							<option value="物资供应科" <c:if test="${department.membership eq '物资供应科'}">selected="selected"</c:if>>物资供应科</option>
							<option value="装校中心" <c:if test="${department.membership eq '装校中心'}">selected="selected"</c:if>>装校中心</option>
							<option value="工程管理科" <c:if test="${department.membership eq '工程管理科'}">selected="selected"</c:if>>工程管理科</option>
						</select>
					</div>
				</td>
			</tr>
			<tr>
				<td height="30" width="10%">
					<div align="right" class="STYLE1">描述：</div></td>
				<td colspan="3">
					<div align="left" class="STYLE1" style="padding-left:10px;">
						<input style="height: 20px;width: 670px" name="discribe" value="${department.discribe}"/>
					</select>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="4" style="padding: 10px">
					<div align="center">
						<input type="hidden" name="departType" value="1">
						<input type="submit" value="　保　存　" class="input_btn_style1" /> <input
							id="backBt" type="button" value="　返　回　" class="input_btn_style1"
							onclick="javascript:window.location.href='javascript:history.go(-1)'" />
					</div>
				</td>
			</tr>
		</table>
</form>
</div>
  </body>
</html>
