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
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Insert title here</title>
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
                    <form:label path="numeroArticle"> id:</form:label>
                    <form:input path="numeroArticle" cssClass="form-control" readonly="true" />
                </div>
                <div class="form-group">
                    <form:label path="nbDisques"> Nombre de disque:</form:label>
                    <form:input path="nbDisques" cssClass="form-control" type="number" />
                </div>
                <c:choose>
                            <c:when test="${article.getClass().simpleName=='Dvd'}">
                                <div class="form-group">
                                    <form:label path="bonus"> Bonus ?</form:label>
                                    <form:checkbox path="bonus" cssClass="form-control"/>
                                </div>
                            </c:when>
                            <c:otherwise>                            
                                <div class="form-group">
                                    <form:label path="troisD"> 3D ?</form:label>
                                    <form:checkbox path="troisD" cssClass="form-control" />
                                </div>
                            </c:otherwise>
                        </c:choose>
                <div class="form-group">
                    <button type="submit" class="btn btn-success">enregistrer</button>
                </div>
            </form:form>

        </fieldset>
    </div>
</body>
</html>