<%@page import="com.example.demo.videoclub.model.Adherent"%>
<%@page import="com.example.demo.videoclub.model.Article"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vidéoclub - Articles</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
	integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="jumbotron">
				<h1>Liste des Articles</h1>
			</div>
		</div>
		<div class="row">
			<table class="table table-striped">
				<tr>
					<th>Identifiant</th>
					<th>Type</th>
					<th>Film</th>
					<th>Nombre de disques</th>
					<th>Bonus</th>
					<th>3D</th>
					<th>Emprunteur</th>
					<th>Id Emprunteur</th>
					<th>Modifications</th>
				</tr>
				<c:forEach items="${articles}" var="article">
					<tr>
						<td>${article.id}</td>
						<td>${article.getClass().simpleName}</td>
						<td>${article.film.titre}</td>
						<td>${article.nbDisques}</td>
						<td><c:if
								test="${article.getClass().simpleName == 'Dvd' && article.bonus}">
								<input type="checkbox" checked="checked" disabled="disabled" />
							</c:if></td>
						<td><c:if
								test="${article.getClass().simpleName == 'Blueray' && article.troisD}">
								<input type="checkbox" checked="checked" disabled="disabled" />
							</c:if></td>
						<td>${article.emprunteur.prenom}${article.emprunteur.nom}</td>
						<td>${article.emprunteur.id}</td>
						<td><a href="./update?id=${article.id}"
							class="btn btn-warning">Modifier</a> <a
							href="./delete?id=${article.id}" class="btn btn-danger">Supprimer</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<a href="./createdvd" class="btn btn-success">Ajouter un Dvd</a> <a
				href="./createblueray" class="btn btn-success">Ajouter un
				Blu-ray</a>
		</div>
	</div>
</body>
</html>