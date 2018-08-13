package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.DaoAdherent;
import dao.DaoAdherentFactory;
import jdbc.util.Context;

public class App {

	public static void main(String[] args) throws Exception {

		DaoAdherent daoAdherent = DaoAdherentFactory.getInstance();

		System.out.println(daoAdherent.findAll());

		// a faire en dernier
		Context.destroy();
	}

}
