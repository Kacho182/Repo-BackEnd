package com.porfolio.yp.Service;

import com.porfolio.yp.Entity.ExperienciaEntity;
import com.porfolio.yp.Repository.ExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService {

     @Autowired
     ExperienciaRepository ExperienciaRep;
     
     public List<ExperienciaEntity> list(){
         return ExperienciaRep.findAll();
     }
     
     public Optional<ExperienciaEntity> getOne(int id){
         return ExperienciaRep.findById(id);
     }
     
     public Optional<ExperienciaEntity> getByNombre(String nombre){
         return ExperienciaRep.findByNombre(nombre);
     }
     
     public void save(ExperienciaEntity expe){
         ExperienciaRep.save(expe);
     }
     
     public void delete(int id){
         ExperienciaRep.deleteById(id);
     }
     
     public boolean existsById(int id){
         return ExperienciaRep.existsById(id);
     }
     
     public boolean existsByNombre(String nombre){
         return ExperienciaRep.existsByNombre(nombre);
     }
}

