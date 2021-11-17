package main.Java.Jdbc;
import java.sql.*;
import java.util.*;

public class MyJDBC01 {
    public static void main(String[] args) {

        Connection dbConnection = null;

        try{
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3303/jdbc",
                    "root", "mila");

            Statement declaracionSql = dbConnection.createStatement();

            ResultSet resultSet = declaracionSql.executeQuery("SELECT * FROM estudiante");

            while (resultSet.next()){
                System.out.println(resultSet.getString("id")+" "+resultSet.getString("nombre")
                        +" "+resultSet.getString("apellido"));
            }

        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }finally {
            try {
                if(dbConnection!=null){dbConnection.close();}
            }catch (SQLException exception){
                System.out.println(exception.getMessage());
            }
        }
    }
}
