package jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Context {
	private Connection connection = null;
	private static Context ctx = null;

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Context() {
		Properties properties = new Properties();
		try {
			properties.load(getClass().getResourceAsStream("/infos.properties"));
			connection = DriverManager.getConnection(properties.getProperty("url"), properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public static Context getInstance() {
		if (ctx == null) {
			ctx = new Context();
		}
		return ctx;
	}

	public static void destroy() {
		if (ctx != null) {
			Closer.closeConnection(ctx.connection);
			ctx = null;
		}
	}

}
