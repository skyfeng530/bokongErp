<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="../../common/common-css.jsp"%>
<%@include file="../../common/taglib.jsp"%>
<%@include file="../../common/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>提交申请</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath }/style/blue/pageCommon.css" />
    <script language="javascript"  src="${pageContext.servletContext.contextPath }/js/workflow/states.js"></script>
    <script language="javascript"  src="${pageContext.servletContext.contextPath }/js/workflow/eventFunction.js"></script>
    <script language="javascript"  src="${pageContext.servletContext.contextPath }/js/workflow/Unqualifiedtrial_view.js"></script>
    <script type="text/javascript">
     var pdid = ${pdid};
    </script>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.servletContext.contextPath }/style/images/title_arrow.gif"/> 填写${pd.name}
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id="main_id"></div>

<div class="Description">
	使用说明：<br />
	1：填写页面中的表单。<br />
	2：填写好后点击提交。<br />
	<br />
	说明2：提交表单后，就会按照 模板对应的流程 开始流转。
</div>

</body>
</html>