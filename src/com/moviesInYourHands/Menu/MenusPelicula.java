package com.moviesInYourHands.Menu;

import java.util.Scanner;

import com.moviesInYourHands.entity.Pelicula;
import com.moviesInYourHands.view.ReadTypes;


public class MenusPelicula 
{
	
	public static int opcionesModificar(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Actualizar Duracion");
				System.out.println("0. Salir");
				System.out.println();

				opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion >= 0 && opcion <= 4) {
					return opcion;
				}

			} catch (java.util.InputMismatchException e) {
				System.out.println("Ingrese solo valores numéricos");
				System.out.println();
				scanner.nextLine();
			}
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public static void menuModificar(Scanner scanner, Pelicula pelicula) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Duracion anterior: ");
				System.out.println(pelicula.getDuracion());
				int duracion = ReadTypes.leerEntero(scanner, "Ingrese el nuevo valor de Duracion: ");
				pelicula.setDuracion(duracion);
				break;
			}
		}
	}

}
