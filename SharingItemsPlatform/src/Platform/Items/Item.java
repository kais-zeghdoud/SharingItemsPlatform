package Platform.Items;
import java.util.Date;

public class Item {
    private Category itemCategory;
    private String itemName;
    private String author;
    private Date releaseDate;
    private int recommendations;

    public Item(Category cat, String itemName, String author, Date releaseDate){
        itemCategory = cat;
        this.itemName = itemName;
        this.author = author;
        this.releaseDate = releaseDate;
        recommendations = 0;
    }

    public String toString(){

        return "";
    }

    public void increaseRecommendations(){

    }
}
