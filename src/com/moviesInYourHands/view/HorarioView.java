package com.moviesInYourHands.view;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;

import com.moviesInYourHands.control.Conexion;
import com.moviesInYourHands.control.HorarioCtrl;
import com.moviesInYourHands.entity.Horario;

public class HorarioView 
{
	
	private Scanner scanner;
	private Horario horario;
	private HorarioCtrl horarioCtrl;
	
	public HorarioView(Conexion conexion, Scanner scanner) 
	{	
		this.scanner = scanner;
		horarioCtrl = new HorarioCtrl(conexion);
		
	}
	/*public void insertar() 
	{
		Time horaInicio;
		Time horaFin;

		horaInicio = ReadTypes.leerHora(scanner, "Ingrese la hora de inicio: ");
		horaFin = ReadTypes.leerHora(scanner, "Ingrese la hora final: ");
		
		horario = new Horario(horaInicio, horaFin);	
		try 
		{
			horarioCtrl.Insertar(horario);
		} 
		catch (Throwable e) 
		{
			System.out.println(e.getMessage());
		}
	}*/
	public void listar() {
		ArrayList<Horario> horarios;

		try 
		{
			horarios = horarioCtrl.list();
			for (int i = 0; i < horarios.size(); i++) 
			{
				System.out.println(horarios.get(i));
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
