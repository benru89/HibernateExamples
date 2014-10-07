package com.sopra.formacion.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Cacheable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Programador {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nombre;
	private String apellidos;
	private int nomina;
	private String tecnologia;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@JoinTable(name = "PROGS_DIRECCIONES", joinColumns = @JoinColumn(name = "PROG_ID"))
	private Collection<Direccion> direccion = new ArrayList<Direccion>();
	
	public Programador() {
	}
	
	public Programador(long id, String nombre, String apellidos, int nomina,
			String tecnologia, Direccion direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nomina = nomina;
		this.tecnologia = tecnologia;
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
	
	public Collection<Direccion> getDireccion() {
		return direccion;
	}

	public void setDireccion(Collection<Direccion> direccion) {
		this.direccion = direccion;
	}

	
}