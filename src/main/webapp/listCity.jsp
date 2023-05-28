<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Load City</title>
</head>
<body>
	<h1>LIST CITY</h1>
	<h3 style="color:green">${success}</h3>
	<h3 style="color:red">${err}</h3>
	
	<form action="SearchCityByCountry" method="get">
		<b>Country Name: </b>
		<input type="text" name="countryName"/>
		<input type="submit" value="Search"/>
	</form><br/>
	<table border="1">
		<tr>
			<th>City Id</th>
			<th>Country Id</th>
			<th>City Name</th>
			<th>FoundationDate</th>
			<th>Area</th>
			<th>Population</th>
		</tr>
		<c:forEach items="${list}" var="s">
			<tr>
				<td>${s.cityId}</td>
				<td>${s.countryId}</td>
				<td>${s.cityName}</td>
				<td><fmt:formatDate value="${s.foundationDate}" pattern="dd/MM/yyyy"/></td>
				<td>${s.area}</td>
				<td>${s.population}</td>
				<td>
					<a href="DetailCity?cityId=${s.cityId}">detail</a>
				</td>
				<td>
					<a href="DeleteCity?cityId=${s.cityId}" onclick="return confirm('Sure?')">delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="PreInsertCity">Add New Student</a>
</body>
</html>