package rest.item.dao;
import rest.item.model.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;


public enum PlatformDao {
    instance;
    private Map<String, User> users = new HashMap<>();
    private Map<String, Post> posts = new HashMap<>();

    private PlatformDao() {
    	Item i = new Item(Category.musicCD, "DLL", "PNL", new SimpleDateFormat("2018-08-15"));
    	Post p = new Post("1", i, "best album ever");
    	posts.put("1",p);
    	
    	
    	i = new Item(Category.musicCD, "Deo Favente", "SCH", new SimpleDateFormat("2015-10-10"));
    	p = new Post("1", i, "19 gotze");
    	posts.put("2",p);
    	
    	
    	Address a = new Address("55", "rue du tage", "75013", "Paris", "France"); 
    	User u = new User("john doe", a);
        users.put("1",u);
    }
    
    public Map<String, User> getUsers(){return users;}
    public Map<String, Post> getPosts(){return posts;}
    
}