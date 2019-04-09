
<%--
Document   : user
Created on : Feb 6, 2019, 8:20:34 PM
Author     : Acer
--%>

<%@page import="com.company.entity.Country"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.company.entity.User"%>
<%@ page import="com.company.entity.UserSkill" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<link rel="stylesheet" href="assets/css/users.css">
<title>JSP Page</title>
</head>
<body>

<%
    User u= (User) request.getAttribute("user");
%>

<div class="container">
    <div>
        <form action="userupdate" method="POST">
            <div class="col-4">
                <input type="hidden" name="id" value="<%=u.getId()%>"/>
                <div class="form-group">
                    <label>name:</label>
                    <input placeholder="Enter name:" class="form-control" type="text" name="name" value="<%=u.getName()%>"/>
                </div>
                <div class="form-group">
                    <label>surname:</label>
                    <input placeholder="Enter surname:" class="form-control" type="text" name="surname" value="<%=u.getSurname()%>"/>
                </div>
                <input class="btn btn-primary" type="submit" name="save" value="Save"/>
            </div>
            <hr/>


        </form>
    </div>

<div>
<ul class="nav nav-tabs" role="tablist">
<li class="active"><a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Details</a></li>
</ul>

<div class="tab-content">
<div id="home" class="tab-pane fade show active">
<table class="table">
<thead>
<tr>
<th>Email</th>
<th>Phone</th>
<th>Address</th>
<th>BirthDate</th>
<th>Country</th>
<th>Nationality</th>
</tr>
</thead>
<tbody>
<tr>
<td><%=u.getEmail()%></td>
<td><%=u.getPhone()%></td>
<td><%=u.getAddress()%></td>
<td><%=u.getBirthDate()%></td>
<td><%=u.getBirthplace().getName()%></td>
<td><%=u.getNationality().getName()%></td>

</tr>
</tbody>
</table>
</div>
<div id="menu1" class="tab-pane fade active show">
<table class="table">
<thead>
<tr>
<th>Profile Description</th>
</tr>
</thead>
<tbody>
<tr>
<td><%=u.getProfileDesc()%></td>
</tr>
</tbody>
</table>
</div>

<div id="menu2" class="tab-pane fade active show">
<table class="table">
<thead>
<tr>
<th>Skill Name</th>
<th>Power</th>
</tr>
</thead>
<tbody>

<c:forEach items="${listskill}" var="f">
<tr>
<td>${f.skill.name}</td>
<td>${f.power}</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</div>
</div>
</div>

</body>
</html>
