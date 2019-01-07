<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>success.jsp ${user.username }</h1>
	${page.getPageNum() }/${page.getPages() }
	<h2>
		<c:forEach items="${page.getResult() }" var="u">
			${u.id } - ${u.username }<br/>
		</c:forEach>
	</h2>
	
</body>
</html>