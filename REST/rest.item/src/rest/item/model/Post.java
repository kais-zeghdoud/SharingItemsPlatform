package rest.item.model;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.util.List;
import rest.item.dao.PlatformDao;


@XmlRootElement
public class Post {
	private final int postID;
    private final Item postedItem;
    private final int posterID;
    private final String description;
    private LocalDateTime postTime;
    private List<Rate> ratings;
    private int recommendations;

    public Post(Item item, int posterID, String description) {
        //this.postID = PlatformDao.instance.getPosts().size() + 1;
    	postID = 0;
        postedItem = item;
        this.posterID = posterID;
        this.description = description;
        postTime = LocalDateTime.now();
        recommendations = 0;
    }

    public Item getItem(){return postedItem;}

    public int getPoster(){return posterID;}

    public List<Rate> getRatings(){return ratings;}

    public int getRecommendations(){return recommendations;}

    public void increaseRecommendations(){recommendations++;}
}
