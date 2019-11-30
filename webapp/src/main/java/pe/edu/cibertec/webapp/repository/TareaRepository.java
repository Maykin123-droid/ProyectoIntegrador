package pe.edu.cibertec.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.webapp.entity.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer>  {

}
