<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<!DOCTYPE html>

<html>
    <head>

        <title>
            Home Page
        </title>

    </head>
    

    <body>
        <!--header-->
        <jsp:include page="header.jsp"></jsp:include>
        <!--menu-->
        <jsp:include page="menu.jsp"></jsp:include>

        <!--content-->

        <h3>Home Page</h3>
        This is demo Products web application using servlet/jsp/mysql

        <b>It includes the following fuctions:</b>
        <ul>
            <li>Login</li>
            <li>Product List</li>
            <li>Create Product</li>
            <li>Edit Product</li>
            <li>Delete Product</li>
        </ul>


        <!--footer-->

        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>