package rest.item.model;
import rest.item.model.Category;
import rest.item.model.Item;
import rest.item.model.PlatformController;
import rest.item.model.Post;
import rest.item.model.Rate;
import java.util.Date;
import java.util.List;


public class User {
    private final int userID;
    private String fullName;
    private Address address;
    private List<Post> userRecommendations;

    public User(String fullName, Address address) {
        this.userID = PlatformController.getInstance().getUsers().size() + 1;
        this.address = address;
    }

    public String getFullName(){return fullName;}

    public Address getAddress(){return address;}

    public void postItem(String id, String postDescription, Category itemCategory, String itemName, String author, Date releaseDate){
        Item item = new Item(id, itemCategory, itemName, author, releaseDate);
        PlatformController.getInstance().getPosts().add(new Post(item, this, postDescription));
    }

    public void removePost(Post post){
        PlatformController.getInstance().getPosts().remove(post);
    }

    public void rateItem(Post post, String text){
        int id = post.getRatings().size() + 1;
        post.getRatings().add(new Rate(id, post.getItem(), this, text));
    }

    public void putRecommendation(Post post){
        if(userRecommendations.contains(post)){
            post.increaseRecommendations();
            userRecommendations.add(post);
        }
    }
}
