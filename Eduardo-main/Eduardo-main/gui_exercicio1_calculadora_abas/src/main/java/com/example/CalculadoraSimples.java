package com.example;

import javax.swing.*;
import java.awt.*;



public class CalculadoraSimples extends JPanel{

    //atributos
    JTextField displaySimples;
    String[] botoes = {
        "7", "8", "9", "/",
        "4", "5", "6", "*",
        "1", "2", "3", "-",
        "0", "=", "+", "c"
    };

    //contrutor
    public CalculadoraSimples() {
        super(new BorderLayout());
        displaySimples = new JTextField();
        displaySimples.setHorizontalAlignment(JTextField.RIGHT);
        displaySimples.setEditable(false);
        this.add(displaySimples,BorderLayout.NORTH);

        //criar um painel para os botoes
        JPanel painelBotoes = new JPanel(new GridLayout(4, 4, 3, 3));
        for (String textoBotoes : botoes) {
            JButton botao = new JButton(textoBotoes);

            //adicionar ação dos botoes
            painelBotoes.add(botao);
       }
        //adicionar os botoes ao painel principal
        this.add(painelBotoes, BorderLayout.CENTER);
    }

    
    public void setDisplay(String texto) {
        this.displaySimples.setText(texto);
    }
    public String  getDisplay() {
        return displaySimples.getText();
    }
}
