package dbaccess;


import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ScriptLoader {
	Scanner fileScanner;
	File createFile;
	File insertFile;
	File dropFile;
	public ScriptLoader()
	{
		createFile= new File("src/scripts/createTables.sql");
		insertFile= new File("src/scripts/insertAllTables.sql");
		dropFile= new File("src/scripts/dropAllTables.sql");
	}
	
	public String CreateTables()
	{
		return getScript(createFile);
	}
	public String insertAllTables()
	{
		return getScript(insertFile);
	}
	public String DropAllTables(Connection db)
	{
		String str=getScript(dropFile);		 
		try {
			Statement stmt = db.createStatement();
			ResultSet rs = stmt.executeQuery(str);
			str="";
			while(rs.next())
			str+=rs.getString(1);
			return str;

		} catch (SQLException sqle) {
			System.out.println("\nsomething wrong: \n"+sqle.getMessage());
		}
		return "";
	}
	
	
	public String getScript(File file)
	{
		String text="";
			try {
				fileScanner=new Scanner(file);
				while(fileScanner.hasNext())
				{
					text +=fileScanner.nextLine();
				}
				return text;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return text;
	}
		
}
