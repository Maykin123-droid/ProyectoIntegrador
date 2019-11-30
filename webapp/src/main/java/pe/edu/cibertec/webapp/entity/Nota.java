package pe.edu.cibertec.webapp.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the nota database table.
 * 
 */
@Entity
@NamedQuery(name="Nota.findAll", query="SELECT n FROM Nota n")
public class Nota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_nota")
	private int codigoNota;

	@Column(name="examen_parcial")
	private int examenParcial;

	private int examen1;

	private int examen2;

	@Column(name="nota_actitudinal")
	private int notaActitudinal;

	@Column(name="nota_virtual")
	private int notaVirtual;

	private double promedio;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="codigo_curso")
	private Curso curso;

	//bi-directional many-to-one association to Alumno
	@ManyToOne
	@JoinColumn(name="codigo_alumno")
	private Alumno alumno;

	public Nota() {
		
		this.alumno = new Alumno();
		this.curso = new Curso();
	}

	public int getCodigoNota() {
		return this.codigoNota;
	}

	public void setCodigoNota(int codigoNota) {
		this.codigoNota = codigoNota;
	}

	public int getExamenParcial() {
		return this.examenParcial;
	}

	public void setExamenParcial(int examenParcial) {
		this.examenParcial = examenParcial;
	}

	public int getExamen1() {
		return this.examen1;
	}

	public void setExamen1(int examen1) {
		this.examen1 = examen1;
	}

	public int getExamen2() {
		return this.examen2;
	}

	public void setExamen2(int examen2) {
		this.examen2 = examen2;
	}

	public int getNotaActitudinal() {
		return this.notaActitudinal;
	}

	public void setNotaActitudinal(int notaActitudinal) {
		this.notaActitudinal = notaActitudinal;
	}

	public int getNotaVirtual() {
		return this.notaVirtual;
	}

	public void setNotaVirtual(int notaVirtual) {
		this.notaVirtual = notaVirtual;
	}

	public double getPromedio() {
		return this.promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
   /* public double calculo() {
		
		
		double resultado = 0.0;
		
		promedio = (examenParcial + examen1 + examen2 + notaActitudinal + notaVirtual) / 5;
		
		return resultado;
		
		
	}*/
	

}