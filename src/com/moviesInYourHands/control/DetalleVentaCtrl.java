package com.moviesInYourHands.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.moviesInYourHands.entity.DetalleVenta;



public class DetalleVentaCtrl
{
	
Conexion conexion;
	
	public DetalleVentaCtrl (Conexion conexion) 
	{
		this.conexion = conexion;
	}
	
	public void Insertar(DetalleVenta detalleVenta) throws Throwable 
	{
		VentaCtrl ventaCtrl = new VentaCtrl(conexion);
		int codigoVenta = ventaCtrl.getLastCodigo();
		conexion.SQL("Insert into detalleVenta( cantidad,codigoFuncion,total,codigoVenta) VALUES(?,?,?,?)");
		conexion.preparedStatement().setInt(1, detalleVenta.getCantidad());
		conexion.preparedStatement().setInt(2, detalleVenta.getCodigoFuncion());
		conexion.preparedStatement().setDouble(3, detalleVenta.getTotal());
		conexion.preparedStatement().setInt(4, codigoVenta);
		conexion.CUD();
		
	}
	
	public ArrayList<DetalleVenta> list() throws Throwable {
		ArrayList<DetalleVenta> detalleVentas = new ArrayList<DetalleVenta>();
		ResultSet rs;
		int codigo;
		int cantidad;
		int codigoFuncion;
		int codigoVenta;
		double total;
		

		conexion.SQL("Select * from detalleVenta");

		rs = conexion.resultSet();

		while (rs.next()) {
			codigo= rs.getInt("codigo");
			cantidad= rs.getInt("cantidad");
			codigoFuncion= rs.getInt("codigoFuncion");
			total=rs.getDouble("total");
			codigoVenta=rs.getInt("codigoVenta");			
			detalleVentas.add(new DetalleVenta(codigo,cantidad,codigoFuncion,codigoVenta,total));
		}
		return detalleVentas;

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
