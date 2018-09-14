<%@page import="javax.servlet.jsp.tagext.TagSupport"%>
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
<title>Edition</title>
</head>
<body>
	<div class="container">
		<fieldset>
			<legend>Edition d'adherent</legend>
			<form:form action="./save" method="get" modelAttribute="adherent">
				<form:hidden path="version" />
				<div class="form-group">
					<div>
						<form:label path="id">Id</form:label>
						<form:input path="id" cssClass="form-control" readonly="true" />
					</div>
					<div>
						<form:label path="civilite">Civilité</form:label>
						<form:select path="civilite" items="${civilite}" cssClass="form-control"></form:select>
					</div>
					<div>
						<form:label path="prenom">Prenom</form:label>
						<form:input path="prenom" cssClass="form-control" />
						<form:errors path="prenom"></form:errors>
					</div>
					<div>
						<form:label path="nom">Nom</form:label>
						<form:input path="nom" cssClass="form-control" />
						<form:errors path="nom"></form:errors>
					</div>
					<div>
						<form:label path="adresse.rue">Rue</form:label>
						<form:input path="adresse.rue" cssClass="form-control" />
					</div>
					<div>
						<form:label path="adresse.cp">Code Postal</form:label>
						<form:input path="adresse.cp" cssClass="form-control" />
					</div>
					<div>
						<form:label path="adresse.ville">Ville</form:label>
						<form:input path="adresse.ville" cssClass="form-control" />
					</div>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-success">Save</button>
					<button type="reset" class="btn btn-primary">Reset</button>
					<a href="./" class="btn btn-danger">Cancel</a>
				</div>
			</form:form>
		</fieldset>

	</div>


</body>
</html>