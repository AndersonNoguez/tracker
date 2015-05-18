package org.traccar.resource;

import java.util.Collection;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.links.AddLinks;
import org.jboss.resteasy.links.LinkResource;
import rs.pelotas.arch.resource.Resource;
import org.traccar.entity.Device;
import org.traccar.entity.User;

/**
 *
 * @author Rafael Guterres
 */
@Path("/traccar/users")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface UserResource extends Resource<User, Long> {

    @RolesAllowed({"traccar_admin", "traccar_admin_read"})
    @AddLinks
    @LinkResource(User.class)
    @GET
    @Path("/")
    @Override
    public List<User> getEntities(@Context HttpServletRequest request);

    @RolesAllowed({"traccar_admin", "traccar_admin_create"})
    @LinkResource
    @POST
    @Path("/")
    @Override
    public Response postEntity(User entity);
    
    @RolesAllowed({"traccar_admin", "traccar_admin_read"})
    @AddLinks
    @LinkResource
    @GET
    @Path("/{id}")
    @Override
    public User getEntityById(@PathParam("id") Long id);

    @RolesAllowed({"traccar_admin", "traccar_admin_update"})
    @LinkResource
    @PUT
    @Path("/{id}")
    @Override
    public Response putEntity(@PathParam("id") Long id, User entity);

    @RolesAllowed({"traccar_admin", "traccar_admin_delete"})
    @LinkResource(User.class)
    @DELETE
    @Path("/{id}")
    @Override
    public Response deleteEntity(@PathParam("id") Long id);
    
    @RolesAllowed({"traccar_admin", "traccar_admin_read_devices"})
    @AddLinks
    @LinkResource(value = User.class, rel = "devices")
    @GET
    @Path("/{id}/devices")
    public Collection<Device> getDevices(@PathParam("id") Long userId);
}