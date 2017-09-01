package com.moviesInYourHands.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.moviesInYourHands.entity.Cliente;



public class ClienteCtrl 
{
	
Conexion conexion;
	
	public ClienteCtrl (Conexion conexion) 
	{
		this.conexion = conexion;
	}
	
	public void Insertar(Cliente cliente) throws Throwable 
	{
		
		conexion.SQL("Insert into cliente( CI,nombre) VALUES(?,?)");
		
		conexion.preparedStatement().setInt(1, cliente.getCI());
		conexion.preparedStatement().setString(2, cliente.getNombre());
		
		conexion.CUD();
		
	}
	
	public ArrayList<Cliente> list() throws Throwable {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		ResultSet rs;
		int codigo;
		int NIT;
		int CI;
		String nombre;
		

		conexion.SQL("Select * from cliente");

		rs = conexion.resultSet();

		while (rs.next()) {
			codigo= rs.getInt("codigo");
			CI= rs.getInt("CI");
			nombre= rs.getString("nombre");
		
			
			clientes.add(new Cliente(codigo,CI,nombre));
		}

		return clientes;

	}

	public int getUltimoClienteIngresado() throws Throwable {
		ResultSet rs;
		int codigo=0;
		

		conexion.SQL("Select * from Cliente order by codigo DESC limit 1");

		rs = conexion.resultSet();

		while (rs.next()) {
			codigo = rs.getInt("codigo");
	}
		return codigo;

	}
}
