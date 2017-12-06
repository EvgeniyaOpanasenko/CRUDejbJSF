package facades.interfaces;

import com.ua.model.User;

import javax.ejb.Local;


//by default is is annotated as @Local
//Facade is a sort of Service in MVC all business logic stored in here and we do not connect to database directly
@Local
public interface UserFacade {
    public User findUserByEmail(String email);
}
