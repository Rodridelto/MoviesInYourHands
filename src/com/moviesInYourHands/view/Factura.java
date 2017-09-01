package com.moviesInYourHands.view;

public class Factura {
	private String nombreCine;
	private String direccion;
	private int codigoDetalleVenta;
	private String nombreCliente;
	private int nit;
	private int cantidad;
	private double precioUnidad;
	private double precioTotal;
	public String getNombreCine() {
		return nombreCine;
	}
	public void setNombreCine(String nombreCine) {
		this.nombreCine = nombreCine;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getCodigoDetalleVenta() {
		return codigoDetalleVenta;
	}
	public void setCodigoDetalleVenta(int codigoDetalleVenta) {
		this.codigoDetalleVenta = codigoDetalleVenta;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public int getNit() {
		return nit;
	}
	public void setNit(int nit) {
		this.nit = nit;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecioUnidad() {
		return precioUnidad;
	}
	public void setPrecioUnidad(double precioUnidad) {
		this.precioUnidad = precioUnidad;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
}
