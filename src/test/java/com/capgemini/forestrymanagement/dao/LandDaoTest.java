package com.capgemini.forestrymanagement.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagement.dto.Land;

class LandDaoTest {

	private static LandDao landDao = new LandDaoImpl();
	private static Land land = new Land();
	
	@BeforeAll
	static void addLand( ) {
		land.setLandId(786);
		land.setDate("12/22/2020");
		land.setLocation("kabbur");
		land.setOwnerName("azad");
		land.setValue(10000);
		landDao.addLand(land);
	}
	
	@AfterAll
	static void deleteLand( ) {
		landDao.deleteLand(land.getLandId());
	}
	
	@Test
	void testAddLand() {
		Land land1 = new Land();
		land1.setLandId(7860);
		land1.setLocation("kabbur");
		land1.setOwnerName("azad");
		land1.setValue(10000);
		assertTrue(landDao.addLand(land1));
		landDao.deleteLand(land1.getLandId());
	}

	@Test
	void testDeleteLand() {
		Land land1 = new Land();
		land1.setLandId(7860);
		land1.setLocation("kabbur");
		land1.setOwnerName("azad");
		land1.setValue(10000);
		landDao.addLand(land1);
		assertTrue(landDao.deleteLand(land1.getLandId()));
	}


	@Test
	void testSearchLand() {
		assertNotNull(landDao.searchLand(land.getLandId()));
	}

	@Test
	void testGetAllLand() {
		assertNotNull(landDao.getAllLand());
	}

}
