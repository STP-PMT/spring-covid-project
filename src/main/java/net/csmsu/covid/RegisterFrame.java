package net.csmsu.covid;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

@Component
public class RegisterFrame extends JFrame {
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

	@Autowired
	ServiceStudent service_student;
	@Autowired
	ServiceRegister service_register;
	private JPanel panel;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 * 
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;

	}

	public RegisterFrame(ServiceRegister service_register) {
		this();
		this.service_register = service_register;
	}

	public RegisterFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Documents\\Data_warehouse\\Covid vaccination project for students\\covid-project\\src\\asssets\\imgaes\\icon.png"));
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				LoadEdit();
				if (rid == 0) {
					List<Student> student = service_student.getStudentNotInRegister();
					DefaultTableModel model = new DefaultTableModel();
					Object[] columns = { "รหัสนิสิต", "ชื่อ", "นามสกุล"};
					model.setColumnIdentifiers(columns);

					for (Student s : student) {
						Object[] obj = {s.getSid(),s.getFirstname(),s.getLastname()};
						model.addRow(obj);
					}
					table.setModel(model);
				}

			}
		});
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		UIManager.put("OptionPane.messageFont", new Font("Tahoma", Font.PLAIN, 14));
		setTitle("ลงทะเบียนต้องการวัคซีน");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 638, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("รหัสนิสิต");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(33, 64, 46, 14);
		contentPane.add(lblNewLabel);

		tfSid = new JTextField();
		tfSid.setEditable(false);
		tfSid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTextField(true);
				
			}
		});
		tfSid.setBounds(89, 64, 138, 20);
		contentPane.add(tfSid);
		tfSid.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("ชื่อ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(33, 92, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("นามสกุล");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(33, 117, 46, 14);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("เบอร์โทร");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2.setBounds(33, 145, 46, 14);
		contentPane.add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("อีเมล");
		lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2_1.setBounds(33, 170, 46, 14);
		contentPane.add(lblNewLabel_1_1_2_1);

		tfFirstname = new JTextField();
		tfFirstname.setEditable(false);
		tfFirstname.setColumns(10);
		tfFirstname.setBounds(89, 89, 138, 20);
		contentPane.add(tfFirstname);

		tfLastname = new JTextField();
		tfLastname.setEditable(false);
		tfLastname.setColumns(10);
		tfLastname.setBounds(89, 114, 138, 20);
		contentPane.add(tfLastname);

		tfMobile = new JTextField();
		tfMobile.setEditable(false);
		tfMobile.setColumns(10);
		tfMobile.setBounds(89, 142, 138, 20);
		contentPane.add(tfMobile);

		tfEmail = new JTextField();
		tfEmail.setEditable(false);
		tfEmail.setColumns(10);
		tfEmail.setBounds(89, 167, 138, 20);
		contentPane.add(tfEmail);

		JButton btnNewButton = new JButton("ยืนยัน");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rid != 0) {
					Register register = service_register.getRegisterByRid(rid);
					String date = setFormatDate(dateChooser);
					register.setRid(rid);
					register.setDate(java.sql.Date.valueOf(date));
					if (service_register.updateRegister(register) != null) {
						JOptionPane.showMessageDialog(null, "แก้ไข สำเร็จ");
					} else {
						JOptionPane.showMessageDialog(null, "แก้ไข ไม่สำเร็จ!");
					}
					rid = 0;
				} else if (!tfSid.getText().isEmpty()) {
					Register register = new Register();
					String id = tfSid.getText();
					String date = setFormatDate(dateChooser);
					List<Student> students = service_student.getStudentById(id);
					for (Student s : students) {
						register.setTbStudent(s);
					}
					register.setDate(java.sql.Date.valueOf(date));
					if (service_register.updateRegister(register) != null) {
						JOptionPane.showMessageDialog(null, "ลงทะเบียน สำเร็จ");

					} else {
						JOptionPane.showMessageDialog(null, "ลงทะเบียน ไม่สำเร็จ!");
					}
				}
				dispose();
			}
		});
		btnNewButton.setBounds(39, 278, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("ยกเลิก");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(138, 278, 89, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("วันที่ลงทะเบียน");
		lblNewLabel_1_1_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2_1_1.setBounds(10, 195, 69, 14);
		contentPane.add(lblNewLabel_1_1_2_1_1);

		label_title = new JLabel("ลงทะเบียนต้องการวัคซีน");
		label_title.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_title.setBounds(321, 11, 186, 23);
		contentPane.add(label_title);

		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd-MMMM-yyyy");
		dateChooser.setDate(new Date());
		dateChooser.setBounds(89, 195, 138, 20);
		contentPane.add(dateChooser);
		
		panel = new JPanel();
		panel.setBounds(237, 64, 375, 237);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 375, 237);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int selected = table.getSelectedRow();
				int sid = (int) table.getModel().getValueAt(selected, 0);
				tfSid.setText(sid+"");
				if (!tfSid.getText().isEmpty()) {
					String Sid = tfSid.getText();
					List<Student> students = service_student.getStudentById(Sid);
					for (Student s : students) {
						tfFirstname.setText(s.getFirstname());
						tfLastname.setText(s.getLastname());
						tfMobile.setText(s.getMobile());
						tfEmail.setText(s.getEmail());
					}
					if (!students.isEmpty()) {
						setTextField(false);
					} else {
						clearTextField();
					}

				} else {
					clearTextField();
				}
			}
		});
		scrollPane.setViewportView(table);
	}

	public RegisterFrame(ServiceStudent service_student, ServiceRegister service_register) {
		this();
		this.service_register = service_register;
		this.service_student = service_student;
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
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		return dateFormat.format(d);
	}

	void LoadEdit() {
		if (rid != 0) {
			Register register = new Register();
			tfSid.setEditable(false);
			setTextField(false);

			register = service_register.getRegisterByRid(rid);
			tfSid.setText(register.getTbStudent().getSid() + "");
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
