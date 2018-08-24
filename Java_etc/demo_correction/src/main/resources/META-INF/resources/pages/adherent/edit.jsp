
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>edition</title>
</head>
<body>
	<div class="container">
		<fieldset>
			<legend>edition d'adherent</legend>
			<form:form action="save" method="get" modelAttribute="adherent">
				<form:hidden path="version" />
				<div class="form-group">
					<form:label path="id">id:</form:label>
					<form:input path="id" cssClass="form-control" readonly="true" />
				</div>
				<div class="form-group">
					<form:label path="civilite">civilite:</form:label>
					<form:select cssClass="form-control" path="civilite"
						items="${civilite}" itemLabel="titre"></form:select>
				</div>
				<div class="form-group">
					<form:label path="prenom">prenom:</form:label>
					<form:input path="prenom" cssClass="form-control is-valid" />
					<form:errors path="prenom"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="nom">nom:</form:label>
					<form:input path="nom" cssClass="form-control" />
					<form:errors path="nom"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="dateNaissance">date de naissance:</form:label>
					<form:input path="dateNaissance" cssClass="form-control"
						type="date" />
					<form:errors path="dateNaissance"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="adresse.numero">numero:</form:label>
					<form:input path="adresse.numero" cssClass="form-control"
						type="number" />
				</div>
				<div class="form-group">
					<form:label path="adresse.rue">rue:</form:label>
					<form:input path="adresse.rue" cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:label path="adresse.ville">ville:</form:label>
					<form:input path="adresse.ville" cssClass="form-control" />
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-success">enregistrer</button>
				</div>
			</form:form>
		</fieldset>
	</div>
</body>
</html>