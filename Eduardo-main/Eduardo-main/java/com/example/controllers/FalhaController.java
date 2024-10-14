package com.example.controllers;

import com.example.api.FalhaAPI;
import com.example.models.Falha;

import java.util.List;
import java.util.ArrayList;

public class FalhaController {
    private List<Falha> falhas;

    public FalhaController() {
        falhas = new ArrayList<Falha>();
    }

    // Métodos - CRUD
    public void createFalha(Falha falha) {
        this.falhas.add(falha);
    }

    public List<Falha> headFalhas() {
        falhas = FalhaAPI.getFalhas(); // Método para buscar falhas
        return falhas;
    }

    public void updateFalha(int posicao, Falha falha) {
        falhas.set(posicao, falha);
    }

    public void deleteFalha(int posicao) {
        falhas.remove(posicao);
    }
}
