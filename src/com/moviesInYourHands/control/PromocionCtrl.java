package com.moviesInYourHands.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.moviesInYourHands.entity.Promocion;

public class PromocionCtrl 
{
	
Conexion conexion;
	
	public PromocionCtrl (Conexion conexion) 
	{
		this.conexion = conexion;
	}
	
	public void Insertar(Promocion promocion) throws Throwable 
	{
		
		conexion.SQL("Insert into promocion( descuento,descripcion ) VALUES(?,?)");
		conexion.preparedStatement().setDouble(1, promocion.getDescuento());
		conexion.preparedStatement().setString(2, promocion.getDescripcion());
		
		conexion.CUD();
		
	}
	
	public ArrayList<Promocion> list() throws Throwable {
		ArrayList<Promocion> promociones = new ArrayList<Promocion>();
		ResultSet rs;
		int codigo;
		int descuento;
		String descripcion;
		

		conexion.SQL("Select * from promocion");

		rs = conexion.resultSet();

		while (rs.next()) {
			codigo= rs.getInt("codigo");
			descuento= rs.getInt("descuento");
			descripcion=rs.getString("descripcion");
			promociones.add(new Promocion(codigo,descuento,descripcion));
		}

		return promociones;

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
