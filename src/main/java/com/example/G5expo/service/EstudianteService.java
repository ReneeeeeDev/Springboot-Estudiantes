package com.example.G5expo.service;

import com.example.G5expo.entity.Estudiante;
import com.example.G5expo.repository.EstudianteRepo;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstudianteService {
    @Autowired
    private EstudianteRepo estudianteRepo;
    public List<Estudiante> mostrar(String buscar){
        if (buscar!=null){
            return  estudianteRepo.findAll(buscar);

        }
        return estudianteRepo.findAll();



    }
    public  Estudiante insertar(Estudiante estudiante){
        return estudianteRepo.save(estudiante);
    }
    public Estudiante update (Estudiante estudiante){
        return estudianteRepo.save(estudiante);
    }
    public  Estudiante buscraporId(String id){
        return estudianteRepo.findByCedula(id);
    }
    public void delete(Estudiante est){
        estudianteRepo.delete(est);
    }

}
