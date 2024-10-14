package com.example;

import java.sql.*;

public class ExercicioProduto {
    public  void produto() {
        
        // Configurações de conexão com o banco de dados
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "postgres";
        
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Estabelecendo a conexão
            con = DriverManager.getConnection(url, user, password);

            // Criar o Statement
            stmt = con.createStatement();

            // Executar a query SQL para obter todos os produtos
            rs = stmt.executeQuery("SELECT * FROM produtos");

            // Variáveis para armazenar os dados necessários
            double totalPreco = 0;
            int count = 0;
            double precoMaisCaro = Double.MIN_VALUE;
            double precoMaisBarato = Double.MAX_VALUE;
            String produtoMaisCaro = "";
            String produtoMaisBarato = "";

            // Iterar pelos resultados e exibir nome e preço de cada produto
            System.out.println("Lista de produtos:");
            while (rs.next()) {
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");

                System.out.println("Nome: " + nome + " | Preço: " + preco);

                // Calcular o total para a média
                totalPreco += preco;
                count++;

                // Verificar o produto mais caro
                if (preco > precoMaisCaro) {
                    precoMaisCaro = preco;
                    produtoMaisCaro = nome;
                }

                // Verificar o produto mais barato
                if (preco < precoMaisBarato) {
                    precoMaisBarato = preco;
                    produtoMaisBarato = nome;
                }
            }

            // Calcular e exibir a média de preços
            if (count > 0) {
                double mediaPrecos = totalPreco / count;
                System.out.println("\nMédia de preços dos produtos: " + mediaPrecos);
            }

            // Exibir o produto mais caro e o mais barato
            System.out.println("\nProduto mais caro: " + produtoMaisCaro + " | Preço: " + precoMaisCaro);
            System.out.println("Produto mais barato: " + produtoMaisBarato + " | Preço: " + precoMaisBarato);

        } catch (SQLException e) {
            // Tratamento de exceções
            e.printStackTrace();
        } finally {
            // Fechar ResultSet, Statement e Connection
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
