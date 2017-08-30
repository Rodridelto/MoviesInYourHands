package com.moviesInYourHands.entity;

public class DetalleVenta 
{
	
	private int codigo;
	private int cantidad;
	private int codigoFuncion;
	private int codigoVenta;
	private double total;
	
	
	
	public DetalleVenta(int codigo, int cantidad, int codigoFuncion,int codigoVenta,double total) {
		
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.codigoFuncion = codigoFuncion;
		this.codigoVenta = codigoVenta;
		this.total=total;
	}
	

    public int getCodigoVenta() {
		return codigoVenta;
	}


	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}


	public DetalleVenta( int cantidad, int codigoFuncion,double total) {
		this.cantidad = cantidad;
		this.codigoFuncion = codigoFuncion;
		this.total=total;
	}
	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
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
		return " DetalleVenta = [codigo= " + codigo +", Cantidad= "+ cantidad + ", codigo de funcion= "+ codigoFuncion + " Total= " + total + "]";
	}
	
	

}
