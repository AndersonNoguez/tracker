package rs.pelotas.tracker.resource;

import java.io.Serializable;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.links.AddLinks;
import org.jboss.resteasy.links.LinkResource;
import rs.pelotas.arch.resource.ApplicationPath;
import rs.pelotas.arch.security.role.ApplicationRole;
import rs.pelotas.tracker.entity.Application;
import rs.pelotas.tracker.entity.Command;
import rs.pelotas.tracker.entity.Device;
import rs.pelotas.tracker.entity.Position;
import rs.pelotas.tracker.entity.User;

/**
 *
 * @author Rafael Guterres
 */
@Path(ApplicationPath.APPLICATION)
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface ApplicationResource extends Serializable {
    
    @PermitAll
    @AddLinks
    @GET
    @Path("/")
    public Response getApplication();
    
    @RolesAllowed({ApplicationRole.DASHBOARD})
    @LinkResource(rel = "list", value = Application.class)
    @GET
    @Path(ApplicationPath.DASHBOARD)
    public Response getDashboard();
    
    @PermitAll
    @AddLinks
    @LinkResource(rel = "list", value = Application.class)
    @GET
    @Path(AppResourcePath.USERS)
    public Response getResource(User user);
    
    @PermitAll
    @AddLinks
    @LinkResource(rel = "list", value = Application.class)
    @GET
    @Path(AppResourcePath.DEVICES)
    public Response getResource(Device device);

    @PermitAll
    @AddLinks
    @LinkResource(rel = "list", value = Application.class)
    @GET
    @Path(AppResourcePath.POSITIONS)
    public Response getResource(Position position);
    
    @PermitAll
    @AddLinks
    @LinkResource(rel = "list", value = Application.class)
    @GET
    @Path(AppResourcePath.COMMANDS)
    public Response getResource(Command command);
}