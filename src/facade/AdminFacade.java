package facade;

import java.sql.SQLException;
import java.util.Collection;
import dao.CompanyDBDAO;
import dao.CouponDBDAO;
import dao.CustomerDBDAO;
import enumerators.ClientType;
import javaBeans.Company;
import javaBeans.Customer;
import exceptions.DataNotExistException;
import exceptions.DuplicateDataException;
import exceptions.LogInFailureException;
import exceptions.ShutDownException;
import exceptions.GeneralExceptionConstants;

/**
 * @author Alexander Logovinsky "AlexLogo"
 * @version 1.2.0 November 11, 2018.
 */
public class AdminFacade implements CouponClientFacade {

	private CompanyDBDAO companyDBDAO;
	private CustomerDBDAO customerDBDAO;
	private CouponDBDAO	couponDBDAO;
	private String ADMIN_NAME = "admin";
	private String ADMIN_PASSWORD = "1234";

	/**
	 * Constructs the class of the admin facade and creating new relevant DBDAO
	 * objects for the use of the facade with the DBDAO objects.
	 */
	public AdminFacade() {
		companyDBDAO = new CompanyDBDAO();
		customerDBDAO = new CustomerDBDAO();
		couponDBDAO	= new CouponDBDAO();
	}

	public CouponDBDAO getCouponDBDAO() {
		return couponDBDAO;
	}

	/**
	 * This method activates the createCompany method in the companyDBDAO class
	 * while sending the received company parameter, eventually creating the
	 * company's record into the Mysql data base.
	 * 
	 * @param company
	 *            - the company object that is filled with the fields of the
	 *            company to eventually add to the data base.
	 *
	 *
	 *
	 */




	public void createCompany(Company company) {

		try {
			companyDBDAO.createCompany(company);

		} catch (DuplicateDataException | SQLException | ShutDownException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * This method activates the removeCompany method in the companyDBDAO class
	 * while sending the received company parameter, eventually removing the
	 * company's record from the Mysql data base.
	 * 
	 * @param company
	 *            - the company object that is filled with the fields of the
	 *            company to eventually add to the data base.
	 */
	public void removeCompany(Company company) {

		try {
			companyDBDAO.removeCompany(company);

		} catch (DataNotExistException | SQLException | ShutDownException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Aactivate the updateCompany method in the companyDBDAO class
	 * while sending the received company parameter, eventually updating the
	 * company's record in the Mysql data base.
	 * 
	 * @param company
	 *            - the company object that is filled with the fields of the
	 *            company to eventually add to the data base.
	 */
	public void updateCompany(Company company) {

		try {
			companyDBDAO.updateCompany(company);

		} catch (DataNotExistException | SQLException | ShutDownException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Activate the getCompany method in the companyDBDAO class
	 * while sending the received company's id parameter, eventually getting and
	 * returning a Company object from the company's record in the Mysql data
	 * base.
	 * 
	 * @param id
	 *            - the company's id of the company we wish to eventually get
	 *            from the data base.
	 * @return companyDBDAO.getCompany(id) - A Company object, that represents
	 *         the company with the given id from the records in the data base.
	 * 
	 */
	public Company getCompany(long id) {

		try {
			return companyDBDAO.getCompany(id);

		} catch (DataNotExistException | SQLException | ShutDownException e) {
			System.err.println(e.getMessage());

			return null;
		}
	}

	/**
	 * Activate the getAllCompanies method in the companyDBDAO
	 * class eventually getting and returning a Array List of Company objects
	 * from the records in the Mysql data base that represents all of the
	 * companies in the system.
	 * 
	 * @return Collection of Company - collection of all the companies in the
	 *         system in Array list of company objects that we receive from the
	 *         records of the data base.
	 */
	public Collection<Company> getAllCompanies() {

		try {
			return companyDBDAO.getAllCompanies();

		} catch (DataNotExistException | SQLException | ShutDownException e) {
			System.err.println(e.getMessage());

			return null;
		}
	}

	/**
	 * Activate the createCustomer method in the customerDBDAO
	 * class while sending the received customer parameter, eventually creating
	 * the customer's record into the Mysql data base.
	 * 
	 * @param customer
	 *            - the customer object that is filled with the fields of the
	 *            customer to eventually add to the data base.
	 */
	public void createCustomer(Customer customer) {

		try {
			customerDBDAO.createCustomer(customer);

		} catch (DuplicateDataException | SQLException | ShutDownException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Activate the removeCustomer method in the customerDBDAO
	 * class while sending the received customer parameter, eventually removing
	 * the customer's record from the Mysql data base.
	 * 
	 * @param customer
	 *            - the customer object that is filled with the fields of the
	 *            customer to eventually add to the data base.
	 */
	public void removeCustomer(Customer customer) {

		try {
			customerDBDAO.removeCustomer(customer);

		} catch (DataNotExistException | SQLException | ShutDownException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Activate the updateCustomer method in the customerDBDAO
	 * class while sending the received customer parameter, eventually updating
	 * the customer's record in the Mysql data base.
	 * 
	 * @param customer
	 *            - the customer object that is filled with the fields of the
	 *            customer to eventually add to the data base.
	 */
	public void updateCustomer(Customer customer) {

		try {
			customerDBDAO.updateCustomer(customer);

		} catch (DataNotExistException | SQLException | ShutDownException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Activate the getCustomer method in the customerDBDAO class
	 * while sending the received customer's id parameter, eventually getting
	 * and returning a Customer object from the customer's record in the Mysql
	 * data base.
	 * 
	 * @param id
	 *            - the customer's id of the customer we wish to eventually get
	 *            from the data base.
	 * @return customerDBDAO.getCustomer(id) - A Customer object, that
	 *         represents the customer with the given id from the records in the
	 *         data base.
	 * 
	 */
	public Customer getCustomer(long id) {

		try {
			return customerDBDAO.getCustomer(id);

		} catch (DataNotExistException | SQLException | ShutDownException e) {
			System.err.println(e.getMessage());

			return null;
		}
	}

	/**
	 * Activate the getAllCustomers method in the customerDBDAO
	 * class eventually getting and returning a Array List of customer objects
	 * from the records in the Mysql data base that represents all of the
	 * customers in the system.
	 * 
	 * @return Collection of Customer - collection of all the customers in the
	 *         system in Array list of customer objects that we receive from the
	 *         records of the data base.
	 */
	public Collection<Customer> getAllCustomers() {

		try {
			return customerDBDAO.getAllCustomers();

		} catch (DataNotExistException | SQLException | ShutDownException e) {
			System.err.println(e.getMessage());

			return null;
		}
	}

	/**
	 * Login method for the admin client type user. After receiving the
	 * parameters, while the clientType is of admin kind, it gets and checks the
	 * credentials and if the login is successful, it returns CouponClientFacade
	 * of the type AdminFacade and the user can start using the admin different
	 * methods, if the login is unsuccessful, the facade is not returned.
	 * 
	 * @param name
	 *            - the user name of the user that wants to log in.
	 * @param password
	 *            - the password of the user that wants to log in. -
	 * @param clientType
	 *            - the client type of the user that wants to log in. -
	 * @return login - returns the CouponClientFacade object of AdminFacade
	 *         kind, or null value.
	 * 
	 */
	@Override
	public CouponClientFacade login(String name, String password, ClientType clientType) {

		if (name.equals(ADMIN_NAME) && password.equals(ADMIN_PASSWORD)) {
			System.out.println("login success.");
			return this;
		}

		try {
			throw new LogInFailureException(GeneralExceptionConstants.ADMIN_LOGIN_FAILED);
		} catch (LogInFailureException e) {
			System.err.println(e.getMessage());
		}

		return null;
	}
}
