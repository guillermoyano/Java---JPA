package biblioteca;

import biblioteca.entidades.Cliente;
import java.util.Scanner;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Biblioteca {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Biblioteca_PU");
        EntityManager em = emf.createEntityManager();
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

//        Cliente cliente1 = new Cliente();
//        cliente1.setNombre("Guillermo");
//        cliente1.setApellido("Moyano");
//        cliente1.setDocumento(30181954L);
//        cliente1.setTelefono("1166506916");
//        em.getTransaction().begin();
//        em.persist(cliente1);
//        em.getTransaction().commit();
//        
//        Cliente cliente2 = new Cliente();
//        cliente2.setNombre("Gonzalo");
//        cliente2.setApellido("Barrasa");
//        cliente2.setDocumento(24932895L);
//        cliente2.setTelefono("2615890406");
//        em.getTransaction().begin();
//        em.persist(cliente2);
//        em.getTransaction().commit();
//        
//        Cliente cliente3 = new Cliente();
//        cliente3.setNombre("Nicolas");
//        cliente3.setApellido("Pergolani");
//        cliente3.setDocumento(37143424L);
//        cliente3.setTelefono("1150126884");
//        em.getTransaction().begin();
//        em.persist(cliente3);
//        em.getTransaction().commit();
//        
//        Cliente cliente4 = new Cliente();
//        cliente4.setNombre("Diego");
//        cliente4.setApellido("Picco");
//        cliente4.setDocumento(35675943L);
//        cliente4.setTelefono("3585095375");
//        em.getTransaction().begin();
//        em.persist(cliente4);
//        em.getTransaction().commit();
//        
//        Cliente cliente5 = new Cliente();
//        cliente5.setNombre("Rodrigo");
//        cliente5.setApellido("Pereyra");
//        cliente5.setDocumento(30671722L);
//        cliente5.setTelefono("2615445331");
//        em.getTransaction().begin();
//        em.persist(cliente5);
//        em.getTransaction().commit();


//        Cliente cliente = (Cliente) em.createQuery("SELECT c "
//                + "FROM Cliente c "
//                + "WHERE c.id = :id").setParameter("id", "51").
//                getSingleResult();
//        em.getTransaction().begin();
//        em.remove(cliente);
//        em.getTransaction().commit();
        
    }
    
}
