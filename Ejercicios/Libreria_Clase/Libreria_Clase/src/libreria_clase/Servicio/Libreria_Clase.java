package libreria_clase.Servicio;

import java.util.Scanner;
import libreria_clase.ControladorPersistencia;
import libreria_clase.ControladorPersistencia;
import libreria_clase.Entidades.Autor;
import libreria_clase.Entidades.Editorial;
import libreria_clase.Entidades.Libro;
import libreria_clase.LibroJpaController;

public class Libreria_Clase {

    public static void main(String[] args) throws Exception {

        ControladorPersistencia control = new ControladorPersistencia();
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        menu();

    }

    public static void menu() throws Exception {

        LibroServicio ls = new LibroServicio();
        AutorServicio as = new AutorServicio();
        EditorialServicio es = new EditorialServicio();
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        ControladorPersistencia control = new ControladorPersistencia();
        ClienteServicio cs = new ClienteServicio();
        PrestamoServicio ps = new PrestamoServicio();

        int opc = 0;
        do {
            System.out.println("-------- ELIGE LA OPCION-------");
            System.out.println("1- Listado de los libros disponibles");
            System.out.println("2- Ingresar un libro, un autor y su editorial");
            System.out.println("3- Buscar autor por nombre");
            System.out.println("4- Buscar libro por ISBN");
            System.out.println("5- Buscar libro por título");
            System.out.println("6- Buscar libro por autor");
            System.out.println("7-Buscar libro por editorial");
            System.out.println("8- Ingresar cliente nuevo");
            System.out.println("9- Préstamo y Devolucion de libros");
            System.out.println("10-SALIR");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    control.mostrarLibros();
                    break;
                case 2:
                    ls.ingresarLibros();
                    break;
                case 3:
                    as.menuNumero3();
                    break;
                case 4:
                    ls.buscarLibroISBN();
                    break;
                case 5:
                    ls.buscarPorTitulo();
                    break;
                case 6:
                    ls.buscarLibrosPorAutor();
                    break;
                case 7:
                    ls.buscarLibrosPorEditorial();
                    break;
                case 8:
                    cs.verificarDNI();
                    break;
                case 9:
                    ps.prestaditos();
                case 10:
                    opc = 0;
                    break;
                default:
                    System.out.println("La opcion elegida es invalida");
            }
        } while (opc != 0);
    }

}
