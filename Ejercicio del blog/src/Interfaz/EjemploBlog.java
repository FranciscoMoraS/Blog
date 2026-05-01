package Interfaz;

import java.util.Map;
import java.util.Scanner;

import Control.Controladora;

public class EjemploBlog {

	private static Controladora controladora;
	
	public static void menuPublicacion() {
		
	}
	
	public static void main(String[] args) throws Exception {
		controladora= new Controladora();
		controladora.crearBlog("La historia de mi vida", "En este blog voy a contar sobre mi vida" );
		controladora.crearBlog("Cocina con Kat", "Aqui voy a subir mis recetas");
		controladora.crearPublicacion(0, "Viaje a la playa", "Ayer fui a la playa con mis padres", "Julien Grant");
		controladora.crearPublicacion(0, "El colegio", "Hoy oficialmente inicio mi vida en el colegio :)", "Julien Grant");
		//crear comentarios y las otras dos publicaciones
		
		boolean continuar = true;
		while (continuar) {
			System.out.println("Administración de Blogs" + "\n");
			System.out.println("1. Crear blog nuevo" + "\n");
			System.out.println("2. Trabajar con Blog" + "\n");
			System.out.println("3. Borrar Blog" + "\n");
			System.out.println("4. Salir" + "\n");
			
			Scanner teclado = new Scanner(System.in);
			
			int opcion= teclado.nextInt();
			
			if (opcion ==1) {
				//solicitar datos blog, validarlos y crear nuevo blog
				String nombre = teclado.nextLine();
				String descripcion = teclado.nextLine();
				controladora.crearBlog(nombre, descripcion);
			} else if (opcion == 2) {
				//abrir menu blogs
				boolean mBlogs = true;
				while (mBlogs) {
					System.out.println(controladora.obtenerBlogs());
					System.out.println("Seleccione un blog para trabajar");
				}
			} else if (opcion == 3) {
				//pedir codigo de blog a borrar
				int codigo = teclado.nextInt();
				controladora.borrarBlog(codigo);
			} else if (opcion ==4) {
				continuar = false;
			} else {
				System.out.println("Ingrese una opcion valida" + "\n");
			}
		}
	}

}
