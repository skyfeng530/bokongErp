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
<form action="${pageContext.servletContext.contextPath }/background/project/figureLib/update.html" method="post">
<input type="hidden" name="id" value="${busProjectFigure.pfid}">
		<table class="ttab" height="100" width="85%" border="0" cellpadding="0" cellspacing="1" align="center">
				<tr>
					<td height="30" colspan="4">
						<div align="center">
							<font color="blue" size="12"><b>修改图库信息</b>
							</font>
						</div></td>
				</tr>
				<tr>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">项目名称：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="pid" value="${busProjectFigure.ppid}"/>
						</div>
					</td>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">产品名称:</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="ppid" value="${busProjectFigure.ppid}"/>
						</div>
					</td>
				</tr>
				<tr>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">图库编号：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="figureNo" value="${busProjectFigure.figureNo}"/>
						</div>
					</td>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">图库名称:</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="figureName" value="${busProjectFigure.figureName}"/>
						</div>
					</td>
				</tr>
				<tr>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">图纸要求：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="figureRequest" value="${busProjectFigure.figureRequest}"/>
						</div>
					</td>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">生产数量:</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="batchNum" value="${busProjectFigure.batchNum}"/>
						</div>
					</td>
				</tr>
				<tr>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">器件类型：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="type" value="${busProjectFigure.type}"/>
						</div>
					</td>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">描述:</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="describe" value="${busProjectFigure.describe}"/>
						</div>
					</td>
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
