package com.capgemini.forestrymanagement.services;

import java.util.List;

import com.capgemini.forestrymanagement.dao.LandDao;
import com.capgemini.forestrymanagement.dto.Land;
import com.capgemini.forestrymanagement.factory.Factory;

public class LandServicesImpl implements LandServices {
	private LandDao landDao = Factory.landDaoImpl();

	@Override
	public boolean addLand(Land land) {
		return landDao.addLand(land);
	}

	@Override
	public boolean deleteLand(int landId) {
		return landDao.deleteLand(landId);
	}

	@Override
	public boolean modifyLand(int landId) {
		return false;
	}

	@Override
	public Land searchLand(int landId) {
		return landDao.searchLand(landId);
	}

	@Override
	public List<Land> getAllLand() {
		return landDao.getAllLand();
	}

}
