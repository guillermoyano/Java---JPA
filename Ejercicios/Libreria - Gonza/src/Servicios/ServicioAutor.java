package Servicios;

import Entidades.Autor;
import Persistencia.AutorJpaController;
import Persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Tonna/SA FR34K
 */
/**/
public class ServicioAutor {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ControladoraPersistencia cp = new ControladoraPersistencia();
    AutorJpaController aut = new AutorJpaController();

    public void SubMenuAutores() throws Exception {
        int opc;
        do {
            System.out.println("-----------------------------------Autores--------------------------------------");
            System.out.println("------------------------------ ELIGE LA OPCION----------------------------------");
            System.out.println("1 - Ingresar un Autor");
            System.out.println("2 - Eliminar un Autor");
            System.out.println("3 - Editar un Autor");
            System.out.println("4 - Mostrar todos los Autores");
            System.out.println("5 - Mostar un Autor");
            System.out.println("0 - VOLVER");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    CrearAutorNuevo();
                    break;
                case 2:
                    EliminarAutor();
                    break;
                case 3:
                    ModificarAutor();
                    break;
                case 4:
                    MostrarAutores();
                    break;
                case 5:
                    MostrarunAutor();
                    break;
                case 0:
                    opc = 0;
                    break;
                default:
                    System.out.println("La opcion elegida es invalida");
            }
        } while (opc != 0);

    }

    public void CrearAutorNuevo() {
        Autor a1 = new Autor();
        System.out.println("Ingrese el Nombre del Autor: ");
        a1.setNombre(leer.next());
        System.out.println("El Autor esta dado de Alta (S/N)");
        String opcion = leer.next();
        if (opcion.equalsIgnoreCase("s")) {
            a1.setAlta(true);
        } else {
            a1.setAlta(false);
        }
        cp.CrearAutor(a1);
    }

    public void EliminarAutor() {
        MostrarAutores();
        System.out.println("Ingrese el codigo Id del Autor a eliminar: ");
        int id = leer.nextInt();
        Autor autor = aut.findAutor(id);
        if (autor != null) {
            cp.EliminarAutor(id);
        } else {
            System.out.println("El id del autor no se encuentra en la lista");
        }

    }

    public void ModificarAutor() {
        MostrarAutores();
        System.out.println("Ingrese el codigo Id del Autor a editar: ");
        int id = leer.nextInt();
        Autor autor = aut.findAutor(id);
        if (autor != null) {
            int opc;
            System.out.println("---------------------------------Editar Autor------------------------------------");
            System.out.println("1 - Editar nombre");
            System.out.println("2 - Editar alta");
            System.out.println("Ingrese su opcion: ");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("Ingrese nuevo nombre: ");
                    autor.setNombre(leer.next());
                    break;
                case 2:
                    System.out.println("Nueva opcion de alta(S/N)");
                    String opcion = leer.next();
                    if (opcion.equalsIgnoreCase("s")) {
                        autor.setAlta(true);
                    } else {
                        autor.setAlta(false);
                    }
                    break;
                default:
                    System.out.println("La opcion elegida es invalida");
            }
            cp.EditarAutor(autor);
        } else {
            System.out.println("El id del Autor no se encuentra en la lista...");
        }

    }

    public void MostrarAutores() {
        cp.MostrarAutores();
    }

    public void MostrarunAutor() {
        System.out.println("Ingrese el codigo Id del Autor a mostar: ");
        int id = leer.nextInt();
        Autor autor = cp.MostrarunAutor(id);
        if (autor != null) {
            System.out.println(cp.MostrarunAutor(id));
        } else {
            System.out.println("El id del autor no se encuentra en la lista");
        }

    }

    public void MostarAutorpornombre() {
        List<Autor> aut1 = aut.findAutorEntities();
        ArrayList<Autor> listaAutores = new ArrayList<>(aut1);
        int contador = 0;
        System.out.println("Ingrese el nombre del autor: ");
        String autor = leer.next();
        for (Autor aux : listaAutores) {
            if (aux.getNombre().equalsIgnoreCase(autor)) {
                System.out.println(aux.toString());
                contador++;
            }
        }
        if (contador == 0) {
            System.out.println("Ese autor no existe en la lista");
        }
    }
    
    public void buscarunautor(){
        int a=0;
        do{
        try{
        System.out.println("Ingrese nombre");
        String nombre = leer.next();
        Autor autor = aut.buscarPornombre(nombre);
        if(autor!=null){
            System.out.println(autor);
            a=1;
        }
        }catch (Exception e){
            System.out.println("Ese autor no existe o el nombre esta mal ingresado");
        leer.nextLine();
        }
        }while(a!=1);
    }
}
