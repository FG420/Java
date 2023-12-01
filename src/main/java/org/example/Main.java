package org.example;
import java.sql.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        try{
            System.out.println("Try the connection to SQLServer");
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());

            String dbUrl = "jdbc:sqlserver://localhost;databaseName=Java_DB;"+
                    "integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
            Connection conn = DriverManager.getConnection(dbUrl);




            // Select Query
            if(conn != null){
                System.out.println("Select Query");
                Statement myS = conn.createStatement();
                String stringSql = "select * from TArticoli where stock > 0";
                ResultSet resSet = myS.executeQuery(stringSql);
                while (resSet.next()){
                    System.out.println("Name: " + resSet.getString(2) + " vat: " + resSet.getString(5) + " stock: " + resSet.getString(6)
                            + " price incl. vat: " + (resSet.getInt(4) + (resSet.getInt(4) * resSet.getInt(5)/100)));
                }
                conn.close();
            }

            // Insert new article Query
            /* if (conn != null) {
                System.out.println("Insert new articolo Query");
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO TArticoli VALUES (?, ?, ?, ?, ?, ?)");
                Scanner scan = new Scanner(System.in);
                System.out.println("insert index: ");
                stmt.setInt(1, scan.nextInt());
                scan.nextLine();
                System.out.println("insert name: ");
                stmt.setString(2, scan.nextLine());
                System.out.println("insert description: ");
                stmt.setString(3, scan.nextLine());
                System.out.println("insert price: ");
                stmt.setFloat(4, scan.nextFloat());
                System.out.println("insert vat: ");
                stmt.setInt(5, scan.nextInt());
                System.out.println("insert stock: ");
                stmt.setInt(6, scan.nextInt());
                stmt.executeUpdate();
                conn.close();
            } */

            //Update price Query
             /* if (conn != null) {
                System.out.println("Update price Query");
                PreparedStatement stmt = conn.prepareStatement("UPDATE TArticoli SET price = price + (price * ? / 100) WHERE id = ?");
                Scanner scan = new Scanner(System.in);
                 System.out.println("insert index: ");
                 stmt.setInt(2, scan.nextInt());
                 System.out.println("insert percent: ");
                 stmt.setInt(1, scan.nextInt());
                stmt.executeUpdate();
                conn.close();
            } */

            //Delete Query
            /* if (conn != null) {
                System.out.println("Delete Query");
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM  TArticoli WHERE id = ?");
                Scanner scan = new Scanner(System.in);
                System.out.println("insert index: ");
                stmt.setInt(1, scan.nextInt());
                stmt.executeUpdate();
                conn.close();
            } */

            // Select value warehouse Query
            /* if(conn != null){
                System.out.println("Select concatenated values Query");
                Statement myS = conn.createStatement();
                String stringSql = "SELECT SUM((price + (price * vat/100)) * stock) AS totalValue FROM TArticoli where stock > 0";
                ResultSet resSet = myS.executeQuery(stringSql);
                while (resSet.next()) {
                    double totalValue = resSet.getDouble("totalValue");
                    System.out.println("Total Stock Value: " + totalValue);
                }
                conn.close();
            } */
            else {
                System.out.println("Not Connected");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {

        }
    }
}