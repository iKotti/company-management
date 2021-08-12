package ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Business.concretes.CompanyManager;
import Business.concretes.EmployeeManager;
import Business.concretes.SectionManager;
import Entity.Company;
import Entity.Employee;
import Entity.Section;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;

public class Dashboard extends JFrame {
	
	List<Company> companies = new ArrayList<Company>();
	List<Section> sections = new ArrayList<Section>();
	List<Employee> employees = new ArrayList<Employee>();

	// Company Table
	String[] companyCol = { "Kod", "Ünvan" };
	DefaultTableModel companyTableModel = new DefaultTableModel(companyCol, 0);
	JTable companyTable = new JTable(companyTableModel);

	// Section Table
	String[] sectionCol = { "Kod", "Ad" };
	DefaultTableModel sectionTableModel = new DefaultTableModel(sectionCol, 0);
	JTable sectionTable = new JTable(sectionTableModel);

	// Employee Table
	String[] employeeCol = { "Sicil No", "Ad" };
	DefaultTableModel employeeTableModel = new DefaultTableModel(employeeCol, 0);
	JTable employeeTable = new JTable(employeeTableModel);

	public Dashboard() {
		companyPanel();
		sectionPanel();
		employeePanel();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(500, 200, 700, 684);
		getContentPane().setLayout(null);
		setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Coded by github.com/iKotti");
		lblNewLabel.setBounds(521, 620, 153, 14);
		getContentPane().add(lblNewLabel);
	}

	public void companyPanel() {
		// GetAll
		CompanyManager companyManager = new CompanyManager();
		companies = companyManager.getAll();

		// Title
		JLabel lblCompanyTitle = new JLabel("\u015E\u0130RKETLER");
		lblCompanyTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCompanyTitle.setBounds(102, 11, 110, 29);
		getContentPane().add(lblCompanyTitle);

		// Pane
		JScrollPane companyPane = new JScrollPane();
		companyPane.setBounds(10, 91, 284, 518);
		getContentPane().add(companyPane);

		for (Company company : companies) {
			String[] companyData = { company.getCompanyCode(), company.getCompanyTitle() };
			companyTableModel.addRow(companyData);
		}
		
		companyPane.setViewportView(companyTable);

		// Dialogs
		JDialog addCompanyDialog = new JDialog();
		addCompanyDialog.setResizable(false);
		addCompanyDialog.setBounds(600, 300, 500, 500);
		addCompanyDialog.setTitle("Þirket Ekle");

		// Buttons
		JButton btnAddCompany = new JButton("Ekle");
		btnAddCompany.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		btnAddCompany.setForeground(new Color(255, 255, 255));
		btnAddCompany.setBackground(new Color(40, 167, 69));
		btnAddCompany.setBounds(10, 51, 89, 29);
		getContentPane().add(btnAddCompany);

		JButton btnDeleteCompany = new JButton("Sil");
		btnDeleteCompany.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		btnDeleteCompany.setForeground(new Color(255, 255, 255));
		btnDeleteCompany.setBackground(new Color(220, 53, 69));
		btnDeleteCompany.setBounds(109, 51, 89, 29);
		getContentPane().add(btnDeleteCompany);

		btnDeleteCompany.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = companyTable.getSelectedRow();

				if (row < 0) {
					getFeedbackDialog("Hata", "Lütfen silmek istediðiniz þirketi seçiniz.");
					return;
				}

				Company company = companies.get(row);
				getCompanyAreYouSureDialog(company, companyTableModel, companies, row);
			}
		});

		JButton btnUpdateCompany = new JButton("G\u00FCncelle");
		btnUpdateCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = companyTable.getSelectedRow();

				if (row < 0) {
					getFeedbackDialog("Hata", "Lütfen güncellemek istediðiniz þirketi seçiniz.");
					return;
				}
				Company company = companies.get(row);
				getUpdateCompanyDialog(company,row);
				
			}
		});
		btnUpdateCompany.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		btnUpdateCompany.setForeground(new Color(255, 255, 255));
		btnUpdateCompany.setBackground(new Color(0, 123, 255));
		btnUpdateCompany.setBounds(205, 51, 89, 29);
		getContentPane().add(btnUpdateCompany);

		btnAddCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getCompanyDialog();
			}
		});

		companyTable.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int companyId = companies.get(companyTable.getSelectedRow()).getCompanyId();
				SectionManager sectionManager = new SectionManager();
				sections = sectionManager.getAll(companyId);
				sectionTableModel = (DefaultTableModel) sectionTable.getModel();

				for (int i = 0; i < sectionTableModel.getRowCount(); i++) {
					sectionTableModel.removeRow(i);
				}

				for (Section section : sections) {
					String[] sectionData = { section.getSectionCode(), section.getSectionName() };
					sectionTableModel.addRow(sectionData);
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	public void getCompanyDialog() {
		CompanyDialog dialog = new CompanyDialog(this, companyTableModel, companies);
		dialog.setLocationRelativeTo(this);
		dialog.setName("Company Dialog");
		dialog.setVisible(true);
	}
	
	public void getUpdateCompanyDialog(Company company,int row) {
		CompanyDialog dialog = new CompanyDialog(this, companyTableModel, companies, company,row);
		dialog.setLocationRelativeTo(this);
		dialog.setName("Company Dialog");
		dialog.setVisible(true);
	}

	public void sectionPanel() {
		// Title
		JLabel lblSectionTitle = new JLabel("B\u00D6L\u00DCMLER");
		lblSectionTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSectionTitle.setBounds(456, 11, 110, 29);
		getContentPane().add(lblSectionTitle);

		// Buttons
		JButton btnAddSection = new JButton("Ekle");
		btnAddSection.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		btnAddSection.setForeground(new Color(255, 255, 255));
		btnAddSection.setBackground(new Color(40, 167, 69));

		btnAddSection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int row = companyTable.getSelectedRow();
				if (row < 0) {
					getFeedbackDialog("Hata", "Lütfen bölüm eklemek istediðiniz þirketi seçiniz.");
					return;
				}

				Company company = companies.get(row);
				getSectionDialog(company);
			}
		});

		sectionTable.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int sectionId = sections.get(sectionTable.getSelectedRow()).getSectionId();
				EmployeeManager employeeManager = new EmployeeManager();
				employees = employeeManager.getAll(sectionId);
				employeeTableModel = (DefaultTableModel) employeeTable.getModel();

				for (int i = 0; i < employeeTableModel.getRowCount(); i++) {
					employeeTableModel.removeRow(i);
				}

				for (Employee employee : employees) {
					String[] employeeData = { employee.getRegistrationNumber(), employee.getEmployeeName() };
					employeeTableModel.addRow(employeeData);
				}

			}
		});

		btnAddSection.setBounds(330, 51, 89, 29);
		getContentPane().add(btnAddSection);

		JButton btnDeleteSection = new JButton("Sil");
		btnDeleteSection.setForeground(new Color(255, 255, 255));
		btnDeleteSection.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		btnDeleteSection.setBackground(new Color(220, 53, 69));
		btnDeleteSection.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = sectionTable.getSelectedRow();

				if (row < 0) {
					getFeedbackDialog("Hata", "Lütfen silmek istediðiniz bölümü seçiniz.");
					return;
				}

				Section section = sections.get(row);
				getSectionAreYouSureDialog(section, sectionTableModel, sections, row);
			}
		});
		btnDeleteSection.setBounds(463, 51, 89, 29);
		getContentPane().add(btnDeleteSection);

		JButton btnUpdateSection = new JButton("G\u00FCncelle");
		btnUpdateSection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = sectionTable.getSelectedRow();

				if (row < 0) {
					getFeedbackDialog("Hata", "Lütfen güncellemek istediðiniz bölümü seçiniz.");
					return;
				}
				
				Section section = sections.get(row);
				getUpdateSectionDialog(section,row,companies);
			}
		});
		btnUpdateSection.setForeground(new Color(255, 255, 255));
		btnUpdateSection.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		btnUpdateSection.setBackground(new Color(0, 123, 255));
		btnUpdateSection.setBounds(585, 51, 89, 29);
		getContentPane().add(btnUpdateSection);

		JScrollPane sectionPane = new JScrollPane();
		sectionPane.setBounds(330, 91, 344, 203);
		getContentPane().add(sectionPane);

		// Section Table
		sectionPane.setViewportView(sectionTable);

	}

	public void employeePanel() {

		// Title
		JLabel lblEmplyeeTitle = new JLabel("PERSONELLER");
		lblEmplyeeTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmplyeeTitle.setBounds(444, 320, 138, 29);
		getContentPane().add(lblEmplyeeTitle);

		// Buttons
		JButton btnAddEmployee = new JButton("Ekle");
		btnAddEmployee.setForeground(new Color(255, 255, 255));
		btnAddEmployee.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		btnAddEmployee.setBackground(new Color(40, 167, 69));

		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int row = sectionTable.getSelectedRow();
				if (row < 0) {
					getFeedbackDialog("Hata", "Lütfen çalýþan eklemek istediðiniz bölümü ve þirketi seçiniz.");
					return;
				}

				Section section = sections.get(row);
				getEmployeeDialog(section);
			}
		});
		btnAddEmployee.setBounds(330, 360, 89, 29);
		getContentPane().add(btnAddEmployee);

		JButton btnDeleteEmployee = new JButton("Sil");
		btnDeleteEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = employeeTable.getSelectedRow();

				if (row < 0) {
					getFeedbackDialog("Hata", "Lütfen silmek istediðiniz çalýþaný seçiniz.");
					return;
				}

				Employee employee = employees.get(row);
				getEmployeeAreYouSureDialog(employee, employeeTableModel, employees, row);
				
			}
		});
		btnDeleteEmployee.setForeground(new Color(255, 255, 255));
		btnDeleteEmployee.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		btnDeleteEmployee.setBackground(new Color(220, 53, 69));
		btnDeleteEmployee.setBounds(463, 360, 89, 29);
		getContentPane().add(btnDeleteEmployee);

		JButton btnUpdateEmployee = new JButton("G\u00FCncelle");
		btnUpdateEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = employeeTable.getSelectedRow();

				if (row < 0) {
					getFeedbackDialog("Hata", "Lütfen güncellemek çalýþaný bölümü seçiniz.");
					return;
				}
				
				Employee employee = employees.get(row);
				getUpdateEmployeeDialog(employee,row,sections);
				
			}
		});
		btnUpdateEmployee.setForeground(new Color(255, 255, 255));
		btnUpdateEmployee.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		btnUpdateEmployee.setBackground(new Color(0, 123, 255));
		btnUpdateEmployee.setBounds(585, 360, 89, 29);
		getContentPane().add(btnUpdateEmployee);

		JScrollPane employeePane = new JScrollPane();
		employeePane.setBounds(330, 400, 344, 209);
		getContentPane().add(employeePane);

		// Table
		employeePane.setViewportView(employeeTable);

	}

	public void getFeedbackDialog(String title, String label) {
		FeedbackDialog feedbackDialog = new FeedbackDialog(title, label);
		feedbackDialog.setLocationRelativeTo(this);
		feedbackDialog.setName("Feedback Dialog");
		feedbackDialog.setVisible(true);
	}

	public void getCompanyAreYouSureDialog(Company company, DefaultTableModel companyTableModel,
			List<Company> companies, int selectedRow) {
		AreYouSureDialog areYouSureDialog = new AreYouSureDialog(company, companyTableModel, companies, selectedRow);
		areYouSureDialog.setLocationRelativeTo(this);
		areYouSureDialog.setName("Are You Sure Dialog");
		areYouSureDialog.setVisible(true);
	}

	public void getSectionAreYouSureDialog(Section section, DefaultTableModel sectionTableModel, List<Section> sections,
			int selectedRow) {
		AreYouSureDialog areYouSureDialog = new AreYouSureDialog(section, sectionTableModel, sections, selectedRow);
		areYouSureDialog.setLocationRelativeTo(this);
		areYouSureDialog.setName("Are You Sure Dialog");
		areYouSureDialog.setVisible(true);
	}
	
	public void getEmployeeAreYouSureDialog(Employee employee,DefaultTableModel employeeTableModel,List<Employee> employees,
			int selectedRow) {
		AreYouSureDialog areYouSureDialog = new AreYouSureDialog(employee, employeeTableModel, employees, selectedRow);
		areYouSureDialog.setLocationRelativeTo(this);
		areYouSureDialog.setName("Are You Sure Dialog");
		areYouSureDialog.setVisible(true);
	}

	public void getSectionDialog(Company company) {
		SectionDialog sectionDialog = new SectionDialog(company);
		sectionDialog.setLocationRelativeTo(this);
		sectionDialog.setName("Section Dialog");
		sectionDialog.setVisible(true);
	}
	
	public void getUpdateSectionDialog(Section section,int row,List<Company> companies) {
		SectionDialog sectionDialog = new SectionDialog(this, sectionTableModel, sections, section,row);
		sectionDialog.setLocationRelativeTo(this);
		sectionDialog.setName("Section Dialog");
		sectionDialog.setVisible(true);
	}

	public void getEmployeeDialog(Section section) {
		EmployeeDialog employeeDialog = new EmployeeDialog(section);
		employeeDialog.setLocationRelativeTo(this);
		employeeDialog.setName("Employee Dialog");
		employeeDialog.setVisible(true);
	}
	
	public void getUpdateEmployeeDialog(Employee employee,int row, List<Section>sections) {
		EmployeeDialog employeeDialog = new EmployeeDialog(this, employeeTableModel, employees, employee,row);
		employeeDialog.setLocationRelativeTo(this);
		employeeDialog.setName("Employee Dialog");
		employeeDialog.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
					frame.setVisible(true);
					frame.setTitle("Þirket Yönetimi");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
