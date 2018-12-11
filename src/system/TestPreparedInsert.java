/*
 * Copyright (c) 2018. Alex Logo. License freebsd.
 */

package system;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import facade.AdminFacade;
import facade.CompanyFacade;
import javaBeans.ClientType;
import javaBeans.Company;
import javaBeans.Coupon;
import javaBeans.CouponType;
import system.CouponSystem;

public class TestPreparedInsert {
    public static void main(String[] args) throws Exception {
        AdminFacade adminF = (AdminFacade) CouponSystem.getInstance().login("admin", "1234", ClientType.ADMIN);

        Company company = new Company();
        company.setCompName("FoodliC12123122");
        company.setPassword("77787");
        company.setEmail("el2zadsf@gmail.com");
        adminF.createCompany(company);
        System.out.println("Company Created " + company);
        printItem(adminF.getAllCompanies());



        company.setEmail("el34f89@walla.com");
        company.setPassword("8888");

        adminF.updateCompany(company);

        System.out.println("COMPANY FACADE LOGIN");
        CompanyFacade companyFacade = (CompanyFacade) CouponSystem.getInstance().login("Maps", "8888",
                ClientType.COMPANY);

        //* CREATE COUPON *//*

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse("2018-12-07");
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

        //* UPDATE COUPON *//*

        Date endDateUpdate = sdf.parse("2018-07-07");
        coupon.setEndDate(endDateUpdate);
        coupon.setPrice(1000);
        companyFacade.updateCoupon(coupon);

        //* GET COUPON *//*

        System.out.println(companyFacade.getCoupon(107));

        //* REMOVE COUPON *//*
        System.out.println("REMOVE COUPON");
        companyFacade.removeCoupon(coupon);

        //* GET ALL COUPONS *//*
        System.out.println("GET ALL COUPON");
        	printItem(companyFacade.getAllCoupons());

        //* GET COUPON BY TYPE *//*
        System.out.println("COMPANY FACADE LOGIN");
        CompanyFacade companyFacade2 = (CompanyFacade) CouponSystem.getInstance().login("Maps", "8888",
                ClientType.COMPANY);

        System.out.println("GET COUPON BY TYPE");
        printItem(companyFacade2.getCouponsByType(CouponType.HEALTH));

        //* GET COUPON BY PRICE *//

        printItem(companyFacade.getCouponsByPrice(150));

        //* GET COUPON BY DATE *//

        Date date = sdf.parse("2027-07-07");


        //System.out.println(adminF.getCompany(22));

        //Error ID find and repair !
       // Company existingCompanyForRemove = new Company();
        // existingCompanyForRemove.setId(16);
        // existingCompanyForRemove.setCompName("Angel");
        //existingCompanyForRemove.setPassword("4444");
       // existingCompanyForRemove.setEmail("angel@ang.comm");
       // adminF.removeCompany(existingCompanyForRemove);


       /* printItem(adminF.getAllCompanies());

        Customer customer = new Customer();
        customer.setCustName("Joert Dar");
        customer.setPassword("6666");

        adminF.createCustomer(customer);

        System.out.println(adminF.getCustomer(1));*/





    }
    private static void printItem(Collection<?> list) {
        for (Object object : list) {
            System.out.println(object);
        }
    }
}
