
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>articles</title>
</head>
<body>
	<div class="container">
		<table class="table">
			<tr>
				<th>type</th>
				<th>id</th>
				<th>nombre de disques</th>
				<th>bonus</th>
				<th>3D</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${articles}" var="article">
				<tr>
					<td><c:choose>
							<c:when test="${article.getClass().simpleName=='Dvd' }">
								Dvd
							</c:when>
							<c:otherwise>
								Blu-ray
							</c:otherwise>
						</c:choose></td>
					<td>${article.id}</td>
					<td>${article.nbDisques }</td>
					<td><c:if
							test="${article.getClass().simpleName=='Dvd' && article.bonus}">
							<input type="checkbox" checked="checked" disabled="disabled">
						</c:if></td>
					<td><c:if
							test="${article.getClass().simpleName=='Blueray' && article.troisD}">
							<input type="checkbox" checked="checked" disabled="disabled">
						</c:if></td>
					<td>supprimer</td>
					<td><a href="./edit?id=${article.id}" class="btn btn-info">editer</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="./adddvd" class="btn btn-info">ajout dvd</a> <a
			href="./addbluray" class="btn btn-info">ajout blu-ray</a>
	</div>
</body>
</html>