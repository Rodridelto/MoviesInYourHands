package com.moviesInYourHands.entity;

public class Pelicula 
{
	private int codigo;
	private String titulo;
	private String idioma;
	private boolean subtitulos;
	private int duracion;
	private String resumen;
	private String genero;
	public Pelicula(int codigo, String titulo, String idioma, boolean subtitulos, int duracion, String resumen,String genero) 
	{

		this.titulo = titulo;
		this.idioma = idioma;
		this.subtitulos = subtitulos;
		this.duracion = duracion;
		this.resumen = resumen;
		this.codigo=codigo;
		this.genero=genero;
	}

	public Pelicula(String titulo, String idioma, boolean subtitulos, int duracion, String resumen,String genero) 
	{
		this.titulo = titulo;
		this.idioma = idioma;
		this.subtitulos = subtitulos;
		this.duracion = duracion;
		this.resumen = resumen;
		this.genero= genero;
	}
	public Pelicula(String titulo)
	{
		this.titulo=titulo;
	}

	public Pelicula(int codigo)
	{
		this.codigo=codigo;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String tituloOriginal) {
		this.titulo = titulo;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public boolean getSubtitulos() {
		return subtitulos;
	}
	public void setSubtitulos(boolean subtitulos) {
		this.subtitulos = subtitulos;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getResumen() {
		return resumen;
	}
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero=genero;
	}

	@Override

	public String toString()
	{
		return " Pelicula = [codigo= " + codigo +", Titulo= "+ titulo + ", Idioma= "+ idioma + ", Subtitulos= "+ subtitulos + ", Duracion= " + duracion + ", Resumen= " + resumen + ", Genero= " + genero + "]";
	}

}
