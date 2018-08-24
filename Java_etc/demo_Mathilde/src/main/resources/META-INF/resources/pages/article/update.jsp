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
		<fieldset>
			<legend>Formulaire Article</legend>
			<c:choose>
				<c:when test="${article.getClass().simpleName == 'Dvd' }">
					<c:url value="savedvd" var="action"></c:url>
				</c:when>
				<c:when test="${article.getClass().simpleName == 'Blueray' }">
					<c:url value="saveblueray" var="action"></c:url>
				</c:when>
			</c:choose>
			<form:form action="${action}" method="get" modelAttribute="article">
				<form:input hidden="hidden" path="version" />
				<div class="form-group">
					<form:label path="id">ID : </form:label>
					<form:input path="id" cssClass="form-control" readonly="true" />
				</div>
				<div class="form-group">
					<form:label path="nbDisques">Nombre de disques : </form:label>
					<form:input type="number" path="nbDisques" cssClass="form-control" />
				</div>
				<div class="form-group">
					<c:choose>
						<c:when test="${article.getClass().simpleName == 'Dvd'}">
							<form:label path="bonus">Bonus</form:label>
							<form:checkbox path="bonus" cssClass="form-control" />
						</c:when>
						<c:when test="${article.getClass().simpleName == 'Blueray'}">
							<form:label path="troisD">3D</form:label>
							<form:checkbox path="troisD" cssClass="form-control" />
						</c:when>
					</c:choose>
				</div>
				<div class="form-group">
					<form:label path="emprunteur.id">Emprunteur</form:label>
					<form:select path="emprunteur.id" cssClass="form-control">
						<form:option value="">(disponible)</form:option>
						<form:options items="${adherents}" itemLabel="description"
							itemValue="id" />
					</form:select>
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