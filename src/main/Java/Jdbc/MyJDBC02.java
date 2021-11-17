package main.Java.Jdbc;

import java.sql.*;
import java.util.*;

public class MyJDBC02 {
    public static void main(String[] args) {

        Connection dbConnection = null;

        try{
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3303/jdbc",
                    "root", "mila");
            dbConnection.setAutoCommit(false);
            PreparedStatement consultaPreparada = dbConnection.prepareStatement("INSERT INTO estudiante(dni, nombre," +
                    "apellido)" +
                    "VALUES(?,?,?);");

                consultaPreparada.setInt(1, 34398057);
                consultaPreparada.setString(2, "Altamirano");
                consultaPreparada.setString(3, "Fatima");
                consultaPreparada.executeUpdate();

            ResultSet resultSet = consultaPreparada.executeQuery("SELECT * FROM estudiante");
            dbConnection.commit();
            while (resultSet.next()){
                System.out.println(resultSet.getString("id")+" "+resultSet.getString("nombre")
                        +" "+resultSet.getString("apellido"));
            }
        }catch (SQLException sqlException){
            try {
                if(dbConnection!=null){dbConnection.rollback();}
            }catch (SQLException exception){
                System.out.println(exception.getMessage());
            }
        }finally {
            try {
                if(dbConnection!=null){dbConnection.close();}
            }catch (SQLException exception){
                System.out.println(exception.getMessage());
            }
        }
    }
}
