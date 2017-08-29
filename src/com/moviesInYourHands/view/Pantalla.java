package com.moviesInYourHands.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.moviesInYourHands.control.Conexion;
import com.moviesInYourHands.view.PeliculaView;

public class Pantalla {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		Conexion conexion = new Conexion();	
		PeliculaView peliculaView = new PeliculaView(conexion,scanner);
		//peliculaView.insertar();
		peliculaView.listar();
		FuncionView funcionView = new FuncionView(conexion,scanner);
		//funcionView.listar();
		
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
