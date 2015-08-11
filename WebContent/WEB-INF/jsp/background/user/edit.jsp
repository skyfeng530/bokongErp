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
<form action="${pageContext.servletContext.contextPath }/background/user/update.html" method="post">
<input type="hidden" name="userId" value="${user.userId}">
		<table class="ttab" height="100" width="85%" border="0" cellpadding="0" cellspacing="1" align="center">
				<tr>
					<td height="30" colspan="4">
						<div align="center">
							<font color="blue" size="8"><b>修改信息</b>
							</font>
						</div></td>
				</tr>
				<tr>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">用户名：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="userName" readonly="readonly" value="${user.userName }"/>
							*用户登录的名称
						</div>
					</td>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">密码：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input type="password" style="height: 20px;width: 200px" name="userPassword" />
							*用户登录的密码
						</div>
					</td>
				</tr>
				<tr>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">姓名：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="userRealname" value="${user.userRealname }"/>
						</div></td>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">生日：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="userBirthday" value="${user.userBirthday }"/>
						</div></td>
				</tr>
				<tr>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">性别：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input type="radio" name="userSex" value="男" <c:if test="${user.userSex eq '男'}">checked="checked"</c:if>/>男
							<input type="radio" name="userSex" value="女" <c:if test="${user.userSex eq '女'}">checked="checked"</c:if>/>女
						</div>
					</td>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">身份证号：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="idCard" value="${user.idCard }"/>
						</div></td>
				</tr>
				<tr>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">联系方式：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="userPhone" value="${user.userPhone }"/>
						</div></td>
					<td height="30" width="10%">
						<div align="right" class="STYLE1"></div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
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
