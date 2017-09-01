package com.moviesInYourHands.view;

import java.sql.Time;
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
	public double getPrecio(int codigofuncion) {
		try {
			return funcionCtrl.getPrecio(codigofuncion);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void mostrarTicket(int codigoFuncion)
	{
	 Ticket ticket = funcionCtrl.listarTicket(codigoFuncion);
	
	
	System.out.println("********** TICKET DE INGRESO **********");
	System.out.println("*Titulo => "+ ticket.getTitulo() +"  ");
	if(ticket.getSubtitulos())
		System.out.println("*Subtitulada"+ "                          ");
	else
		System.out.println("*Doblada" + "                    ");
	System.out.println("*Genero => "+ ticket.getGenero() + "         ");
	System.out.println("*Numero de sala => "+ ticket.getNumeroSala() + "                  ");
	System.out.println("*Hora inicio => "+ ticket.getHoraInicio() + "              ");
	System.out.println("***************************************");


         	
	}

}
