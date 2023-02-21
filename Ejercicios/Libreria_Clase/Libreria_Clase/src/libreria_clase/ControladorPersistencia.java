package libreria_clase;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import libreria_clase.Entidades.Autor;
import libreria_clase.Entidades.Editorial;
import libreria_clase.Entidades.Libro;

public class ControladorPersistencia {

    LibroJpaController libroJPA = new LibroJpaController();
    EditorialJpaController editorialJPA = new EditorialJpaController();
    AutorJpaController autorJPA = new AutorJpaController();
    
    public void crearLibro(Libro lib){
        try {
         libroJPA.create(lib);
        } catch (Exception e) {
           Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
     public void crearAutor(Autor aut){
        try {
         autorJPA.create(aut);
        } catch (Exception e) {
           Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, e);
        }
    }
     
      public void crearEditorial(Editorial edi){
        try {
         editorialJPA.create(edi);
        } catch (Exception e) {
           Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, e);
        }
    }
      
      public void eliminarLibro(Long  id){
          try {
              libroJPA.destroy(id);
          } catch (Exception e) {
              Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, e);
          } 
      }
      
      public void eliminarAutor(Integer id){
          try {
              autorJPA.destroy(id);
          } catch (Exception e) {
              Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, e);
          } 
      }
      
      public void eliminarEditorial(Integer ids){
          try {
              editorialJPA.destroy(ids);
          } catch (Exception e) {
             Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, e);
          } 
      }
      
      public void buscarLibro(){
          try {
              List <Libro> librito = libroJPA.findLibroEntities();
              for (Libro aux : librito) {
                  System.out.println(aux.toString());
              }
          } catch (Exception e) {
              Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, e);
          }
      }
      
      public void buscarPorAutor(String nombre){
          try {
              List <Autor> boludo = autorJPA.findAutorEntities();
              for (Autor aux : boludo) {
                  System.out.println(aux.toString());
              }
          } catch (Exception e) {
              Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, e);
          }
      }
      
      public void mostrarLibros(){
           try {
              List <Libro> librito = libroJPA.findLibroEntities();
              List <Autor> boludo = autorJPA.findAutorEntities();
              int contador=0;
              for (Libro aux : librito) {
                  System.out.println(aux.getTitulo()+"  " +aux.getAutor()+ " " +aux.getEditorial());
                  contador++;
              }
          } catch (Exception e) {
              Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, e);
          }
      }
      
      
       public void editarLibro(Libro libro){
          try {
              libroJPA.edit(libro);
          } catch (Exception e) {
              Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, e);
          }
      }
}
