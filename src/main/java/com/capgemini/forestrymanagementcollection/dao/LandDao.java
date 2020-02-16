package com.capgemini.forestrymanagementcollection.dao;

import java.util.List;

import com.capgemini.forestrymanagementcollection.bean.LandBean;

public interface LandDao {
	public boolean addLand(LandBean lbean);

	public boolean deleteLand(int landid);

	public boolean modifyLandLoc(int landid, String location);

	public boolean modifyLandOwner(int landid, String owner);

	public boolean modifyLandPrice(int landid, int value);

	public List<LandBean> searchLand(int landid);

	public List<LandBean> getAllLand();

}
