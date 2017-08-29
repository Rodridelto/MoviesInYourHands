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

	}*/
	/*
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
