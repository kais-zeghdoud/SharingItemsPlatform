package Platform.Items;
import java.util.Date;

public class Item {
	private String id;
    private Category itemCategory;
    private String itemName;
    private String author;
    private Date releaseDate;
    private int recommendations;

    public Item(String id, Category cat, String itemName, String author, Date releaseDate){
    	this.id = id;
        itemCategory = cat;
        this.itemName = itemName;
        this.author = author;
        this.releaseDate = releaseDate;
        recommendations = 0;
    }

    public String toString(){
        return "Item name : " + itemName + "\nId : " + id + "\nItem category : " + itemCategory + "\nAuthor : " + author +
                "\nRelease Date : " + releaseDate + "Users recommendations : " + recommendations;
    }

    public Category getItemCategory(){return itemCategory;}

    public String getItemName(){return itemName;}
    
    public String getId() {
    	return id;
    }
}
