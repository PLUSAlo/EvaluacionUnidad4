package utng.manejador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import utng.datos.AutorDAO;
import utng.datos.CancionDAO;
import utng.modelo.Autor;
import utng.modelo.Cancion;

/**
 *
 * @author Alondra
 */

@ManagedBean(name = "cancionBean")
@SessionScoped
public class CancionBean implements Serializable{
    private List<Cancion> canciones;
    private Cancion cancion;
    private List<Autor> autores; 

    public CancionBean() {
       cancion = new Cancion();
       cancion.setAutor(new Autor());
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    public Cancion getCancion() {
        return cancion;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
    
    public String listar() {
        CancionDAO dao = new CancionDAO();
        try {
            canciones = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Canciones";
    }

    public String eliminar() {
        CancionDAO dao = new CancionDAO();
        try {
            dao.delete(cancion);
            canciones = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";
    }

    public String iniciar() {
        cancion = new Cancion();
        cancion.setAutor(new Autor());
        try {
            autores = new AutorDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Iniciar";
    }

    public String guardar() {
       CancionDAO dao = new CancionDAO();
        try {
            if (cancion.getIdCancion() != 0) {
                dao.update(cancion);
            } else {
                dao.insert(cancion);
            }
            canciones = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }

    public String cancelar() {
        return "Cancelar";
    }

    public String editar(Cancion cancion) {
        this.cancion= cancion;
        try {
            autores = new AutorDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Editar";
    }
}
