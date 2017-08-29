package com.moviesInYourHands.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.moviesInYourHands.entity.Sala;

public class SalaCtrl 
{
	
Conexion conexion;
	
	public SalaCtrl (Conexion conexion) 
	{
		this.conexion = conexion;
	}
	
	public void Insertar(Sala sala) throws Throwable 
	{
		
		conexion.SQL("Insert into sala(codigoCine,numeroSala,cantidadDeButacas) VALUES(?,?,?)");
		conexion.preparedStatement().setInt(1, sala.getCodigoCine());
		conexion.preparedStatement().setInt(2, sala.getNumeroSala());
		conexion.preparedStatement().setInt(3, sala.getCantidadButacas());
		conexion.CUD();
		
	}
	
	public ArrayList<Sala> list() throws Throwable {
		ArrayList<Sala> salas = new ArrayList<Sala>();
		ResultSet rs;
		int codigo;
		int codigoCine;
		int numeroSala;
		int cantidadDeButacas;
		

		conexion.SQL("Select * from sala");

		rs = conexion.resultSet();

		while (rs.next()) {
			codigo= rs.getInt("codigo");
			codigoCine= rs.getInt("codigoCine");
			numeroSala= rs.getInt("numeroSala");
			cantidadDeButacas= rs.getInt("cantidadDeButacas");
			
			salas.add(new Sala(codigo,codigoCine,numeroSala,cantidadDeButacas));
		}

		return salas;

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
