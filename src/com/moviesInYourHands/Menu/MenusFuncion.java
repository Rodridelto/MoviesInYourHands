package com.moviesInYourHands.Menu;

import java.util.Scanner;

import com.moviesInYourHands.control.Conexion;
import com.moviesInYourHands.view.FuncionView;

public class MenusFuncion 
{
	
	public static int menu(Scanner scanner) {

		int opcion;
		Conexion conexion = new Conexion();
		while (true) {
			try {
				System.out.println("☻*☻*☻*☻*☻*☻*☻*☻*☻*☻* RB CINEMAS *☻*☻*☻*☻*☻*☻*☻*☻*☻*☻");
				System.out.println("---------------------------------------------------------------------------------------------- ");
				FuncionView funcionView= new FuncionView(conexion,scanner);
				funcionView.listar();
				System.out.println("-----------------------------------------------------------------------------------------------");
				System.out.println("* Ingrese el codigo de la funcion a la que desea ingresar" + "      *");
				//System.out.println("*  0. Salir                                                    *");
				System.out.println("****************************************************************");

				opcion = scanner.nextInt();
				scanner.nextLine();
				
				//System.out.println("=====>");

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
	public static int menuEntradas(Scanner scanner)
	{
		int cantidadDeEntradas;
		try{
			
			System.out.println("Ingrese la cantidad de entradas que desea adquirir");
			cantidadDeEntradas = scanner.nextInt();
			scanner.nextLine();
			return cantidadDeEntradas;
		}
	    catch (java.util.InputMismatchException e) {
	    	System.out.println("Ingrese solo valores numéricos");
	    	System.out.println();
	    	scanner.nextLine();
	    }
		return 0;
		
	}
	
	

}
