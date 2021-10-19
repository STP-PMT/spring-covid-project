package net.csmsu.covid;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.csmsu.covid.entity.Register;
import net.csmsu.covid.entity.Student;
import net.csmsu.covid.service.ServiceRegister;
import net.csmsu.covid.service.ServiceStudent;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTabbedPane;
import com.toedter.calendar.JDateChooser;
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.beans.VetoableChangeListener;
import java.text.SimpleDateFormat;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@Component
public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField search_student;
	private JTable table_student;
	private JTable table_register;
	
	private JPanel panel_card;
	
	@Autowired ServiceRegister service_register;
	@Autowired ServiceStudent service_student;
	@Autowired RegisterFrame register_frame;
	
	private JTextField search_register;
	private JTextField textField_2;
	private JTable table_allvaccine;
	
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
	public MainFrame() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		setResizable(false);	
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		UIManager.put("OptionPane.messageFont", new Font("Tahoma", Font.PLAIN, 14));
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Documents\\Data_warehouse\\Covid vaccination project for students\\covid-project\\src\\asssets\\imgaes\\icon.png"));
		setTitle("Covid Vaccination Project For Students");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_menu = new JPanel();
		panel_menu.setBackground(new Color(51, 204, 255));
		panel_menu.setBounds(0, 0, 161, 461);
		contentPane.add(panel_menu);
		panel_menu.setLayout(null);
		
		JButton btnNewButton = new JButton("รายชื่อนิสิต");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl =(CardLayout) panel_card.getLayout();
				cl.show(panel_card,"Student");
				List<Student> students =  service_student.getAllStudent();
				LoadDataStudent(students);
			}
		});
		btnNewButton.setBounds(10, 45, 141, 23);
		panel_menu.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ลงทะเบียนเข้าระบบ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl =(CardLayout) panel_card.getLayout();
				cl.show(panel_card,"Register");
				LoadDataRegister(table_register);
			}
		});
		btnNewButton_1.setBounds(10, 79, 141, 23);
		panel_menu.add(btnNewButton_1);
		
		JButton btnSohkcid = new JButton("หน้าแรก");
		btnSohkcid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl =(CardLayout) panel_card.getLayout();
				cl.show(panel_card,"Home");
			}
		});
		btnSohkcid.setBounds(10, 11, 141, 23);
		panel_menu.add(btnSohkcid);
		
		JButton btnNewButton_1_1 = new JButton("ลงทะเบียนฉีดวัคซีน");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				CardLayout cl =(CardLayout) panel_card.getLayout();
				cl.show(panel_card,"Vaccine");
				LoadDataVaccine(table_allvaccine);
			}
		});
		btnNewButton_1_1.setBounds(10, 113, 141, 23);
		panel_menu.add(btnNewButton_1_1);
		
		panel_card = new JPanel();
		panel_card.setBounds(160, 0, 684, 461);
		contentPane.add(panel_card);
		panel_card.setLayout(new CardLayout(0, 0));
		
		JPanel panel_home = new JPanel();
		panel_home.setBackground(Color.BLUE);
		panel_card.add(panel_home, "Home");
		panel_home.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Documents\\Data_warehouse\\Covid vaccination project for students\\covid-project\\src\\asssets\\imgaes\\icon.png"));
		lblNewLabel_2.setBounds(251, 11, 128, 128);
		panel_home.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("โครงการฉีดวัคซีนโควิดสำหรับนักศึกษา");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_3.setBounds(26, 152, 614, 62);
		panel_home.add(lblNewLabel_3);
		
		JPanel panel_student = new JPanel();
		panel_card.add(panel_student, "Student");
		panel_student.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 87, 664, 363);
		panel_student.add(scrollPane);
		
		
		table_student = new JTable();
		scrollPane.setViewportView(table_student);
		
		JLabel lblNewLabel_1 = new JLabel("รายชื่อนิสิต");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 11, 211, 25);
		panel_student.add(lblNewLabel_1);
		
		search_student = new JTextField();
		search_student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(search_student.getText());
				List<Student> students =  service_student.getStudentById(id);
				LoadDataStudent(students);
			}
		});
		search_student.setBounds(453, 12, 144, 20);
		panel_student.add(search_student);
		search_student.setToolTipText("search");
		search_student.setForeground(Color.BLACK);
		search_student.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("ค้นหา");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(search_student.getText());
				List<Student> students =  service_student.getStudentById(id);
				LoadDataStudent(students);
			}
		});
		btnNewButton_2.setBounds(600, 11, 74, 23);
		panel_student.add(btnNewButton_2);
		
		JPanel panel_register = new JPanel();
		panel_register.setLayout(null);
		panel_card.add(panel_register, "Register");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 87, 664, 363);
		panel_register.add(scrollPane_1);
		
		table_register = new JTable();
		scrollPane_1.setViewportView(table_register);
		
		JLabel lblNewLabel_1_1 = new JLabel("ลงทะเบียนเพื่อฉีดวัคซีน");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(10, 5, 224, 25);
		panel_register.add(lblNewLabel_1_1);
		
		search_register = new JTextField();
		search_register.setToolTipText("search");
		search_register.setForeground(Color.BLACK);
		search_register.setColumns(10);
		search_register.setBounds(454, 8, 144, 20);
		panel_register.add(search_register);
		
		JButton btnNewButton_2_1 = new JButton("ค้นหา");
		btnNewButton_2_1.setBounds(600, 7, 74, 23);
		panel_register.add(btnNewButton_2_1);
		
		JButton btnNewButton_3 = new JButton("ลงทะเบียน");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterFrame frame = new RegisterFrame(service_student,service_register);
				frame.setVisible(true);
			}
		});
		btnNewButton_3.setBackground(new Color(0, 204, 51));
		btnNewButton_3.setBounds(10, 53, 89, 23);
		panel_register.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("แก้ไข");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
	        		int id = (Integer) table_register.getValueAt(table_register.getSelectedRow(), 0);
	        		System.err.println("Selected : "+id);
	        		RegisterFrame frame = new RegisterFrame(service_register);
	        		frame.setRid(id);
	        		frame.setVisible(true);
	        		frame.addWindowListener(new WindowAdapter() {
	        			@Override
	        			public void windowClosed(WindowEvent e) {
	        				LoadDataRegister(table_register);
	        			}
	        		});
	        	}catch(Exception ex){}
			}
		});
		btnNewButton_4.setBackground(new Color(255, 255, 51));
		btnNewButton_4.setBounds(107, 53, 89, 23);
		panel_register.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("ลบ");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
	        		int id = (Integer) table_register.getValueAt(table_register.getSelectedRow(), 0);
	        		System.err.println("Delete rid : "+id);
	        		if(service_register.deleteByRid(id)) {
	        			JOptionPane.showMessageDialog(null,"ลบสำเร็จ");
	        		}else {
	        			JOptionPane.showMessageDialog(null,"ลบไม่สำเร็จ");
	        		}
	        		LoadDataRegister(table_register);
	        	}catch(Exception ex){}
			}
		});
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBackground(Color.RED);
		btnNewButton_5.setBounds(205, 53, 89, 23);
		panel_register.add(btnNewButton_5);
		
		JPanel panel_vaccine = new JPanel();
		panel_vaccine.setLayout(null);
		panel_card.add(panel_vaccine, "Vaccine");
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("ลงทะเบียนฉีดวัคซีน");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1.setBounds(10, 5, 224, 25);
		panel_vaccine.add(lblNewLabel_1_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("search");
		textField_2.setForeground(Color.BLACK);
		textField_2.setColumns(10);
		textField_2.setBounds(454, 8, 144, 20);
		panel_vaccine.add(textField_2);
		
		JButton btnNewButton_2_1_1_1 = new JButton("ค้นหา");
		btnNewButton_2_1_1_1.setBounds(600, 7, 74, 23);
		panel_vaccine.add(btnNewButton_2_1_1_1);
		
		JButton btnNewButton_3_1_1 = new JButton("ฉีดวัคซีน");
		btnNewButton_3_1_1.setBackground(new Color(0, 204, 51));
		btnNewButton_3_1_1.setBounds(10, 53, 89, 23);
		panel_vaccine.add(btnNewButton_3_1_1);
		
		JButton btnNewButton_4_1_1 = new JButton("แก้ไข");
		btnNewButton_4_1_1.setBackground(new Color(255, 255, 51));
		btnNewButton_4_1_1.setBounds(107, 53, 89, 23);
		panel_vaccine.add(btnNewButton_4_1_1);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 87, 664, 363);
		panel_vaccine.add(tabbedPane_1);
		
		JPanel panel_all = new JPanel();
		tabbedPane_1.addTab("รายชื่อลงทะเบียน", null, panel_all, null);
		panel_all.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 659, 335);
		panel_all.add(scrollPane_2);
		
		table_allvaccine = new JTable();
		scrollPane_2.setViewportView(table_allvaccine);
		
		JPanel panel_dose1 = new JPanel();
		tabbedPane_1.addTab("เข็มที่ 1", null, panel_dose1, null);
		
		JPanel panel_dose2 = new JPanel();
		tabbedPane_1.addTab("เข็มที่ 2", null, panel_dose2, null);
		
		JPanel panel_dose3 = new JPanel();
		tabbedPane_1.addTab("เข็มที่ 3", null, panel_dose3, null);
		
		JDateChooser dateChooser = new JDateChooser();
		
		dateChooser.setBounds(563, 53, 111, 20);
		panel_vaccine.add(dateChooser);
		dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(tabbedPane_1.getTitleAt(tabbedPane_1.getSelectedIndex()).equals("รายชื่อลงทะเบียน")) {
					try {
						String strdate = setFormatDate(dateChooser);
						System.err.println(strdate);
					} catch (NullPointerException e) {
						
					}
					
				}
			}
		});
		
	}
	
	void LoadDataRegister(JTable table) {
		List<Register> registers =  service_register.getAllRegister();
		
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = {"รหัสลงทะเบียน","รหัสนิสิต","ชื่อ","นามสกุล","เบอร์โทร","วันที่ลงทะเบียน"};
		model.setColumnIdentifiers(columns);
		
		for(Register r:registers) {
			Object[] obj = {r.getRid(),r.getTbStudent().getSid(),r.getTbStudent().getFirstname(),r.getTbStudent().getLastname(),
					r.getTbStudent().getMobile(),r.getDate()};
			model.addRow(obj);
		}
		table.setModel(model);
	}
	
	void LoadDataVaccine(JTable table) {
		List<Register> registers =  service_register.getAllRegister();
		
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = {"รหัสลงทะเบียน","รหัสนิสิต","ชื่อ","นามสกุล","วันที่ลงทะเบียน","เข็มที่ 1","เข็มที่ 2","เข็มที่ 3"};
		model.setColumnIdentifiers(columns);
		
		for(Register r:registers) {
			Object[] obj = {r.getRid(),r.getTbStudent().getSid(),r.getTbStudent().getFirstname(),r.getTbStudent().getLastname(),r.getDate(),
					(r.getTbVaccine1()!=null)?r.getTbVaccine1().getTbVaccine().getName():"ไม่มีข้อมูล",
					(r.getTbVaccine2()!=null)?r.getTbVaccine1().getTbVaccine().getName():"ไม่มีข้อมูล",
					(r.getTbVaccine2()!=null)?r.getTbVaccine1().getTbVaccine().getName():"ไม่มีข้อมูล",
					};
			model.addRow(obj);
		}
		table.setModel(model);
	}
	
	
	void LoadDataStudent(List<Student> students) {
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = {"รหัสนิสิต","ชื่อ","นามสกุล","เบอร์โทร","อีเมล"};
		model.setColumnIdentifiers(columns);
		
		for(Student s:students) {
			Object[] obj = {s.getSid(),s.getFirstname(),s.getLastname(),s.getMobile(),s.getEmail()};
			model.addRow(obj);
		}
		table_student.setModel(model);
	}
	
	String setFormatDate(JDateChooser date) {
		if(date.getDate() != null) {
			Date d = date.getDate();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
			return dateFormat.format(d);	
		}else {
			return "";
		}
		
	}
}
