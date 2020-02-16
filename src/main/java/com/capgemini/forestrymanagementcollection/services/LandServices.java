package com.capgemini.forestrymanagementcollection.services;

import java.util.List;

import com.capgemini.forestrymanagementcollection.bean.LandBean;

public interface LandServices {
	public boolean addLand(LandBean lbean);

	public boolean deleteLand(int landId);

	public boolean modifyLandLoc(int landId, String location);

	public boolean modifyLandOwner(int landId, String owner);

	public boolean modifyLandPrice(int landId, int value);

	public List<LandBean> searchLand(int s);

	public List<LandBean> getAllLand();

}
