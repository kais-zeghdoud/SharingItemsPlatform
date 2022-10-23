package rest.item.model;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;


@XmlRootElement
public class Rate {
	private final int rateID;
    private Item ratedItem;
    private User ratingUser;
    private String text;
    private final LocalDateTime time;
    private int rate;

    public Rate(int rateID, Item ratedItem, User ratingUser, String text, int rate) {
        this.rateID = rateID;
        this.ratedItem = ratedItem;
        this.ratingUser = ratingUser;
        this.text = text;
        time = LocalDateTime.now();
        this.rate = rate;
    }

    public String toString(){
        return "\n\nRate ID : " + rateID + "\nRated Item : " + ratedItem.getItemName() + 
        		"\nRated by : " + ratingUser.getFullName() + "\nAt : " + time + "\nRating : " + text;
    }
    
    public int getRate () {
    	return this.rate;
    }
    
    
}
