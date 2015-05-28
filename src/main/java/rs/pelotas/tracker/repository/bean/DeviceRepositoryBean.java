package rs.pelotas.tracker.repository.bean;

import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Root;
import rs.pelotas.arch.repository.BaseRepository;
import rs.pelotas.tracker.entity.Device;
import rs.pelotas.tracker.entity.User;
import rs.pelotas.tracker.entity.User_;
import rs.pelotas.tracker.repository.DeviceRepository;

/**
 *
 * @author Rafael Guterres
 */
public class DeviceRepositoryBean extends BaseRepository<Device, Long> implements DeviceRepository {
    
    private static final long serialVersionUID = 5330144509499505026L;

    @Override
    public List<Device> findDevicesByUserId(Long userId) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Device> criteriaQuery = criteriaBuilder.createQuery(Device.class);
        Root<User> userRoot = criteriaQuery.from(User.class);
        criteriaQuery.where(criteriaBuilder.equal(userRoot.get(User_.id), userId));
        ListJoin<User, Device> users = userRoot.join(User_.devices);
        CriteriaQuery<Device> cq = criteriaQuery.select(users);
        TypedQuery<Device> typedQuery = getEntityManager().createQuery(cq);
        return typedQuery.getResultList();
    }
}