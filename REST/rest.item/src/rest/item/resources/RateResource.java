package rest.item.resources;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
@Path("/rate")
public class RateResource {

    // Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    @GET
    @Produces(MediaType.TEXT_XML)
    public void getRate(){

    }

    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public void getRates() {

    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newPost(@FormParam("postId") int postId,
            @FormParam("rate") int rate,
            @FormParam("user") int userId,
            @FormParam("text") String text,
            @Context HttpServletResponse servletResponse) throws IOException {
    	
    	Rate rateObj = new Rate (11, PlatformDao.instance.getPosts().get( Integer.toString(postId)).getItem(), 
    			PlatformDao.instance.getUsers().get( Integer.toString(userId) ), text, rate);
        
        PlatformDao.instance.getPosts().get(0).getRatings().add(rateObj);
        servletResponse.sendRedirect("../platform.html");
    }
    
}