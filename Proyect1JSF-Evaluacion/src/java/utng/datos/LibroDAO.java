package utng.datos;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import utng.modelo.Libro;

/**
 *
 * @author Alondra
 */
public class LibroDAO extends DAO<Libro>{
     public LibroDAO() {
        super(new Libro());
    }
    public Libro getOneById(Libro libro) throws HibernateException {
        return super.getOneById(libro.getIdLibro()); 
    }
}
