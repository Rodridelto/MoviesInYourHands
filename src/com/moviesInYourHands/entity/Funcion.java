package com.moviesInYourHands.entity;

public class Funcion
{
	private int codigo;
	private int codigoPromocion;
	private int codigoHorario;
	private int codigoTemporada;
	private int codigoCine;
	private int codigoPelicula;
	private int codigoDetalleVenta;
	private String nombreFuncion;
	
	
	public Funcion(int codigo, int codigoPromocion, int codigoHorario, int codigoTemporada, int codigoCine,
			int codigoPelicula, int codigoDetalleVenta, String nombreFuncion) 
	{
		this.codigo = codigo;
		this.codigoPromocion = codigoPromocion;
		this.codigoHorario = codigoHorario;
		this.codigoTemporada = codigoTemporada;
		this.codigoCine = codigoCine;
		this.codigoPelicula = codigoPelicula;
		this.codigoDetalleVenta = codigoDetalleVenta;
		this.nombreFuncion = nombreFuncion;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigoPromocion() {
		return codigoPromocion;
	}
	public void setCodigoPromocion(int codigoPromocion) {
		this.codigoPromocion = codigoPromocion;
	}
	public int getCodigoHorario() {
		return codigoHorario;
	}
	public void setCodigoHorario(int codigoHorario) {
		this.codigoHorario = codigoHorario;
	}
	public int getCodigoTemporada() {
		return codigoTemporada;
	}
	public void setCodigoTemporada(int codigoTemporada) {
		this.codigoTemporada = codigoTemporada;
	}
	public int getCodigoCine() {
		return codigoCine;
	}
	public void setCodigoCine(int codigoCine) {
		this.codigoCine = codigoCine;
	}
	public int getCodigoPelicula() {
		return codigoPelicula;
	}
	public void setCodigoPelicula(int codigoPelicula) {
		this.codigoPelicula = codigoPelicula;
	}
	public int getCodigoDetalleVenta() {
		return codigoDetalleVenta;
	}
	public void setCodigoDetalleVenta(int codigoDetalleVenta) {
		this.codigoDetalleVenta = codigoDetalleVenta;
	}
	public String getNombreFuncion() {
		return nombreFuncion;
	}
	public void setNombreFuncion(String nombreFuncion) {
		this.nombreFuncion = nombreFuncion;
	}
	
	@Override

	public String toString()
	{
		return " Funcion = [codigo= " + codigo +", codigo promocion= "+ codigoPromocion + ", codigo horario= "+ codigoHorario + ", codigo temporada= "+ codigoTemporada +  ", codigo cine= "+ codigoCine +  ", codigo pelicula= "+ codigoPelicula +  ", codigo de detalle venta= "+ codigoDetalleVenta + ", nombre funcion= "+ nombreFuncion +  "]";
	}
	
}
