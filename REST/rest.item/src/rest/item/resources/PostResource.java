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


public class PostResource {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    String id;
    public PostResource(UriInfo uriInfo, Request request, String id) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
    }

    //Application integration
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Post getPost(){
        Post post = PlatformDao.instance.getPosts().get(id);
        if(post==null)
            throw new RuntimeException("Get: Post with " + id +  " not found");
        return post;
    }

    // for the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public Post getPostHTML() {
        Post post = PlatformDao.instance.getPosts().get(id);
        if(post==null)
            throw new RuntimeException("Get: Post with " + id +  " not found");
        return post;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response putPost(JAXBElement<Post> post) {
        Post p = post.getValue();
        return putAndGetResponse(p);
    }

    @DELETE
    public void deleteTodo() {
        Post p = PlatformDao.instance.getPosts().remove(id);
        if(p==null)
            throw new RuntimeException("Delete: Post with " + id +  " not found");
    }

    private Response putAndGetResponse(Post post) {
        Response res;
        if(PlatformDao.instance.getPosts().containsKey(post.getID())) {
            res = Response.noContent().build();
        } else {
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        PlatformDao.instance.getPosts().put(post.getID() , post);
        return res;
    }
}

