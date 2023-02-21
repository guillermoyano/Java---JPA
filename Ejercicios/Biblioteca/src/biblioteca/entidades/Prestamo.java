package biblioteca.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class Prestamo implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaPrestamos;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaDevolucion;
    private Libro libro;
    private Cliente cliente;

    public Prestamo() {
    }

    public Prestamo(String id, Date fechaPrestamos, Date fechaDevolucion, Libro libro, Cliente cliente) {
        this.id = id;
        this.fechaPrestamos = fechaPrestamos;
        this.fechaDevolucion = fechaDevolucion;
        this.libro = libro;
        this.cliente = cliente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFechaPrestamos() {
        return fechaPrestamos;
    }

    public void setFechaPrestamos(Date fechaPrestamos) {
        this.fechaPrestamos = fechaPrestamos;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "id=" + id + ", fechaPrestamos=" + fechaPrestamos + ", fechaDevolucion=" + fechaDevolucion + ", libro=" + libro + ", cliente=" + cliente + '}';
    }
    
    
           
}
