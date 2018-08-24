
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>adherents</title>
</head>
<body>
	<div class="container">
		<div>
			<div access="hasRole('ROLE_ADMIN')">
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					logged as:${pageContext.request.userPrincipal.name} 
					<a href="../logout">logout</a>
				</c:if>
			</div>
		</div>
		<table class="table">
			<tr>
				<th>identifiant</th>
				<th>civilite</th>
				<th>prenom</th>
				<th>nom</th>
				<th>date de naissance</th>
				<th>rue</th>
				<th>ville</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${adherents}" var="adherent">
				<tr>
					<td>${adherent.id }</td>
					<td>${adherent.civilite.titre }</td>
					<td>${adherent.prenom }</td>
					<td>${adherent.nom }</td>
					<td><fmt:formatDate value="${adherent.dateNaissance }"
							pattern="dd/MM/yyyy" /></td>
					<td>${adherent.adresse.numero}${adherent.adresse.rue}</td>
					<td>${adherent.adresse.ville }</td>
					<td><a href="./delete?id=${adherent.id}"
						class="btn btn-danger">supprimer</a></td>
					<td><a href="./edit?id=${adherent.id}" class="btn btn-primary">edition</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="./add" class="btn btn-primary">ajouter adherent</a>
	</div>
</body>
</html>