package com.moviesInYourHands.control;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.moviesInYourHands.entity.Temporada;

public class TemporadaCtrl
{
	
Conexion conexion;
	
	public TemporadaCtrl (Conexion conexion) 
	{
		this.conexion = conexion;
	}
	
	public void Insertar(Temporada temporada) throws Throwable 
	{
		
		conexion.SQL("Insert into temporada(fechaInicio,fechaFin) VALUES(?,?)");
		conexion.preparedStatement().setDate(1, (java.sql.Date)temporada.getFechaInicio());
		conexion.preparedStatement().setDate(2, (java.sql.Date)temporada.getFechaFin());
		
		conexion.CUD();
		
	}
	
	public ArrayList<Temporada> list() throws Throwable {
		ArrayList<Temporada> temporadas = new ArrayList<Temporada>();
		ResultSet rs;
		int codigo;
		Date fechaInicio;
		Date fechaFin;

		conexion.SQL("Select * from temporada");

		rs = conexion.resultSet();

		while (rs.next()) {
			codigo= rs.getInt("codigo");
			fechaInicio= rs.getDate("fechaInicio");
			fechaFin= rs.getDate("fechaFin");
			
			temporadas.add(new Temporada(codigo,fechaInicio,fechaFin));
		}

		return temporadas;

	}
	
	public String getDatosTemporada(int codigo) throws Throwable
	{
		ResultSet rs;
        String datos = "";
		conexion.SQL("Select * from temporada where codigo=?");
		conexion.preparedStatement().setInt(1, codigo);
		rs = conexion.resultSet();
		while (rs.next()){
			datos = rs.getDate("fechaInicio").toGMTString() + " - " + rs.getDate("fechaFin").toGMTString();
		}
		return datos;
				
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
