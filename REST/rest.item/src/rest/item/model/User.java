package rest.item.model;
import javax.xml.bind.annotation.XmlRootElement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import rest.item.dao.PlatformDao;

@XmlRootElement
public class User {
	private final int userID;
    private String fullName;
    private Address address;
    private List<Post> userRecommendations;

    public User(String fullName, Address address) {
    	this.fullName = fullName;
    	userID = 0;
        //this.userID = PlatformDao.instance.getUsers().values().size() + 1;
        this.address = address;
    }
    
    public int getID() {return userID;}

    public String getFullName(){return fullName;}

    public Address getAddress(){return address;}

    public void postItem(String postDescription, Category itemCategory, String itemName, String author, SimpleDateFormat releaseDate){
        Item item = new Item(itemCategory, itemName, author, releaseDate);
        PlatformDao.instance.getPosts().put("9", new Post(userID, item, postDescription));
    }

    public void removePost(Post post){
    	PlatformDao.instance.getPosts().values().remove(post);
    }

    public void rateItem(Post post, String text){
        int id = post.getRatings().size() + 1;
        //post.getRatings().add(new Rate(id, post.getItem(), this, text));
    }

    public void putRecommendation(Post post){
        if(!userRecommendations.contains(post)){
            post.getItem().increaseRecommendations();
            userRecommendations.add(post);
        }
    }
    
    public String toString(){
        return "\nID : " + userID + "\nFull name : " + fullName + "\nAddress : " + address.toString();
    }
}
