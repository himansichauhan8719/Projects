package com.capgemini.forestrymanagement.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.forestrymanagement.dto.Product;
import com.capgemini.forestrymanagement.exception.ProductExceptions;

public class ProductDaoImpl implements ProductDao {
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");

	@Override
	public boolean addProduct(Product p) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(p);
			transaction.commit();
			return true;

		} catch (Exception e) {
			transaction.rollback();
			throw new ProductExceptions("Product Cannot be Added\nProduct Id already Existed");
		}

	}

	@Override
	public boolean deleteProduct(int productId) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from Product where productId = :pid ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("pid", productId);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			System.out.println("Delete Successfulyy :)");
			return true;
		}
		entityManager.close();
		throw new ProductExceptions("Product Cannot be Deleted Enter Valid Product Id");
	}

	@Override
	public boolean modifyProduct(int productId, String productName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update Product set productName = :pname where productId = :pid ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("pname", productName);
		query.setParameter("pid", productId);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			System.out.println("Product Modified Successfulyy :)");
			return true;
		}
		entityManager.close();
		throw new ProductExceptions("Product Cannot be Modified\nEnter Valid Product Id");

	}

	@Override
	public Product getProduct(int productId) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Product product = entityManager.find(Product.class, productId);
		if (product != null) {
			return product;
		}
		entityManager.close();

		throw new ProductExceptions("Product Cannot be found\nEnter valid Product Id");
	}

	@Override
	public ArrayList<Product> getAllProduct() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "from Product ";
		Query query = entityManager.createQuery(jpql);
		ArrayList<Product> product = (ArrayList<Product>) query.getResultList();
		for (Product product2 : product) {
			if (product2 != null) {
				return product;
			}
		}
		entityManager.close();
		throw new ProductExceptions("No Products Present");
	}

}
