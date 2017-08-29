package com.moviesInYourHands.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.moviesInYourHands.control.Conexion;
import com.moviesInYourHands.control.TemporadaCtrl;
import com.moviesInYourHands.entity.Temporada;

public class TemporadaView 
{
	
	private Scanner scanner;
	private Temporada temporada;
	private TemporadaCtrl temporadaCtrl;
	
	public TemporadaView(Conexion conexion, Scanner scanner) 
	{	
		this.scanner = scanner;
		temporadaCtrl = new TemporadaCtrl(conexion);
		
	}
	public void insertar() 
	{
		Date fechaInicio;
		Date fechaFin;

		fechaInicio = ReadTypes.leerFecha(scanner, "Ingrese la fecha de inicio: ");
		fechaFin = ReadTypes.leerFecha(scanner, "Ingrese la fecha final: ");
		
		temporada = new Temporada(fechaInicio, fechaFin);	
		try 
		{
			temporadaCtrl.Insertar(temporada);
		} 
		catch (Throwable e) 
		{
			System.out.println(e.getMessage());
		}
	}
	public void listar() {
		ArrayList<Temporada> temporadas;

		try 
		{
			temporadas = temporadaCtrl.list();
			for (int i = 0; i < temporadas.size(); i++) 
			{
				System.out.println(temporadas.get(i));
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
