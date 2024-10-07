package com.aluracursos.peliculasStarsWars.modulos;

import com.aluracursos.peliculasStarsWars.principal.CountTitles;
import com.google.gson.annotations.SerializedName;

public class Titulo {
    private int count;

    public Titulo(int count){
        this.count = count;
    }

    public Titulo(CountTitles tituloAdaptado){
        this.count = Integer.valueOf(tituloAdaptado.count());
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "count: " + this.getCount();
    }
}
