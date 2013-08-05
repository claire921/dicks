package Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dicks.dao.RuleDAO;
import com.dicks.dao.impl.RuleDAOImpl;
import com.dicks.pojo.Customer;
import com.dicks.pojo.Fee;
import com.dicks.pojo.Inventory;

import com.dicks.pojo.OrderDetail;

import com.dicks.pojo.PackageDetail;
import com.dicks.pojo.Product;
import com.dicks.pojo.Rule;

import com.dicks.pojo.Store;
import com.dicks.pojo.User;
import com.dicks.pojo.Vendor;


public class HibernateTest
{
	private static SessionFactory sessionFactory;
	
	static
	{
		try
		{
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception
	{
<<<<<<< HEAD
		Fee fee= new Fee();
		fee.setAttribute("adf");
		fee.setCostName("Nike");
		fee.setFlag('a');;
		fee.setPercentage(134);
		fee.setShippingType("store");
		fee.setValue(345);
=======
>>>>>>> branch 'master' of https://github.com/claire921/dicks.git
		
<<<<<<< HEAD
//		User user = new User();
//		user.setEmail("ssd");
//		user.setPassword("sgsg");
//		user.setUserName("aa");
		
		Rule rule = new Rule("ad", "dfgadg", "sdgd", 1, 'd', 'd', 'd', "sdgdgfs", "sdfgsdfg", "sfggfd", "sgds", "sgfdg", "sdfggfd");
	
//		RuleCategory rc = new RuleCategory();
//		rc.setRule(rule);
//		rc.setRuleID(rule.getRuleID());
//		rc.setCategoryID(2);
//		rc.setIsProductRelated(false);
		
//		Set<RuleCategory> set = new HashSet<RuleCategory>();
//		set.add(rc);
//
//		rule.setRuleCategorys(set);

=======
//		Rule rule = new Rule("ad", "dfgadg", "sdgd", 1, "d", 'd', 'd', "sdgdgfs", "sdfgsdfg", "sfggfd", "sgds", "sgfdg", "sdfggfd");
//		
//		RuleDAO ruleDAOImpl =  RuleDAOImpl.getInstance();
//		ruleDAOImpl.createRule(rule);

		
//		Fee fee= new Fee();
//		fee.setAttribute("afaf");
//		fee.setCostName("Nike");
//		fee.setFlag('a');;
//		fee.setPercentage(134);
//		fee.setShippingType("dfagda");
//		fee.setValue(234);
//		
////		User user = new User();
////		user.setEmail("ssd");
////		user.setPassword("sgsg");
////		user.setUserName("aa");
//		
//		Rule rule = new Rule("ad", "dfgadg", "sdgd", 1, "d", 'd', 'd', "sdgdgfs", "sdfgsdfg", "sfggfd", "sgds", "sgfdg", "sdfggfd");
//	
//		Vendor vendor = new Vendor();
//		vendor.setAddress("sfdg");
//		vendor.setVendorName("sgdsd");
//		vendor.setZip("23424");
//		
//		RuleCategory rc = new RuleCategory();
//		rc.setCategoryID(2);
//		rc.setIsProductRelated(false);
//		
//		Set<RuleCategory> set = new HashSet<RuleCategory>();
//		set.add(rc);
//
//		rule.setRuleCategorys(set);
//		
//		Store store = new Store();
//		store.setAddress("sdgsdfg");
//		store.setStoreName("sdgds");
//		store.setZip("sdgsd");
//		
//		
//		Product product = new Product();
//		product.setFactoryPrice(123);
//		product.setFlag("g");
//		product.setHeight(323.43);
//		product.setLength(45.34);
//		product.setProductDescr("fhs");
//		product.setProductName("shfsh");
//		product.setSku("sfhfhsfhfsh");
//		product.setVendorID(45);
//		
		Order order = new Order(55,'g',new java.sql.Date(2003, 5, 4), "sg","dsggd","sfdg","gddfg");
//		
//		Inventory inventory = new Inventory();
//		inventory.setProductID(2);
//		inventory.setRetailPrice(234);
//		inventory.setSaftyStock(343);
//		inventory.setStorage(343);
//		inventory.setStoreID(435);
//		
//		
		Customer customer = new Customer();
		customer.setAddress("gsdgdf");
		customer.setCustomerName("sfdgsdg");
		customer.setPassword("sdgsdfg");
		customer.setSex('m');
		customer.setTel("gddgd");
		customer.setZip("sfhsdfg");
		customer.getOrderses().add(order);
//			
>>>>>>> branch 'master' of https://github.com/claire921/dicks.git
		Session session = sessionFactory.openSession();
		Transaction tx = null;
<<<<<<< HEAD
	
=======
		
//		Package package1 = new Package();
//		package1.setCustomerID(2);
//		package1.setDeliveryDate(new java.sql.Date(20000));
//		package1.setOrderID(43);
//		package1.setShippingCompany("fedex");
//		package1.setShippingDay(32);
//		package1.setShippingStatus('d');
//		package1.setTotalAmount(34);
//		package1.setWeight(45.43);
//		
//		PackageDetail pd = new  PackageDetail();
//		pd.setPackageID(1);
//		pd.setProductID(3);
//		pd.setQty(32);
//		pd.setUnitPrice(24);
//		
//		OrderDetail od = new OrderDetail();
//		od.setOrderID(2);
//		od.setProductID(3);
//		od.setQty(13);
//		od.setUnitPrice(43);
//		
//		ProductCategory pc = new ProductCategory();
//		pc.setCategoryDescr("dfgsgsf");
//		pc.setCategoryName("sdgf");
//		pc.setProdCategoryID(2);
//		pc.setProdID(4);
//		
//		StoreCategory sc = new StoreCategory();
//		sc.setCategoryDescr("dfgsgsf");
//		sc.setCategoryName("sdgf");
//		sc.setStoreCategoryID(1);
//		sc.setStoreID(4);
//		
//		
>>>>>>> branch 'master' of https://github.com/claire921/dicks.git
		try
		{
			tx = session.beginTransaction();
			
<<<<<<< HEAD
			session.save(fee);
//			session.save(user);
			session.save(rule);
			
			RuleCategory rc = new RuleCategory();
			rc.setRule(rule);
			rc.setRuleID(rule.getRuleID());
			rc.setCategoryID(2);
			rc.setIsProductRelated(false);
			
			session.save(rc);

=======
//			session.save(fee);
////			session.save(user);
////			session.save(rule);
//			session.save(vendor);
//			session.save(store);
//			session.save(product);
//			session.save(order);
//			session.save(inventory);
//			session.save(customer);
			//session.save(package1);
//			session.save(pd);
			session.save(customer);
>>>>>>> branch 'master' of https://github.com/claire921/dicks.git
			tx.commit();
		}
		catch(Exception ex)
		{
			if(null != tx)
			{
				tx.rollback();
			}
			
			ex.printStackTrace();
		}
		finally
		{
			session.close();
<<<<<<< HEAD
		}	
=======
		}
>>>>>>> branch 'master' of https://github.com/claire921/dicks.git
	}
}
