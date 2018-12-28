/*
 * Copyright (c) 2018. Alex Logo. License freebsd.
 */

package system;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;


import exceptions.GeneralExceptionConstants;
import exceptions.LogInFailureException;
import facade.AdminFacade;
import facade.CompanyFacade;
import facade.CustomerFacade;
import enumerators.ClientType;
import javaBeans.Company;
import javaBeans.Coupon;
import enumerators.CouponType;
import javaBeans.Customer;



/**
 * @author Alexander Logovinsky "AlexLogo"
 * @version 1.2.0 November 11, 2018.
 */
public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		try {
			CouponSystem cs = CouponSystem.getInstance();
			System.out.println("Welcom to CoupTrap coupon system\nPlease TYPE:\n 1 -> for Admin User Login # User name: admin, password: 1234, RUN TEST SYSTEM \n 2 -> for Customer Login \n 3 -> for Company Login");
			//boolean log = false;
            int log = sc.nextInt();
			switch (log) {
				case 1:
					System.out.println("Enter User Name:");
					String name = sc.next();
					System.out.println("Enter Password:");
					String pass = String.valueOf(sc.next());
					ClientType type1 = ClientType.ADMIN;
					cs.login(name, pass, type1);
					//AdminFacade adminFacade = (AdminFacade) CouponSystem.getInstance().login(name, pass, type1);
					break;
				case 2:
					System.out.println("Enter User Name:");
					String name2 = sc.next();
					System.out.println("Enter Password:");
					String pass2 = String.valueOf(sc.next());
					ClientType type2 = ClientType.COMPANY;
					cs.login(name2, pass2, type2);
					//CustomerFacade customerFacade = (CustomerFacade) CouponSystem.getInstance().login(name2, pass2, type2);
					break;
				case 3:
					System.out.println("Enter User Name:");
					String name3 = sc.next();
					System.out.println("Enter Password:");
					String pass3 = String.valueOf(sc.next());
					ClientType type3 = ClientType.CUSTOMER;
					cs.login(name3, pass3, type3);
					System.out.println("Run Test System");
					//CompanyFacade  companyFacade = (CompanyFacade) CouponSystem.getInstance().login(name3, pass3, type3);
					throw new LogInFailureException(GeneralExceptionConstants.ADMIN_LOGIN_FAILED);

			}
		}catch (LogInFailureException e) {
			System.err.println(e.getMessage());
		}


		System.out.println("######################STARTING APP######################");
        System.out.println("######################SYSTEM TEST RUN1##################");
		System.out.println("######################ADMIN FACADE######################");

		AdminFacade adminF = (AdminFacade) CouponSystem.getInstance().login("admin", "1234", ClientType.ADMIN);

		System.out.println("#####CREATE COMPANY: TEST IF COMPANY ALREADY EXISTS IN THE SYSTEM######################");
		adminF.createCompany(new Company("BUG22", "2222", "bug1@gmail.com"));

		System.out.println("####CREATE COMPANY TEST GETER's and SETERS's##############");
		Company company = new Company();
		company.setCompName("Foodli2");
		company.setPassword("77787");
		company.setEmail("el2zadsf23@gmail.com");

		adminF.createCompany(company);
		System.out.println("Company Created " + company);

		System.out.println("print all companies");
		System.out.println("######################PRINT ALL COMPANY#################");
		printItem(adminF.getAllCompanies());

		System.out.println("######################UPDATE COMPANY####################");
		company.setEmail("el34f@walla.com");
		company.setPassword("8888");
		adminF.updateCompany(company);

		System.out.println("####################GET COMPANY BY: 27##################");
		System.out.println(adminF.getCompany(20));


		System.out.println("####################REMOVE COMPANY#######################");
		Company exsistingCompanyForRemove = new Company();
		exsistingCompanyForRemove.setCompName("BUG22");
		exsistingCompanyForRemove.setPassword("2222");
		exsistingCompanyForRemove.setEmail("bug1@gmail.com");
		adminF.removeCompany(exsistingCompanyForRemove);
		System.out.println("Company Removed = [" + exsistingCompanyForRemove + "]");
		printItem(adminF.getAllCompanies());

		System.out.println("######################CREATE CUSTOMER####################");

		Customer customer = new Customer();
		customer.setCustName("User6");
		customer.setPassword("6666");
		adminF.createCustomer(customer);

		System.out.println("####################UPDATE CUSTOMER######################");

		customer.setPassword("9999");
		adminF.updateCustomer(customer);

		System.out.println("####################GET CUSTOMER BY ID###################");
		System.out.println(adminF.getCustomer(1));

		System.out.println("####################REMOVE CUSTOMER######################");
		Customer exsistingCustomerForRemove = new Customer();
		exsistingCustomerForRemove.setCustName("User6");
		exsistingCustomerForRemove.setPassword("6666");
		adminF.removeCustomer(exsistingCustomerForRemove);

		System.out.println("####################GET ALL CUSTOMER#####################");
		printItem(adminF.getAllCustomers());

		System.out.println("###############COMPANY FACADE LOGIN######################");
		CompanyFacade companyFacade = (CompanyFacade) CouponSystem.getInstance().login("Google", "6452341",
				ClientType.COMPANY);


		System.out.println("###############CREATE COUPON#############################");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = sdf.parse("2019-01-07");
		Date endDate = sdf.parse("2019-12-08");

		Coupon coupon = new Coupon();
		coupon.setTitle("Analitics coupon");
		coupon.setStartDate(startDate);
		coupon.setEndDate(endDate);
		coupon.setAmount(100);
		coupon.setType(CouponType.ELECTRICITY);
		coupon.setMessage("Discaount");
		coupon.setPrice(299.0);
		coupon.setImage("google.png");

		companyFacade.createCoupon(coupon);

		System.out.println("###############UPDATE COUPON#############################");
		Date endDateUpdate = sdf.parse("2018-12-12");
		coupon.setEndDate(endDateUpdate);
		coupon.setPrice(1000);
		companyFacade.updateCoupon(coupon);
		System.out.println(coupon);

		System.out.println("###############GET COUPON BY ID:##########################");
		System.out.println(companyFacade.getCoupon(107));

		System.out.println("######################REMOVE COUPON#######################");
		companyFacade.removeCoupon(coupon);





		//* GET COUPON BY PRICE *//

		//printItem(companyFacade.getCouponsByPrice(100));

		//* GET COUPON BY DATE *//
		//System.out.println("######################GET COUPON BY DATE##################");
		//Date date = sdf.parse("2018-11-30");
		//printItem(companyFacade.getCouponsByDate(date));

		/* CUSTOMER FACADE METHODS */
		System.out.println("################CUSTOMER FACADE LOGIN#######################");
		CustomerFacade customerFacade = (CustomerFacade) CouponSystem.getInstance().login("User5", "5555", ClientType.CUSTOMER);

		//* PURCHASE COUPON *//
		System.out.println("######################PURCHASE COUPON#######################");
		customerFacade.purchaseCoupon(companyFacade.getCoupon(126));
		customerFacade.purchaseCoupon(companyFacade.getCoupon(127));

		//* GET ALL PURCHASED COUPONS *//
		System.out.println("######################PRINT ALL PURCHASED COUPON BY CUSTOMER######################");
		printItem(customerFacade.getAllPurchasedCoupons());






	//	printItem(customerFacade.getAllPurchasedCouponsByPrice(150));
		System.out.println("######################SHUTDOWN APP##########################");
		CouponSystem.getInstance().shutdown();





	}

	private static void printItem(Collection<?> list) {
		for (Object object : list) {
			System.out.println(object);
		}


	}
}
