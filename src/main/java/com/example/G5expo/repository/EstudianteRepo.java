package com.example.G5expo.repository;

import com.example.G5expo.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepo extends JpaRepository<Estudiante, String> {

    @Query("SELECT e FROM Estudiante e WHERE e.est_cedula= :ced")
    Estudiante findByCedula(@Param("ced")String ced);

    @Query("SELECT e FROM Estudiante e WHERE CONCAT(e.est_cedula, e.est_nombre, e.est_apellido, e.est_direccion) LIKE %?1%")
    List<Estudiante> findAll(String palabra);
}
