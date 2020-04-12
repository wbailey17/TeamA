import java.util.List;
import javax.persistence.*;

@Entity
public class Budget {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "income")
	private Double income;
	
    @OneToMany()
    @JoinColumn(name="budget_id")
	private List<Expense> expenses;
	
	public Budget(String name, Double income) {
		this.name = name;
		this.income = income;
	}
	public Budget() {
		super();
	}

	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setIncome(Double income) {
		this.income = income;
	}
	
	public List<Expense> getExpenses(){
		return this.expenses;
	}
	
	public void setExpenses(List<Expense> e) {
		this.expenses = e;
	}
}
