<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客一覧画面</title>
</head>
<body>
	<h2>顧客一覧画面</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>名前</th>
			<th>Eメールアドレス</th>
			<th></th>
		</tr>
		<c:forEach items="${customers}" var="customer">
			<tr>
				<td><c:out value="${customer.id}" /></td>
				<td><c:out value="${customer.name}" /></td>
				<td><c:out value="${customer.emailAddress}" /></td>
				<td><c:url value="/customer/${customer.id}" var="url" /> <a
					href="${url}">詳細</a> <c:url value="/customer/${customer.id}/edit"
						var="url" /> <a href="${url }">編集</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>