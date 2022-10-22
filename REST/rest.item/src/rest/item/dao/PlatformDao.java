package rest.item.dao;
import rest.item.model.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;



public enum PlatformDao {
    instance;
    private static List<User> users;
    private static List<Post> posts;

    private PlatformDao() {
        Todo todo = new Todo("1", "Prendre un bon petit d�j");
        todo.setDescription("il est important de commencer la journ�e par un repas �quilibr�");
        contentProvider.put("1", todo);
        todo = new Todo("2", "Faire 10000 pas");
        todo.setDescription("afin de garder une bonne sant�");
        contentProvider.put("2", todo);
    }
    
    public List<User> getUsers(){return users;}
    public List<Post> getPosts(){return posts;}

    public void createUser(String fullName, int NB, String name, int postalCode, String city, String country){
        users.add(new User(fullName, new Address(NB, name, postalCode, city, country)));
    }
    
    public void createPost() {
    	posts.add(null);
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