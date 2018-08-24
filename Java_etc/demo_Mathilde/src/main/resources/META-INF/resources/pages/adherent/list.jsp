<%@page import="com.example.demo.videoclub.model.Adherent"%>
<%@page import="com.example.demo.videoclub.model.Article"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vidéoclub - Adhérents</title>
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
		<div class="jumbotron">
			<h1>Liste des Adhérents</h1>
		</div>
		<div>
			<sec:authorize access="hasRole('USER')">
				<c:if test="${pageContext.request.userPrincipal.name != null }">
					logged as:${pageContext.request.userPrincipal.name}
					<a href="">Logout</a>
				</c:if>
			</sec:authorize>
		</div>
		<table class="table table-striped">
			<tr>
				<th>Identifiant</th>
				<th>Civilité</th>
				<th>Nom</th>
				<th>Prénom</th>
				<th>Date de naissance</th>
				<th>Adresse</th>
				<th>Ville</th>
				<th>Modifications</th>
			</tr>
			<c:forEach items="${adherents}" var="adherent">
				<tr>
					<td>${adherent.id}</td>
					<td>${adherent.civilite.titre}</td>
					<td>${adherent.nom}</td>
					<td>${adherent.prenom}</td>
					<td><fmt:formatDate value="${adherent.dateNaissance}"
							pattern="dd/MM/yyyy" /></td>
					<td>${adherent.adresse.numero} ${adherent.adresse.rue}</td>
					<td>${adherent.adresse.ville}</td>
					<td><a href="./update?id=${adherent.id}"
						class="btn btn-warning">Modifier</a> <a
						href="./delete?id=${adherent.id}" class="btn btn-danger">Supprimer</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<a href="./create" class="btn btn-success">Ajouter un adhérent</a> 
		<a href="./createbis" class="btn btn-success">Ajouter un Adhérent en Modale</a>
		<a href="adherent?q=edit" class="btn btn-success" data-toggle="modal" data-target="#modalFormulaire">Ajouter un élève</a>
		<div class="modal fade" id="modalFormulaire" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Ajouter un adhérent</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form id="formAdherent">
							<div class="form-row">
								<div class="col">
									<label for="identifiant">Identifiant</label> <input
										class="form-control" type="text" id="identifiant"
										disabled="disabled" value="${adherent.id}" />
								</div>
							</div>
							<div class="form-row">
								<div class="col">
									<label for="nom">Nom</label> <input class="form-control"
										type="text" id="nom" placeholder="Nom de l'élève" />
								</div>
								<div class="col">
									<label for="prenom">Prénom</label> <input class="form-control"
										type="text" id="prenom" placeholder="Prénom de l'élève" />
								</div>
							</div>
							<div class="form-row">
								<div class="col">
									<label for="age">Age</label> <input class="form-control"
										type="number" id="age" placeholder="Age de l'élève" min="18"
										max="99" />
								</div>
								<div class="col">
									<label for="situation">Situation familiale</label> <select
										class="form-control" id=situation>
										<option selected="selected">Célibat</option>
										<option>PACS</option>
										<option>Mariage</option>
									</select>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Annuler</button>
						<button type="button" class="btn btn-primary"
							onclick="enregistrer();" data-dismiss="modal">Enregistrer</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>