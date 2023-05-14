package com.porfolio.yp.Repository;

import com.porfolio.yp.Entity.ExperienciaEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExperienciaRepository extends JpaRepository<ExperienciaEntity, Integer>{
    
    public Optional<ExperienciaEntity> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
    
}
    

