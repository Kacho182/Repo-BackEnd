package com.porfolio.yp.Service;

import com.porfolio.yp.Entity.SkillsEntity;
import com.porfolio.yp.Repository.SkillsRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class SkillsService {

    @Autowired
    SkillsRepository SkillsRep;
    
    public List<SkillsEntity> list(){
        return SkillsRep.findAll();
    }
    
    public Optional<SkillsEntity> getOne(int id){
        return SkillsRep.findById(id);
    }
    
    public Optional<SkillsEntity> getByNombre(String nombre){
        return SkillsRep.findByNombre(nombre);
    }
    
    public void save(SkillsEntity skill){
        SkillsRep.save(skill);
    }
    
    public void delete(int id){
        SkillsRep.deleteById(id);
    }
    
    public boolean existsById(int id){
        return SkillsRep.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return SkillsRep.existsByNombre(nombre);
    }
}

