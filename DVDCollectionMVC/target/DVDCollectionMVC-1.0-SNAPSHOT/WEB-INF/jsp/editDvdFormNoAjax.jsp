<%-- 
    Document   : stats
    Created on : Oct 26, 2016, 8:18:41 AM
    Author     : parallels
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dvd Collection - Home (No Ajax)</title>
        <!-- Bootstrap CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" />
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>
        <div class="container">
            <h1>Dvd Collection (No Ajax)</h1>
            <hr />
            <h2>New Dvd Form</h2>
            <a href="displayDvdCollectionNoAjax">Dvd Collection (No Ajax)</a><br />
            <hr />
            <sf:form class="form-horizontal" role="form" modelAttribute="dvd"
                     action="editDvdNoAjax"
                     method="POST">
                <div class="form-group">
                    <label for="edit-title" 
                           class="col-md-4 control-label">Title:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control"
                                  id="edit-title" 
                                  path="title"
                                  placeholder="Title" />
                        <!-- cssClass="name-of-css-class" on the front should be:
                          class="name-of-css-class" -->
                        <sf:errors path="title" cssClass="bg-danger"></sf:errors>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit-release-date" 
                               class="col-md-4 control-label">Release date:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control"
                                  id="edit-release-date" 
                                  path="releaseDate"
                                  placeholder="Release Date" />
                        <sf:errors path="releaseDate" cssClass="bg-danger"></sf:errors>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit-rating" 
                               class="col-md-4 control-label">Rating:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control"
                                  id="edit-rating" 
                                  path="rating"
                                  placeholder="Rating" />
                        <sf:errors path="rating" cssClass="bg-danger"></sf:errors>

                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit-director" 
                               class="col-md-4 control-label">Director:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control"
                                  id="edit-director" 
                                  path="director"
                                  placeholder="Director" />
                        <sf:errors path="director" cssClass="bg-danger"></sf:errors>

                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit-studio" 
                               class="col-md-4 control-label">Studio:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control"
                                  id="edit-studio" 
                                  path="studio"
                                  placeholder="Studio" />
                        <sf:errors path="studio" cssClass="bg-danger"></sf:errors>

                        </div>
                    </div>
                        
                      <div class="form-group">
                        <label for="edit-user-rating" 
                               class="col-md-4 control-label">User Rating:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control"
                                  id="edit-user-rating" 
                                  path="userRating"
                                  placeholder="User Rating" />
                        <sf:errors path="userRating" cssClass="bg-danger"></sf:errors>

                        </div>
                    </div>  
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                        <sf:hidden path="dvdId" />
                        <button type="submit" id="edit-button"
                                class="btn btn-default">Update Dvd</button>
                    </div>
                </div>
            </sf:form>
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
