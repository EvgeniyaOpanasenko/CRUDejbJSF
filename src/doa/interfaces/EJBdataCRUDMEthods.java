package doa.interfaces;

import javax.ejb.Local;
import java.util.List;


//TODO find out if this annotation is mandatory
@Local // or remote
public interface EJBdataCRUDMEthods<T> {

    void save(T entity);

    void delete(T entity);

    T find(int entityID);

    T update(T entity);

    List<T> findAll();

    T findOneResult();

}
