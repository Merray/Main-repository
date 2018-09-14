<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<legend>edition d'article</legend>
			<c:choose>
				<c:when test="${article.getClass().simpleName=='Dvd'}">
					<c:url value="savedvd" var="action"></c:url>
				</c:when>
				<c:otherwise>
					<c:url value="savebluray" var="action"></c:url>
				</c:otherwise>
			</c:choose>
			<form:form action="${action}" method="get" modelAttribute="article">
				<form:hidden path="version" />
				<div class="form-group">
					<form:label path="id">id:</form:label>
					<form:input path="id" cssClass="form-control" readonly="true" />
				</div>
				<div class="form-group">
					<form:label path="nbDisques">nombre de disque:</form:label>
					<form:input path="nbDisques" cssClass="form-control" type="number" />
				</div>
				<c:choose>
					<c:when test="${article.getClass().simpleName=='Dvd'}">
						<div class="form-group">
							<form:label path="bonus">bonus:</form:label>
							<form:checkbox path="bonus" cssClass="form-control" />
						</div>
					</c:when>
					<c:otherwise>
						<div class="form-group">
							<form:label path="troisD">3D:</form:label>
							<form:checkbox path="troisD" cssClass="form-control" />
						</div>
					</c:otherwise>
				</c:choose>
				<div class="form-group">
					<form:label path="emprunteur">emprunteur:</form:label>
					<form:select path="emprunteur.id" cssClass="form-control">
						<form:option value="">disponible</form:option>
						<form:options items="${adherents}" itemLabel="description"
							itemValue="id" />
					</form:select>
					<form:errors path="emprunteur"></form:errors>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-success">enregistrer</button>
				</div>
			</form:form>
		</fieldset>
	</div>
</body>
</html>