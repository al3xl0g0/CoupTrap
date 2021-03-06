/*
 * Copyright (c) 2018. Alex Logo. License freebsd.
 */

package system;

import java.sql.SQLException;

import connection.ConnectionPool;
import facade.AdminFacade;
import facade.CompanyFacade;
import facade.CouponClientFacade;
import facade.CustomerFacade;
import enumerators.ClientType;
import threads.ClearCouponTask;

/**
 * Singleton pattern coupon system of the project, that returns the
 * right facade object if the login attempt is successful. Starts the Daily task thread
 * for deleting unnecessary coupons. And is able to shut down the system.
 /**
 * @author Alexander Logovinsky "AlexLogo"
 * @version 1.2.0 November 11, 2018.
 */


public final class CouponSystem {

	// task - the daily coupon task thread.
	private ClearCouponTask task;


	private static CouponSystem instance = null;

	/**
	 *  Daily task thread constructs (which daemon).
	 *
	 */
	private CouponSystem() {
		task = new ClearCouponTask();
		Thread taskThread = new Thread(task);
		taskThread.setDaemon(true);
		taskThread.start();
	}

	/**
	 * Instantiating the coupon system or getting it's instance (if it's already
	 * have been instantiated). Enabling the user to attempt login to the
	 * program.
	 * 
	 * @return instance - the coupon system instance.
	 */
	public synchronized static CouponSystem getInstance() {

		if (instance == null) {

			instance = new CouponSystem();
		}
		return instance;
	}

	/**
	 * Login filter method that receives parameters and according to the client
	 * type, attempts login filter at the specific facade, while returning a facade
	 * object if the login was successful.
	 * 
	 * @param name
	 *            - the user's name.
	 * @param password
	 *            - the user's password.
	 * @param clientType
	 *            - the client type of the user.
	 * @return - result.login - the facade if the login was successful, or null
	 *         if not.
	 * @throws SQLException
	 *             - when sql related errors accur.
	 */
	public CouponClientFacade login(String name, String password, ClientType clientType) throws SQLException {

		CouponClientFacade result = null;

		switch (clientType) {
		case ADMIN:
			result = new AdminFacade();
			break;

		case COMPANY:
			result = new CompanyFacade();
			break;

		case CUSTOMER:
			result = new CustomerFacade();
			break;
		}

		return result.login(name, password, clientType);
	}

	/**
	 * Shutdown: Starting at stopping the daily
	 * task thread, and after that, closing all connections and exiting.
	 *
	 */


	public void shutdown() {

		task.setQuite(true);
		try {
			ConnectionPool.getInstance().closeAllConnections();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		System.exit(0);
	}
}
