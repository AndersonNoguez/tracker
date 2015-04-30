package rs.pelotas.tracker.filter;

import rs.pelotas.arch.filter.BaseFilter;
import rs.pelotas.arch.annotation.CriteriaFilter;

/**
 *
 * @author Rafael Guterres
 */
public class DeviceFilter implements BaseFilter {
    
    @CriteriaFilter
    private String name;
    
    @CriteriaFilter
    private String imei;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }
}