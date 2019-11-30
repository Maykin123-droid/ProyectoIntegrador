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
import pe.edu.cibertec.webapp.entity.Tarea;
import pe.edu.cibertec.webapp.repository.AlumnoRepository;
import pe.edu.cibertec.webapp.repository.CursoRepository;
import pe.edu.cibertec.webapp.repository.TareaRepository;

@Component(value = "tareaView")
@ViewScoped
public class TareaView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private TareaRepository tareaRepository;
	
	@Inject
	private CursoRepository cursoRepository;
	
	@Inject
	private AlumnoRepository alumnoRepository;	
	
	private List<Tarea> tareas;
	private Tarea tarea;
	
	@PostConstruct
	public void init() {
		tareas = tareaRepository.findAll();
		tarea = new Tarea();
	}
	
	public void registrar() {
		boolean exits = tareaRepository.existsById(tarea.getCodigoTarea());
		Alumno alu = alumnoRepository.findById(tarea.getAlumno().getCodigoAlumno()).get();
		Curso cur = cursoRepository.findById(tarea.getCurso().getCodigoCurso()).get();
		tarea.setAlumno(alu);
		tarea.setCurso(cur);
		tareaRepository.save(tarea);
		if (exits) {
			addMessage("Sistema", "Se ha actualizado satisfactoriamente.");
		} else {
			addMessage("Sistema", "Se ha registrado satisfactoriamente.");
		}
		init();
	}
	
	public void eliminar(int codigo) {
		tareaRepository.deleteById(codigo);
		addMessage("Sistema", "Se ha eliminado satisfactoriamente.");
		init();
	}

	public void buscar(int codigo) {
		tarea = tareaRepository.findById(codigo).get();
	}
	

	
	public TareaRepository getTareaRepository() {
		return tareaRepository;
	}

	public void setTareaRepository(TareaRepository tareaRepository) {
		this.tareaRepository = tareaRepository;
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

	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

	public Tarea getTarea() {
		return tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
