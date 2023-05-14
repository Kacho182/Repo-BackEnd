
package com.porfolio.yp.Controller;

import antlr.StringUtils;
import com.porfolio.yp.Dto.dtoExperiencia;
import com.porfolio.yp.Entity.ExperienciaEntity;
import com.porfolio.yp.Security.Controller.Mensaje;
import com.porfolio.yp.Service.ExperienciaService;
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
@RequestMapping("/exp")
@CrossOrigin(origins = {"https://hosting-portfolio-3b1b8.web.app","http://localhost:4200"})
public class ExperienciaController {
    @Autowired
    ExperienciaService ExperienciaServ;
    
    @GetMapping("/lista")
    public ResponseEntity<List<ExperienciaEntity>> list(){
        List<ExperienciaEntity> list = ExperienciaServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<ExperienciaEntity> getById(@PathVariable("id") int id){
        if(!ExperienciaServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        ExperienciaEntity experiencia = ExperienciaServ.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!ExperienciaServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        ExperienciaServ.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp){      
        /*if(StringUtils.isBlank(dtoexp.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);*/
        if(ExperienciaServ.existsByNombre(dtoexp.getNombre()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
        ExperienciaEntity experiencia = new ExperienciaEntity(dtoexp.getNombre(), dtoexp.getDescripcion(), dtoexp.getTiempo());
        ExperienciaServ.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp){
        //Validamos si existe el ID
        if(!ExperienciaServ.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(ExperienciaServ.existsByNombre(dtoexp.getNombre()) && ExperienciaServ.getByNombre(dtoexp.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        /*if(StringUtils.isBlank(dtoexp.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);*/
        
        ExperienciaEntity experiencia = ExperienciaServ.getOne(id).get();
        experiencia.setNombreE(dtoexp.getNombre());
        experiencia.setDescripcionE(dtoexp.getDescripcion());
        experiencia.setTiempo(dtoexp.getTiempo());
        
        
        ExperienciaServ.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
             
    }
}