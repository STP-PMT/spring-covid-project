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
	private JLabel label_date;
	private Vaccine1 vaccine1;
	
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
	
	public Date setDateVaccine(Date date,int num) {
		LocalDate localdate = LocalDate.parse(date+"");
		LocalDate value = localdate.plusDays(num);
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date datevalue = Date.from(value.atStartOfDay(defaultZoneId).toInstant());
		return datevalue;
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
					Mobile.setText(register.getTbStudent().getMobile());
					label_dateRegister.setText(register.getDate()+"");
					for(Vaccine v : vaccines) {
						vaccineMap.put(v.getVid(),v.getName());
						combo_vaccine.addItem(v.getName());
					}
					Date dateMin = setDateVaccine(register.getDate(),7);
					Date dateMax = setDateVaccine(register.getDate(),14);
					date_vaccine1.setMinSelectableDate(dateMin);
					date_vaccine1.setMaxSelectableDate(dateMax);
					
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
		setBounds(100, 100, 336, 443);
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
					v1.addTbRegister(register);
					String strdate = setFormatDate(date_vaccine1);
					v1.setDate(java.sql.Date.valueOf(strdate));
					if(service_vaccine.updateVaccine1(v1)!=null) {
						Vaccine1 v = service_vaccine.getVaccine1ByRid(rid);
						register.addTbVaccine1(v);
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
		btnNewButton.setBounds(122, 370, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ยกเลิก");
		btnNewButton_1.setBounds(222, 370, 89, 23);
		contentPane.add(btnNewButton_1);
		
		label_dateRegister = new JLabel("");
		label_dateRegister.setBounds(98, 160, 157, 14);
		contentPane.add(label_dateRegister);
		
		JLabel textField_dateRegister_1 = new JLabel("วันที่ลงทะเบียน");
		textField_dateRegister_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_dateRegister_1.setBounds(10, 157, 78, 14);
		contentPane.add(textField_dateRegister_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 185, 256, 150);
		contentPane.add(panel);
		panel.setLayout(null);
		
		date_vaccine1 = new JDateChooser();
		date_vaccine1.setBounds(82, 97, 157, 20);
		panel.add(date_vaccine1);
		
		label_date = new JLabel("null");
		label_date.setBounds(82, 69, 157, 14);
		panel.add(label_date);
		label_date.setForeground(Color.RED);
		label_date.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_3 = new JLabel("เลือกวันฉีดตั้งแต่วันที่ ");
		lblNewLabel_3.setBounds(106, 44, 106, 14);
		panel.add(lblNewLabel_3);
		
		combo_vaccine = new JComboBox<String>();
		combo_vaccine.setBounds(82, 11, 157, 22);
		panel.add(combo_vaccine);
		combo_vaccine.setEnabled(false);
		
		JLabel lblNewLabel_2 = new JLabel("วัคซีนเข็มที่ 1");
		lblNewLabel_2.setBounds(10, 15, 62, 14);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
	}
	String setFormatDate(JDateChooser date) {
		Date d = date.getDate();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
		return dateFormat.format(d);	
	}
}
