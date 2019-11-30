package pe.edu.cibertec.webapp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cursos database table.
 * 
 */
@Entity
@Table(name="cursos")
@NamedQuery(name="Curso.findAll", query="SELECT c FROM Curso c")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_curso")
	private int codigoCurso;

	private String asistencia;

	private String horario;

	@Column(name="nombre_curso")
	private String nombreCurso;

	private String profesor;

	private String salon;

	private String tema;

	//bi-directional many-to-one association to Alumno
	@ManyToOne
	@JoinColumn(name="codigo_alumno")
	private Alumno alumno;

	//bi-directional many-to-one association to Nota
	@OneToMany(mappedBy="curso")
	private List<Nota> notas;

	//bi-directional many-to-one association to Tarea
	@OneToMany(mappedBy="curso")
	private List<Tarea> tareas;

	public Curso() {
		this.alumno = new Alumno();
	}

	public int getCodigoCurso() {
		return this.codigoCurso;
	}

	public void setCodigoCurso(int codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public String getAsistencia() {
		return this.asistencia;
	}

	public void setAsistencia(String asistencia) {
		this.asistencia = asistencia;
	}

	public String getHorario() {
		return this.horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getNombreCurso() {
		return this.nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public String getProfesor() {
		return this.profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public String getSalon() {
		return this.salon;
	}

	public void setSalon(String salon) {
		this.salon = salon;
	}

	public String getTema() {
		return this.tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public List<Nota> getNotas() {
		return this.notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public Nota addNota(Nota nota) {
		getNotas().add(nota);
		nota.setCurso(this);

		return nota;
	}

	public Nota removeNota(Nota nota) {
		getNotas().remove(nota);
		nota.setCurso(null);

		return nota;
	}

	public List<Tarea> getTareas() {
		return this.tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

/*	public Tarea addTarea(Tarea tarea) {
		getTareas().add(tarea);
		tarea.setCurso(this);

		return tarea;
	}

	public Tarea removeTarea(Tarea tarea) {
		getTareas().remove(tarea);
		tarea.setCurso(null);

		return tarea;
	}*/

	@Override
	public String toString() {
		return "Curso [codigoCurso=" + codigoCurso + ", asistencia=" + asistencia + ", horario=" + horario
				+ ", nombreCurso=" + nombreCurso + ", profesor=" + profesor + ", salon=" + salon + ", tema=" + tema
				+ ", alumno=" + alumno + ", notas=" + notas + ", tareas=" + tareas + "]";
	}
	
	

}