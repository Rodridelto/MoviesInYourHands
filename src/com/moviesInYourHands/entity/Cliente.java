package com.moviesInYourHands.entity;

public class Cliente 
{
	private int codigo;
	private int CI;
	private String nombre;
	public Cliente(int codigo, int cI, String nombre) {

		this.codigo = codigo;
		CI = cI;
		this.nombre = nombre;
	}



	public Cliente( int cI, String nombre) {
		CI = cI;
		this.nombre = nombre;
	}



	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCI() {
		return CI;
	}
	public void setCI(int cI) {
		CI = cI;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override

	public String toString()
	{
		return " Cliente = [codigo= " + codigo + ", CI= "+ CI + ", nombre= "+ nombre + "]";
	}


}
