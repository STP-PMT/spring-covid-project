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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import net.csmsu.covid.entity.Register;
import net.csmsu.covid.entity.Vaccine;
import net.csmsu.covid.entity.Vaccine1;
import net.csmsu.covid.service.ServiceRegister;
import net.csmsu.covid.service.ServiceVaccine;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
@Component
public class VaccineFrame extends JFrame {

	private JPanel contentPane;
	private JTextField Sid;
	private JTextField Mobile;
	private JTextField Lastname;
	private JTextField Firstname;
	private JDateChooser date_vaccine1;
	private JLabel label_dateRegister;
	
	private Hashtable<Integer, String> vaccineMap =  new Hashtable<Integer, String>();
	private JLabel label_date;
	private JLabel label_vaccine1;
	private JLabel label_vaccine2;
	private JLabel label_vaccine3;
	private JPanel panel_card;
	private JComboBox<String> combo_vaccine1;
	private JComboBox<String> combo_vaccine2;
	
	
	
	@Autowired ServiceRegister service_register;
	@Autowired ServiceVaccine service_vaccine;
	private int rid=-1;
	private int vaccineTable = -1;
	
	public int getVaccineTable() {
		return vaccineTable;
	}
	public void setVaccineTable(int vaccineTable) {
		this.vaccineTable = vaccineTable;
	}
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
	
	public Date setDateVaccine(Date date,int num) {
		LocalDate localdate = LocalDate.parse(date+"");
		LocalDate value = localdate.plusDays(num);
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date datevalue = Date.from(value.atStartOfDay(defaultZoneId).toInstant());
		return datevalue;
	}
	
	public VaccineFrame() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				List<Vaccine> vaccines = service_vaccine.getAllVaccine();
				Register register = service_register.getRegisterByRid(rid);
				Sid.setText(register.getTbStudent().getSid()+"");
				Firstname.setText(register.getTbStudent().getFirstname());
				Lastname.setText(register.getTbStudent().getLastname());
				Mobile.setText(register.getTbStudent().getMobile());
				label_dateRegister.setText(register.getDate()+"");
				
				if(rid!=-1 && vaccineTable ==1) {
					for(Vaccine v : vaccines) {
						vaccineMap.put(v.getVid(),v.getName());
						combo_vaccine1.addItem(v.getName());
					}
					Date dateMin = setDateVaccine(register.getDate(),7);
					Date dateMax = setDateVaccine(register.getDate(),14);
					date_vaccine1.setMinSelectableDate(dateMin);
					date_vaccine1.setMaxSelectableDate(dateMax);
					
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
					label_date.setText(format.format(dateMin)+" - "+format.format(dateMax));
				}
				if(rid!=-1 && vaccineTable ==2) {
					CardLayout cl = (CardLayout) panel_card.getLayout();
					cl.show(panel_card, "vaccine2");
					for(Vaccine v : vaccines) {
						vaccineMap.put(v.getVid(),v.getName());
						combo_vaccine2.addItem(v.getName());
					}
					Date dateMin = setDateVaccine(register.getDate(),7);
					Date dateMax = setDateVaccine(register.getDate(),14);
					date_vaccine1.setMinSelectableDate(dateMin);
					date_vaccine1.setMaxSelectableDate(dateMax);
					label_vaccine1.setText(register.getTbVaccine1().getTbVaccine().getName());
					
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
					label_date.setText(format.format(dateMin)+" - "+format.format(dateMax));
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
		setBounds(100, 100, 566, 345);
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
		
		JButton btnNewButton = new JButton("ยืนยัน");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(date_vaccine1.getDate()!=null) {
					Vaccine1 v1 = new Vaccine1();
					Register register = service_register.getRegisterByRid(rid);
					Vaccine vaccine_type = service_vaccine.getVaccineById(1);
					String strdate = setFormatDate(date_vaccine1);
					
					v1.setTbRegister(register);
					v1.setTbVaccine(vaccine_type);
					v1.setDate(java.sql.Date.valueOf(strdate));
					
					if(service_vaccine.updateVaccine1(v1)!=null) {
						Vaccine1 v = service_vaccine.getVaccine1ByRid(rid);
						register.setTbVaccine1(v);
						if(service_register.updateRegister(register)!=null) {
							JOptionPane.showMessageDialog(null,"ลงทะเบียน สำเร็จ");
						}else {
							JOptionPane.showMessageDialog(null,"ลงทะเบียน ไม่สำเร็จ!");
						}
					}else {
						JOptionPane.showMessageDialog(null,"ลงทะเบียน ไม่สำเร็จ!");
					}
				}else {
					JOptionPane.showMessageDialog(null,"โปรดระบุวันที่!");
				}
				rid = -1;
			}
		});
		btnNewButton.setBounds(345, 272, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ยกเลิก");
		btnNewButton_1.setBounds(445, 272, 89, 23);
		contentPane.add(btnNewButton_1);
		
		label_dateRegister = new JLabel("");
		label_dateRegister.setBounds(98, 157, 157, 14);
		contentPane.add(label_dateRegister);
		
		JLabel textField_dateRegister_1 = new JLabel("วันที่ลงทะเบียน");
		textField_dateRegister_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_dateRegister_1.setBounds(10, 157, 78, 14);
		contentPane.add(textField_dateRegister_1);
		
		JLabel textField_dateRegister_1_1 = new JLabel("เข็มที่ 1");
		textField_dateRegister_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_dateRegister_1_1.setBounds(10, 182, 78, 14);
		contentPane.add(textField_dateRegister_1_1);
		
		JLabel textField_dateRegister_1_1_1 = new JLabel("เข็มที่ 2");
		textField_dateRegister_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_dateRegister_1_1_1.setBounds(10, 207, 78, 14);
		contentPane.add(textField_dateRegister_1_1_1);
		
		JLabel textField_dateRegister_1_1_2 = new JLabel("เข็มที่ 3");
		textField_dateRegister_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_dateRegister_1_1_2.setBounds(10, 232, 78, 14);
		contentPane.add(textField_dateRegister_1_1_2);
		
		label_vaccine1 = new JLabel("-");
		label_vaccine1.setBounds(98, 182, 157, 14);
		contentPane.add(label_vaccine1);
		
		label_vaccine2 = new JLabel("-");
		label_vaccine2.setBounds(98, 207, 157, 14);
		contentPane.add(label_vaccine2);
		
		label_vaccine3 = new JLabel("-");
		label_vaccine3.setBounds(98, 232, 157, 14);
		contentPane.add(label_vaccine3);
		
		panel_card = new JPanel();
		panel_card.setBounds(265, 48, 256, 198);
		contentPane.add(panel_card);
		panel_card.setLayout(new CardLayout(0, 0));
		
		JPanel panel_vaccine1 = new JPanel();
		panel_card.add(panel_vaccine1, "vaccine1");
		panel_vaccine1.setBackground(new Color(127, 255, 212));
		panel_vaccine1.setLayout(null);
		
		date_vaccine1 = new JDateChooser();
		date_vaccine1.setBounds(82, 97, 157, 20);
		panel_vaccine1.add(date_vaccine1);
		
		label_date = new JLabel("null");
		label_date.setBounds(82, 69, 157, 14);
		panel_vaccine1.add(label_date);
		label_date.setForeground(Color.RED);
		label_date.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_3 = new JLabel("เลือกวันฉีดตั้งแต่วันที่ ");
		lblNewLabel_3.setBounds(106, 44, 106, 14);
		panel_vaccine1.add(lblNewLabel_3);
		
		combo_vaccine1 = new JComboBox<String>();
		combo_vaccine1.setBounds(82, 11, 157, 22);
		panel_vaccine1.add(combo_vaccine1);
		combo_vaccine1.setEnabled(false);
		
		JLabel lblNewLabel_2 = new JLabel("วัคซีนเข็มที่ 1");
		lblNewLabel_2.setBounds(10, 15, 62, 14);
		panel_vaccine1.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JPanel panel_vaccine2 = new JPanel();
		panel_vaccine2.setBackground(new Color(127, 255, 212));
		panel_card.add(panel_vaccine2, "vaccine2");
		panel_vaccine2.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("วัคซีนเข็มที่ 2");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setBounds(10, 15, 62, 14);
		panel_vaccine2.add(lblNewLabel_2_1);
		
		combo_vaccine2 = new JComboBox<String>();
		combo_vaccine2.setBounds(82, 11, 157, 22);
		panel_vaccine2.add(combo_vaccine2);
		
		JLabel lblNewLabel_3_1 = new JLabel("วันฉีดเข็มที่ 2");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setBounds(106, 44, 106, 14);
		panel_vaccine2.add(lblNewLabel_3_1);
		
		JLabel label_dateVaccine2 = new JLabel("null");
		label_dateVaccine2.setHorizontalAlignment(SwingConstants.CENTER);
		label_dateVaccine2.setForeground(Color.RED);
		label_dateVaccine2.setBounds(82, 69, 157, 14);
		panel_vaccine2.add(label_dateVaccine2);
		
		JPanel panel_vaccine3 = new JPanel();
		panel_vaccine3.setBackground(new Color(127, 255, 212));
		panel_card.add(panel_vaccine3, "vaccine3");
		panel_vaccine3.setLayout(null);
		
		JLabel label_dateVaccine3 = new JLabel("null");
		label_dateVaccine3.setHorizontalAlignment(SwingConstants.CENTER);
		label_dateVaccine3.setForeground(Color.RED);
		label_dateVaccine3.setBounds(82, 69, 157, 14);
		panel_vaccine3.add(label_dateVaccine3);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("วันฉีดเข็มที่ 3");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setBounds(106, 44, 106, 14);
		panel_vaccine3.add(lblNewLabel_3_1_1);
		
		JComboBox<String> combo_vaccine_1_1 = new JComboBox<String>();
		combo_vaccine_1_1.setEnabled(false);
		combo_vaccine_1_1.setBounds(82, 11, 157, 22);
		panel_vaccine3.add(combo_vaccine_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("วัคซีนเข็มที่ 3");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_1.setBounds(10, 15, 62, 14);
		panel_vaccine3.add(lblNewLabel_2_1_1);
		
		JLabel label_title = new JLabel("ลงทะเบียนวัคซีน");
		label_title.setHorizontalAlignment(SwingConstants.CENTER);
		label_title.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_title.setBounds(194, 11, 175, 26);
		contentPane.add(label_title);
	}
	
	String setFormatDate(JDateChooser date) {
		Date d = date.getDate();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
		return dateFormat.format(d);	
	}
}
