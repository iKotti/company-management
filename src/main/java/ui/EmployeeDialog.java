package ui;

import javax.swing.JDialog;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Business.concretes.EmployeeManager;
import Entity.Employee;
import Entity.Section;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class EmployeeDialog extends JDialog {
	private JTextField tfRegistrationNumber;
	private JTextField tfEmployeeName;

	public EmployeeDialog(Section section) {
		setBounds(500, 200, 389, 161);
		setTitle("Çalýþan Ekle");
		setResizable(false);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 77, 195, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblRegistrationNumber = new JLabel("Sicil No");
		GridBagConstraints gbc_lblRegistrationNumber = new GridBagConstraints();
		gbc_lblRegistrationNumber.anchor = GridBagConstraints.WEST;
		gbc_lblRegistrationNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegistrationNumber.gridx = 1;
		gbc_lblRegistrationNumber.gridy = 1;
		getContentPane().add(lblRegistrationNumber, gbc_lblRegistrationNumber);

		tfRegistrationNumber = new JTextField();
		GridBagConstraints gbc_tfRegistrationNumber = new GridBagConstraints();
		gbc_tfRegistrationNumber.gridwidth = 3;
		gbc_tfRegistrationNumber.insets = new Insets(0, 0, 5, 5);
		gbc_tfRegistrationNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfRegistrationNumber.gridx = 2;
		gbc_tfRegistrationNumber.gridy = 1;
		getContentPane().add(tfRegistrationNumber, gbc_tfRegistrationNumber);
		tfRegistrationNumber.setColumns(10);

		JLabel lblEmployeeName = new JLabel("\u00C7al\u0131\u015Fan Ad\u0131");
		GridBagConstraints gbc_lblEmployeeName = new GridBagConstraints();
		gbc_lblEmployeeName.anchor = GridBagConstraints.WEST;
		gbc_lblEmployeeName.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmployeeName.gridx = 1;
		gbc_lblEmployeeName.gridy = 2;
		getContentPane().add(lblEmployeeName, gbc_lblEmployeeName);

		tfEmployeeName = new JTextField();
		GridBagConstraints gbc_tfEmployeeName = new GridBagConstraints();
		gbc_tfEmployeeName.gridwidth = 3;
		gbc_tfEmployeeName.insets = new Insets(0, 0, 5, 5);
		gbc_tfEmployeeName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfEmployeeName.gridx = 2;
		gbc_tfEmployeeName.gridy = 2;
		getContentPane().add(tfEmployeeName, gbc_tfEmployeeName);
		tfEmployeeName.setColumns(10);

		JButton btnAddEmployee = new JButton("Ekle");
		btnAddEmployee.setForeground(new Color(255, 255, 255));
		btnAddEmployee.setBackground(new Color(40, 167, 69));
		btnAddEmployee.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					EmployeeManager employeeManager = new EmployeeManager();

					Employee employee = new Employee();
					employee.setRegistrationNumber(tfRegistrationNumber.getText());
					employee.setEmployeeName(tfEmployeeName.getText());
					employee.setSectionId(section.getSectionId());
					employeeManager.add(employee);
					getFeedbackDialog("Baþarýlý", "Çalýþan baþarýyla kaydedildi.");

				} catch (Exception e) {
					System.out.println("HATA! Çalýþan kaydedilemedi " + e.toString());
					getFeedbackDialog("Hata", "Çalýþan kaydedilemedi.");
				}

				dispose();
			}
		});
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 4;
		gbc_btnSave.gridy = 3;
		getContentPane().add(btnAddEmployee, gbc_btnSave);

	}

	/**
	 * @wbp.parser.constructor
	 */
	public EmployeeDialog(Component component, DefaultTableModel employeeTableModel, List<Employee> employees,
			Employee employee, int row) {
		setBounds(500, 200, 389, 161);
		setTitle("Çalýþan Güncelle");
		setResizable(false);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 77, 195, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblRegistrationNumber = new JLabel("Sicil No");
		GridBagConstraints gbc_lblRegistrationNumber = new GridBagConstraints();
		gbc_lblRegistrationNumber.anchor = GridBagConstraints.WEST;
		gbc_lblRegistrationNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegistrationNumber.gridx = 1;
		gbc_lblRegistrationNumber.gridy = 1;
		getContentPane().add(lblRegistrationNumber, gbc_lblRegistrationNumber);

		tfRegistrationNumber = new JTextField();
		GridBagConstraints gbc_tfRegistrationNumber = new GridBagConstraints();
		gbc_tfRegistrationNumber.gridwidth = 3;
		gbc_tfRegistrationNumber.insets = new Insets(0, 0, 5, 5);
		gbc_tfRegistrationNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfRegistrationNumber.gridx = 2;
		gbc_tfRegistrationNumber.gridy = 1;
		getContentPane().add(tfRegistrationNumber, gbc_tfRegistrationNumber);
		tfRegistrationNumber.setColumns(10);

		JLabel lblEmployeeName = new JLabel("\u00C7al\u0131\u015Fan Ad\u0131");
		GridBagConstraints gbc_lblEmployeeName = new GridBagConstraints();
		gbc_lblEmployeeName.anchor = GridBagConstraints.WEST;
		gbc_lblEmployeeName.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmployeeName.gridx = 1;
		gbc_lblEmployeeName.gridy = 2;
		getContentPane().add(lblEmployeeName, gbc_lblEmployeeName);

		tfEmployeeName = new JTextField();
		GridBagConstraints gbc_tfEmployeeName = new GridBagConstraints();
		gbc_tfEmployeeName.gridwidth = 3;
		gbc_tfEmployeeName.insets = new Insets(0, 0, 5, 5);
		gbc_tfEmployeeName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfEmployeeName.gridx = 2;
		gbc_tfEmployeeName.gridy = 2;
		getContentPane().add(tfEmployeeName, gbc_tfEmployeeName);
		tfEmployeeName.setColumns(10);

		tfRegistrationNumber.setText(employee.getRegistrationNumber());
		tfEmployeeName.setText(employee.getEmployeeName());

		JButton btnUpdateEmployee = new JButton("Güncelle");
		btnUpdateEmployee.setForeground(new Color(255, 255, 255));
		btnUpdateEmployee.setBackground(new Color(0, 123, 255));
		btnUpdateEmployee.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		btnUpdateEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmployeeManager employeeManager = new EmployeeManager();

				employee.setRegistrationNumber(tfRegistrationNumber.getText());
				employee.setEmployeeName(tfEmployeeName.getText());

				boolean isUpdate = employeeManager.update(employee);

				String[] employeeData = { employee.getRegistrationNumber(), employee.getEmployeeName() };
				employeeTableModel.setValueAt(employeeData[0], row, 0);
				employeeTableModel.setValueAt(employeeData[1], row, 1);

				if (isUpdate) {
					getFeedbackDialog("Baþarýlý", "Çalýþan baþarýyla güncellendi.");
				} else {
					getFeedbackDialog("Hata", "Çalýþan güncellenemedi.");
				}

				dispose();
			}
		});
		GridBagConstraints gbc_btnUpdateEmployee = new GridBagConstraints();
		gbc_btnUpdateEmployee.insets = new Insets(0, 0, 5, 5);
		gbc_btnUpdateEmployee.gridx = 4;
		gbc_btnUpdateEmployee.gridy = 3;
		getContentPane().add(btnUpdateEmployee, gbc_btnUpdateEmployee);

	}

	public void getFeedbackDialog(String title, String label) {
		FeedbackDialog feedbackDialog = new FeedbackDialog(title, label);
		feedbackDialog.setLocationRelativeTo(this);
		feedbackDialog.setName("Feedback Dialog");
		feedbackDialog.setVisible(true);
	}
}
