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
import net.csmsu.covid.entity.Vaccine1;
import net.csmsu.covid.entity.Vaccine2;
import net.csmsu.covid.entity.Vaccine3;
import net.csmsu.covid.service.ServiceRegister;
import net.csmsu.covid.service.ServiceStudent;
import net.csmsu.covid.service.ServiceVaccine;

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
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

@Component
public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField search_student;
	private JTable table_student;
	private JTable table_register;
	private JPanel panel_card;

	@Autowired
	ServiceRegister service_register;
	@Autowired
	ServiceStudent service_student;
	@Autowired
	ServiceVaccine service_vaccine;
	@Autowired
	RegisterFrame register_frame;

	private JTextField search_register;
	private JTextField tfVaccine;
	private JTable table_allvaccine;
	private JTable table_vaccine1;
	private JTable table_vaccine2;
	private JTable table_vaccine3;
	private JTabbedPane tabbedPane_1;
	private JComboBox<String> comboBox;
	private JTextField textField;
	private JPanel panel;
	private JDateChooser dateChooser;
	private JTable table_report;

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
	public MainFrame() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {

		setResizable(false);
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		UIManager.put("OptionPane.messageFont", new Font("Tahoma", Font.PLAIN, 14));
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"D:\\Documents\\Data_warehouse\\Covid vaccination project for students\\covid-project\\src\\asssets\\imgaes\\icon.png"));
		setTitle("Covid Vaccination Project For Students");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_menu = new JPanel();
		panel_menu.setBackground(new Color(51, 204, 255));
		panel_menu.setBounds(0, 0, 161, 581);
		contentPane.add(panel_menu);
		panel_menu.setLayout(null);

		JButton btnNewButton = new JButton("รายชื่อนิสิต");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) panel_card.getLayout();
				cl.show(panel_card, "Student");
				List<Student> students = service_student.getAllStudent();
				LoadDataStudent(students);
			}
		});
		btnNewButton.setBounds(10, 45, 141, 23);
		panel_menu.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("ลงทะเบียนเข้าระบบ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) panel_card.getLayout();
				cl.show(panel_card, "Register");
				List<Register> registers = service_register.getAllRegister();
				LoadDataRegister(registers);
			}
		});
		btnNewButton_1.setBounds(10, 79, 141, 23);
		panel_menu.add(btnNewButton_1);

		JButton btnSohkcid = new JButton("หน้าแรก");
		btnSohkcid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) panel_card.getLayout();
				cl.show(panel_card, "Home");
			}
		});
		btnSohkcid.setBounds(10, 11, 141, 23);
		panel_menu.add(btnSohkcid);

		JButton btnNewButton_1_1 = new JButton("ลงทะเบียนฉีดวัคซีน");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) panel_card.getLayout();
				cl.show(panel_card, "Vaccine");
				List<Register> registers = service_register.getAllRegister();
				LoadDataVaccine(registers);
			}
		});
		btnNewButton_1_1.setBounds(10, 113, 141, 23);
		panel_menu.add(btnNewButton_1_1);

		JButton btnReport = new JButton("รายงานข้อมูลวัคซีน");
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) panel_card.getLayout();
				cl.show(panel_card, "report");
				List<Register> registers = service_register.getAllRegister();
				LoadReport(registers);
			}
		});
		btnReport.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnReport.setBounds(10, 147, 141, 23);
		panel_menu.add(btnReport);

		JLabel lblNewLabel_5 = new JLabel("สิทธิพงษื แปลมูลตรี");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(10, 556, 141, 14);
		panel_menu.add(lblNewLabel_5);

		panel_card = new JPanel();
		panel_card.setBounds(160, 0, 824, 581);
		contentPane.add(panel_card);
		panel_card.setLayout(new CardLayout(0, 0));

		JPanel panel_home = new JPanel();
		panel_home.setBackground(new Color(224, 255, 255));
		panel_card.add(panel_home, "Home");
		panel_home.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(
				"D:\\Documents\\Data_warehouse\\Covid vaccination project for students\\covid-project\\src\\asssets\\imgaes\\icon.png"));
		lblNewLabel_2.setBounds(355, 149, 128, 128);
		panel_home.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("โครงการฉีดวัคซีนโควิดสำหรับนักศึกษา");
		lblNewLabel_3.setForeground(new Color(0, 0, 205));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_3.setBounds(119, 301, 614, 62);
		panel_home.add(lblNewLabel_3);

		JPanel panel_student = new JPanel();
		panel_student.setBackground(new Color(224, 255, 255));
		panel_card.add(panel_student, "Student");
		panel_student.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 87, 804, 483);
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
				String id = search_student.getText();
				List<Student> students = service_student.getStudentBySidOrName(id);
				LoadDataStudent(students);
			}
		});
		search_student.setBounds(560, 12, 177, 20);
		panel_student.add(search_student);
		search_student.setToolTipText("search");
		search_student.setForeground(Color.BLACK);
		search_student.setColumns(10);

		JButton btnNewButton_2 = new JButton("ค้นหา");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = search_student.getText();
				List<Student> students = service_student.getStudentBySidOrName(id);
				LoadDataStudent(students);
			}
		});
		btnNewButton_2.setBounds(740, 11, 74, 23);
		panel_student.add(btnNewButton_2);
		
		JButton btnAdd = new JButton("เพิ่มข้อมูล");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentFrame frame = new StudentFrame(service_student);
				frame.setVisible(true);
				frame.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						List<Student> s = service_student.getAllStudent();
						LoadDataStudent(s);
					}
				});
			}
		});
		btnAdd.setBounds(560, 53, 79, 23);
		panel_student.add(btnAdd);
		
		JButton btnEdit = new JButton("แก้ไข");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = (String) table_student.getValueAt(table_student.getSelectedRow(), 0);
					System.err.println("Sid :"+id);
					StudentFrame frame = new StudentFrame(service_student);
					frame.setSid(id);
					frame.setVisible(true);
					frame.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosed(WindowEvent e) {
							List<Student> s = service_student.getAllStudent();
							LoadDataStudent(s);
						}
					});
				} catch (Exception ex) {
				}
			}
		});
		
		btnEdit.setBounds(646, 53, 79, 23);
		panel_student.add(btnEdit);
		
		JButton btnDelete = new JButton("ลบ");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = (String) table_student.getValueAt(table_student.getSelectedRow(), 0);
					int input = JOptionPane.showConfirmDialog(null, "ลบข้อมูลนิสิตรหัส " + id, "ลบข้อมูลนิสิต",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
					if (input == 0) {
						if (service_student.deleteBySid(id)) {
							JOptionPane.showMessageDialog(null, "ลบสำเร็จ");
						} else {
							JOptionPane.showMessageDialog(null, "ลบไม่สำเร็จ");
						}
					}
					List<Student> s = service_student.getAllStudent();
					LoadDataStudent(s);
				} catch (Exception ex) {
				}
			}
		});
		btnDelete.setBounds(735, 53, 79, 23);
		panel_student.add(btnDelete);

		JPanel panel_register = new JPanel();
		panel_register.setBackground(new Color(224, 255, 255));
		panel_register.setLayout(null);
		panel_card.add(panel_register, "Register");

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 87, 804, 483);
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
		search_register.setBounds(594, 12, 144, 20);
		panel_register.add(search_register);

		JButton btnNewButton_2_1 = new JButton("ค้นหา");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Register> r = service_register.getRegisterByRidOrName(search_register.getText());
				LoadReport(r);
			}
		});
		btnNewButton_2_1.setBounds(740, 11, 74, 23);
		panel_register.add(btnNewButton_2_1);

		JButton btnNewButton_3 = new JButton("ลงทะเบียน");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterFrame frame = new RegisterFrame(service_student, service_register);
				frame.setVisible(true);
				frame.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						List<Register> registers = service_register.getAllRegister();
						LoadDataRegister(registers);
					}
				});
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
					System.err.println("Selected : " + id);
					RegisterFrame frame = new RegisterFrame(service_register);
					frame.setRid(id);
					frame.setVisible(true);
					frame.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosed(WindowEvent e) {
							List<Register> registers = service_register.getAllRegister();
							LoadDataRegister(registers);
						}
					});
				} catch (Exception ex) {
				}
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
					int input = JOptionPane.showConfirmDialog(null, "ลบข้อมูลลงทะเบียนรหัส " + id, "ลบวัคซีน",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
					if (input == 0) {
						if (service_register.deleteByRid(id)) {
							JOptionPane.showMessageDialog(null, "ลบสำเร็จ");
						} else {
							JOptionPane.showMessageDialog(null, "ลบไม่สำเร็จ");
						}
					}
					List<Register> registers = service_register.getAllRegister();
					LoadDataRegister(registers);
				} catch (Exception ex) {
				}
			}
		});
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBackground(Color.RED);
		btnNewButton_5.setBounds(205, 53, 89, 23);
		panel_register.add(btnNewButton_5);

		JPanel panel_vaccine = new JPanel();
		panel_vaccine.setBackground(new Color(224, 255, 255));
		panel_vaccine.setLayout(null);
		panel_card.add(panel_vaccine, "Vaccine");

		JLabel lblNewLabel_1_1_1_1 = new JLabel("ลงทะเบียนและฉีดวัคซีน");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1.setBounds(10, 5, 224, 25);
		panel_vaccine.add(lblNewLabel_1_1_1_1);

		tfVaccine = new JTextField();
		tfVaccine.setToolTipText("search");
		tfVaccine.setForeground(Color.BLACK);
		tfVaccine.setColumns(10);
		tfVaccine.setBounds(594, 12, 144, 20);
		panel_vaccine.add(tfVaccine);

		JButton btnNewButton_2_1_1_1 = new JButton("ค้นหา");
		btnNewButton_2_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tabbedPane_1.getTitleAt(tabbedPane_1.getSelectedIndex()).equals("รายชื่อลงทะเบียน")) {
					List<Register> r = service_register.getRegisterByRidOrName(tfVaccine.getText());
					LoadDataVaccine(r);
				}
				if (tabbedPane_1.getTitleAt(tabbedPane_1.getSelectedIndex()).equals("เข็มที่ 1")) {
					List<Vaccine1> vaccine1s = service_vaccine.getVaccine1ByRidOrName(tfVaccine.getText());
					LoadVaccine1(vaccine1s);
				}
				if (tabbedPane_1.getTitleAt(tabbedPane_1.getSelectedIndex()).equals("เข็มที่ 2")) {
					List<Vaccine2> vaccine2s = service_vaccine.getVaccine2ByRidOrName(tfVaccine.getText());
					LoadVaccine2(vaccine2s);
				}
				if (tabbedPane_1.getTitleAt(tabbedPane_1.getSelectedIndex()).equals("เข็มที่ 3")) {
					List<Vaccine3> vaccine3s = service_vaccine.getVaccine3ByRidOrName(tfVaccine.getText());
					LoadVaccine3(vaccine3s);
				}
			}
		});
		btnNewButton_2_1_1_1.setBounds(740, 11, 74, 23);
		panel_vaccine.add(btnNewButton_2_1_1_1);

		JButton btnNewButton_3_1_1 = new JButton("ลงทะเบียน");
		btnNewButton_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tabbedPane_1.getTitleAt(tabbedPane_1.getSelectedIndex()).equals("รายชื่อลงทะเบียน")) {
					try {
						int id = (Integer) table_allvaccine.getValueAt(table_allvaccine.getSelectedRow(), 0);
						VaccineFrame frame = new VaccineFrame(service_register, service_vaccine);
						Register r = service_register.getRegisterByRid(id);
						if (r.getTbVaccine1() == null) {
							frame.setRid(id);
							frame.setVaccineTable(0);
							frame.setVisible(true);
							frame.addWindowListener(new WindowAdapter() {
								@Override
								public void windowClosed(WindowEvent e) {
									Filter();
								}
							});
						} else {
							JOptionPane.showMessageDialog(null,
									"นิสิตรหัส " + r.getTbStudent().getSid() + " ลงทะเบียนแล้ว");
						}
					} catch (Exception e2) {

					}
				}
				if (tabbedPane_1.getTitleAt(tabbedPane_1.getSelectedIndex()).equals("เข็มที่ 1")) {
					try {
						int id = (Integer) table_vaccine1.getValueAt(table_vaccine1.getSelectedRow(), 0);
						VaccineFrame frame = new VaccineFrame(service_register, service_vaccine);
						Register r = service_register.getRegisterByRid(id);
						if (r.getTbVaccine2() == null) {
							frame.setRid(id);
							frame.setVaccineTable(1);
							frame.setVisible(true);
							frame.addWindowListener(new WindowAdapter() {
								@Override
								public void windowClosed(WindowEvent e) {
									String strdate = setFormatDate(dateChooser);
									List<Vaccine1> vaccine1s = service_vaccine
											.getVaccine1ByDate(java.sql.Date.valueOf(strdate));
									LoadVaccine1(vaccine1s);
								}
							});
						} else {
							JOptionPane.showMessageDialog(null,
									"นิสิตรหัส " + r.getTbStudent().getSid() + " ลงทะเบียนแล้ว");
						}
					} catch (Exception e2) {

					}
				}
				if (tabbedPane_1.getTitleAt(tabbedPane_1.getSelectedIndex()).equals("เข็มที่ 2")) {
					try {
						int id = (Integer) table_vaccine2.getValueAt(table_vaccine2.getSelectedRow(), 0);
						VaccineFrame frame = new VaccineFrame(service_register, service_vaccine);
						Register r = service_register.getRegisterByRid(id);
						if (r.getTbVaccine3() == null) {
							frame.setRid(id);
							frame.setVaccineTable(2);
							frame.setVisible(true);
							frame.addWindowListener(new WindowAdapter() {
								@Override
								public void windowClosed(WindowEvent e) {
									String strdate = setFormatDate(dateChooser);
									List<Vaccine2> vaccine2s = service_vaccine
											.getVaccine2ByDate(java.sql.Date.valueOf(strdate));
									LoadVaccine2(vaccine2s);
								}
							});
						} else {
							JOptionPane.showMessageDialog(null,
									"นิสิตรหัส " + r.getTbStudent().getSid() + " ลงทะเบียนแล้ว");
						}
					} catch (Exception e2) {

					}
				}
				if (tabbedPane_1.getTitleAt(tabbedPane_1.getSelectedIndex()).equals("เข็มที่ 3")) {
					try {
						int id = (Integer) table_vaccine3.getValueAt(table_vaccine3.getSelectedRow(), 0);
						VaccineFrame frame = new VaccineFrame(service_register, service_vaccine);
						Register r = service_register.getRegisterByRid(id);
						if (r.getTbVaccine3() != null) {
							frame.setRid(id);
							frame.setVaccineTable(3);
							frame.setVisible(true);
							frame.addWindowListener(new WindowAdapter() {
								@Override
								public void windowClosed(WindowEvent e) {
									String strdate = setFormatDate(dateChooser);
									List<Vaccine3> vaccine3s = service_vaccine
											.getVaccine3ByDate(java.sql.Date.valueOf(strdate));
									LoadVaccine3(vaccine3s);
								}
							});
						} else {
							JOptionPane.showMessageDialog(null,
									"นิสิตรหัส " + r.getTbStudent().getSid() + " ลงทะเบียนแล้ว");
						}
					} catch (Exception e2) {

					}
				}

			}
		});
		btnNewButton_3_1_1.setBackground(new Color(0, 204, 51));
		btnNewButton_3_1_1.setBounds(725, 547, 89, 23);
		panel_vaccine.add(btnNewButton_3_1_1);

		JButton btn_manage = new JButton("จัดการ");
		btn_manage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = (Integer) table_allvaccine.getValueAt(table_allvaccine.getSelectedRow(), 0);
					ManageVaccineFrame manage = new ManageVaccineFrame(service_register, service_vaccine);
					Register r = service_register.getRegisterByRid(id);
					if (r.getTbVaccine1() != null) {
						manage.setRid(id);
						manage.setVisible(true);
						manage.addWindowListener(new WindowAdapter() {
							@Override
							public void windowClosed(WindowEvent e) {
								Filter();
							}
						});
					} else {
						JOptionPane.showMessageDialog(null,
								"นิสิตรหัส " + r.getTbStudent().getSid() + " ไม่มีข้อมูลวัคซีน");
					}
				} catch (Exception e2) {

				}

			}
		});
		btn_manage.setBackground(new Color(255, 255, 51));
		btn_manage.setBounds(626, 547, 89, 23);
		panel_vaccine.add(btn_manage);

		tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (panel != null) {
					panel.setVisible(false);
					tfVaccine.setText("");
				}
				if (tabbedPane_1.getTitleAt(tabbedPane_1.getSelectedIndex()).equals("รายชื่อลงทะเบียน")) {
					if (service_register != null) {
						panel.setVisible(true);
						Filter();
					}
					btn_manage.setVisible(true);
				}
				if (tabbedPane_1.getTitleAt(tabbedPane_1.getSelectedIndex()).equals("เข็มที่ 1")) {
					btn_manage.setVisible(false);
					String strdate = setFormatDate(dateChooser);
					List<Vaccine1> vaccine1s = service_vaccine.getVaccine1ByDate(java.sql.Date.valueOf(strdate));
					LoadVaccine1(vaccine1s);
				}
				if (tabbedPane_1.getTitleAt(tabbedPane_1.getSelectedIndex()).equals("เข็มที่ 2")) {
					btn_manage.setVisible(false);
					String strdate = setFormatDate(dateChooser);
					List<Vaccine2> vaccine2s = service_vaccine.getVaccine2ByDate(java.sql.Date.valueOf(strdate));
					LoadVaccine2(vaccine2s);
				}
				if (tabbedPane_1.getTitleAt(tabbedPane_1.getSelectedIndex()).equals("เข็มที่ 3")) {
					btn_manage.setVisible(false);
					String strdate = setFormatDate(dateChooser);
					List<Vaccine3> vaccine3s = service_vaccine.getVaccine3ByDate(java.sql.Date.valueOf(strdate));
					LoadVaccine3(vaccine3s);
				}
			}
		});
		tabbedPane_1.setBounds(10, 92, 804, 439);
		panel_vaccine.add(tabbedPane_1);

		JPanel panel_all = new JPanel();
		tabbedPane_1.addTab("รายชื่อลงทะเบียน", null, panel_all, null);
		panel_all.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 799, 411);
		panel_all.add(scrollPane_2);

		table_allvaccine = new JTable();
		scrollPane_2.setViewportView(table_allvaccine);

		JPanel panel_dose1 = new JPanel();
		tabbedPane_1.addTab("เข็มที่ 1", null, panel_dose1, null);
		panel_dose1.setLayout(null);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 0, 799, 411);
		panel_dose1.add(scrollPane_3);

		table_vaccine1 = new JTable();
		scrollPane_3.setViewportView(table_vaccine1);

		JPanel panel_dose2 = new JPanel();
		tabbedPane_1.addTab("เข็มที่ 2", null, panel_dose2, null);
		panel_dose2.setLayout(null);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(0, 0, 799, 411);
		panel_dose2.add(scrollPane_4);

		table_vaccine2 = new JTable();
		scrollPane_4.setViewportView(table_vaccine2);

		JPanel panel_dose3 = new JPanel();
		tabbedPane_1.addTab("เข็มที่ 3", null, panel_dose3, null);
		panel_dose3.setLayout(null);

		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(0, 0, 799, 411);
		panel_dose3.add(scrollPane_5);

		table_vaccine3 = new JTable();
		scrollPane_5.setViewportView(table_vaccine3);

		dateChooser = new JDateChooser();
		dateChooser.setDate(new Date());
		dateChooser.setBounds(10, 59, 119, 20);
		panel_vaccine.add(dateChooser);

		panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(594, 43, 220, 42);
		panel_vaccine.add(panel);
		panel.setLayout(null);

		comboBox = new JComboBox<String>();
		comboBox.setBounds(66, 11, 144, 22);
		panel.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Filter();
			}
		});
		comboBox.setModel(
				new DefaultComboBoxModel<String>(new String[] { "ทั้งหมด", "ลงทะเบียนแล้ว", "ยังไม่ลงทะเบียน" }));

		JLabel lblNewLabel = new JLabel("ตัวกรอง");
		lblNewLabel.setBounds(10, 15, 46, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JPanel panel_report = new JPanel();
		panel_report.setBackground(new Color(224, 255, 255));
		panel_report.setLayout(null);
		panel_card.add(panel_report, "report");

		JLabel lbReport = new JLabel("รายงานข้อมูลการฉีดวัคซีนของนิสิต");
		lbReport.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbReport.setBounds(10, 8, 334, 20);
		panel_report.add(lbReport);

		textField = new JTextField();
		textField.setToolTipText("search");
		textField.setForeground(Color.BLACK);
		textField.setColumns(10);
		textField.setBounds(594, 12, 144, 20);
		panel_report.add(textField);

		JButton btnSearch = new JButton("ค้นหา");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Register> r = service_register.getRegisterByRidOrName(textField.getText());
				LoadReport(r);
			}
		});
		btnSearch.setBounds(740, 11, 74, 23);
		panel_report.add(btnSearch);

		JTabbedPane tabbedPane_1_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1_1.setBounds(10, 92, 804, 478);
		panel_report.add(tabbedPane_1_1);

		JScrollPane scrollPane_6 = new JScrollPane();
		tabbedPane_1_1.addTab("รายชื่อนิสิตฉีดวัคซีน", null, scrollPane_6, null);

		table_report = new JTable();
		table_report.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int selected = table_report.getSelectedRow();
				int rid = (int) table_report.getModel().getValueAt(selected, 0);
				ReportFrame report = new ReportFrame(service_register);
				report.setRid(rid);
				report.setVisible(true);
			}
		});
		scrollPane_6.setViewportView(table_report);
		dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (tabbedPane_1.getTitleAt(tabbedPane_1.getSelectedIndex()).equals("รายชื่อลงทะเบียน")) {
					try {
						String strdate = setFormatDate(dateChooser);
						System.err.println(strdate);
					} catch (NullPointerException e) {
					}
				}
				if (tabbedPane_1.getTitleAt(tabbedPane_1.getSelectedIndex()).equals("เข็มที่ 1")) {
					try {
						String strdate = setFormatDate(dateChooser);
						List<Vaccine1> vaccine1s = service_vaccine.getVaccine1ByDate(java.sql.Date.valueOf(strdate));
						LoadVaccine1(vaccine1s);
					} catch (NullPointerException e) {
					}
				}
				if (tabbedPane_1.getTitleAt(tabbedPane_1.getSelectedIndex()).equals("เข็มที่ 2")) {
					try {
						String strdate = setFormatDate(dateChooser);
						List<Vaccine2> vaccine2s = service_vaccine.getVaccine2ByDate(java.sql.Date.valueOf(strdate));
						LoadVaccine2(vaccine2s);
					} catch (NullPointerException e) {
					}
				}
				if (tabbedPane_1.getTitleAt(tabbedPane_1.getSelectedIndex()).equals("เข็มที่ 3")) {
					try {
						String strdate = setFormatDate(dateChooser);
						List<Vaccine3> vaccine3s = service_vaccine.getVaccine3ByDate(java.sql.Date.valueOf(strdate));
						LoadVaccine3(vaccine3s);
					} catch (NullPointerException e) {
					}
				}
			}
		});

	}

	void LoadDataRegister(List<Register> registers) {

		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "รหัสลงทะเบียน", "รหัสนิสิต", "ชื่อ", "นามสกุล", "เบอร์โทร", "วันที่ลงทะเบียน" };
		model.setColumnIdentifiers(columns);

		for (Register r : registers) {
			Object[] obj = { r.getRid(), r.getTbStudent().getSid(), r.getTbStudent().getFirstname(),
					r.getTbStudent().getLastname(), r.getTbStudent().getMobile(), r.getDate() };
			model.addRow(obj);
		}
		table_register.setModel(model);
	}
	
	void LoadReport(List<Register> registers) {

		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "รหัสลงทะเบียน", "รหัสนิสิต", "ชื่อ", "นามสกุล", "วันที่ลงทะเบียน", "เข็มที่ 1",
				"เข็มที่ 2", "เข็มที่ 3" };
		model.setColumnIdentifiers(columns);

		for (Register r : registers) {
			Object[] obj = { r.getRid(), r.getTbStudent().getSid(), r.getTbStudent().getFirstname(),
					r.getTbStudent().getLastname(), r.getDate(),
					(r.getTbVaccine1() != null) ? r.getTbVaccine1().getTbVaccine().getName() : "",
					(r.getTbVaccine2() != null) ? r.getTbVaccine2().getTbVaccine().getName() : "",
					(r.getTbVaccine3() != null) ? r.getTbVaccine3().getTbVaccine().getName() : "", };
			model.addRow(obj);
		}
		table_report.setModel(model);
	}

	void LoadDataVaccine(List<Register> registers) {

		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "รหัสลงทะเบียน", "รหัสนิสิต", "ชื่อ", "นามสกุล", "วันที่ลงทะเบียน", "เข็มที่ 1",
				"เข็มที่ 2", "เข็มที่ 3" };
		model.setColumnIdentifiers(columns);

		for (Register r : registers) {
			Object[] obj = { r.getRid(), r.getTbStudent().getSid(), r.getTbStudent().getFirstname(),
					r.getTbStudent().getLastname(), r.getDate(),
					(r.getTbVaccine1() != null) ? r.getTbVaccine1().getTbVaccine().getName() : "",
					(r.getTbVaccine2() != null) ? r.getTbVaccine2().getTbVaccine().getName() : "",
					(r.getTbVaccine3() != null) ? r.getTbVaccine3().getTbVaccine().getName() : "", };
			model.addRow(obj);
		}
		table_allvaccine.setModel(model);
	}

	void LoadVaccine1(List<Vaccine1> vaccine1s) {
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "รหัสลงทะเบียน", "รหัสนิสิต", "ชื่อ", "นามสกุล", "เข็มที่ 1", "วันที่ฉีด", "สถานะ" };
		model.setColumnIdentifiers(columns);
		for (Vaccine1 v : vaccine1s) {
			int rid = v.getTbRegister().getRid();
			String sid = v.getTbRegister().getTbStudent().getSid();
			String firstname = v.getTbRegister().getTbStudent().getFirstname();
			String lastname = v.getTbRegister().getTbStudent().getLastname();
			String vaccineType = v.getTbVaccine().getName();
			Date dateVaccine1 = v.getDate();
			String status = v.getStatus();
			if (v.getTbRegister().getTbVaccine2() == null) {
				Object[] obj = { rid, sid, firstname, lastname, vaccineType, dateVaccine1, status };
				model.addRow(obj);
			}
		}
		table_vaccine1.setModel(model);
	}

	void LoadVaccine2(List<Vaccine2> vaccine2s) {

		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "รหัสลงทะเบียน", "รหัสนิสิต", "ชื่อ", "นามสกุล", "เข็มที่ 2", "วันที่ฉีด", "สถานะ" };
		model.setColumnIdentifiers(columns);

		for (Vaccine2 v : vaccine2s) {
			int rid = v.getTbRegister().getRid();
			String sid = v.getTbRegister().getTbStudent().getSid();
			String firstname = v.getTbRegister().getTbStudent().getFirstname();
			String lastname = v.getTbRegister().getTbStudent().getLastname();
			String vaccineType = v.getTbVaccine().getName();
			Date dateVaccine2 = v.getDate();
			String status = v.getStatus();
			if (v.getTbRegister().getTbVaccine3() == null) {
				Object[] obj = { rid, sid, firstname, lastname, vaccineType, dateVaccine2, status };
				model.addRow(obj);
			}
		}
		table_vaccine2.setModel(model);
	}

	void LoadVaccine3(List<Vaccine3> vaccine3s) {

		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "รหัสลงทะเบียน", "รหัสนิสิต", "ชื่อ", "นามสกุล", "เข็มที่ 3", "วันที่ฉีด", "สถานะ" };
		model.setColumnIdentifiers(columns);

		for (Vaccine3 v : vaccine3s) {
			int rid = v.getTbRegister().getRid();
			String sid = v.getTbRegister().getTbStudent().getSid();
			String firstname = v.getTbRegister().getTbStudent().getFirstname();
			String lastname = v.getTbRegister().getTbStudent().getLastname();
			String vaccineType = v.getTbVaccine().getName();
			Date dateVaccine3 = v.getDate();
			String status = v.getStatus();
			if (v.getStatus() == null) {
				Object[] obj = { rid, sid, firstname, lastname, vaccineType, dateVaccine3, status };
				model.addRow(obj);
			}
		}
		table_vaccine3.setModel(model);
	}

	void LoadDataStudent(List<Student> students) {
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "รหัสนิสิต", "ชื่อ", "นามสกุล", "เบอร์โทร", "อีเมล" };
		model.setColumnIdentifiers(columns);
		for (Student s : students) {
			Object[] obj = { s.getSid(), s.getFirstname(), s.getLastname(), s.getMobile(), s.getEmail() };
			model.addRow(obj);
		}
		table_student.setModel(model);
	}

	String setFormatDate(JDateChooser date) {
		if (date.getDate() != null) {
			Date d = date.getDate();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			return dateFormat.format(d);
		} else {
			return "";
		}
	}

	void Filter() {
		if (tabbedPane_1.getTitleAt(tabbedPane_1.getSelectedIndex()).equals("รายชื่อลงทะเบียน")) {
			if (comboBox.getSelectedItem().equals("ทั้งหมด")) {
				List<Register> registers = service_register.getAllRegister();
				LoadDataVaccine(registers);
				// System.err.println("ทั้งหมด");
			}
			if (comboBox.getSelectedItem().equals("ลงทะเบียนแล้ว")) {
				List<Register> registers = service_register.getNotNullVaccine();
				LoadDataVaccine(registers);
				// System.err.println("ลงทะเบียนแล้ว");
			}
			if (comboBox.getSelectedItem().equals("ยังไม่ลงทะเบียน")) {
				List<Register> registers = service_register.getNotVaccine();
				LoadDataVaccine(registers);
				// System.err.println("ยังไม่ลงทะเบียน");
			}
		}
	}
}
