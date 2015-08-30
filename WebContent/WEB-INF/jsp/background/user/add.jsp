<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="../../common/common-css.jsp"%>
<script src="${pageContext.servletContext.contextPath }/js/jquery_1_7_2_min.js" type="text/javascript"></script>
  <script type="text/javascript">
  var flag = false;
  function validateUserName(uname){
	  $.ajax({
    		async:false, //请勿改成异步，下面有些程序依赖此请数据
    		type : "POST",
    		data:{userName:uname},
    		url: "${pageContext.servletContext.contextPath }/background/user/checkUserName.html",
    		dataType:'json',
    		success: function(json){
    			if(json == "1000"){
    				$("span[name='uname_tips']").html("");
    				flag = true;
            	}else if(json == "1001"){
            		$("span[name='uname_tips']").html("用户名已存在！");
            		flag = false;
              };
     		}
    	});
  }
  function validate(){
	  var uname = $('input[name="userName"]').val();
	  var upwd = $('input[name="userPassword"]').val();
	  var userRealname = $('input[name="userRealname"]').val();
	  var userBirthday = $('input[name="userBirthday"]').val();
	  var idCard = $('input[name="idCard"]').val();
	  var userPhone = $('input[name="userPhone"]').val();
	  if(!flag){
		  alert("用户名已存在！");
		  return false;
	  }
	  if(uname!=""&&upwd!=""&&userRealname!=""&&userBirthday&&idCard!=""&&userPhone){
		  if(!validateDate(userBirthday)){
			  alert("生日格式错误！");
			  return false;
		  }
		  if(!isPhone(userPhone)){
			  alert("电话号码格式错误！");
			  return false;
		  }
		  if(!isCardNo(idCard)){
			  alert("身份证号码错误！");
			  return false;
		  }
		  return true;
	  }else{
		  alert("参数不能为空！");
		  return false;
	  }
  }
  function validateDate(val){//验证时间2010-10-10
	  var patten = /^\d{4}[\/-]\d{1,2}[\/-]\d{1,2}$/;  
	  return patten.test(val);  
  }
   function isPhone(aPhone) {
       var bValidate = RegExp(/^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/).test(aPhone);
       if (bValidate) {
           return true;
       }
       else{
           return false;
       }
   }
   function isCardNo(card)
   {  
      // 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X  
      var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;  
      if(reg.test(card) === false)  
      {  
          return  false;  
      }else{
    	  return true;
      }
   }
   $(function(){
	   if ("${errorMsg}" == "1") {
		   $("span[name='uname_tips']").html("用户名已存在！");
	   }
   })
  </script>
</head>

<body >
	<div style="height: 100%;overflow-y: auto;">
		<br /> <br />
		<form
			action="${pageContext.servletContext.contextPath }/background/user/add.html" onsubmit="return validate()"
			method="post">
			<table class="ttab" height="100" width="85%" border="0"
				cellpadding="0" cellspacing="1" align="center">
				<tr>
					<td height="30" colspan="4">
						<div align="center">
							<font color="blue" size="8"><b>添加用户信息</b>
							</font>
						</div></td>
				</tr>
				<tr>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">用户名：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="userName" value="${user.userName }" onblur="validateUserName(this.value)"/>
							<span name="uname_tips" style="color: red;"></span>
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
