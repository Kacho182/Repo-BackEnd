package com.porfolio.yp.Repository;

import com.porfolio.yp.Entity.PersonaEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonaRepository extends JpaRepository<PersonaEntity, Integer> {
    public Optional<PersonaEntity> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}

