package facades.interfaces;

import com.ua.model.User;

import javax.ejb.Local;


//by default is is annotated as @Local
@Local
public interface UserFacade {
    public User findUserByEmail(String email);
}
