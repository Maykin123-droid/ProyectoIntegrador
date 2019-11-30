package pe.edu.cibertec.webapp.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import pe.edu.cibertec.webapp.entity.Alumno;
import pe.edu.cibertec.webapp.entity.Curso;
import pe.edu.cibertec.webapp.repository.AlumnoRepository;
import pe.edu.cibertec.webapp.repository.CursoRepository;


@Component(value = "cursoView")
@ViewScoped
public class CursoView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CursoRepository cursoRepository;
	
	@Inject
	private AlumnoRepository alumnoRepository;	
	
	private List<Curso> cursos;
	private Curso curso;
	
	
	@PostConstruct
	public void init() {
		cursos = cursoRepository.findAll();
		curso = new Curso();
	}

	public void registrar() {
		boolean exits = cursoRepository.existsById(curso.getCodigoCurso());
		Alumno alu = alumnoRepository.findById(curso.getAlumno().getCodigoAlumno()).get();
		curso.setAlumno(alu);
		cursoRepository.save(curso);
		if (exits) {
			addMessage("Sistema", "Se ha actualizado satisfactoriamente.");
		} else {
			addMessage("Sistema", "Se ha registrado satisfactoriamente.");
		}
		init();
	}
	
	public void eliminar(int codigo) {
		cursoRepository.deleteById(codigo);
		addMessage("Sistema", "Se ha eliminado satisfactoriamente.");
		init();
	}

	public void buscar(int codigo) {
		curso = cursoRepository.findById(codigo).get();
	}

    
	
	public List<Curso> getCursos() {
		return cursos;
	}

	public Curso getCurso() {
		return curso;
	}
	
	

	public CursoRepository getCursoRepository() {
		return cursoRepository;
	}

	public void setCursoRepository(CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}

	public AlumnoRepository getAlumnoRepository() {
		return alumnoRepository;
	}

	public void setAlumnoRepository(AlumnoRepository alumnoRepository) {
		this.alumnoRepository = alumnoRepository;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	

}
