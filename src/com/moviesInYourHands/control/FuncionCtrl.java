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
		
		conexion.SQL("Insert into pelicula( codigoPromocion,codigoHorario, codigoTemporada,codigoCine,codigoPelicula,codigoDetalleVenta,nombreFuncion) VALUES(?,?,?,?,?,?,?)");
		conexion.preparedStatement().setInt(1, funcion.getCodigoPromocion());
		conexion.preparedStatement().setInt(2, funcion.getCodigoHorario());
		conexion.preparedStatement().setInt(3, funcion.getCodigoTemporada());
		conexion.preparedStatement().setInt(4, funcion.getCodigoCine());
		conexion.preparedStatement().setInt(5, funcion.getCodigoPelicula());
		conexion.preparedStatement().setInt(6, funcion.getCodigoDetalleVenta());
		conexion.preparedStatement().setString(7, funcion.getNombreFuncion());
		conexion.CUD();
		
	}
	
	public ArrayList<Funcion> list() throws Throwable {
		ArrayList<Funcion> funcion = new ArrayList<Funcion>();
		ResultSet rs;
		
		 int codigo;
		 int codigoPromocion;
		 int codigoHorario;
		 int codigoTemporada;
		 int codigoCine;
		 int codigoPelicula;
		 int codigoDetalleVenta;
		 String nombreFuncion;
		

		conexion.SQL("Select * from funcion");

		rs = conexion.resultSet();

		while (rs.next()) {
			codigo= rs.getInt("codigo");
			codigoPromocion=rs.getInt("codigoPromocion");
			codigoHorario=rs.getInt("codigoHorario");
			codigoTemporada=rs.getInt("codigoTemporada");
			codigoCine=rs.getInt("codigoCine");
			codigoPelicula=rs.getInt("codigoPelicula");
			codigoDetalleVenta=rs.getInt("codigoDetalleVenta");
			nombreFuncion=rs.getNString("nombreFuncion");
			
			
			
			funcion.add(new Funcion(codigo,codigoPromocion,codigoHorario, codigoTemporada,codigoCine,codigoPelicula,codigoDetalleVenta,nombreFuncion));
		}

		return funcion;

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
			funcion.setCodigoDetalleVenta(rs.getInt("codigoDetalleVenta"));
			funcion.setNombreFuncion(rs.getString("nombreFuncion"));
				
		}

		rs.close();

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


}
