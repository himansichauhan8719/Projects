package com.capgemini.forestrymanagementspringboot.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.forestrymanagementspringboot.dto.Admin;
import com.capgemini.forestrymanagementspringboot.exception.AdminExceptions;

@Repository
public class AdminDaoImpl implements AdminDao {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
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
		}
		throw new AdminExceptions("Duplicate Id Not Allowed");

	}

	@Override
	public Admin login(Admin admin) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		String jpql = "from Admin where name=:name";
		TypedQuery<Admin> query = manager.createQuery(jpql, Admin.class);
		query.setParameter("name",admin.getAdminName());
		try {
			Admin adminAccount = query.getSingleResult();
			if (adminAccount.getAdminPassword().equals(admin.getAdminPassword())) {
				return adminAccount;
			} 
		} catch (Exception e) {
			throw new AdminExceptions("Account does not exist");
		}
		return null;
	}

	

	}

