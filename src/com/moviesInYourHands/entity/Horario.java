package com.moviesInYourHands.entity;

import java.sql.Time;

public class Horario 
{
	private int codigo;
	private Time horarioInicio;
	private Time horarioFin;
	public Horario(int codigo, Time horarioInicio, Time horarioFin) {
		
		this.codigo = codigo;
		this.horarioInicio = horarioInicio;
		this.horarioFin = horarioFin;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Time getHorarioInicio() {
		return horarioInicio;
	}
	public void setHorarioInicio(Time horarioInicio) {
		this.horarioInicio = horarioInicio;
	}
	public Time getHorarioFin() {
		return horarioFin;
	}
	public void setHorarioFin(Time horarioFin) {
		this.horarioFin = horarioFin;
	}
	
	@Override

	public String toString()
	{
		return " Horario = [codigo= " + codigo +", Hora de inicio= "+ horarioInicio + ", Hora final= "+ horarioFin + "]";
	}

}
