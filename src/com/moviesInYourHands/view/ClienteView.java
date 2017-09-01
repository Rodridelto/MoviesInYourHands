package com.moviesInYourHands.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.moviesInYourHands.control.ClienteCtrl;
import com.moviesInYourHands.control.Conexion;
import com.moviesInYourHands.entity.Cliente;

public class ClienteView 
{
	
	private Scanner scanner;
	private Cliente cliente;
	private ClienteCtrl clienteCtrl;



	public  ClienteView(Conexion conexion,Scanner scanner)
	{
		this.scanner = scanner;
		clienteCtrl = new  ClienteCtrl(conexion);

	}

	public void insertar() 
	{
		
		int CI;
		String nombre;

		CI = ReadTypes.leerEntero(scanner, "Ingrese el CI: ");
		nombre = ReadTypes.leerCadena(scanner, "Ingrese el nombre: ");
		
		cliente = new Cliente(CI,nombre);

		try {
			clienteCtrl.Insertar(cliente);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}

	public void listar() {
		ArrayList<Cliente> clientes;

		try {
			clientes = clienteCtrl.list();
			for (int i = 0; i < clientes.size(); i++) {
				System.out.println(clientes.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
}
