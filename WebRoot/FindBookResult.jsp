<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Result of Finding Author</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <s:form action  = "FindBookWithAuthorName">
			<s:textfield name = "AuthorName"  ></s:textfield>
			<s:submit value ="查询另一个作者"/>
	</s:form>
	<br/>
	<table>
        <tr>
            <td>ISBN</td>
            <td>标题</td>
            <td>作者ID</td>
            <td>出版日期</td>
            <td>价格</td>
        </tr>
        <tr/>
        <s:iterator value="booklist" status="st">
            <tr>
            <td><s:property value="ISBN"/></td>
            <td><a href="ShowBookDetail.action?ISBN=<s:property value="ISBN" />"><s:property value='Title'/></a></td>
            <td><s:property value='AuthorID'/></td>
            <td><s:property value='PublishDate'/></td>
            <td><s:property value='Price'/></td>
            </tr>
        </s:iterator>
    </table>
	<a href = "index.jsp">返回主界面</a>
  </body>
</html>
