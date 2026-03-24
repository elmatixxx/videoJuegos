package com.videojuegos.microservicio.controller;

import com.videojuegos.microservicio.service.VideoJuegoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/juegos")
public class VideoJuegoController {

    private final VideoJuegoService service;

    public VideoJuegoController(VideoJuegoService service){
        this.service = service;
    }

    @GetMapping("/Listar")
    public List<String> listar(){
        return service.listar();
    }

    @PostMapping("/agregar")
    public String agregar(@RequestBody java.util.Map<String, String>body){
        String nombre = body.get("nombre");
        service.agregar(nombre);
        return ("El juego "+nombre+" se agrego con exito");
    }

    @PutMapping("/modificar")
    public String actualizar(@RequestBody java.util.Map<String, String>body) {

        String antiguo = body.get("antiguo");
        String nuevo = body.get("nuevo");

        service.modificar(antiguo, nuevo);
        return "Juego modificado";
    }
    
    @DeleteMapping("/eliminar")
    public String eliminar(@RequestBody java.util.Map<String, String>body){
        String nombre = body.remove("nombre");
        service.eliminar(nombre);
        return("El juego fue eliminado con exito");
    }
    @GetMapping("/buscar/{nombre}")
    public String buscar(@PathVariable String nombre){
        return service.buscar(nombre);
    }
        
}
