package ui;

import javax.swing.JDialog;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Business.concretes.SectionManager;
import Entity.Company;
import Entity.Section;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class SectionDialog extends JDialog {

	private JTextField tfSectionCode;
	private JTextField tfSectionName;

	public SectionDialog(Company company) {
		setBounds(500, 200, 389, 197);
		setTitle("Bölüm Ekle");
		setResizable(false);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 74, 20, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 21, 0, 0, 0, 0, 13, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblSectionCode = new JLabel("B\u00F6l\u00FCm Kodu");
		GridBagConstraints gbc_lblSectionCode = new GridBagConstraints();
		gbc_lblSectionCode.anchor = GridBagConstraints.WEST;
		gbc_lblSectionCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblSectionCode.gridx = 1;
		gbc_lblSectionCode.gridy = 1;
		getContentPane().add(lblSectionCode, gbc_lblSectionCode);

		tfSectionCode = new JTextField();
		GridBagConstraints gbc_tfSectionCode = new GridBagConstraints();
		gbc_tfSectionCode.insets = new Insets(0, 0, 5, 5);
		gbc_tfSectionCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfSectionCode.gridx = 2;
		gbc_tfSectionCode.gridy = 1;
		getContentPane().add(tfSectionCode, gbc_tfSectionCode);
		tfSectionCode.setColumns(10);

		JLabel lblSectionName = new JLabel("B\u00F6l\u00FCm Ad\u0131");
		GridBagConstraints gbc_lblSectionName = new GridBagConstraints();
		gbc_lblSectionName.anchor = GridBagConstraints.WEST;
		gbc_lblSectionName.insets = new Insets(0, 0, 5, 5);
		gbc_lblSectionName.gridx = 1;
		gbc_lblSectionName.gridy = 2;
		getContentPane().add(lblSectionName, gbc_lblSectionName);

		tfSectionName = new JTextField();
		GridBagConstraints gbc_tfSectionName = new GridBagConstraints();
		gbc_tfSectionName.insets = new Insets(0, 0, 5, 5);
		gbc_tfSectionName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfSectionName.gridx = 2;
		gbc_tfSectionName.gridy = 2;
		getContentPane().add(tfSectionName, gbc_tfSectionName);
		tfSectionName.setColumns(10);

		JButton btnAddSection = new JButton("Ekle");
		btnAddSection.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		btnAddSection.setForeground(new Color(255, 255, 255));
		btnAddSection.setBackground(new Color(40, 167, 69));
		btnAddSection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SectionManager sectionManager = new SectionManager();
					Section section = new Section();
					section.setSectionCode(tfSectionCode.getText());
					section.setSectionName(tfSectionName.getText());
					section.setCompanyId(company.getCompanyId());
					sectionManager.add(section);
					getFeedbackDialog("Baþarýlý", "Bölüm baþarýyla kaydedildi.");
				} catch (Exception e2) {

					getFeedbackDialog("Hata", "Bölüm kaydedilemedi.");
				}

				dispose();
			}
		});
		GridBagConstraints gbc_btnAddSection = new GridBagConstraints();
		gbc_btnAddSection.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddSection.gridx = 2;
		gbc_btnAddSection.gridy = 4;
		getContentPane().add(btnAddSection, gbc_btnAddSection);
	}

	/**
	 * @wbp.parser.constructor
	 */
	public SectionDialog(Component component, DefaultTableModel sectionTableModel, List<Section> sections,
			Section section, int row) {
		setBounds(500, 200, 389, 197);
		setTitle("Bölüm Güncelle");
		setResizable(false);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 74, 20, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 21, 0, 0, 0, 0, 13, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblSectionCode = new JLabel("B\u00F6l\u00FCm Kodu");
		GridBagConstraints gbc_lblSectionCode = new GridBagConstraints();
		gbc_lblSectionCode.anchor = GridBagConstraints.WEST;
		gbc_lblSectionCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblSectionCode.gridx = 1;
		gbc_lblSectionCode.gridy = 1;
		getContentPane().add(lblSectionCode, gbc_lblSectionCode);

		tfSectionCode = new JTextField();
		GridBagConstraints gbc_tfSectionCode = new GridBagConstraints();
		gbc_tfSectionCode.insets = new Insets(0, 0, 5, 5);
		gbc_tfSectionCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfSectionCode.gridx = 2;
		gbc_tfSectionCode.gridy = 1;
		getContentPane().add(tfSectionCode, gbc_tfSectionCode);
		tfSectionCode.setColumns(10);

		JLabel lblSectionName = new JLabel("B\u00F6l\u00FCm Ad\u0131");
		GridBagConstraints gbc_lblSectionName = new GridBagConstraints();
		gbc_lblSectionName.anchor = GridBagConstraints.WEST;
		gbc_lblSectionName.insets = new Insets(0, 0, 5, 5);
		gbc_lblSectionName.gridx = 1;
		gbc_lblSectionName.gridy = 2;
		getContentPane().add(lblSectionName, gbc_lblSectionName);

		tfSectionName = new JTextField();
		GridBagConstraints gbc_tfSectionName = new GridBagConstraints();
		gbc_tfSectionName.insets = new Insets(0, 0, 5, 5);
		gbc_tfSectionName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfSectionName.gridx = 2;
		gbc_tfSectionName.gridy = 2;
		getContentPane().add(tfSectionName, gbc_tfSectionName);
		tfSectionName.setColumns(10);
		GridBagConstraints gbc_btnUpdateSection = new GridBagConstraints();
		gbc_btnUpdateSection.anchor = GridBagConstraints.EAST;
		gbc_btnUpdateSection.insets = new Insets(0, 0, 5, 5);
		gbc_btnUpdateSection.gridx = 2;
		gbc_btnUpdateSection.gridy = 4;

		tfSectionCode.setText(section.getSectionCode());
		tfSectionName.setText(section.getSectionName());

		JButton btnUpdateSection = new JButton("G\u00FCncelle");
		btnUpdateSection.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		btnUpdateSection.setForeground(new Color(255, 255, 255));
		btnUpdateSection.setBackground(new Color(0, 123, 255));
		btnUpdateSection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				section.setSectionCode(tfSectionCode.getText());
				section.setSectionName(tfSectionName.getText());

//				String selectedCompany = cbSectionCompanies.getSelectedItem().toString();
//				
//				for(Company c:companies) {
//					if (c.getCompanyTitle().equals(selectedCompany)) {
//						section.setCompanyId(c.getCompanyId());
//						return;
//					}
//					else {
//						System.out.println("Þirket güncellenemedi");
//					}
//				}

				SectionManager sectionManager = new SectionManager();
				boolean isUpdate = sectionManager.update(section);

				String[] sectionData = { section.getSectionCode(), section.getSectionName() };
				sectionTableModel.setValueAt(sectionData[0], row, 0);
				sectionTableModel.setValueAt(sectionData[1], row, 1);

				if (isUpdate) {
					getFeedbackDialog("Baþarýlý", "Bölüm baþarýyla güncellendi.");
				} else {
					getFeedbackDialog("Hata", "Bölüm güncellenemedi.");
				}

				dispose();
			}
		});
		getContentPane().add(btnUpdateSection, gbc_btnUpdateSection);

	}

	public void getFeedbackDialog(String title, String label) {
		FeedbackDialog feedbackDialog = new FeedbackDialog(title, label);
		feedbackDialog.setLocationRelativeTo(this);
		feedbackDialog.setName("Feedback Dialog");
		feedbackDialog.setVisible(true);
	}
}
