package plateform.ressources;


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

import Platform.Items.Category;
import Platform.Items.Item;
import dao.ItemDao;



/// Will map the resource to the URL items
@Path("/Items")
public class ItemsRessource {

    // Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    // Return the list of items to the user in the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public List<Item> getItemsBrowser() {
        List<Item> items = new ArrayList<Item>();
        items.addAll(ItemDao.instance.getModel().values());
        return items;
    }

    // Return the list of items for applications
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<Item> get() {
        List<Item> Items = new ArrayList<Item>();
        Items.addAll(ItemDao.instance.getModel().values());
        return Items;
    }

    // retuns the number of Items
    // Use http://localhost:8080/com.vogella.jersey.Item/rest/Items/count
    // to get the total number of records
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        int count = ItemDao.instance.getModel().size();
        return String.valueOf(count);
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newItem(@FormParam("id") String id,
            @FormParam("itemCategory") Category cat,
            @FormParam("itemName") String itemName,
            @FormParam("author") String author,
            @FormParam("releaseDate") Date releaseDate,
            @Context HttpServletResponse servletResponse) throws IOException {
        Item item = new Item(id, cat, itemName, author, releaseDate);
        // set an attribut if it's missing
        /*if (description != null) {
            item.set(description);
        }*/
        ItemDao.instance.getModel().put(id, item);

        servletResponse.sendRedirect("../create_item.html");
    }

    // Defines that the next path parameter after items is
    // treated as a parameter and passed to the ItemResources
    // Allows to type http://localhost:8080/projet_web.rest/rest/items/1
    // 1 will be treaded as parameter item and passed to ItemResource
    @Path("{item}")
    public ItemRessource getItem(@PathParam("item") String id) {
        return new ItemRessource(uriInfo, request, id);
    }

}