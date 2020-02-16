package com.capgemini.forestrymanagement.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.forestrymanagement.dto.Contracts;
import com.capgemini.forestrymanagement.exception.ContractsExceptions;

public class ContractDaoImpl implements ContractDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");

	public boolean addContract(Contracts contracts) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(contracts);
			transaction.commit();
			return true;

		} catch (Exception e) {
			transaction.rollback();
		}
		throw new ContractsExceptions("Cannot Be Added\nDuplicate Contract no not Allowed");

	}

	public boolean deleteContract(int contractNo) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from Contracts where contractNo =: cno ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("cno", contractNo);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			System.out.println("Delete Successfulyy :)");
			return true;
		}
		entityManager.close();
		throw new ContractsExceptions("cannot be Deleted\nEnter Valid Contract no ");
	}

	public Contracts getContract(int contractNo) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Contracts contracts = entityManager.find(Contracts.class, contractNo);
		if (contracts != null) {
			return contracts;
		}
		entityManager.close();
		throw new ContractsExceptions("Contract Cannot be Found\nEnter Valid Contract No");
	}

	public ArrayList<Contracts> getAllContract() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "from Contracts ";
		Query query = entityManager.createQuery(jpql);
		ArrayList<Contracts> contracts = (ArrayList<Contracts>) query.getResultList();
		for (Contracts contracts2 : contracts) {
			if (contracts2 != null) {
				return contracts;

			}
		}
		entityManager.close();
		throw new ContractsExceptions("No Contracts Present ");
	}

	@Override
	public boolean scheduleContracts(int contractNo, String date, String qty, String status) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update Contracts set deliveryDate = :date, quantity= :qty, status= :stat where contractNo = :cno ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("date", date);
		query.setParameter("qty", qty);
		query.setParameter("stat", status);
		query.setParameter("cno", contractNo);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		entityManager.close();
		throw new ContractsExceptions("Contract scheduled failed\nEnter Valid Contract No:");

	}

}
