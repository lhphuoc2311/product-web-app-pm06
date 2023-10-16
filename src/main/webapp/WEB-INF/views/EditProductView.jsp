<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
    <!--su dung JSTL-->
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>

        <!DOCTYPE html>

        <html>

        <head>

        </head>

        <body>


            <!--header-->
            <jsp:include page="header.jsp"></jsp:include>
            <!--menu-->
            <jsp:include page="menu.jsp"></jsp:include>

            <h2>Edit product Product Page</h2>


            <!--content-->
            <c:if test="${not empty p}">
                <form action="editProduct" method="post">
                    
                    <input hidden name="code" value="${p.code}">

                    <table>
                        <!-- <tr>
                            <td>Code</td>
                            <td><input type="text" name="code" value="${p.code}"></td>
                        </tr> -->
                        <tr>
                            <td>Name</td>
                            <td><input type="text" name="name" value="${p.name}"></td>
                        </tr>
                        <tr>
                            <td>Price</td>
                            <td><input type="text" name="price" value="${p.price}"></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Save"></td>
                            <td><a href="productList">Cancel</a></td>
                        </tr>
                    </table>
                </form>

            </c:if>


            <jsp:include page="footer.jsp"></jsp:include>

        </body>

        </html>