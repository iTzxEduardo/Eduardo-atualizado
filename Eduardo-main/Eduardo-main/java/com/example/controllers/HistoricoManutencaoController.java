package com.example.controllers;

import com.example.api.HistoricoManutencaoAPI;
import com.example.models.HistoricoManutencao;

import java.util.List;
import java.util.ArrayList;

public class HistoricoManutencaoController {
    private List<HistoricoManutencao> historicos;

    public HistoricoManutencaoController() {
        historicos = new ArrayList<HistoricoManutencao>();
    }

    // Métodos - CRUD
    public void createHistoricoManutencao(HistoricoManutencao historico) {
        this.historicos.add(historico);
    }

    public List<HistoricoManutencao> headHistoricoManutencao() {
        historicos = HistoricoManutencaoAPI.getHistoricoManutencaos(); // Método para buscar históricos de manutenção
        return historicos;
    }

    public void updateHistoricoManutencao(int posicao, HistoricoManutencao historico) {
        historicos.set(posicao, historico);
    }

    public void deleteHistoricoManutencao(int posicao) {
        historicos.remove(posicao);
    }
}
