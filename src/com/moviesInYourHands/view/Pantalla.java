package com.moviesInYourHands.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.moviesInYourHands.Menu.MenusFuncion;
import com.moviesInYourHands.control.Conexion;
import com.moviesInYourHands.view.PeliculaView;

public class Pantalla {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		Conexion conexion = new Conexion();	
		int codigofuncion = MenusFuncion.menu(scanner);
		int cantidadEntradas= MenusFuncion.menuEntradas(scanner);
		//System.out.println("el codigo ingresado es: " +codigofuncion);
		//System.out.println("la cantidad ingresada es: " +cantidadEntradas);
		ClienteView clienteView = new ClienteView(conexion, scanner);
		clienteView.insertar();
		
		VentaView ventaView = new VentaView(conexion,scanner);
		ventaView.insertar();
		
		DetalleVentaView detalleVentaView= new DetalleVentaView(conexion,scanner);
		FuncionView  funcionView = new FuncionView(conexion, scanner);
		
		double total = cantidadEntradas *  funcionView.getPrecio(codigofuncion);
		
		
		detalleVentaView.insertar(cantidadEntradas, codigofuncion, total);
		funcionView.mostrarTicket(codigofuncion);
		detalleVentaView.mostrarFactura(codigofuncion);
		
		
		//PeliculaView peliculaView = new PeliculaView(conexion,scanner);
		//peliculaView.insertar();
		//peliculaView.listar();
		//FuncionView funcionView = new FuncionView(conexion,scanner);
		//funcionView.listar();
		//1ventaView.insertar();
		
		try 
		{
			conexion.close();
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getSQLState());
		}
		
		scanner.close();
	}

}
