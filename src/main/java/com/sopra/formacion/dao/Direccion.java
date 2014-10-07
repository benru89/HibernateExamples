package com.sopra.formacion.dao;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Direccion {
	@Column(name = "DIR_CALLE")
	private String calle;
	@Column(name = "DIR_CIUDAD")
	private String ciudad;
	@Column(name = "DIR_CP")
	private int codigoPostal;
	
	public Direccion(){
		
	}
	public Direccion(String calle, String ciudad, int codigoPostal) {
		super();
		this.calle = calle;
		this.ciudad = ciudad;
		this.codigoPostal = codigoPostal;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public int getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
}
