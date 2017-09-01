package com.moviesInYourHands.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.moviesInYourHands.entity.Venta;

public class VentaCtrl 
{
	
Conexion conexion;
	
	public VentaCtrl (Conexion conexion) 
	{
		this.conexion = conexion;
	}
	
	public void Insertar(Venta venta) throws Throwable 
	{
		ClienteCtrl clienteCtrl = new ClienteCtrl(conexion);
		int codigoCliente = clienteCtrl.getUltimoClienteIngresado();
		conexion.SQL("Insert into venta(codigoCliente, NIT, codigoBancario) VALUES(?,?,?)");
		conexion.preparedStatement().setInt(1, codigoCliente);
		conexion.preparedStatement().setInt(2, venta.getNIT());
		conexion.preparedStatement().setInt(3, venta.getCodigoBancario());
		conexion.CUD();
		
	}
	
	public ArrayList<Venta> list() throws Throwable {
		ArrayList<Venta> ventas = new ArrayList<Venta>();
		ResultSet rs;
		int codigo;
		int codigoBancario;
		int codigoCliente;
		int NIT;
		

		conexion.SQL("Select * from venta");

		rs = conexion.resultSet();

		while (rs.next()) {
			codigo= rs.getInt("codigo");
			codigoBancario= rs.getInt("codigoBancario");
			codigoCliente= rs.getInt("codigoCliente");
			NIT= rs.getInt("NIT");
			
			ventas.add(new Venta(codigoBancario,codigoCliente, NIT));
		}

		return ventas;

	}
	
	public int getLastCodigo() throws Throwable
	{
		ResultSet rs;
		int codigo=0;
		

		conexion.SQL("Select * from Venta order by codigo DESC limit 1");

		rs = conexion.resultSet();

		while (rs.next()) {
			codigo = rs.getInt("codigo");
	}
		return codigo;
	}

}
