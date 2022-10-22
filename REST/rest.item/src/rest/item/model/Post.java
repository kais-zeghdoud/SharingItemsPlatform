package rest.item.model;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.util.List;
import rest.item.dao.PlatformDao;


@XmlRootElement
public class Post {
	private final int postID;
    private final Item postedItem;
    private final User poster;
    private final String description;
    private LocalDateTime postTime;
    private List<Rate> ratings;
    private int recommendations;

    public Post(Item item, User user, String description) {
    	
        this.postID = PlatformDao.instance.getModel().size() + 1; // CHANGE !!!!!
        
        
        postedItem = item;
        poster = user;
        this.description = description;
        postTime = LocalDateTime.now();
        recommendations = 0;
    }

    public Item getItem(){return postedItem;}

    public User getPoster(){return poster;}

    public List<Rate> getRatings(){return ratings;}

    public int getRecommendations(){return recommendations;}

    public void increaseRecommendations(){recommendations++;}
}
