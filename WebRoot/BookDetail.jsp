<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>Book Detail</title>
    
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
  		
        <script type="text/javascript">
            function del()	{
                var flag = false;
                if(confirm('您确定要删除吗？'))	{
                    flag = true;
                }
                return flag;
            }
        </script>
            <h3>书</h3><br/>
            <p>ISBN：<s:property value="detail.ISBN"/></p>
            <p>书名：<s:property value='detail.Title'/></p>
            <p>作者ID：<s:property value='detail.AuthorID'/></p>
            <p>出版社：<s:property value='detail.Publisher'/></p>
            <p>出版日期：<s:property value='detail.PublishDate'/></p>
            <p>价格：¥<s:property value='detail.Price'/></p>
            <h3>作者</h3>
            <p>作者ID：<s:property value="detail.AuthorID"/></p>
            <p>姓名：<s:property value='detail.AuthorName'/></p>
            <p>年龄：<s:property value='detail.AuthorAge'/></p>
            <p>国家：<s:property value='detail.AuthorCountry'/></p>
           
            <a href="EditBook.action?detail.ISBN=${detail.ISBN}">修改</a><br/>
            <a href="deleteBook.action?detail.ISBN=${detail.ISBN}" onclick="return del();">删除</a><br/>

  </body>
</html>
