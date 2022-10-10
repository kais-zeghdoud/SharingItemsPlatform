package Platform.Posts;
import Platform.Items.Item;
import Platform.Users.User;
import java.time.LocalDateTime;
import java.util.List;

public class Post {
    private final int postID;
    private Item postedItem;
    private User poster;
    private String description;
    private LocalDateTime postTime;
    private List<Rate> ratings;

    public Post(int postID) {
        this.postID = 0;
    }

    public Item getPostedItem(){return postedItem;}

    public List<Rate> getRatings(){return ratings;}
}
