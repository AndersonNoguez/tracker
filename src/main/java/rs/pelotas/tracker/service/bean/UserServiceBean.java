package rs.pelotas.tracker.service.bean;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import rs.pelotas.arch.repository.Repository;
import rs.pelotas.arch.service.BaseService;
import rs.pelotas.tracker.filter.UserFilter;
import rs.pelotas.tracker.entity.User;
import rs.pelotas.tracker.repository.UserRepository;
import rs.pelotas.tracker.service.UserService;

/**
 *
 * @author Rafael Guterres
 */
@Stateless
public class UserServiceBean extends BaseService<User, Long> implements UserService {

    private static final long serialVersionUID = -8808714191503203114L;
    
    @Inject
    UserRepository userRepository;

    @Override
    public Repository<User, Long> getRepository() {
        return userRepository;
    }

    @Override
    public User findByLogin(String login) {
        UserFilter userFilter = new UserFilter();
        userFilter.setLogin(login);
        List<User> users = userRepository.find(userFilter);
        return users.get(0);
    }

    @Override
    public List<User> findUsersByDevicesId(Long deviceId) {
        return userRepository.findUsersByDeviceId(deviceId);
    }
}