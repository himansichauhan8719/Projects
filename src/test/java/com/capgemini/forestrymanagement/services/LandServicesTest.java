package com.capgemini.forestrymanagement.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagement.dto.Land;

class LandServicesTest {
	private static LandServices landServices = new LandServicesImpl();
	private static Land land = new Land();
	
	@BeforeAll
	static void addLand( ) {
		land.setLandId(786);
		land.setDate("12/22/2020");
		land.setLocation("kabbur");
		land.setOwnerName("azad");
		land.setValue(10000);
		landServices.addLand(land);
	}
	
	@AfterAll
	static void deleteLand( ) {
		landServices.deleteLand(land.getLandId());
	}
	
	@Test
	void testAddLand() {
		Land land1 = new Land();
		land1.setLandId(7860);
		land1.setLocation("kabbur");
		land1.setOwnerName("azad");
		land1.setValue(10000);
		assertTrue(landServices.addLand(land1));
		landServices.deleteLand(land1.getLandId());
	}

	@Test
	void testDeleteLand() {
		Land land1 = new Land();
		land1.setLandId(7860);
		land1.setLocation("kabbur");
		land1.setOwnerName("azad");
		land1.setValue(10000);
		landServices.addLand(land1);
		assertTrue(landServices.deleteLand(land1.getLandId()));
	}


	@Test
	void testSearchLand() {
		assertNotNull(landServices.searchLand(land.getLandId()));
	}

	@Test
	void testGetAllLand() {
		assertNotNull(landServices.getAllLand());
	}
}
