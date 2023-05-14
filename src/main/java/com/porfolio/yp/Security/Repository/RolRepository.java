
package com.porfolio.yp.Security.Repository;

import com.porfolio.yp.Security.Entity.Rol;
import com.porfolio.yp.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}