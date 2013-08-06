package com.dicks.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import com.dicks.engine.Parcel;
import com.dicks.pojo.Store;
import com.dicks.pojo.Inventory;
import com.dicks.pojo.OrderDetail;
import com.dicks.pojo.Orders;
import com.dicks.pojo.Product;

public class InventoryDao extends BaseDao<Inventory> {
	private static InventoryDao instance = new InventoryDao();

	public static InventoryDao getInstance() {
		return instance;
	}

	public static void setInstance(InventoryDao instance) {
		InventoryDao.instance = instance;
	}

	public InventoryDao() {
		super(Inventory.class);
	}
	
	public void createInventory(Inventory inventory) throws Exception {
		super.create(inventory);
	}
	
	public Inventory getInventoryByStoreProduct(int storeId, int productId) throws Exception {
		List<Criterion> criterions = new ArrayList<Criterion>();
		Criterion criterion1 = Restrictions.eq("store.id", storeId);
		Criterion criterion2 = Restrictions.eq("product.id", productId);
		criterions.add(criterion1);
		criterions.add(criterion2);
		return super.get(criterions);
	}

	public boolean containNumProduct(Store store, Product product, int num) throws Exception {
		Inventory inventory = getInventoryByStoreProduct(store.getStoreId(), product.getProdId());
		
		if (inventory == null) return false;
		
		if (inventory.getInventory() - inventory.getSafetyStock() < num) return false;
		return true;
	}
	
	public boolean containProduct(Store store, Product product) throws Exception  {
		return containNumProduct(store, product, 1);
	}
	
	public boolean containAllroductsParcel(Store store, Parcel parcel) throws Exception {
		HashMap<Product, Integer> products = parcel.getProducts();
		Set<Product> productSet = products.keySet();
		
		List<Criterion> criterion = new ArrayList<Criterion>();
		Disjunction disjunctions = Restrictions.disjunction();
		
		for (Product p : productSet) {
			disjunctions.add(Restrictions.conjunction()
							.add(Restrictions.eq("store.id", store.getStoreId()))
							.add(Restrictions.eq("product.id", p.getProdId())));
		}
		criterion.add(disjunctions);
		
		return (int) super.getCount(criterion) == productSet.size();
	}
	
	public boolean containAnyProductOrder(Store store, Orders order) throws Exception {
		OrderDetailDAO orderDetailDAO = OrderDetailDAO.getInstance();
		
		ArrayList<OrderDetail> orderDetails = orderDetailDAO.getOrderDetailssByOrder(order.getOrderId());
		
		List<Criterion> criterion = new ArrayList<Criterion>();
		Disjunction disjunctions = Restrictions.disjunction();
		
		for (OrderDetail orderDetail : orderDetails) {
			Product p = orderDetail.getProduct();
			disjunctions.add(Restrictions.conjunction()
							.add(Restrictions.eq("store.id", store.getStoreId()))
							.add(Restrictions.eq("product.id", p.getProdId())));
		}
		criterion.add(disjunctions);
		return (int) super.getCount(criterion) > 0;		
	}
}