<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="../../common/common-css.jsp"%>
</head>

<body>
	<div style="height: 100%;overflow-y: auto;">
		<br /> <br />
		<form
			action="${pageContext.servletContext.contextPath }/background/device/add.html"
			method="post">
			<table class="ttab" height="100" width="85%" border="0"
				cellpadding="0" cellspacing="1" align="center">
				<tr>
					<td height="30" colspan="4">
						<div align="center">
							<font color="blue" size="10"><b>添加物料</b>
							</font>
						</div></td>
				</tr>
				<tr>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">物料名称：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="deviceName" />
						</div></td>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">编号：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="deviceVersion" />
						</div></td>
				</tr>
				<tr>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">类型：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<select name="deviceType" id="a">
								<option value="">==请选择==</option>
								<option value="0">元器件</option>
								<option value="1">成品</option>
								<option value="2">半成品</option>
							</select>
						</div></td>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">库存状态：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<select name="deviceStatus">
								<option value="">==请选择==</option>
								<option value="0">是</option>
								<option value="1">否</option>
							</select>
						</div></td>
				</tr>
				<tr>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">数量：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="deviceCount" />
						</div></td>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">是否质检：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<select name="ischeckout">
								<option value="">==请选择==</option>
								<option value="0">是</option>
								<option value="1">否</option>
							</select>
						</div></td>
				</tr>
				<tr>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">厂商：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="manufacturers" />
						</div></td>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">厂商电话：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="manufacturersPhone" />
						</div></td>
				</tr>
				<tr>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">生产日期：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="productDate" />
						</div></td>
					<td height="30" width="10%">
						<div align="right" class="STYLE1">过期时间：</div></td>
					<td>
						<div align="left" class="STYLE1" style="padding-left:10px;">
							<input style="height: 20px;width: 200px" name="outDate" />
						</div></td>
				</tr>
				<tr>
					<td height="30" colspan="4" class="STYLE1" style="padding-left:10px;">备注：</td>
				</tr>
				<tr>
					<td height="30" colspan="4" class="STYLE1" style="padding-left:10px;">
						<textarea name="remark" id="s" cols="100" rows="5"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="4" style="padding: 10px">
						<div align="center">
			 				<input type="submit" value="　保　存　" class="input_btn_style1"/>　　　　
			 				<input id="backBt" type="button" value="　返　回　" class="input_btn_style1" onclick="javascript:window.location.href='javascript:history.go(-1)'"/>
		 				</div>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
