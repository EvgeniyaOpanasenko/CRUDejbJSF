package doa;

import com.ua.model.User;
import doa.generalizedDAO.GenericDAO;

import javax.ejb.Stateless;
import java.util.HashMap;
import java.util.Map;

@Stateless
public class UserDAO extends GenericDAO<User> {

    public UserDAO() {
    }

    public UserDAO(Class<User> entityClass) {
        super(User.class);
    }

    public User findUserByEmail(String email) {

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("email", email);
        return super.findOneResult(User.FIND_BY_EMAIL, parameters);
    }

    public User findOneResult() {
        return null;
    }
}
