package dbgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dbaccess.AddEmployee;
import dbaccess.Queries;
import JavaClasses.Person;

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
public class AddEmployeeView extends javax.swing.JFrame {
	private JTextField nameField;
	private JTextField idField;
	private JTextField street_numberField;
	private JTextField street_name_field;
	private JTextField cityField;
	private JTextField stateField;
	private JTextField zip_codeField;
	private JTextField genderField;
	private JTextField emailField;
	private JTextField skillField;

	private Person person;
	    
	private JButton submitEmployee;
	private JButton addSkill;

	private JTable table;
	private JTextArea msgArea;
	private JScrollPane msgPane;
	private JScrollPane jScrollPane1;
	private AddEmployee ae;


	/**
	* constructor takes a reference of a db accesser object 
	*/
	public AddEmployeeView(AddEmployee ae) {
		super();
		this.ae = ae;
		initGUI();
	}
	
	/**
	* drawing the GUI
	*/
	private void initGUI() {
		try {
			{
				nameField = new JTextField("Enter name of employee to add");
				getContentPane().add(nameField);
				nameField.setBounds(14, 5, 205, 28);
			}
			{
				idField = new JTextField("id");
				getContentPane().add(idField);
				idField.setBounds(14, 35, 205, 28);
			}
			{
				street_numberField = new JTextField("Street Number");
				getContentPane().add(street_numberField);
				street_numberField.setBounds(14, 65, 205, 28);
			}
			{
				street_name_field = new JTextField("Street Name");
				getContentPane().add(street_name_field);
				street_name_field.setBounds(14, 95, 205, 28);
			}
			{
				cityField = new JTextField("City");
				getContentPane().add(cityField);
				cityField.setBounds(14, 125, 205, 28);
			}
			{
				stateField = new JTextField("State");
				getContentPane().add(stateField);
				stateField.setBounds(14, 155, 205, 28);
			}
			{
				zip_codeField = new JTextField("Zip Code");
				getContentPane().add(zip_codeField);
				zip_codeField.setBounds(14, 185, 205, 28);
			}
			{
				genderField = new JTextField("Gender");
				getContentPane().add(genderField);
				genderField.setBounds(14, 215, 205, 28);
			}
			{
				emailField = new JTextField("Email");
				getContentPane().add(emailField);
				emailField.setBounds(14, 245, 205, 28);
			}
			
			
			{
				submitEmployee = new JButton();
				getContentPane().add(submitEmployee);
				submitEmployee.setText("Submit Employee");
				submitEmployee.setBounds(14, 275, 175, 28);
				submitEmployee.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						submitEmployeeButActionPerformed(evt);
					}
				});
			}
			{
				skillField = new JTextField("Skill_id **adds to employee above**");
				getContentPane().add(skillField);
				skillField.setBounds(14, 305, 205, 28);
			}
			{
				addSkill = new JButton();
				getContentPane().add(addSkill);
				addSkill.setText("Add Skill");
				addSkill.setBounds(14, 335, 175, 28);
				addSkill.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						addSkillButActionPerformed(evt);
					}
				});
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
	private void submitEmployeeButActionPerformed(ActionEvent evt) {
		person = new Person(Integer.parseInt(idField.getText()), nameField.getText(),
				 Integer.parseInt(street_numberField.getText()), street_name_field.getText(), 
				 cityField.getText(), stateField.getText(), zip_codeField.getText(),
				 genderField.getText(), emailField.getText());
		
		
		//create sql statement then request result set from db
		try {
			ae.insertEmployee(person);
		
			msgArea.append("\nEmployee inserted successfully");
		} catch (SQLException sqle) {
			msgArea.append("\n" + sqle.toString());
		}
	}
	private void addSkillButActionPerformed(ActionEvent evt) {

		//create sql statement then request result set from db
		try {
			ae.addSkill(idField.getText(), skillField.getText());
		
			msgArea.append("\nSkill added successfully");
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
