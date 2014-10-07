package com.sopra.formacion.dao;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Programador {

	@Id
	@GeneratedValue
	private long id;
	private String nombre;
	private String apellidos;
	private int nomina;
	private String tecnologia;
	
	@Embedded
	private Direccion direccion;
	
	@Embedded
	@AttributeOverrides({@AttributeOverride(name = "calle", column = @Column(name = "DIR_CALL_WORK")),
	@AttributeOverride(name = "ciudad", column = @Column(name = "DIR_CIUDAD_WORK")),
	@AttributeOverride(name = "codigoPostal", column = @Column(name = "DIR_CP_WORK"))})
	private Direccion workDireccion;
	
	public Programador(long id, String nombre, String apellidos, int nomina,
			String tecnologia, Direccion direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nomina = nomina;
		this.tecnologia = tecnologia;
		this.direccion = direccion;
	}

	public Programador() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getNomina() {
		return nomina;
	}

	public void setNomina(int nomina) {
		this.nomina = nomina;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Direccion getWorkDireccion() {
		return workDireccion;
	}

	public void setWorkDireccion(Direccion workDireccion) {
		this.workDireccion = workDireccion;
	}

}