<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="../../common/common-css.jsp"%>
<%@include file="../../common/common-js.jsp"%>
<%@include file="../../common/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请假任务办理</title>
<link type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath }/style/blue/pageCommon.css" />
    <script type="text/javascript">
    	function inputDisable(){
			var input1 = $('#inputData input');
			for(var i = 0 ; i < input1.length; i++){
				input1[i].setAttribute("disabled","disabled");
			}
			var input2 = $('#inputData textarea');
			for(var i = 0 ; i < input1.length; i++){
				input2[i].setAttribute("disabled","disabled");
			}
    	}
    </script>
</head>
<body onload="javascript:inputDisable();">
<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.servletContext.contextPath }/style/images/title_arrow.gif"/> 审核历史记录
        </div>
        <div id="Title_End"></div>
    </div>
</div>
<!--显示表单内容-->
<div id=MainArea>
    <form action="${pageContext.servletContext.contextPath }/background/workflow/submitTask.html" method="post">
		<div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.servletContext.contextPath }/style/blue/images/item_point.gif" />  </div> 
        </div>
        <div class="ItemBlockBorder">
        	<%-- <jsp:include page="page/${url}.jsp"/> --%>
		</div>
        <!-- 表单操作 -->
        <div id="InputDetailBar">
			<input type="button" onclick="javascript:history.go(-1);" class="input_btn_style1" value="返回"/>
        </div>
    </form>
</div>
<br><br><br>
<div id=MainArea>
    <form action="#" method="post">
		<div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.servletContext.contextPath }/style/blue/images/item_point.gif" /> 显示之前环节审批意见信息 </div> 
        </div>
        <div class="ItemBlockBorder">
        	<table class="ttab" height="100" width="90%" border="0"
				cellpadding="0" cellspacing="1" align="center" onmouseover="changeto()"  onmouseout="changeback()">
		         <tr align="CENTER" valign="MIDDLE" id="TableTitle">
					<td width="20%" height="22" align="center" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">时间</td>
					<td width="20%" height="22" align="center" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">审批人</td>
					<td width="60%" height="22" align="center" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">审批意见</td>
				</tr>
		        <c:forEach var="key" items="${commentList}">
			        <tr>
			            <td align="center">
			            	<fmt:formatDate value="${key.time}" pattern="yyyy-MM-dd HH:mm"/>
			            </td>
						<td align="center">${key.userId}</td>
						<td align="center">${key.fullMessage}</td>
					</tr>
				</c:forEach>
				<c:if test="${empty commentList}">
					<tr><td colspan="3" align="center"><span style="font-size: 18px;color: blue;">没有审批意见</span></td></tr>
				</c:if>
			</table>
		</div>
    </form>
</div>
</body>
</html>