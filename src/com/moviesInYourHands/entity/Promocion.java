package com.moviesInYourHands.entity;

public class Promocion 
{
	
	private int codigo;
	private double descuento;
	private String descripcion;
	public Promocion(int codigo, double descuento, String descripcion) {
		
		this.codigo = codigo;
		this.descuento = descuento;
		this.descripcion = descripcion;
	}
	
	public Promocion(double descuento, String descripcion) {
		this.descuento = descuento;
		this.descripcion = descripcion;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	} 
	
	@Override

	public String toString()
	{
		return " Promocion = [codigo= " + codigo +", Descuento= "+ descuento + ", Descripcion= "+ descripcion + "]";
	}

}
