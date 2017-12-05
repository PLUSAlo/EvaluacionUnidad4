package utng.datos;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import utng.modelo.Cancion;

/**
 *
 * @author Alondra
 */
public class CancionDAO extends DAO<Cancion>{
    public CancionDAO() {
        super(new Cancion());
    }
    public Cancion getOneById(Cancion cancion) throws HibernateException {
        return super.getOneById(cancion.getIdCancion()); 
    }
}
