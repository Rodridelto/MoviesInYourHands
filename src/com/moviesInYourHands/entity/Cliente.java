package com.moviesInYourHands.entity;

public class Cliente 
{
	private int codigo;
	private int NIT;
	private int CI;
	private String nombre;
	public Cliente(int codigo, int nIT, int cI, String nombre) {
		
		this.codigo = codigo;
		NIT = nIT;
		CI = cI;
		this.nombre = nombre;
	}
	
	
	
	public Cliente(int nIT, int cI, String nombre) {
		NIT = nIT;
		CI = cI;
		this.nombre = nombre;
	}



	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getNIT() {
		return NIT;
	}
	public void setNIT(int nIT) {
		NIT = nIT;
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
		return " Cliente = [codigo= " + codigo +", NIT= "+ NIT + ", CI= "+ CI + ", nombre= "+ nombre + "]";
	}


}
