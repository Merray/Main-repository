<%@page import="model.Adherent"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<title>adherents</title>
</head>
<body>
	<div class="container">
		<header>
			<div class="jumbotron jumbotron-fluid">
				<div class="row">
					<div class="col-sm-3">
						<img src="../images/book.png" alt=":(">
					</div>
					<div class="col-sm-9">
						<h1 class="display-4">Le Site Des Adhérents</h1>
						<p class="lead">Votre partenaire cinématographique tout au
							long de l'année</p>
					</div>
				</div>


			</div>

		</header>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Identifiant</th>
					<th scope="col">Civilite</th>
					<th scope="col">Prenom</th>
					<th scope="col">Nom</th>
					<th scope="col">Rue</th>
					<th scope="col">Code postal</th>
					<th scope="col">Ville</th>
					<th scope="col"></th>
					<th scope="col"></th>
				</tr>
			</thead>
			<c:forEach items="${adherents}" var="adherent">
				<tr>
					<td>${adherent.id}</td>
					<td>${adherent.civilite}</td>
					<td>${adherent.prenom}</td>
					<td>${adherent.nom }</td>
					<td>${adherent.adresse.rue}</td>
					<td>${adherent.adresse.cp}</td>
					<td>${adherent.adresse.ville}</td>
					<td><a href="./delete?id=${adherent.id}"
						class="btn btn-danger">supprimer</a></td>
					<td><a href="./edit?id=${adherent.id}" class="btn btn-primary">edition</a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="row">
			<div class=col-sm-2>
				<a href="./add" class="btn btn-success btn-lg b1">Ajouter</a>
			</div>
			<div class=col-sm-2>
				<button class="btn btn-primary btn-lg b1" type="button"
					data-toggle="collapse" data-target="#collapseExample"
					aria-expanded="false" aria-controls="collapseExample">A
					propos</button>

			</div>
			<div class="collapse" id="collapseExample">
				<div class="card card-body">Ceci est un site qui gère les
					adhérents d'un videoclub</div>
			</div>
		</div>

	</div>
</body>
</html>