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
}
