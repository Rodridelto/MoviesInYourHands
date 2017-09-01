package com.moviesInYourHands.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.moviesInYourHands.control.Conexion;
import com.moviesInYourHands.control.VentaCtrl;
import com.moviesInYourHands.entity.Venta;

public class VentaView
{

	private Scanner scanner;
	private Venta venta;
	private VentaCtrl ventaCtrl;



	public  VentaView(Conexion conexion,Scanner scanner)
	{
		this.scanner = scanner;
		ventaCtrl = new  VentaCtrl(conexion);

	}

	public void insertar() 
	{
		
		int codigoBancario;
		int codigoCliente;
		int NIT;
		
		codigoBancario = ReadTypes.leerEntero(scanner, "Ingrese el Codigo bancario: ");
		NIT = ReadTypes.leerEntero(scanner, "Ingrese el NIT: ");
		
		
		venta = new Venta(codigoBancario,NIT);

		try {
			ventaCtrl.Insertar(venta);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}

	public void listar() {
			ArrayList<Venta> ventas;

		try {
			ventas = ventaCtrl.list();
			for (int i = 0; i < ventas.size(); i++) {
				System.out.println(ventas.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
}
