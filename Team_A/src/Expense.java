import javax.persistence.*;

@Entity
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="amount")
	private Double amount;
	
	@ManyToOne
	@JoinColumn(name="budget_id", nullable=false)
	private Budget budget;
	
	public Expense() {
		super();
	}
	public Expense(String name, Double amount) {
		this.name = name;
		this.amount = amount;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getAmount() {
		return this.amount;
	}
	
	public void setBudget(Budget budget) {
		this.budget = budget;
	}
	
	public Budget getBudget() {
		return this.budget;
	}
}
