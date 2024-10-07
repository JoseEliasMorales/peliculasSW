package com.aluracursos.peliculasStarsWars.modulos;

import com.aluracursos.peliculasStarsWars.principal.CountTitles;
import com.aluracursos.peliculasStarsWars.principal.TitulosSWApi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Titulo {
    private int count;
    private String titulo;
    private String fechaDeLanzamiento;
    private int episodio;
    private String parrafoDeApertura;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");


    public Titulo(CountTitles tituloAdaptado){
        this.count = Integer.valueOf(tituloAdaptado.count());
    }

    public String getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public int getEpisodio() {
        return episodio;
    }

    public String getParrafoDeApertura() {
        return parrafoDeApertura;
    }

    public Titulo(TitulosSWApi titulosSWApi){
        this.titulo = titulosSWApi.title();
        this.fechaDeLanzamiento = LocalDate.parse(titulosSWApi.release_date()).format(formatter);
        this.episodio = Integer.valueOf(titulosSWApi.episode_id());
        this.parrafoDeApertura = titulosSWApi.opening_crawl();
    }


    public int getCount() {
        return count;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return ": " + this.getTitulo();
    }
}
