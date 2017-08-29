package com.moviesInYourHands.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.moviesInYourHands.control.Conexion;
import com.moviesInYourHands.control.VentaCtrl;
import com.moviesInYourHands.entity.Venta;

public class VentaView
{

	private Scanner scanner;
	private Venta venta;
	private VentaCtrl ventaCtrl;



	public  VentaView(Conexion conexion,Scanner scanner)
	{
		this.scanner = scanner;
		ventaCtrl = new  VentaCtrl(conexion);

	}

	public void insertar() 
	{
		
		int codigoBancario;
		int codigoCliente;
		int NIT;
		int codigoDetalleVenta;

		codigoBancario = ReadTypes.leerEntero(scanner, "Ingrese el Codigo bancario: ");
		codigoCliente = ReadTypes.leerEntero(scanner, "Ingrese el codigo cliente: ");
		NIT = ReadTypes.leerEntero(scanner, "Ingrese el NIT: ");
		codigoDetalleVenta = ReadTypes.leerEntero(scanner, "Ingrese el codigo DetalleVenta: ");
		
		venta = new Venta(codigoBancario,codigoCliente,NIT,codigoDetalleVenta);

		try {
			ventaCtrl.Insertar(venta);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}

	public void listar() {
			ArrayList<Venta> ventas;

		try {
			ventas = ventaCtrl.list();
			for (int i = 0; i < ventas.size(); i++) {
				System.out.println(ventas.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

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
