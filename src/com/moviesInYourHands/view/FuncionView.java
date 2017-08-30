package com.moviesInYourHands.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.moviesInYourHands.control.Conexion;
import com.moviesInYourHands.control.FuncionCtrl;
import com.moviesInYourHands.entity.Funcion;

public class FuncionView 
{
	
	private Scanner scanner;
	private Funcion funcion;
	private FuncionCtrl funcionCtrl;
	
	public FuncionView(Conexion conexion, Scanner scanner) 
	{	
		this.scanner = scanner;
		funcionCtrl = new FuncionCtrl(conexion);
		
	}
	
	/*public void insertar() 
	{
		int codigoPromocion;
		int codigoHorario;
		int codigoTemporada;
		int codigoCine;
		int codigoPelicula;
		String nombreFuncion;

		codigoPromocion = ReadTypes.leerEntero(scanner, "Ingrese el codigo de promocion: ");
		codigoHorario = ReadTypes.leerEntero(scanner, "Ingrese el codigo de horario: ");
		codigoTemporada = ReadTypes.leerEntero(scanner, "Ingrese el codigo de temporada: ");
		codigoCine = ReadTypes.leerEntero(scanner, "Ingrese el codigo de cine: ");
		codigoPelicula = ReadTypes.leerEntero(scanner, "Ingrese el codigo de pelicula: ");
		nombreFuncion = ReadTypes.leerCadena(scanner, "Ingrese el nombre de la funcion: ");
		
		funcion = new Funcion(codigoPromocion, codigoHorario, codigoTemporada, codigoCine, codigoPelicula, nombreFuncion);	
		try 
		{
			funcionCtrl.insert(funcion);
		} 
		catch (Throwable e) 
		{
			System.out.println(e.getMessage());
		}
	}*/
	public void listar() {
		ArrayList<Funcion> funciones;

		try 
		{
			funciones = funcionCtrl.list();
			for (int i = 0; i < funciones.size(); i++) 
			{
				System.out.println(funciones.get(i));
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
	public double getPrecio(int codigofuncion) {
		try {
			return funcionCtrl.getPrecio(codigofuncion);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
