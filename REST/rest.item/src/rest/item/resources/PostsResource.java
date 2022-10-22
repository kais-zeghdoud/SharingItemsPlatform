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



/// Will map the resource to the URL posts
@Path("/posts")
public class PostsResource {

    // Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    // Return the list of posts to the user in the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public List<Post> getPostsBrowser() {  
    	List<Post> posts = new ArrayList<Post>();
    	posts.addAll(PlatformDao.instance.getPosts());
    	return posts;
    }

    // Return the list of posts for applications
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<Post> getPosts() {
    	List<Post> posts = new ArrayList<Post>();
    	posts.addAll(PlatformDao.instance.getPosts());
    	return posts;
    }

    // returns the number of posts
    // Use http://localhost:8080/com.vogella.jersey.todo/rest/todos/count
    // to get the total number of records
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
    	if(PlatformDao.instance.getPosts().isEmpty())
    		return "No items on the Platform yet";
    	else {
    		int count = PlatformDao.instance.getPosts().size();
            return "Posted items on the Platform : " + count;
    	}
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newPost(@FormParam("category") Category cat,
            @FormParam("itemName") String itemName,
            @FormParam("author") String author,
            @FormParam("releaseDate") Date releaseDate,
            @FormParam("userID") int user,
            @FormParam("description") String description,
            @Context HttpServletResponse servletResponse) throws IOException {
    	
        Item item = new Item(cat, itemName, author, releaseDate);
        PlatformDao.instance.getPosts().add(new Post(item, user, description));
        servletResponse.sendRedirect("../create_post.html");
    }
    

    // Defines that the next path parameter after posts is
    // treated as a parameter and passed to the TodoResources
    // Allows to type http://localhost:8080/rest.item/rest/posts/1
    // 1 will be treaded as parameter post and passed to PostResource
    @Path("{post}")
    public PostResource getTodo(@PathParam("post") int id) {
        return new PostResource(uriInfo, request, id);
    }

}