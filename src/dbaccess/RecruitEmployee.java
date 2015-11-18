/*
 * Created on Jul 4, 2006
 */
package dbaccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import JavaClasses.Person;
// import java.sql.PreparedStatement;
// import java.text.DateFormat;

/**
 * @author Shengru Tu
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class RecruitEmployee {
	private Person person;
	private Connection conn;
	final String host = "localhost"; 
	final String port = "1521";
	final String sID = "nbdb";

	/**
	 * @param username
	 *            the user name to access the database.
	 * @param passwd
	 *            This constructor establishes connection and a java.sql.Types
	 *            checker object.
	 */
	public RecruitEmployee(	String host,
						String port, 
						String sID, 
						String username, 
						String passwd) throws SQLException { 
		conn = new DBConnection(host, port, sID).getDBConnection(username, passwd); 
	}

	public RecruitEmployee(String username, String passwd) throws SQLException {
		this.conn = new DBConnection(host, port, sID).getDBConnection(username, passwd); 
 
	}

	public RecruitEmployee(Connection conn) throws SQLException {
		this.conn = conn; 
	}

	public ResultSet getAllPersons() throws SQLException {
		String str = "SELECT * FROM person";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(str);
		return rs;
	}
	
	public ResultSet getBestFitJobs(String name) throws SQLException {
		String str = "SELECT j.pos_code, j.job_title\n" +
				"FROM job_profile j\n" +
				"WHERE NOT EXISTS ( (\n" +
				"            SELECT R.skill_id \t  FROM skill_require R   WHERE R.pos_code=J.pos_code  )           "
				+ "MINUS         (\n" +
				" SELECT skill_id   FROM  knows_skill NATURAL JOIN person  WHERE name = '"+ name    +"')     )";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(str);
		return rs;
	}
	
	/**
	 * return the columns' titles of a table as a Vector
	 */
	public Vector getTitlesAsVector(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int col = rsmd.getColumnCount();
		Vector title = new Vector();
		for (int i = 0; i < col; i++) {
			title.add(rsmd.getColumnLabel(i+1));
		}
		return title;
	}
	
	/**
	 * convert a ResultSet object to a two dimensional array of String 
	 */
	public Vector resultSet2Vector(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int col = rsmd.getColumnCount();
		Vector vec = new Vector(); 
		Vector row = null; 
		while (rs.next()) { 
			row = new Vector(); 
			for (int i = 0; i < col; i++) {
				row.add(rs.getObject(i+1)); 
			}
			vec.add(row);
		} 
		return vec;
	}
	
	
}
