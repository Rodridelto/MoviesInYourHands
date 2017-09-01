package com.moviesInYourHands.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.moviesInYourHands.entity.Cine;



public class CineCtrl 
{
	
Conexion conexion;
	
	public CineCtrl (Conexion conexion) 
	{
		this.conexion = conexion;
	}
	
	public void Insertar(Cine cine) throws Throwable 
	{
		
		conexion.SQL("Insert into cine(nombre,direccion,telefono) VALUES(?,?,?)");
		conexion.preparedStatement().setString(1, cine.getNombre());
		conexion.preparedStatement().setString(2, cine.getDireccion());
		conexion.preparedStatement().setInt(3, cine.getTelefono());
		conexion.CUD();
		
	}
	
	public ArrayList<Cine> list() throws Throwable {
		ArrayList<Cine> cines = new ArrayList<Cine>();
		ResultSet rs;
		int codigo;
		String nombre;
	    String direccion;
		int telefono;
		

		conexion.SQL("Select * from cine");

		rs = conexion.resultSet();

		while (rs.next()) {
			codigo= rs.getInt("codigo");
			nombre= rs.getString("nombre");
			direccion= rs.getString("direccion");
			telefono= rs.getInt("telefono");
			
			
			cines.add(new Cine(codigo,nombre,direccion,telefono));
		}

		return cines;

	}
	public String getNombre(int codigo) throws Throwable
	{
		ResultSet rs;
        String nombre = "";
		conexion.SQL("Select * from cine where codigo=?");
		conexion.preparedStatement().setInt(1, codigo);
		rs = conexion.resultSet();
		while (rs.next()){
			nombre = rs.getString("nombre");
		}
		return nombre;
				
	}

}
