package dbgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dbaccess.TableInfo;

import java.sql.ResultSet;


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
public class DateRange extends javax.swing.JFrame {
	private DatePanel jPanel1;
	private JPanel tabPanel;
	private JTable resultTable;
	private JButton jButton1;
	private DatePanel jPanel2;
	private JTable table;
	private JScrollPane jScrollPane1;
	
	private TableInfo ti;
	private String tableName;
	private String dateField;
	
	public DateRange(TableInfo ti, String tableName, String dateField) {
		super();
		this.ti = ti;
		this.tableName = tableName;
		this.dateField = dateField;
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				jPanel1 = new DatePanel("From:");
				getContentPane().add(jPanel1);
				jPanel1.setBounds(35, 21, 252, 42);
			}
			{
				jPanel2 = new DatePanel("To:");
				getContentPane().add(jPanel2);
				jPanel2.setBounds(329, 21, 210, 49);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Run Query");
				jButton1.setBounds(595, 14, 133, 35);
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton1ActionPerformed(evt);
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
				jScrollPane1.setBounds(7, 70, 966, 357);
			}
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			pack();
			this.setSize(995, 500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void jButton1ActionPerformed(ActionEvent evt) {
//		System.out.println("jButton1.actionPerformed, event=" + evt);
		//TODO add your code for jButton1.actionPerformed
		String date1 = jPanel1.getDateString() ; 
		String selStr = "SELECT * FROM " + tableName + " WHERE " + dateField + 
						" BETWEEN '" + jPanel1.getDateString() + "' AND '" + jPanel2.getDateString() + "'";
		try {
			ResultSet rs = ti.runSQLQuery(selStr);
			TableModel tableModel = new DefaultTableModel(ti.resultSet2Vector(rs), ti.getTitlesAsVector(rs));
			table.setModel(tableModel); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) throws Exception {
		if (args.length < 2) {
			System.out.println("usage: java TableInfo db-username db-password"); 
			System.exit(1);
		}
		TableInfo ti = new TableInfo(args[0], args[1]); 
//		TableInfo ti = new TableInfo("scott", "tiger");
		DateRange dr = new DateRange(ti, "Emp", "HireDate");
		dr.setVisible(true);
	}
}
