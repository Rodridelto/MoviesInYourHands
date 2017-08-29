package com.moviesInYourHands.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.moviesInYourHands.control.Conexion;
import com.moviesInYourHands.entity.Pelicula;




public class PeliculaCtrl 
{
	
	Conexion conexion;
	
	public PeliculaCtrl (Conexion conexion) 
	{
		this.conexion = conexion;
	}
	
	public void Insertar(Pelicula pelicula) throws Throwable 
	{
		
		conexion.SQL("Insert into pelicula( titulo,idioma, subtitulos,duracion,resumen,genero) VALUES(?,?,?,?,?,?)");
		conexion.preparedStatement().setString(1, pelicula.getTitulo());
		conexion.preparedStatement().setString(2, pelicula.getIdioma());
		conexion.preparedStatement().setBoolean(3, pelicula.getSubtitulos());
		conexion.preparedStatement().setInt(4, pelicula.getDuracion());
		conexion.preparedStatement().setString(5, pelicula.getResumen());
		conexion.preparedStatement().setString(6, pelicula.getGenero());
		conexion.CUD();
		
	}
	
	public ArrayList<Pelicula> list() throws Throwable {
		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
		ResultSet rs;
		int codigo;
		String titulo;
		String idioma;
		boolean subtitulos;
		int duracion;
		String resumen;
		String genero;
		

		conexion.SQL("Select * from pelicula");

		rs = conexion.resultSet();

		while (rs.next()) {
			codigo= rs.getInt("codigo");
			titulo= rs.getString("titulo");
			idioma= rs.getString("idioma");
			subtitulos= rs.getBoolean("subtitulos");
			duracion=rs.getInt("duracion");
			resumen=rs.getString("resumen");
			genero=rs.getString("genero");
			peliculas.add(new Pelicula(codigo,titulo,idioma, subtitulos,duracion,resumen,genero));
		}

		return peliculas;

	}
	
	public void search(Pelicula pelicula) throws Throwable {

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
	}
	public String getNombre(int codigo) throws Throwable
	{
		ResultSet rs;
        String nombre = "";
		conexion.SQL("Select * from pelicula where codigo=?");
		conexion.preparedStatement().setInt(1, codigo);
		rs = conexion.resultSet();
		while (rs.next()){
			nombre = rs.getString("titulo");
			//System.out.println(nombre + "nombre");
		}
		return nombre;
				
	}
	

}
