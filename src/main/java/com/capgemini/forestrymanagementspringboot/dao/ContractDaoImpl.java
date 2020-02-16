package com.capgemini.forestrymanagementspringboot.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.forestrymanagementspringboot.dto.Contracts;
import com.capgemini.forestrymanagementspringboot.exception.ContractsExceptions;
@Repository
public class ContractDaoImpl implements ContractDao {
	
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory ;
	
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
		throw new ContractsExceptions("Cannot Be Added Duplicate Contract no not Allowed");

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
		throw new ContractsExceptions("cannot be Deleted Enter Valid Contract no ");
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
	public boolean scheduleContracts(Contracts contract) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update Contracts set customerId=:cid, prodId=:pid, deliveryDate = :date, quantity= :qty, status= :stat where contractNo = :cno ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("cid", contract.getCustomerId());
		query.setParameter("pid", contract.getProdId());
		query.setParameter("date", contract.getDeliveryDate());
		query.setParameter("qty", contract.getQuantity());
		query.setParameter("stat", contract.getStatus());
		query.setParameter("cno", contract.getContractNo());

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		entityManager.close();
		throw new ContractsExceptions("Contract scheduled failed Enter Valid Contract No:");

	}

}
