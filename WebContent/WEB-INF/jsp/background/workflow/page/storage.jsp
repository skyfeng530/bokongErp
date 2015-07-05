<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table class="ttab" height="100" width="90%" border="0"
	cellpadding="0" cellspacing="1" align="center">
	<tr>
		<td height="30" width="10%">
			<div align="right" class="STYLE1">图号：</div></td>
		<td>
			<div align="left" class="STYLE1" style="padding-left:10px;">
				<input style="height: 20px;width: 200px" name="materialNumber" />
			</div></td>
		<td height="30" width="10%">
			<div align="right" class="STYLE1">零件名称：</div></td>
		<td>
			<div align="left" class="STYLE1" style="padding-left:10px;">
				<input style="height: 20px;width: 200px" name="name" />
			</div></td>
	</tr>
	<tr>
		<td height="30" width="10%">
			<div align="right" class="STYLE1">类别：</div></td>
		<td>
			<div align="left" class="STYLE1" style="padding-left:10px;">
				<select name="materialType" id="a">
					<option value="">==请选择==</option>
					<option value="0">光学</option>
					<option value="1">机械</option>
				</select>
			</div></td>
		<td height="30" width="10%">
			<div align="right" class="STYLE1">序号：</div></td>
		<td>
			<div align="left" class="STYLE1" style="padding-left:10px;">
				<input style="height: 20px;width: 200px" name="deviceVersion" />
			</div></td>
	</tr>
	<tr>
		<td height="30" width="10%">
			<div align="right" class="STYLE1">数量：</div></td>
		<td>
			<div align="left" class="STYLE1" style="padding-left:10px;">
				<input style="height: 20px;width: 200px" name="deviceName" />
			</div>
		</td>
		<td height="30" width="10%">
			<div align="right" class="STYLE1"></div></td>
		<td>
			<div align="left" class="STYLE1" style="padding-left:10px;">
			</div>
		</td>
	</tr>
	<tr>
		<td height="30" colspan="2" class="STYLE1" style="padding-left:10px;">备注：</td>
		<td height="30" colspan="2" class="STYLE1" style="margin-right: 5px;" align="right">
			<input type="button" class="input_btn_style1" value="添加" style="margin-right: 10px;"/>
		</td>
	</tr>
	<tr>
		<td height="30" colspan="4" class="STYLE1" style="padding-left:10px;">
			<textarea name="remark" id="s" cols="90" rows="3"></textarea>
		</td>
	</tr>
</table>
<br>
<table class="ttab" height="100" width="90%" border="0" cellpadding="0" cellspacing="1" align="center">
	<tr>
		<td height="30" width="10%">
			<div align="right" class="STYLE1">项目名称：</div></td>
		<td>
			<div align="left" class="STYLE1" style="padding-left:10px;">
				<input style="height: 20px;width: 200px" name="materialNumber" />
			</div></td>
		<td height="30" width="10%">
			<div align="right" class="STYLE1">任务编号：</div></td>
		<td>
			<div align="left" class="STYLE1" style="padding-left:10px;">
				<input style="height: 20px;width: 200px" name="name" />
			</div>
		</td>
	</tr>
	<tr>
		<td height="30" width="10%">
			<div align="right" class="STYLE1">交接人：</div></td>
		<td>
			<div align="left" class="STYLE1" style="padding-left:10px;">
				<input style="height: 20px;width: 200px" name="materialNumber" />
			</div>
		</td>
		<td height="30" width="10%">
			<div align="right" class="STYLE1"></div></td>
		<td>
			<div align="left" class="STYLE1" style="padding-left:10px;">
			</div>
		</td>
	</tr>
	<tr>
	<td colspan="6">
		<table class="ttab" width="100%" cellspacing="1" onmouseover="changeto()"  onmouseout="changeback()">
		<tr>
	  		<td width="12%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">图号</td>
	  		<td width="12%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">零件名称</td>
	  		<td width="12%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">类别</td>
	  		<td width="12%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">编号</td>
	  		<td width="12%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">数量</td>
	  		<td width="15%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">备注</td>
  		</tr>
  		<tr>
	 		<td  height="20"><span style="STYLE1">1</span></td>
	 		<td  height="20"><span style="STYLE1">1</span></td>
	 		<td  height="20"><span style="STYLE1">1</span></td>
	 		<td  height="20"><span style="STYLE1">1</span></td>
	 		<td  height="20"><span style="STYLE1">1</span></td>
	 		<td  height="20"><span style="STYLE1">1</span></td>
	 	</tr>
 		</table>
 	</td>
 	</tr>
</table>