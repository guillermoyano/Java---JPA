package libreria_clase.Servicio;

import java.util.List;
import java.util.Scanner;
import libreria_clase.ClienteJpaController;
import libreria_clase.Entidades.Cliente;

public class ClienteServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    Cliente c = new Cliente();
    ClienteJpaController cjc = new ClienteJpaController();

    public void crearCliente() {

        try {
            System.out.println("Ingresar el número de DNI");
            c.setDocumento(leer.nextLong());
            System.out.println("Ingrese su nombre");
            c.setNombre(leer.next());
            System.out.println("Ahora el apellido (si, te lo pido separado porque somos boludos");
            c.setApellido(leer.next());
            System.out.println("Por último, el número de teléfono");
            c.setTelefono(leer.next());
            cjc.create(c);
        } catch (Exception e) {
            throw e;
        }
    }

    public void verificarDNI() {

        try {
            System.out.println("Ingrese el numero de DNI");
            Long numero = leer.nextLong();
            List<Cliente> papucho = cjc.findClienteEntities();
            int contador = 0;
            for (Cliente aux : papucho) {
                if (aux.getDocumento().equals(numero)) {
                    System.out.println("Ese cliente ya existe");
                    System.out.println(aux.getApellido() + ", " + aux.getNombre());
                    contador++;
                }
            }

            if (contador == 0) {
                System.out.println("Vamos a crear a un nuevo cliente porque no está en la base de datos");
                crearCliente();
            }
        } catch (Exception e) {
            throw e;
        }
    }
    public void listaClientes(){
        System.out.println("Ingrese el dni del cliente ");
        Long dni=leer.nextLong();
        List <Cliente> c1 = cjc.findClienteEntities();
        for (Cliente aux : c1) {
            if (aux.getDocumento().equals(dni)) {
                System.out.println("El id del cliente es: "+aux.getId());
                
            }
        }
    }
}
