<%--
    Document   : user
    Created on : Feb 6, 2019, 8:20:34 PM
    Author     : Acer
--%>

<%@page import="java.util.List"%>
<%@page import="com.company.entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="assets/css/users.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script type="text/javascript" src="assets/js/users.js"></script>
</head>
<body>


<div class="container mycontainer">
    <div class="col-12 row">
        <div class="col-4">

            <form:form action="usersM" method="GET" modelAttribute="user">

                <div class="form-group">
                    <label>name:</label>
                    <form:input
                            onkeyup="writeWhatIamTyping()"
                            placeholder="Enter name:"
                            class="form-control"
                            path="name"/>
                    <form:errors path="name"/>
                </div>


                <div class="form-group">
                    <label>surname:</label>
                    <form:input
                            placeholder="Enter surname:"
                            class="form-control"
                            path="surname"/>
                    <form:errors path="surname"/>
                </div>

                <form:button
                        class="btn btn-primary"
                        type="submit"
                        value="Search"
                        id="btnsearch">Search</form:button>

            </form:form>

        </div>
    </div>
    <div>
        <table class="table">
            <thead>
            <tr>
                <th>name</th>
                <th>surname</th>
                <th>nationality</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="u">
                <tr>
                    <td>${u.name}</td>
                    <td>${u.surname}</td>
                    <td>${u.nationality.name}</td>
                    <td style="width: 5px">

                        <input type="hidden" name="id" value="<${u.id}>"/>
                        <input type="hidden" name="action" value="delete">
                        <button class="btn btn-danger" type="submit" value="delete"
                                data-toggle="modal" data-target="#exampleModalLong" onclick="setIdForDelete('<${u.id}>')">
                            <i class="fas fa-trash-alt"></i>
                        </button>
                    </td>
                    <td style="width: 5px">
                        <form:form action="userdetail" method="GET" modelAttribute="user">
                            <form:hidden path="id" value="${u.id}"/>
                            <form:hidden path="action" value="update"/>
                            <button class="btn btn-secondary" type="submit" value="update">
                                <i class="fas fa-pen-square"></i>
                            </button>
                        </form:form>
                    </td>
                </tr>

            </tbody>
        </table>
    </div>

</div>



<!-- Modal -->
<div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Delete</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure?
            </div>
            <div class="modal-footer">
                <form:form action="userdelete" method="POST" modelAttribute="user">
                    <input type="hidden" name="id" value="${u.id}" id="idForDelete"/>
                    <input type="hidden" name="action" value="delete">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-danger">Delete</button>
                </form:form>
            </div>
        </div>
    </div>
</div>
</c:forEach>
</body>
</html>