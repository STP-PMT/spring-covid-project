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
import java.util.List;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

@Component
public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table_student;
	private JTable table_register;
	
	private JPanel panel_card;
	
	@Autowired ServiceRegister service_register;
	@Autowired ServiceStudent service_student;
	
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
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Documents\\Data_warehouse\\Covid vaccination project for students\\covid-project\\src\\asssets\\imgaes\\icon.png"));
		setTitle("Covid Vaccination Project For Students");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_title = new JPanel();
		panel_title.setBackground(Color.BLUE);
		panel_title.setBounds(0, 0, 784, 47);
		contentPane.add(panel_title);
		panel_title.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Covid Vaccination Project For Students");
		lblNewLabel.setBounds(10, 11, 279, 25);
		panel_title.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.WHITE);
		
		textField = new JTextField();
		textField.setForeground(Color.LIGHT_GRAY);
		textField.setText("ค้นหา");
		textField.setBounds(541, 15, 233, 20);
		panel_title.add(textField);
		textField.setColumns(10);
		
		JPanel panel_menu = new JPanel();
		panel_menu.setBackground(new Color(51, 204, 255));
		panel_menu.setBounds(0, 47, 132, 414);
		contentPane.add(panel_menu);
		panel_menu.setLayout(null);
		
		JButton btnNewButton = new JButton("รายชื่อนักเรียน");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl =(CardLayout) panel_card.getLayout();
				cl.show(panel_card,"Student");
				LoadDataStudent();
			}
		});
		btnNewButton.setBounds(10, 11, 112, 23);
		panel_menu.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ลงทะเบียน");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl =(CardLayout) panel_card.getLayout();
				cl.show(panel_card,"Register");
				System.err.println(service_register);
				LoadDataRegister();
			}
		});
		btnNewButton_1.setBounds(10, 42, 112, 23);
		panel_menu.add(btnNewButton_1);
		
		panel_card = new JPanel();
		panel_card.setBounds(134, 47, 650, 414);
		contentPane.add(panel_card);
		panel_card.setLayout(new CardLayout(0, 0));
		
		JPanel panel_student = new JPanel();
		panel_card.add(panel_student, "Student");
		panel_student.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 87, 630, 316);
		panel_student.add(scrollPane);
		
		
		table_student = new JTable();
		scrollPane.setViewportView(table_student);
		
		JLabel lblNewLabel_1 = new JLabel("รายชื่อนักเรียน");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 11, 160, 25);
		panel_student.add(lblNewLabel_1);
		
		JPanel panel_register = new JPanel();
		panel_register.setLayout(null);
		panel_card.add(panel_register, "Register");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 87, 630, 316);
		panel_register.add(scrollPane_1);
		
		table_register = new JTable();
		scrollPane_1.setViewportView(table_register);
		
		JLabel lblNewLabel_1_1 = new JLabel("ลงทะเบียน");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(10, 11, 160, 25);
		panel_register.add(lblNewLabel_1_1);
		
	}
	void LoadDataRegister() {
		List<Register> registers =  service_register.getAllRegister();
		
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = {"รหัสลงทะเบียน","รหัสนิสิต","ชื่อ","นามสกุล","เบอร์โทร","วันที่ลงทะเบียน"};
		model.setColumnIdentifiers(columns);
		
		for(Register r:registers) {
			Object[] obj = {r.getRid(),r.getTbStudent().getSid(),r.getTbStudent().getFirstname(),r.getTbStudent().getLastname(),
					r.getTbStudent().getMobile(),r.getDate()};
			model.addRow(obj);
		}
		table_register.setModel(model);
	}
	
	void LoadDataStudent() {
		List<Student> students =  service_student.getAllStudent();
		
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = {"รหัสนิสิต","ชื่อ","นามสกุล","เบอร์โทร","อีเมล"};
		model.setColumnIdentifiers(columns);
		
		for(Student s:students) {
			Object[] obj = {s.getSid(),s.getFirstname(),s.getLastname(),s.getMobile(),s.getEmail()};
			model.addRow(obj);
		}
		table_student.setModel(model);
	}
}
