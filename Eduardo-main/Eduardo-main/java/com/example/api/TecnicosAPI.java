package com.example.api;

import org.json.JSONArray;
import org.json.JSONObject;
import com.example.models.Tecnico;
import java.util.ArrayList;
import java.util.List;

public class TecnicosAPI {

    // Método para obter todos os técnicos
    public static List<Tecnico> getTecnicos() {
        String json = ApiConnection.getData("tecnicos");
        List<Tecnico> tecnicos = new ArrayList<>();

        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Tecnico tecnico = new Tecnico(
                    jsonObject.getString("id"),
                    jsonObject.getString("nome"),
                    jsonObject.getString("especialidade"),
                    jsonObject.getString("disponibilidade")
                );
                tecnicos.add(tecnico);
            }
        }
        return tecnicos;
    }

    // Método para adicionar um novo técnico
    public static Tecnico postTecnico(Tecnico novoTecnico) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("nome", novoTecnico.getNome());
        jsonObject.put("especialidade", novoTecnico.getEspecialidade());
        jsonObject.put("disponibilidade", novoTecnico.getDisponibilidade());

        String jsonResponse = ApiConnection.postData("tecnicos", jsonObject.toString());

        if (jsonResponse != null) {
            JSONObject respostaJson = new JSONObject(jsonResponse);
            return new Tecnico(
                respostaJson.getString("id"), // ID gerado pela API
                respostaJson.getString("nome"),
                respostaJson.getString("especialidade"),
                respostaJson.getString("disponibilidade")
            );
        }
        return null; // Retorna null se a criação falhar
    }

    // Método para atualizar um técnico existente
    public static Tecnico putTecnico(Tecnico tecnicoAtualizado) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("nome", tecnicoAtualizado.getNome());
        jsonObject.put("especialidade", tecnicoAtualizado.getEspecialidade());
        jsonObject.put("disponibilidade", tecnicoAtualizado.getDisponibilidade());

        String jsonResponse = ApiConnection.putData("tecnicos/" + tecnicoAtualizado.getId(), jsonObject.toString());

        if (jsonResponse != null) {
            JSONObject respostaJson = new JSONObject(jsonResponse);
            return new Tecnico(
                respostaJson.getString("id"),
                respostaJson.getString("nome"),
                respostaJson.getString("especialidade"),
                respostaJson.getString("disponibilidade")
            );
        }
        return null; // Retorna null se a atualização falhar
    }

    // Método para excluir um técnico
    public static boolean deleteTecnico(String tecnicoId) {
        String response = ApiConnection.deleteData("tecnicos/" + tecnicoId);
        return response != null; // Retorna true se a exclusão for bem-sucedida
    }
}
