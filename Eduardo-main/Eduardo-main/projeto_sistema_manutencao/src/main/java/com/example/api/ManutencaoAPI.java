package com.example.api;


import org.json.JSONArray;
import org.json.JSONObject;

import com.example.models.Manutencao;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class ManutencaoAPI {

    public static List<Manutencao> getManutencaos() {
        String json = ApiConnection.getData("manutencaos");
        List<Manutencao> manutencaos = new ArrayList<>();

        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Manutencao manutencao = new Manutencao(
                    jsonObject.getString("id"),
                    jsonObject.getString("codigo"),
                    jsonObject.getString("nome"),
                    jsonObject.getString("modelo"),
                    jsonObject.getString("fabricante"),
                    LocalDate.parse(jsonObject.getString("dataAquisicao")),
                    jsonObject.getInt("tempoVidaEstimado"),
                    jsonObject.getString("localizacao"),
                    jsonObject.getString("detalhes"),
                    jsonObject.getString("manual")
                );
                manutencaos.add(manutencao);
            }
        }
        return manutencaos;
    }

    public static void postManutencaos(Manutencao manutencao){
        //Criar um Objeto Json
        JSONObject manutencaoObject = new JSONObject();
        manutencaoObject.put("id",manutencao.getId());
        manutencaoObject.put("codigo",manutencao.getCodigo());
        manutencaoObject.put("nome",manutencao.getNome());
        manutencaoObject.put("modelo",manutencao.getModelo());
        manutencaoObject.put("fabricante",manutencao.getFabricante());
        manutencaoObject.put("dataAquisicao", manutencao.getDataAquisicao().toString());
        manutencaoObject.put("tempoVidaEstimado", manutencao.getTempoVidaEstimado());
        manutencaoObject.put("localizacao",manutencao.getLocalizacao());
        manutencaoObject.put("detalhes",manutencao.getDetalhes());
        manutencaoObject.put("manual",manutencao.getManual());

        //gravando no 
        if (!manutencaoObject.isEmpty()) {
            ApiConnection.postData("manutencaos",manutencaoObject.toString());
        }
        
    }
    //Método putManutencao
    public static void putManutencaos(Manutencao manutencao){
        //Criar um Objeto Json
        JSONObject manutencaoObject = new JSONObject();
        manutencaoObject.put("id",manutencao.getId());
        manutencaoObject.put("codigo",manutencao.getCodigo());
        manutencaoObject.put("nome",manutencao.getNome());
        manutencaoObject.put("modelo",manutencao.getModelo());
        manutencaoObject.put("fabricante",manutencao.getFabricante());
        manutencaoObject.put("dataAquisicao", manutencao.getDataAquisicao().toString());
        manutencaoObject.put("tempoVidaEstimado", manutencao.getTempoVidaEstimado());
        manutencaoObject.put("localizacao",manutencao.getLocalizacao());
        manutencaoObject.put("detalhes",manutencao.getDetalhes());
        manutencaoObject.put("manual",manutencao.getManual());

        //gravando no 
        if (!manutencaoObject.isEmpty()) {
            ApiConnection.putData("manutencaos",
            manutencaoObject.toString(),
            manutencao.getId());
        }
        
    }



}

