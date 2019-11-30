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
import pe.edu.cibertec.webapp.entity.Nota;
import pe.edu.cibertec.webapp.entity.Tarea;
import pe.edu.cibertec.webapp.repository.AlumnoRepository;
import pe.edu.cibertec.webapp.repository.CursoRepository;
import pe.edu.cibertec.webapp.repository.NotaRepository;


@Component(value = "notaView")
@ViewScoped
public class NotaView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private NotaRepository notaRepository;
	
	@Inject
	private CursoRepository cursoRepository;
	
	@Inject
	private AlumnoRepository alumnoRepository;
	
	
	private List<Nota> notas;
	private Nota nota;
	
	
	@PostConstruct
	public void init() {
		notas = notaRepository.findAll();
		nota = new Nota();
	}
	
	
	public void registrar() {
		boolean exits = notaRepository.existsById(nota.getCodigoNota());
		Alumno alu = alumnoRepository.findById(nota.getAlumno().getCodigoAlumno()).get();
		Curso cur = cursoRepository.findById(nota.getCurso().getCodigoCurso()).get();
		nota.setAlumno(alu);
		nota.setCurso(cur);
		notaRepository.save(nota);
		if (exits) {
			addMessage("Sistema", "Se ha actualizado satisfactoriamente.");
		} else {
			addMessage("Sistema", "Se ha registrado satisfactoriamente.");
		}
		init();
	}
	
	public void eliminar(int codigo) {
		notaRepository.deleteById(codigo);
		addMessage("Sistema", "Se ha eliminado satisfactoriamente.");
		init();
	}

	public void buscar(int codigo) {
		nota = notaRepository.findById(codigo).get();
	}
	
	
	
	
	public NotaRepository getNotaRepository() {
		return notaRepository;
	}


	public void setNotaRepository(NotaRepository notaRepository) {
		this.notaRepository = notaRepository;
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


	public List<Nota> getNotas() {
		return notas;
	}


	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}


	public Nota getNota() {
		return nota;
	}


	public void setNota(Nota nota) {
		this.nota = nota;
	}


	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
}
