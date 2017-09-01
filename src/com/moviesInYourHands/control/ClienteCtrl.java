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
	
	/*public void search(Pelicula pelicula) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from pelicula where titulo=?");
		conexion.preparedStatement().setString(1, pelicula.getTitulo());
		rs = conexion.resultSet();

		while (rs.next()) {

			pelicula.setCodigo(rs.getInt("codigo"));
			pelicula.setIdioma(rs.getString("idioma"));
			pelicula.setSubtitulos(rs.getBoolean("subtitulos"));
			pelicula.setDuracion(rs.getInt("duracion"));
			pelicula.setResumen(rs.getString("resumen"));
			
		}

		rs.close();

	}
	
	public void update(Pelicula pelicula) throws Throwable {
		
		int codigo;
		int duracion;
		
		if (pelicula != null) {
			codigo = pelicula.getCodigo();
			duracion = pelicula.getDuracion();

			conexion.SQL("Update pelicula set codigo = ? where duracion=?");
			conexion.preparedStatement().setInt(1, codigo);
			conexion.preparedStatement().setInt(2, duracion);
			conexion.CUD();
		}
	}*/


}
