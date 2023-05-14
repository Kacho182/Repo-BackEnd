package com.porfolio.yp.Repository;

import com.porfolio.yp.Entity.EstudiosEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EducacionRepository extends JpaRepository<EstudiosEntity, Integer>{
    public Optional<EstudiosEntity> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
