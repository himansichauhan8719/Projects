package com.capgemini.forestrymanagementspringboot.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.forestrymanagementspringboot.dto.Customer;
import com.capgemini.forestrymanagementspringboot.exception.CustomerExceptions;
@Repository
public class CustomerDaoImpl implements CustomerDao {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory ;

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
		Customer customer1 = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		customer1 = entityManager.find(Customer.class, customerId);
		if (customer1 != null) {
			return customer1;

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
	public boolean modifyCustomer(Customer customer) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update Customer set customerName = :cname, streetAdd1 =: sAdd1, streetAdd2 =: sAdd2,"
				+ " town=: twn, postalCode=: pcode, telephone=: tel, email=: eml where customerId = :cid ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("cname", customer.getCustomerName());
		query.setParameter("sAdd1", customer.getStreetAdd1());
		query.setParameter("sAdd2", customer.getStreetAdd2());
		query.setParameter("twn", customer.getTown());
		query.setParameter("pcode", customer.getPostalCode());
		query.setParameter("tel", customer.getTelephone());
		query.setParameter("eml", customer.getEmail());
		query.setParameter("cid", customer.getCustomerId());

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			System.out.println("Customer name Modified Successfulyy ");
			return true;
		}
		entityManager.close();
		throw new CustomerExceptions("Customer name Cannot be Modified\nEnter The Valid Customer Id:");

	}



}
