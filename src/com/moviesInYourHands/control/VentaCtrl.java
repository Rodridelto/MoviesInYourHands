package com.moviesInYourHands.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.moviesInYourHands.entity.Venta;

public class VentaCtrl 
{
	
Conexion conexion;
	
	public VentaCtrl (Conexion conexion) 
	{
		this.conexion = conexion;
	}
	
	public void Insertar(Venta venta) throws Throwable 
	{
		
		conexion.SQL("Insert into venta(codigoCliente, NIT, codigoBancario) VALUES(?,?,?)");
		conexion.preparedStatement().setInt(1, venta.getCodigoCliente());
		conexion.preparedStatement().setInt(2, venta.getNIT());
		conexion.preparedStatement().setInt(3, venta.getCodigoBancario());
		conexion.CUD();
		
	}
	
	public ArrayList<Venta> list() throws Throwable {
		ArrayList<Venta> ventas = new ArrayList<Venta>();
		ResultSet rs;
		int codigo;
		int codigoBancario;
		int codigoCliente;
		int NIT;
		

		conexion.SQL("Select * from venta");

		rs = conexion.resultSet();

		while (rs.next()) {
			codigo= rs.getInt("codigo");
			codigoBancario= rs.getInt("codigoBancario");
			codigoCliente= rs.getInt("codigoCliente");
			NIT= rs.getInt("NIT");
			
			ventas.add(new Venta(codigoBancario,codigoCliente, NIT));
		}

		return ventas;

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
	public int getLastCodigo() throws Throwable
	{
		ResultSet rs;
		int codigo=0;
		

		conexion.SQL("Select * from Venta order by codigo DESC limit 1");

		rs = conexion.resultSet();

		while (rs.next()) {
			codigo = rs.getInt("codigo");
	}
		return codigo;
	}

}
