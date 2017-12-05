package utng.manejador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import utng.datos.AutorDAO;
import utng.datos.LibroDAO;
import utng.modelo.Autor;
import utng.modelo.Libro;

/**
 *
 * @author Alondra
 */

@ManagedBean(name = "libroBean")
@SessionScoped
public class LibroBean implements Serializable {

    private List<Libro> libros;
    private Libro libro;
    private List<Autor> autores;

    public LibroBean() {
        libro = new Libro();
        libro.setAutor(new Autor());
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public String listar() {
        LibroDAO dao = new LibroDAO();
        try {
            libros = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Libros";
    }

    public String eliminar() {
        LibroDAO dao = new LibroDAO();
        try {
            dao.delete(libro);
            libros = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";
    }

    public String iniciar() {
        libro = new Libro();
        libro.setAutor(new Autor());
        try {
            autores = new AutorDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Iniciar";
    }

    public String guardar() {
        LibroDAO dao = new LibroDAO();
        try {
            if (libro.getIdLibro() != 0) {
                dao.update(libro);
            } else {
                dao.insert(libro);
            }
            libros = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }

    public String cancelar() {
        return "Cancelar";
    }

    public String editar(Libro libro) {
        this.libro = libro;
        try {
            autores = new AutorDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Editar";
    }

}
