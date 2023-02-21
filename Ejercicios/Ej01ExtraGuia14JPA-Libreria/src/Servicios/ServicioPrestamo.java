package Servicios;

import Entidades.Cliente;
import Entidades.Libro;
import Entidades.Prestamo;
import Persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Tonna/SA FR34K
 */
/**/
public class ServicioPrestamo {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    ControladoraPersistencia cp = new ControladoraPersistencia();

    public void SubMenuPrestamos() throws Exception {
        int opc;
        do {
            System.out.println("----------------------------------Prestamos--------------------------------------");
            System.out.println("------------------------------ ELIGE LA OPCION----------------------------------");
            System.out.println("1 - Ingresar un prestamo");
            System.out.println("2 - Eliminar un prestamo");
            System.out.println("3 - Editar un prestamo");
            System.out.println("4 - Mostrar todos los prestamos");
            System.out.println("5 - Mostrar un prestamo");
            System.out.println("6 - Mostrar todos los prestamos de un cliente");
            System.out.println("7 - Devolucion de un prestamo");
            System.out.println("0 - VOLVER");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    CrearPrestamoNuevo();
                    break;
                case 2:
                    EliminarPrestamo();
                    break;
                case 3:
                    ModificarPrestamo();
                    break;
                case 4:
                    MostrarPrestamos();
                    break;
                case 5:
                    MostrarunPrestamo();
                    break;
                case 6:
                    PrestamosdeunCliente();
                    break;
                case 7:
                    DevolucionPrestamo();
                case 0:
                    opc = 0;
                    break;
                default:
                    System.out.println("La opcion elegida es invalida");
            }
        } while (opc != 0);
    }

    public void CrearPrestamoNuevo() {
        int opcion1, cont = 0;
        Prestamo p1 = new Prestamo();
        System.out.println("Ingrese la fecha de inicio del prestamo: ");
        System.out.println("Ingrese el dia: ");
        int dia = leer.nextInt();
        System.out.println("Ingrese el mes: ");
        int mes = leer.nextInt();
        System.out.println("Ingrese el año: ");
        int anio = leer.nextInt();
        Date fechainicio = new java.sql.Date(anio - 1900, mes - 1, dia);
        p1.setFechaprestamo(fechainicio);
        System.out.println("Ingrese la fecha de final del prestamo: ");
        System.out.println("Ingrese el dia: ");
        int dia1 = leer.nextInt();
        System.out.println("Ingrese el mes: ");
        int mes1 = leer.nextInt();
        System.out.println("Ingrese el año: ");
        int anio1 = leer.nextInt();
        Date fechafinal = new java.sql.Date(anio1 - 1900, mes1 - 1, dia1);
        p1.setFechadevolucion(fechafinal);
        cp.MostrarLibros();
        System.out.println("Ingrese el isbn del libro a prestar: ");
        Long isbn = leer.nextLong();
        Libro libro = cp.MostrarunLibro(isbn);
        if (libro != null) {
            p1.setLibro(libro);
        } else {
            System.out.println("Ese isbn no esta el la lista de libros");
            cont++;
        }
        cp.MostrarClientes();
        System.out.println("Ingrese el id del cliente, para el prestamo: ");
        int id = leer.nextInt();
        Cliente cliente = cp.MostrarunCliente(id);
        if (cliente != null) {
            p1.setCliente(cliente);
        } else {
            System.out.println("Ese id no se encuentra en la lista de Clientes");
            cont++;
        }
        if (cont == 0) {
            cp.CrearPrestamo(p1);
        } else {
            System.out.println("Alguno de los datos esta incompleto");
        }
    }

    public void EliminarPrestamo() {
        MostrarPrestamos();
        System.out.println("Ingrese el codigo Id del prestamo a eliminar: ");
        int id = leer.nextInt();
        Prestamo prestamo = cp.MostrarunPrestamo(id);
        if (prestamo != null) {
            cp.EliminarPrestamo(id);
        } else {
            System.out.println("El id del prestamo no se encuentra en la lista");
        }
    }

    public void ModificarPrestamo() {
        MostrarPrestamos();
        System.out.println("Ingrese el codigo Id del prestamo a editar: ");
        int id = leer.nextInt();
        Prestamo prestamo = cp.MostrarunPrestamo(id);
        if (prestamo != null) {
            int opc;
            System.out.println("---------------------------------Editar Editorial------------------------------------");
            System.out.println("1 - Editar fecha de inicio");
            System.out.println("2 - Editar fecha de devolucion");
            System.out.println("3 - Editar Libro a prestar");
            System.out.println("4 - Editar cliente que se lleva el libro");
            System.out.println("Ingrese su opcion: ");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("Ingrese la nuevo fecha de inicio del prestamo: ");
                    System.out.println("Ingrese el dia: ");
                    int dia = leer.nextInt();
                    System.out.println("Ingrese el mes: ");
                    int mes = leer.nextInt();
                    System.out.println("Ingrese el año: ");
                    int anio = leer.nextInt();
                    Date fechainicio = new Date(anio - 1900, mes - 1, dia);
                    prestamo.setFechaprestamo(fechainicio);
                    break;
                case 2:
                    System.out.println("Ingrese la nueva fecha de final del prestamo: ");
                    System.out.println("Ingrese el dia: ");
                    int dia1 = leer.nextInt();
                    System.out.println("Ingrese el mes: ");
                    int mes1 = leer.nextInt();
                    System.out.println("Ingrese el año: ");
                    int anio1 = leer.nextInt();
                    Date fechafinal = new Date(anio1 - 1900, mes1 - 1, dia1);
                    prestamo.setFechadevolucion(fechafinal);
                    break;
                case 3:
                    cp.MostrarLibros();
                    System.out.println("Ingrese el nuevo isbn del libro a prestar: ");
                    Long isbn1 = leer.nextLong();
                    Libro libro = cp.MostrarunLibro(isbn1);
                    if (libro != null) {
                        prestamo.setLibro(libro);
                        libro.setEjemplaresprestados(libro.getEjemplaresprestados()+1);
                        libro.setEjemplaresrestantes(libro.getEjemplaresrestantes()-1);
                        cp.EditarLibro(libro);
                    } else {
                        System.out.println("Ese isbn no esta el la lista de libros");
                    }
                    break;
                case 4:
                    cp.MostrarClientes();
                    System.out.println("Ingrese el id del cliente, para el prestamo: ");
                    int id1 = leer.nextInt();
                    Cliente cliente = cp.MostrarunCliente(id);
                    if (cliente != null) {
                        prestamo.setCliente(cliente);
                    } else {
                        System.out.println("Ese id no se encuentra en la lista de Clientes");
                    }
                    break;
                default:
                    System.out.println("La opcion elegida es invalida");
            }
            cp.EditarPrestamo(prestamo);
        } else {
            System.out.println("El id del prestamo no se encuentra en la lista...");
        }
    }

    public void MostrarPrestamos() {
        cp.MostrarPrestamos();
    }

    public void MostrarunPrestamo() {
        System.out.println("Ingrese el codigo Id del prestamo a mostar: ");
        int id = leer.nextInt();
        Prestamo prestamo = cp.MostrarunPrestamo(id);
        if (prestamo != null) {
            System.out.println(cp.MostrarunPrestamo(id));
        } else {
            System.out.println("El id del prestamo no se encuentra en la lista");
        }
    }
    
    public void DevolucionPrestamo(){
        MostrarPrestamos();
        System.out.println("Ingresar el id del prestamo a eliminar: ");
        int id = leer.nextInt();
        Long isbn;
        Prestamo prestamo = cp.MostrarunPrestamo(id);
        if(prestamo!=null){
            isbn = prestamo.getLibro().getIsbn();
            Libro libro = cp.MostrarunLibro(isbn);
            libro.setEjemplaresprestados(libro.getEjemplaresprestados()-1);
            libro.setEjemplaresrestantes(libro.getEjemplaresrestantes()+1);
            cp.EditarLibro(libro);
            cp.EliminarPrestamo(id);
        }else{
            System.out.println("El id no se encuentra en la lista");
        }
    }
    
    public void PrestamosdeunCliente(){
        cp.MostrarClientes();
        System.out.println("Ingrese el id del cliente para mostrar sus prestamos: ");
        int id = leer.nextInt();
        Cliente cliente = cp.MostrarunCliente(id);
        if(cliente!=null){
            List<Prestamo> list = cp.MostrarPrestamos();
            ArrayList<Prestamo> presta = new ArrayList<> (list);
            for (Prestamo aux : presta) {
                if(aux.getCliente().getId().equals(id)){
                    System.out.println(aux.toString());
                }
            }
        }
        
    }
}
