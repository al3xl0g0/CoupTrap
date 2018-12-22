/*
 * Copyright (c) 2018. Alex Logo. License freebsd.
 */

package connection;

/**
 * @author Alexander Logovinsky "AlexLogo"
 * @version 1.2.0 November 11, 2018.
 */


public class ConnectionData {

	public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

	public static final String DB_URL = "jdbc:mysql://localhost/coupn_db_test2";
	public static final String USER = "dbuser";
	public static final String PASS = "dbpassword";
	static final int maxConnections = 5;

}