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
}
