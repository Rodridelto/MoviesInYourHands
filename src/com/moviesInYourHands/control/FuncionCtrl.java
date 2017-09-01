package com.moviesInYourHands.control;

import java.sql.ResultSet;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.moviesInYourHands.entity.Funcion;
import com.moviesInYourHands.view.Ticket;

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
		
		Date fecha= new Date();
		java.sql.Date today = new java.sql.Date(fecha.getTime());
			
			 conexion.SQL("select * from funcion inner join temporada on temporada.codigo=funcion.codigoTemporada "+
					 "where temporada.fechaInicio <= ? and temporada.fechaFin >= ?");
		 
		 conexion.preparedStatement().setDate(1, today);
		 conexion.preparedStatement().setDate(2, today);
		

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
	
	public Ticket listarTicket(int codigo)
	{
		ResultSet rs;
        String titulo = null;
        boolean subtitulos = false;
        String genero = null;
        int numeroSala = 0;
        Time horaInicio = null;
        Ticket ticket= new Ticket();
         
		try {
			conexion.SQL("SELECT titulo, subtitulos,genero,sala.numeroSala,horario.horaInicio,horario.horaFin "+
  "from pelicula INNER JOIN funcion ON funcion.codigoPelicula=pelicula.codigo "+
  "INNER JOIN cine ON funcion.codigoCine= cine.codigo "+
 " INNER JOIN sala ON cine.codigo=sala.codigoCine "+
 "INNER JOIN horario ON funcion.codigoHorario=horario.codigo "+
  "where funcion.codigo=?");
			conexion.preparedStatement().setInt(1, codigo);
			rs = conexion.resultSet();
			while (rs.next()){
				titulo = rs.getString("titulo");
				subtitulos=rs.getBoolean("subtitulos");
				genero=rs.getString("genero");
				numeroSala=rs.getInt("numeroSala");
				horaInicio=rs.getTime("horaInicio");
				
			
			}
			ticket.setTitulo(titulo);
			ticket.setSubtitulos(subtitulos);
			ticket.setGenero(genero);
			ticket.setNumeroSala(numeroSala);
			ticket.setHoraInicio(horaInicio);

		} catch (Throwable e) {
			e.printStackTrace();
		}
		return ticket;
		
		
		}

}
