package com.example.api;

import org.json.JSONArray;
import org.json.JSONObject;
import com.example.models.HistoricoManutencao;
import java.util.ArrayList;
import java.util.List;

public class HistoricoManutencaoAPI {

    // Método para obter todos os registros de histórico de manutenção
    public static List<HistoricoManutencao> getHistoricoManutencaos() {
        String json = ApiConnection.getData("historicoManutencao");
        List<HistoricoManutencao> historicoManutencaos = new ArrayList<>();

        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                HistoricoManutencao historicoManutencao = new HistoricoManutencao(
                    jsonObject.getString("id"),
                    jsonObject.getInt("maquinaId"),
                    jsonObject.getString("data"),
                    jsonObject.getString("tipo"),
                    jsonObject.getString("pecasTrocadas"),
                    jsonObject.getInt("tempoDeParada"),
                    jsonObject.getString("tecnicoId"),
                    jsonObject.getString("observacoes")
                );
                historicoManutencaos.add(historicoManutencao);
            }
        }
        return historicoManutencaos;
    }

    // Método para adicionar um novo registro de histórico de manutenção
    public static HistoricoManutencao postHistoricoManutencao(HistoricoManutencao novoHistorico) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("maquinaId", novoHistorico.getMaquinaId());
        jsonObject.put("data", novoHistorico.getData());
        jsonObject.put("tipo", novoHistorico.getTipo());
        jsonObject.put("pecasTrocadas", novoHistorico.getPecasTrocadas());
        jsonObject.put("tempoDeParada", novoHistorico.getTempoDeParada());
        jsonObject.put("tecnicoId", novoHistorico.getTecnicoId());
        jsonObject.put("observacoes", novoHistorico.getObservacoes());

        String jsonResponse = ApiConnection.postData("historicoManutencao", jsonObject.toString());

        if (jsonResponse != null) {
            JSONObject respostaJson = new JSONObject(jsonResponse);
            return new HistoricoManutencao(
                respostaJson.getString("id"), // ID gerado pela API
                respostaJson.getInt("maquinaId"),
                respostaJson.getString("data"),
                respostaJson.getString("tipo"),
                respostaJson.getString("pecasTrocadas"),
                respostaJson.getInt("tempoDeParada"),
                respostaJson.getString("tecnicoId"),
                respostaJson.getString("observacoes")
            );
        }
        return null; // Retorna null se a criação falhar
    }

    // Método para atualizar um registro de histórico de manutenção existente
    public static HistoricoManutencao putHistoricoManutencao(HistoricoManutencao historicoAtualizado) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("maquinaId", historicoAtualizado.getMaquinaId());
        jsonObject.put("data", historicoAtualizado.getData());
        jsonObject.put("tipo", historicoAtualizado.getTipo());
        jsonObject.put("pecasTrocadas", historicoAtualizado.getPecasTrocadas());
        jsonObject.put("tempoDeParada", historicoAtualizado.getTempoDeParada());
        jsonObject.put("tecnicoId", historicoAtualizado.getTecnicoId());
        jsonObject.put("observacoes", historicoAtualizado.getObservacoes());

        String jsonResponse = ApiConnection.putData("historicoManutencao/" + historicoAtualizado.getId(), jsonObject.toString());

        if (jsonResponse != null) {
            JSONObject respostaJson = new JSONObject(jsonResponse);
            return new HistoricoManutencao(
                respostaJson.getString("id"),
                respostaJson.getInt("maquinaId"),
                respostaJson.getString("data"),
                respostaJson.getString("tipo"),
                respostaJson.getString("pecasTrocadas"),
                respostaJson.getInt("tempoDeParada"),
                respostaJson.getString("tecnicoId"),
                respostaJson.getString("observacoes")
            );
        }
        return null; // Retorna null se a atualização falhar
    }
}
