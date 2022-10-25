package rest.item.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import rest.item.dao.PlatformDao;
import rest.item.model.*;


public class UserResource {
	@Context
    UriInfo uriInfo;
    @Context
    Request request;
    String id;
    public UserResource(UriInfo uriInfo, Request request, String id) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
    }
    
  //Application integration
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User getUser(){
        User user = PlatformDao.instance.getUsers().get(id);
        if(user==null)
            throw new RuntimeException("Get: User with " + id +  " not found");
        return user;
    }

    // for the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public User getUserHTML() {
        User user = PlatformDao.instance.getUsers().get(id);
        if(user==null)
            throw new RuntimeException("Get: User with " + id +  " not found");
        return user;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response putUser(JAXBElement<User> user) {
        User u = user.getValue();
        return putAndGetResponse(u);
    }

    @DELETE
    public void deleteUser() {
        User u = PlatformDao.instance.getUsers().remove(id);
        if(u==null)
            throw new RuntimeException("Delete: User with " + id +  " not found");
    }

    private Response putAndGetResponse(User user) {
        Response res;
        if(PlatformDao.instance.getUsers().containsKey(String.valueOf(user.getID()))) {
            res = Response.noContent().build();
        } else {
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        PlatformDao.instance.getUsers().put(String.valueOf(user.getID()), user);
        return res;
    }
}
