package rest.item.model;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.util.List;
import rest.item.dao.PlatformDao;


@XmlRootElement
public class Post {
	private String postID;
    private Item postedItem;
    private String posterID;
    private String description;
    private LocalDateTime postTime;
    private List<Rate> ratings;

    public Post(String posterID, Item item, String description) {
    	postID = "0" ;
        postedItem = item;
        this.posterID = posterID;
        this.description = description;
        postTime = LocalDateTime.now();
    }
    
    public String getID() {return postID;}

    public Item getItem(){return postedItem;}

    public String getPosterID(){return posterID;}

    public List<Rate> getRatings(){return ratings;}
    
    public String toString() {
    	return "\nPost ID : " + postID + "\nPost Time : " + postTime + "\nPoster's name : " + PlatformDao.instance.getUsers().get(posterID).getFullName()
    			+ "\nDescription : " + description +  postedItem.toString();
    }
    
    public float getAvgRates () {
    	float avg = (float) 0.0;
    	for (Rate r : ratings) {
    		avg += r.getRate();
    	}
    	return (float) avg/ratings.size();
    }
}
