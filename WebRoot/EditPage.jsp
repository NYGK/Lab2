<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>EditPage</title>
    
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
     <h2>编辑图书</h2><br/>
     		
        <s:form action  = "UpdateBook">
        	
            <s:textfield name = "detail.ISBN" label = "ISBN（不可修改）"></s:textfield>
			<s:textfield name = "detail.Title" label = "书名"></s:textfield>
			<s:textfield name = "detail.Publisher" label = "出版商"></s:textfield>
			<s:textfield name = "detail.PublishDate" label = "出版日期"></s:textfield>
			<s:textfield name = "detail.Price" label = "价格"></s:textfield>
			<s:textfield name = "detail.AuthorID" label = "作者ID"></s:textfield>
			<s:textfield name = "detail.AuthorName" label = "作者姓名"></s:textfield>
			<s:textfield name = "detail.AuthorAge" label = "作者年龄"></s:textfield>
			<s:textfield name = "detail.AuthorCountry" label = "国家"></s:textfield>
			<s:submit value ="提交"/>
		</s:form>
  </body>
</html>
