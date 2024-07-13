package com.Alura.Literatura.Pincipal;

import com.Alura.Literatura.modelo.Libros;
import com.Alura.Literatura.modelo.Autor;
import com.Alura.Literatura.repository.AutorRepository;
import com.Alura.Literatura.repository.LibroRepository;
import com.Alura.Literatura.service.ConsumoAPI;
import com.Alura.Literatura.service.ConvierteDatos;
import com.Alura.Literatura.modelo.DatosLibros;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication(scanBasePackages = {"com.Alura.Literatura"})
public class LiteraturaApplication implements CommandLineRunner {

	private final ConsumoAPI consumoAPI;
	private final ConvierteDatos convierteDatos;
	private final Scanner scanner;
	private final AutorRepository autorRepository = new AutorRepository();
	private final LibroRepository libroRepository = new LibroRepository();

	public LiteraturaApplication(ConsumoAPI consumoAPI, ConvierteDatos convierteDatos) {
		this.consumoAPI = consumoAPI;
		this.convierteDatos = convierteDatos;
		this.scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {
		SpringApplication.run(LiteraturaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		mostrarMenu();
	}

	private void mostrarMenu() {
		boolean continuar = true;
		while (continuar) {
			System.out.println("### Menú Principal ###");
			System.out.println("1. Consultar libros");
			System.out.println("2. Buscar libro por título");
			System.out.println("3. Listar autores");
			System.out.println("4. Listar autores vivos en determinado año");
			System.out.println("5. Salir");
			System.out.println("Ingrese el número de opción deseada: ");

			int opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion) {
				case 1:
					consultarLibrosDesdeAPI();
					break;
				case 2:
					buscarLibroPorTitulo();
					break;
				case 3:
					listarAutores();
					break;
				case 4:
					listarAutoresVivosEnAnio();
					break;
				case 5:
					System.out.println("Saliendo de la aplicación...");
					continuar = false;
					break;
				default:
					System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
			}
		}
	}

	private void consultarLibrosDesdeAPI() {
		try {
			String url = ConsumoAPI.URL_BASE;
			String jsonResponse = consumoAPI.obtenerDatos(url);
			DatosLibros datosLibros = convierteDatos.convertirDesdeJson(jsonResponse, DatosLibros.class);

			guardarLibrosYAutores(datosLibros);
			mostrarInformacionLibros(datosLibros);
		} catch (Exception e) {
			System.out.println("Error al consultar los libros desde la API: " + e.getMessage());
		}
	}

	private void buscarLibroPorTitulo() {
		System.out.println("Ingrese el título del libro: ");
		String titulo = scanner.nextLine();
		try {
			String jsonResponse = consumoAPI.buscarLibroPorTitulo(titulo);
			//System.out.println("Respuesta de la API: " + jsonResponse);  // Depuración

			DatosLibros datosLibros = convierteDatos.convertirDesdeJson(jsonResponse, DatosLibros.class);

			if (datosLibros.getResults().isEmpty()) {
				System.out.println("No se encontraron libros con ese título.");
			} else {
				guardarLibrosYAutores(datosLibros);
				mostrarInformacionLibro(datosLibros.getResults().get(0));
			}
		} catch (Exception e) {
			System.out.println("Error al buscar el libro por título: " + e.getMessage());
			e.printStackTrace();  // Depuración
		}
	}

	private void listarAutores() {
		List<Autor> autores = autorRepository.listar();
		if (autores.isEmpty()) {
			System.out.println("No se han encontrado autores.");
		} else {
			autores.forEach(autor -> System.out.println(autor));
		}
	}

	private void listarAutoresVivosEnAnio() {
		System.out.println("Ingrese el año: ");
		int anio = scanner.nextInt();
		scanner.nextLine();
		List<Autor> autoresVivos = autorRepository.listarVivosEnAnio(anio);
		if (autoresVivos.isEmpty()) {
			System.out.println("No se encontraron autores vivos en el año " + anio);
		} else {
			autoresVivos.forEach(autor -> System.out.println(autor));
		}
	}

	private void guardarLibrosYAutores(DatosLibros datosLibros) {
		datosLibros.getResults().forEach(libro -> {
			libroRepository.guardar(libro);
			if (!libro.getAutores().isEmpty()) {
				autorRepository.guardar(libro.getAutores().get(0));
			}
		});
	}

	private void mostrarInformacionLibros(DatosLibros datosLibros) {
		System.out.println("### Resultados de la consulta ###");
		for (int i = 0; i < datosLibros.getResults().size(); i++) {
			mostrarInformacionLibro(datosLibros.getResults().get(i));
		}
	}

	private void mostrarInformacionLibro(Libros libro) {
		System.out.println("Libro #" + libro.getId());
		System.out.println("Titulo: " + libro.getTitulo());

		StringBuilder autores = new StringBuilder("Autores: ");
		for (int j = 0; j < libro.getAutores().size(); j++) {
			autores.append(libro.getAutores().get(j).getNombre());
			if (j < libro.getAutores().size() - 1) {
				autores.append(", ");
			}
		}
		System.out.println(autores.toString());

		System.out.println("Idiomas: " + libro.getIdiomas().get(0));  // Asumiendo que solo hay un idioma
		System.out.println("Número de Descargas: " + libro.getDownloadCount());
		System.out.println();
	}
}
