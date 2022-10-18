package plateform.ressources;

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

import Platform.Items.Item;
import dao.ItemDao;

public class ItemRessource {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	String id;
	public ItemRessource (UriInfo uriInfo, Request request, String id) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
	}
	
	// integration of the app
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Item getItem () {
		Item item = ItemDao.instance.getModel().get(id);
		if(item==null) {
			throw new RuntimeException("Get: Item with "+id+" id not found");
		}
		return item;
	}
	
	// get function for the browser
	@GET
	@Produces(MediaType.TEXT_XML)
	public Item getItemHTML() {
		Item item = ItemDao.instance.getModel().get(id);
		if(item==null) {
			throw new RuntimeException("Get: Item with "+id+" id not found");
		}
		return item;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putItem(JAXBElement<Item> item) {
		Item i = item.getValue();
		return putAndGetResponse(i);
	}
	
	@DELETE
	public void deleteItem () {
		Item i = ItemDao.instance.getModel().remove(id);
		if (i==null) {
			throw new RuntimeException("Delete: Item with "+id+" id not found");
		}
	}
	
	private Response putAndGetResponse(Item item) {
		Response response;
		if(ItemDao.instance.getModel().containsKey(item.getId())) {
			response = Response.noContent().build();
		} else {
			response = Response.created(uriInfo.getAbsolutePath()).build();
		}
		ItemDao.instance.getModel().put(item.getId(), item);
		return response;
	}
}
