package com.videojuegos.microservicio.service;
import org.springframework.stereotype.Service;

import com.videojuegos.microservicio.repository.VideoJuegoRepository;

import java.util.List;

@Service
public class VideoJuegoService {
    
    private final VideoJuegoRepository repository;

    public VideoJuegoService(VideoJuegoRepository repository){

        this.repository = repository;
    }

    public List<String> listar(){
        return repository.obtenerJuegos();
    }
    public void agregar(String nombre){
        repository.agregarJuego(nombre);
    }
    public void eliminar(String nombre){
        repository.eliminarJuego(nombre);
    }
    public void modificar(String antiguo, String nuevo){
        repository.actualizarJuego(antiguo, nuevo);
    }
    public String buscar(String nombre){
       return repository.buscarJuego(nombre);
    }
}
    