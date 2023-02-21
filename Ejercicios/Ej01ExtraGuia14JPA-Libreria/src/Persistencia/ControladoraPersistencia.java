package Persistencia;

import Entidades.Autor;
import Entidades.Cliente;
import Entidades.Editorial;
import Entidades.Libro;
import Entidades.Prestamo;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tonna/SA FR34K
 */
/**/
public class ControladoraPersistencia {

    LibroJpaController lib = new LibroJpaController();
    AutorJpaController aut = new AutorJpaController();
    EditorialJpaController edi = new EditorialJpaController();
    PrestamoJpaController pre = new PrestamoJpaController();
    ClienteJpaController cli = new ClienteJpaController();
    
    // LIBRO //
    public void CrearLibro(Libro libro) {
        lib.create(libro);
    }

    public void EliminarLibro(Long isbn) {
        try {
            lib.destroy(isbn);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void EditarLibro(Libro libro) {
        try {
            lib.edit(libro);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Libro MostrarunLibro(Long isbn) {
        return lib.findLibro(isbn);
    }

    public ArrayList<Libro> MostrarLibros() {
        List<Libro> list = lib.findLibroEntities();
        ArrayList<Libro> libro = new ArrayList<Libro>(list);
        return libro;
    }

    // AUTOR //
    public void CrearAutor(Autor autor) {
        aut.create(autor) ;
    }

    public void EliminarAutor(int id) {
        try {
            aut.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void EditarAutor(Autor autor) {
        try {
            aut.edit(autor);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Autor MostrarunAutor(int id) {
        return aut.findAutor(id);
    }

    public ArrayList<Autor> MostrarAutores() {
        List<Autor> list = aut.findAutorEntities();
        ArrayList<Autor> auto = new ArrayList<Autor>(list);
        return auto;

    }

    // EDITORIAL //
    
    public void CrearEditorial(Editorial editorial) {
        edi.create(editorial);
    }

    public void EliminarEditorial(int id) {
        try {
            edi.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void EditarEditorial(Editorial editorial) {
        try {
            edi.edit(editorial);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Editorial MostrarunEditorial(int id) {
        return edi.findEditorial(id);
    }

    public ArrayList<Editorial> MostrarEditoriales() {
        List<Editorial> list = edi.findEditorialEntities();
        ArrayList<Editorial> edito = new ArrayList<Editorial>(list);
        return edito;

    }
    
    /// PRESTAMO ///

    public void CrearPrestamo(Prestamo prestamo) {
        pre.create(prestamo);
    }

    public void EliminarPrestamo(int id) {
        try {
            pre.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void EditarPrestamo(Prestamo prestamo) {
        try {
            pre.edit(prestamo);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Prestamo MostrarunPrestamo(int id) {
        return pre.findPrestamo(id);
    }

    public ArrayList<Prestamo> MostrarPrestamos() {
        List<Prestamo> list = pre.findPrestamoEntities();
        ArrayList<Prestamo> presta = new ArrayList<Prestamo>(list);
        return presta;
    }
    
    /// CLIENTE ///

    public void CrearCliente(Cliente cliente) {
        cli.create(cliente);
    }

    public void EliminarCliente(int id) {
        try {
            cli.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void EditarCliente(Cliente cliente) {
        try {
            cli.edit(cliente);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Cliente MostrarunCliente(int id) {
        return cli.findCliente(id);
    }

    public ArrayList<Cliente> MostrarClientes() {
        List <Cliente> list = cli.findClienteEntities();
        ArrayList<Cliente> clien = new ArrayList <> (list);
        return clien;
    }
    
}
