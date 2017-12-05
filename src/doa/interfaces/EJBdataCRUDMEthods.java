package doa.interfaces;

import javax.ejb.Local;
import java.util.List;


//TODO find out if this annotation is mandatory
@Local // or remote
public interface EJBdataCRUDMEthods<T> {

    public void save(T entity);

    public void delete(T entity);

    public T find(int entityID);

    public T update(T entity);

    public List<T> findAll();

}
