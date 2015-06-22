<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<TITLE>ERP管理系统</TITLE>
	<LINK HREF="${pageContext.servletContext.contextPath }/style/blue/login.css" type=text/css rel=stylesheet />
	<script type="text/javascript">
	  function checkUserForm(){
	    var userName = $("#loginName").val();
	    var userPassword = $("#password").val();
	    if(userName=="" || userPassword==""){
	      alert("用户名或密码不能为空");
	      return false;
	    	}
	          document.loginForm.submit();
	     }
	      //按回车键
	     document.onkeydown=function(){
          if (event.keyCode == 13){
            checkUserForm();
          }
         };
	</script>
</HEAD>

<BODY LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0 CLASS=PageBody >
<FORM METHOD="post" NAME="actForm" ACTION="${pageContext.servletContext.contextPath }/background/loginCheck.html">
    <DIV ID="CenterAreaBg">
        <DIV ID="CenterArea">
            <DIV ID="LogoImg"><IMG BORDER="0" SRC="${pageContext.servletContext.contextPath }/style/blue/images/logo.png" /></DIV>
            <DIV ID="LoginInfo">
            	<span style="color: yellow;font-size: 12px;">${error}</span>
                <TABLE BORDER=0 style="margin-left: 30px;margin-top: 20px;" CELLSPACING=0 CELLPADDING=0 width=100%>
                    <TR>
                        <TD width=45 CLASS="Subject"><IMG BORDER="0" SRC="${pageContext.servletContext.contextPath }/style/blue/images/login/userId.gif" /></TD>
                        <TD>
                        <INPUT SIZE="20" CLASS="TextField" TYPE="text" ID="loginName" NAME="username" /></TD>
                        <TD ROWSPAN="2" STYLE="padding-left:10px;">
                        <INPUT TYPE="image" SRC="${pageContext.servletContext.contextPath }/style/blue/images/login/userLogin_button.gif"/></TD>
                    </TR>
                    <TR>
                        <TD CLASS="Subject"><IMG BORDER="0" SRC="${pageContext.servletContext.contextPath }/style/blue/images/login/password.gif" /></TD>
                        <TD><INPUT SIZE="20" CLASS="TextField" TYPE="password" ID="password" NAME="password" /></TD>
                    </TR>
                </TABLE>
            </DIV>
            <DIV ID="CopyRight"><A HREF="javascript:void(0)">&copy; 2015 版权所有  XXXX</A></DIV>
        </DIV>
    </DIV>
</FORM>
</BODY>

</HTML>

