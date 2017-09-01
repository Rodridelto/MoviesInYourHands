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

	public String getNombre(int codigo) throws Throwable
	{
		ResultSet rs;
        String nombre = "";
		conexion.SQL("Select * from horario where codigo=?");
		conexion.preparedStatement().setInt(1, codigo);
		rs = conexion.resultSet();
		while (rs.next()){
			nombre = rs.getString("horaInicio") + " - "+rs.getString("horaFin") ;
		}
		return nombre;
				
	}
}
