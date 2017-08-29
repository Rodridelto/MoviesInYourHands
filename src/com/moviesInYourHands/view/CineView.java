package com.moviesInYourHands.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.moviesInYourHands.control.CineCtrl;
import com.moviesInYourHands.control.Conexion;
import com.moviesInYourHands.entity.Cine;

public class CineView 
{
	
	
	private Scanner scanner;
	private Cine cine;
	private CineCtrl cineCtrl;
	
	public CineView(Conexion conexion, Scanner scanner) 
	{	
		this.scanner = scanner;
		cineCtrl = new CineCtrl(conexion);
		
	}
	public void insertar() 
	{
		String nombre;
		String direccion;
		int telefono;

		nombre = ReadTypes.leerCadena(scanner, "Ingrese el nombre del cine: ");
		direccion = ReadTypes.leerCadena(scanner, "Ingrese la direccion: ");
		telefono = ReadTypes.leerEntero(scanner, "Ingrese el telefono: ");
		
		cine = new Cine(nombre, direccion, telefono);	
		try 
		{
			cineCtrl.Insertar(cine);
		} 
		catch (Throwable e) 
		{
			System.out.println(e.getMessage());
		}
	}
	public void listar() {
		ArrayList<Cine> cines;

		try 
		{
			cines = cineCtrl.list();
			for (int i = 0; i < cines.size(); i++) 
			{
				System.out.println(cines.get(i));
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
