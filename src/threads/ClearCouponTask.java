package threads;

import connection.ConnectionPool;
import exceptions.DataNotExistException;
import exceptions.ShutDownException;
import facade.AdminFacade;
import javaBeans.Coupon;
import exceptions.CouponExceptionConstants;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;


public class ClearCouponTask implements Runnable, Serializable {
    private static final long serialVersionUID = 1L;
    private static LocalDate localDate;
    private static Date currentDate;
    private AdminFacade adminFacade = new AdminFacade();
    private boolean quite = false;


    @Override
    public void run() {
        while (!this.quite) {
            ArrayList<Long> expiredCouponID = new ArrayList<>();
            Coupon coupon;
            
            try {
                ConnectionPool pool = ConnectionPool.getInstance();
                Connection conn = pool.getConnection();
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM coupn_db_test2.coupon WHERE END_DATE < current_date()");
                
                while (resultSet.next() && !this.quite) {
                    long coupon_id = resultSet.getLong("ID");
                    expiredCouponID.add(coupon_id);
                }
    
                Iterator deleteCouponID = expiredCouponID.iterator();
                
                while (deleteCouponID.hasNext() && !this.quite) {
                    long couponToDeleteID =(Long)deleteCouponID.next();
                    coupon = this.adminFacade.getCouponDBDAO().getCoupon(couponToDeleteID);
                    this.adminFacade.getCouponDBDAO().removeCoupon(coupon);
                    System.out.println(coupon+ "Removed");
                }
                
                ConnectionPool.getInstance().returnConnection(conn);
                System.out.println("System updated successfully and all old coupons had been removed successfully.");
                Thread.sleep(86400000L);
            } catch (SQLException | InterruptedException | DataNotExistException | ShutDownException dcetE0  ) {
                dcetE0.getMessage();
                try {
                    throw new DataNotExistException(CouponExceptionConstants.COUPON_DOES_NOT_EXISTS);
                } catch (DataNotExistException e) {
                    e.printStackTrace();
                }
            }


        }
    }
    
    public boolean isQuite() {
        return this.quite;
    }
    
    public void setQuite(boolean quite){
        this.quite=quite;
    }
    
    public static Date getLastDate() {
        return currentDate;
    }
    
    public static Date getCurrentDate() {
        localDate = LocalDate.now();
        currentDate = java.sql.Date.valueOf(localDate);
        return currentDate;
    }


}