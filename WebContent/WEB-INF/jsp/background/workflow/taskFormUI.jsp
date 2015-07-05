<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="../../common/common-css.jsp"%>
<%@include file="../../common/common-js.jsp"%>
<%@include file="../../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>提交申请</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath }/style/blue/pageCommon.css" />
    <script type="text/javascript">
    	function inputDisable(){
			var input1 = $('#inputData input');
			for(var i = 0 ; i < input1.length; i++){
				input1[i].setAttribute("disabled","disabled");
			}
			var input1 = $('#inputData textarea');
			for(var i = 0 ; i < input1.length; i++){
				input1[i].setAttribute("disabled","disabled");
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
            <img border="0" width="13" height="13" src="${pageContext.servletContext.contextPath }/style/images/title_arrow.gif"/> 审批流程
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <form action="${pageContext.servletContext.contextPath }/background/workflow/submitTask.html" method="post">
		<div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.servletContext.contextPath }/style/blue/images/item_point.gif" /> 请假流程审批 </div> 
        </div>
        <div class="ItemBlockBorder">
        	<jsp:include page="page/${url}.jsp"/>
        	<table class="ttab" height="100" width="90%" border="0"
				cellpadding="0" cellspacing="1" align="center">
				<tr>
					<td height="30" colspan="4" class="STYLE1" style="padding-left:10px;">审批意见：</td>
				</tr>
				<tr>
					<td height="30" colspan="4" class="STYLE1" style="padding-left:10px;">
						<textarea name="comment" id="s" cols="90" rows="3"></textarea>
					</td>
				</tr>
				<tr>
					<td height="30" colspan="2" width="20%">
						<div align="right" class="STYLE1">下一步处理人：</div></td>
					<td colspan="2">
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<select name="nextName" style="height: 20px;width: 200px">
								<option value="">==请选择==</option>
								<c:forEach var="key" items="${users}">
									<option value="${key.userName}">${key.userName}</option>
								</c:forEach>
							</select>
						</div>
					</td>
				</tr>
			</table>
		</div>
        <!-- 表单操作 -->
        <div id="InputDetailBar">
        	<input type="hidden" name="taskId" value="${taskId}">
        	<input type="hidden" name="id" value="${leave.id}">
        	<input type="hidden" name="pdkey" value="${leave.id}">
			<c:forEach var="key" items="${outcomeList}">
				<input type="submit" name="outcome" class="input_btn_style1" value="${key}"/>
			</c:forEach>
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
<div class="Description">
	使用说明：<br />
	1：填写页面中的表单。<br />
	2：填写好后点击提交。<br />
	<br />
	说明2：提交表单后，就会按照 模板对应的流程 开始流转。
</div>

</body>
</html>