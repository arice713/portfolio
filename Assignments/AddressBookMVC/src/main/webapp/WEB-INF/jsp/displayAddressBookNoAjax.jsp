<%-- 
    Document   : stats
    Created on : Oct 26, 2016, 8:18:41 AM
    Author     : parallels
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Address Book - Home (No Ajax)</title>
        <!-- Bootstrap CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" />
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>
        <div class="container">
            <h1>Address Book (No Ajax)</h1>
            <!-- #2 - Personalized welcome message -->
            Hello <sec:authentication property="principal.username" />!<br/>
            <!-- #3 - Only render this link if user has admin role -->
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <a href="displayNewPersonFormNoAjax">Add a Contact</a><br/>
            </sec:authorize> 
            <hr />
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/mainAjaxPage">Address Book (Ajax)</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/search">Search</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/stats">Stats</a>
                    </li>
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/displayContactListNoAjax">Address Book (No Ajax)</a>
                    </li>

                    <!-- #1 - Logout link -->
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a>
                    </li> 
                </ul>
            </div>
            <!-- iterate through our contacts and show information -->
            <c:if test="${fn:length(addressBook) lt 1}">
                <form action="loadContacts" method="POST">
                    <button type="submit" class="btn btn-default">Load Test Persons</button>
                </form>
            </c:if>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Company</th>
                        <th>Phone</th>
                        <th>Email</th>
                        <th>&nbsp;</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="person" items="${addressBook}">
                        <!-- For each person:
                        1. First Name & Last Name
                        2. Edit link
                        3. Delete link
                        -->
                        <s:url value="deletePersonNoAjax" var="deletePerson_url">
                            <s:param name="personId" value="${person.personId}" />
                        </s:url>

                        <s:url value="displayEditPersonFormNoAjax" var="editPerson_url">
                            <s:param name="personId" value="${person.personId}" />
                        </s:url>
                        <tr>
                            <td>${person.firstName} ${person.lastName}</td>
                            <td>${person.company}</td>
                            <td>${person.phone}</td>
                            <td>${person.email}</td>
                            <td>
                                <!-- Use hasRole for a single role, hasAnyRole for multiple roles -->
                                <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
                                    <a href="${deletePerson_url}">Delete</a> |
                                    <a href="${editPerson_url}">Edit</a>
                                </sec:authorize>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
