package net.csmsu.covid;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;

import net.csmsu.covid.entity.Student;
import net.csmsu.covid.service.ServiceStudent;

import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Optional;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StudentFrame extends JFrame {
	@Autowired
	ServiceStudent service_student;

	private JPanel contentPane;
	private JTextField tfSid;
	private JTextField tfFirstname;
	private JTextField tfLastname;
	private JTextField tfMobile;
	private JTextField tfEmail;
	private JLabel lbTitle;
	private JLabel adSid;
	private JLabel adFirstname;
	private JLabel adLastname;
	private JLabel adMobile;
	private JLabel adEmail;
	private String sid = "";

	public StudentFrame(ServiceStudent service_student) {
		this();
		this.service_student = service_student;
	}

	public StudentFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				if (sid != "") {
					lbTitle.setText("แก้ไขข้อมูล");
					Student student = service_student.getStudentById(sid).get();
					tfSid.setText(student.getSid());
					tfFirstname.setText(student.getFirstname());
					tfLastname.setText(student.getLastname());
					tfMobile.setText(student.getMobile());
					tfEmail.setText(student.getEmail());
					tfSid.setEditable(false);
				}
			}
		});
		setTitle("ข้อมูลนิสิต");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"D:\\Documents\\Data_warehouse\\Covid vaccination project for students\\covid-project\\src\\asssets\\imgaes\\icon.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfSid = new JTextField();
		tfSid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == ke.VK_BACK_SPACE
						|| ke.getKeyChar() == ke.VK_DELETE) {
					tfSid.setEditable(true);
					adSid.setText("");
				} else {
					tfSid.setEditable(false);
					adSid.setText("ใส่ตัวเลข");
				}
			}
		});
		tfSid.setColumns(10);
		tfSid.setBounds(79, 57, 138, 20);
		contentPane.add(tfSid);

		JLabel lblNewLabel = new JLabel("รหัสนิสิต");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(23, 57, 46, 14);
		contentPane.add(lblNewLabel);

		tfFirstname = new JTextField();
		tfFirstname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')) {
					tfFirstname.setEditable(false);
					adFirstname.setText("ห้ามใส่ตัวเลข");
				} else {
					tfFirstname.setEditable(true);
					adFirstname.setText("");
				}
			}
		});
		tfFirstname.setColumns(10);
		tfFirstname.setBounds(79, 82, 138, 20);
		contentPane.add(tfFirstname);

		JLabel lblNewLabel_1 = new JLabel("ชื่อ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(23, 85, 46, 14);
		contentPane.add(lblNewLabel_1);

		tfLastname = new JTextField();
		tfLastname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')) {
					tfLastname.setEditable(false);
					adLastname.setText("ห้ามใส่ตัวเลข");
				} else {
					tfLastname.setEditable(true);
					adLastname.setText("");
				}
			}
		});
		tfLastname.setColumns(10);
		tfLastname.setBounds(79, 107, 138, 20);
		contentPane.add(tfLastname);

		JLabel lblNewLabel_1_1 = new JLabel("นามสกุล");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(23, 110, 46, 14);
		contentPane.add(lblNewLabel_1_1);

		tfMobile = new JTextField();
		tfMobile.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == ke.VK_BACK_SPACE
						|| ke.getKeyChar() == ke.VK_DELETE) {
					tfMobile.setEditable(true);
					adMobile.setText("");
				} else {
					tfMobile.setEditable(false);
					adMobile.setText("ใส่ตัวเลข");
				}
			}
		});
		tfMobile.setColumns(10);
		tfMobile.setBounds(79, 135, 138, 20);
		contentPane.add(tfMobile);

		JLabel lblNewLabel_1_1_2 = new JLabel("เบอร์โทร");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2.setBounds(23, 138, 46, 14);
		contentPane.add(lblNewLabel_1_1_2);

		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(79, 160, 138, 20);
		contentPane.add(tfEmail);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("อีเมล");
		lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2_1.setBounds(23, 163, 46, 14);
		contentPane.add(lblNewLabel_1_1_2_1);

		lbTitle = new JLabel("เพิ่มข้อมูลนิสิต");
		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setBounds(79, 11, 138, 20);
		contentPane.add(lbTitle);

		adSid = new JLabel("");
		adSid.setHorizontalAlignment(SwingConstants.CENTER);
		adSid.setForeground(Color.RED);
		adSid.setBounds(227, 60, 97, 14);
		contentPane.add(adSid);

		adFirstname = new JLabel("");
		adFirstname.setHorizontalAlignment(SwingConstants.CENTER);
		adFirstname.setForeground(Color.RED);
		adFirstname.setBounds(227, 85, 97, 14);
		contentPane.add(adFirstname);

		adLastname = new JLabel("");
		adLastname.setHorizontalAlignment(SwingConstants.CENTER);
		adLastname.setForeground(Color.RED);
		adLastname.setBounds(227, 110, 97, 14);
		contentPane.add(adLastname);

		adMobile = new JLabel("");
		adMobile.setHorizontalAlignment(SwingConstants.CENTER);
		adMobile.setForeground(Color.RED);
		adMobile.setBounds(227, 138, 97, 14);
		contentPane.add(adMobile);

		adEmail = new JLabel("");
		adEmail.setHorizontalAlignment(SwingConstants.CENTER);
		adEmail.setForeground(Color.RED);
		adEmail.setBounds(227, 163, 97, 14);
		contentPane.add(adEmail);

		JButton btnNewButton = new JButton("ตกลง");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (sid != "") {
					Student student = service_student.getStudentById(sid).get();
					checkTextField(student);
					if(adSid.getText().isEmpty()&&adFirstname.getText().isEmpty()&&adLastname.getText().isEmpty()&&adMobile.getText().isEmpty()&&adEmail.getText().isEmpty()) {
						if(service_student.updateUpdate(student)!=null) {
							JOptionPane.showMessageDialog(null, "แก้ไข สำเร็จ");
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "แก้ไข ไม่สำเร็จ!");
						}
					}else {
						JOptionPane.showMessageDialog(null, "ข้อมูลไม่ถุกต้อง");
					}
				} else {
					Student s = new Student();
					checkTextField(s);
					if(adSid.getText().isEmpty()&&adFirstname.getText().isEmpty()&&adLastname.getText().isEmpty()&&adMobile.getText().isEmpty()&&adEmail.getText().isEmpty()) {
						if(service_student.updateUpdate(s)!=null) {
							JOptionPane.showMessageDialog(null, "ลงทะเบียน สำเร็จ");
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "ลงทะเบียน ไม่สำเร็จ!");
						}
					}else {
						JOptionPane.showMessageDialog(null, "ข้อมูลไม่ถุกต้อง");
					}
				}
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(136, 228, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("ยกเลิก");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(235, 228, 89, 23);
		contentPane.add(btnNewButton_1);
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	private void checkTextField(Student s) {
		adSid.setText("");
		adFirstname.setText("");
		adMobile.setText("");
		adLastname.setText("");
		adEmail.setText("");
		if (tfSid.getText().length() == 11) {
			if(sid=="") {
				Optional<Student> student = service_student.getStudentById(tfSid.getText());
				if(!student.isPresent()) {
					s.setSid(tfSid.getText());
				}else {
					adSid.setText("มีรหัสนี้ในระบบแล้ว");
				}
			}
		} else {
			adSid.setText("รหัสไม่ถูกต้อง");
		}
		if (tfMobile.getText().length() == 10) {
			s.setMobile(tfMobile.getText());
		} else {
			adMobile.setText("เบอร์โทรไม่ถูกต้อง");
		}
		if(!tfFirstname.getText().isEmpty()) {
			s.setFirstname(tfFirstname.getText());
		}else {
			adFirstname.setText("ใส่ชื่อ");
		}
		if(!tfLastname.getText().isEmpty()) {
			s.setLastname(tfLastname.getText());
		}else {
			adLastname.setText("ใส่นามสกุล");
		}
		if(!tfEmail.getText().isEmpty()) {
			s.setEmail(tfEmail.getText());
		}else {
			adEmail.setText("ใส่อีเมล");
		}
	}

}
