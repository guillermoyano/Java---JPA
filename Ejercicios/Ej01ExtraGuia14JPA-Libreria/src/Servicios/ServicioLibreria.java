package Servicios;

import java.util.Scanner;

/**
 *
 * @author Tonna/SA FR34K
 */
/**/
public class ServicioLibreria {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ServicioLibro sl = new ServicioLibro();
    ServicioAutor sa = new ServicioAutor();
    ServicioEditorial se = new ServicioEditorial();
    ServicioCliente sc = new ServicioCliente();
    ServicioPrestamo sp = new ServicioPrestamo();
    
    public void Menu() throws Exception {
        int opc;
        do {
            System.out.println("--------------------------------Menu Libreria------------------------------------");
            System.out.println("------------------------------ ELIGE LA OPCION----------------------------------");
            System.out.println("1 - Libros");
            System.out.println("2 - Autores");
            System.out.println("3 - Editoriales");
            System.out.println("4 - Clientes");
            System.out.println("5 - Prestamos");
            System.out.println("6 - Busqueda de autor por nombre");
            System.out.println("7 - Busqueda de un Libro por ISBN");
            System.out.println("8 - Busqueda de un libro por titulo");
            System.out.println("9 - Busqueda de Libros por nombre de autor");
            System.out.println("10 - Busqueda de Libros por editorial");
            System.out.println("0 - SALIR");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    sl.SubMenuLibros();
                    break;
                case 2:
                    sa.SubMenuAutores();
                    break;
                case 3:
                    se.SubMenuEditoriales();
                    break;
                case 4:
                    sc.SubMenuClientes();
                    break;
                case 5:
                    sp.SubMenuPrestamos();
                    break;
                case 6:
                    sa.MostarAutorpornombre();
                    break;
                case 7:
                    sl.MostrarunLibro();
                    break;
                case 8:
                    sl.BusquedadeLibroportitulo();
                    break;
                case 9:
                    sl.BusquedaLibrosporAutor();
                    break;
                case 10:
                    sl.BusquedaLibrosporEditorial();
                    break;
                case 0:
                    System.out.println("Fin del programa...");
                    opc = 0;
                    break;
                default:
                    System.out.println("La opcion elegida es invalida");
            }
        } while (opc != 0);
    }
}
