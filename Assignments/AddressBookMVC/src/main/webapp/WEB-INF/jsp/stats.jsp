<%-- 
    Document   : stats
    Created on : Oct 26, 2016, 8:18:41 AM
    Author     : parallels
--%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Company Contacts - Stats</title>
        <!-- Bootstrap CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" />
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>
        <div class="container">
            <h1>Stats</h1>
             <!-- #2 - Personalized welcome message -->
            Hello <sec:authentication property="principal.username" />!<br/>
            <hr />
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/mainAjaxPage">Contact List (Ajax)</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/search">Search</a>
                    </li>
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/stats">Stats</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/displayContactListNoAjax">Contact List (No Ajax)</a>
                    </li>
                    
                    <!-- #1 - Logout link -->
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a>
                    </li> 
                </ul>
            </div>
            <div class="row">
                <!-- #1: Contacts Per Company Chart -->
                <div class="col-md-12">
                    <h2>Statistics</h2>
                    <!-- #2: this is where we'll render the bar chart -->
                    <div id="chart_div"></div>
                </div>
            </div> 
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <!-- #1: Include and load Google Charts - both steps are required -->
        <script type="text/javascript" src="http://www.google.com/jsapi"></script>
        <script>
            google.load('visualization', '1.0', {'packages': ['corechart']});
        </script>

        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <!-- #2: Include and load Google Charts - both steps are required -->
        <script src="${pageContext.request.contextPath}/js/stats.js"></script> 
    </body>
</html>
