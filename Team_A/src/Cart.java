import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private Integer cart_id;
	
	@Column(name = "name")
	private String name;
	
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    
    
    public Cart(String name) {
    	this.name = name;
    }
    
    
    public void setUser(User user) {
    	this.user = user;
    }
}
