package net.csmsu.covid;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;

import net.csmsu.covid.entity.Register;
import net.csmsu.covid.entity.Student;
import net.csmsu.covid.service.ServiceRegister;
import net.csmsu.covid.service.ServiceStudent;

import java.awt.event.ActionListener;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

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
	private JDateChooser dateChooser;
	
	private JLabel label_title;
	
	private int rid = 0;

	

	@Autowired ServiceStudent sevice;
	@Autowired ServiceRegister service_register;
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
	
	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid=rid;
		
	}
	public RegisterFrame(ServiceRegister service_register) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		this();
		this.service_register = service_register;
	}
	
	public RegisterFrame() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				LoadEdit();
			}
		});
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		UIManager.put("OptionPane.messageFont", new Font("Tahoma", Font.PLAIN, 14));
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
				setTextField(true);
			 if(!tfSid.getText().isEmpty()) {
					int Sid = Integer.parseInt(tfSid.getText());
					List<Student> students = sevice.getStudentById(Sid);
					for(Student s : students) {
						tfFirstname.setText(s.getFirstname());
						tfLastname.setText(s.getLastname());
						tfMobile.setText(s.getMobile());
						tfEmail.setText(s.getEmail());	
					}
					if(!students.isEmpty()) {
						setTextField(false);
					}else {
						clearTextField();
					}
						
				}else {
					clearTextField();
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rid !=0) {
					Register register = service_register.getRegisterByRid(rid);
					String date = setFormatDate(dateChooser);
					register.setRid(rid);
					register.setDate(java.sql.Date.valueOf(date));
					if(service_register.updateRegister(register)!=null) {
						JOptionPane.showMessageDialog(null,"แก้ไข สำเร็จ");
					}else {
						JOptionPane.showMessageDialog(null,"แก้ไข ไม่สำเร็จ!");
					}
					rid=0;
					dispose();
				}
				else if(!tfSid.getText().isEmpty()){
					Register register = new Register();
					int id = Integer.parseInt(tfSid.getText());
					String date = setFormatDate(dateChooser);
					List<Student> students = sevice.getStudentById(id);
					for(Student s : students) {
						register.setTbStudent(s);
					}
					register.setDate(java.sql.Date.valueOf(date));
					if(service_register.updateRegister(register)!=null) {
						JOptionPane.showMessageDialog(null,"ลงทะเบียน สำเร็จ");
						
					}else {
						JOptionPane.showMessageDialog(null,"ลงทะเบียน ไม่สำเร็จ!");
					}			
				}
			}
		});
		btnNewButton.setBounds(86, 327, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ยกเลิก");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(185, 327, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("วันที่ลงทะเบียน");
		lblNewLabel_1_1_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2_1_1.setBounds(27, 208, 69, 14);
		contentPane.add(lblNewLabel_1_1_2_1_1);
		
		label_title = new JLabel("ลงทะเบียนต้องการวัคซีน");
		label_title.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_title.setBounds(50, 11, 186, 23);
		contentPane.add(label_title);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd-MMMM-yyyy");
		dateChooser.setDate(new Date());
		dateChooser.setBounds(106, 208, 138, 20);
		contentPane.add(dateChooser);
	}
	
	void setTextField(boolean b) {
		tfFirstname.setEnabled(b);
		tfLastname.setEnabled(b);
		tfMobile.setEnabled(b);
		tfEmail.setEnabled(b);
	}
	
	void clearTextField() {
		tfFirstname.setText("");
		tfLastname.setText("");
		tfMobile.setText("");
		tfEmail.setText("");
	}
	
	String setFormatDate(JDateChooser date) {
		Date d = date.getDate();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
		return dateFormat.format(d);	
	}
	
	void LoadEdit() {
		if(rid!=0) {
			Register register = new Register();
			tfSid.setEditable(false);
			setTextField(false);
			
			register = service_register.getRegisterByRid(rid);
			tfSid.setText(register.getTbStudent().getSid()+"");
			tfFirstname.setText(register.getTbStudent().getFirstname());
			tfLastname.setText(register.getTbStudent().getLastname());
			tfMobile.setText(register.getTbStudent().getMobile());
			tfEmail.setText(register.getTbStudent().getEmail());
			dateChooser.setDate(register.getDate());
			
			label_title.setText("แก้ไขการลงทะเบียน");
			setTitle("แก้ไขการลงทะเบียน");
			
		}
	}

}
