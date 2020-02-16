package com.capgemini.forestrymanagementcollection.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementcollection.bean.LandBean;

class LandServicesTest {
	
	private LandServices landServices = new LandServicesImpl();
	LandBean landBean = new LandBean();

	
	@BeforeEach
	public void addLand( ) {
		landBean.setLandId(10);
		landBean.setLocation("kabbur");
		landBean.setOwnerName("abhi");
		landBean.setValue(10000);
		landServices.addLand(landBean);
	}
	

	@Test
	void testDeleteLand() {
		assertTrue(landServices.deleteLand(landBean.getLandId()));
	}

	@Test
	void testModifyLandLoc() {
		assertTrue(landServices.modifyLandLoc(landBean.getLandId(), "bgm"));
	}

	@Test
	void testModifyLandOwner() {
		assertTrue(landServices.modifyLandOwner(landBean.getLandId(), "khan"));
	}

	@Test
	void testModifyLandPrice() {
		assertTrue(landServices.modifyLandPrice(landBean.getLandId(), 11000));
	}

	@Test
	void testSearchLand() {
		assertNotNull(landServices.searchLand(landBean.getLandId()));
	}

	@Test
	void testGetAllLand() {
		assertNotNull(landServices.getAllLand());
	}

}
