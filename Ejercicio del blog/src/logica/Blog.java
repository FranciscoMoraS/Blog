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

	public Map<Integer, publicacion> getPublicaciones() {
		return Publicaciones;
	}
	public void crearPublicacion(String titulo, String texto, String creador) {
		publicacion p = new publicacion(titulo, texto, creador);
		Publicaciones.put(p.getCodigo(), p);
	}
	public String getPublicacion(int codigoPublicacion) throws Exception {
		if (Publicaciones.containsKey(codigoPublicacion)) {
			throw new Exception("Codigo de publicacion no valido");
		}
		publicacion p = Publicaciones.get(codigoPublicacion);
		return p.toString();
	}
	
}
