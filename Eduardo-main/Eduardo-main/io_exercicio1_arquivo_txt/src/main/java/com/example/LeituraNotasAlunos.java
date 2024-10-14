package com.example;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class LeituraNotasAlunos {
    private List<Aluno> alunos;

    public LeituraNotasAlunos() {
        alunos = new ArrayList<>();   
    }
    public void leituraFile(){
        try (BufferedReader br = new BufferedReader(new FileReader("notas.txt"))){
            String linha = br.readLine();
          do {
            String [] aluno = linha.split(",");
            Aluno alunoNota = new Aluno(
                aluno[0],
                Double.parseDouble(aluno[1]),
                Double.parseDouble(aluno[2]),
                Double.parseDouble(aluno[3]));
                alunos.add(alunoNota);
                linha = br.readLine();
          } while (linha!=null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(alunos);
    }

    //aluno com maior nota

    public void alunoMaiorNota(){
        String nome= "";
        double maiorNota = 0;
        for (Aluno aluno : alunos) {
            if (aluno.maiorNotaAluno()>maiorNota) {
                maiorNota = aluno.maiorNotaAluno();
                nome = aluno.getNome();
            }
        }
        System.out.println("O Aluno com Maior nota é " +nome +" com nota = "+maiorNota);
   }
 
   //aluno com menor nota

   public void alunoMenorNota(){
    String nome= "";
    double menorNota = 10;
    for (Aluno aluno : alunos) {
        if (aluno.menorNotaAluno()<menorNota) {
            menorNota = aluno.menorNotaAluno();
            nome = aluno.getNome();
        }
    }
    System.out.println("O Aluno com menor a nota é " +nome +" com nota = "+menorNota);
}

//media geral das notas

public void mediaTurma(){
    double mediaNotasTurmas = 0;
    for (Aluno aluno : alunos) {
        mediaNotasTurmas += aluno.mediaTurma();
    }
    mediaNotasTurmas /= alunos.size();
    System.out.println("A média da Turma é =  "+mediaNotasTurmas);
}
}
