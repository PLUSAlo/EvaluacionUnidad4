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
@Table(name="cancion")
public class Cancion implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_cancion")
    private Long idCancion;
    @Column(name="nombre_cancion", length=40)
    private String nombreCancion;
    @Column(length=40)
    private String cantante;
    @Column(length=40)
    private String album;
    @Column(length=40)
    private String genero;
    
    @ManyToOne()
    @JoinColumn(name="id_autor")
    private Autor autor;

    public Cancion(Long idCancion, String nombreCancion, String cantante, String album, String genero, Autor autor) {
        this.idCancion = idCancion;
        this.nombreCancion = nombreCancion;
        this.cantante = cantante;
        this.album = album;
        this.genero = genero;
        this.autor = autor;
    }

    public Cancion() {
        this(0L,"","","","",null);
    }

    public Long getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(Long idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getCantante() {
        return cantante;
    }

    public void setCantante(String cantante) {
        this.cantante = cantante;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Cancion{" + "idCancion=" + idCancion + ", nombreCancion=" + nombreCancion + ", cantante=" + cantante + ", album=" + album + ", genero=" + genero + ", autor=" + autor + '}';
    }
    
    
    
}
