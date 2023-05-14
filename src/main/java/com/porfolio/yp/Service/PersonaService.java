package com.porfolio.yp.Service;

import com.porfolio.yp.Entity.PersonaEntity;
import com.porfolio.yp.Repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class PersonaService {

    @Autowired
    PersonaRepository PersonaRepo;
    
    public List<PersonaEntity> list(){
         return PersonaRepo.findAll();
     }
     
     public Optional<PersonaEntity> getOne(int id){
         return PersonaRepo.findById(id);
     }
     
     public Optional<PersonaEntity> getByNombre(String nombre){
         return PersonaRepo.findByNombre(nombre);
     }
     
     public void save(PersonaEntity persona){
         PersonaRepo.save(persona);
     }
     
     public void delete(int id){
         PersonaRepo.deleteById(id);
     }
     
     public boolean existsById(int id){
         return PersonaRepo.existsById(id);
     }
     
     public boolean existsByNombre(String nombre){
         return PersonaRepo.existsByNombre(nombre);
     }
}

