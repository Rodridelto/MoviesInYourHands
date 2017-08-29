package com.moviesInYourHands.entity;

public class Sala 
{
	private int codigo;
	private int codigoCine;
	private int numeroSala;
	private int cantidadButacas;
	public Sala(int codigo, int codigoCine, int numeroSala, int cantidadButacas) {
		
		this.codigo = codigo;
		this.codigoCine = codigoCine;
		this.numeroSala = numeroSala;
		this.cantidadButacas = cantidadButacas;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigoCine() {
		return codigoCine;
	}
	public void setCodigoCine(int codigoCine) {
		this.codigoCine = codigoCine;
	}
	public int getNumeroSala() {
		return numeroSala;
	}
	public void setNumeroSala(int numeroSala) {
		this.numeroSala = numeroSala;
	}
	public int getCantidadButacas() {
		return cantidadButacas;
	}
	public void setCantidadButacas(int cantidadButacas) {
		this.cantidadButacas = cantidadButacas;
	}
	
	@Override

	public String toString()
	{
		return " Sala = [codigo= " + codigo +", codigo de cine= "+ codigoCine + ", Numero de sala= "+ numeroSala + ", Cantidad de butacas= "+ cantidadButacas + "]";
	}

}
