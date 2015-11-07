package rs.pelotas.tracker.resource.bean;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import rs.pelotas.arch.resource.BaseResource;
import rs.pelotas.arch.service.Service;
import rs.pelotas.tracker.entity.Device;
import rs.pelotas.tracker.entity.User;
import rs.pelotas.tracker.resource.UserResource;
import rs.pelotas.tracker.service.DeviceService;
import rs.pelotas.tracker.service.UserService;

/**
 *
 * @author Rafael Guterres
 */
@RequestScoped
public class UserResourceBean extends BaseResource<User, Long> implements UserResource {

    private static final long serialVersionUID = -6835862323296783770L;

    @Inject
    private UserService userService;

    @Inject
    private DeviceService deviceService;

    @Override
    public Service<User, Long> getService() {
        return userService;
    }

    @Override
    public List<Device> getDevices(Long userId) {
        return deviceService.findDevicesByUserId(userId);
    }
}
