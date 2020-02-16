package com.capgemini.forestrymanagement.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.forestrymanagement.dto.Customer;
import com.capgemini.forestrymanagement.exception.CustomerExceptions;

public class CustomerDaoImpl implements CustomerDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");

	public boolean addCustomer(Customer customer) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			entityManager.persist(customer);
			transaction.commit();
			return true;

		} catch (Exception e) {
			transaction.rollback();
		}
		entityManager.close();
		throw new CustomerExceptions("Cannot be Added\nDuplicate Customer Id not Allowed");

	}

	public boolean deleteCustomer(int customerId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from Customer where customerId = :cid ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("cid", customerId);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			System.out.println("Delete Successfulyy :)");
			return true;
		}
		throw new CustomerExceptions("Cannot be deleted\nEnter The Valid Customer Id:");

	}

	public Customer getCustomer(int customerId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.err.println(customerId);
		Customer customer = entityManager.find(Customer.class, customerId);
		if (customer != null) {
			return customer;

		}
		throw new CustomerExceptions("Customer Cannot be Found\nEnter The Valid Customer Id:");
	}

	public ArrayList<Customer> getAllCust() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from Customer ";
		Query query = entityManager.createQuery(jpql, Customer.class);
		ArrayList<Customer> customer = (ArrayList<Customer>) query.getResultList();
			if (customer != null && customer.size()!=0) {
				return customer;

			}
		throw new CustomerExceptions("Customer Details Are not Present ");
	}

	@Override
	public boolean modifyCustomer(int customerId, String customerName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update Customer set customerName = :cname where customerId = :cid ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("cname", customerName);
		query.setParameter("cid", customerId);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			System.out.println("Customer name Modified Successfulyy ");
			return true;
		}
		entityManager.close();
		throw new CustomerExceptions("Customer name Cannot be Modified\nEnter The Valid Customer Id:");

	}

	@Override
	public boolean modifyCustomerAdd1(int customerId, String address1) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update Customer set streetAdd1 = :add1 where customerId = :cid ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("add1", address1);
		query.setParameter("cid", customerId);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			System.out.println("Customer Street Address 1 Modified Successfulyy ");
			return true;
		}
		entityManager.close();
		throw new CustomerExceptions("Customer Street Address 1 Cannot be Modified\nEnter The Valid Customer Id:");

	}

	@Override
	public boolean modifyCustomerAdd2(int customerId, String address2) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update Customer set streetAdd2 = :add2 where customerId = :cid ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("add2", address2);
		query.setParameter("cid", customerId);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			System.out.println("Customer Street Address 2 Modified Successfulyy :)");
			return true;
		}
		entityManager.close();
		throw new CustomerExceptions("Customer Street Address 2 Cannot be Modified\nEnter The Valid Customer Id:");
	}

	@Override
	public boolean modifyCustomerTown(int customerId, String town) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update Customer set town = :twn where customerId = :cid ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("twn", town);
		query.setParameter("cid", customerId);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			System.out.println("Customer Town Modified Successfully :)");
			return true;
		}
		entityManager.close();
		throw new CustomerExceptions("Customer Town Cannot be Modified\nEnter The Valid Customer Id:");
	}

	@Override
	public boolean modifyCustomerEmail(int customerId, String emailId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update Customer set email = :eml where customerId = :cid ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("eml", emailId);
		query.setParameter("cid", customerId);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			System.out.println("Customer Email id Modified Successfully:)");
			return true;
		}
		entityManager.close();
		throw new CustomerExceptions("Customer Email id Cannot be Modified\nEnter The Valid Customer Id:");
	}

	@Override
	public boolean modifyCustomerPost(int customerId, int postCode) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update Customer set postalCode = :post where customerId = :cid ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("post", postCode);
		query.setParameter("cid", customerId);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			System.out.println("Postal code Modified Successfulyy :)");
			return true;
		}
		entityManager.close();
		throw new CustomerExceptions("Customer postal code Cannot be Modified\nEnter The Valid Customer Id:");
	}

	@Override
	public boolean modifyCustomerTel(int customerId, long telephone) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update Customer set telephone = :tel where customerId = :cid ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("tel", telephone);
		query.setParameter("cid", customerId);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			System.out.println("Modification Successfulyy :)");
			return true;
		}
		entityManager.close();
		throw new CustomerExceptions("Customer telephone Cannot be Modified\nEnter The Valid Customer Id:");
	}

}
