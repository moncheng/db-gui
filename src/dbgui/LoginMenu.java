package dbgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import dbaccess.DBConnection;
import dbaccess.JobApply;
import dbaccess.AddEmployee;
import dbaccess.RecruitEmployee;
import dbaccess.Queries;
import dbaccess.TableInfo;
import dbaccess.TableUpdate;

import java.io.StringWriter; 
import java.io.PrintWriter;

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
public class LoginMenu extends javax.swing.JFrame {
	private JLabel menuTitle;
	private JLabel usernameLab;
	private JLabel passwdLab;
	private JLabel generalLab;
	private JLabel searchLab;
	private JLabel recruitLab;

	private JButton mySQLBut;
	private JButton queryBut;
	private JButton tabModBut;
	private JButton tabSelectBut;
	private JButton jobSearchBut;
	private JButton recruitBut;
	private JButton trainingTrackBut;
	private JButton addEmployeeBut;
	private JButton tabViewBut;
	private JButton loginBut;
	private JTextField passwdField;
	private JTextField usernameField;
	
	/*dbAccess objects*/
	private java.sql.Connection conn;
	private TableInfo ti;
	private JobApply ja;
	private AddEmployee ae;
	private RecruitEmployee re;
	
	private Queries q;
	private JTextArea msgArea;
	private JTextField sidField;
	private JLabel sidLab;
	private JTextField portField;
	private JLabel portLab;
	private JTextField hostField;
	private JLabel hostLab;
	private TableUpdate tu;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		LoginMenu inst = new LoginMenu();
		inst.setVisible(true);
		
	}
	
	public LoginMenu() {
		super();
		initGUI();
		this.setTitle("Recruit Employees");
		loginButActionPerformed();
		
	}
	
	private void initGUI() {
		try {
//			{
//				menuTitle = new JLabel();
//				getContentPane().add(menuTitle);
//				menuTitle.setText("Menu");
//				menuTitle.setBounds(91, 133, 63, 28);
//			}
			{
				usernameLab = new JLabel();
				getContentPane().add(usernameLab);
//				usernameLab.setText("User name");
//				usernameLab.setBounds(35, 14, 91, 28);
			}
			{
				usernameField = new JTextField("id");
//				getContentPane().add(usernameField);
//				usernameField.setBounds(133, 14, 119, 28);
			}
			{
				passwdLab = new JLabel();
//				getContentPane().add(passwdLab);
//				passwdLab.setText("passwordField");
//				passwdLab.setBounds(35, 49, 105, 28);
			}
			{
				passwdField = new JTextField("pass");
//				getContentPane().add(passwdField);
//				passwdField.setBounds(133, 49, 119, 28);
			}
			{
//				loginBut = new JButton();
//				getContentPane().add(loginBut);
//				loginBut.setText("Login ");
//				loginBut.setBounds(14, 91, 175, 28);
//				loginBut.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent evt) {
//						loginButActionPerformed(evt);
//					}
//				});
			}
			{
				generalLab = new JLabel();
				getContentPane().add(generalLab);
				generalLab.setText("General");
				generalLab.setBounds(80, 5, 175, 28);
			}
			{
				tabViewBut = new JButton();
				getContentPane().add(tabViewBut);
				tabViewBut.setText("View Table ");
				tabViewBut.setBounds(14, 40, 175, 28);
				tabViewBut.setEnabled(false);
				tabViewBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						tabViewButActionPerformed(evt);
					}
				});
			}
			{
				queryBut = new JButton();
				getContentPane().add(queryBut);
				queryBut.setText("Scripts");
				queryBut.setBounds(14, 75, 175, 28);
				queryBut.setEnabled(false);
				queryBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						queryButButActionPerformed(evt);
					}
				});

			}
			{
//				tabSelectBut = new JButton();
//				getContentPane().add(tabSelectBut);
//				tabSelectBut.setText("Select rows from tables");
//				tabSelectBut.setBounds(14, 231, 175, 28);
//				tabSelectBut.setEnabled(false);
//				tabSelectBut.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent evt) {
//						tabSelectButActionPerformed(evt);
//					}
//				});
			}
			{
//				tabModBut = new JButton();
//				getContentPane().add(tabModBut);
//				tabModBut.setText("Insert rows to tables");
//				tabModBut.setBounds(14, 266, 175, 28);
//				tabModBut.setEnabled(false);
//				tabModBut.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent evt) {
//						tabModButActionPerformed(evt);
//					}
//				});
			}
			{
//				mySQLBut = new JButton();
//				getContentPane().add(mySQLBut);
//				mySQLBut.setText("My SQL-PLUS");
//				mySQLBut.setBounds(14, 301, 175, 28);
//				mySQLBut.setEnabled(false);
//				mySQLBut.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent evt) {
//						mySQLButActionPerformed(evt);
//					}
//				});
			}
			{
				searchLab = new JLabel();
				getContentPane().add(searchLab);
				searchLab.setText("Job Search");
				searchLab.setBounds(250, 5, 175, 28);
			}
			{
				jobSearchBut = new JButton();
				getContentPane().add(jobSearchBut);
				jobSearchBut.setText("Apply for a job");
				jobSearchBut.setBounds(210, 40, 147, 28);
				jobSearchBut.setEnabled(false);
				jobSearchBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jobApplyButActionPerformed(evt);
					}
				});
			}
			{
				recruitLab = new JLabel();
				getContentPane().add(recruitLab);
				recruitLab.setText("Recruiters");
				recruitLab.setBounds(440, 5, 175, 28);
			}
			{
				recruitBut = new JButton();
				getContentPane().add(recruitBut);
				recruitBut.setText("Recruit applicants");
				recruitBut.setBounds(392, 40, 147, 28);
				recruitBut.setEnabled(false);
				recruitBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						recruitButActionPerformed(evt);
					}
				});
			}
			{
				addEmployeeBut = new JButton();
				getContentPane().add(addEmployeeBut);
				addEmployeeBut.setText("Add An Employee");
				addEmployeeBut.setBounds(392, 75, 147, 28);
				addEmployeeBut.setEnabled(false);
				addEmployeeBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						addEmployeeButActionPerformed(evt);
					}
				});
			}
			{
//				hostLab = new JLabel();
//				getContentPane().add(hostLab);
//				hostLab.setText("database host");
//				hostLab.setBounds(287, 14, 105, 28);
			}
			{
				hostField = new JTextField();
//				getContentPane().add(hostField);
				hostField.setText("dbsvcs.cs.uno.edu");
				hostField.setBounds(392, 14, 147, 28);
			}
			{
//				portLab = new JLabel();
//				getContentPane().add(portLab);
//				portLab.setText("databse port");
//				portLab.setBounds(294, 49, 98, 28);
			}
			{
				portField = new JTextField();
//				getContentPane().add(portField);
				portField.setText("1521");
				portField.setBounds(392, 49, 70, 28);
			}
//			{
//				sidLab = new JLabel();
//				getContentPane().add(sidLab);
//				sidLab.setText("database name (SID)");
//				sidLab.setBounds(245, 84, 147, 28);
//			}
			{
				sidField = new JTextField();
//				getContentPane().add(sidField);
				sidField.setText("orcl");
				sidField.setBounds(392, 84, 119, 28);
			}
			{
				msgArea = new JTextArea();
				getContentPane().add(msgArea);
				msgArea.setText("database message");
				msgArea.setBounds(14, 119, 633, 231);
			}
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			pack();
			this.setSize(680, 500);
			this.setTitle("LinRobertson Express Business Solution");
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	
	private void loginButActionPerformed() {

//	private void loginButActionPerformed(ActionEvent evt) {
		// System.out.println("loginBut.actionPerformed, event=" + evt);
//		String username = usernameField.getText();
//		String passwd = passwdField.getText();
//		String host = hostField.getText();
//		String port = portField.getText();
//		String sid = sidField.getText();
		
		String username = "srobert6";
		String passwd = "XMhL7Kpc";
		String host = hostField.getText();
		String port = portField.getText();
		String sid = sidField.getText();
		DBConnection dbc = new DBConnection(host, port, sid);
		try {
			conn = dbc.getDBConnection(username, passwd);
			tu = new TableUpdate(conn);
			ti = tu.getTableInfo();
			q = new Queries(conn);
			ja = new JobApply(conn);
			ae = new AddEmployee(conn);
			re= new RecruitEmployee(conn);
			tabViewBut.setEnabled(true);
			queryBut.setEnabled(true);
//			tabSelectBut.setEnabled(true);
//			tabModBut.setEnabled(true);
//			mySQLBut.setEnabled(true);
			jobSearchBut.setEnabled(true);
			recruitBut.setEnabled(true);
			addEmployeeBut.setEnabled(true);
		} catch (java.sql.SQLException sqle) {
			StringWriter strMsg = new StringWriter();
			PrintWriter prtMsg = new PrintWriter(strMsg);
			sqle.printStackTrace(prtMsg); 
			msgArea.setText(strMsg.toString());
		}
	}

	private void queryButButActionPerformed(ActionEvent evt) {
		//System.out.println("tabViewBut.actionPerformed, event=" + evt);
		QueryView inst = new QueryView(q,conn);
		inst.setVisible(true);
	}

	private void tabViewButActionPerformed(ActionEvent evt) {
		//System.out.println("tabViewBut.actionPerformed, event=" + evt);
		TableView inst = new TableView(ti);
		inst.setVisible(true);
	}
	
	private void tabSelectButActionPerformed(ActionEvent evt) {
		//System.out.println("tabSelectBut.actionPerformed, event=" + evt);
		TableSelect inst = new TableSelect(ti);
		inst.setVisible(true);
	}
	
	private void tabModButActionPerformed(ActionEvent evt) {
		//System.out.println("tabModBut.actionPerformed, event=" + evt);
		TableModifier inst = new TableModifier(tu);
		inst.setVisible(true);
	}
	
	private void mySQLButActionPerformed(ActionEvent evt) {
		//System.out.println("mySQLBut.actionPerformed, event=" + evt);
		MySQLPLUS ms = new MySQLPLUS(ti);
		ms.setVisible(true);
	}
	private void jobApplyButActionPerformed(ActionEvent evt) {
		//System.out.println("mySQLBut.actionPerformed, event=" + evt);
		JobApplyView jv = new JobApplyView(ja);
		jv.setVisible(true);
	}
	private void recruitButActionPerformed(ActionEvent evt) {
		//System.out.println("mySQLBut.actionPerformed, event=" + evt);
		RecruitEmployeeView rev = new RecruitEmployeeView(re);
		rev.setSize(900, 600);
		rev.setVisible(true);

	}
	private void addEmployeeButActionPerformed(ActionEvent evt) {
		//System.out.println("mySQLBut.actionPerformed, event=" + evt);
		AddEmployeeView av = new AddEmployeeView(ae);
		av.setVisible(true);
	}
	private void trainingTrackButActionPerformed(ActionEvent evt) {
		//System.out.println("mySQLBut.actionPerformed, event=" + evt);

	}
}
