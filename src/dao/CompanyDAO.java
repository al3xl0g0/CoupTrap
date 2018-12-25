package dao;

import java.sql.SQLException;
import java.util.Collection;

import javaBeans.Company;
import javaBeans.Coupon;
import exceptions.DataNotExistException;
import exceptions.DuplicateDataException;
import exceptions.LogInFailureException;
import exceptions.ShutDownException;

/**
 * @author Alexander Logovinsky "AlexLogo"
 * @version 1.2.0 November 11, 2018.
 */
public interface CompanyDAO {


	/**
	 * @param company
	 * @throws SQLException
	 * @throws DuplicateDataException
	 * @throws ShutDownException
	 */
	 void createCompany(Company company) throws SQLException, DuplicateDataException, ShutDownException;

	/**
	 * @param Company
	 * @throws SQLException
	 * @throws DataNotExistException
	 * @throws ShutDownException
	 */
	 void removeCompany(Company Company) throws SQLException, DataNotExistException, ShutDownException;

	/**
	 * @param Company
	 * @throws SQLException
	 * @throws DataNotExistException
	 * @throws ShutDownException
	 */
	 void updateCompany(Company Company) throws SQLException, DataNotExistException, ShutDownException;


	/**
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws DataNotExistException
	 * @throws ShutDownException
	 */
	 Company getCompany(long id) throws SQLException, DataNotExistException, ShutDownException;

	 Collection<Company> getAllCompanies() throws SQLException, DataNotExistException, ShutDownException;

	 Collection<Coupon> getCoupons() throws SQLException, DataNotExistException, ShutDownException;

	 boolean login(String compName, String password)
			throws SQLException, LogInFailureException, ShutDownException;
}
