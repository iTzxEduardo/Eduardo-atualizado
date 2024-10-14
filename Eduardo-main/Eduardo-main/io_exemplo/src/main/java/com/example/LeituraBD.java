package com.example;

import java.sql.*;

public class LeituraBD {
    public void exemplo(){
        try{
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
            "postgres","postgres");
            
            //tradutor de sql
            Statement stmt = con.createStatement();

            //armazenar os resultador
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios");

            while (rs.next()) {
                System.out.println("ID: "+ rs.getInt("id")
                +"NOME: "+ rs.getString("nome")
                +"IDADE: "+ rs.getInt("idade")
                );
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }   
}
