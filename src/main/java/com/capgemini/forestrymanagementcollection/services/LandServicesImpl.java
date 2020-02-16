package com.capgemini.forestrymanagementcollection.services;

import java.util.List;

import com.capgemini.forestrymanagementcollection.bean.LandBean;
import com.capgemini.forestrymanagementcollection.dao.LandDao;
import com.capgemini.forestrymanagementcollection.factory.Factory;

public class LandServicesImpl implements LandServices {
	private LandDao landDao = Factory.getLandDao();

	@Override
	public boolean addLand(LandBean landBean) {
		return landDao.addLand(landBean);
	}

	@Override
	public boolean deleteLand(int landId) {
		return landDao.deleteLand(landId);
	}

	@Override
	public List<LandBean> searchLand(int landId) {
		return landDao.searchLand(landId);
	}

	@Override
	public List<LandBean> getAllLand() {
		return landDao.getAllLand();
	}

	@Override
	public boolean modifyLandLoc(int landId, String location) {
		return landDao.modifyLandLoc(landId, location);
	}

	@Override
	public boolean modifyLandOwner(int landId, String owner) {
		return landDao.modifyLandOwner(landId, owner);
	}

	@Override
	public boolean modifyLandPrice(int landId, int value) {
		return landDao.modifyLandPrice(landId, value);
	}

}
