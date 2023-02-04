package com.example.G5expo.controller;

import com.example.G5expo.entity.Estudiante;
import com.example.G5expo.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;
    @GetMapping
    public List<Estudiante> mostrar(@PathVariable("buscar") String buscar){

        return  estudianteService.mostrar(buscar);
    }
    @PostMapping
    public Estudiante insert (@RequestBody Estudiante estudiante){
        return  estudianteService.insertar(estudiante);
    }
    @PutMapping
    public  Estudiante update (@RequestBody Estudiante est){
        return  estudianteService.update(est);
    }




}
