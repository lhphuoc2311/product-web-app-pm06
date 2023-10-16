<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<!DOCTYPE html>

<html>
    <head>

    </head>
    <body>
        <h1>Create Product Page</h1>
         <!--header-->
         <jsp:include page="header.jsp"></jsp:include>
         <!--menu-->
         <jsp:include page="menu.jsp"></jsp:include>


         <form action="createProduct" method="post">
            <table>
                <tr>
                    <td>Code</td>
                    <td><input type="text" name="code"></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="text" name="price"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Save"></td>
                    <td><a href="productList">Cancel</a></td>
                </tr>
            </table>
         </form>

          <!--footer-->

        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>