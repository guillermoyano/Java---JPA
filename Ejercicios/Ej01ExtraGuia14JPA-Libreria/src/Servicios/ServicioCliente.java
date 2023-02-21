
package Servicios;

import Entidades.Cliente;
import Persistencia.ControladoraPersistencia;
import java.util.Scanner;

/**
 *
 * @author Tonna/SA FR34K
 */
/**/
public class ServicioCliente {
 Scanner leer = new Scanner(System.in).useDelimiter("\n");

    ControladoraPersistencia cp = new ControladoraPersistencia();

    public void SubMenuClientes() throws Exception {
        int opc;
        do {
            System.out.println("----------------------------------Clientes--------------------------------------");
            System.out.println("------------------------------ ELIGE LA OPCION----------------------------------");
            System.out.println("1 - Ingresar un Cliente");
            System.out.println("2 - Eliminar un Cliente");
            System.out.println("3 - Editar un Cliente");
            System.out.println("4 - Mostrar todos los Clientes");
            System.out.println("5 - Mostrar una Cliente");
            System.out.println("0 - VOLVER");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    CearClienteNuevo();
                    break;
                case 2:
                    EliminarCliente();
                    break;
                case 3:
                    ModificarCliente();
                    break;
                case 4:
                    MostrarClientes();
                    break;
                case 5:
                    MostrarunCliente();
                    break;
                case 0:
                    opc = 0;
                    break;
                default:
                    System.out.println("La opcion elegida es invalida");
            }
        } while (opc != 0);
    }

    public void CearClienteNuevo() {
        int opcion1;
        Cliente e1 = new Cliente();
        System.out.println("Ingrese el nombre del cliente: ");
        e1.setNombre(leer.next());
        System.out.println("Ingresar el apellido del cliente: ");
        e1.setApellido(leer.next());
        System.out.println("Ingresar el dni del cliente: ");
        e1.setDni(leer.nextLong());
        System.out.println("Ingresar el telefono del cliente: ");
        e1.setTelefono(leer.next());
        cp.CrearCliente(e1);
        System.out.println("Cliente creado...");
    }

    public void EliminarCliente() {
        MostrarClientes();
        System.out.println("Ingrese el codigo Id del Cliente a eliminar: ");
        int id = leer.nextInt();
        Cliente cliente = cp.MostrarunCliente(id);
        if (cliente != null) {
            cp.EliminarCliente(id);
            System.out.println("Cliente eliminado...");
        } else {
            System.out.println("El id del Cliente no se encuentra en la lista");
        }
    }

    public void ModificarCliente() {
        MostrarClientes();
        System.out.println("Ingrese el codigo Id del cliente a editar: ");
        int id = leer.nextInt();
        Cliente cliente = cp.MostrarunCliente(id);
        if (cliente != null) {
            int opc;
            System.out.println("---------------------------------Editar Editorial------------------------------------");
            System.out.println("1 - Editar nombre");
            System.out.println("2 - Editar apellido");
            System.out.println("3 - Editar dni");
            System.out.println("4 - Editar telefono");
            System.out.println("Ingrese su opcion: ");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("Ingrese nuevo nombre: ");
                    cliente.setNombre(leer.next());
                    break;
                case 2:
                    System.out.println("Ingrese nuevo apellido: ");
                    cliente.setApellido(leer.next());
                    break;
                case 3:
                    System.out.println("Ingrese nuevo dni: ");
                    cliente.setDni(leer.nextLong());
                    break;
                case 4:
                    System.out.println("Ingrese nuevo telefono");
                    cliente.setTelefono(leer.next());
                default:
                    System.out.println("La opcion elegida es invalida");
            }
            cp.EditarCliente(cliente);
            System.out.println("Cliente modificado...");
        } else {
            System.out.println("El id del cliente no se encuentra en la lista...");
        }
    }

    public void MostrarClientes() {
        cp.MostrarClientes();
    }

    public void MostrarunCliente() {
        System.out.println("Ingrese el codigo Id del cliente a mostar: ");
        int id = leer.nextInt();
        Cliente cliente = cp.MostrarunCliente(id);
        if (cliente != null) {
            System.out.println(cp.MostrarunCliente(id));
        } else {
            System.out.println("El id del cliente no se encuentra en la lista");
        }
    }
}

