package rest.item.model;
import javax.xml.bind.annotation.XmlRootElement;

import java.text.SimpleDateFormat;


@XmlRootElement
public class Item {
    private Category itemCategory;
    private String itemName;
    private String author;
    private SimpleDateFormat releaseDate;
    private int recommendations;

    public Item(Category cat, String itemName, String author, SimpleDateFormat releaseDate){
        itemCategory = cat;
        this.itemName = itemName;
        this.author = author;
        this.releaseDate = releaseDate;
        recommendations = 0;
    }

    public String toString(){
        return "\nItem name : " + itemName + "\nItem category : " + itemCategory + "\nAuthor : " + author +
                /*"\nRelease Date : " + releaseDate.toString() +*/ "\nUsers recommendations : " + recommendations;
    }

    public Category getItemCategory(){return itemCategory;}

    public String getItemName(){return itemName;}
    
    public int getRecommendations(){return recommendations;}

    public void increaseRecommendations(){recommendations++;}
}
