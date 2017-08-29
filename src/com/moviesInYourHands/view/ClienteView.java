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
		int NIT;
		int CI;
		String nombre;

		NIT = ReadTypes.leerEntero(scanner, "Ingrese el NIT: ");
		CI = ReadTypes.leerEntero(scanner, "Ingrese el CI: ");
		nombre = ReadTypes.leerCadena(scanner, "Ingrese el nombre: ");
		
		cliente = new Cliente(NIT,CI,nombre);

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

	/*public void buscar(String titulo) {
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
	}*/

}
