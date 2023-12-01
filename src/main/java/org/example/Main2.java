package org.example;


import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.google.gson.*;

public class Main2 {
    public static void main(String[] args) {

        try {
            String dbUrl = "jdbc:sqlserver://localhost;databaseName=Java_DB;"+
                    "integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
            ResultSet myres = null;
            Connection conn = DriverManager.getConnection(dbUrl);
            Statement stmt = conn.createStatement();
            String sqlString = "select * from TArticoli";
            myres = stmt.executeQuery(sqlString);
            System.out.println("Connesso al DB");

            ArrayList<Article> arrayList = new ArrayList<>();
            // List<Article> list = new LinkedList<>();

            while(myres.next()){
               /* Article article = new Article();
                article.setId(myres.getInt(1));
                article.setName(myres.getString(2));
                article.setDescription(myres.getString(3));
                article.setPrice(myres.getFloat(4));
                article.setVat(myres.getInt(5));
                article.setStock(myres.getInt(6));
                arrayList.add(article); */

                Article article = new Article(myres.getInt(1), myres.getString(2),
                        myres.getString(3), myres.getFloat(4), myres.getInt(5), myres.getInt(6));
                arrayList.add(article);
            }
            for (Article article : arrayList) {
                System.out.println(article.getName() + " " + article.getPrice() + " " + article.getVat() + " " + article.getStock());
            }

            Gson gson = new Gson();
            String string = gson.toJson(arrayList);
            System.out.println(string);

        } catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {

        }

    }
}
