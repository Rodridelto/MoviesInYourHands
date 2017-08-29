package com.moviesInYourHands.entity;

import java.util.Date;

public class Temporada 
{
	
	private int codigo;
	private Date fechaInicio;
	private Date fechaFin;
	public Temporada(int codigo, Date fechaInicio, Date fechaFin) {
	
		this.codigo = codigo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
	
	public Temporada(Date fechaInicio, Date fechaFin) {
		
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}


	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	@Override

	public String toString()
	{
		return " Temporada = [codigo= " + codigo +", Fecha de inicio= "+ fechaInicio + ", Fecha final= "+ fechaFin+ "]";
	}
	
	 

}
