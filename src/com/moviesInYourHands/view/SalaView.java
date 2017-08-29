package com.moviesInYourHands.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.moviesInYourHands.control.Conexion;
import com.moviesInYourHands.control.SalaCtrl;
import com.moviesInYourHands.entity.Sala;

public class SalaView 
{
	
	private Scanner scanner;
	private Sala sala;
	private SalaCtrl salaCtrl;
	
	public SalaView(Conexion conexion, Scanner scanner) 
	{	
		this.scanner = scanner;
		salaCtrl = new SalaCtrl(conexion);
		
	}
	public void insertar() 
	{
		int codigoCine;
		int numero;
		int cantidadButacas;

		codigoCine = ReadTypes.leerEntero(scanner, "Ingrese el codigo del cine: ");
		numero = ReadTypes.leerEntero(scanner, "Ingrese el numero de sala: ");
		cantidadButacas = ReadTypes.leerEntero(scanner, "Ingrese la cantidad de butacas: ");
		
		sala = new Sala(codigoCine, numero, cantidadButacas);	
		try 
		{
			salaCtrl.Insertar(sala);
		} 
		catch (Throwable e) 
		{
			System.out.println(e.getMessage());
		}
	}
	public void listar() {
		ArrayList<Sala> salas;

		try 
		{
			salas = salaCtrl.list();
			for (int i = 0; i < salas.size(); i++) 
			{
				System.out.println(salas.get(i));
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
