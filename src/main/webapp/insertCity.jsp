<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert City</title>
</head>
<body>
	<h1>INSERT CITY</h1>
	<h3 style="color:red">${err }</h3>
	
	<form action="InsertCity" method="post">
		<table>
			<tr>
				<td>City Name:</td>
				<td><input type="text" name="cityName"/></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td>
					<select name="countryId">
					<c:forEach items="${list}" var="country">
						<option value="${country.countryId}">${country.countryName}</option>
					</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>FoundationDate:</td>
				<td><input type="date" name="foundationDate"/></td>
			</tr>
			<tr>
				<td>Area:</td>
				<td><input type="number" name="area"/></td>
			</tr>
			<tr>
				<td>Population:</td>
				<td><input type="number" name="population"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="insert"/>
				<input type="reset" value="clear"/></td>
			</tr>
		</table>
	</form>
</body>
</html>