package utng.manejador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.datos.AutorDAO;
import utng.modelo.Autor;

/**
 *
 * @author Alondra
 */
@ManagedBean
@SessionScoped
public class AutorBean implements Serializable{
    private List<Autor>autores;
    private Autor autor;
    
    public AutorBean(){}

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
    public String listar(){
        AutorDAO dao = new AutorDAO();
        try {
            autores=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Autores";
    }
    
    public String eliminar(){
         AutorDAO dao = new AutorDAO();
        try {
            dao.delete(autor);
            autores=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";
    }
    
    public String iniciar(){
        autor= new Autor();
        return "Iniciar";
    }
    
    public String guardar(){
       AutorDAO dao = new AutorDAO();
        try {
            if(autor.getIdAutor()!= 0){
                dao.update(autor);
            }else {
                dao.insert(autor);
            }
            autores=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }
    
    public String cancelar(){
    return "Cancelar";
    }
    
    public String editar(Autor autor){
        this.autor=autor;
        return "Editar";
    }
}
