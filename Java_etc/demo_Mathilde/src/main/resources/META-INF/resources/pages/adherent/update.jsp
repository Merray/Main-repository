<%@page import="com.example.demo.videoclub.model.Adherent"%>
<%@page import="com.example.demo.videoclub.model.Article"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Vidéoclub - Adhérent</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<fieldset>
			<legend>Formulaire Adhérent</legend>
			<form:form action="save" method="get" modelAttribute="adherent">
				<form:input hidden="hidden" path="version"/>
				<div class="form-group">
					<form:label path="id">ID : </form:label>
					<form:input path="id" cssClass="form-control" readonly="true"/>
				</div>
				<div class="form-group">
					<form:label path="civilite">Civilité : </form:label>
					<form:select path="civilite" items = "${civilite}" itemLabel="titre" cssClass="form-control"/>
					<form:label path="prenom">Prénom : </form:label>
					<form:input path="prenom" cssClass="form-control"/>
					<form:errors path="prenom"></form:errors>
					<form:label path="nom">Nom : </form:label>
					<form:input path="nom" cssClass="form-control"/>
					<form:errors path="nom"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="dateNaissance">Date de naissance : </form:label>
					<form:input type="date" path="dateNaissance" cssClass="form-control" />
					<form:errors path="dateNaissance"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="adresse.numero">Numéro : </form:label>
					<form:input type="number" path="adresse.numero" cssClass="form-control" />
					<form:label path="adresse.rue">Rue : </form:label>
					<form:input path="adresse.rue" cssClass="form-control" />
					<form:label path="adresse.ville">Ville: </form:label>
					<form:input path="adresse.ville" cssClass="form-control" />
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-success">Enregistrer</button>
					<button type="reset" class="btn btn-warning">Réinitialiser</button> 
					<a href="./" class="btn btn-danger">Quitter</a>
				</div>
			</form:form>
		</fieldset>
	</div>
</body>
</html>