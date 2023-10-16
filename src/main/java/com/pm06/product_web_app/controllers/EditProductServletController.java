package com.pm06.product_web_app.controllers;

import java.io.IOException;
import java.sql.Connection;

import com.pm06.product_web_app.models.DBCrud;
import com.pm06.product_web_app.models.MySQLConnector;
import com.pm06.product_web_app.models.Product;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editProduct")
public class EditProductServletController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//1. lay code tu url browser
        String code = req.getParameter("code");
        //2. ket noi csdl
        Connection conn = MySQLConnector.getMySQLConnection();

        //3. lay product tu bang theo code
        Product product = DBCrud.findProductByCode(conn, code);
        //4. close
        MySQLConnector.closeConnection(conn);

        //5. dat doi tuong product vao trong request (req)

        req.setAttribute("p", product);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/EditProductView.jsp");

        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1. lay thong tin product tu form
        String code = req.getParameter("code");

        String name = req.getParameter("name");

        double price = Double.parseDouble(req.getParameter("price"));

        //2. chuyen thong tin thanh doi tuong product

        Product product = new Product(code, name, price);

        //3. ket noi csdl
        Connection conn = MySQLConnector.getMySQLConnection();

        //4. update product
        DBCrud.updateProduct(conn, product);
        //close

        // chuyen snag trang product list
        resp.sendRedirect(req.getContextPath() + "/productList");

    }

    
    
}
