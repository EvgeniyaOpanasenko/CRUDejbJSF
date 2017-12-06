package facades;

import com.ua.model.Dog;
import com.ua.doa.DogDAO;
import facades.interfaces.DogFacade;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class DogFacadeImpl implements DogFacade {

    @EJB
    private DogDAO dogDAO;

    public void save(Dog dog) {
        isDogWithAllDAta(dog);
        dogDAO.save(dog);
    }

    private void isDogWithAllDAta(Dog dog) {
        boolean hasError = false;

        if (dog == null) {
            hasError = true;
        } else if (dog.getName() == null || "".equals(dog.getName().trim())) {
            hasError = true;
        }
        if (hasError) {
            throw new IllegalArgumentException("All field must be inserted");
        }
    }

    public Dog update(Dog dog) {
        isDogWithAllDAta(dog);
        return dogDAO.update(dog);
    }

    public void delete(Dog dog) {
        dogDAO.delete(dog);
    }

    public Dog find(int entityID) {
        dogDAO.find(entityID);
        return null;
    }

    public List<Dog> findAll() {
        return dogDAO.findAll();
    }
}
