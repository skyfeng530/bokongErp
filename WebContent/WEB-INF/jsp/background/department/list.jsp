<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="../../common/taglib.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="../../common/common-css.jsp" %>
<%@include file="../../common/common-js.jsp" %>
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath }/css/fenyecss.css" />
<script type="text/javascript">
function permissio(dName){
	 var url = "${pageContext.servletContext.contextPath }/background/resources/permissioUser.html?dName="+dName;
	 var h_sp1 = 400;
	 var w_sp1 = 350;
	//兼容IE，firefox,google.模态窗口居中问题
	 var iTop2 = (window.screen.availHeight - 20 - h_sp1) / 2;
	 var iLeft2 = (window.screen.availWidth - 10 - w_sp1) / 2;
	 var params = 'menubar:no;dialogHeight=' + h_sp1 + 'px;dialogWidth=' + w_sp1 + 'px;dialogLeft=' + iLeft2 + 'px;dialogTop=' + iTop2 + 'px;resizable=yes;scrollbars=0;resizeable=0;center=yes;location:no;status:no;scroll:no'
	 window.showModalDialog(url, window, params);
	 //location.href=url;
}
function userRole(dName){
	 var url = "${pageContext.servletContext.contextPath }/background/department/departmentRole.html?dName="+dName;
	 var h_sp1 = 420;
	 var w_sp1 = 600;
	//兼容IE，firefox,google.模态窗口居中问题
	 var iTop2 = (window.screen.availHeight - 20 - h_sp1) / 2;
	 var iLeft2 = (window.screen.availWidth - 10 - w_sp1) / 2;
	 var params = 'menubar:no;dialogHeight=' + h_sp1 + 'px;dialogWidth=' + w_sp1 + 'px;dialogLeft=' + iLeft2 + 'px;dialogTop=' + iTop2 + 'px;resizable=yes;scrollbars=0;resizeable=0;center=yes;location:no;status:no;scroll:no'
	 window.showModalDialog(url, window, params);
	 //location.href=url;
}
</script>
</head>
<body>
<form id="fenye" name="fenye" action="${pageContext.servletContext.contextPath }/background/department/query.html" method="post">
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
                <td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：系统管理-部门列表</td>
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
                    <td class="STYLE1"><div align="center"><a href="${pageContext.servletContext.contextPath }/background/department/addUI.html">新增</a></div></td>
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
 
            <td width="20%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif" ><span class="STYLE1">部门名称</span></td>
            <td width="20%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif" ><span class="STYLE1">所属角色</span></td>
            <td  height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">基本操作</td>
          </tr>
          
          <c:forEach var="key" items="${pageView.records}">
          <tr>
            <td height="20" >
              <input type="checkbox" name="check" value="${key.dName}" />
            </td>
            
            <td height="20" ><span class="STYLE1">${key.dName}</span></td>
            <td height="20" ><span class="STYLE1">${key.roleName }</span></td>
            <td height="20" ><span class="STYLE4">
             <sec:authorize ifAnyGranted="ROLE_sys_user_fenpeirole">
             <img src="${pageContext.servletContext.contextPath }/images/role.png" width="16" height="16" />
            	<a href="javascript:void(0);" onclick="userRole('${key.dName}')">
            	分配角色</a>
            </sec:authorize>
            <sec:authorize ifAnyGranted="ROLE_sys_user_permissions">
            <img src="${pageContext.servletContext.contextPath }/images/resc.png" width="16" height="16" />
            	<a href="javascript:void(0);" onclick="permissio('${key.dName}')">分配权限</a>&nbsp;&nbsp;&nbsp;&nbsp;
            </sec:authorize>
            <sec:authorize ifAnyGranted="ROLE_sys_user_edit">
            <img src="${pageContext.servletContext.contextPath }/images/edt.gif" width="16" height="16" />
            <a href="${pageContext.servletContext.contextPath }/background/department/getById.html?dName=${key.dName}&&type=1">
                                     编辑
            </a>
            &nbsp; &nbsp;
           </sec:authorize>
           <sec:authorize ifAnyGranted="ROLE_sys_user_delete">
            <img src="${pageContext.servletContext.contextPath }/images/del.gif" width="16" height="16" />
            	<a href="javascript:void(0);" onclick="deleteId('${pageContext.servletContext.contextPath }/background/department/deleteById.html?dName=${key.dName}');">
            	删除</a>
            	</sec:authorize>
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