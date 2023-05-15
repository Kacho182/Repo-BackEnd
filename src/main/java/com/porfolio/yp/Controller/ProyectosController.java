
package com.porfolio.yp.Controller;

import antlr.StringUtils;
import com.porfolio.yp.Dto.dtoProyectos;
import com.porfolio.yp.Entity.ProyectosEntity;
import com.porfolio.yp.Security.Controller.Mensaje;
import com.porfolio.yp.Service.ProyectoService;
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
@CrossOrigin(origins = {"http://localhost:4200","https://portfolio-argentinaprogr-1b50f.web.app"})
@RequestMapping("/proy")
public class ProyectosController {
    
    @Autowired
    ProyectoService ProyectoServ;

    @GetMapping("/lista")
    public ResponseEntity<List<ProyectosEntity>> list() {
        List<ProyectosEntity> list = ProyectoServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<ProyectosEntity> getById(@PathVariable("id") int id) {
        if (!ProyectoServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        ProyectosEntity proyect = ProyectoServ.getOne(id).get();
        return new ResponseEntity(proyect, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!ProyectoServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        ProyectoServ.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoproy) {
        /*if (StringUtils.isBlank(dtoproy.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }*/
        if (ProyectoServ.existsByNombre(dtoproy.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa Proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }

        ProyectosEntity proyect = new ProyectosEntity(dtoproy.getNombre(), dtoproy.getDescripcion());
        ProyectoServ.save(proyect);

        return new ResponseEntity(new Mensaje("Proyecto agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoproyect) {
        //Validamos si existe el ID
        if (!ProyectoServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de skills
        if (ProyectoServ.existsByNombre(dtoproyect.getNombre()) && ProyectoServ.getByNombre(dtoproyect.getNombre()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        /*if (StringUtils.isBlank(dtoproyect.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }*/

        ProyectosEntity proyect = ProyectoServ.getOne(id).get();
        proyect.setNombre(dtoproyect.getNombre());
        proyect.setDescripcion(dtoproyect.getDescripcion());
        

        ProyectoServ.save(proyect);
        return new ResponseEntity(new Mensaje("Proyecto actualizada"), HttpStatus.OK);

    }
    
}

