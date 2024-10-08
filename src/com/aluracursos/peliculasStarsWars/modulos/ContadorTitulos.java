package com.aluracursos.peliculasStarsWars.modulos;

import com.aluracursos.peliculasStarsWars.principal.CountTitles;

public class ContadorTitulos {
    private int count;

    public int getCount() {
        return count;
    }

    public ContadorTitulos(CountTitles countTitles){
        this.count = Integer.valueOf(countTitles.count());
    }
}
