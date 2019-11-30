package pe.edu.cibertec.webapp.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tarea database table.
 * 
 */
@Entity
@NamedQuery(name="Tarea.findAll", query="SELECT t FROM Tarea t")
public class Tarea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_tarea")
	private int codigoTarea;

	@Column(name="estado_tarea")
	private String estadoTarea;

	@Column(name="fecha_emitida")
	private String fechaEmitida;

	@Column(name="fecha_vencimiento")
	private String fechaVencimiento;

	@Column(name="nombre_tarea")
	private String nombreTarea;

	@Column(name="nota_tarea")
	private String notaTarea;

	//bi-directional many-to-one association to Alumno
	@ManyToOne
	@JoinColumn(name="codigo_alumno")
	private Alumno alumno;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="codigo_curso")
	private Curso curso;

	public Tarea() {
		this.alumno = new Alumno();
		this.curso = new Curso();
	}

	public int getCodigoTarea() {
		return this.codigoTarea;
	}

	public void setCodigoTarea(int codigoTarea) {
		this.codigoTarea = codigoTarea;
	}

	public String getEstadoTarea() {
		return this.estadoTarea;
	}

	public void setEstadoTarea(String estadoTarea) {
		this.estadoTarea = estadoTarea;
	}

	public String getFechaEmitida() {
		return this.fechaEmitida;
	}

	public void setFechaEmitida(String fechaEmitida) {
		this.fechaEmitida = fechaEmitida;
	}

	public String getFechaVencimiento() {
		return this.fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getNombreTarea() {
		return this.nombreTarea;
	}

	public void setNombreTarea(String nombreTarea) {
		this.nombreTarea = nombreTarea;
	}

	public String getNotaTarea() {
		return this.notaTarea;
	}

	public void setNotaTarea(String notaTarea) {
		this.notaTarea = notaTarea;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}