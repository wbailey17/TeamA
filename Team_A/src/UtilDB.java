/**
 */


import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @since JavaSE-1.8
 */
public class UtilDB {
   static SessionFactory sessionFactory = null;

   public static SessionFactory getSessionFactory() {
      if (sessionFactory != null) {
         return sessionFactory;
      }
      Configuration configuration = new Configuration().configure();
      StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
      sessionFactory = configuration.buildSessionFactory(builder.build());
      return sessionFactory;
   }

   public static List<Item> listInventory() {
      List<Item> resultList = new ArrayList<Item>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;

      try {
         tx = session.beginTransaction();
         List<?> inventory = session.createQuery("FROM Item").list();
         for (Iterator<?> iterator = inventory.iterator(); iterator.hasNext();) {
            Item item = (Item) iterator.next();
            resultList.add(item);
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }

   public static List<Item> listInventory(String keyword) {
      List<Item> resultList = new ArrayList<Item>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;

      try {
         tx = session.beginTransaction();
         List<?> inventory = session.createQuery("FROM Item").list();
         for (Iterator<?> iterator = inventory.iterator(); iterator.hasNext();) {
            Item item = (Item) iterator.next();
            if (item.getName().startsWith(keyword)) {
               resultList.add(item);
            }
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }

   public static Item createItem(String name, int cost, int quantity, String storage) {
      Session session = getSessionFactory().openSession();
      Transaction tx = null;
      Item item = new Item(name, cost, quantity, storage);
      try {
         tx = session.beginTransaction();
         session.save(item);
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return item;
   }
   
   public static void updateItem(Item item) {
	   Session session = getSessionFactory().openSession();
	   Transaction tx = null;
	   try {
		   tx = session.beginTransaction();
		   session.update(item);
		   tx.commit();
	   } catch (HibernateException e) {
		   if (tx != null)
			   tx.rollback();
		   e.printStackTrace();
	   } finally {
		   session.close();
	   }
   }
   
   public static void deleteItem(Item item) {
	   Session session = getSessionFactory().openSession();
	   Transaction tx = null;
	   try {
		   tx = session.beginTransaction();
		   session.delete(item);
		   tx.commit();
	   } catch (HibernateException e) {
		   if (tx != null)
			   tx.rollback();
		   e.printStackTrace();
	   } finally {
		   session.close();
	   }
   }
   
   public static void save(User user) {
	   Session session = getSessionFactory().openSession();
	   Transaction tx = null;
	   try {
		   tx = session.beginTransaction();
		   session.update(user);
		   tx.commit();
	   } catch (HibernateException e) {
		   if (tx != null)
			   tx.rollback();
		   e.printStackTrace();
	   } finally {
		   session.close();
	   }
   }
   
   public static User getUser(String username) {
	   Session session = getSessionFactory().openSession();
	   Transaction tx = null;
	   User user = null;
	   try {
		   tx = session.beginTransaction();
		   String sql = "SELECT * FROM User WHERE username = :user"; // prepared statement to get a specific user example
		   SQLQuery query = session.createSQLQuery(sql); // creates the actual query
		   query.addEntity(User.class); // maps to User Entity
		   query.setParameter("user", username);  
		   List users = query.list();
		   if(!users.isEmpty()) {
			   user = (User) users.get(0);
			   user.getInventories();
			   String tsql = "SELECT * FROM Inventory WHERE user_id = :id";
			   SQLQuery q = session.createSQLQuery(tsql);
			   q.addEntity(Inventory.class);
			   q.setParameter("id", user.getId());
			   List temp = q.list();
			   user.setInventories(temp);
		   }

		   
	   } catch (HibernateException e) {
		   if (tx != null)
			   tx.rollback();
		   e.printStackTrace();
	   } finally {
		   session.close();
	   }
	   return user;
   }
   
   public static Item updateItem(User user, String name, String newName, float cost, int number, String storage) {
	   Session session = getSessionFactory().openSession();
	   List<Item> temp = new ArrayList<>();
	   Item item = null;
	   Transaction tx = null;
	   try {
		   tx = session.beginTransaction();
		   /*String tsql = "SELECT * FROM Item WHERE inventory_id = :id";
		   SQLQuery q = session.createSQLQuery(tsql);
		   q.addEntity(Item.class);
		   q.setParameter("id", user.getInventories().get(0).getId());
		   List<?> inventory = q.list();
	       for (Iterator<?> iterator = inventory.iterator(); iterator.hasNext();) {
	            Item x = (Item) iterator.next();
	            temp.add(x);
	       }*/
		   session.saveOrUpdate(user.getInventories().get(0));
	  	   for(Item thing: user.getInventories().get(0).returnInventory()) {
				if(name.equalsIgnoreCase(thing.getName()))
				{
					item = thing;
				}
			}
	  	   if(item != null) {
	  		 if (cost > 0) {
					item.setCost(cost);
				}
				if (number != -1) {
					item.setQuantity(number);
				}
				if (!storage.equals("")) {
					item.setStorage(storage);
				}
				if (!newName.equals("")) {
					item.setName(newName);
				}
			  	session.saveOrUpdate(item);
	  	   }
		   tx.commit();
	   } catch (HibernateException e) {
		   if (tx != null)
			   tx.rollback();
		   e.printStackTrace();
	   } finally {
		   session.close();
	   }

	   return item;
   }
   
   public static List<Item> getInventory(User user) {
	   Session session = getSessionFactory().openSession();
	   Transaction tx = null;
	   List<Item> temp = new ArrayList<>();
	   try {
		   tx = session.beginTransaction();
		   //String tsql = "SELECT * FROM Item WHERE inventory_id = :id";
		   //SQLQuery q = session.createSQLQuery(tsql);
		   //q.addEntity(Item.class);
		   //q.setParameter("id", user.getInventories().get(0).getId());
		   //List<?> inventory = q.list();
		   session.saveOrUpdate(user.getInventories().get(0));
	       for (Item x: user.getInventories().get(0).returnInventory()) {
	            Item item = x;
	            temp.add(item);
	       }
		   tx.commit();
	   } catch (HibernateException e) {
		   if (tx != null)
			   tx.rollback();
		   e.printStackTrace();
	   } finally {
		   session.close();
	   }
	   return temp;
   }
   
   public static List<Item> searchInventory(User user, String keyword) {
	   List<Item> inventory = getInventory(user);
	   List<Item> matching = new ArrayList<>();
	   for(Item item: inventory) {
		   if(item.getName().toLowerCase().contains(keyword.toLowerCase())) {
			   matching.add(item);
		   }
	   }
	   return matching;
   }
   
   public static Item deleteItem(User user, String name) {
	   Session session = getSessionFactory().openSession();
	   Item item = null;
	   Transaction tx = null;
	   try {
		   tx = session.beginTransaction();
		   session.saveOrUpdate(user.getInventories().get(0));
		   item = user.getInventories().get(0).removeItem(name);
		   String tsql = "DELETE FROM Item WHERE inventory_id = :id and name = :name";
		   SQLQuery q = session.createSQLQuery(tsql);
		   q.addEntity(Item.class);
		   q.setParameter("id", user.getInventories().get(0).getId());
		   q.setParameter("name", item.getName());
		   q.executeUpdate();
		   tx.commit();
	   } catch (HibernateException e) {
		   if (tx != null)
			   tx.rollback();
		   e.printStackTrace();
	   } finally {
		   session.close();
	   }
	   return item;
   }
   
   public static boolean addItem(User user, Item item) {
	   Session session = getSessionFactory().openSession();
	   boolean exist = false;
	   Transaction tx = null;
	   try {
		   tx = session.beginTransaction();
		   session.saveOrUpdate(user.getInventories().get(0));
		   for(Item x : user.getInventories().get(0).returnInventory()) {
			   if(item.getName().equalsIgnoreCase(x.getName())) {
				   exist = true;
			   }
		   }
		   if(!exist) {
			   item.setInventory(user.getInventories().get(0));
			   user.getInventories().get(0).addToInventory(item);
			   session.saveOrUpdate(item);
		   }
		   session.saveOrUpdate(user.getInventories().get(0));
		   tx.commit();
	   } catch (HibernateException e) {
		   if (tx != null)
			   tx.rollback();
		   e.printStackTrace();
	   } finally {
		   session.close();
	   }
	   return exist;
   }
   
   public static void newUser(String username) {
	   Session session = getSessionFactory().openSession();
	   Transaction tx = null;
	   User user = new User(username);
	   Inventory in = new Inventory("inventory");
	   //Budget b =  new Budget("Budget 1", 1000.0);
	   in.setUser(user);
	  // b.setUser(user);
	   try {
		   tx = session.beginTransaction();
		   session.save(user);
		   session.save(in);
		  // session.save(b);
		   tx.commit();
	   } catch (HibernateException e) {
		   if (tx != null)
			   tx.rollback();
		   e.printStackTrace();
	   } finally {
		   session.close();
	   }
   }
   
   public static void test() {
	   Session session = getSessionFactory().openSession();
	   Transaction tx = null;
	   
	   try {
		   tx = session.beginTransaction();
		   String sql = "SELECT * FROM User WHERE user_id = :id"; // prepared statement to get a specific user example
		   SQLQuery query = session.createSQLQuery(sql); // creates the actual query
		   query.addEntity(User.class); // maps to User Entity
		   query.setParameter("id", 3); // gets the :id --> 2
		   List users = query.list(); // gets the result list == since its a where a unique id = a id then there will only get 1 result
		   User u = (User) users.get(0); // get the 1 result and make it as a user object
		   
		   String tsql = "SELECT * FROM Inventory WHERE user_id = :id";
		   SQLQuery q = session.createSQLQuery(tsql);
		   q.addEntity(Inventory.class);
		   q.setParameter("id", u.getId());
		   
		   List<Inventory> inventories = q.list();
		   
	         for (Iterator<?> iterator = inventories.iterator(); iterator.hasNext();) {
	        	 	Inventory i = (Inventory) iterator.next();
	        	 	System.out.println("I have:" + i.getName());
	          }
		   
		   tx.commit();
	   } catch (HibernateException e) {
		   if (tx != null)
			   tx.rollback();
		   e.printStackTrace();
	   } finally {
		   session.close();
	   }
	   
   }
   
   public static Budget getBudget(User user) {
	   Session session = getSessionFactory().openSession();
	   Transaction tx = null;
	   Budget budget = null;
	   try {
		   tx = session.beginTransaction();
		   String tsql = "SELECT * FROM Budget WHERE user_id = :id";
		   SQLQuery q = session.createSQLQuery(tsql);
		   q.addEntity(Budget.class);
		   q.setParameter("id", user.getId());
		   if( q.list().isEmpty()) { // if there is no Budget attached to the user than return nothing
			   return null;
		   }
		   budget = (Budget) q.list().get(0);
		   tx.commit();
	   } catch (HibernateException e) {
		   if (tx != null)
			   tx.rollback();
		   e.printStackTrace();
	   } finally {
		   session.close();
	   }
	   return budget;
   }
   
   public static Budget createBudget(User user, Budget budget) {
	   Session session = getSessionFactory().openSession();
	   Transaction tx = null;
	   User u = null;
		   try {
			   tx = session.beginTransaction();
//			   String tsql = "SELECT * FROM User WHERE user_id = :id";
//			   SQLQuery query = session.createSQLQuery(tsql);
//			   query.addEntity(User.class);
//			   query.setParameter("user_id", user.getId());
//			   u = (User) query.list().get(0);
			   user.setBudget(budget);
			   budget.setUser(user);
			   session.save(user);
			   session.save(budget);
			   tx.commit();
		   } catch (HibernateException e) {
			   if (tx != null)
				   tx.rollback();
			   e.printStackTrace();
		   } finally {
			   session.close();
		   }

	   return budget;
   }
   public static List<Expense> getExpenses(Budget budget){
	   Session session = getSessionFactory().openSession();
	   Transaction tx = null;
	   List<Expense> expenses = new ArrayList<>();
	   try {
		   tx = session.beginTransaction();
		   String tsql = "SELECT * FROM Expense WHERE budget_id = :id";
		   SQLQuery q = session.createSQLQuery(tsql);
		   q.addEntity(Expense.class);
		   q.setParameter("id", budget.getID());
		   expenses = q.list();
		   
		   tx.commit();
	   } catch (HibernateException e) {
		   if (tx != null)
			   tx.rollback();
		   e.printStackTrace();
	   } finally {
		   session.close();
	   }
	   return expenses;
   }
   
   public static void addExpense(Budget budget, Expense expense) {
	   Session session = getSessionFactory().openSession();
	   Transaction tx = null;
	   try {
		   tx = session.beginTransaction();
		   String tsql = "SELECT * FROM Budget WHERE id =:id";
		   SQLQuery q = session.createSQLQuery(tsql);
		   q.addEntity(Budget.class);
		   q.setParameter("id", budget.getID());
		   Budget b = (Budget) q.list().get(0);
		   b.addExpense(expense);
		   expense.setBudget(b);
		   session.save(b);
		   session.save(expense);
		   tx.commit();
	   } catch (HibernateException e) {
		   if (tx != null)
			   tx.rollback();
		   e.printStackTrace();
	   } finally {
		   session.close();
	   }
   }
}
