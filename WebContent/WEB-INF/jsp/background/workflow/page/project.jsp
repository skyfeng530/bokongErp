<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table id="inputData" class="ttab" height="100" width="90%" border="0"
	cellpadding="0" cellspacing="1" align="center">
	<tr>
		<td height="30" colspan="2" width="10%">
			<div align="right" class="STYLE1">项目名称：</div></td>
		<td colspan="2">
			<div align="left" class="STYLE1" style="padding-left:10px;">
				<input style="height: 20px;width: 400px" name="projectName" value="${project.projectName }"/>
			</div>
		</td>
	</tr>
	<tr>
		<td height="30" colspan="2" width="10%">
			<div align="right" class="STYLE1">计划编号：</div></td>
		<td colspan="2">
			<div align="left" class="STYLE1" style="padding-left:10px;">
				<input style="height: 20px;width: 400px" name="taskNumber" value="${project.taskNumber }"/>
			</div>
		</td>
	</tr>
	<tr>
		<td height="30" colspan="4" class="STYLE1" style="padding-left:10px;">简介：</td>
	</tr>
	<tr>
		<td height="30" colspan="4" class="STYLE1" style="padding-left:10px;">
			<textarea name="info" id="s" cols="90" rows="3">${project.info }</textarea>
		</td>
	</tr>
</table>