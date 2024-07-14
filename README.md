# ChallengerLiterarura
Challenger Literarura de Alura 

# Literatura

**Literatura** es una aplicación que permite a los usuarios buscar libros y autores, registrar libros y listar autores vivos en un año específico. La aplicación utiliza una base de datos y una API externa para obtener y almacenar información sobre libros y autores.

## Características

- Buscar libros por título
- Revisar libros registrados
- Listar autores buscados
- Buscar autores vivos en un año específico
- Buscar libros por idioma

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.3.1**
- **JPA/Hibernate**
- **MySQL** (o cualquier otra base de datos soportada por JPA)
- **Maven**

## Instalación

1. Clona el repositorio:

    ```bash
    git clone https://github.com/tu_usuario/literatura.git
    cd literatura
    ```

2. Configura la base de datos:

    - Crea una base de datos en tu sistema de gestión de bases de datos (por ejemplo, MySQL).
    - Actualiza las configuraciones en `src/main/resources/application.properties` con los detalles de tu base de datos:

      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/nombre_de_tu_base_de_datos
      spring.datasource.username=tu_usuario
      spring.datasource.password=tu_contraseña
      spring.jpa.hibernate.ddl-auto=update
      ```

3. Construye y ejecuta la aplicación:

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

## Uso

### Menú Principal

Al ejecutar la aplicación, se mostrará el siguiente menú:

1 - Busca tu libro favorito
2 - Revisa tus libros buscados
3 - Autores que has buscado
4 - Buscar autores con vida de un año
5 - Busca libros por idioma
0 - Salir

### Funcionalidades

1. **Busca tu libro favorito**: Permite buscar un libro por su título y registrarlo en la base de datos.
2. **Revisa tus libros buscados**: Muestra todos los libros registrados.
3. **Autores que has buscado**: Lista todos los autores registrados.
4. **Buscar autores con vida de un año**: Permite buscar autores que estaban vivos en un año específico.
5. **Busca libros por idioma**: Permite buscar libros por su idioma.

### Ejemplos de Uso

#### Buscar un Libro por Título

- Selecciona la opción `1` en el menú principal.
- Ingresa el título del libro que deseas buscar.

#### Buscar Autores Vivos en un Año Específico

- Selecciona la opción `4` en el menú principal.
- Ingresa el año en el cual deseas buscar autores vivos.

## Contribución

¡Contribuciones son bienvenidas! Por favor, sigue los siguientes pasos para contribuir:

1. Haz un fork del proyecto.
2. Crea una nueva rama (`git checkout -b feature/nueva-caracteristica`).
3. Realiza tus cambios y haz commit (`git commit -am 'Añadir nueva característica'`).
4. Haz push a la rama (`git push origin feature/nueva-caracteristica`).
5. Crea un nuevo Pull Request.

## Contacto

Para cualquier consulta o sugerencia, por favor contacta a:

- **Nombre del Desarrollador**: Rafael Gelvez
- **Email**: rafael.gelvezc@hotmail.com
- **GitHub**: [RafaelGelvezC](https://github.com/RafaelGelvezC)
