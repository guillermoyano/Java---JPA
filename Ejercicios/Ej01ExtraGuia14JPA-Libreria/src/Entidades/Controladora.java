package Entidades;

import Persistencia.ControladoraPersistencia;
import java.util.ArrayList;

//import java.util.Scanner;
/**
 *
 * @author Tonna/SA FR34K
 */
/**/
public class Controladora {

//    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ControladoraPersistencia cp = new ControladoraPersistencia();

    public void CrearLibro(Libro libro) {

        cp.CrearLibro(libro);
    }

    public void EliminarLibro(Long isbn) {
        cp.EliminarLibro(isbn);
    }

    public void EditarLibro(Libro libro) {
        cp.EditarLibro(libro);
    }

    public Libro MostrarunLibro(Long isbn) {
        return cp.MostrarunLibro(isbn);
    }

    public ArrayList<Libro> MostarLibros() {
        return cp.MostrarLibros();

    }

    public void CrearAutor(Autor autor) {

        cp.CrearAutor(autor);
    }

    public void EliminarAutor(int id) {
        cp.EliminarAutor(id);
    }

    public void EditarAutor(Autor autor) {
        cp.EditarAutor(autor);
    }

    public Autor MostrarunAutor(int id) {
        return cp.MostrarunAutor(id);
    }

    public ArrayList<Autor> MostrarAutores() {
        return cp.MostrarAutores();

    }
    
    public void CrearEditorial(Editorial editorial) {

        cp.CrearEditorial(editorial);
    }

    public void EliminarEditorial(int id) {
        cp.EliminarEditorial(id);
    }

    public void EditarEditorial(Editorial editorial) {
        cp.EditarEditorial(editorial);
    }

    public Editorial MostrarunEditorial(int id) {
        return cp.MostrarunEditorial(id);
    }

    public ArrayList<Editorial> MostrarEditoriales() {
        return cp.MostrarEditoriales();

    }
    
    public void CrearPrestamo(Prestamo prestamo) {

        cp.CrearPrestamo(prestamo);
    }

    public void EliminarPrestamo(int id) {
        cp.EliminarPrestamo(id);
    }

    public void EditarPrestamo(Prestamo prestamo) {
        cp.EditarPrestamo(prestamo);
    }

    public Prestamo MostrarunPrestamo(int id) {
        return cp.MostrarunPrestamo(id);
    }

    public ArrayList<Prestamo> MostrarPrestamos() {
        return cp.MostrarPrestamos();

    }
    
    public void CrearCliente(Cliente cliente) {

        cp.CrearCliente(cliente);
    }

    public void EliminarCliente(int id) {
        cp.EliminarCliente(id);
    }

    public void EditarCliente(Cliente cliente) {
        cp.EditarCliente(cliente);
    }

    public Cliente MostrarunCliente(int id) {
        return cp.MostrarunCliente(id);
    }

    public ArrayList<Cliente> MostrarClientes() {
        return cp.MostrarClientes();

    }
}
