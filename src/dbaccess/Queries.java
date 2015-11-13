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
// import java.sql.PreparedStatement;
// import java.text.DateFormat;

/**
 * @author Shengru Tu
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class Queries {

	private Connection conn;
	final String host = "localhost"; 
	final String port = "1521";
	final String sID = "nbdb";

	/**
	 * @param username
	 *            the user name to access the database.
	 * @param password
	 *            This constructor establishes connection and a java.sql.Types
	 *            checker object.
	 */
	public Queries(	String host,
						String port, 
						String sID, 
						String username, 
						String passwd) throws SQLException { 
		conn = new DBConnection(host, port, sID).getDBConnection(username, passwd); 
	}

	public Queries(String username, String passwd) throws SQLException {
		this.conn = new DBConnection(host, port, sID).getDBConnection(username, passwd); 
 
	}

	public Queries(Connection conn) throws SQLException {
		this.conn = conn; 
	}

	/**
	 * execute a simple SQL statement without any parameter 
	 */
	public int runUpdate(String str) throws SQLException {
		Statement stmt = conn.createStatement();
		return stmt.executeUpdate(str);
	}
	
	/**
	 * Run a fixed query.
	 */
	public ResultSet runSQLQuery(String str) throws SQLException {
		Statement stmt = conn.createStatement();
		return stmt.executeQuery(str);

	}	

	/**
	 * list the user's table names
	 */
	public String[] listQueries() throws SQLException {

		ArrayList al = new ArrayList();

		al.add("1. List a company's workers by names.");
		al.add("2. List a company's staff by salary in descending order.");
		al.add("3. List companies' labor cost (total salaries and wage rates by 1920 hours) in descending order.");
		al.add("4. Find all the jobs a person is currently holding.");
		al.add("5. List all the workers who are working for a specific project.");
		al.add("6. List a person's knowledge/skills in a readable format.");
		al.add("7. List the skill gap of a worker between his/her job(s) and his/her skills.");
		al.add("8. List the required knowledge/skills of a job profile in a readable format.");
		al.add("9. List a person's missing knowledge/skills for a specific job in a readable format.");
		al.add("10. Find the courses each of which alone can cover a given skill set.");
		al.add("11. List the courses (course id and title) that each alone teaches all the missing knowledge/skills for a person to pursue a specific job.");
		al.add("12. Suppose the skill gap of a worker and the requirement of a desired job can be covered by one course. Find the 'quickest' solution for this worker. Show the course and the completing date.");
		al.add("13. If query #10 returns nothing, then find the course sets with the minimum number of courses that their combination covers the given skill set. The considered course sets will not include more than three courses.");
		al.add("14. List the course sets that their combinations cover all the missing knowledge/skills for a person to pursue a specific job. The considered course sets will not include more than three courses.");
		al.add("15. Find the cheapest course choices to make up one's skill gap by showing the courses to take and the total cost. The considered course sets will not include more than three courses.");
		al.add("16. List all the job profiles that a person is qualified.");
		al.add("17. Find the job with the highest pay rate for a person according to his/her skill qualification.");
		al.add("18. List all the names along with the emails of the persons who are qualified for a job profile.");
		al.add("19. When a company cannot find any qualified person for a job, a secondary solution is to find a person who is almost qualified to the job. Make a 'missing-one' list that lists people who miss only one skill for a specified job profile.");
		al.add("20. List the skillID and the number of people in the missing-one list for a given job profile in the ascending order of the people counts.");
		al.add("21. Suppose there is a new job profile that has nobody qualified. List the persons who miss the least number of skills and report the 'least number'.");
		al.add("22. For a specified job profile and a given small number k, make a 'missing-k' list that lists the people's IDs and the number of missing skills for the people who miss only up to k skills in the ascending order of missing skills.");
		al.add("23. Given a job profile and its corresponding missing-k list specified in Question 22. Find every skill that is needed by at least one person in the given missing-k list. List each skillID and the number of people who need it in the descending order of the people counts.");
		al.add("24. In a local or national crisis, we need to find all the people who once held a job of the special job-profile identifier.");
		al.add("25. Find all the unemployed people who once held a job of the given job-profile identifier.");
		al.add("26. Find out the biggest employer in terms of number of employees or the total amount of salaries and wages paid to employees.");


		String[] tn = new String[1];
		tn = (String[]) al.toArray(tn);
		return tn;
	}

	/**
	 * return the ResultSet object of a table
	 */
	public ResultSet getTable(String tn) throws SQLException {
		String str = "SELECT * FROM " + tn;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(str);
		return rs;
	}
	
	/**
	 * return the columns' titles of a table as an array of String
	 */
	public String[] getTitles(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int col = rsmd.getColumnCount();
		String[] title = new String[col];
		for (int i = 0; i < col; i++) {
			title[i] = rsmd.getColumnLabel(i+1);
		}
		return title;
	}

	/**
	 * return a column's values in String[]
	 */
	public String[] getColumn(String tableName, String colName) throws SQLException {
		ResultSet rs = runSQLQuery("SELECT DISTINCT " + colName + " FROM " + tableName + 
									" ORDER BY " + colName); 
		ArrayList list = new ArrayList(); 
		while (rs.next()) { 
			Object obj = rs.getObject(colName);
			String str = "null";
			if (obj != null) 
				str = obj.toString();
			list.add(str);
		}
		String[] result = new String[1];
		result = (String[])list.toArray(result);
		return result;
	}
	
	/**
	 * Return an ordered, specific ResultSet of a table.
	 */
	public ResultSet getOrderedColumn(String tn, String values, String order) throws SQLException{
		String str = "SELECT " + values + " FROM " + tn + " ORDER BY " + order;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(str);
		return rs;
	}

	/**
	 * return a date column's dates in a SHORT format
	 */
	public String[] getDateColumnInShort(String tableName, String colName) throws SQLException {
		String[] result = getDateColumn(tableName, colName, DateFormat.SHORT);
		return result;
	}

	/**
	 * return a date column's dates in a chosen format
	 */
	public String[] getDateColumn(String tableName, String colName, int form) throws SQLException {
		ResultSet rs = runSQLQuery("SELECT DISTINCT " + colName + " FROM " + tableName + 
									" ORDER BY " + colName); 
		DateFormat df = DateFormat.getDateInstance(form);
		ArrayList dList = new ArrayList(); 
		while (rs.next()) { 
			String dat = df.format(rs.getDate(colName));
			dList.add(dat);
		}
		String[] result = new String[1];
		result = (String[])dList.toArray(result);
		return result;
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
	 * return the columns' types 
	 */
	public int[] getColumnTypes(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int col = rsmd.getColumnCount();
		int[] types = new int[col];
		for (int i = 0; i < col; i++) {
			types[i] = rsmd.getColumnType(i+1);
		}
		return types;
	}
	
	/**
	 * return the selected resultset from a table 
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public ResultSet getSelectedResultSet(String tn, String colName, 
							int colType, String val) throws Exception { 
		String whereClause = null;
		if (val.equals("null")) {
			whereClause = colName + " is null"; 
		} else {
			if (colType == Types.DATE) {
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
				Date dat = sdf.parse(val); 
				sdf.applyPattern("dd-MMM-yyyy");
				val = "'" + sdf.format(dat) + "'";
			} else if (colType == Types.VARCHAR || colType == Types.CHAR || 
				colType == Types.LONGVARCHAR) {
				val = "'" + val + "'";
			} 
			whereClause = colName + " = " + val;
		}
		String sqlStr = "SELECT * FROM " + tn + " WHERE " + whereClause; 
		ResultSet rs = runSQLQuery(sqlStr); 
		return rs;
	}
	
	/**
	 * convert a ResultSet object to a two dimensional array of String 
	 */
	public String[][] resultSet22DArray(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int col = rsmd.getColumnCount();
		ArrayList al = new ArrayList(1); 
		String[] row = null; 
		while (rs.next()) { 
			row = new String[col]; 
			for (int i = 0; i < col; i++) {
				Object obj = rs.getObject(i+1); 
				if (obj != null)
					row[i] = obj.toString();
				else 
					row[i] = "";
			}
			al.add(row);
		} 
		String[][] tab = new String[al.size()][col]; 
		for (int i = 0; i < al.size(); i++) {
			tab[i] = (String[])al.get(i);
		}
		return tab;
	} 
	
	/**
	 * convert a ResultSet object to an array of String 
	 */
	public String[] resultSet2Array(ResultSet rs) throws SQLException {
		ArrayList al = new ArrayList(1);
		String row = null;
		while (rs.next()) {
			row = new String("");
			Object obj = rs.getObject(1);
			if (obj != null) {
				row = obj.toString();
				al.add(row);
			}
		}
		String[] tab = new String[al.size()];
		for (int i = 0; i < al.size(); i++) {
			tab[i] = (String) (al.get(i));
		}
		return tab;
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

	/**
	 * return a String array of the column names 
	 */
	public static String[] getColumn(ResultSet rs) throws SQLException {
		ResultSetMetaData rmd = rs.getMetaData(); 
		int colNum = rmd.getColumnCount();
		String[] col = new String[colNum]; 
		for (int i = 0; i < colNum; i++) {
			col[i] = rmd.getColumnName(i+1); 
		}
		return col;
	}

	/**
	 * return a String array of the column types 
	 */
	public static int[] getColumnType(ResultSet rs) throws SQLException {
		ResultSetMetaData rmd = rs.getMetaData(); 
		int colNum = rmd.getColumnCount();
		int[] colType = new int[colNum]; 
		for (int i = 0; i < colNum; i++) {
			colType[i] = rmd.getColumnType(i+1); 
		}
		return colType;
	}
	
	/**
	 * tester
	 */
	public static void main(String[] args) throws SQLException {
		if (args.length < 2) {
			System.out.println("usage: java TableInfo db-username db-password"); 
			System.exit(1);
		}
		DBConnection tc = new DBConnection("nbdb"); 
		Connection conn = tc.getDBConnection(args[0], args[1]); 
		TableInfo ti = new TableInfo(conn); 
		System.out.println("\nYour tables are listed below.\n"); 
		String[] names = ti.listTableName(); 
		if (names.length == 0) 
			System.out.println("You do not have any table.");
		else {
			for (int i=0; i<names.length; i++) {
				System.out.println(names[i]); 
			}
			System.out.println("\nList your first table contents.\n");
			ResultSet rs = ti.getTable(names[0]);
			String[] titles = ti.getTitles(rs); 
			for (int i=0; i<titles.length; i++) {
				System.out.print(titles[i] + "\t|"); 
			}
			System.out.println("\n"); 
			String[][] table = ti.resultSet22DArray(rs); 
			for (int i=0; i<table.length; i++) {
				for (int j=0; j<table[0].length; j++) {
					System.out.print(table[i][j] + "\t|");
				}
				System.out.println(); 
			}
		}
		String[] dateS = ti.getDateColumnInShort("Emp", "HireDate"); 
		String[] dateL = ti.getDateColumn("Emp", "HireDate", DateFormat.MEDIUM);
	}
}
