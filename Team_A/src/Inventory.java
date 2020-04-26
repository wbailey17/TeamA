import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inventory_id")
	private Integer inventory_id;
	
	@Column(name = "name")
	private String name;
	
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
	// TODO replace 'object' with item class
    
    @OneToMany()
    @JoinColumn(name="inventory_id")
	private List<Item> inventory;
	
	public Inventory(List<Item> inventory)
	{
		this.inventory = inventory;
	}
	
	public Inventory(String name) {
		this.name = name;
	}
	
	public Inventory() {
		super();
	}

	// TODO replace 'object' with item class
	public void addToInventory(Item item) {
		// TODO add to database
		inventory.add(item);
	}
	
	// TODO replace 'object' with item class
	public Item removeItem(String item) {
		Item thing = null; 
		thing = searchForExactItem(item);
		if(thing != null ) {
			// TODO delete from database
			//UtilDB.deleteItem(thing);
			inventory.remove(thing);
		}
		return thing;
	}
	
	public int getQuantity(String item)
	{
		Item thing = searchForExactItem(item);
		int quantity = -1;
		if(thing != null){
			quantity = thing.getQuantity();
		}
		return quantity;
	}
	
	public void setQuantity(String item, int amount)
	{
		Item thing = searchForExactItem(item);
		if(thing != null) {
			// TODO update database
			thing.setQuantity(amount);
		}
	}
	
	public void setStorageType(String item, String storage)
	{
		Item thing = searchForExactItem(item);
		if(thing != null) {
			thing.setStorage(storage);
		}
	}
	
	public String getStorageType(String item)
	{
		Item thing = searchForExactItem(item);
		String storage = null;
		if(thing != null) {
			storage = thing.getStorage();
		}
		return storage;
	}
	
	public void setCost(String item, int cost)
	{
		Item thing = searchForExactItem(item);
		if(thing != null) {
			thing.setCost(cost);
		}
	}
	
	public int getCost(String item)
	{
		Item thing = searchForExactItem(item);
		int cost = -1;
		if(thing != null) {
			cost = thing.getCost();
		}
		return cost;
	}
	
	// TODO replace 'object'
	private Item searchForExactItem(String item)
	{
		for(Item thing: inventory) {
			if(item.equalsIgnoreCase(thing.getName()))
			{
				return thing;
			}
		}
		return null;
	}
	
	public List<Item> itemsStartingWith(String keyword){
		List<Item> resultList = new ArrayList<Item>();
		for (Item item: inventory) {
			if (item.getName().startsWith(keyword)) {
	               resultList.add(item);
	            }
		}
		return resultList;
	}
	
	public Item updateItem(String name, String newName, int newCost, int newQuantity, String newStorage) {
		Item item = searchForExactItem(name);
		if (item != null) {
			if (newCost != -1) {
				item.setCost(newCost);
			}
			if (newQuantity != -1) {
				item.setQuantity(newQuantity);
			}
			if (!newStorage.equals("")) {
				item.setStorage(newStorage);
			}
			if (!newName.equals("")) {
				item.setName(newName);
			}
			//UtilDB.updateItem(item);
			return item;
		}
		return new Item();
	}
	
	public List<Item> returnInventory()
	{
		return inventory;
	}
	
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		return this.name;
	}
	public int getId() {
		return this.inventory_id;
	}
}
