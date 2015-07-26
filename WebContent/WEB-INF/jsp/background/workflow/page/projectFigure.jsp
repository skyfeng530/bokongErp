<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table id="inputData" class="ttab" height="100" width="90%" border="0"
	cellpadding="0" cellspacing="1" align="center">
	<tr>
		<td height="30" colspan="2" width="10%">
			<div align="right" class="STYLE1">项目名称：</div></td>
		<td colspan="2">
			<div align="left" class="STYLE1" style="padding-left:10px;">
				<input style="height: 20px;width: 400px" name="projectName" value="${projectFigure.projectName }"/>
			</div>
		</td>
	</tr>
	<tr>
		<td height="30" colspan="2" width="10%">
			<div align="right" class="STYLE1">任务名称：</div></td>
		<td colspan="2">
			<div align="left" class="STYLE1" style="padding-left:10px;">
				<input style="height: 20px;width: 400px" name="taskName" value="${projectFigure.taskName }"/>
			</div>
		</td>
	</tr>
	<tr>
		<td height="30" colspan="2" width="10%">
			<div align="right" class="STYLE1">零件类型：</div></td>
		<td colspan="2">
			<div align="left" class="STYLE1" style="padding-left:10px;">
				<input style="height: 20px;width: 400px" name="materialType" value="${projectFigure.materialType }"/>
			</div>
		</td>
	</tr>
	<tr>
		<td height="30" colspan="2" width="10%">
			<div align="right" class="STYLE1">图号：</div></td>
		<td colspan="2">
			<div align="left" class="STYLE1" style="padding-left:10px;">
				<input style="height: 20px;width: 400px" name="materialNumber" value="${projectFigure.materialNumber }"/>
			</div>
		</td>
	</tr>
	<tr>
		<td height="30" colspan="2" width="10%">
			<div align="right" class="STYLE1">子图号：</div></td>
		<td colspan="2">
			<div align="left" class="STYLE1" style="padding-left:10px;">
				<input style="height: 20px;width: 400px" name="subTypeNumber" value="${projectFigure.subTypeNumber }"/>
			</div>
		</td>
	</tr>
	<tr>
		<td height="30" colspan="2" width="10%">
			<div align="right" class="STYLE1">名称：</div></td>
		<td colspan="2">
			<div align="left" class="STYLE1" style="padding-left:10px;">
				<input style="height: 20px;width: 400px" name="pfName" value="${projectFigure.pfName }"/>
			</div>
		</td>
	</tr>
	<tr>
		<td height="30" colspan="2" width="10%">
			<div align="right" class="STYLE1">图纸要求：</div></td>
		<td colspan="2">
			<div align="left" class="STYLE1" style="padding-left:10px;">
				<input style="height: 20px;width: 400px" name="testRequirements" value="${projectFigure.testRequirements }"/>
			</div>
		</td>
	</tr>
	<tr>
		<td height="30" colspan="4" class="STYLE1" style="padding-left:10px;">备注：</td>
	</tr>
	<tr>
		<td height="30" colspan="4" class="STYLE1" style="padding-left:10px;">
			<textarea name="bak" id="s" cols="90" rows="3">${projectFigure.bak }</textarea>
		</td>
	</tr>
</table>