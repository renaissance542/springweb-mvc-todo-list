<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="academy.learnprogramming.util.Mappings" %>
<html>
<head>
    <title>Todo Items</title>
</head>
<body>
    <div align="center">
    <c:url var="addLink" value="${Mappings.ADD_ITEM}"/>
    <h2><a href="${addLink}">New Item</a></h2>

        <table border="1" cellpadding="5">

            <caption><h2>Todo Items</h2></caption>
            <tr>
                <th>Title</th>
                <th>Deadline</th>
                <th>Delete</th>
            </tr>
            <c:forEach var="item" items="${todoData.todoItems}">
                <c:url var="deleteLink" value="${Mappings.DELETE_ITEM}">
                    <c:param name="id" value="${item.id}"/>
                </c:url>
                <tr>
                    <td><c:out value="${item.title}"/></td>
                    <td><c:out value="${item.deadline}"/></td>
                    <td><a href="${deleteLink}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>

</html>