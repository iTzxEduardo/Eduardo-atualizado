package com.example;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

@Getter
@Setter
public class Curso {
    private String nomeCurso;
    private List<Aluno> alunos;
    private Professor professor;

    //contruto
    public Curso(String nomeCurso){
        this.nomeCurso = nomeCurso;
        alunos = new ArrayList<>();
    }

    //metodos
    public void addProf(Professor professor){
        this.professor = professor;
    }

    public void addAluno(Aluno aluno){
        alunos.add(aluno);
    }

    //metodos infoCurso

    public void infoCurso(){
        System.out.println("Curso: " + nomeCurso);
        System.out.println("Professor: " + professor.getNome());
        System.out.println("Alunos Matriculados: " );
        for (Aluno aluno : alunos) {
            System.out.println("Aluno: " +aluno.getNome()+ "RA: "+aluno.getMatricula());
        }
    }

    //metodos lançar notas
    public void atribuirNotaNome(String nomeAluno, double notaAluno){

        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase((nomeAluno))) {
                aluno.setNota(notaAluno);               
                return;
            }            
        }
        System.out.println("Aluno não encontrado");
    }

    //metodo exibir resultado final
    public void exibirResultadoFinal(){
        for (Aluno aluno : alunos) {
            System.out.println(aluno.exibirInfo());
            System.out.println(aluno.avaliarDesenpenho());
            
        }
    }
}
