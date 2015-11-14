package dbgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dbaccess.DBConnection;
import dbaccess.ProjectQueries;
import dbaccess.Queries;

import java.sql.Connection;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class QueryView extends javax.swing.JFrame {
	private Queries q;
	private JLabel tnLabel;
	private JComboBox tnJCombo;
	private JTable table;
	private JTextArea msgArea;
	private JScrollPane msgPane;
	private JScrollPane jScrollPane1;
	private Connection db;

	/**
	* constructor takes a reference of a db accesser object 
	*/
	public QueryView(Queries q,Connection dbc) {
		super();
		this.q = q;
		this.db=dbc;
		initGUI();
	}
	
	public QueryView(Queries q) {
		super();
		this.q = q;
		initGUI();
	}
	
	/**
	* drawing the GUI
	*/
	private void initGUI() {
		try {
			{
				tnLabel = new JLabel();
				getContentPane().add(tnLabel);
				tnLabel.setText("Chose a Query: ");
				tnLabel.setBounds(7, 0, 91, 28);
			}
			{
				ComboBoxModel tnJComboModel = new DefaultComboBoxModel(q.listQueries());
				tnJCombo = new JComboBox();
				getContentPane().add(tnJCombo);
				tnJCombo.setModel(tnJComboModel);
				tnJCombo.setBounds(7, 28, 231, 28);
				tnJCombo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						tnJComboActionPerformed(evt);
					}
				});
			}
			{
				TableModel tableModel = new DefaultTableModel( 
											new String[][] {{" ", " "}}, 
											new String[] {"Column 1", "Column 2" });
				table = new JTable();
				table.setModel(tableModel);
				table.setBounds(21, 56, 826, 357);
			}
			{
				jScrollPane1 = new JScrollPane(table);
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(7, 98, 861, 329);
			}
			{
				msgPane = new JScrollPane();
				getContentPane().add(msgPane);
				msgPane.setBounds(245, 0, 623, 91);
				{
					msgArea = new JTextArea();
					msgPane.setViewportView(msgArea);
					msgArea.setText("messages from the database system ");
				}
			}
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			pack();
			this.setSize(883, 485);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	* Combobox's action
	*/
	private void tnJComboActionPerformed(ActionEvent evt) {
		//System.out.println("tnJCombo.actionPerformed, event=" + evt);
		String chosenQuery = (String) tnJCombo.getSelectedItem();
		ProjectQueries queries =new ProjectQueries();
		String query= queries.getQuery(chosenQuery);
		System.out.println(query);
		try {
			ResultSet rs = q.runSQLQuery(query);
			Vector res = q.resultSet2Vector(rs);
			TableModel tableModel = new DefaultTableModel(res, q.getTitlesAsVector(rs));
			table.setModel(tableModel);
			msgArea.append("\nNumber of records in is " + res.size());
		} catch (SQLException sqle) {
			msgArea.append("\n" + sqle.toString());
		}
	}
	
	public ResultSet runSQLQuery(String str) throws SQLException {
		Statement stmt = db.createStatement();
		return stmt.executeQuery(str);
	}	
	/**
	* activater
	*/
	public static void main(String[] args) throws Exception { 
		if (args.length < 2) {
			System.out.println("usage: java TableInfo db-username db-password"); 
			System.exit(1);
		}
		Queries q = new Queries(args[0], args[1]);
//		TableInfo ti = new TableInfo("scott", "tiger");
		QueryView inst = new QueryView(q);
		inst.setVisible(true);
	}
	
}
