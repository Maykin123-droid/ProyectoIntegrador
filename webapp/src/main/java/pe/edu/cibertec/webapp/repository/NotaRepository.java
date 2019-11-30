package pe.edu.cibertec.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.webapp.entity.Nota;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Integer>{

}
