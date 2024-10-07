package com.aluracursos.peliculasStarsWars.request;

import com.aluracursos.peliculasStarsWars.modulos.Titulo;
import com.aluracursos.peliculasStarsWars.principal.CountTitles;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SWApi {
    private HttpClient client;
    private String direccion = "https://swapi.dev/api/films/";
    private Gson gson;
    private String json;

    public SWApi(Gson gson){
        this.client = HttpClient.newHttpClient();
        this.gson = gson;
    }

    public CountTitles buscarPeliculas() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        this.json = response.body();
        return gson.fromJson(json, CountTitles.class);
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    @Override
    public String toString() {
        return "result: " + this.getJson();
    }
}
