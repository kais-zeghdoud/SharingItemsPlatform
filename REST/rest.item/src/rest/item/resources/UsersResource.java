package rest.item.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import rest.item.dao.PlatformDao;
import rest.item.model.*;



@Path("/users")
public class UsersResource {
	@Context
    UriInfo uriInfo;
    @Context
    Request request;

    // Return the list of users to the user in the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public List<User> getUsersBrowser(){
    	List<User> users = new ArrayList<User>();
    	users.addAll(PlatformDao.instance.getUsers().values());
    	return users;
    }

    // Return the list of users for applications
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<User> getUsers() {
    	List<User> users = new ArrayList<User>();
    	users.addAll(PlatformDao.instance.getUsers().values());
    	return users;
    }

    // returns the number of users
    // Use http://localhost:8080/com.vogella.jersey.todo/rest/users/count
    // to get the total number of records
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
    	if(PlatformDao.instance.getUsers().values().isEmpty())
    		return "No user registered on the Platform yet";
    	else {
    		int count = PlatformDao.instance.getUsers().size();
            return "Registered users on the Platform : " + count;
    	}
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newUser(@FormParam("userID") String userID,
            @FormParam("fullName") String fullName,
            @FormParam("streetNB") String streetNB,
            @FormParam("streetName") String streetName,
            @FormParam("postalCode") String postalCode,
            @FormParam("city") String city,
            @FormParam("country") String country,
            @Context HttpServletResponse servletResponse) throws IOException {
    	
        Address a = new Address(streetNB, streetName, postalCode, city, country); 
        PlatformDao.instance.getUsers().put("9",new User(fullName, a));
        servletResponse.sendRedirect("../create_user.html");
    }
    

    // Defines that the next path parameter after users is
    // treated as a parameter and passed to the TodoResources
    // Allows to type http://localhost:8080/rest.item/rest/users/1
    // 1 will be treaded as parameter user and passed to UserResource
    @Path("{user}")
    public UserResource getUser(@PathParam("user") String id) {
        return new UserResource(uriInfo, request, id);
    }
    
    
    @GET
    @Path("AllUsers")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAllUsers() {
    	String result = "";
    	for(User u : PlatformDao.instance.getUsers().values()) {
    		result += "\n" + u.toString();
    	}	
    	return result;
    }

}
