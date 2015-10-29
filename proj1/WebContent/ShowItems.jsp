<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.util.List, com.proj1.model.Item"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	
	<table border="1">
    <!-- some titles... -->
    <tr>
        <th>Item Code</th>
        <th>Item Name</th>
        <th>Item Description</th>
        <th>Price</th>
        <th>Category ID</th>
        <th>Photo</th>
    </tr>
    <c:forEach items="${sessionScope.itemList}" var="image">
    <tr>
        <td>
            <c:out value="${image.itemCode}" />
        </td>
        <td>
            <c:out value="${image.itemName}" />
        </td>
        <td>
            <c:out value="${image.itemDesc}" />
        </td>
        <td>
            <c:out value="${image.price}" />
        </td>
        <td>
            <c:out value="${image.categoryId}" />
        </td>
        <td>
            <img style="display:block;" width="120" height="80" src="${image.fileName}"  />
        </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>