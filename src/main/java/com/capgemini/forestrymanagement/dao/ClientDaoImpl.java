package com.capgemini.forestrymanagement.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.forestrymanagement.dto.Client;
import com.capgemini.forestrymanagement.exception.ClientExceptions;

public class ClientDaoImpl implements ClientDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");

	@Override
	public boolean addClient(Client client) {

		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(client);
			transaction.commit();
			return true;

		} catch (Exception e) {
			transaction.rollback();
			throw new ClientExceptions("Duplicate Clients Not Allowed :(");
		}

	}

	@Override
	public boolean loginClient(int clientId, String clientPassword) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			Client client = entityManager.find(Client.class, clientId);
			entityManager.close();

			String role = "client";
			if (client.getClientPassword().equals(clientPassword) && client.getRole().equalsIgnoreCase(role)) {
				return true;
			}
		} catch (Exception e) {
		}
		throw new ClientExceptions("Invalid Client Account");
	}

	@Override
	public List<Client> searchClient(int clientId) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Client client = entityManager.find(Client.class, clientId);
		if (client != null) {
			return (List<Client>) client;
		}
		throw new ClientExceptions("No clients present\nEnter valid Client Id");
	}

	@Override
	public List<Client> getAllClient() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "from Client ";
		Query query = entityManager.createQuery(jpql);
		ArrayList<Client> a = (ArrayList<Client>) query.getResultList();
		entityManager.close();
		for (Client client : a) {
			if (a != null && !a.isEmpty()) {
				return a;
			}
		}
		throw new ClientExceptions("No Clients Present");
	}

	@Override
	public boolean deleteClient(int clientId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from Client where clientId = :cid ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("cid", clientId);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			System.out.println("Delete Successfulyy :)");
			return true;
		}
		entityManager.close();
		throw new ClientExceptions("Cannot be Deleted\nPlease Enter Valid Client Id");

	}

}
