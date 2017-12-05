package facades;

import com.ua.model.User;
import doa.UserDAO;
import facades.interfaces.UserFacade;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class UserFacadeImpl implements UserFacade {

    @EJB
    private UserDAO userDAO;

    public User findUserByEmail(String email) {
        return userDAO.findUserByEmail(email);
    }
}
