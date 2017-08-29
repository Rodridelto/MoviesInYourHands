package com.moviesInYourHands.entity;

public class DetalleVenta 
{
	
	private int codigo;
	private int cantidad;
	private int codigoFuncion;
	
	
	public DetalleVenta(int codigo, int cantidad, int codigoFuncion) {
		
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.codigoFuncion = codigoFuncion;
	}


	public DetalleVenta(int cantidad, int codigoFuncion) {
		this.cantidad = cantidad;
		this.codigoFuncion = codigoFuncion;
	}
	
	


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public int getCodigoFuncion() {
		return codigoFuncion;
	}


	public void setCodigoFuncion(int codigoFuncion) {
		this.codigoFuncion = codigoFuncion;
	}
	
	@Override

	public String toString()
	{
		return " DetalleVenta = [codigo= " + codigo +", Cantidad= "+ cantidad + ", codigo de funcion= "+ codigoFuncion + "]";
	}
	
	

}
