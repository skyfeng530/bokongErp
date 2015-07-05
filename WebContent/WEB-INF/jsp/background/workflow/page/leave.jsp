<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table id="inputData" class="ttab" height="100" width="90%" border="0"
	cellpadding="0" cellspacing="1" align="center">
	<tr>
		<td height="30" colspan="2" width="10%">
			<div align="right" class="STYLE1">请假天数：</div></td>
		<td colspan="2">
			<div align="left" class="STYLE1" style="padding-left:10px;">
				<input style="height: 20px;width: 400px" name="days" value="${leave.days }"/>
			</div>
		</td>
	</tr>
	<tr>
		<td height="30" colspan="2" width="10%">
			<div align="right" class="STYLE1">请假内容：</div></td>
		<td colspan="2">
			<div align="left" class="STYLE1" style="padding-left:10px;">
				<input style="height: 20px;width: 400px" name="content" value="${leave.content }"/>
			</div>
		</td>
	</tr>
	<tr>
		<td height="30" colspan="4" class="STYLE1" style="padding-left:10px;">备注：</td>
	</tr>
	<tr>
		<td height="30" colspan="4" class="STYLE1" style="padding-left:10px;">
			<textarea name="remark" id="s" cols="90" rows="3">${leave.remark }</textarea>
		</td>
	</tr>
</table>