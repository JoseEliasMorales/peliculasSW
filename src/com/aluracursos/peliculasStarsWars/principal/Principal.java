package com.aluracursos.peliculasStarsWars.principal;

import com.aluracursos.peliculasStarsWars.modulos.ContadorTitulos;
import com.aluracursos.peliculasStarsWars.modulos.Titulo;
import com.aluracursos.peliculasStarsWars.request.SWApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner teclado = new Scanner(System.in);
        List<Titulo> listaDePeliculas = new ArrayList<>();

        System.out.println("Cargando peliculas... ");

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        SWApi swApi = new SWApi(gson);

        ContadorTitulos contarTitulos = new ContadorTitulos(swApi.contarPeliculas());

        int cantidad = contarTitulos.getCount();



        if(cantidad > 0) {
            for (int i = 1; i <= cantidad; i++) {
                Titulo tituloPeli = new Titulo(swApi.buscarPeliculas(i));
                System.out.println( i + " - " + tituloPeli.getTitulo());
            }
        }

        boolean activo = true;
        while (activo){
            System.out.println("Escoge una pelicula: ");



            try{
                int opcionPelicula = teclado.nextInt();
                if(opcionPelicula < 1 | opcionPelicula > cantidad){
                    System.out.println("Opcion invalida.");
                } Titulo peliculaElegida = new Titulo(swApi.buscarPeliculas(opcionPelicula));

                FileWriter escritura = new FileWriter("peliculas.json");
                listaDePeliculas.add(peliculaElegida);
                System.out.println(listaDePeliculas);
                escritura.write(gson.toJson(listaDePeliculas));
                escritura.close();

                System.out.println(""" 
                Haz escogido %s
                Que deseas saber de la pelicula? 
                
                1 - Fecha de lanzamiento.
                2 - Numero de episodio.
                3 - Parrafo de apertura.
                4 - Salir
                """.formatted(peliculaElegida.getTitulo()));

                int opcionInfo = teclado.nextInt();

                switch (opcionInfo){
                    case 1:
                        System.out.println("La fecha de lanzamiento es: " + peliculaElegida.getFechaDeLanzamiento());;
                        continue;
                    case 2:
                        System.out.println("El numero de episodio es: " + peliculaElegida.getEpisodio());;
                        continue;
                    case 3:
                        System.out.println("Asi comienza la pelicula: \n" + peliculaElegida.getParrafoDeApertura());
                        continue;
                    case 4:
                        activo = false;
                        System.out.println("Que la fuerza te acompañe! Adios!");
                        break;
                    default:
                        System.out.println("Opcion no disponible");
                        continue;
                }
            }catch (InputMismatchException e){
                System.out.println("Error: Utilice solo numeros.");
            }
        }





    }
}
