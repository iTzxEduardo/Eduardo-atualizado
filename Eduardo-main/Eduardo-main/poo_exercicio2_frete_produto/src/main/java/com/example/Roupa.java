package com.example;

public class Roupa extends Produto implements Transportavel {
    private double volume;

    public Roupa(String nome, double preco, double volume){
        super(nome, preco);
        this.volume = volume;
    }
    @Override
    public double calcularPeso(){
        double peso = volume * 2.75;
        return peso;
    }

    @Override
    public double calcularFrete(){
        double valorFrete = calcularPeso()*0.4;
        return valorFrete;
    }
}
