package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ExercicioCSV {
    public void produto() {
        try {
            // Abrir o arquivo "dados.csv" para leitura
            BufferedReader br = new BufferedReader(new FileReader("C:\\Eduardo\\io_exemplo\\dados.csv"));
            
            // Criar o novo arquivo "dados_com_valor_estoque.csv" para escrita
            PrintWriter pw = new PrintWriter(new FileWriter("C:\\Eduardo\\io_exemplo\\dados_com_valor_estoque.csv"));

            // Ler a primeira linha do arquivo original (cabeçalho)
            String linha = br.readLine();

            // Verificar se o cabeçalho existe
            if (linha != null) {
                // Adicionar uma nova coluna para o valor total do estoque no novo arquivo
                pw.println(linha + ",valor_total_estoque");

                // Exibir o cabeçalho
                System.out.println("Cabeçalho");
                String colunas[] = linha.split(",");
                for (String coluna : colunas) {
                    System.out.print(coluna + " ");
                }
                System.out.print("valor_total_estoque"); // Exibir a nova coluna
                System.out.println();
            }

            // Exibir o conteúdo e calcular o valor total do estoque
            System.out.println("----Conteúdo----");
            while ((linha = br.readLine()) != null) {
                // Dividir a linha atual em colunas
                String colunas[] = linha.split(",");

                // Atribuir os valores da linha às variáveis
                String nome = colunas[0]; // Nome do produto
                int quantidade = Integer.parseInt(colunas[1]); // Quantidade
                double preco = Double.parseDouble(colunas[2]); // Preço

                // Calcular o valor total do estoque (quantidade * preço)
                double valorTotalEstoque = quantidade * preco;

                // Exibir o nome, quantidade, preço e o valor total do estoque
                System.out.println("Nome: " + nome + " | Quantidade: " + quantidade + 
                                   " | Preço: " + preco + " | Valor total do estoque: " + valorTotalEstoque);
                System.out.println("----------------------");

                // Escrever a linha original mais o valor total do estoque no novo arquivo
                pw.println(linha + "," + valorTotalEstoque);
            }

            // Fechar os recursos
            pw.close();
            br.close();

            System.out.println("Arquivo 'dados_com_valor_estoque.csv' gerado com sucesso!");

        } catch (Exception e) {
            // Tratamento de exceção
            e.printStackTrace();
        }
    }
}
