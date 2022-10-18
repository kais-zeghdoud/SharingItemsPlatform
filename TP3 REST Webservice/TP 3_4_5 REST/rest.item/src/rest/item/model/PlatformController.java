package rest.item.model;
import rest.item.model.Category;
import rest.item.model.Item;
import rest.item.model.Post;
import rest.item.model.Address;
import rest.item.model.User;

import java.util.ArrayList;
import java.util.List;

public class PlatformController {
    private static PlatformController instance;
    private static List<User> users;
    private static List<Post> posts;

    private PlatformController(){}

    public static PlatformController getInstance(){
        if (instance == null)
            instance = new PlatformController();
        return instance;
    }

    public List<User> getUsers(){return users;}

    public List<Post> getPosts(){return posts;}

    public void createUser(String fullName, int NB, String name, int postalCode, String city, String country){
        users.add(new User(fullName, new Address(NB, name, postalCode, city, country)));
    }

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
}
