package dbgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dbaccess.JobApply;
import dbaccess.Queries;

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
public class JobApplyView extends javax.swing.JFrame {
	private JTextField nameField;
	private JButton allJobs;
	private JButton bestFitJobs;
	private JButton trainingTrackForJob;
	private JTable table;
	private JTextArea msgArea;
	private JScrollPane msgPane;
	private JScrollPane jScrollPane1;
	private JobApply ja;
	private String name;

	/**
	* constructor takes a reference of a db accesser object 
	*/
	public JobApplyView(JobApply ja) {
		super();
		this.ja = ja;
		initGUI();
	}
	
	/**
	* drawing the GUI
	*/
	private void initGUI() {
		try {
			{
				nameField = new JTextField("Enter your name");
				getContentPane().add(nameField);
				nameField.setBounds(14, 5, 119, 28);
			}
			{
				allJobs = new JButton();
				getContentPane().add(allJobs);
				allJobs.setText("All jobs ");
				allJobs.setBounds(14, 40, 175, 28);
				allJobs.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						allJobsButActionPerformed(evt);
					}
				});
			}
			{
				bestFitJobs = new JButton();
				getContentPane().add(bestFitJobs);
				bestFitJobs.setText("Jobs you qualify for");
				bestFitJobs.setBounds(14, 75, 175, 28);
				bestFitJobs.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						bestFitJobsButActionPerformed(evt);
					}
				});
			}
			{
				nameField = new JTextField("Enter the job");
				getContentPane().add(nameField);
				nameField.setBounds(14, 110, 119, 28);
			}
			{
				trainingTrackForJob = new JButton();
				getContentPane().add(trainingTrackForJob);
				trainingTrackForJob.setText("Training track for job");
				trainingTrackForJob.setBounds(14, 145, 175, 28);
				trainingTrackForJob.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						trainingTrackForJobButActionPerformed(evt);
					}
				});
			}
			{
				TableModel tableModel = new DefaultTableModel( 
											new String[][] {{" ", " "}}, 
											new String[] {"Column 1", "Column 2" });
				table = new JTable();
				table.setModel(tableModel);
				table.setBounds(21, 200, 826, 357);
			}
			{
				jScrollPane1 = new JScrollPane(table);
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(7, 200, 861, 329);
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
	* User's action
	*/
	private void allJobsButActionPerformed(ActionEvent evt) {

		//create sql statement then request result set from db
		try {
			ResultSet rs = ja.getAllJobs();
			Vector res = ja.resultSet2Vector(rs);
			TableModel tableModel = new DefaultTableModel(res, ja.getTitlesAsVector(rs));
			table.setModel(tableModel);
			msgArea.append("\nNumber of records in result is " + res.size());
		} catch (SQLException sqle) {
			msgArea.append("\n" + sqle.toString());
		}
	}
	private void trainingTrackForJobButActionPerformed(ActionEvent evt) {
//		try {
//			ResultSet rs = q.getTable(chosenTable);
//			Vector res = q.resultSet2Vector(rs);
//			TableModel tableModel = new DefaultTableModel(res, q.getTitlesAsVector(rs));
//			table.setModel(tableModel);
//			msgArea.append("\nNumber of records in " + chosenTable + " is " + res.size());
//		} catch (SQLException sqle) {
//			msgArea.append("\n" + sqle.toString());
//		}
	}
	private void bestFitJobsButActionPerformed(ActionEvent evt) {
		try {
			name = nameField.getText();
			ResultSet rs = ja.getBestFitJobs(name);
			Vector res = ja.resultSet2Vector(rs);
			TableModel tableModel = new DefaultTableModel(res, ja.getTitlesAsVector(rs));
			table.setModel(tableModel);
			msgArea.append("\nNumber of records in result is " + res.size());
		} catch (SQLException sqle) {
			msgArea.append("\n" + sqle.toString());
		}
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
