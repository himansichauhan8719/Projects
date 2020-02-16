package com.capgemini.forestrymanagementcollection.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.forestrymanagementcollection.bean.LandBean;
import com.capgemini.forestrymanagementcollection.exception.LandExceptions;

public class LandDaoImpl implements LandDao {
	private List<LandBean> list = new ArrayList<LandBean>();
	LandBean landBean = new LandBean();

	@Override
	public boolean addLand(LandBean landObject) {
		for (LandBean landBean01 : list) {
			if (landBean01.getLandId() == landBean01.getLandId()) {
				throw new LandExceptions("Land Id Already Existed");

			}
		}
		list.add(landObject);
		return true;
	}

	@Override
	public boolean deleteLand(int landid) {
		for (LandBean landBean : list) {
			if (landid == landBean.getLandId()) {
				list.remove(landBean);
				return true;
			}
		}
		throw new LandExceptions("Land Details cannot be Deleted");
	}

	@Override
	public List<LandBean> searchLand(int landid) {
		for (LandBean landBean : list) {
			if (landid == landBean.getLandId()) {
				List<LandBean> l1 = new ArrayList<LandBean>();
				l1.add(landBean);
				return l1;
			}
		}
		throw new LandExceptions("Land Details Cannot be found");
	}

	@Override
	public List<LandBean> getAllLand() {
		List<LandBean> l = new ArrayList<LandBean>();
		for (LandBean landBean : list) {
			if (list != null && !list.isEmpty()) {
				l.add(landBean);
				return l;

			}
		}
		throw new LandExceptions("No Land Details Present");

	}

	@Override
	public boolean modifyLandLoc(int landid, String location) {
		for (LandBean landBean : list) {
			if (landBean.getLandId() == landid) {
				landBean.setLocation(location);
				return true;
			}
		}
		throw new LandExceptions("Land Location cannot be Modified");
	}

	@Override
	public boolean modifyLandOwner(int landid, String owner) {
		for (LandBean landBean : list) {
			if (landBean.getLandId() == landid) {
				landBean.setOwnerName(owner);
				return true;
			}
		}
		throw new LandExceptions("Land Owner cannot be Modified");
	}

	@Override
	public boolean modifyLandPrice(int landid, int value) {
		for (LandBean landBean : list) {
			if (landBean.getLandId() == landid) {
				landBean.setValue(value);
				return true;
			}
		}
		throw new LandExceptions("Land Value cannot be Modified");
	}

}
