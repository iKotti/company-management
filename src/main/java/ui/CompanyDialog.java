package ui;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Business.concretes.CompanyManager;
import Entity.Company;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class CompanyDialog extends JDialog {

	private String companyCode;
	private String companyName;

	private JTextField tfCompanyCode;
	private JTextField tfCompanyName;

	private Company company = new Company();

	public CompanyDialog(Component c, DefaultTableModel companyTableModel, List<Company> companies) {

		setBounds(500, 200, 389, 161);
		setResizable(false);
		setTitle("Þirket Ekle");

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 77, 195, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblcompanyCode = new JLabel("Kod");
		GridBagConstraints gbc_lblcompanyCode = new GridBagConstraints();
		gbc_lblcompanyCode.anchor = GridBagConstraints.WEST;
		gbc_lblcompanyCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblcompanyCode.gridx = 1;
		gbc_lblcompanyCode.gridy = 1;
		getContentPane().add(lblcompanyCode, gbc_lblcompanyCode);

		tfCompanyCode = new JTextField();
		GridBagConstraints gbc_tfCompanyCode = new GridBagConstraints();
		gbc_tfCompanyCode.insets = new Insets(0, 0, 5, 5);
		gbc_tfCompanyCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCompanyCode.gridx = 2;
		gbc_tfCompanyCode.gridy = 1;
		getContentPane().add(tfCompanyCode, gbc_tfCompanyCode);
		tfCompanyCode.setColumns(10);

		JLabel lblCompanyName = new JLabel("\u015Eirket Ad\u0131");
		GridBagConstraints gbc_lblCompanyName = new GridBagConstraints();
		gbc_lblCompanyName.anchor = GridBagConstraints.WEST;
		gbc_lblCompanyName.insets = new Insets(0, 0, 5, 5);
		gbc_lblCompanyName.gridx = 1;
		gbc_lblCompanyName.gridy = 2;
		getContentPane().add(lblCompanyName, gbc_lblCompanyName);

		tfCompanyName = new JTextField();
		GridBagConstraints gbc_tfCompanyName = new GridBagConstraints();
		gbc_tfCompanyName.insets = new Insets(0, 0, 5, 5);
		gbc_tfCompanyName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCompanyName.gridx = 2;
		gbc_tfCompanyName.gridy = 2;
		getContentPane().add(tfCompanyName, gbc_tfCompanyName);
		tfCompanyName.setColumns(10);

		JButton btnAddCompany = new JButton("Ekle");
		GridBagConstraints gbc_btnAddCompany = new GridBagConstraints();
		btnAddCompany.setBackground(new Color(40, 167, 69));
		btnAddCompany.setForeground(new Color(255, 255, 255));
		btnAddCompany.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		gbc_btnAddCompany.anchor = GridBagConstraints.EAST;
		gbc_btnAddCompany.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddCompany.gridx = 2;
		gbc_btnAddCompany.gridy = 3;
		getContentPane().add(btnAddCompany, gbc_btnAddCompany);

		btnAddCompany.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				company.setCompanyCode(tfCompanyCode.getText());
				company.setCompanyTitle(tfCompanyName.getText());

				try {
					CompanyManager companyManager = new CompanyManager();
					companyManager.add(company);
					String[] companyData = { company.getCompanyCode(), company.getCompanyTitle() };
					companyTableModel.addRow(companyData);
					companies.add(company);
					getFeedbackDialog("Baþarýlý", "Þirket baþarýyla kaydedildi.");
					
				} catch (Exception e2) {
					System.out.println("HATA! Þirket kaydedilemedi " + e.toString());
					getFeedbackDialog("Hata", "Þirket kaydedilemedi.");
				}
				
				dispose();

			}
		});

	}

	/**
	 * @wbp.parser.constructor
	 */
	public CompanyDialog(Component component, DefaultTableModel companyTableModel, List<Company> companies,
			Company company, int row) {
		setBounds(500, 200, 389, 161);
		setTitle("Þirket Güncelle");
		setResizable(false);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 77, 195, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblcompanyCode = new JLabel("Kod");
		GridBagConstraints gbc_lblcompanyCode = new GridBagConstraints();
		gbc_lblcompanyCode.anchor = GridBagConstraints.WEST;
		gbc_lblcompanyCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblcompanyCode.gridx = 1;
		gbc_lblcompanyCode.gridy = 1;
		getContentPane().add(lblcompanyCode, gbc_lblcompanyCode);

		tfCompanyCode = new JTextField();
		GridBagConstraints gbc_tfCompanyCode = new GridBagConstraints();
		gbc_tfCompanyCode.insets = new Insets(0, 0, 5, 5);
		gbc_tfCompanyCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCompanyCode.gridx = 2;
		gbc_tfCompanyCode.gridy = 1;
		getContentPane().add(tfCompanyCode, gbc_tfCompanyCode);
		tfCompanyCode.setColumns(10);

		JLabel lblCompanyName = new JLabel("\u015Eirket Ad\u0131");
		GridBagConstraints gbc_lblCompanyName = new GridBagConstraints();
		gbc_lblCompanyName.anchor = GridBagConstraints.WEST;
		gbc_lblCompanyName.insets = new Insets(0, 0, 5, 5);
		gbc_lblCompanyName.gridx = 1;
		gbc_lblCompanyName.gridy = 2;
		getContentPane().add(lblCompanyName, gbc_lblCompanyName);

		tfCompanyName = new JTextField();
		GridBagConstraints gbc_tfCompanyName = new GridBagConstraints();
		gbc_tfCompanyName.insets = new Insets(0, 0, 5, 5);
		gbc_tfCompanyName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCompanyName.gridx = 2;
		gbc_tfCompanyName.gridy = 2;
		getContentPane().add(tfCompanyName, gbc_tfCompanyName);
		tfCompanyName.setColumns(10);

		JButton btnUpdateCompany = new JButton("Güncelle");
		btnUpdateCompany.setBackground(new Color(0, 123, 255));
		btnUpdateCompany.setForeground(new Color(255, 255, 255));
		btnUpdateCompany.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		GridBagConstraints gbc_btnUpdateCompany = new GridBagConstraints();
		gbc_btnUpdateCompany.anchor = GridBagConstraints.EAST;
		gbc_btnUpdateCompany.insets = new Insets(0, 0, 0, 5);
		gbc_btnUpdateCompany.gridx = 2;
		gbc_btnUpdateCompany.gridy = 3;
		getContentPane().add(btnUpdateCompany, gbc_btnUpdateCompany);

		tfCompanyCode.setText(company.getCompanyCode());
		tfCompanyName.setText(company.getCompanyTitle());

		btnUpdateCompany.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				company.setCompanyCode(tfCompanyCode.getText());
				company.setCompanyTitle(tfCompanyName.getText());

				CompanyManager companyManager = new CompanyManager();
				boolean isUpdate = companyManager.update(company);

				String[] companyData = { company.getCompanyCode(), company.getCompanyTitle() };
				companyTableModel.setValueAt(companyData[0], row, 0);
				companyTableModel.setValueAt(companyData[1], row, 1);

				if (isUpdate) {
					getFeedbackDialog("Baþarýlý", "Þirket baþarýyla güncellendi.");
				} else {
					getFeedbackDialog("Hata", "Þirket güncellenemedi.");
				}
				dispose();

			}
		});
	}

	public void getFeedbackDialog(String title, String label) {
		FeedbackDialog feedbackDialog = new FeedbackDialog(title, label);
		feedbackDialog.setLocationRelativeTo(this);
		feedbackDialog.setName("Feedback Dialog");
		feedbackDialog.setVisible(true);
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
