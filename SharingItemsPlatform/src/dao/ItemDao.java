package dao;

import java.util.Date;
import java.util.HashMap;

import Platform.Items.Category;
import Platform.Items.Item;
import java.util.Map;

public class ItemDao {
	//instance;
	
	private Map<String, Item> itemProvider = new HashMap<>();
	
	@SuppressWarnings("deprecation")
	private ItemDao () {
		Item item = new Item(Category.book, "Le grand mort", "Regis Loisel", new Date (2007, 11, 14));
		itemProvider.put("1", item);
		item = new Item(Category.DVD, "Shutter Island", "Martin Scorses", new Date (2010, 2, 19));
		itemProvider.put("2", item);
		item = new Item(Category.musicCD, "Discovery", "Daft Punk", new Date (2001, 3, 12));
		itemProvider.put("3", item);
		item = new Item(Category.videoGame, "Subnautica", "Unknown Worlds", new Date (2018, 1, 23));
		itemProvider.put("4", item);
	}
	
	public Map<String, Item> getModel () {
		return itemProvider;
	}
}
