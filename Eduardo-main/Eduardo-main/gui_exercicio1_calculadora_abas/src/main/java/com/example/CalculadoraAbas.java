package com.example;

import javax.swing.*;

public class CalculadoraAbas extends JFrame{

    //atributos
 

    //construtor

    public CalculadoraAbas() {
        super("Calculadora com abas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        //cria as abas
        JTabbedPane abas = new JTabbedPane();

        JPanel calcSimples = new CalculadoraSimples();
        abas.addTab("Simples", calcSimples);

        JPanel calcAvancada = new CalculadorAvancada();
        abas.addTab("Avançada", calcAvancada);
        
        this.add(abas);
        this.setVisible(true);
    }
}
