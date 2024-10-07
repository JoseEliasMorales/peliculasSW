package com.aluracursos.peliculasStarsWars.principal;

import com.aluracursos.peliculasStarsWars.modulos.Titulo;
import com.aluracursos.peliculasStarsWars.request.SWApi;
import com.google.gson.Gson;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Gson gson = new Gson();

        SWApi swApi = new SWApi(gson);
        Titulo titulo = new Titulo(swApi.buscarPeliculas());

        System.out.println(titulo);
    }
}
