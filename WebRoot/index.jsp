<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
 	 <head>
    	<title>WELCOME !</title>
		
  	</head>
  
	

	<body>
		<h1>WELCOME !</h1>
		<s:form action  = "FindBookWithAuthorName">
			<s:textfield name = "AuthorName" label = "请输入你要查询的作者名字"></s:textfield>
			<s:submit value ="查询"/>
		</s:form>
	
		<h2>or</h2>
		
		
		<br/>
		<a href = "AddBook.jsp"><button type = "button">添加书籍</button></a>
	</body>
</html>
