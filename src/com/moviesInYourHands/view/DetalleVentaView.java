package com.moviesInYourHands.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.moviesInYourHands.control.Conexion;
import com.moviesInYourHands.control.DetalleVentaCtrl;
import com.moviesInYourHands.entity.DetalleVenta;


public class DetalleVentaView
{
	
	private Scanner scanner;
	private DetalleVenta detalleVenta;
	private DetalleVentaCtrl detalleVentaCtrl;



	public  DetalleVentaView(Conexion conexion,Scanner scanner)
	{
		this.scanner = scanner;
		detalleVentaCtrl = new  DetalleVentaCtrl(conexion);

	}

	public void insertar(int cantidad,int codigoFuncion,double total) 
	{
	
		detalleVenta = new DetalleVenta(cantidad,codigoFuncion,total);

		try {
			detalleVentaCtrl.Insertar(detalleVenta);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}

	public void listar() {
		ArrayList<DetalleVenta> detalleVentas;

		try {
			detalleVentas = detalleVentaCtrl.list();
			for (int i = 0; i < detalleVentas.size(); i++) {
				System.out.println(detalleVentas.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	public void mostrarFactura(int codigoFuncion)
	{
		Date fecha;
		String fechaDia;
		fecha= new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		fechaDia = simpleDateFormat.format(fecha);

		Factura  factura = detalleVentaCtrl.getFactura(codigoFuncion);
		System.out.println();
		System.out.println();
		System.out.println("************** "+ factura.getNombreCine() +"**************");
		System.out.println("*          "+ factura.getDireccion() +"        ");
		System.out.println("*************** FACTURA ***************");
		System.out.println("* N° de Factura:  "+ factura.getCodigoDetalleVenta()+"                  ");
		System.out.println("*-------------------------------------");
		System.out.println("* Fecha:  "+ fechaDia + "            ");
		System.out.println("* Cliente: "+ factura.getNombreCliente() + "      ");
		System.out.println("* NIT: "+ factura.getNit() + "                        ");
		System.out.println("***************************************");
		System.out.println("* Cantidad "+ " Precio Unitario " + "   Total  ");
		System.out.println("*   "+ factura.getCantidad() + "         " + factura.getPrecioUnidad() +"              " + factura.getPrecioTotal() +"  ");
		System.out.println("*   *** Gracias por su compra =)***   ");
		System.out.println("***************************************");

		
	}
}
