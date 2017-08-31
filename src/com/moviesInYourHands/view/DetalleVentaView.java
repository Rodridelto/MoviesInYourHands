package com.moviesInYourHands.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.moviesInYourHands.control.Conexion;
import com.moviesInYourHands.control.DetalleVentaCtrl;
import com.moviesInYourHands.entity.DetalleVenta;


public class DetalleVentaView
{
	
	private Scanner scanner;
	private DetalleVenta detalleVenta;
	private DetalleVentaCtrl detalleVentaCtrl;



	public  DetalleVentaView(Conexion conexion,Scanner scanner)
	{
		this.scanner = scanner;
		detalleVentaCtrl = new  DetalleVentaCtrl(conexion);

	}

	public void insertar(int cantidad,int codigoFuncion,double total) 
	{
		/*int cantidad;
		int codigoFuncion;

		cantidad = ReadTypes.leerEntero(scanner, "Ingrese la cantidad de entradas: ");
		codigoFuncion = ReadTypes.leerEntero(scanner, "Ingrese el codigo de la funcion: ");
*/
		detalleVenta = new DetalleVenta(cantidad,codigoFuncion,total);

		try {
			detalleVentaCtrl.Insertar(detalleVenta);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}

	public void listar() {
		ArrayList<DetalleVenta> detalleVentas;

		try {
			detalleVentas = detalleVentaCtrl.list();
			for (int i = 0; i < detalleVentas.size(); i++) {
				System.out.println(detalleVentas.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	public void mostrarFactura(int codigoFuncion)
	{
		detalleVentaCtrl.mostrarFactura(codigoFuncion);
	}
	/*public void buscar(String titulo) {
		pelicula=new Pelicula(titulo);
		try {
			peliculaCtrl.search(pelicula);
			System.out.println(pelicula);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	public void actualizar() {
		int codigo;

		codigo = ReadTypes.leerEntero(scanner, "Ingrese los minutos de duracion a modificar: ");
		pelicula=new Pelicula(codigo);
		
		try {
			peliculaCtrl.search(pelicula);
		} 
		catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		//MenusPelicula.menuModificar(scanner, pelicula);

		try {
			peliculaCtrl.update(pelicula);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}*/

}
