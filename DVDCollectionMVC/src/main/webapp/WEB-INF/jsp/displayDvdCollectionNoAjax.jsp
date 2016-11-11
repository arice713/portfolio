<%-- 
    Document   : displayDvdNoAjax
    Created on : Oct 29, 2016, 8:43:17 PM
    Author     : apprentice
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Company Contacts - Home (No Ajax)</title>
        <!-- Bootstrap CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" />
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>
        <div class="container">
            <h1>Company Dvds (No Ajax)</h1>
            <a href="displayNewContactFormNoAjax">Add a Dvd</a><br />
            <hr />
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/search">Search</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/stats">Stats</a>
                    </li>
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/displayDvdCollectionNoAjax">Dvd Collection (No Ajax)</a>
                    </li>
                </ul>
            </div>
            <!-- iterate through our dvds and show information -->
            <c:forEach var="dvd" items="${dvdcollection}">
                <!-- For each dvd:
                1. title
                2. Edit link
                3. Delete link
                -->
                <s:url value="deleteDvdNoAjax" var="deleteDvd_url">
                    <s:param name="dvdId" value="${dvd.dvdId}" />
                </s:url>
                
                <s:url value="displayEditDvdFormNoAjax" var="editDvd_url">
                    <s:param name="dvdId" value="${dvd.dvdId}" />
                </s:url>
                
                Title: ${dvd.title} |
                <a href="${deleteDvd_url}">Delete</a> |
                <a href="${editDvd_url}">Edit</a><br />
                Release Date: ${Dvd.releaseDate}<br />
                Rating: ${Dvd.rating}<br />
                Director: ${Dvd.directorl}<br />
                Studio: ${Dvd. studio}<br />
                User Rating: ${Dvd. userRating}<br />
                <hr />
            </c:forEach>
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>

