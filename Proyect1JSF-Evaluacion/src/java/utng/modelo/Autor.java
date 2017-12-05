package utng.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Alondra
 */
@Entity
@Table(name="autor")
public class Autor {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_autor")
    private Long idAutor;
    @Column(length=50)
    private String nombre;
    @Column(length=50)
    private String estado;
     @Column(length=50)
    private String prestigio;

    public Autor(Long idAutor, String nombre, String estado, String prestigio) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.estado = estado;
        this.prestigio = prestigio;
    }

    public Autor() {
        this.idAutor=0L;
    }
    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPrestigio() {
        return prestigio;
    }

    public void setPrestigio(String prestigio) {
        this.prestigio = prestigio;
    }

    @Override
    public String toString() {
        return "Autor{" + "idAutor=" + idAutor + ", nombre=" + nombre + ", estado=" + estado + ", prestigio=" + prestigio + '}';
    }
     
     
    
}
