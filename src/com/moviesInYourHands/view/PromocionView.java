package com.moviesInYourHands.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.moviesInYourHands.control.Conexion;
import com.moviesInYourHands.control.PromocionCtrl;
import com.moviesInYourHands.entity.Promocion;

public class PromocionView 
{
	
	private Scanner scanner;
	private Promocion promocion;
	private PromocionCtrl promocionCtrl;
	
	public PromocionView(Conexion conexion, Scanner scanner) 
	{	
		this.scanner = scanner;
		promocionCtrl = new PromocionCtrl(conexion);
		
	}
	public void insertar() 
	{
		double descuento;
		String descripcion;

		descuento = ReadTypes.leerReal(scanner, "Ingrese el descuento: ");
		descripcion = ReadTypes.leerCadena(scanner, "Ingrese la descripcion: ");
		
		promocion = new Promocion(descuento, descripcion);	
		try 
		{
			promocionCtrl.Insertar(promocion);
		} 
		catch (Throwable e) 
		{
			System.out.println(e.getMessage());
		}
	}
	public void listar() {
		ArrayList<Promocion> promociones;

		try 
		{
			promociones = promocionCtrl.list();
			for (int i = 0; i < promociones.size(); i++) 
			{
				System.out.println(promociones.get(i));
			}
		} 
		catch (Throwable e) 
		{
			System.out.println(e.getMessage());
		}
	}
	/*public void buscar(String nombreFuncion) 
	{
		funcion= new Funcion(nombreFuncion);
		try 
		{
			funcionCtrl.search(funcion);
			System.out.println(funcion);
		} 
		catch (Throwable e) 
		{
			System.out.println(e.getMessage());
		}
	}
	public void actualizar() 
	{
		int codigo;
		
		codigo = ReadTypes.leerEntero(scanner, "Ingrese los minutos de duracion a modificar: ");
		pelicula=new Pelicula(codigo);
		try {
			peliculaCtrl.search(pelicula);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenusPelicula.menuModificar(scanner, pelicula);

		try {
			peliculaCtrl.update(pelicula);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}*/

}
