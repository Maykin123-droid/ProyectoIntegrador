package pe.edu.cibertec.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.webapp.entity.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

	@Query("SELECT e FROM Empleado e WHERE e.usuario = :usuario AND e.clave = :clave")
	Empleado login(@Param("usuario") String usuario, @Param("clave") String clave);
}
