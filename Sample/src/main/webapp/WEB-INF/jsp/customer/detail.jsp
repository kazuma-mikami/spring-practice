<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客詳細画面</title>
</head>
<body>
	<h1>顧客詳細画面</h1>
	<dl>
		<dl>名前
		</dl>
		<dd>
			<c:out value="${customer.name }" />
		</dd>
		<dl>Eメールアドレス
		</dl>
		<dd>
			<c:out value="${customer.emailAddress }" />
		</dd>
		<dt>誕生日</dt>
		<dd>
			<fmt:formatDate pattern="yyyy/MM/dd" value="${customer.birthday}" />
		</dd>
		<dl>好きな数字
		</dl>
		<dd>
			<c:out value="${customer.favoriteNumber}" />
		</dd>
	</dl>
	<c:url value="/customer" var="url" />
	<a href="${url}">一覧</a>
</body>
</html>