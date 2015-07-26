<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../common/common-css.jsp"%>
<%@include file="../../common/taglib.jsp"%>
<%@include file="../../common/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>仓库管理员备料</title>
<link type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath }/style/blue/pageCommon.css"></link>
<script src="${pageContext.servletContext.contextPath }/js/workflow/storageOutStock.js" type="text/javascript"></script>
</head>
<body>
<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.servletContext.contextPath }/style/images/title_arrow.gif"/> 填写出料单
        </div>
        <div id="Title_End"></div>
    </div>
</div>
<!--显示表单内容-->
<table style="width: 98%;margin: 10px">
  <tr>
  <td>项目名称：aaa</td>
  <td>任务标号：aaa</td>
  <td>出料套数：aaa</td>
  </tr>
</table>
<div id="main_id" style="margin: 10px"></div>
<div id="update_id" style="margin: 10px"></div>
<table style="width: 120px;margin-left: auto;margin-right: auto">
  <tr>
  <td id="submit_id"></td>
  <td id="cancel_id"></td>
  </tr>
</table>
<div class="Description">
	使用说明：<br />
	1：填写页面中的表单。<br />
	2：填写好后点击提交。<br />
	<br />
	说明2：提交表单后，就会按照 模板对应的流程 开始流转。
</div>
</body>
</html>