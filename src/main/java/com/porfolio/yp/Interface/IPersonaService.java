package com.porfolio.yp.Interface;

import com.porfolio.yp.Entity.PersonaEntity;
import java.util.List;


public interface IPersonaService {
    //Traer una lista de personas
    public List<PersonaEntity> getPersona();
    
    //Guardar un objeto de tipo Persona
    public void savePersona(PersonaEntity persona);
    
    //Eliminar un objeto pero lo buscamos por ID
    public void deletePersona(Long id);
    
    //Buscar una persona por ID
    public PersonaEntity findPersona(Long id);
}
