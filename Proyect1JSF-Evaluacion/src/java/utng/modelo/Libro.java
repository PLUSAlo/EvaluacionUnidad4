package utng.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Alondra
 */

@Entity
@Table(name="libro")
public class Libro implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_libro")
    private Long idLibro;
    @Column(name="nombre_libro", length=40)
    private String nombreLibro;
    @Column(length=40)
    private String edicion;
     @Column(length=40)
    private String editorial;
    
    @ManyToOne()
    @JoinColumn(name="id_autor")
    private Autor autor;

    public Libro(Long idLibro, String nombreLibro, String edicion, String editorial, Autor autor) {
        this.idLibro = idLibro;
        this.nombreLibro = nombreLibro;
        this.edicion = edicion;
        this.editorial = editorial;
        this.autor = autor;
    }

    public Libro() {
        this(0L,"","","",null);
    }

    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro{" + "idLibro=" + idLibro + ", nombreLibro=" + nombreLibro + ", edicion=" + edicion + ", editorial=" + editorial + ", autor=" + autor + '}';
    }
    
    
}
