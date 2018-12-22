package dao;

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

	void createCustomer(Customer customer) throws SQLException, DuplicateDataException, ShutDownException;

	void removeCustomer(Customer customer) throws SQLException, DataNotExistException, ShutDownException;

	void updateCustomer(Customer customer) throws SQLException, DataNotExistException, ShutDownException;

	Customer getCustomer(long id) throws SQLException, DataNotExistException, ShutDownException;

	Collection<Customer> getAllCustomers() throws SQLException, DataNotExistException, ShutDownException;

	Collection<Coupon> getCoupons() throws SQLException, DataNotExistException, ShutDownException;


	boolean login(String custName, String password)
			throws SQLException, LogInFailureException, ShutDownException;

}
