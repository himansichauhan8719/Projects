package com.capgemini.forestrymanagementcollection.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementcollection.bean.LandBean;

class LandDaoTest {
	private LandDao landDao = new LandDaoImpl();
	LandBean landBean = new LandBean();

	
	@BeforeEach
	public void addLand( ) {
		landBean.setLandId(10);
		landBean.setLocation("kabbur");
		landBean.setOwnerName("abhi");
		landBean.setValue(10000);
		landDao.addLand(landBean);
	}
	

	@Test
	void testDeleteLand() {
		assertTrue(landDao.deleteLand(landBean.getLandId()));
	}

	@Test
	void testModifyLandLoc() {
		assertTrue(landDao.modifyLandLoc(landBean.getLandId(), "bgm"));
	}

	@Test
	void testModifyLandOwner() {
		assertTrue(landDao.modifyLandOwner(landBean.getLandId(), "khan"));
	}

	@Test
	void testModifyLandPrice() {
		assertTrue(landDao.modifyLandPrice(landBean.getLandId(), 11000));
	}

	@Test
	void testSearchLand() {
		assertNotNull(landDao.searchLand(landBean.getLandId()));
	}

	@Test
	void testGetAllLand() {
		assertNotNull(landDao.getAllLand());
	}

}
