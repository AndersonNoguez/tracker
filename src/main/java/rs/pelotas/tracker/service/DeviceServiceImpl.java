package rs.pelotas.tracker.service;

import javax.inject.Inject;
import rs.pelotas.arch.repository.BaseRepository;
import rs.pelotas.arch.service.BaseServiceImpl;
import rs.pelotas.tracker.entity.Device;
import rs.pelotas.tracker.repository.DeviceRepository;

/**
 * @author Rafael Guterres
 */
public class DeviceServiceImpl
     extends BaseServiceImpl<Device, Long> 
  implements DeviceService {
    
    @Inject
    DeviceRepository deviceRepository;

    @Override
    public BaseRepository<Device, Long> getRepository() {
        return deviceRepository;
    }
}