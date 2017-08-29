package com.moviesInYourHands.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.moviesInYourHands.control.Conexion;
import com.moviesInYourHands.control.PeliculaCtrl;
import com.moviesInYourHands.entity.Pelicula;





public class PeliculaView 
{

	private Scanner scanner;
	private Pelicula pelicula;
	private PeliculaCtrl peliculaCtrl;



	public  PeliculaView(Conexion conexion,Scanner scanner)
	{
		this.scanner = scanner;
		peliculaCtrl = new  PeliculaCtrl(conexion);

	}

	public void insertar() 
	{
		String titulo;
		String idioma;
		boolean subtitulos;
		int duracion;
		String resumen;
		String genero;

		titulo = ReadTypes.leerCadena(scanner, "Ingrese el Titulo: ");
		idioma = ReadTypes.leerCadena(scanner, "Ingrese el idioma: ");
		subtitulos = ReadTypes.leerBoolean(scanner, "Ingrese el subtitulos: ");
		duracion = ReadTypes.leerEntero(scanner, "Ingrese el duracion: ");
		resumen = ReadTypes.leerCadena(scanner, "Ingrese el resumen: ");
		genero = ReadTypes.leerCadena(scanner, "Ingrese el genero: ");


		pelicula = new Pelicula(titulo,idioma,subtitulos,duracion,resumen,genero);

		try {
			peliculaCtrl.Insertar(pelicula);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}

	public void listar() {
		ArrayList<Pelicula> peliculas;

		try {
			peliculas = peliculaCtrl.list();
			for (int i = 0; i < peliculas.size(); i++) {
				System.out.println(peliculas.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	public void buscar(String titulo) {
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
	}
}
