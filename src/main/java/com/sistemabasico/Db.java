package com.sistemabasico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Db {
    private String URL;
    private String user;
    private String password;

    public Db (String URL, String user, String password){
        this.URL = URL;
        this.user = user;
        this.password = password;
    }

    private Connection stabilishConnection() throws SQLException{
        Connection connection = DriverManager.getConnection(URL,user,password);

        if (connection == null) {
            System.out.println("Error al ingresar a la base de datos, intenta nuevamente");
            return null;
        }
        else{
            System.out.println("Conexión establecida, operando...");
            return connection;
        }
    }

    public void insertData(String nombre) {
        try{
            Connection con = this.stabilishConnection();
            
            String queryInsert = "INSERT INTO usuario (nombre_completo) VALUES (?)";
            PreparedStatement preparedStatement = con.prepareStatement(queryInsert);
            preparedStatement.setString(1, nombre);

            int rowsAffected = preparedStatement.executeUpdate();
            
            if (rowsAffected > 0){
                System.out.println("Exitoso");
            }
            else{
                System.out.println("Error en el query");
            }

            con.close();


        } catch (SQLException ex) {
            System.out.println("Error en el query");
        }
    }

    public ArrayList<String> selectData(){
        ArrayList<String> results = new ArrayList<>();

        try{
            Connection con = this.stabilishConnection();

            String querySelect = "SELECT * FROM usuario";
            java.sql.Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(querySelect);
            while (rs.next()) {
                results.add("id: " + rs.getString("id") + " | " + rs.getString("nombre_completo")); 
            }

            con.close();
        } catch(SQLException ex){
            System.out.println("Error en el query" + ex.getMessage());
        }
        return results;
    }

    public int ammountOfData(){
        int numResult = -1;
        try{
            Connection con = this.stabilishConnection();
            String querySelect = "SELECT COUNT(*) FROM usuario";
            java.sql.Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(querySelect);
            rs.next();
            numResult = rs.getInt(".count(*)");

            con.close();
            
        } catch(SQLException ex){
            System.out.println("Error en el query" + ex.getMessage());
        }

        return numResult;
    }

    public int ammountOfData(String name) {
        int numResult = -1;
        try{
            Connection con = this.stabilishConnection();
            String querySelect = "SELECT COUNT(*) FROM usuario WHERE nombre_completo = '" + name + "'";
            java.sql.Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(querySelect);
            rs.next();
            numResult = rs.getInt(".count(*)");

            con.close();
            
        } catch(SQLException ex){
            System.out.println("Error en el query" + ex.getMessage());
        }

        return numResult;
    }
}
