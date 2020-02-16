package com.capgemini.forestrymanagementcollection.services;

import java.util.List;

import com.capgemini.forestrymanagementcollection.bean.ClientBean;

public interface ClientServices {
	public boolean addClient(ClientBean bean);

	public boolean loginClient(Object clientId, String clientPassword);

	public List<ClientBean> searchClient(int clientid);

	public List<ClientBean> getAllClient();

	public boolean deleteClient(int clientid);

	public boolean updateClientName(int clientid, String name);

	public boolean updateClientPass(int clientid, String pass);
}
