package com.aluracursos.peliculasStarsWars.modulos;

import com.aluracursos.peliculasStarsWars.principal.CountTitles;
import com.aluracursos.peliculasStarsWars.principal.TitulosSWApi;





public class Titulo {

    private String titulo;
    private int fechaDeLanzamiento;
    private int episodio;
    private String parrafoDeApertura;





    public int getFechaDeLanzamiento() {
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
        this.fechaDeLanzamiento = Integer.valueOf(titulosSWApi.release_date().substring(0, 4));
        this.episodio = Integer.valueOf(titulosSWApi.episode_id());
        this.parrafoDeApertura = titulosSWApi.opening_crawl();
    }



    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return ": " + this.getTitulo();
    }
}
