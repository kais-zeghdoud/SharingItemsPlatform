package src.rest.Platform.Posts;
import src.rest.Platform.Items.Item;
import src.rest.Platform.Users.User;
import java.time.LocalDateTime;


public class Rate {
    private final int rateID;
    private Item ratedItem;
    private User ratingUser;
    private String text;
    private final LocalDateTime time;

    public Rate(int rateID, Item ratedItem, User ratingUser, String text) {
        this.rateID = rateID;
        this.ratedItem = ratedItem;
        this.ratingUser = ratingUser;
        this.text = text;
        time = LocalDateTime.now();
    }

    public String toString(){
        return "";
    }

}
