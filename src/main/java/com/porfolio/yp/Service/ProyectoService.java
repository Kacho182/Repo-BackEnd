
package com.porfolio.yp.Service;

import com.porfolio.yp.Entity.ProyectosEntity;
import com.porfolio.yp.Repository.ProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Transactional
@Service
public class ProyectoService {
    @Autowired
    ProyectoRepository ProyectosRep;
    
    public List<ProyectosEntity> list(){
        return ProyectosRep.findAll();
    }
    
    public Optional<ProyectosEntity> getOne(int id){
        return ProyectosRep.findById(id);
    }
    
     public Optional<ProyectosEntity> getByNombre(String nombre){
         return ProyectosRep.findByNombre(nombre);
     }
     
     public void save(ProyectosEntity p){
         ProyectosRep.save(p);
     }
     
     public void delete(int id){
         ProyectosRep.deleteById(id);
     }
     
     public boolean existsById(int id){
         return ProyectosRep.existsById(id);
     }
     
     public boolean existsByNombre(String nombre){
         return ProyectosRep.existsByNombre(nombre);
     }
    
}
