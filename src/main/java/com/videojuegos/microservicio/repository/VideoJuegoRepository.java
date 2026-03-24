package com.videojuegos.microservicio.repository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VideoJuegoRepository {

    private List<String> juegos = new ArrayList<>();

    public VideoJuegoRepository(){
        juegos.add("Fifa");
        juegos.add("Minecraft");
        juegos.add("Mario Kart");
        juegos.add("Mortal Kombat");
    }

    public List<String> obtenerJuegos(){
        return juegos;
    }

    public void agregarJuego(String nombre){
        juegos.add(nombre);
    }
    public void eliminarJuego(String nombre){
        juegos.remove(nombre);
    }
    public void actualizarJuego(String antiguo, String nuevo){
        int index = juegos.indexOf(antiguo);
        if(index != -1){
            juegos.set(index,nuevo);
        }
    }
    public String buscarJuego(String nombre){
        if (juegos.contains(nombre)){
            return ("Juego "+nombre+" Encontrado con exito");
        }
        return "No encontrado";
    }
}
