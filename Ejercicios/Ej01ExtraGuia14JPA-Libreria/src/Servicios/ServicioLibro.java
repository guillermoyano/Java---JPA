package Servicios;

import Entidades.Autor;
import Entidades.Editorial;
import Entidades.Libro;
import Persistencia.AutorJpaController;
import Persistencia.ControladoraPersistencia;
import Persistencia.EditorialJpaController;
import Persistencia.LibroJpaController;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Tonna/SA FR34K
 */
/**/
public class ServicioLibro {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ControladoraPersistencia cp = new ControladoraPersistencia();
    LibroJpaController li = new LibroJpaController();
    AutorJpaController au = new AutorJpaController();
    EditorialJpaController ed = new EditorialJpaController();

    public void SubMenuLibros() throws NonexistentEntityException, Exception {
        int opc;
        do {
            System.out.println("------------------------------------Libros--------------------------------------");
            System.out.println("------------------------------ ELIGE LA OPCION----------------------------------");
            System.out.println("1 - Ingresar un Libro");
            System.out.println("2 - Eliminar un Libro");
            System.out.println("3 - Editar un Libro");
            System.out.println("4 - Mostrar todos los Libros");
            System.out.println("5 - Mostar un Libro");
            System.out.println("0 - VOLVER");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    CrearLibroNuevo();
                    break;
                case 2:
                    EliminarLibro();
                    break;
                case 3:
                    ModificarLibro();
                    break;
                case 4:
                    MostrarLibros();
                    break;
                case 5:
                    MostrarunLibro();
                    break;
                case 0:
                    opc = 0;
                    break;
                default:
                    System.out.println("La opcion elegida es invalida");
            }
        } while (opc != 0);

    }

    public void CrearLibroNuevo() {
        int opcion1, opcion2;
        Libro l1 = new Libro();
        System.out.println("Ingrese el Titulo del Libro: ");
        l1.setTitulo(leer.next());
        System.out.println("Ingrese el año del Libro: ");
        l1.setAnio(leer.nextInt());
        System.out.println("Ingrese la cantidad de ejemplares: ");
        l1.setCantidadejemplares(leer.nextInt());
        System.out.println("Ingrese la cantidad de ejemplares prestados: ");
        l1.setEjemplaresprestados(leer.nextInt());
        l1.setEjemplaresrestantes(l1.getCantidadejemplares() - l1.getEjemplaresprestados());
        System.out.println("El libro esta dado de Alta (S/N)");
        String opcion = leer.next();
        if (opcion.equalsIgnoreCase("s")) {
            l1.setAlta(true);
        } else {
            l1.setAlta(false);
        }
        System.out.println("Ingrese el Autor del Libro");
        System.out.println("1- Elija un Autor de la Lista");
        System.out.println("2- Crear un nuevo Autor");
        System.out.println("Elegir opcion: ");
        opcion1 = leer.nextInt();
        do {
            switch (opcion1) {
                case 1:
                    cp.MostrarAutores();
                    System.out.println("Ingrese el id del Autor");
                    int autor = leer.nextInt();
                    l1.setAutor(au.findAutor(autor));
                    opcion1 = 10;
                    break;
                case 2:
                    Autor a1 = new Autor();
                    System.out.println("Ingrese el nombre del Autor");
                    a1.setNombre(leer.next());
                    System.out.println("El Autor esta dado de Alta (S/N)");
                    String autoropcion = leer.next();
                    if (autoropcion.equalsIgnoreCase("s")) {
                        a1.setAlta(true);
                    } else {
                        a1.setAlta(false);
                    }
                    cp.CrearAutor(a1);
                    l1.setAutor(a1);
                    opcion1 = 10;
                    break;
                default:
                    System.out.println("Esa opcion es invalida");
                    opcion1 = leer.nextInt();
            }
        } while (opcion1 == 10);
        System.out.println("Ingrese la Editorial del Libro");
        System.out.println("1- Elija una Editorial de la Lista");
        System.out.println("2- Crear una nueva Editorial");
        System.out.println("Elegir opcion: ");
        opcion2 = leer.nextInt();
        do {
            switch (opcion2) {
                case 1:
                    cp.MostrarEditoriales();
                    System.out.println("Ingrese el id de la Editorial");
                    int editorial = leer.nextInt();
                    l1.setEditorial(ed.findEditorial(editorial));
                    opcion1 = 10;
                    break;
                case 2:
                    Editorial e1 = new Editorial();
                    System.out.println("Ingrese el nombre de la Editorial");
                    e1.setNombre(leer.next());
                    System.out.println("La Editorial esta dada de Alta (S/N)");
                    String autoropcion = leer.next();
                    if (autoropcion.equalsIgnoreCase("s")) {
                        e1.setAlta(true);
                    } else {
                        e1.setAlta(false);
                    }
                    cp.CrearEditorial(e1);
                    l1.setEditorial(e1);
                    opcion1 = 10;
                    break;
                default:
                    System.out.println("Esa opcion es invalida");
                    opcion1 = leer.nextInt();
            }
        } while (opcion1 == 10);
        cp.CrearLibro(l1);
    }

    public void EliminarLibro() {
        MostrarLibros();
        System.out.println("Ingrese el codigo isbn del Libro a eliminar: ");
        Long isbn = leer.nextLong();
        Libro libro = li.findLibro(isbn);
        if (libro != null) {
            cp.EliminarLibro(isbn);
        } else {
            System.out.println("El isbn del libro no se encuentra en la lista");
        }
    }

    public void ModificarLibro() {
        MostrarLibros();
        System.out.println("Ingrese el codigo Isbn del libro a editar: ");
        Long isbn = leer.nextLong();
        Libro libro = li.findLibro(isbn);
        if (libro != null) {
            int opc;
            System.out.println("---------------------------------Editar Libro------------------------------------");
            System.out.println("1 - Editar nombre");
            System.out.println("2 - Editar año");
            System.out.println("3 - Editar cantidad de ejemplares");
            System.out.println("4 - Editar cantidad de ejemplares prestados");
            System.out.println("5 - Editar alta");
            System.out.println("6 - Editar autor del libro");
            System.out.println("7 - Editar editorial del libro");
            System.out.println("Ingrese su opcion: ");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("Ingrese nuevo nombre: ");
                    libro.setTitulo(leer.next());
                    break;
                case 2:
                    System.out.println("Ingrese el nuevo año: ");
                    libro.setAnio(leer.nextInt());
                    break;
                case 3:
                    System.out.println("Ingrese la nueva cantidad de ejemplares: ");
                    libro.setCantidadejemplares(leer.nextInt());
                    libro.setEjemplaresrestantes(libro.getCantidadejemplares() - libro.getEjemplaresprestados());
                    break;
                case 4:
                    System.out.println("Ingrese la nueva cantidad de ejemplares prestados: ");
                    libro.setEjemplaresprestados(leer.nextInt());
                    libro.setEjemplaresrestantes(libro.getCantidadejemplares() - libro.getEjemplaresprestados());
                    break;
                case 5:
                    System.out.println("Nueva opcion de alta(S/N)");
                    String opcion = leer.next();
                    if (opcion.equalsIgnoreCase("s")) {
                        libro.setAlta(true);
                    } else {
                        libro.setAlta(false);
                    }
                    break;
                case 6:
                    int opcion1;
                    System.out.println("Ingrese el Autor del Libro");
                    System.out.println("1- Elija un Autor de la Lista");
                    System.out.println("2- Crear un nuevo Autor");
                    System.out.println("Elegir opcion: ");
                    opcion1 = leer.nextInt();
                    do {
                        switch (opcion1) {
                            case 1:
                                cp.MostrarAutores();
                                System.out.println("Ingrese el id del Autor");
                                int autor = leer.nextInt();
                                libro.setAutor(au.findAutor(autor));
                                opcion1 = 10;
                                break;
                            case 2:
                                Autor a1 = new Autor();
                                System.out.println("Ingrese el nombre del Autor");
                                a1.setNombre(leer.next());
                                System.out.println("El Autor esta dado de Alta (S/N)");
                                String autoropcion = leer.next();
                                if (autoropcion.equalsIgnoreCase("s")) {
                                    a1.setAlta(true);
                                } else {
                                    a1.setAlta(false);
                                }
                                cp.CrearAutor(a1);
                                libro.setAutor(a1);
                                opcion1 = 10;
                                break;
                            default:
                                System.out.println("Esa opcion es invalida");
                                opcion1 = leer.nextInt();
                        }
                    } while (opcion1 == 10);
                    break;
                case 7:
                    int opcion2;
                    System.out.println("Ingrese la Editorial del Libro");
                    System.out.println("1- Elija una Editorial de la Lista");
                    System.out.println("2- Crear una nueva Editorial");
                    System.out.println("Elegir opcion: ");
                    opcion2 = leer.nextInt();
                    do {
                        switch (opcion2) {
                            case 1:
                                cp.MostrarEditoriales();
                                System.out.println("Ingrese el id de la Editorial");
                                int editorial = leer.nextInt();
                                libro.setEditorial(ed.findEditorial(editorial));
                                opcion1 = 10;
                                break;
                            case 2:
                                Editorial e1 = new Editorial();
                                System.out.println("Ingrese el nombre de la Editorial");
                                e1.setNombre(leer.next());
                                System.out.println("La Editorial esta dada de Alta (S/N)");
                                String autoropcion = leer.next();
                                if (autoropcion.equalsIgnoreCase("s")) {
                                    e1.setAlta(true);
                                } else {
                                    e1.setAlta(false);
                                }
                                cp.CrearEditorial(e1);
                                libro.setEditorial(e1);
                                opcion1 = 10;
                                break;
                            default:
                                System.out.println("Esa opcion es invalida");
                                opcion1 = leer.nextInt();
                        }
                    } while (opcion1 == 10);
                    break;
                default:
                    System.out.println("La opcion elegida es invalida");
            }
            cp.EditarLibro(libro);
        } else {
            System.out.println("El isbn del libro no esta en la lista");
        }
    }

    public void MostrarLibros() {
        cp.MostrarLibros();
    }

    public void MostrarunLibro() {
        System.out.println("Ingrese el codigo ISBN del Libro a mostar: ");
        Long isbn = leer.nextLong();
        Libro libro = cp.MostrarunLibro(isbn);
        if (libro != null) {
            System.out.println(cp.MostrarunLibro(isbn));
        } else {
            System.out.println("El isbn del libro no se encuentra en la lista");
        }

    }

    public void BusquedadeLibroportitulo() {
        List<Libro> lib1 = cp.MostrarLibros();
        ArrayList<Libro> lib = new ArrayList<>(lib1);
        System.out.println("Ingrese el titulo del libro: ");
        String titulo = leer.next();
        int cont = 0;
        for (Libro aux : lib) {
            if (aux.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println(aux.toString());
                cont++;
            }
        }
        if (cont == 0) {
            System.out.println("El titulo que ingreso no se encuentra en la lista");
        }
    }
    
    public void BusquedaLibrosporAutor(){
        List<Autor> autor = cp.MostrarAutores();
        ArrayList<Autor> aut = new ArrayList<>(autor);
        System.out.println("Ingrese el nombre del Autor: ");
        String nombre = leer.next();
        int codigo=0, cont=0;
        for (Autor aux : aut) {
            if(aux.getNombre().equalsIgnoreCase(nombre)){
                codigo=aux.getId();
                cont++;
            }
            
        }
        if(cont==0){
            System.out.println("El autor no se encuentra en la lista");
        }
        List<Libro> lib1 = cp.MostrarLibros();
        ArrayList<Libro> lib = new ArrayList<>(lib1);
        int cont1 = 0;
        for (Libro aux : lib) {
            if (aux.getAutor().getId().equals(codigo)){
                System.out.println(aux.toString());
                cont++;
            }
        }
        if (cont == 0) {
            System.out.println("Ese autor no se encuentra en la lista");
        }
    }
    
    public void BusquedaLibrosporEditorial(){
        List<Editorial> editorial = cp.MostrarEditoriales();
        ArrayList<Editorial> edi = new ArrayList<>(editorial);
        for (Editorial aux : edi) {
            System.out.println(aux.toString());
        }
        cp.MostrarEditoriales();
        System.out.println("Ingrese el nombre de la Editorial: ");
        String nombre = leer.next();
        int codigo=0, cont=0;
        for (Editorial aux : edi) {
            if(aux.getNombre().equalsIgnoreCase(nombre)){
                codigo=aux.getId();
                cont++;
            }
            
        }
        if(cont==0){
            System.out.println("La Editorial no se encuentra en la lista");
        }
        List<Libro> lib1 = cp.MostrarLibros();
        ArrayList<Libro> lib = new ArrayList<>(lib1);
        int cont1 = 0;
        for (Libro aux : lib) {
            if (aux.getEditorial().getId().equals(codigo)){
                System.out.println(aux.toString());
                cont++;
            }
        }
        if (cont == 0) {
            System.out.println("Esa Editorial no se encuentra en la lista");
        }
    }
}
