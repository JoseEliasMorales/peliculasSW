package com.aluracursos.peliculasStarsWars.request;


import com.aluracursos.peliculasStarsWars.principal.CountTitles;
import com.aluracursos.peliculasStarsWars.principal.TitulosSWApi;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class SWApi {
    private HttpClient client;
    private String direccion ;
    private Gson gson;
    private String json;

    public SWApi(Gson gson){
        this.client = HttpClient.newHttpClient();
        this.gson = gson;

    }

    private String request(int busqueda)  {
        if (busqueda != 0){
            this.direccion = "https://swapi.py4e.com/api/films/" + busqueda + "/";
        } else {
            this.direccion = "https://swapi.py4e.com/api/films/";
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        this.json = response.body();
        return json;
    }

    public CountTitles contarPeliculas() throws IOException, InterruptedException {
        String json = request(0);
        return gson.fromJson(json, CountTitles.class);
    }

    public TitulosSWApi buscarPeliculas(int numero) throws IOException, InterruptedException {
        String json = request(numero);
        return gson.fromJson(json, TitulosSWApi.class);
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
