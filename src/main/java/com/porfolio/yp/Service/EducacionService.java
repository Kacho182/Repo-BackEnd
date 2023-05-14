/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.yp.Service;

import com.porfolio.yp.Entity.EstudiosEntity;
import com.porfolio.yp.Repository.EducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService {
    @Autowired
    EducacionRepository EducacionRep;
    
    public List<EstudiosEntity> list(){
        return EducacionRep.findAll();
    }
    
    public Optional<EstudiosEntity> getOne(int id){
        return EducacionRep.findById(id);
    }
    
    public Optional<EstudiosEntity> getByNmbre(String nombre){
        return EducacionRep.findByNombre(nombre);
    }
    
    public void save(EstudiosEntity educacion){
        EducacionRep.save(educacion);
    }
    
    public void delete(int id){
        EducacionRep.deleteById(id);
    }
    
    public boolean existsById(int id){
        return EducacionRep.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return EducacionRep.existsByNombre(nombre);
    }
}
