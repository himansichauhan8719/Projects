package com.capgemini.forestrymanagementcollection.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.forestrymanagementcollection.bean.ClientBean;
import com.capgemini.forestrymanagementcollection.exception.ClientExceptions;

public class ClientDaoImpl implements ClientDao {

	Scanner sc = new Scanner(System.in);
	List<ClientBean> clientList = new ArrayList<ClientBean>();
	ClientBean clientBean = new ClientBean();

	@Override
	public boolean addClient(ClientBean bean) {
		for (ClientBean clientBean : clientList) {
			if (clientBean.getClientId() == bean.getClientId()) {
				throw new ClientExceptions("Client Cannot be Added");
			}
		}
		clientList.add(bean);
		return true;
	}

	@Override
	public boolean loginClient(Object cid, String cpass) {
		for (ClientBean clientBean : clientList) {
			if (cid.equals(clientBean.getClientId()) && cpass.equals(clientBean.getClientPassword())) {
				return true;
			}
		}
		throw new ClientExceptions("Invalid Client");
	}

	@Override
	public List<ClientBean> searchClient(int clientId) {
		for (ClientBean clientBean : clientList) {
			if (clientBean.getClientId() == clientId) {
				return clientList;
			}
		}
		throw new ClientExceptions("Client Cannot be Found");
	}

	@Override
	public List<ClientBean> getAllClient() {
		if (clientList != null) {
			return clientList;
		}
		throw new ClientExceptions("No client Account present");

	}

	@Override
	public boolean deleteClient(int clientid) {
		for (ClientBean clientBean : clientList) {
			if (((clientBean.getClientId()) == clientid)) {
				clientList.remove(clientBean);
				return true;
			}
		}
		throw new ClientExceptions("Client Cannot be Deleted");
	}

	@Override
	public boolean updateClientName(int clientid, String name) {
		for (ClientBean clientBean : clientList) {
			if (clientid == clientBean.getClientId()) {
				clientBean.setClientName(name);
				return true;
			}
		}
		throw new ClientExceptions("Client name Cannot be Updated");
	}

	@Override
	public boolean updateClientPass(int clientid, String clientPassword) {
		for (ClientBean clientBean : clientList) {
			if (clientid == clientBean.getClientId()) {
				clientBean.setClientPassword(clientPassword);
				return true;
			}
		}
		throw new ClientExceptions("Client Password Cannot be Updated");
	}

}
