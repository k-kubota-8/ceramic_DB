package dao;

public class LoadDriver {
	private static final String JDBC_URL = "jdbc:h2:tcp://localhost/~/test";
	private static final String DB_USER = "sa";
	private static final String DB_PASS = "";
	private static final String DB_DRIVER = "org.h2.Driver";
	
	static {
		try {
			Class.forName(getDRIVER());
		}catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
	}
	
	public static void execute() {
		try {
			Class.forName(getDRIVER());
		}catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
	}
	
	public static String getURL() { return JDBC_URL;}
	public static String getUSER() { return DB_USER;}
	public static String getPASS() {return DB_PASS;}
	public static String getDRIVER() { return DB_DRIVER;}
}
