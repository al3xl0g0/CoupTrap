package daoLayer;

import java.sql.SQLException;
import java.util.Collection;

import javaBeans.Coupon;
import javaBeans.Customer;
import exceptions.DataNotExistException;
import exceptions.DuplicateDataException;
import exceptions.LogInFailureException;
import exceptions.ShutDownException;

/**
 * @author Alexander Logovinsky "AlexLogo"
 * @version 1.2.0 November 11, 2018.
 */
public interface CustomerDAO {

	// - Abstract methods to create, romove and etc customer related actions.

	void createCustomer(Customer customer) throws SQLException, DuplicateDataException, ShutDownException;

	void removeCustomer(Customer customer) throws SQLException, DataNotExistException, ShutDownException;

	void updateCustomer(Customer customer) throws SQLException, DataNotExistException, ShutDownException;

	// - Abstract methods to get customer related information such as getting
	// customer, all customers or all customer coupons.
	Customer getCustomer(long id) throws SQLException, DataNotExistException, ShutDownException;

	Collection<Customer> getAllCustomers() throws SQLException, DataNotExistException, ShutDownException;

	Collection<Coupon> getCoupons() throws SQLException, DataNotExistException, ShutDownException;

	// Abstarct login method, for login later use.

	boolean login(String custName, String password)
			throws SQLException, LogInFailureException, ShutDownException;

}
