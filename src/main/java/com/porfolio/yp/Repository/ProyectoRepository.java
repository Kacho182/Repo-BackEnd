package com.porfolio.yp.Repository;

import com.porfolio.yp.Entity.ProyectosEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProyectoRepository extends JpaRepository< ProyectosEntity,Integer > {
    Optional<ProyectosEntity> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
