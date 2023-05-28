<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update City</title>
</head>
<body>
	<h1>UPDATE CITY</h1>
	<h3 style="color: red">${err }</h3>

	<form action="UpdateCity" method="post">
		<table>
			<tr>
				<td>City Id:</td>
				<td><input type="text" name="cityId" value="${c.cityId}"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<td>City Name:</td>
				<td><input type="text" name="cityName" value="${c.cityName}" /></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><select name="countryId">
						<c:forEach items="${list}" var="country">
							<c:choose>
								<c:when test="${c.countryId == country.countryId}">
									<option selected value="${country.countryId}">${country.countryName}</option>
								</c:when>
								<c:otherwise>
									<option value="${country.countryId}">${country.countryName}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>FoundationDate:</td>
				<td><input type="date" name="foundationDate"
					value='<fmt:formatDate value="${c.foundationDate}" pattern="yyyy-MM-dd"/>' /></td>
			</tr>
			<tr>
				<td>Area:</td>
				<td><input type="number" name="area" value="${c.area}" /></td>
			</tr>
			<tr>
				<td>Population:</td>
				<td><input type="number" name="population"
					value="${c.population}" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="insert" /> <input type="reset"
					value="clear" /></td>
			</tr>
		</table>
	</form>
</body>
</html>