package com.aluracursos.peliculasStarsWars.principal;

import com.aluracursos.peliculasStarsWars.modulos.Titulo;
import com.aluracursos.peliculasStarsWars.request.SWApi;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Cargando peliculas... ");

        Gson gson = new Gson();

        SWApi swApi = new SWApi(gson);
        Titulo contarTitulos = new Titulo(swApi.contarPeliculas());

        int cantidad = contarTitulos.getCount();



        if(cantidad > 0) {
            for (int i = 1; i <= cantidad; i++) {
                Titulo tituloPeli = new Titulo(swApi.buscarPeliculas(i));
                System.out.println( i + " - " + tituloPeli.getTitulo());
            }
        }

        System.out.println("Escoge una pelicula de la lista: ");
        int opcionPelicula = teclado.nextInt();

        if(opcionPelicula < 1 | opcionPelicula > cantidad){
            System.out.println("Opcion invalida.");
        } Titulo peliculaElegida = new Titulo(swApi.buscarPeliculas(opcionPelicula));

        System.out.println(""" 
                Haz escogido %s
                Que deseas saber de la pelicula? 
                
                1 - Fecha de lanzamiento.
                2 - Numero de episodio.
                3 - Parrafo de apertura.
                """.formatted(peliculaElegida.getTitulo()));

        int opcionInfo = teclado.nextInt();

        switch (opcionInfo){
            case 1:
                System.out.println("La fecha de lanzamiento es: " + peliculaElegida.getFechaDeLanzamiento());;
                break;
            case 2:
                System.out.println("El numero de episodio es: " + peliculaElegida.getEpisodio());;
                break;
            case 3:
                System.out.println("Asi comienza la pelicula: \n" + peliculaElegida.getParrafoDeApertura());
                break;
            default:
                System.out.println("Opcion no disponible");
                break;
        }



    }
}
