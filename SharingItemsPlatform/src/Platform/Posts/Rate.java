package Platform.Posts;
import Platform.Items.Item;
import Platform.Users.User;

import java.time.LocalDateTime;

public class Rate {
    private final int rateID;
    private Item ratedItem;
    private User ratingUser;
    private String text;
    private LocalDateTime time;

    public Rate(int rateID) {
        this.rateID = rateID;
    }

    public String toString(){
        return "";
    }
}
