package com.capgemini.forestrymanagementcollection.services;

import java.util.List;

import com.capgemini.forestrymanagementcollection.bean.ClientBean;
import com.capgemini.forestrymanagementcollection.dao.ClientDao;
import com.capgemini.forestrymanagementcollection.factory.Factory;

public class ClientServicesImpl implements ClientServices {

	private ClientDao clientDao = Factory.clientIml();

	@Override
	public boolean addClient(ClientBean bean) {
		return clientDao.addClient(bean);
	}

	@Override
	public boolean loginClient(Object clientId, String clientPassword) {
		return clientDao.loginClient(clientId, clientPassword);
	}

	@Override
	public List<ClientBean> searchClient(int clientid) {
		return clientDao.searchClient(clientid);
	}

	@Override
	public List<ClientBean> getAllClient() {
		return clientDao.getAllClient();
	}

	@Override
	public boolean deleteClient(int clientid) {
		return clientDao.deleteClient(clientid);
	}

	@Override
	public boolean updateClientName(int clientid, String name) {
		return clientDao.updateClientName(clientid, name);
	}

	@Override
	public boolean updateClientPass(int clientid, String pass) {
		return clientDao.updateClientPass(clientid, pass);
	}

}
