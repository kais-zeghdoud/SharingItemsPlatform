package rest.item.model;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;


@XmlRootElement
public class Item {
	private int id;
    private Category itemCategory;
    private String itemName;
    private String author;
    private Date releaseDate;
    private int recommendations;

    public Item(int id, Category cat, String itemName, String author, Date releaseDate){
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
    
    public int getId() {
    	return id;
    }
}
