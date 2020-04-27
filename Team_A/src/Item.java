import javax.persistence.*;
import java.util.*;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "cost")
	private float cost;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "storage")
	private String storage;
	
	@ManyToOne
	@JoinColumn(name="inventory_id", nullable=false)
	private Inventory inventory;
	
	public Item(Integer id, String name, float cost, int quantity, String storage) {
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.quantity = quantity;
		this.storage = storage;
	}
	
	public Item(String name, float cost, int quantity, String storage) {
		this.name = name;
		this.cost = cost;
		this.quantity = quantity;
		this.storage = storage;
	}
	
	public Item(String name, int quantity, String storage) {
		this.name = name;
		this.quantity = quantity;
		this.storage = storage;
	}
	
	public Item() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage = storage;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
}
