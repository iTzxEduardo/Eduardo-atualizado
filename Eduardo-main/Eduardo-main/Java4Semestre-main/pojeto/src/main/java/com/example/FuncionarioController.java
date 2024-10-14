package com.example;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class FuncionarioController {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public FuncionarioController() {
        funcionarios = new ArrayList<>();
    }

    //metodo adicionar
    public void addFuncionario() {
        String nome = JOptionPane.showInputDialog("Digite o nome do Funcionario");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite sua Idade"));
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite seu Salario"));
        Funcionario funcionario = new Funcionario(nome, idade, salario);
        funcionarios.add(funcionario);
}
    //metodo para listar todos os funcionarios
    public void listarFuncionarios(){
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.toString());
        }
    }
    
    //buscar funcionarios 
    public void buscarFuncionario(){
        String nome = JOptionPane.showInputDialog("Digite o Nome do Funcionario a ser Buscado ");
        try {
            boolean encontrado = false;
            for (Funcionario funcionario : funcionarios) {
                if (funcionario.getNome().equalsIgnoreCase(nome)) {
                    System.out.println(funcionario.toString());
                    encontrado = true;                   
                }
            }if (!encontrado) {
                throw new Exception("Funcionario não Encontrado");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    //remover funcionario
    public void removerFuncionario() {
        String nome = JOptionPane.showInputDialog("Digite o Nome do Funcionario a ser Removido");
        try {
            boolean encontrado = false;
            for (Funcionario funcionario : funcionarios) {
                if (funcionario.getNome().equalsIgnoreCase(nome)) {
                    funcionarios.remove(funcionario);
                    encontrado = true;
                    System.out.println("Funcionario removido com sucesso");
                    break;
                }
            }
            if (!encontrado) {
                throw new Exception("Funcionario não Encontrado");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    //calculo de média salarial 
    public void calcularMediaSalarial() {
        double mediaSalario = 0;
        if (funcionarios.size()==0) {
            System.out.println("Lista Vazia");            
        }else{
            for (Funcionario funcionario : funcionarios) {
                mediaSalario = funcionario.getSalario();
            }
            mediaSalario/=funcionarios.size();
            System.out.println("A media de salarial" + mediaSalario);
        }
    }

}
