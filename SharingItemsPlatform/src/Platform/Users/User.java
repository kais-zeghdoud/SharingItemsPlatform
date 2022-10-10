package Platform.Users;
import Platform.Posts.Post;
import java.util.List;

public class User {
    private final int userID;
    private String fullName;
    private Address address;
    private List<Post> posts;

    public User(int userID) {
        this.userID = userID;
    }

    public String getFullName(){return fullName;}

    public Address getAddress(){return address;}

    public List<Post> getPosts(){return posts;}

    public void postItem(){}

    public void removePost(){}

    public void rateItem(){}

    public void putRecommendation(){}
}
