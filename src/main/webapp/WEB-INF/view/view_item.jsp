<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="academy.learnprogramming.util.Mappings" %>
<html>
<head>
    <title>View Item</title>
</head>
<body>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Item Details</h2></caption>
            <table>
                <tr>
                    <td><label>ID</label></td>
                    <td><c:out value="${todoItem.id}"/></td>
                </tr>
                <tr>
                    <td><label>Title</label></td>
                    <td><c:out value="${todoItem.title}"/></td>
                </tr>
                <tr>
                    <td><label>Deadline</label></td>
                    <td><c:out value="${todoItem.deadline}"/></td>
                </tr>
                <tr>
                    <td><label>Details</label></td>
                    <td><c:out value="${todoItem.details}"/></td>
                </tr>
                <tr>
                    <c:url var="itemsListLink" value="${Mappings.ITEMS}"/>
                    <td><a href="${itemsListLink}">Back to items list</a></td>
                </tr>

        </table>
    </div>

</body>

</html>