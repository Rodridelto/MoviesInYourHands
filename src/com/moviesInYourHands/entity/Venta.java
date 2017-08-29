package com.moviesInYourHands.entity;

public class Venta 
{
	
	private int codigo;
	private int codigoBancario;
	private int codigoCliente;
	private int NIT;
	public Venta(int codigo, int codigoBancario, int codigocliente, int NIT) {
		
		this.codigo = codigo;
		this.codigoBancario = codigoBancario;
		this.codigoCliente = codigoCliente;
		this.NIT=NIT;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigoBancario() {
		return codigoBancario;
	}
	public void setCodigoBancario(int codigoBancario) {
		this.codigoBancario = codigoBancario;
	}
	public int getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public int getNIT() {
		return NIT;
	}
	public void setNIT(int nIT) {
		this.NIT=NIT;
	}
	
	@Override

	public String toString()
	{
		return " Venta = [codigo= " + codigo +", Codigo bancario= "+ codigoBancario + ", Codigo cliente= "+ codigoCliente + ", NIT= "+ NIT + "]";
	}
	
	

}
