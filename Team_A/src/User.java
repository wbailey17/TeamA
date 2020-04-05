import java.util.*;
import javax.persistence.*;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer user_id;
	
	@Column(name="username")
	private String username;
	
    @OneToMany(mappedBy="user")
    private List<Cart> carts = new ArrayList<>();
    
    @OneToMany
    @JoinColumn(name="user_id")
    private List<Inventory> inventories = new ArrayList<>();
    
	public User(String username) {
		this.username = username;
	}
	
	public User() {
		super();
	}
	
	public  List<Cart> getCarts() {
		return this.carts;
	}
	
	public List<Inventory> getInventories(){
		return this.inventories;
	}
	
	public void setInventories(List<Inventory> i) {
		this.inventories = i;
	}
	public String getUsername() {
		return this.username;
	}
	
	public Integer getId() {
		return this.user_id;
	}
	
}
