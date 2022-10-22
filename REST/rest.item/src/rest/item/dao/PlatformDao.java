package rest.item.dao;
import rest.item.model.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public enum PlatformDao {
    instance;
    private List<User> users = new ArrayList<User>();
    private List<Post> posts = new ArrayList<Post>();

    private PlatformDao() {
    	Post p = new Post(new Item(Category.musicCD, "DLL", "PNL", new Date()), 1, "best album ever");
    	posts.add(p);
    }
    
    public List<User> getUsers(){return users;}
    public List<Post> getPosts(){return posts;}
    
    /*
    public void createUser(String fullName, int NB, String name, int postalCode, String city, String country){
        users.add(new User(fullName, new Address(NB, name, postalCode, city, country)));
    }
    */

    
    public List<Item> getItemsByCategory(Category category){
        List<Item> items = new ArrayList<>();
        for (Post post: posts) {
            if(post.getItem().getItemCategory().equals(category))
                items.add(post.getItem());
        }
        return items;
    }

    
    public List<Item> getItemsByKeyword(String keyword){
        List<Item> items = new ArrayList<>();
        for (Post post: posts) {
            if(post.getItem().getItemName().equals(keyword))
                items.add(post.getItem());
        }
        return items;
    }

    
    /*
    public List<Item> getItemsByCity(String city){
        List<Item> items = new ArrayList<>();
        for (Post post: posts) {
            if(post.getPoster().getAddress().getCity().equals(city))
                items.add(post.getItem());
        }
        return items;
    }

    
    public List<Item> getItemsByUser(String fullName){
        List<Item> items = new ArrayList<>();
        for (Post post: posts) {
            if(post.getPoster().getFullName().equals(fullName))
                items.add(post.getItem());
        }
        return items;
    }
    */
}