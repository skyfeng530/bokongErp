<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>不合格品审理记录</title>
<style type="text/css">
td,tr {
	font-size: 12px;
  border:1px solid #000000;
  border-width: 1px 0px 0px 1px; 
}

.tab{
  width:600px;
  height:auto;
 }
 .tab li{
  width:150px;
  height:74px;
  border:1px solid #000000;
  border-width:0px 1px 0px 0px;
  list-style:none;
  float:left;
  }
  
  .tab1{
  width:600px;
  height:auto;
 }
 .tab1 li{
  width:100px;
  height:74px;	
  border:1px solid #000000;
  border-width:0px 1px 0px 0px;
  list-style:none;
  float:left;
  }

</style></head>

<body>
<div style="border:1px solid #000000; width:794px; height:1123px;margin-left: auto; margin-right: auto; padding-top:50px;">
  <table width="649" height="778" cellpadding="3" cellspacing="1" style="border:2px solid #000000;" align="center">
   <caption align="top">
    <strong>研制过程相关问题报告和处理单<br />
    </strong><br />
    <br />
      <div style="float:right;">序号：</div>
    </caption>
    <tr>
      <td width="80" height="48"><div align="center">报告部门</div></td>
      <td width="109">&nbsp;</td>
      <td width="89"><div align="center">报告人或联系人</div></td>
      <td width="155">&nbsp;</td>
      <td width="50"><div align="center">报告时间</div></td>
      <td width="119">&nbsp;</td>
    </tr>
    <tr>
      <td height="48"><div align="center">问题类型</div></td>
      <td colspan="5"><form id="form1" name="form1" method="post" action="">
        <label>
          <input type="checkbox" name="checkbox" value="checkbox" />
          设计</label>
        <label>
        <input type="checkbox" name="checkbox2" value="checkbox" />
        工艺</label>
        <label>
        <input type="checkbox" name="checkbox3" value="checkbox" />
        条件</label>
        <label>
        <input type="checkbox" name="checkbox4" value="checkbox" />
        操作</label>
        <label>
        <input type="checkbox" name="checkbox5" value="checkbox" />
        其他</label>
      </form>
      </td>
    </tr>
    <tr>
      <td height="205"><div align="center">问题简述</div></td>
      <td colspan="5">&nbsp;</td>
    </tr>
    <tr>
      <td height="191"><div align="center">项目指挥批示（需要时）</div></td>
      <td colspan="5">&nbsp;</td>
    </tr>
    <tr>
      <td height="180"><div align="center">处理过程及措施简述</div></td>
      <td colspan="5">&nbsp;</td>
    </tr>
    <tr>
      <td><div align="center">处理结果确认</div></td>
      <td colspan="5"><form id="form2" name="form2" method="post" action="">
        <label>
          <input type="checkbox" name="checkbox6" value="checkbox" />
          完成</label>
        <label>
        <input type="checkbox" name="checkbox7" value="checkbox" />
        待观察</label>
        <label>
        <input type="checkbox" name="checkbox8" value="checkbox" />
        重新处理 </label>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <label>签字/日期：</label>
      </form>
      </td>
    </tr>
    <tr>
      <td height="157"><div align="center">报告处理结果验证</div></td>
      <td colspan="5">&nbsp;</td>
    </tr>
  </table>
</div>
</body>
</html>