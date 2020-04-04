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
    private List<Cart> inventories = new ArrayList<>();
    
    
	public User(String username) {
		this.username = username;
	}
	
	public  List<Cart> getInventories() {
		return this.inventories;
	}
	
	
}
