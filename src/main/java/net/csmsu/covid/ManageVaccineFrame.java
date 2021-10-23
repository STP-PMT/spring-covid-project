package net.csmsu.covid;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;

import net.csmsu.covid.entity.Register;
import net.csmsu.covid.entity.Vaccine;
import net.csmsu.covid.service.ServiceRegister;
import net.csmsu.covid.service.ServiceVaccine;

import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class ManageVaccineFrame extends JFrame {

	private JPanel contentPane;
	private JButton btnDose1;
	private JButton btnDose2;
	private JButton btnDose3;
	private JLabel label_sid;
	private JLabel label_firstname;
	private JLabel label_lastname;
	private JLabel label_mobile;
	
	private int rid;
	
	@Autowired
	ServiceRegister service_register;
	@Autowired
	ServiceVaccine service_vaccine;
	private JLabel label_dateRegister;
	private JLabel label_vaccine1;
	private JLabel label_vaccine2;
	private JLabel label_vaccine3;

	public ManageVaccineFrame(ServiceRegister service_register, ServiceVaccine service_vaccine) {
		this();
		this.service_register = service_register;
		this.service_vaccine = service_vaccine;
	}
	
	public ManageVaccineFrame() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				Register register = service_register.getRegisterByRid(rid);
				label_sid.setText(register.getTbStudent().getSid() + "");
				label_firstname.setText(register.getTbStudent().getFirstname());
				label_lastname.setText(register.getTbStudent().getLastname());
				label_mobile.setText(register.getTbStudent().getMobile());
				label_dateRegister.setText(register.getDate() + "");
				load(register);
			}
		});
		setTitle("จัดการข้อมูลวัคซีน");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Documents\\Data_warehouse\\Covid vaccination project for students\\covid-project\\src\\asssets\\imgaes\\icon.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 578, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_title = new JLabel("จัดการข้อมูลวัคซีน");
		label_title.setHorizontalAlignment(SwingConstants.CENTER);
		label_title.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_title.setBounds(186, 11, 175, 26);
		contentPane.add(label_title);
		
		JLabel lblNewLabel = new JLabel("รหัสนิสิต");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(42, 57, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ชื่อ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(42, 85, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("นามสกุล");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(42, 110, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("เบอร์โทร");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2.setBounds(42, 138, 46, 14);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel textField_dateRegister_1 = new JLabel("วันที่ลงทะเบียน");
		textField_dateRegister_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_dateRegister_1.setBounds(10, 163, 78, 14);
		contentPane.add(textField_dateRegister_1);
		
		label_dateRegister = new JLabel("");
		label_dateRegister.setBounds(98, 163, 157, 14);
		contentPane.add(label_dateRegister);
		
		JButton btnNewButton = new JButton("ตกลง");
		btnNewButton.setBackground(new Color(50, 205, 50));
		btnNewButton.setBounds(455, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		label_sid = new JLabel("");
		label_sid.setBounds(98, 57, 157, 14);
		contentPane.add(label_sid);
		
		label_firstname = new JLabel("");
		label_firstname.setBounds(98, 85, 157, 14);
		contentPane.add(label_firstname);
		
		label_lastname = new JLabel("");
		label_lastname.setBounds(98, 110, 157, 14);
		contentPane.add(label_lastname);
		
		label_mobile = new JLabel("");
		label_mobile.setBounds(98, 138, 157, 14);
		contentPane.add(label_mobile);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(265, 44, 291, 138);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnDose3 = new JButton("ลบ");
		btnDose3.setBounds(228, 61, 49, 20);
		panel.add(btnDose3);
		btnDose3.setBackground(Color.RED);
		
		btnDose2 = new JButton("ลบ");
		btnDose2.setBounds(228, 36, 49, 20);
		panel.add(btnDose2);
		btnDose2.setBackground(Color.RED);
		
		btnDose1 = new JButton("ลบ");
		btnDose1.setBounds(228, 11, 49, 20);
		panel.add(btnDose1);
		btnDose1.setBackground(Color.RED);
		
		label_vaccine1 = new JLabel("-");
		label_vaccine1.setBounds(66, 14, 157, 14);
		panel.add(label_vaccine1);
		
		JLabel textField_dateRegister_1_1 = new JLabel("เข็มที่ 1");
		textField_dateRegister_1_1.setBounds(10, 14, 46, 14);
		panel.add(textField_dateRegister_1_1);
		textField_dateRegister_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel textField_dateRegister_1_1_1 = new JLabel("เข็มที่ 2");
		textField_dateRegister_1_1_1.setBounds(10, 39, 46, 14);
		panel.add(textField_dateRegister_1_1_1);
		textField_dateRegister_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		 label_vaccine2 = new JLabel("-");
		label_vaccine2.setBounds(66, 39, 157, 14);
		panel.add(label_vaccine2);
		
		JLabel textField_dateRegister_1_1_2 = new JLabel("เข็มที่ 3");
		textField_dateRegister_1_1_2.setBounds(20, 67, 36, 14);
		panel.add(textField_dateRegister_1_1_2);
		textField_dateRegister_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		label_vaccine3 = new JLabel("-");
		label_vaccine3.setBounds(66, 67, 157, 14);
		panel.add(label_vaccine3);
		btnDose2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	
	private void load(Register register) {
		if(register.getTbVaccine1() != null) {
			label_vaccine1.setText(register.getTbVaccine1().getTbVaccine().getName());
		}else {
			btnDose1.setVisible(false);
		}
		
		if(register.getTbVaccine2() != null) {
			label_vaccine2.setText(register.getTbVaccine2().getTbVaccine().getName());
		}else {
			btnDose2.setVisible(false);
		}
		
		if(register.getTbVaccine3() != null) {
			label_vaccine3.setText(register.getTbVaccine3().getTbVaccine().getName());
		}else {
			btnDose3.setVisible(false);
		}
	}
	
}
