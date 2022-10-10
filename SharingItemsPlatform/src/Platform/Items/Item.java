package Platform.Items;
import java.util.Date;

public class Item {
    private final int itemID;
    private Category itemCategory;
    private String itemName;
    private String author;
    private Date releaseDate;
    private int recommendations;

    public Item(int itemID){
        this.itemID = itemID;
    }

    public String toString(){

        return "";
    }

    public void increaseRecommendations(){

    }
}
