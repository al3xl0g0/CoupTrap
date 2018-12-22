/*
 * Copyright (c) 2018. Alex Logo. License freebsd.
 */

package system;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

import facade.AdminFacade;
import facade.CompanyFacade;
import enumerators.ClientType;
import facade.CustomerFacade;
import javaBeans.Company;
import javaBeans.Coupon;
import enumerators.CouponType;
import javaBeans.Customer;
import exceptions.LogInFailureException;
import exceptions.GeneralExceptionConstants;



public class TestPreparedInsert {
    public static void main(String[] args) throws Exception  {
        Scanner sc = new Scanner(System.in);
        AdminFacade adminFacade = null;
        CustomerFacade customerFacade = null;
        CompanyFacade companyFacade = null;

        /*Company company = new Company();
        company.setCompName("Electric231");
        company.setPassword("7777");
        company.setEmail("el@gmail.com");
        AdminFacade adminF = (AdminFacade) CouponSystem.getInstance().login("admin", "1234", ClientType.ADMIN);

        adminF.createCompany(company);

        try {
            CouponSystem cs = CouponSystem.getInstance();
            System.out.println("enter:\n 1 for admin \n 2 for customer \n 3 for company");
            //int log = false;
            int log = sc.nextInt();
            switch (log) {
                case 1:
                    System.out.println("Enter User Name:");
                    String name = sc.next();
                    System.out.println("Enter Password:");
                    String pass = String.valueOf(sc.next());
                    System.out.println("Enter userType:");
                    ClientType type1 = ClientType.ADMIN;
                    cs.login(name, pass, type1);
                    AdminFacade adminFacade = (AdminFacade) CouponSystem.getInstance().login(name, pass, type1);
                    break;
                case 2:
                    System.out.println("Enter User Name:");
                    String name2 = sc.next();
                    System.out.println("Enter Password:");
                    String pass2 = String.valueOf(sc.next());
                    System.out.println("Enter userType:");
                    ClientType type2 = ClientType.COMPANY;
                    cs.login(name2, pass2, type2);
                    CustomerFacade customerFacade1 = (CustomerFacade) CouponSystem.getInstance().login(name2, pass2, type2);
                    break;
                case 3:
                    System.out.println("Enter User Name:");
                    String name3 = sc.next();
                    System.out.println("Enter Password:");
                    String pass3 = String.valueOf(sc.next());
                    System.out.println("Enter userType:");
                    ClientType type3 = ClientType.CUSTOMER;
                    cs.login(name3, pass3, type3);
                    CompanyFacade  companyFacade1 = (CompanyFacade) CouponSystem.getInstance().login(name3, pass3, type3);
                    throw new LogInFailureException(GeneralExceptionConstants.ADMIN_LOGIN_FAILED);
            }
            switch(log) {
                case 1:
                    System.out.println("--------------------------------------------------");
                    System.out.println("--------------COMPANY MANIPULATION----------------");
                    System.out.println("--------------------------------------------------");
                    System.out.println(adminFacade.getAllCompanies());
                    System.out.println("--------------------------------------------------");
                    adminFacade.createCompany(company);
                    System.out.println("--------------------------------------------------");
                    System.out.println(adminFacade.getAllCompanies());
                    System.out.println("--------------------------------------------------");
                    System.out.println("enter the recycable company id from the table above");
                    long RECcompanyid = sc.nextLong();
                    //company.setCompId(RECcompanyid);
                    System.out.println(adminFacade.getCompany(RECcompanyid));
                    System.out.println("--------------------------------------------------");
                    System.out.println("setting the recycable company password and email to 'updated'");
                    company.setEmail("updated");
                    company.setPassword("updated");
                    adminFacade.updateCompany(company);
                    System.out.println("--------------------------------------------------");
                    System.out.println(adminFacade.getCompany(RECcompanyid));
                    System.out.println("--------------------------------------------------");
                    adminFacade.removeCompany(company);
                    System.out.println("company has been removed");
                    System.out.println("--------------------------------------------------");
                    System.out.println(adminFacade.getAllCompanies());
                    System.out.println("--------------------------------------------------");
                    System.out.println("exemple of company with coupons - DailyPlanet");
                    Company longRegComp = adminFacade.getCompany(2L);
                    System.out.println("--------------------------------------------------");
                    System.out.println(longRegComp.toString());
                    System.out.println("--------------------------------------------------");
                    System.out.println("--------------------------------------------------");
                    System.out.println("--------------CUSTOMER MANIPULATION---------------");
                    System.out.println("--------------------------------------------------");
                    System.out.println(adminFacade.getAllCustomers());
                    System.out.println("--------------------------------------------------");
                    adminFacade.createCustomer(recycableCustomer);
                    System.out.println("--------------------------------------------------");
                    System.out.println(adminFacade.getAllCustomers());
                    System.out.println("--------------------------------------------------");
                    System.out.println("enter the recycable customer id from the table above");
                    long RECcustomerid = sc.nextLong();
                    recycableCustomer.setCustId(RECcustomerid);
                    System.out.println(adminFacade.getCustomer(RECcustomerid));
                    System.out.println("--------------------------------------------------");
                    System.out.println("setting the recycable customer password to 'updated'");
                    recycableCustomer.setPassword("updated");
                    adminFacade.updateCustomer(recycableCustomer);
                    System.out.println("--------------------------------------------------");
                    System.out.println(adminFacade.getCustomer(RECcustomerid));
                    System.out.println("--------------------------------------------------");
                    adminFacade.removeCustomer(recycableCustomer);
                    System.out.println("customer has been removed");
                    System.out.println("--------------------------------------------------");
                    System.out.println(adminFacade.getAllCustomers());
                    System.out.println("--------------------------------------------------");
                    System.out.println("exemple of customer with coupons - jack_Sparrow");
                    System.out.println(adminFacade.getCustomer(1L));
                    System.out.println("--------------------------------------------------");
                    System.out.println("--------------------------------------------------");
                    sc.close();
                    break;
                case 2:
                    long customer_id = customerFacade.getLoggedCustomer().getCustId();
                    System.out.println("loged as customer :" + customer_id);
                    System.out.println("-------------------------------------");
                    System.out.println(customerFacade.getAllPurchasedCoupons());
                    System.out.println("-------------------------------------");
                    System.out.println(customerFacade.getAllPurchasedCoupons());
                    System.out.println("-------------------------------------");
                    System.out.println(customerFacade.getAllPurchasedCoupons());
                    System.out.println("-------------------------------------");
                    System.out.println("-------------------------------------");
                    System.out.println(customerFacade.getAllPurchasedCoupons());
                    System.out.println("-------------------------------------");
                    System.out.println("-------------------------------------");
                    System.out.println(customerFacade.getAllPurchasedCoupons());
                    System.out.println("-------------------------------------");
                    System.out.println("-------------------------------------");
                    System.out.println(customerFacade.getAllPurchasedCoupons());
                    System.out.println("-------------------------------------");
                    System.out.println("-------------------------------------");
                    System.out.println(customerFacade.getAllPurchasedCoupons());
                    System.out.println("-------------------------------------");
                    System.out.println("-------------------------------------");
                    System.out.println(customerFacade.getAllPurchasedCoupons());
                    System.out.println("-------------------------------------");
                    System.out.println("-------------------------------------");
                    System.out.println("-------------------------------------");
                    System.out.println("enter the max coupon price");
                    double couponMaxPrice = sc.nextDouble();
                    System.out.println("-------------------------------------");
                    System.out.println(customerFacade.getAllPurchasedCouponsByPrice(couponMaxPrice));
                    System.out.println("-------------------------------------");
                    System.out.println("set to return only coupons of food type");
                    System.out.println(customerFacade.getAllPurchasedCouponsByType(CouponType.FOOD));
                    System.out.println("-------------------------------------");
                    sc.close();
                    break;
                case 3:
                    System.out.println("------------------getAllCoupons-------------------");
                    System.out.println(companyFacade.getAllCoupons());
                    System.out.println("-------------------creating coupon (recycled)------------------");
                    companyFacade.createCoupon(coupon);
                    System.out.println("--------------------getAllCoupons reccycled added-----------------");
                    System.out.println(companyFacade.getAllCoupons());
                    System.out.println("-------------------------------------");
                    System.out.println("insert the new coupon's id from the table above");
                    long coupon_id = sc.nextLong();
                    System.out.println("--------------------getting coupon by id generated-----------------");
                    Coupon coupon2UpDate = companyFacade.getCoupon(coupon_id);
                    System.out.println("update coupon's amount and price");
                    System.out.println("-------------------------------------");
                    System.out.println("insert a double for price");
                    coupon2UpDate.setPrice(sc.nextDouble());
                    System.out.println("--------------------setting coupon's price-----------------");
                    System.out.println("insert an integr for amount");
                    System.out.println("-------------------------------------");
                    coupon2UpDate.setAmount(sc.nextInt());
                    System.out.println("--------------------setting coupon's amount in stock-----------------");
                    companyFacade.updateCoupon(coupon2UpDate);
                    System.out.println("-----------------updating coupon in database--------------------");
                    System.out.println(companyFacade.getAllCoupons());
                    System.out.println("------------------getAllCoupons-------------------");
                    companyFacade.removeCoupon(coupon2UpDate);
                    System.out.println("-----------------removing coupon after update--------------------");
                    System.out.println(companyFacade.getAllCoupons());
                    System.out.println("--------------------getAllCoupons-----------------");
                    System.out.println("returns company food type coupons");
                    System.out.println(companyFacade.getCouponsByType(COUPON_TYPE.Food));
                    System.out.println("-------------------------------------");
                    sc.close();
            }
        }catch (LogInFailureException e) {
            System.err.println(e.getMessage());

            switch(log) {
                case 1:
                    System.out.println("--------------------------------------------------");
                    System.out.println("--------------COMPANY MANIPULATION----------------");
                    System.out.println("--------------------------------------------------");
                    System.out.println(adminFacade.getAllCompanies());
                    System.out.println("--------------------------------------------------");
                    adminFacade.createCompany(recycableCompany);
                    System.out.println("--------------------------------------------------");
                    System.out.println(adminFacade.getAllCompanies());
                    System.out.println("--------------------------------------------------");
                    System.out.println("enter the recycable company id from the table above");
                    long RECcompanyid = sc.nextLong();
                    recycableCompany.setCompId(RECcompanyid);
                    System.out.println(adminFacade.getCompany(RECcompanyid));
                    System.out.println("--------------------------------------------------");
                    System.out.println("setting the recycable company password and email to 'updated'");
                    recycableCompany.setEmail("updated");
                    recycableCompany.setPassword("updated");
                    adminFacade.updateCompany(recycableCompany);
                    System.out.println("--------------------------------------------------");
                    System.out.println(adminFacade.getCompany(RECcompanyid));
                    System.out.println("--------------------------------------------------");
                    adminFacade.removeCompany(recycableCompany);
                    System.out.println("company has been removed");
                    System.out.println("--------------------------------------------------");
                    System.out.println(adminFacade.getAllCompanies());
                    System.out.println("--------------------------------------------------");
                    System.out.println("exemple of company with coupons - DailyPlanet");
                    Company longRegComp = adminFacade.getCompany(2L);
                    System.out.println("--------------------------------------------------");
                    System.out.println(longRegComp.toString());
                    System.out.println("--------------------------------------------------");
                    System.out.println("--------------------------------------------------");
                    System.out.println("--------------CUSTOMER MANIPULATION---------------");
                    System.out.println("--------------------------------------------------");
                    System.out.println(adminFacade.getAllCustomers());
                    System.out.println("--------------------------------------------------");
                    adminFacade.createCustomer(recycableCustomer);
                    System.out.println("--------------------------------------------------");
                    System.out.println(adminFacade.getAllCustomers());
                    System.out.println("--------------------------------------------------");
                    System.out.println("enter the recycable customer id from the table above");
                    long RECcustomerid = sc.nextLong();
                    recycableCustomer.setCustId(RECcustomerid);
                    System.out.println(adminFacade.getCustomer(RECcustomerid));
                    System.out.println("--------------------------------------------------");
                    System.out.println("setting the recycable customer password to 'updated'");
                    recycableCustomer.setPassword("updated");
                    adminFacade.updateCustomer(recycableCustomer);
                    System.out.println("--------------------------------------------------");
                    System.out.println(adminFacade.getCustomer(RECcustomerid));
                    System.out.println("--------------------------------------------------");
                    adminFacade.removeCustomer(recycableCustomer);
                    System.out.println("customer has been removed");
                    System.out.println("--------------------------------------------------");
                    System.out.println(adminFacade.getAllCustomers());
                    System.out.println("--------------------------------------------------");
                    System.out.println("exemple of customer with coupons - jack_Sparrow");
                    System.out.println(adminFacade.getCustomer(1L));
                    System.out.println("--------------------------------------------------");
                    System.out.println("--------------------------------------------------");
                    sc.close();
                    break;
                case 2:
                    long customer_id = customerFacade.getLoggedCustomer().getCustId();
                    System.out.println("loged as customer :" + customer_id);
                    System.out.println("-------------------------------------");
                    System.out.println(customerFacade.getAllPurchesedCoupons());
                    System.out.println("-------------------------------------");
                    System.out.println(customerFacade.getAllPurchasedCoupons());
                    System.out.println("-------------------------------------");
                    System.out.println(customerFacade.getAllPurchasedCoupons());
                    System.out.println("-------------------------------------");
                    System.out.println("-------------------------------------");
                    System.out.println(customerFacade.getAllPurchesedCoupons());
                    System.out.println("-------------------------------------");
                    System.out.println("-------------------------------------");
                    System.out.println(customerFacade.getAllPurchasedCoupons());
                    System.out.println("-------------------------------------");
                    System.out.println("-------------------------------------");
                    System.out.println(customerFacade.getAllPurchesedCoupons());
                    System.out.println("-------------------------------------");
                    System.out.println("-------------------------------------");
                    System.out.println(customerFacade.getAllPurchasedCoupons());
                    System.out.println("-------------------------------------");
                    System.out.println("-------------------------------------");
                    System.out.println(customerFacade.getAllPurchesedCoupons());
                    System.out.println("-------------------------------------");
                    System.out.println("-------------------------------------");
                    System.out.println("-------------------------------------");
                    System.out.println("enter the max coupon price");
                    double couponMaxPrice = sc.nextDouble();
                    System.out.println("-------------------------------------");
                    System.out.println(customerFacade.getAllPurchesedCouponsByPrice(couponMaxPrice));
                    System.out.println("-------------------------------------");
                    System.out.println("set to return only coupons of food type");
                    System.out.println(customerFacade.getAllPurchesedCouponsByType(COUPON_TYPE.Food));
                    System.out.println("-------------------------------------");
                    sc.close();
                    break;
                case 3:
                    System.out.println("------------------getAllCoupons-------------------");
                    System.out.println(companyFacade.getAllCoupons());
                    System.out.println("-------------------creating coupon (recycled)------------------");
                    companyFacade.createCoupon(coupon);
                    System.out.println("--------------------getAllCoupons reccycled added-----------------");
                    System.out.println(companyFacade.getAllCoupons());
                    System.out.println("-------------------------------------");
                    System.out.println("insert the new coupon's id from the table above");
                    long coupon_id = sc.nextLong();
                    System.out.println("--------------------getting coupon by id generated-----------------");
                    Coupon coupon2UpDate = companyFacade.getCoupon(coupon_id);
                    System.out.println("update coupon's amount and price");
                    System.out.println("-------------------------------------");
                    System.out.println("insert a double for price");
                    coupon2UpDate.setPrice(sc.nextDouble());
                    System.out.println("--------------------setting coupon's price-----------------");
                    System.out.println("insert an integr for amount");
                    System.out.println("-------------------------------------");
                    coupon2UpDate.setAmount(sc.nextInt());
                    System.out.println("--------------------setting coupon's amount in stock-----------------");
                    companyFacade.updateCoupon(coupon2UpDate);
                    System.out.println("-----------------updating coupon in database--------------------");
                    System.out.println(companyFacade.getAllCoupons());
                    System.out.println("------------------getAllCoupons-------------------");
                    companyFacade.removeCoupon(coupon2UpDate);
                    System.out.println("-----------------removing coupon after update--------------------");
                    System.out.println(companyFacade.getAllCoupons());
                    System.out.println("--------------------getAllCoupons-----------------");
                    System.out.println("returns company food type coupons");
                    System.out.println(companyFacade.getCouponsByType(CouponType.HEALTH));
                    System.out.println("-------------------------------------");
                    sc.close();
            }
        }
        *//* ADMIN FACADE */

        AdminFacade adminF = (AdminFacade) CouponSystem.getInstance().login("admin", "1234", ClientType.ADMIN);

        /* ADIMIN FACADE - COMPANY METHODS */

        /* CREATE COMPANY */

        Company company = new Company();
        company.setCompName("Electric231");
        company.setPassword("7777");
        company.setEmail("el@gmail.com");

        adminF.createCompany(company);

        /* UPDATE COMPANY */

        company.setEmail("elf@walla.com");
        company.setPassword("8888");

        adminF.updateCompany(company);

        /* GET COMPANY BY ID */

        System.out.println(adminF.getCompany(2));

        /* REMOVE COMPANY */
        /* The Company with the name "Angel" already exists in the DB */

        Company exsistingCompanyForRemove = new Company();
        exsistingCompanyForRemove.setCompName("Angel");
        exsistingCompanyForRemove.setPassword("4444");
        exsistingCompanyForRemove.setEmail("angel@ang.comm");

        adminF.removeCompany(exsistingCompanyForRemove);

        /* GET ALL COMPANIES */

        printItem(adminF.getAllCompanies());

        /* ADMIN CUSTOMER METHODS */

        /* CREATE CUSTOMER */

        Customer customer = new Customer();
        customer.setCustName("Joe Dar");
        customer.setPassword("666");

        adminF.createCustomer(customer);

        /* UPDATE CUSTOMER */

        customer.setPassword("999");
        adminF.updateCustomer(customer);

        /* GET CUSTOMER */

        System.out.println(adminF.getCustomer(1));

        /* REMOVE CUSTOMER */
        /*
         * The Customer with the name "Abraham Mozes" already exists in the DB
         */

        Customer exsistingCustomerForRemove = new Customer();
        exsistingCustomerForRemove.setCustName("Abraham Mozes");
        exsistingCustomerForRemove.setPassword("444");

        adminF.removeCustomer(exsistingCustomerForRemove);

        /* GET ALL CUSTOMER */

        printItem(adminF.getAllCustomers());

        /* COMPANY FACADE METHODS */

        //CompanyFacade companyFacade = (CompanyFacade) CouponSystem.getInstance().login("Hush Puppies", "1111",
        //		ClientType.COMPANY);

        /* CREATE COUPON */

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse("2018-07-07");
        Date endDate = sdf.parse("2019-07-07");

        Coupon coupon = new Coupon();
        coupon.setTitle("Perks2");
        coupon.setStartDate(startDate);
        coupon.setEndDate(endDate);
        coupon.setAmount(500);
        coupon.setType(CouponType.SPORTS);
        coupon.setMessage("The best coupon");
        coupon.setPrice(299.0);
        coupon.setImage("sport star");

        companyFacade.createCoupon(coupon);

        /* UPDATE COUPON */

        Date endDateUpdate = sdf.parse("2021-07-07");
        coupon.setEndDate(endDateUpdate);
        coupon.setPrice(1000);

        companyFacade.updateCoupon(coupon);

        /* GET COUPON */

        System.out.println(companyFacade.getCoupon(10));

        /* REMOVE COUPON */

        companyFacade.removeCoupon(coupon);

        /* GET ALL COUPONS */

        printItem(companyFacade.getAllCoupons());

        /* GET COUPON BY TYPE */

        printItem(companyFacade.getCouponsByType(CouponType.HEALTH));

        /* GET COUPON BY PRICE */

        printItem(companyFacade.getCouponsByPrice(150));

        /* GET COUPON BY DATE */

        Date date = sdf.parse("2027-07-07");

        printItem(companyFacade.getCouponsByDate(date));

        /* CUSTOMER FACADE METHODS */

        //CustomerFacade customerFacade = (CustomerFacade) CouponSystem.getInstance().login("John Day", "111",
        //		ClientType.CUSTOMER);

        /* PURCHASE COUPON */

        customerFacade.purchaseCoupon(companyFacade.getCoupon(107));

        /* GET ALL PURCHASED COUPONS */

        printItem(customerFacade.getAllPurchasedCoupons());

        /* GET ALL PURCHASED COUPONS BY TYPE */

        printItem(customerFacade.getAllPurchasedCouponsByType(CouponType.HEALTH));

        /* GET ALL PURCHASED COUPONS BY PRICE */

        printItem(customerFacade.getAllPurchasedCouponsByPrice(150));

        CouponSystem.getInstance().shutdown();
    }


    private static void printItem(Collection<?> list) {
        for (Object object : list) {
            System.out.println(object);
        }
    }
}
