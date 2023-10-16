package com.pm06.product_web_app.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBCrud {

    public static List<Product> getAllProduct(Connection conn){
        List<Product> productList = null;
        String sql = "SELECT * FROM product";
        PreparedStatement ps = null;
        ResultSet rs = null;
        productList = new ArrayList<>();

        //code

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            //chuyen ResultSet sang List<Product>
            while(rs.next()){
                String code = rs.getString("code");
                String name = rs.getString("name");
                double price = rs.getDouble("price");

                Product product = new Product(code, name, price);
                productList.add(product);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return productList;


    }
    

    public static void addProduct(Connection conn, Product product){

        //cau lenh sql - insert vao csdl
        String sql = "insert into product (code, name, price) values(?, ?, ?)";
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, product.getCode());
            ps.setString(2, product.getName());
            ps.setDouble(3, product.getPrice());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        

    }

    public static Product findProductByCode(Connection conn, String code){
        Product product = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from product where code = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, code);
            rs = ps.executeQuery();

            while(rs.next()){
                String name = rs.getString("name");
                double price = rs.getDouble("price");

                product = new Product(code, name, price);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return product;
    }

    public static void updateProduct(Connection conn, Product product){

        String sql = " update product set name = ?, price = ? where code = ?";

        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setString(3, product.getCode());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        

    }
}
