package libreria_clase.Servicio;

import java.util.List;
import java.util.Scanner;
import libreria_clase.EditorialJpaController;
import libreria_clase.Entidades.Autor;
import libreria_clase.Entidades.Editorial;

public class EditorialServicio {

    EditorialJpaController ejc = new EditorialJpaController();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public int buscarEditorialPorNombre() {

        try {
            System.out.println("Ingrese el nombre de la editorial que quiere buscar");
            String nombre = leer.next();
            int aidi = 0, cont = 0;
            List<Editorial> editores = ejc.findEditorialEntities();
            for (Editorial aux : editores) {
                if (aux.getNombre().equalsIgnoreCase(nombre)) {
                    aidi = aux.getId();
                }
                cont++;
            }
            if (cont == 0) {
                System.out.println("Esa editorial no está en la lista");
            }
            return aidi;
        } catch (Exception e) {
            throw e;
        }
    }
    
}
