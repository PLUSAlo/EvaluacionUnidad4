package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Autor;

/**
 *
 * @author Alondra
 */
public class AutorDAO extends DAO<Autor>{
     public AutorDAO() {
        super(new Autor());
    }

    
    public Autor getOneById(Autor autor) throws HibernateException {
        return super.getOneById(autor.getIdAutor());
    }
}
