package libreria_clase.Servicio;

import java.util.List;
import java.util.Scanner;
import libreria_clase.AutorJpaController;
import libreria_clase.ControladorPersistencia;
import libreria_clase.EditorialJpaController;
import libreria_clase.Entidades.Autor;
import libreria_clase.Entidades.Editorial;
import libreria_clase.Entidades.Libro;
import libreria_clase.LibroJpaController;

public class LibroServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    Libro l = new Libro();
    AutorServicio as = new AutorServicio();
    Autor a = new Autor();
    Editorial e = new Editorial();
    LibroJpaController ljc = new LibroJpaController();
    AutorJpaController ajc = new AutorJpaController();
    EditorialJpaController ejc = new EditorialJpaController();
    EditorialServicio es = new EditorialServicio();
    ControladorPersistencia control = new ControladorPersistencia();

    public void ingresarLibros() {

        System.out.println("Ingrese el nombre del libro");
        l.setTitulo(leer.next());
        System.out.println("Ingrese el año en que se editó");
        l.setAnio(leer.nextInt());
        System.out.println("Cuántos ejemplares ingresaron en la librería");
        l.setEjemplares(leer.nextInt());
        System.out.println("Cuántos ejemplares están prestados");
        l.setEjemplaresPrestados(leer.nextInt());
        l.setEjemplaresRestantes(l.getEjemplares() - l.getEjemplaresPrestados());
        l.setAlta(true);

        int buscar = as.buscarAutorPorNombre();
        if (buscar == 0) {
            System.out.println("Como el autor no existe en la base de datos deberemos ingresarlo");
            System.out.println("Ingrese el nombre nuevamente");
            a.setNombre(leer.next());
            a.setAlta(true);
            ajc.create(a);
            l.setAutor(a);
        } else {
            l.setAutor(ajc.findAutor(buscar));
        }

        int buscaras = es.buscarEditorialPorNombre();
        if (buscaras == 0) {
            System.out.println("Como la editorial no existe en la base de datos deberemos ingresarla");
            System.out.println("Ingrese el nombre nuevamente");
            e.setNombre(leer.next());
            e.setAlta(true);
            ejc.create(e);
            l.setEditorial(e);
        } else {
            l.setEditorial(ejc.findEditorial(buscaras));
        }

        control.crearLibro(l);

    }

    public void buscarLibroISBN() {
        System.out.println("Ingrese el numero de ISBN del libro");
        Long numero = leer.nextLong();
        Libro librito = ljc.findLibro(numero);
        
        if (librito != null){
            System.out.println(librito);
        }else{
            System.out.println("Ese número de ISBN no existe (y los sabés)");
        }

    }
    
    public void buscarLibroPorTitulo() {
        LibroJpaController libro1 = new LibroJpaController();
        System.out.println("Ingrese el Titulo del Libro");
        String titulo = leer.next();
        try {
            List<Libro> lib1 = libro1.findLibroEntities();
            for (Libro aux : lib1) {
                if (aux.getTitulo().equalsIgnoreCase(titulo)) {
                     System.out.println("El ISBN del libro es: "+aux.getIsbn()+". El título del libro es: "+aux.getTitulo()+". Quedan en stock actualmente: "+aux.getEjemplaresRestantes()+" ejemplares");
                }
            }
        } catch (Exception e) {
            throw e;
        }

    }
      public void buscarPorTitulo() {
        LibroJpaController libro1 = new LibroJpaController();
        System.out.println("Ingrese el Titulo del Libro");
        String titulo = leer.next();
        try {
            List<Libro> lib1 = libro1.findLibroEntities();
            for (Libro aux : lib1) {
                if (aux.getTitulo().equalsIgnoreCase(titulo)) {
                    System.out.println(aux.toString());

                }

            }

        } catch (Exception e) {
            throw e;
        }

    }
       public void buscarLibrosPorAutor() {

        AutorJpaController aut1 = new AutorJpaController();
        System.out.println("Ingrese el Nombre Del Autor");
        String autor = leer.next();
        int cont = 0;
        int codigo = 0;
        try {
            LibroJpaController libro1 = new LibroJpaController();
            List<Libro> lib1 = libro1.findLibroEntities();

            List<Autor> auto2 = aut1.findAutorEntities();
            for (Autor aux : auto2) {
                if (aux.getNombre().equalsIgnoreCase(autor)) {
                    codigo = aux.getId();
                    cont++;
                }

            }
            for (Libro obj : lib1) {
                if (obj.getAutor().getId().equals(codigo)) {
                    System.out.println(obj.toString());

                }
            }
            if (cont == 0) {
                System.out.println("No se encontro el Autor(mentira ta mal hecha la tabla no digas nada SHHHH)");
            }
            System.out.println(cont);
        } catch (Exception e) {
            throw e;

        }
    }
        public void buscarLibrosPorEditorial() {

        EditorialJpaController ed1 = new EditorialJpaController();
        System.out.println("Ingrese el Nombre De la Editorial");
        String editorial = leer.next();
        int cont = 0;
        int codigo = 0;
        try {
            LibroJpaController libro1 = new LibroJpaController();
            List<Libro> lib1 = libro1.findLibroEntities();

            List<Editorial> edi1 = ed1.findEditorialEntities();
            for (Editorial aux : edi1) {
                if (aux.getNombre().equalsIgnoreCase(editorial)) {
                    codigo = aux.getId();
                    cont++;
                }

            }
            for (Libro obj : lib1) {
                if (obj.getEditorial().getId().equals(codigo)) {
                    System.out.println(obj.toString());

                }
            }
            if (cont == 0) {
                System.out.println("No se encontro la editorial (mentira ta mal hecha la tabla no digas nada SHHHH)");
            }
            System.out.println(cont);
        } catch (Exception e) {
            throw e;

        }
    }
}
