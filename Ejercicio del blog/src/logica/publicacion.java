package logica;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class publicacion {
	private static int consecutivo=0;
	private int codigo;
	private String titulo;
	private String texto;
	private String nombreCreador;
	private LocalDateTime fechaPublicacion;
	private List<comentario> comentarios;
	
	public publicacion(String titulo, String texto, String nombreCreador) {
		this.titulo=titulo;
		this.texto=texto;
		this.nombreCreador=nombreCreador;
		codigo=consecutivo;
		fechaPublicacion= LocalDateTime.now();
		comentarios= new ArrayList<>();
		consecutivo++;
	}

	public static int getConsecutivo() {
		return consecutivo;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getTexto() {
		return texto;
	}

	public String getNombreCreador() {
		return nombreCreador;
	}
	public void crearComentario (String email, String ip, String textoComentario) {
		comentario nuevoComentario=new comentario(email, ip, textoComentario);
		comentarios.add(nuevoComentario);
	}
	public List getComentarios() {
		return comentarios;
	}
	public void borrarComentario(int codigoComentario) throws Exception {
		if (codigoComentario >= comentarios.size())
			throw new Exception("codigo de comentario no valido.");
	}
	public String toString() {
		
	}
	
	
}
