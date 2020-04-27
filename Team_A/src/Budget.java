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
    
    @OneToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
	
	public Budget(String name, Double income) {
		this.name = name;
		this.income = income;
	}
	public Budget() {
		super();
	}

	public Integer getID() {
		return this.id;
	}
	public void setUser(User user) {
		this.user = user;
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
	public Double getIncome() {
		return this.income;
	}
	public List<Expense> getExpenses(){
		return this.expenses;
	}
	
	public void setExpenses(List<Expense> e) {
		this.expenses = e;
	}
	
	public void addExpense(Expense e) {
		this.expenses.add(e);
	}
	
	public Expense removeExpense(String expense) {
		Expense e = null;
		e = this.searchForExpense(expense);
		if (e != null) {
			this.expenses.remove(e);
			return e;
		} else {
			return null; // returns null if Expense does not exist in list
		}
	}
	
	public void setExpenseName(String expense, String name) {
		Expense e = null;
		e = this.removeExpense(expense);
		if( e != null) {
			e.setName(name);
			System.out.println("Successfully changed name!");
		} 
	}
	
	public Expense getExpense(String expense) {
		Expense e = this.searchForExpense(expense);
		return (e != null) ? e : null; // if the expense is found then return the object else nothing
	}
	
	public void updateExpenseAmount(String expense, Double amount) {
		Expense e = this.getExpense(expense);
		if (e != null) {
			e.setAmount(amount);
		}
	}
	
	public Double getExpenseAmount(String expense) {
		return this.getExpense(expense).getAmount();
	}
	
	
	public Expense searchForExpense(String expense) {
		for(Expense e: this.getExpenses()) {
			if(expense.equals(e.getName()))
			{
				return e;
			}
		}
		return null;
	}
}
