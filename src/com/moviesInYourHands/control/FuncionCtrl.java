package com.moviesInYourHands.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.moviesInYourHands.entity.Funcion;

public class FuncionCtrl
{
	
Conexion conexion;
	
	public FuncionCtrl (Conexion conexion) 
	{
		this.conexion = conexion;
	}
	
	public void Insertar(Funcion funcion) throws Throwable 
	{
		
		conexion.SQL("Insert into pelicula( codigoPromocion,codigoHorario, codigoTemporada,codigoCine,codigoPelicula,nombreFuncion) VALUES(?,?,?,?,?,?)");
		conexion.preparedStatement().setInt(1, funcion.getCodigoPromocion());
		conexion.preparedStatement().setInt(2, funcion.getCodigoHorario());
		conexion.preparedStatement().setInt(3, funcion.getCodigoTemporada());
		conexion.preparedStatement().setInt(4, funcion.getCodigoCine());
		conexion.preparedStatement().setInt(5, funcion.getCodigoPelicula());
		conexion.preparedStatement().setString(6, funcion.getNombreFuncion());
		conexion.CUD();
		
	}
	
	public ArrayList<Funcion> list() throws Throwable {
		ArrayList<Funcion> funciones = new ArrayList<Funcion>();
		ResultSet rs;
		
		 int codigo;
		 int codigoPromocion;
		 int codigoHorario;
		 int codigoTemporada;
		 int codigoCine;
		 int codigoPelicula;
		 double precioUnidad;
		 String cine;
		 String pelicula;
		 String horario;
		 String temporada;
		 String nombreFuncion;
		

		conexion.SQL("Select * from funcion");

		rs = conexion.resultSet();

		while (rs.next()) {
			codigo= rs.getInt("codigo");
			//codigoPromocion=rs.getInt("codigoPromocion");
			codigoHorario=rs.getInt("codigoHorario");
			codigoTemporada=rs.getInt("codigoTemporada");
			codigoCine=rs.getInt("codigoCine");
			codigoPelicula=rs.getInt("codigoPelicula");
			nombreFuncion=rs.getString("nombreFuncion");
			precioUnidad = rs.getDouble("precioUnidad");
			
			
		    cine = new CineCtrl(conexion).getNombre(codigoCine);
		    pelicula = new PeliculaCtrl(conexion).getNombre(codigoPelicula);
			horario = new HorarioCtrl(conexion).getNombre(codigoHorario);
		    temporada = new TemporadaCtrl(conexion).getDatosTemporada(codigoTemporada);
			Funcion funcion = new Funcion(codigo,0,codigoHorario, codigoTemporada,codigoCine,codigoPelicula,nombreFuncion, precioUnidad);
			funcion.setCine(cine);
			funcion.setPelicula(pelicula);
			funcion.setHorario(horario);
			funcion.setTemporada(temporada);
			funciones.add(funcion);
		}
		
		return funciones;

	}
	
	public void search(Funcion funcion) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from funcion where codigo=?");
		conexion.preparedStatement().setInt(1, funcion.getCodigo());
		rs = conexion.resultSet();

		while (rs.next()) {

			funcion.setCodigoPromocion(rs.getInt("codigoPromocion"));
			funcion.setCodigoHorario(rs.getInt("codigoHorario"));
			funcion.setCodigoTemporada(rs.getInt("codigoTemporada"));
			funcion.setCodigoCine(rs.getInt("codigoCine"));
			funcion.setCodigoPelicula(rs.getInt("codigoPelicula"));
			funcion.setNombreFuncion(rs.getString("nombreFuncion"));
				
		}

		rs.close();
		funcion.setCine(new CineCtrl(conexion).getNombre(funcion.getCodigoCine()));
	}
	
	public void update(Funcion funcion) throws Throwable {
		
		int codigo;
		String nombreFuncion;
		
		if (funcion != null) {
			codigo = funcion.getCodigo();
			nombreFuncion = funcion.getNombreFuncion();

			conexion.SQL("Update pelicula set codigo = ? where duracion=?");
			conexion.preparedStatement().setInt(1, codigo);
			conexion.preparedStatement().setString(2, nombreFuncion);
			conexion.CUD();
		}
	}
	public double getPrecio(int codigo) throws Throwable
	{
		ResultSet rs;
        double precio = 0;
		conexion.SQL("Select * from funcion where codigo=?");
		conexion.preparedStatement().setInt(1, codigo);
		rs = conexion.resultSet();
		while (rs.next()){
			precio = rs.getDouble("precioUnidad");
		}
		return precio;
				
	}

}
