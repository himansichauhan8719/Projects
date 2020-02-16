package com.capgemini.forestrymanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.forestrymanagement.dto.Land;
import com.capgemini.forestrymanagement.exception.LandExceptions;

public class LandDaoImpl implements LandDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");

	@Override
	public boolean addLand(Land land) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		boolean l = false;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(land);
			transaction.commit();
			l = true;

		} catch (Exception e) {
			transaction.rollback();
			throw new LandExceptions("Land Cannot be Added\nLand Id already Existed");
		}
		entityManager.close();
		return l;

	}

	@Override
	public boolean deleteLand(int landId) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from Land where landId = :lid ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("lid", landId);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			System.out.println("Delete Successfulyy :)");
			return true;
		}
		throw new LandExceptions("Land Details Cannot be Deleted\nEnter Valid Land Id:");
	}

	@Override
	public boolean modifyLand(int landId) {
		return true;
	}

	@Override
	public Land searchLand(int landId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Land land = entityManager.find(Land.class, landId);
		if (land != null) {
			return land;
		}
		entityManager.close();
		throw new LandExceptions("Land Details cannot be Found\nEnter Valid Land Id");
	}

	@Override
	public List<Land> getAllLand() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "from Land ";
		Query query = entityManager.createQuery(jpql);
		List<Land> land = (List<Land>) query.getResultList();
		if (land != null) {
			return land;
		}
		entityManager.close();
		throw new LandExceptions("No Land Details Present");
	}

}
