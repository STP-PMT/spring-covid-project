package net.csmsu.covid;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
@Component
public class VaccineFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public VaccineFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Documents\\Data_warehouse\\Covid vaccination project for students\\covid-project\\src\\asssets\\imgaes\\icon.png"));
		setTitle("ลงทะเบียนซีดวัคซีน");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		UIManager.put("OptionPane.messageFont", new Font("Tahoma", Font.PLAIN, 14));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 337, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("รหัสนิสิต");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(42, 51, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(98, 48, 157, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(98, 204, 157, 20);
		contentPane.add(dateChooser);
		
		JLabel lblNewLabel_1 = new JLabel("ชื่อ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(42, 79, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("นามสกุล");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(42, 104, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("เบอร์โทร");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2.setBounds(42, 132, 46, 14);
		contentPane.add(lblNewLabel_1_1_2);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(98, 129, 157, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(98, 101, 157, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(98, 76, 157, 20);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_2 = new JLabel("วัคซีนเข็มที่ 1");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(10, 179, 78, 14);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setBounds(98, 175, 157, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("ยืนยัน");
		btnNewButton.setBounds(122, 304, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ยกเลิก");
		btnNewButton_1.setBounds(222, 304, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
