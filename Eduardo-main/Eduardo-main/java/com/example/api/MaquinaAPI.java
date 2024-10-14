package com.example.api;

import org.json.JSONArray;
import org.json.JSONObject;
import com.example.models.Maquina;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MaquinaAPI {

    // Método para obter todas as máquinas
    public static List<Maquina> getMaquinas() {
        String json = ApiConnection.getData("maquinas");
        List<Maquina> maquinas = new ArrayList<>();
    
        if (json != null) {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("maquinas"); // Acesso ao array "maquinas"
            
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonItem = jsonArray.getJSONObject(i);
                Maquina maquina = new Maquina(
                    jsonItem.getString("id"),
                    jsonItem.getString("codigo"),
                    jsonItem.getString("nome"),
                    jsonItem.getString("modelo"),
                    jsonItem.getString("fabricante"),
                    LocalDate.parse(jsonItem.getString("dataAquisicao")),
                    jsonItem.getInt("tempoVidaEstimado"),
                    jsonItem.getString("localizacao"),
                    jsonItem.getString("detalhes"),
                    jsonItem.optString("manual", null) // Evita exceção se "manual" não estiver presente
                );
                maquinas.add(maquina);
            }
        }
        return maquinas;
    }
    

    // Método para adicionar uma nova máquina
    public static Maquina postMaquina(Maquina novaMaquina) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("codigo", novaMaquina.getCodigo());
        jsonObject.put("nome", novaMaquina.getNome());
        jsonObject.put("modelo", novaMaquina.getModelo());
        jsonObject.put("fabricante", novaMaquina.getFabricante());
        jsonObject.put("dataAquisicao", novaMaquina.getDataAquisicao().toString());
        jsonObject.put("tempoVidaEstimado", novaMaquina.getTempoVidaEstimado());
        jsonObject.put("localizacao", novaMaquina.getLocalizacao());
        jsonObject.put("detalhes", novaMaquina.getDetalhes());
        jsonObject.put("manual", novaMaquina.getManual());

        String jsonResponse = ApiConnection.postData("maquinas", jsonObject.toString());

        if (jsonResponse != null) {
            JSONObject respostaJson = new JSONObject(jsonResponse);
            return new Maquina(
                respostaJson.getString("id"),
                respostaJson.getString("codigo"),
                respostaJson.getString("nome"),
                respostaJson.getString("modelo"),
                respostaJson.getString("fabricante"),
                LocalDate.parse(respostaJson.getString("dataAquisicao")),
                respostaJson.getInt("tempoVidaEstimado"),
                respostaJson.getString("localizacao"),
                respostaJson.getString("detalhes"),
                respostaJson.getString("manual")
            );
        }
        return null;
    }

    // Método para atualizar uma máquina existente
    public static Maquina putMaquina(Maquina maquinaAtualizada) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("codigo", maquinaAtualizada.getCodigo());
        jsonObject.put("nome", maquinaAtualizada.getNome());
        jsonObject.put("modelo", maquinaAtualizada.getModelo());
        jsonObject.put("fabricante", maquinaAtualizada.getFabricante());
        jsonObject.put("dataAquisicao", maquinaAtualizada.getDataAquisicao().toString());
        jsonObject.put("tempoVidaEstimado", maquinaAtualizada.getTempoVidaEstimado());
        jsonObject.put("localizacao", maquinaAtualizada.getLocalizacao());
        jsonObject.put("detalhes", maquinaAtualizada.getDetalhes());
        jsonObject.put("manual", maquinaAtualizada.getManual());

        String jsonResponse = ApiConnection.putData("maquinas/" + maquinaAtualizada.getId(), jsonObject.toString());

        if (jsonResponse != null) {
            JSONObject respostaJson = new JSONObject(jsonResponse);
            return new Maquina(
                respostaJson.getString("id"),
                respostaJson.getString("codigo"),
                respostaJson.getString("nome"),
                respostaJson.getString("modelo"),
                respostaJson.getString("fabricante"),
                LocalDate.parse(respostaJson.getString("dataAquisicao")),
                respostaJson.getInt("tempoVidaEstimado"),
                respostaJson.getString("localizacao"),
                respostaJson.getString("detalhes"),
                respostaJson.getString("manual")
            );
        }
        return null; // Retorna null se a atualização falhar
    }

    // Método para deletar uma máquina
    public static void deleteMaquina(String id) {
        ApiConnection.deleteData("maquinas/" + id);
    }
}
