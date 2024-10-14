package com.example;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<Curso>();
        String operacao = "0";
        do {
            operacao=JOptionPane.showInputDialog(
                "\n---Gerenciamento de Curso---\n"+
                "1 - Criar Curso\n" +
                "2 - Adicionar Professor ao Curso\n" +
                "3 - Adicionar Aluno ao Curso\n" +
                "4 - Visualizar Informações do Curso\n" +
                "5 - Atribuir Nota ao Aluno\n" +
                "6 - Exibir Resultado Final\n" +
                "7 - Sair\n" 
            );
            switch (operacao) {
                case "1" :
                    String nomeCurso = JOptionPane.showInputDialog("Informe o Nome do Curso");
                    cursos.add( new Curso(nomeCurso));
                    break;

                    case "2" :
                    String nomeCursoP = JOptionPane.showInputDialog("Informe o Nome do Professor");
                    for (Curso curso : cursos) {
                        if (curso.getNomeCurso().equalsIgnoreCase(nomeCursoP)) {
                            String nomeProf = JOptionPane.showInputDialog("Nome: ");
                            String cpfProf = JOptionPane.showInputDialog("CPF: ");
                            double salarioProf = Double.parseDouble(JOptionPane.showInputDialog("Salario: "));
                            Professor professor = new Professor(nomeProf, cpfProf, salarioProf);
                            curso.addProf(professor);
                        }
                    }
                    break;
                    case "3 ":
                    String nomeCursoA = JOptionPane.showInputDialog("Informe o Nome do Curso");
                    try {
                        boolean encontrado = false;
                        for (Curso curso : cursos) {
                            if (curso.getNomeCurso().equalsIgnoreCase(nomeCursoA)) {
                                encontrado = true;
                                boolean novoAluno = true;
                                do {
                                    String nomeAluno = JOptionPane.showInputDialog("Nome: ");
                                    String cpfAluno = JOptionPane.showInputDialog("CPF: ");
                                    String matriculaAluno = JOptionPane.showInputDialog("CPF: ");
                                    curso.addAluno(new Aluno(nomeAluno, cpfAluno, matriculaAluno)); 
                                    novoAluno = JOptionPane.showConfirmDialog(null, "Deseja adicionar outro aluno?", "Adicionar Aluno", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                                    // novoAluno = JOptionPane.showInputDialog(
                                    //     "Inserir Novo Aluno?\n"
                                    //     + "1 - Sim\n"
                                    //     + "2 - Não\n").equals("1")?true:false;

                                } while (encontrado);
                                
                            }
                            
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                    }

                default:
                    break;
            }
        } while (operacao!="7");
    }
}