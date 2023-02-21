package libreria_clase.Servicio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import libreria_clase.ClienteJpaController;
import libreria_clase.ControladorPersistencia;
import libreria_clase.Entidades.Cliente;
import libreria_clase.Entidades.Libro;
import libreria_clase.Entidades.Prestamo;
import libreria_clase.LibroJpaController;
import libreria_clase.PrestamoJpaController;
import libreria_clase.exceptions.NonexistentEntityException;

public class PrestamoServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    LibroJpaController ljc = new LibroJpaController();
    ClienteJpaController cjc = new ClienteJpaController();
    PrestamoJpaController pjc = new PrestamoJpaController();
    ClienteServicio cs = new ClienteServicio();
    AutorServicio as = new AutorServicio();
    LibroServicio ls = new LibroServicio();
    Libro l = new Libro();
    ControladorPersistencia cp = new ControladorPersistencia();

    public void prestaditos() throws Exception {
        int opcion = 0;
        do {
            System.out.println("\tMenu ");
            System.out.println("1 - Buscar listado de libros");
            System.out.println("2 - Pedir prestado un libro");
            System.out.println("3 - Devolver un libro que le prestamos");
            System.out.println("4 - Ver Libros Prestados ");
            System.out.println("5 - Salir");
            System.out.println("Elija su opcion:");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    buscarLibro();
                    break;
                case 2:
                    prestarLibro();
                    break;
                case 3:
                    devolverLibro();
                    break;
                case 4:
                    verPrestados();
                    break;
                case 5:
                    System.out.println("Hasta Luego...");
                    break;
                default:
                    System.out.println("Esa no es una opcion valida, vuelva a intentar...");
                    break;
            }
        } while (!(opcion == 5));
    }

    public void buscarLibro() {

        try {
            cs.verificarDNI();
            int opc = 0;
            do {
                System.out.println("-------- ELIGE LA OPCION-------");
                System.out.println("1- Buscar el libro por su título");
                System.out.println("2- Buscar el libro por su autor");
                System.out.println("3- Buscar el libro por ISBN");
                System.out.println("4-SALIR");
                opc = leer.nextInt();
                switch (opc) {
                    case 1:
                        ls.buscarLibroPorTitulo();
                        break;
                    case 2:
                        as.menuNumero3();
                        break;
                    case 3:
                        ls.buscarLibroISBN();
                        break;
                    case 4:
                        opc = 0;
                        break;
                    default:
                        System.out.println("La opcion elegida es invalida");
                }
            } while (opc != 0);

        } catch (Exception e) {
            throw e;
        }

    }

    public void prestarLibro() {

        List<Libro> libroncho = ljc.findLibroEntities();
        System.out.println("Ingrese el número de ISBN del libro elegido");
        Long nume = leer.nextLong();
        Libro librito = null;
        Prestamo p1 = new Prestamo();
        Cliente c1 = new Cliente();
        List<Prestamo> prestadito = pjc.findPrestamoEntities();
        List<Cliente> clientito = cjc.findClienteEntities();
        int rest = 0;
        int sum = 0;
        for (Libro aux : libroncho) {
            if (aux.getIsbn().equals(nume)) {
                librito = ljc.findLibro(nume);
                if (aux.getEjemplaresRestantes() > 0) {
                    System.out.println("Le vamos a prestar el libro elegido (" + aux.getTitulo() + ")");
                    rest = aux.getEjemplaresRestantes() - 1;
                    librito.setEjemplaresRestantes(rest);
                    sum = aux.getEjemplaresPrestados() + 1;
                    librito.setEjemplaresPrestados(sum);

                }
            }
        }
        cs.listaClientes();
        System.out.println("Ingrese el id del cliente que recibira el ejemplar");
        int id = leer.nextInt();
        Cliente cliente = cjc.findCliente(id);
        p1.setCliente(cliente);
        Libro libro = ljc.findLibro(nume);
        p1.setLibro(libro);

        System.out.println("Que fecha pide prestado el libro ? ");
        System.out.println("Mes,Dia,Año");
        int mes = leer.nextInt();
        int dia = leer.nextInt();
        int anio = leer.nextInt();
        Date fecha1 = new java.sql.Date(anio-1900, mes - 1, dia);
        p1.setFechaPrestamo(fecha1);

        System.out.println("Que fecha devuelve el libro ? ");
        System.out.println("Mes,Dia,Año");
        int mes1 = leer.nextInt();
        int dia2 = leer.nextInt();
        int anio2 = leer.nextInt();
        Date fecha2 = new java.sql.Date(anio2-1900, mes1 - 1, dia2);
        p1.setFechaDevolucion(fecha2);
        //new SimpleDateFormat("yyyy-MM-dd").format(fecha2);

        cp.editarLibro(librito);
        pjc.create(p1);

    }

    public void devolverLibro() throws Exception {
        List<Libro> libroncho = ljc.findLibroEntities();
        System.out.println("Ingrese el número de ISBN del libro a devolver");
        Long nume = leer.nextLong();
        Libro librito = null;
        try {
            int rest = 0;
            int sum = 0;
            for (Libro aux : libroncho) {
                if (aux.getIsbn().equals(nume)) {
                    librito = ljc.findLibro(nume);
                    if (aux.getEjemplaresRestantes() > 0) {
                        System.out.println("Va a devolver el libro  (" + aux.getTitulo() + ")");
                        sum = aux.getEjemplaresRestantes() + 1;
                        librito.setEjemplaresRestantes(sum);
                        rest = aux.getEjemplaresPrestados() - 1;
                        librito.setEjemplaresPrestados(rest);
                        cp.editarLibro(librito);
                    }
                }
            }
            System.out.println("Ingrese el numero de id del prestamo ");
            Integer id = leer.nextInt();

            pjc.destroy(id);
        } catch (Exception e) {
            throw e;
        }

    }

    public void verPrestados() {
        try {
            System.out.println("Ingrese el numero de DNI del cliente que quiere buscar ");
            Long numero = leer.nextLong();
            List<Cliente> papucho = cjc.findClienteEntities();
            List<Libro> librito = ljc.findLibroEntities();
            int contador = 0;
            for (Cliente aux : papucho) {
                if (aux.getDocumento().equals(numero)) {
                    System.out.println(aux.getApellido() + ", " + aux.getNombre());
                    contador++;
                }
            }
            if (contador == 0) {
                System.out.println("Ese cliente no tiene libros prestados ");
            }

        } catch (Exception e) {
            throw e;
        }

    }

}
