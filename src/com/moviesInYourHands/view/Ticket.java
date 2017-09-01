package com.moviesInYourHands.view;

import java.sql.Time;

public class Ticket 
{
	
    private String titulo;
    private boolean subtitulos;
    private String genero;
    private int numeroSala;
    private Time horaInicio;
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public boolean getSubtitulos() {
		return subtitulos;
	}
	public void setSubtitulos(boolean subtitulos) {
		this.subtitulos = subtitulos;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getNumeroSala() {
		return numeroSala;
	}
	public void setNumeroSala(int numeroSala) {
		this.numeroSala = numeroSala;
	}
	public Time getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}
    
    

}
