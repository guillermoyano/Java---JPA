package Servicios;

import Entidades.Editorial;
import Persistencia.ControladoraPersistencia;
import java.util.Scanner;

/**
 *
 * @author Tonna/SA FR34K
 */
/**/
public class ServicioEditorial {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    ControladoraPersistencia cp = new ControladoraPersistencia();

    public void SubMenuEditoriales() throws Exception {
        int opc;
        do {
            System.out.println("----------------------------------Editoriales--------------------------------------");
            System.out.println("------------------------------ ELIGE LA OPCION----------------------------------");
            System.out.println("1 - Ingresar una Editorial");
            System.out.println("2 - Eliminar una Editorial");
            System.out.println("3 - Editar una Editorial");
            System.out.println("4 - Mostrar todas las Editoriales");
            System.out.println("5 - Mostrar una Editorial");
            System.out.println("0 - VOLVER");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    CearEditorialNuevo();
                    break;
                case 2:
                    EliminarEditorial();
                    break;
                case 3:
                    ModificarEditorial();
                    break;
                case 4:
                    MostrarEditoriales();
                    break;
                case 5:
                    MostrarunEditorial();
                    break;
                case 0:
                    opc = 0;
                    break;
                default:
                    System.out.println("La opcion elegida es invalida");
            }
        } while (opc != 0);
    }

    public void CearEditorialNuevo() {
        int opcion1;
        Editorial e1 = new Editorial();
        System.out.println("Ingrese el nombre de la Editorial del Libro: ");
        e1.setNombre(leer.next());
        System.out.println("La Editorial esta dada de Alta (S/N)");
        String opcion = leer.next();
        if (opcion.equalsIgnoreCase("s")) {
            e1.setAlta(true);
        } else {
            e1.setAlta(false);
        }
        cp.CrearEditorial(e1);
    }

    public void EliminarEditorial() {
        MostrarEditoriales();
        System.out.println("Ingrese el codigo Id de la Editorial a eliminar: ");
        int id = leer.nextInt();
        Editorial editorial = cp.MostrarunEditorial(id);
        if (editorial != null) {
            cp.EliminarEditorial(id);
        } else {
            System.out.println("El id de la Editorial no se encuentra en la lista");
        }
    }

    public void ModificarEditorial() {
        MostrarEditoriales();
        System.out.println("Ingrese el codigo Id de la Editorial a editar: ");
        int id = leer.nextInt();
        Editorial editorial = cp.MostrarunEditorial(id);
        if (editorial != null) {
            int opc;
            System.out.println("---------------------------------Editar Editorial------------------------------------");
            System.out.println("1 - Editar nombre");
            System.out.println("2 - Editar alta");
            System.out.println("Ingrese su opcion: ");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("Ingrese nuevo nombre: ");
                    editorial.setNombre(leer.next());
                    break;
                case 2:
                    System.out.println("Nueva opcion de alta(S/N)");
                    String opcion = leer.next();
                    if (opcion.equalsIgnoreCase("s")) {
                        editorial.setAlta(true);
                    } else {
                        editorial.setAlta(false);
                    }
                    break;
                default:
                    System.out.println("La opcion elegida es invalida");
            }
            cp.EditarEditorial(editorial);
        } else {
            System.out.println("El id de la Editorial no se encuentra en la lista...");
        }
    }

    public void MostrarEditoriales() {
        cp.MostrarEditoriales();
    }

    public void MostrarunEditorial() {
        System.out.println("Ingrese el codigo Id del Autor a mostar: ");
        int id = leer.nextInt();
        Editorial editorial = cp.MostrarunEditorial(id);
        if (editorial != null) {
            System.out.println(cp.MostrarunEditorial(id));
        } else {
            System.out.println("El id de la Editorial no se encuentra en la lista");
        }
    }
}
