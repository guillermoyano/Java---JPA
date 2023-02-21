package libreria_clase.Servicio;

import java.util.List;
import java.util.Scanner;
import libreria_clase.AutorJpaController;
import libreria_clase.ControladorPersistencia;
import libreria_clase.Entidades.Autor;
import libreria_clase.Entidades.Libro;
import libreria_clase.LibroJpaController;

public class AutorServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    Autor a = new Autor();
    ControladorPersistencia control = new ControladorPersistencia();
    AutorJpaController ajc = new AutorJpaController();
    LibroJpaController ljc = new LibroJpaController();

    public void mostrarAutores() {

        List<Autor> boluditos = ajc.findAutorEntities();
        for (Autor aux : boluditos) {
            System.out.println(aux.toString());
        }
    }

    public int buscarAutorPorNombre() {

        try {
            System.out.println("Ingrese el nombre del autor que quiere buscar");
            String nombre = leer.next();
            int aidi = 0, cont = 0;
            List<Autor> boluditos = ajc.findAutorEntities();
            for (Autor aux : boluditos) {
                if (aux.getNombre().equalsIgnoreCase(nombre)) {
                    aidi = aux.getId();
                }
                cont++;
            }
            if (cont == 0) {
                System.out.println("Ese webón no está en la lista");
            }
            return aidi;
        } catch (Exception e) {
            throw e;
        }
    }

    public void menuNumero3() {

        try {
            System.out.println("Ingrese el nombre del autor que quiere buscar");
            String nombre = leer.next();
            List<Autor> boluditos = ajc.findAutorEntities();
            List<Libro> librito = ljc.findLibroEntities();
            int cont = 0;
            int codigo=0;
            for (Autor aux : boluditos) {
                if (aux.getNombre().contains(nombre)) {
                    System.out.println("Se encontró el autor " +aux.getNombre());
                    codigo = aux.getId();
                    cont++;
                }
            }
            if (cont == 0) {
                System.out.println("Ese webón no está en la lista");
            }else if(cont !=0){
                for (Libro aux  : librito) {
                    if (aux.getAutor().getId().equals(codigo)){
                        System.out.println("El ISBN del libro es: "+aux.getIsbn()+". El título del libro es: "+aux.getTitulo()+". Quedan en stock actualmente: "+aux.getEjemplaresRestantes()+" ejemplares");
                    }
                }
            }
            
        } catch (Exception e) {
            throw e;
        }
    }
    
}
