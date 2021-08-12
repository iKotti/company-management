package ui;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import Business.concretes.CompanyManager;
import Business.concretes.EmployeeManager;
import Business.concretes.SectionManager;
import Entity.Company;
import Entity.Employee;
import Entity.Section;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class AreYouSureDialog extends JDialog {

	public AreYouSureDialog(Company company, DefaultTableModel companyTableModel, List<Company> companies,
			int selectedRow) {
		setBounds(500, 200, 425, 154);
		setTitle("Emin misiniz?");
		getContentPane().setLayout(null);
		setResizable(false);

		JLabel lblConfirm = new JLabel("Silmek istedi\u011Finize emin misiniz ? Bu i\u015Flem geri al\u0131namaz.");
		lblConfirm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblConfirm.setBounds(42, 24, 337, 23);
		getContentPane().add(lblConfirm);

		JButton btnYes = new JButton("Evet");
		btnYes.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		btnYes.setForeground(new Color(255, 255, 255));
		btnYes.setBackground(new Color(40, 167, 69));
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CompanyManager companyManager = new CompanyManager();
				try {
					companyManager.delete(company);
					companyTableModel.removeRow(selectedRow);
					companies.remove(company);
					getFeedbackDialog("Baþarýlý", "Þirket baþarýyla silindi.");

				} catch (Exception e) {
					System.out.println("HATA! Þirket silinemedi. " + e.toString());
					getFeedbackDialog("Hata", "Þirket silinemedi.");
				}
				dispose();
			}
		});

		btnYes.setBounds(224, 66, 89, 23);
		getContentPane().add(btnYes);

		JButton btnNo = new JButton("Iptal");
		btnNo.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		btnNo.setForeground(new Color(255, 255, 255));
		btnNo.setBackground(new Color(108, 117, 125));
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNo.setBounds(90, 66, 89, 23);
		getContentPane().add(btnNo);
	}

	public AreYouSureDialog(Section section, DefaultTableModel sectionTableModel, List<Section> sections,
			int selectedRow) {
		setBounds(500, 200, 425, 154);
		setTitle("Emin misiniz?");
		getContentPane().setLayout(null);

		JLabel lblConfirm = new JLabel("Silmek istedi\u011Finize emin misiniz ? Bu i\u015Flem geri al\u0131namaz.");
		lblConfirm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblConfirm.setBounds(42, 24, 337, 23);
		getContentPane().add(lblConfirm);

		JButton btnYes = new JButton("Evet");
		btnYes.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		btnYes.setForeground(new Color(255, 255, 255));
		btnYes.setBackground(new Color(40, 167, 69));
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SectionManager sectionManager = new SectionManager();
				try {
					sectionManager.delete(section);
					sectionTableModel.removeRow(selectedRow);
					sections.remove(section);
					getFeedbackDialog("Baþarýlý", "Bölüm baþarýyla silindi.");

				} catch (Exception e) {
					System.out.println("HATA! Bölüm silinemedi. " + e.toString());
					getFeedbackDialog("Hata", "Bölüm silinemedi.");
				}
				dispose();
			}
		});

		btnYes.setBounds(224, 66, 89, 23);
		getContentPane().add(btnYes);

		JButton btnNo = new JButton("Iptal");
		btnNo.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		btnNo.setForeground(new Color(255, 255, 255));
		btnNo.setBackground(new Color(108, 117, 125));
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNo.setBounds(90, 66, 89, 23);
		getContentPane().add(btnNo);

	}

	public AreYouSureDialog(Employee employee, DefaultTableModel employeeTableModel, List<Employee> employees,
			int selectedRow) {
		setBounds(500, 200, 425, 154);
		setTitle("Emin misiniz?");
		getContentPane().setLayout(null);

		JLabel lblConfirm = new JLabel("Silmek istedi\u011Finize emin misiniz ? Bu i\u015Flem geri al\u0131namaz.");
		lblConfirm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblConfirm.setBounds(42, 24, 337, 23);
		getContentPane().add(lblConfirm);

		JButton btnYes = new JButton("Evet");
		btnYes.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		btnYes.setForeground(new Color(255, 255, 255));
		btnYes.setBackground(new Color(40, 167, 69));
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmployeeManager employeeManager = new EmployeeManager();
				try {
					employeeManager.delete(employee);
					employeeTableModel.removeRow(selectedRow);
					employees.remove(employee);
					getFeedbackDialog("Baþarýlý", "Çalýþan baþarýyla silindi.");

				} catch (Exception e) {
					System.out.println("HATA! Çalýþan silinemedi. " + e.toString());
					getFeedbackDialog("Hata", "Çalýþan silinemedi.");
				}
				dispose();
			}
		});

		btnYes.setBounds(224, 66, 89, 23);
		getContentPane().add(btnYes);

		JButton btnNo = new JButton("Iptal");
		btnNo.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		btnNo.setForeground(new Color(255, 255, 255));
		btnNo.setBackground(new Color(108, 117, 125));
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNo.setBounds(90, 66, 89, 23);
		getContentPane().add(btnNo);

	}

	public void getFeedbackDialog(String title, String label) {
		FeedbackDialog feedbackDialog = new FeedbackDialog(title, label);
		feedbackDialog.setLocationRelativeTo(this);
		feedbackDialog.setName("Feedback Dialog");
		feedbackDialog.setVisible(true);
	}
}
