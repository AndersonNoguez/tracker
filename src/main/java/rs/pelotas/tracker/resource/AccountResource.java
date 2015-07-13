package rs.pelotas.tracker.resource;

import java.io.Serializable;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.links.AddLinks;
import rs.pelotas.arch.resource.ApplicationPath;
import rs.pelotas.arch.security.role.ApplicationRole;
import rs.pelotas.tracker.entity.User;

/**
 *
 * @author Rafael Guterres
 */
@Path(ApplicationPath.ACCOUNT)
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface AccountResource extends Serializable {
    
    @RolesAllowed({ApplicationRole.ACCOUNT})
    @AddLinks
    @GET
    @Path("/")
    public User getAccount();
}
