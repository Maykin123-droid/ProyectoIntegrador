package pe.edu.cibertec.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.webapp.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

	
}
