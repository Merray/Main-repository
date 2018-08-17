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
<title>Welcome to my super web page</title>
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
<link rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="eleves.js" defer></script>
</head>
<body class="container">
	<div>
		<header>
			<div class="jumbotron jumbotron-fluid">
				<div class="row">
					<div class="col-sm-3">
						<img src="../images/book.png" alt=":(">
					</div>
					<div class="col-sm-9">
						<h1 class="display-4">Le Site Des Adhérent</h1>
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
					<td><a href="adherent?q=delete&id=${adherent.id}"
						class="btn btn-danger">Supprimer</a></td>
					<td><a href="adherent?q=edit&id=${adherent.id}"
						class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter2">Edition</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="row">
		<div class=col-sm-2>
			<button type="button" class="btn btn-success btn-lg b1"
				data-toggle="modal" data-target="#exampleModalCenter">Ajouter</button>
		</div>
		<div class=col-sm-2>
			<button class="btn btn-primary btn-lg b1" type="button"
				data-toggle="collapse" data-target="#collapseExample"
				aria-expanded="false" aria-controls="collapseExample">A
				propos</button>

		</div>
		<div class="collapse" id="collapseExample">
			<div class="card card-body">Ceci est un site qui gère les adhérents d'un videoclub</div>
		</div>
	</div>
	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalCenterTitle">Ajouter
						une personne</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form>
						<div>
							<label for="exampleFormControlInput1">Civilite</label> <select
								class="form-control" id="civilite">
								<option disabled="disabled" selected="selected">Votre
									civilité...</option>
								<option>Mr</option>
								<option>Mme</option>
								<option>Mlle</option>
								<option>Autre (mdr)</option>
							</select>

						</div>
						<div class="form-group">
							<label for="exampleFormControlInput1">Nom</label> <input
								type="email" class="form-control" id="nom"
								placeholder="Nom de l'adhérent">
						</div>
						<div class="form-group">
							<label for="exampleFormControlInput1">Prénom</label> <input
								type="email" class="form-control" id="prenom"
								placeholder="Prénom de l'adhérent">
						</div>
						<div class="form-group">
							<label for="exampleFormControlInput1">Rue</label> <input
								type="email" class="form-control" id="rue"
								placeholder="ex: 3 rue des Lilas">
						</div>
						<div class="form-group">
							<label for="exampleFormControlInput1">Code Postal</label> <input
								type="email" class="form-control" id="cp"
								placeholder="ex: 95000 ">
						</div>
						<div class="form-group">
							<label for="exampleFormControlInput1">Ville</label> <input
								type="email" class="form-control" id="ville"
								placeholder="ex : Paris">
						</div>

					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Fermer</button>
					<button type="button" class="btn btn-primary" onclick="ajouter()"
						data-dismiss="modal">OK</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="exampleModalCenter2" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalCenterTitle">Modifier
						une personne</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form>
						<div>
							<label for="exampleFormControlInput1">Civilite</label> <select
								class="form-control" id="civilite">
								<option disabled="disabled" selected="selected">Votre
									civilité...</option>
								<option>Mr</option>
								<option>Mme</option>
								<option>Mlle</option>
								<option>Autre (mdr)</option>
							</select>

						</div>
						<div class="form-group">
							<label for="exampleFormControlInput1">Nom</label> <input
								type="email" class="form-control" id="nom"
								placeholder="Nom de l'adhérent">
						</div>
						<div class="form-group">
							<label for="exampleFormControlInput1">Prénom</label> <input
								type="email" class="form-control" id="prenom"
								placeholder="Prénom de l'adhérent">
						</div>
						<div class="form-group">
							<label for="exampleFormControlInput1">Rue</label> <input
								type="email" class="form-control" id="rue"
								placeholder="ex: 3 rue des Lilas">
						</div>
						<div class="form-group">
							<label for="exampleFormControlInput1">Code Postal</label> <input
								type="email" class="form-control" id="cp"
								placeholder="ex: 95000 ">
						</div>
						<div class="form-group">
							<label for="exampleFormControlInput1">Ville</label> <input
								type="email" class="form-control" id="ville"
								placeholder="ex : Paris">
						</div>

					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Fermer</button>
					<button type="button" class="btn btn-primary" onclick="ajouter()"
						data-dismiss="modal">OK</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>