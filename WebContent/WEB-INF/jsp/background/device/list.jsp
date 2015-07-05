<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="../../common/taglib.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="../../common/common-css.jsp" %>
<%@include file="../../common/common-js.jsp" %>
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath }/css/fenyecss.css" />
</head>
<body>
<form id="fenye" name="fenye" action="${pageContext.servletContext.contextPath }/background/device/list.html" method="post">
<table width="100%">
  <tr>
    <td height="30" background="${pageContext.servletContext.contextPath }/images/tab_05.gif"><table width="100%">
      <tr>
        <td width="12" height="30"><img src="${pageContext.servletContext.contextPath }/images/tab_03.gif" width="12" height="30" /></td>
        <td><table width="100%">
          <tr>
            <td width="46%" valign="middle"><table width="100%">
              <tr>
                <td width="5%"><div align="center"><img src="${pageContext.servletContext.contextPath }/images/tb.gif" width="16" height="16" /></div></td>
                <td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：设备管理-设备列表</td>
              </tr>
            </table></td>
            <td width="54%"><table align="right" >
              <tr>
                <td width="60"><table width="87%" >
                  <tr>
                    <td class="STYLE1"><div align="center">
                      <input type="checkbox" name="checkbox11" id="choseAll" onclick="selectAllCheckBox()" />
                    </div></td>
                    <td class="STYLE4">全选</td>
                  </tr>
                </table></td>
                <td width="52"><table width="88%">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="${pageContext.servletContext.contextPath }/images/11.gif" width="14" height="14" /></div></td>
                    <td class="STYLE4">
                    <a href="javascript:void(0);"  onclick="return deleteAll()">
                    	删除
                    </a>
                    	</td>
                  </tr>
                </table></td>
                <td width="60"><table width="90%">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="${pageContext.servletContext.contextPath }/images/22.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><div align="center"><a href="${pageContext.servletContext.contextPath }/background/device/addDevice.html">新增</a></div></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="16"><img src="${pageContext.servletContext.contextPath }/images/tab_07.gif" width="16" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
  <td align="center">
  <!-- 这里的表单 name 必须是fenye -->
  	<div class="search_k" align="left">
		<fieldset class="search">
			<legend><img src="${pageContext.servletContext.contextPath }/images/search_btn.gif" align="middle"/>&nbsp;<span class="STYLE1" style="color: blue;">高级查找</span></legend>
			<div class="search_content">
				设备名称：<input type="text" name="deviceName" value="${param.deviceName}" style="height: 20px"/>　　
				<input type="submit" value="开始查询" class="input_btn_style1"/>&nbsp;&nbsp;
				<input type="reset" value="重置" class="input_btn_style1"/>
			</div>
		</fieldset>
	</div>
  </td>
  </tr>
  <tr>
    <td><table class="listtable" width="100%">
      <tr>
        <td width="8" background="${pageContext.servletContext.contextPath }/images/tab_12.gif">&nbsp;</td>
        <td><table class="ttab" width="100%" cellspacing="1" onmouseover="changeto()"  onmouseout="changeback()">
          <tr>
            <td width="3%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif" >
              <input id="chose" type="checkbox" name="checkbox" onclick="selectAllCheckBox()" />
            </td>
 
            <td width="8%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif" ><span class="STYLE1">设备名称</span></td>
            <td width="6%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif" ><span class="STYLE1">型号</span></td>
            <td width="6%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">类型</td>
            <td width="6%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">数量</td>
            <td width="6%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">是否检查</td>
            <td width="9%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">厂商</td>
            <td width="9%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">厂商电话</td>
            <td width="10%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">生产日期</td>
            <td width="10%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">过期时间</td>
            <td width="6%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">设备状态</td>
            <td width="12%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">备注</td>
          </tr>
          
          <c:forEach var="key" items="${pageView.records}">
          <tr>
            <td height="20" >
              <input type="checkbox" name="check" value="${key.id}" />
            </td>
            
            <td height="20" ><span class="STYLE1">${key.deviceName}</span></td>
            <td height="20" ><span class="STYLE1">${key.deviceVersion}</span></td>
            <c:if test="${key.deviceType eq 0}">
            	<td height="20" ><span class="STYLE1">元器件</span></td>
            </c:if>
            <c:if test="${key.deviceType eq 1}">
            	<td height="20" ><span class="STYLE1">成品</span></td>
            </c:if>
            <c:if test="${key.deviceType eq 2}">
            	<td height="20" ><span class="STYLE1">半成品</span></td>
            </c:if>
            <td height="20" ><span class="STYLE1" style="color: blue;">${key.deviceCount}</span></td>
            <c:if test="${key.ischeckout eq 0}">
	            <td height="20" ><span class="STYLE1">否</span></td>
            </c:if>
            <c:if test="${key.ischeckout ne 0}">
	            <td height="20" ><span class="STYLE1">是</span></td>
            </c:if>
            <td height="20" ><span class="STYLE1">${key.manufacturers}</span></td>
            <td height="20" ><span class="STYLE1">${key.manufacturersPhone}</span></td>
            <td height="20" ><span class="STYLE1">
            <fmt:parseDate value="${key.productDate}" var="date" pattern="yyyy-MM-dd HH:mm" />
			<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm" />
            </span></td>
            <td height="20" ><span class="STYLE1">
            <fmt:parseDate value="${key.outDate}" var="date" pattern="yyyy-MM-dd HH:mm" />
			<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm" />
            </span></td>
            <c:if test="${key.deviceStatus eq 0}">
	            <td height="20" ><span class="STYLE1">在库</span></td>
            </c:if>
            <c:if test="${key.deviceStatus ne 0}">
	            <td height="20" ><span class="STYLE1">出库</span></td>
            </c:if>
            <td height="20" ><span class="STYLE1">${key.remark}
            	</span></td>
          </tr>
          </c:forEach>
        </table></td>
        <td width="8" background="${pageContext.servletContext.contextPath }/images/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="35" background="${pageContext.servletContext.contextPath }/images/tab_19.gif"><%@include file="../../common/webfenye.jsp" %>
    </td>
  </tr>
</table>
</form>
</body>
</html>