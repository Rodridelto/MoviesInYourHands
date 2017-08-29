package com.moviesInYourHands.entity;

public class Funcion
{
	private int codigo;
	private int codigoPromocion;
	private int codigoHorario;
	private int codigoTemporada;
	private int codigoCine;
	private int codigoPelicula;
	private String nombreFuncion;
	private String promocion;
	private String horario;
	private String temporada;
	private String cine;
	private String pelicula;
	
	
	public Funcion(int codigo, int codigoPromocion, int codigoHorario, int codigoTemporada, int codigoCine,
			int codigoPelicula, String nombreFuncion) 
	{
		this.codigo = codigo;
		this.codigoPromocion = codigoPromocion;
		this.codigoHorario = codigoHorario;
		this.codigoTemporada = codigoTemporada;
		this.codigoCine = codigoCine;
		this.codigoPelicula = codigoPelicula;
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
	
	public String getNombreFuncion() {
		return nombreFuncion;
	}
	public void setNombreFuncion(String nombreFuncion) {
		this.nombreFuncion = nombreFuncion;
	}
	
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getTemporada() {
		return temporada;
	}
	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}
	public String getCine() {
		return cine;
	}
	public void setCine(String cine) {
		this.cine = cine;
	}
	public String getPelicula() {
		return pelicula;
	}
	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
	}
	public String getPromocion() {
		return promocion;
	}
	public void setPromocion(String promocion) {
		this.promocion = promocion;
	}
	@Override

	public String toString()
	{
		return " Funcion = [codigo= " + codigo +", codigo promocion= "+ codigoPromocion + " promocion:"+promocion+ ", codigo horario= "+codigoHorario+" horario:"+ horario + " codigo temporada= "+ codigoTemporada + " temporada:"+ temporada +  ", codigo cine= "+codigoCine +" cine:"+ cine +  " codigo pelicula= " +codigoPelicula+ " pelicula: "+ pelicula + ", nombre funcion= "+ nombreFuncion +  "]";
	}
	
}
