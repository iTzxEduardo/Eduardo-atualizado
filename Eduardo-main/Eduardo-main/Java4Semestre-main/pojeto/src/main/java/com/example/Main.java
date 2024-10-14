package com.example;
import javax.swing.JOptionPane;


public class Main {
    public static void main(String[] args) {
        FuncionarioController gerenciaFuncionarioController = new FuncionarioController();
        int operacao = 0;
        do {
            operacao = Integer.parseInt(JOptionPane.showInputDialog(
               "\n----- Gerenciador de Funcionários -----\n" +
               "1 - Cadastrar Funcionário\n" +
               "2 - Listar Funcionários\n" +
               "3 - Buscar Funcionário\n" +
               "4 - remover Funcionário\n" +
               "5 - Media salarios\n" +
               "6 - Sair"
    ));

            switch(operacao){
                case 1:
                gerenciaFuncionarioController.addFuncionario();
                break;
                case 2:
                gerenciaFuncionarioController.listarFuncionarios();
                break;
                case 3:
                gerenciaFuncionarioController.buscarFuncionario();
                break;
                case 4:
                gerenciaFuncionarioController.removerFuncionario();
                break;
                case 5:
                gerenciaFuncionarioController.calcularMediaSalarial();
                break;
                case 6:
                gerenciaFuncionarioController.addFuncionario();
                break;
            }
        } while (operacao!=5);
    }
}