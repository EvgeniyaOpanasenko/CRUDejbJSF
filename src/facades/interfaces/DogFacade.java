package facades.interfaces;

import com.ua.model.Dog;

import javax.ejb.Local;
import java.util.List;

@Local
public interface DogFacade {


    public abstract void save(Dog dog);

    public abstract Dog update(Dog dog);

    public abstract void delete(Dog dog);

    public abstract Dog find(int entityID);

    public abstract List<Dog> findAll();
}
