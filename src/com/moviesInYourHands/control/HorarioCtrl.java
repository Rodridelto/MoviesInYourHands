package com.moviesInYourHands.control;

import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;

import com.moviesInYourHands.entity.Horario;



public class HorarioCtrl 
{
	
Conexion conexion;
	
	public HorarioCtrl (Conexion conexion) 
	{
		this.conexion = conexion;
	}
	
	public void Insertar(Horario horario) throws Throwable 
	{
		
		conexion.SQL("Insert into horario(horaInicio,horaFin) VALUES(?,?)");
		conexion.preparedStatement().setTime(1, horario.getHorarioInicio());
		conexion.preparedStatement().setTime(2, horario.getHorarioFin());
		conexion.CUD();
		
	}
	
	public ArrayList<Horario> list() throws Throwable {
		ArrayList<Horario> horarios = new ArrayList<Horario>();
		ResultSet rs;
		int codigo;
		Time horaInicio;
		Time horaFin;
		

		conexion.SQL("Select * from horario");

		rs = conexion.resultSet();

		while (rs.next()) {
			codigo= rs.getInt("codigo");
			horaInicio= rs.getTime("horaInicio");
			horaFin= rs.getTime("horaFin");
			
			horarios.add(new Horario(codigo,horaInicio,horaFin));
		}

		return horarios;

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
