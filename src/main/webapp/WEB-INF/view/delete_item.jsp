
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="academy.learnprogramming.util.AttributeNames" %>
<html>
<head>
    <title>Delete Item</title>
</head>
<body>
    <div align="center">
        <h2>Press SUBMIT button to confirm deleting this item:</h2>
        <form:form method="POST" modelAttribute="${AttributeNames.TODO_ITEM}">
            <table>
                <tr>
                    <td><label>ID</label></td>
                    <td>
                        <form:input path="id" disabled="true"/>
                    </td>
                </tr>
                <tr>
                    <td><label>Title</label></td>
                    <td>
                        <form:input path="title" disabled="true"/>
                    </td>
                </tr>
                <tr>
                    <td><label>Deadline</label></td>
                    <td>
                        <form:input path="deadline" disabled="true"/>
                    </td>
                </tr>
                <tr>
                    <td><label>Details</label></td>
                    <td>
                        <form:input path="details" disabled="true"/>
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>

            </table>

        </form:form>
    </div>

</body>

</html>