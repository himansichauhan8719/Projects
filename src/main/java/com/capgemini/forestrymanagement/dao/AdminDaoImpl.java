package com.capgemini.forestrymanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.forestrymanagement.dto.Admin;
import com.capgemini.forestrymanagement.exception.AdminExceptions;

public class AdminDaoImpl implements AdminDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");

	@Override
	public boolean addAdmin(Admin admin) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(admin);
			transaction.commit();
			return true;

		} catch (Exception e) {
			throw new AdminExceptions("Duplicate Id Not Allowed");
		}

	}

	@Override
	public boolean loginAdmin(Object adminId, String adminPassword) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			Admin admin = entityManager.find(Admin.class, adminId);
			entityManager.close();
			String role = "admin";
			if (admin.getAdminPassword().equals(adminPassword) && admin.getRole().equalsIgnoreCase(role)) {
				return true;
			}
		} catch (Exception e) {
		}
		throw new AdminExceptions("Invalid Admin");

	}

	@Override
	public boolean deleteAdmin(int adminId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from Admin where adminId = :aid ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("aid", adminId);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			System.out.println("Delete Successfulyy :)");
			return true;
		}
		throw new AdminExceptions("Cannot be deleted\nEnter The Valid Admin Id:");

	}

}