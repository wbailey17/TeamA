import java.util.List;

public class Inventory {
	
	// TODO replace 'object' with item class
	private List<Item> inventory;
	
	public Inventory(List<Item> inventory)
	{
		this.inventory = inventory;
	}

	// TODO replace 'object' with item class
	public void addToInventory(Item item) {
		// TODO add to database
		inventory.add(item);
	}
	
	// TODO replace 'object' with item class
	public void removeItem(String item) {
		Item thing = searchForItem(item);
		if(thing != null ) {
			// TODO delete from database
			inventory.remove(thing);
		}
	}
	
	public int getQuantity(String item)
	{
		Item thing = searchForItem(item);
		int quantity = -1;
		if(thing != null){
			quantity = thing.getQuantity();
		}
		return quantity;
	}
	
	public void setQuantity(String item, int amount)
	{
		Item thing = searchForItem(item);
		if(thing != null) {
			// TODO update database
			thing.setQuantity(amount);
		}
	}
	
	public void setStorageType(String item, String storage)
	{
		Item thing = searchForItem(item);
		if(thing != null) {
			thing.setStorage(storage);
		}
	}
	
	public String getStorageType(String item)
	{
		Item thing = searchForItem(item);
		String storage = null;
		if(thing != null) {
			storage = thing.getStorage();
		}
		return storage;
	}
	
	public void setCost(String item, int cost)
	{
		Item thing = searchForItem(item);
		if(thing != null) {
			thing.setCost(cost);
		}
	}
	
	public int getCost(String item)
	{
		Item thing = searchForItem(item);
		int cost = -1;
		if(thing != null) {
			cost = thing.getCost();
		}
		return cost;
	}
	
	// TODO replace 'object'
	private Item searchForItem(String item)
	{
		for(Item thing: inventory) {
			if(thing.getName() == item)
			{
				return thing;
			}
		}
		return null;
	}
	
	public Item updateItem(String name, String newName, int newCost, int newQuantity, String newStorage) {
		Item item = searchForItem(name);
		if (newName != null) {
			item.setName(name);
		}
		if (newCost != -1) {
			item.setCost(newCost);
		}
		if (newQuantity != -1) {
			item.setQuantity(newQuantity);
		}
		if (newStorage != null) {
			item.setStorage(newStorage);
		}
		UtilDB.updateItem(item);
		return item;
	}
	
	public List<Item> returnInventory()
	{
		return inventory;
	}
	
}
