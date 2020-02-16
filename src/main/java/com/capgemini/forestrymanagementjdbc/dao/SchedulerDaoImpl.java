package com.capgemini.forestrymanagementjdbc.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.capgemini.forestrymanagementjdbc.bean.SchedulerBean;
import com.capgemini.forestrymanagementjdbc.exception.SchedulerExceptions;
import com.capgemini.forestrymanagementjdbc.factory.Factory1;

public class SchedulerDaoImpl implements SchedulerDao {

	FileReader filerReader;
	Properties properties;
	SchedulerBean schedulerBean = Factory1.getSchedBean();

	public SchedulerDaoImpl() {
		try {
			filerReader = new FileReader("scheduler.properties");
			properties = new Properties();
			properties.load(filerReader);
			Class.forName(properties.getProperty("driverClass"));
		} catch (Exception e) {
			System.err.println("Driver Cannot be Loaded");
		}
	}

	@Override
	public boolean addScheduler(SchedulerBean sbean) {
		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("addquery"))) {
			pstmt.setInt(1, sbean.getScheId());
			pstmt.setString(2, sbean.getScheName());
			pstmt.setString(3, sbean.getSchePassword());
			pstmt.setString(4, sbean.getRole());

			int i = pstmt.executeUpdate();
			if (i > 0) {

				return true;
			}

		} catch (Exception e) {
			throw new SchedulerExceptions("Scheduler Cannot be Added");
		}
		return false;
	}

	@Override
	public boolean deleteScheduler(int schedulerId, String password) {
		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("delete"))) {

			pstmt.setInt(1, schedulerId);
			pstmt.setString(2, password);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				return true;
			}
		} catch (Exception e) {
		}
		throw new SchedulerExceptions("Scheduler Cannot be deleted");
	}

	@Override
	public boolean loginScheduler(int schedulerId, String password) {
		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("login"))) {
			pstmt.setInt(1, schedulerId);
			pstmt.setString(2, password);
			pstmt.setString(3, "scheduler");

			ResultSet rs = pstmt.executeQuery();
			SchedulerBean sBean = new SchedulerBean();
			while (rs.next()) {
				sBean.setScheId(rs.getInt(1));
				sBean.setSchePassword(rs.getString(3));
			}
			if (sBean.getScheId() == schedulerId || sBean.getSchePassword	() == password) {
				return true;

			}

		} catch (Exception e) {
		}
		throw new SchedulerExceptions("Scheduler Cannot be Login");

	}

	@Override
	public List<SchedulerBean> getAllScheduler() {
		List<SchedulerBean> a = new ArrayList<SchedulerBean>();
		try (Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbUser"),
				properties.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(properties.getProperty("query1"))) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				SchedulerBean bean1 = new SchedulerBean();
				bean1.setScheId(rs.getInt(1));
				bean1.setScheName(rs.getString(2));
				a.add(bean1);
			}
			return a;

		} catch (Exception e) {
		}
		throw new SchedulerExceptions("Scheduler not present");
	}

}
