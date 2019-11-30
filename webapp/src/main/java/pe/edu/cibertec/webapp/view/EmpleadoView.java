package pe.edu.cibertec.webapp.view;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

import pe.edu.cibertec.webapp.entity.Empleado;
import pe.edu.cibertec.webapp.repository.EmpleadoRepository;

@Component(value = "empleadoView")
@ViewScoped
public class EmpleadoView {
	
	@Inject
	private EmpleadoRepository empleadoRepository;

	private String nombre;
	@NotEmpty(message = "Usuario en blanco")
	private String usuario;
	@NotEmpty(message = "Contraseña en blanco")
	private String clave;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String login() {
		Empleado emp = empleadoRepository.login(usuario, clave);
		if (emp != null) {
			return "dashboard";
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario y/o contraseña incorrecta", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return "login";
		}
	}

}
