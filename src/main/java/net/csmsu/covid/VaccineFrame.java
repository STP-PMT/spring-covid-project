package net.csmsu.covid;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import net.csmsu.covid.entity.Register;
import net.csmsu.covid.entity.Vaccine;
import net.csmsu.covid.service.ServiceRegister;
import net.csmsu.covid.service.ServiceVaccine;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Hashtable;
import java.util.List;
@Component
public class VaccineFrame extends JFrame {

	private JPanel contentPane;
	private JTextField Sid;
	private JTextField Mobile;
	private JTextField Lastname;
	private JTextField Firstname;
	private JDateChooser date_vaccine1;
	private JLabel label_dateRegister;
	private JComboBox<String> combo_vaccine;
	private Hashtable<Integer, String> vaccineMap =  new Hashtable<Integer, String>();
	
	@Autowired ServiceRegister service_register;
	@Autowired ServiceVaccine service_vaccine;
	private int rid=-1;
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public VaccineFrame(ServiceRegister service_register,ServiceVaccine service_vaccine) {
		this();
		this.service_register = service_register;
		this.service_vaccine = service_vaccine;
	}
	public VaccineFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				if(rid!=-1) {
					Register register = service_register.getRegisterByRid(rid);
					List<Vaccine> vaccines = service_vaccine.getAllVaccine();
					
					Sid.setText(register.getTbStudent().getSid()+"");
					Firstname.setText(register.getTbStudent().getFirstname());
					Lastname.setText(register.getTbStudent().getLastname());
					Mobile.setText(register.getTbStudent().getLastname());
					label_dateRegister.setText(register.getDate()+"");
					for(Vaccine v : vaccines) {
						vaccineMap.put(v.getVid(),v.getName());
						combo_vaccine.addItem(v.getName());
					}
				}
			}
		});
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
		
		Sid = new JTextField();
		Sid.setEditable(false);
		Sid.setBounds(98, 48, 157, 20);
		contentPane.add(Sid);
		Sid.setColumns(10);
		
		date_vaccine1 = new JDateChooser();
		date_vaccine1.setBounds(98, 213, 157, 20);
		contentPane.add(date_vaccine1);
		
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
		
		Mobile = new JTextField();
		Mobile.setEditable(false);
		Mobile.setColumns(10);
		Mobile.setBounds(98, 129, 157, 20);
		contentPane.add(Mobile);
		
		Lastname = new JTextField();
		Lastname.setEditable(false);
		Lastname.setColumns(10);
		Lastname.setBounds(98, 101, 157, 20);
		contentPane.add(Lastname);
		
		Firstname = new JTextField();
		Firstname.setEditable(false);
		Firstname.setColumns(10);
		Firstname.setBounds(98, 76, 157, 20);
		contentPane.add(Firstname);
		
		JLabel lblNewLabel_2 = new JLabel("วัคซีนเข็มที่ 1");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(10, 188, 78, 14);
		contentPane.add(lblNewLabel_2);
		
		combo_vaccine = new JComboBox<String>();
		combo_vaccine.setEnabled(false);
		combo_vaccine.setBounds(98, 184, 157, 22);
		contentPane.add(combo_vaccine);
		
		JButton btnNewButton = new JButton("ยืนยัน");
		btnNewButton.setBounds(122, 304, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ยกเลิก");
		btnNewButton_1.setBounds(222, 304, 89, 23);
		contentPane.add(btnNewButton_1);
		
		label_dateRegister = new JLabel("");
		label_dateRegister.setBounds(98, 160, 157, 14);
		contentPane.add(label_dateRegister);
		
		JLabel textField_dateRegister_1 = new JLabel("วันที่ลงทะเบียน");
		textField_dateRegister_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_dateRegister_1.setBounds(10, 157, 78, 14);
		contentPane.add(textField_dateRegister_1);
	}
}
