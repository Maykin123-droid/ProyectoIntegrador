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
import pe.edu.cibertec.webapp.repository.AlumnoRepository;

@Component(value = "alumnoView")
@ViewScoped
public class AlumnoView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AlumnoRepository alumnoRepository;
	
	private List<Alumno> alumnos; 
	
	private Alumno alumno;

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public Alumno getAlumno() {
		return alumno;
	}
	
	@PostConstruct
	public void init() {
		alumnos = alumnoRepository.findAll();
		alumno = new Alumno();
	}
	
	public void registrar() {
		boolean exits = alumnoRepository.existsById(alumno.getCodigoAlumno());
		alumnoRepository.save(alumno);
		if (exits) {
			addMessage("Sistema", "Se ha actualizado satisfactoriamente.");
		} else {
			addMessage("Sistema", "Se ha registrado satisfactoriamente.");
		}
		init();
	}

	public void eliminar(Alumno alu) {
		alumnoRepository.delete(alu);
		addMessage("Sistema", "Se ha eliminado satisfactoriamente.");
		init();
	}

	public void buscar(int codigo) {
		alumno = alumnoRepository.findById(codigo).get();
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
