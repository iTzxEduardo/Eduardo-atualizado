package com.example;

import java.io.BufferedReader;
import java.io.FileReader;

public class LeituraCSV {
    
    // Método exemplo para ler e exibir o conteúdo de um arquivo CSV
    public void exemplo() {
        try {
            // Abre o arquivo "dados.csv" para leitura
            BufferedReader br = new BufferedReader(
                new FileReader("dados.csv")
            );
            
            // Lê a primeira linha do arquivo (geralmente o cabeçalho)
            String linha = br.readLine();
            
            // Verifica se o cabeçalho existe (linha não é nula)
            if (linha != null) {
                // Divide a linha do cabeçalho em colunas usando a vírgula como separador
                String colunas[] = linha.split(",");
                
                // Exibe as colunas do cabeçalho
                System.out.println("Cabeçalho");
                for (String coluna : colunas) {
                    System.out.print(coluna + " ");
                }
                System.out.println(); // Para pular uma linha
            }
            
            // Exibe o conteúdo do CSV (linhas subsequentes)
            System.out.println("----Conteúdo----");
            // Continua lendo linha a linha até o final do arquivo
            while ((linha = br.readLine()) != null) {
                // Divide a linha atual em colunas usando a vírgula como separador
                String colunas[] = linha.split(",");
                
                // Exibe as colunas da linha atual
                for (String coluna : colunas) {
                    System.out.print(coluna + " ");
                }
                System.out.println(); // Para pular uma linha após cada linha do arquivo
                System.out.println("----------------------");
            }
            
        } catch (Exception e) {
            // Captura qualquer exceção que ocorrer durante a leitura e exibe o stack trace
            e.printStackTrace();
        }
    }
}
