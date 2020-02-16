package com.capgemini.forestrymanagement.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.forestrymanagement.dto.Scheduler;
import com.capgemini.forestrymanagement.exception.SchedulerExceptions;

public class SchedulerDaoImpl implements SchedulerDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");

	@Override
	public boolean addScheduler(Scheduler scheduler) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		boolean a = false;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(scheduler);
			transaction.commit();
			a = true;
			return a;

		} catch (Exception e) {
			transaction.rollback();

		}
		entityManager.close();
		throw new SchedulerExceptions("Cannot be Added\nScheduler Id Already Present");
	}

	@Override
	public boolean loginScheduler(int schedulerId, String schedulerPassword) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {

			Scheduler scheduler = entityManager.find(Scheduler.class, schedulerId);
			entityManager.close();
			String role = "scheduler";
			if (scheduler.getSchedulerPassword().equals(schedulerPassword)
					&& scheduler.getRole().equalsIgnoreCase(role)) {
				return true;
			}
		} catch (Exception e) {
		}
		throw new SchedulerExceptions("Invalid Scheduler");

	}

	@Override
	public List<Scheduler> getAllScheduler() {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from Scheduler ";
		Query query = entityManager.createQuery(jpql);
		ArrayList<Scheduler> scheduler = (ArrayList<Scheduler>) query.getResultList();
		if (scheduler != null) {
			return scheduler;
		}
		entityManager.close();
		throw new SchedulerExceptions("No Scheduler Account present");

	}

	@Override
	public Scheduler searchScheduler(int schedulerId) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Scheduler scheduler = entityManager.find(Scheduler.class, schedulerId);
		String role = "scheduler";
		if (scheduler.getRole().equalsIgnoreCase(role)) {
			return scheduler;
		}
		entityManager.close();
		throw new SchedulerExceptions("Scheduler Cannot be Found");
	}

	@Override
	public boolean deleteScheduler(int schedulerId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from Scheduler where schedulerId = : sid ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("sid", schedulerId);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		entityManager.close();
		throw new SchedulerExceptions("Cannot be Deleted\nEnter Valid Scheduler Id");
	}

	public boolean modifyScheduler(int schedulerId, String schedulerName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update Scheduler set schedulerName = :sname where schedulerId = :sid ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("sname", schedulerName);
		query.setParameter("sid", schedulerId);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			System.out.println("Modification Successfulyy :)");
			return true;
		}
		entityManager.close();
		throw new SchedulerExceptions("Scheduler Name Cannot be Modified\nEnter valid Scheduler Id");
	}

	@Override
	public boolean modifySchedulerPass(int schedulerId, String schedulerPassword) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update Scheduler set schedulerName = :pass where schedulerId = :sid ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("pass", schedulerPassword);
		query.setParameter("sid", schedulerId);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			System.out.println("Modification Successfulyy :)");
			return true;
		}
		entityManager.close();
		throw new SchedulerExceptions("Scheduler Password Modification failed\nEnter Valid Scheduler Id");
	}

}
