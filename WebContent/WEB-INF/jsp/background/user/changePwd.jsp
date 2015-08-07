<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../common/taglib.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@include file="../../common/common-css.jsp" %>
    <script src="${pageContext.servletContext.contextPath }/js/jquery_1_7_2_min.js" type="text/javascript"></script>
  <script type="text/javascript">
  function check(){
	  var uname = "${user.userName}";
	  var oldpwd = $('input[name="userPassword"]').val();
	  var newpwd1 = $('input[name="newPwd1"]').val();
	  var newpwd2 = $('input[name="newPwd2"]').val();
	  if(uname != "" && oldpwd != "" && newpwd1 != "" && newpwd2 != ""){
		  if(newpwd1 == newpwd2){
			  return true;
		  }else{
			  alert("两次输入密码不一致！");
			  return false;
		  }
	  }else{
		  alert("输入参数不能为空！");
		  return false;
	  }
  }
  function allocation(){
	  if(check()){
		  $.ajax({
	      		async:false, //请勿改成异步，下面有些程序依赖此请数据
	      		type : "POST",
	      		data:{userName:"${user.userName}",userPassword:$('input[name="userPassword"]').val(),
	      			newPwd1:$('input[name="newPwd1"]').val(),
	      			newPwd2:$('input[name="newPwd2"]').val()},
	      		url: "${pageContext.servletContext.contextPath }/background/user/changePwd.html",
	      		dataType:'json',
	      		success: function(json){
	      			if(json == "1000"){
	      			window.dialogArguments.location.reload();
			          alert("修改密码成功！！");
			          window.close();
	              	}else if(json == "1001"){
	              		alert("修改密码失败！！");
	                };
	       		}
	      	});
	  }
  }
  </script>
  </head>
  <body>
  <div style="height: 100%;overflow-y: auto;">
<br/>
<br/>  
<table class="ttab" height="100" width="85%" border="0" cellpadding="0" cellspacing="1" align="center">
		<tr>
			<td height="30" colspan="4">
				<div align="center">
					<font color="blue" size="8"><b>修改密码</b>
					</font>
				</div>
			</td>
		</tr>
		<tr>
			<td height="30" width="20%">
				<div align="right" class="STYLE1">用户名：</div></td>
			<td>
				<div align="left" class="STYLE1" style="padding-left:10px;">
					<input style="height: 20px;width: 200px" name="userName" readonly="readonly" value="${user.userName }"/>
					*用户登录的名称
				</div>
			</td>
		</tr>
		<tr>
			<td height="30" width="20%">
				<div align="right" class="STYLE1">旧密码：</div></td>
			<td>
				<div align="left" class="STYLE1" style="padding-left:10px;">
					<input type="password" style="height: 20px;width: 200px" name="userPassword"/>
				</div>
			</td>
		</tr>
		<tr>
			<td height="30" width="20%">
				<div align="right" class="STYLE1">新密码：</div></td>
			<td>
				<div align="left" class="STYLE1" style="padding-left:10px;">
					<input type="password" style="height: 20px;width: 200px" name="newPwd1"/>
				</div>
			</td>
		</tr>
		<tr>
			<td height="30" width="20%">
				<div align="right" class="STYLE1">确认密码：</div></td>
			<td>
				<div align="left" class="STYLE1" style="padding-left:10px;">
					<input type="password" style="height: 20px;width: 200px" name="newPwd2"/>
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="4" style="padding: 10px">
				<div align="center">
					<input type="button" value="　保　存　" class="input_btn_style1" onclick="allocation();"/> 
					<input
						id="backBt" type="button" value="　关   闭　" class="input_btn_style1"
						onclick="javascript:window.close();" />
				</div>
			</td>
		</tr>
	</table>
</div>
  </body>
</html>
