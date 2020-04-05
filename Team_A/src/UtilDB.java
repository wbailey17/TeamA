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
}
