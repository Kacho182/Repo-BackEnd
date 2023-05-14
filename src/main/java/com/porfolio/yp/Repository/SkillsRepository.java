package com.porfolio.yp.Repository;

import com.porfolio.yp.Entity.SkillsEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillsRepository extends JpaRepository<SkillsEntity, Integer>{
    Optional<SkillsEntity> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}

