
package com.porfolio.yp.Controller;

import antlr.StringUtils;
import com.porfolio.yp.Dto.dtoEducacion;
import com.porfolio.yp.Entity.EstudiosEntity;
import com.porfolio.yp.Security.Controller.Mensaje;
import com.porfolio.yp.Service.EducacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educ")
@CrossOrigin(origins = {"https://hosting-portfolio-3b1b8.web.app","http://localhost:4200"})
public class EducacionController {
    @Autowired
    EducacionService EducacionServ;
    
    @GetMapping("/lista")
    public ResponseEntity<List<EstudiosEntity>> list(){
        List<EstudiosEntity> list = EducacionServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<EstudiosEntity> getById(@PathVariable("id")int id){
        if(!EducacionServ.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        EstudiosEntity educacion = EducacionServ.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!EducacionServ.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        EducacionServ.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion){
        
        /*if(StringUtils.isBlank(dtoeducacion.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }*/
        if(EducacionServ.existsByNombre(dtoeducacion.getNombre())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        EstudiosEntity educacion = new EstudiosEntity(
                dtoeducacion.getNombre(), dtoeducacion.getDescripcion(), dtoeducacion.getTiempo()
            );
        EducacionServ.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
                
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeducacion){
        if(!EducacionServ.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(EducacionServ.existsByNombre(dtoeducacion.getNombre()) && EducacionServ.getByNmbre(dtoeducacion.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        /*if(EducacionServ.isBlank(dtoeducacion.getNombre())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }*/
        
        EstudiosEntity educacion = EducacionServ.getOne(id).get();
        
        educacion.setNombreE(dtoeducacion.getNombre());
        educacion.setDescripcionE(dtoeducacion.getDescripcion());
        educacion.setTiempo(dtoeducacion.getTiempo());
        
        EducacionServ.save(educacion);
        
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
}