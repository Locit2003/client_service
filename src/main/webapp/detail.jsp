<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail City</title>
</head>
<body>
<h1>DETAIL CITY</h1>
	
		<table>
			<tr>
				<td>City Id:</td>
				<td>${c.cityId}</td>
			</tr>
			<tr>
				<td>Country Id:</td>
				<td>${c.countryId}</td>
			</tr>
			<tr>
				<td>City Name:</td>
				<td>
					${c.cityName }
				</td>
			</tr>
			<tr>
				<td>FoundationDate:</td>
				<td><fmt:formatDate value="${c.foundationDate}" pattern="dd/MM/yyyy"/></td>
			</tr>
			<tr>
				<td>Area:</td>
				<td>${c.area}</td>
			</tr>
			<tr>
				<td>Population:</td>
				<td>${c.population }</td>
			</tr>	
			<tr>
				<td><a href="index.jsp">Back</a></td>
				<td>
					<a href="PreUpdateCity?cityId=${c.cityId}">update</a>
				</td>
			</tr>		
		</table>
		
</body>
</html>