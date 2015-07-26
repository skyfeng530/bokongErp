<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../../common/include.jsp"%>
<script src="${pageContext.servletContext.contextPath }/js/workflow/storageOut.js" type="text/javascript"></script>
<table id="inputData" class="ttab" height="100" width="90%" border="0"
	cellpadding="0" cellspacing="1" align="center">
	<tr>
		<td height="30" colspan="2" width="10%">
			<div align="right" class="STYLE1">项目名称：</div></td>
		<td colspan="2">
			<div id="projectName" align="left" class="STYLE1" style="padding-left:10px;">
			</div>
		</td>
	</tr>
	<tr>
		<td height="30" colspan="2" width="10%">
			<div align="right" class="STYLE1">任务编号：</div></td>
		<td colspan="2">
			<div id="taskNumber" align="left" class="STYLE1" style="padding-left:10px;">
			</div>
		</td>
	</tr>
	<tr>
		<td height="30" colspan="2" width="10%">
			<div align="right" class="STYLE1">器件类型：</div></td>
		<td colspan="2">
			<div id="deviceType" align="left" class="STYLE1" style="padding-left:10px;">
			</div>
		</td>
	</tr>
	<tr>
		<td height="30" colspan="2" width="10%">
			<div align="right" class="STYLE1">出库方式：</div></td>
		<td colspan="2">
			<div align="left" class="STYLE1"  style="padding-left:10px;">
				<input id="ploidyRadio"  onclick="libraryMode()" name="LibraryMode" type="radio" value="0" checked="checked"/>整套
				<input id="devicesRadio" onclick="libraryMode()"  name="LibraryMode" type="radio" value="1"/>器件
			</div>
		</td>
	</tr>
	<tr id="ploidyId">
		<td height="30" colspan="2" width="10%">
		    <div align="right" class="STYLE1">套数：</div></td>
		<td colspan="2">
			<div id="ploidyNum" align="left" class="STYLE1" style="padding-left:10px;">
			</div>
		</td>
	</tr>
</table>