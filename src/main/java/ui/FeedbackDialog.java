package ui;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class FeedbackDialog extends JDialog {
	
	public FeedbackDialog(String title, String label){
		setBounds(500, 200, 389, 137);
		setTitle(title);
		getContentPane().setLayout(null);
		setResizable(false);
		
		//Label
		JLabel lblFeedback = new JLabel("New label");
		lblFeedback.setBounds(25, 23, 338, 14);
		getContentPane().add(lblFeedback);
		
		lblFeedback.setText(label);
		
		//Button
		JButton btnFeedback = new JButton("Kapat");
		btnFeedback.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		btnFeedback.setForeground(new Color(255, 255, 255));
		btnFeedback.setBackground(new Color(108, 117, 125));
		btnFeedback.setBounds(265, 64, 98, 23);
		btnFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		getContentPane().add(btnFeedback);
	}

}
