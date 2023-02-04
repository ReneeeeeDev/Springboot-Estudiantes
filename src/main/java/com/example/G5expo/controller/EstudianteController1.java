package com.example.G5expo.controller;

import com.example.G5expo.entity.Estudiante;
import com.example.G5expo.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EstudianteController1 {
    @Autowired
    private EstudianteService estudianteService;
    @GetMapping("/")
    public String mostrar(Model model,@Param("buscar") String buscar){

        List<Estudiante> estudiantes=  estudianteService.mostrar(buscar);
        model.addAttribute("estudiantes", estudiantes);
        model.addAttribute("buscar", buscar);
        return "index";
    }
    @GetMapping("/nuevo-estudiante")
    public String nuevo(Estudiante estudiante){
        return "nuevoE";
    }
    @PostMapping("/accion-nuevo")
    public String insert (@Validated Estudiante estudiante, BindingResult result, Model model){
        estudianteService.insertar(estudiante);
        return "redirect:/";
    }
    @GetMapping("/editar-estudiante/{id}")
    public String editar(@PathVariable("id") String id, Model model){
        Estudiante estudiante = estudianteService.buscraporId(id);
        model.addAttribute("estudiante", estudiante);
        return "editar";
    }
    @PostMapping("/editar-accion/{id}")
    public  String update(@PathVariable("id") String id,@Validated Estudiante estudiante, BindingResult result, Model model ){
        estudianteService.update(estudiante);
        return "redirect:/";
    }
    @GetMapping("/eliminar-estudiante/{id}")
    public String delete (@PathVariable("id") String id){
        Estudiante  estudiante = estudianteService.buscraporId(id);
        estudianteService.delete(estudiante);

        return "redirect:/";
    }
}
