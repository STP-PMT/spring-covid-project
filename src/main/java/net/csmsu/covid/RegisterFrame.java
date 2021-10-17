package net.csmsu.covid;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;

import net.csmsu.covid.entity.Student;
import net.csmsu.covid.service.ServiceStudent;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

@Component
public class RegisterFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfSid;
	private JTextField tfFirstname;
	private JTextField tfLastname;
	private JTextField tfMobile;
	private JTextField tfEmail;

@Autowired ServiceStudent sevice;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public RegisterFrame() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setTitle("ลงทะเบียนต้องการวัคซีน");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("รหัสนิสิต");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(50, 77, 46, 14);
		contentPane.add(lblNewLabel);
		
		tfSid = new JTextField();
		tfSid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Sid = Integer.parseInt(tfSid.getText());
				System.err.println(sevice);
				if(Sid != 0) {
					List<Student> students = sevice.getStudentById(Sid);
					for(Student s : students) {
						tfFirstname.setText(s.getFirstname());
						tfLastname.setText(s.getLastname());
						tfMobile.setText(s.getMobile());
						tfEmail.setText(s.getEmail());
					}
				}
			}
		});
		tfSid.setBounds(106, 77, 138, 20);
		contentPane.add(tfSid);
		tfSid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ชื่อ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(50, 105, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("นามสกุล");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(50, 130, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("เบอร์โทร");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2.setBounds(50, 158, 46, 14);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("อีเมล");
		lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2_1.setBounds(50, 183, 46, 14);
		contentPane.add(lblNewLabel_1_1_2_1);
		
		tfFirstname = new JTextField();
		tfFirstname.setColumns(10);
		tfFirstname.setBounds(106, 102, 138, 20);
		contentPane.add(tfFirstname);
		
		tfLastname = new JTextField();
		tfLastname.setColumns(10);
		tfLastname.setBounds(106, 127, 138, 20);
		contentPane.add(tfLastname);
		
		tfMobile = new JTextField();
		tfMobile.setColumns(10);
		tfMobile.setBounds(106, 155, 138, 20);
		contentPane.add(tfMobile);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(106, 180, 138, 20);
		contentPane.add(tfEmail);
		
		JButton btnNewButton = new JButton("ยืนยัน");
		btnNewButton.setBounds(86, 327, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ยกเลิก");
		btnNewButton_1.setBounds(185, 327, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("วันที่ลงทะเบียน");
		lblNewLabel_1_1_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2_1_1.setBounds(27, 208, 69, 14);
		contentPane.add(lblNewLabel_1_1_2_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("ลงทะเบียนต้องการวัคซีน");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(50, 11, 186, 23);
		contentPane.add(lblNewLabel_2);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(106, 208, 138, 20);
		contentPane.add(dateChooser);
	}
}
