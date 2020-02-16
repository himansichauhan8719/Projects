package com.capgemini.forestrymanagementjdbc.services;

import java.util.List;

import com.capgemini.forestrymanagementjdbc.bean.ClientBean;
import com.capgemini.forestrymanagementjdbc.dao.ClientDao;
import com.capgemini.forestrymanagementjdbc.factory.Factory1;

public class ClientServicesImpl implements ClientSevices {
	ClientDao clientDao = Factory1.getClDao();

	@Override
	public boolean addClient(ClientBean bean) {
		return clientDao.addClient(bean);
	}

	@Override
	public boolean loginClient(int clientid, String clientpass) {
		return clientDao.loginClient(clientid, clientpass);
	}

	@Override
	public List<ClientBean> searchClient(int clientid) {
		// TODO Auto-generated method stub
		return clientDao.searchClient(clientid);
	}

	@Override
	public List<ClientBean> getAllClient() {
		// TODO Auto-generated method stub
		return clientDao.getAllClient();
	}

	@Override
	public boolean deleteClient(int clientid, String clientpass) {
		// TODO Auto-generated method stub
		return clientDao.deleteClient(clientid, clientpass);
	}

}
