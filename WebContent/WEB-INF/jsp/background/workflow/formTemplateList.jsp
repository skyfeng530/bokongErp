<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="../../common/taglib.jsp" %>
<%@include file="../../common/common-css.jsp" %>
<%@include file="../../common/common-js.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>申请模板选择</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="${pageContext.servletContext.contextPath }/script/jquery.js"></script>
    <script language="javascript" src="${pageContext.servletContext.contextPath }/script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="${pageContext.servletContext.contextPath }/script/PageUtils.js" charset="utf-8"></script>
    <script language="javascript" src="${pageContext.servletContext.contextPath }/script/DemoData.js" charset="utf-8"></script>
	<script language="javascript" src="${pageContext.servletContext.contextPath }/script/DataShowManager.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath }/style/blue/pageCommon.css" />
	<link type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath }/style/blue/select.css" />
    <script type="text/javascript">
    </script>
</head>
<body>

<div id="Title_bar" style="margin-bottom: 20px;">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.servletContext.contextPath }/style/images/title_arrow.gif"/> 申请模板选择
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<table width="85%" cellspacing="0" cellpadding="1" border="0" class="TableBorder" style="margin-left: 15px;">
	<tbody>
		<tr>
			<td>
				<table width="100%" cellspacing="0" cellpadding="0" border="0">
					<tr>
						<td class="HeadRight">
							<table height="27" cellspacing="0" cellpadding="0" border="0">
								<tr>
									<td class="HeadLeft">请选择申请模板</td>
									<td width="35" class="HeadMiddle"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td> 
		</tr>
		<c:forEach var="key" items="${pageView.records}">
		<tr>
			<td>
				<!-- 显示表单模板列表 -->
				<div id="DetailBlock"> 
					<img width="16" height="16" src="${pageContext.servletContext.contextPath }/style/images/FileType/doc.gif"/> 
					<a href="applyFormUI.html">${key.name}请假申请</a>
				</div>
			</td>
		</tr>
		</c:forEach>
		<tr>
			<td>
				<!-- 显示表单模板列表 -->
				<c:forEach var="key" items="${pdList}">
					<div id="DetailBlock"> 
						<img width="16" height="16" src="${pageContext.servletContext.contextPath }/style/images/FileType/doc.gif"/> 
						<a href="applyFormUI.html?deploymentId=${key.deploymentId}">${key.name}</a>
					</div>
				</c:forEach>
			</td>
		</tr>
	</tbody>
</table>

<div class="Description">
	说明：此页面是列出所有的表单模板记录<br />
</div>

</body>
</html>