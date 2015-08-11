<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../../common/taglib.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@include file="../../../common/common-css.jsp" %>
  </head>
  
  <body>
  <div style="height: 100%;overflow-y: auto;">
<br/>
<br/>  
<form action="${pageContext.servletContext.contextPath }/background/device/material/update.html" method="post">
<input type="hidden" name="id" value="${omInstorage.id}">
		<table class="ttab" height="100" width="85%" border="0" cellpadding="0" cellspacing="1" align="center">
				<tr>
					<td height="30" colspan="4">
						<div align="center">
							<font color="blue" size="12"><b>修改元器件信息</b>
							</font>
						</div></td>
				</tr>
				<tr>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">器件编号：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="devBatchNo" value="${omInstorage.devBatchNo}"/>
						</div>
					</td>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">总个数：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="totalNumber" value="${omInstorage.totalNumber}"/>
						</div>
					</td>
				</tr>
				<tr>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">生产产家：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="vendorNo" value="${omInstorage.vendorNo}"/>
						</div>
					</td>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">检测结果：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="checkRst" value="${omInstorage.checkRst}"/>
						</div>
					</td>
				</tr>
				<tr>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">检测数量：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="checkNum" value="${omInstorage.checkNum}"/>
						</div></td>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">合格数量：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="qualifiedNum" value="${omInstorage.qualifiedNum}"/>
						</div></td>
				</tr>
				<tr>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">不合格数量：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="unqualifiedNum" value="${omInstorage.unqualifiedNum}"/>
						</div></td>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">不合格等级：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="unqualifiedGrade" value="${omInstorage.unqualifiedGrade}"/>
						</div></td>
				</tr>
				<tr>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">不合格原因：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="unqualifiedReason" value="${omInstorage.unqualifiedReason}"/>
						</div></td>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">审核结果：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="reviewRst" value="${omInstorage.reviewRst}"/>
						</div></td>
				</tr>
				<tr>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">审核小组：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="reviewGrp" value="${omInstorage.reviewGrp}"/>
						</div></td>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">审理单号：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="reviewNo" value="${omInstorage.reviewNo}"/>
						</div></td>
				</tr>
				
				<tr>
					<td colspan="4" style="padding: 10px">
						<div align="center">
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
