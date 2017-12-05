package doa;

import com.ua.model.Dog;
import doa.generalizedDAO.GenericDAO;

import javax.ejb.Stateless;


@Stateless
public class DogDAO extends GenericDAO<Dog> {

    public DogDAO(Class<Dog> entityClass) {
        super(Dog.class);
    }

    public DogDAO() {
    }

    public Dog findOneResult() {
        return null;
    }
}
