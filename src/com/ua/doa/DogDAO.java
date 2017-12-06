package com.ua.doa;

import com.ua.model.Dog;
import com.ua.doa.generalizedDAO.GenericDAO;

import javax.ejb.Stateless;

//the same as @Repository

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
