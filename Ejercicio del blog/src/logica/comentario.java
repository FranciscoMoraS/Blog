package logica;

import java.time.LocalDateTime;

public class comentario {
	private LocalDateTime fechaCreacion;
	private String email;
	private String ip;
	private String texto;
	
	public comentario(String email, String ip, String texto) {
		this.email=email;
		this.ip=ip;
		this.texto=texto;
		fechaCreacion= LocalDateTime.now();
	}
	public String toString() {
		String resultado= email +" - "+ip+" - "+ fechaCreacion.toString()+"\n";
		resultado += texto + "\n";
		return resultado;
	}
	
}
