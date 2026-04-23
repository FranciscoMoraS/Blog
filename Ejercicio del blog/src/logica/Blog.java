package logica;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class Blog {
	private static int consecutivo;
	private int codigo;
	private String nombre;
	private String descripcion;
	private LocalDateTime fechaCreacion;
	private Map<Integer, publicacion> Publicaciones;
	
	public Blog (String nombre, String descripcion) {
		this.nombre=nombre;
		this.descripcion=descripcion;
		codigo=consecutivo;
		consecutivo++;
		fechaCreacion=LocalDateTime.now();
		Publicaciones= new TreeMap<Integer, publicacion>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCodigo() {
		return codigo;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}


	public void crearPublicacion(String titulo, String texto, String creador) {
		publicacion p = new publicacion(titulo, texto, creador);
		Publicaciones.put(p.getCodigo(), p);
	}
	public String getPublicacion(int codigoPublicacion) throws Exception {
		revisarPublicacionExistente(codigoPublicacion);
		publicacion p = Publicaciones.get(codigoPublicacion);
		return p.toString();
	}
	public Map<Integer, String> getPublicaciones(){
		Map<Integer, String> titulos = new TreeMap<Integer, String>();
		for (publicacion p: Publicaciones.values()) {
			titulos.put(p.getCodigo(), p.getTitulo());
		}
		return titulos;
	}
	private void revisarPublicacionExistente(int codigoPublicacion) throws Exception {
		if (!Publicaciones.containsKey(codigoPublicacion))
			throw new Exception("Codigo de publicacion no encontrado");
	}
	public void crearComentario(int codigoPublicacion, String email, String ip, String textoComentario) throws Exception {
		revisarPublicacionExistente(codigoPublicacion);
		publicacion p = Publicaciones.get(codigoPublicacion);
		p.crearComentario(email, ip, textoComentario);
	}
	public void borrarComentario(int codigoPublicacion, int codigoComentario) throws Exception {
		revisarPublicacionExistente(codigoPublicacion);
		publicacion p = Publicaciones.get(codigoPublicacion);
		p.borrarComentario(codigoComentario);
	}
}
