<%@page import="com.example.demo.model.Article"%>
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
<title>Articles</title>
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
						<h1 class="display-4">Le Site Des Articles</h1>
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
					<th scope="col">Type</th>
					<th scope="col">Nombre de disques</th>
					<th scope="col">Bonus</th>
					<th scope="col">3D</th>
					<th scope="col"></th>
					<th scope="col"></th>
				</tr>
			</thead>
			<c:forEach items="${articles}" var="article">
				<tr>
					<td>${article.numeroArticle}</td>
					<td>${article.getClass().simpleName}</td>
					<td>${article.nbDisques}</td>
					<td><c:if
							test="${article.getClass().simpleName == 'Dvd' && article.bonus}">
							<input type="checkbox" checked="checked" disabled="disabled" />
						</c:if></td>
					<td><c:if
							test="${article.getClass().simpleName == 'BluRay' && article.troisD}">
							<input type="checkbox" checked="checked" disabled="disabled" />
						</c:if></td>
					<td><a href="./delete?id=${article.numeroArticle}"
						class="btn btn-danger">Supprimer</a></td>
					<td><a href="./edit?id=${article.numeroArticle}"
						class="btn btn-primary">edition</a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="row">
			<div class=col-sm-2>
				<a href="./addbluray" class="btn btn-success btn-lg b1">Ajouter
					BluRay</a>
			</div>
			<div class=col-sm-2>
				<a href="./adddvd" class="btn btn-success btn-lg b1">Ajouter Dvd</a>
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