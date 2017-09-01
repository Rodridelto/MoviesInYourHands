package com.moviesInYourHands.control;

import java.sql.ResultSet;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.moviesInYourHands.entity.DetalleVenta;
import com.moviesInYourHands.view.Factura;



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

	public Factura getFactura(int codigoFuncion)
	{
		ResultSet rs;
		String nombre = null;
		String direccion = null;
		int codigoDetalleVenta = 0;
		String nombreCliente = null;
		int NIT = 0;
		int cantidad = 0;
		double precioUnidad = 0;
		double total = 0;
		Factura factura = new Factura();

		try {
			conexion.SQL("SELECT cine.nombre, cine.direccion, detalleventa.codigo, cliente.nombre,venta.NIT, detalleventa.cantidad, funcion.precioUnidad, detalleventa.total "+
					" from cine INNER JOIN funcion ON funcion.codigoCine= cine.codigo " + 
					" INNER JOIN detalleventa ON funcion.codigo=detalleventa.codigoFuncion "+
					" INNER JOIN venta ON detalleventa.codigoVenta=venta.codigo " +
					"   INNER JOIN cliente ON venta.codigoCliente=cliente.codigo "+
					" where funcion.codigo=?");
			conexion.preparedStatement().setInt(1, codigoFuncion);
			rs = conexion.resultSet();
			while (rs.next()){
				nombre = rs.getString("nombre");
				direccion=rs.getString("direccion");
				codigoDetalleVenta=rs.getInt("codigo");
				nombreCliente=rs.getString("cliente.nombre");
				NIT=rs.getInt("NIT");
				cantidad=rs.getInt("cantidad");
				precioUnidad=rs.getDouble("precioUnidad");
				total=rs.getDouble("total");
			}
			
			factura.setNombreCine(nombre);
			factura.setDireccion(direccion);
			factura.setCodigoDetalleVenta(codigoDetalleVenta);
			factura.setNombreCliente(nombreCliente);
			factura.setNit(NIT);
			factura.setCantidad(cantidad);
			factura.setPrecioUnidad(precioUnidad);
			factura.setPrecioTotal(total);
			return factura;
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return factura;
	}
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


