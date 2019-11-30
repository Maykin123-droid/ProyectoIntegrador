package pe.edu.cibertec.webapp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the alumno database table.
 * 
 */
@Entity
@NamedQuery(name="Alumno.findAll", query="SELECT a FROM Alumno a")
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_alumno")
	private int codigoAlumno;

	private int celular;

	private String ciclo;

	private String direccion;

	private String dni;

	@Column(name="nombre_alumno")
	private String nombreAlumno;

	//bi-directional many-to-one association to Curso
	@OneToMany(mappedBy="alumno")
	private List<Curso> cursos;

	//bi-directional many-to-one association to Nota
	@OneToMany(mappedBy="alumno")
	private List<Nota> notas;

	//bi-directional many-to-one association to Tarea
	@OneToMany(mappedBy="alumno")
	private List<Tarea> tareas;

	public Alumno() {
	}

	public int getCodigoAlumno() {
		return this.codigoAlumno;
	}

	public void setCodigoAlumno(int codigoAlumno) {
		this.codigoAlumno = codigoAlumno;
	}

	public int getCelular() {
		return this.celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public String getCiclo() {
		return this.ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombreAlumno() {
		return this.nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Curso addCurso(Curso curso) {
		getCursos().add(curso);
		curso.setAlumno(this);

		return curso;
	}

	public Curso removeCurso(Curso curso) {
		getCursos().remove(curso);
		curso.setAlumno(null);

		return curso;
	}

	public List<Nota> getNotas() {
		return this.notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public Nota addNota(Nota nota) {
		getNotas().add(nota);
		nota.setAlumno(this);

		return nota;
	}

	public Nota removeNota(Nota nota) {
		getNotas().remove(nota);
		nota.setAlumno(null);

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
		tarea.setAlumno(this);

		return tarea;
	}

	public Tarea removeTarea(Tarea tarea) {
		getTareas().remove(tarea);
		tarea.setAlumno(null);

		return tarea;
	}*/

	@Override
	public String toString() {
		return "Alumno [codigoAlumno=" + codigoAlumno + ", celular=" + celular + ", ciclo=" + ciclo + ", direccion="
				+ direccion + ", dni=" + dni + ", nombreAlumno=" + nombreAlumno + ", cursos=" + cursos + ", notas="
				+ notas + ", tareas=" + tareas + "]";
	}
	
	

}