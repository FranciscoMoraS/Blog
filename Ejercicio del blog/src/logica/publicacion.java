package logica;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class publicacion {
	private static int consecutivo=0;
	private int codigo;
	private String titulo;
	private String texto;
	private String nombreCreador;
	private LocalDateTime fechaPublicacion;
	private ArrayList<comentario> comentarios;
	
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
	//public ArrayList<comentario> getComentarios() {
	//	return comentarios;
	//}
	public void borrarComentario(int codigoComentario) throws Exception {
		if (codigoComentario >= comentarios.size())
			throw new Exception("codigo de comentario no valido.");
		comentarios.remove(codigoComentario);
	}
	public String toString() {
		String resultado;
		resultado= titulo + "\n"+ texto + "\n"+ nombreCreador + " - " + fechaPublicacion.toString();
		resultado+= "\n";
		for (int i=0; i< comentarios.size();i++) {
			resultado+= comentarios.get(i).toString();
			resultado+= "\n";
		}
		return resultado;
	}
	
	
}
