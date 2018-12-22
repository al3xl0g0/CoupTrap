package dao;

import java.sql.SQLException;
import java.util.Collection;

import javaBeans.Coupon;
import enumerators.CouponType;
import exceptions.DataNotExistException;
import exceptions.DuplicateDataException;
import exceptions.ShutDownException;

/**
 * @author Alexander Logovinsky "AlexLogo"
 * @version 1.2.0 November 11, 2018.
 */
public interface CouponDAO {

	void createCoupon(Coupon coupon) throws SQLException, DuplicateDataException, ShutDownException;

	void removeCoupon(Coupon coupon) throws SQLException, DataNotExistException, ShutDownException;

	void updateCoupon(Coupon coupon) throws SQLException, DataNotExistException, ShutDownException;

	Coupon getCoupon(long id) throws SQLException, DataNotExistException, ShutDownException;

	Collection<Coupon> getAllCoupon() throws SQLException, DataNotExistException, ShutDownException;

	Collection<Coupon> getCouponByType(CouponType couponType)
			throws SQLException, DataNotExistException, ShutDownException;

}
