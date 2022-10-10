package Platform;
import Platform.Posts.Post;
import Platform.Users.User;
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

    public void createUser(){}

    public void getItemsByCategory(){}

    public void getItemsByKeyword(){}

    public void getItemsByCity(){}

    public void getItemsByUser(){}
}
