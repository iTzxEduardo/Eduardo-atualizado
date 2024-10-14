package com.example;

import javax.swing.*;
import java.awt.*;

public class CalculadorAvancada extends JPanel {
    
    //atributos
    JTextField displayAvancado;
    String[] botoes = {
        "^", "sqrt","log", "!",
        "7", "8", "9", "/",
        "4", "5", "6", "*",
        "1", "2", "3", "-",
        "0", ".", "+", "c",
       
    };

    //contrutor
    public CalculadorAvancada(){
        super(new BorderLayout());
        displayAvancado = new JTextField();
        add(displayAvancado, BorderLayout.NORTH);
        displayAvancado.setEditable(false);
        this.add(displayAvancado,BorderLayout.NORTH);

         //criar um painel para os botoes
         JPanel painelBotoes = new JPanel(new GridLayout(5, 5, 3, 3));
         for (String textoBotoes : botoes) {
             JButton botao = new JButton(textoBotoes);
 
             //adicionar ação dos botoes
             painelBotoes.add(botao);
        }
        this.add(painelBotoes, BorderLayout.CENTER);
    }
}
