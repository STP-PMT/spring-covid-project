package net.csmsu.covid;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;

import net.csmsu.covid.entity.Register;
import net.csmsu.covid.service.ServiceRegister;

import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ReportFrame extends JFrame {
	@Autowired
	ServiceRegister service_register;

	private JPanel contentPane;
	private JLabel lbSid;
	private JLabel lbDate;
	private JLabel lbFirstname;
	private JLabel lbLastname;
	private JLabel lbEmail;
	private JLabel lbMobile;
	private JLabel lbNameVaccine1;
	private JLabel lbDateVaccine1;
	private JLabel lbStatus1;
	private JLabel lbNameVaccine2;
	private JLabel lbDateVaccine2;
	private JLabel lbStatus2;
	private JLabel lbNameVaccine3;
	private JLabel lbDateVaccine3;
	private JLabel lbStatus3;
	private int rid = -1;

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public ReportFrame(ServiceRegister service_register) {
		this();
		this.service_register = service_register;
	}

	public ReportFrame() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				if (rid != -1) {
					Register r = service_register.getRegisterByRid(rid);
					lbSid.setText(r.getTbStudent().getSid() + "");
					lbDate.setText(r.getDate() + "");
					lbFirstname.setText(r.getTbStudent().getFirstname());
					lbLastname.setText(r.getTbStudent().getLastname());
					lbEmail.setText(r.getTbStudent().getEmail());
					lbMobile.setText(r.getTbStudent().getMobile());
					if (r.getTbVaccine1() != null) {
						lbNameVaccine1.setText(r.getTbVaccine1().getTbVaccine().getName());
						lbDateVaccine1.setText(r.getTbVaccine1().getDate() + "");
						if (r.getTbVaccine1().getStatus() != null) {
							lbStatus1.setText(r.getTbVaccine1().getStatus());
						} else {
							lbStatus1.setText("ยังไม่ฉีด");
						}
					}
					if (r.getTbVaccine2() != null) {
						lbNameVaccine2.setText(r.getTbVaccine2().getTbVaccine().getName());
						lbDateVaccine2.setText(r.getTbVaccine2().getDate() + "");
						if (r.getTbVaccine2().getStatus() != null) {
							lbStatus2.setText(r.getTbVaccine2().getStatus());
						} else {
							lbStatus2.setText("ยังไม่ฉีด");
						}
					}
					if (r.getTbVaccine3() != null) {
						lbNameVaccine3.setText(r.getTbVaccine3().getTbVaccine().getName());
						lbDateVaccine3.setText(r.getTbVaccine3().getDate() + "");
						if (r.getTbVaccine3().getStatus() != null) {
							lbStatus3.setText(r.getTbVaccine3().getStatus());
						} else {
							lbStatus3.setText("ยังไม่ฉีด");
						}
					}
				}
			}
		});
		setTitle("รายงาน");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"D:\\Documents\\Data_warehouse\\Covid vaccination project for students\\covid-project\\src\\asssets\\imgaes\\icon.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 658, 330);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_student = new JPanel();
		panel_student.setBackground(new Color(224, 255, 255));
		panel_student.setBounds(10, 11, 620, 130);
		contentPane.add(panel_student);
		panel_student.setLayout(null);

		JLabel lblNewLabel = new JLabel("รหัสนิสิต");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(43, 38, 56, 21);
		panel_student.add(lblNewLabel);

		lbSid = new JLabel("ไม่มีข้อมูล");
		lbSid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbSid.setBounds(111, 37, 145, 21);
		panel_student.add(lbSid);

		lbDate = new JLabel("ไม่มีข้อมูล");
		lbDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbDate.setBounds(454, 11, 133, 21);
		panel_student.add(lbDate);

		JLabel lblNewLabel_2 = new JLabel("วันที่ลงทะเบียน");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(344, 11, 94, 21);
		panel_student.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("ชื่อ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(43, 66, 49, 21);
		panel_student.add(lblNewLabel_3);

		lbFirstname = new JLabel("ไม่มีข้อมูล");
		lbFirstname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbFirstname.setBounds(112, 67, 144, 21);
		panel_student.add(lbFirstname);

		JLabel lblNewLabel_3_2 = new JLabel("นามสกุล");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2.setBounds(268, 66, 62, 21);
		panel_student.add(lblNewLabel_3_2);

		lbLastname = new JLabel("ไม่มีข้อมูล");
		lbLastname.setHorizontalAlignment(SwingConstants.LEFT);
		lbLastname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbLastname.setBounds(345, 66, 145, 21);
		panel_student.add(lbLastname);

		JLabel lblNewLabel_3_3 = new JLabel("อีเมล");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_3.setBounds(45, 96, 49, 21);
		panel_student.add(lblNewLabel_3_3);

		lbEmail = new JLabel("ไม่มีข้อมูล");
		lbEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lbEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbEmail.setBounds(113, 97, 145, 21);
		panel_student.add(lbEmail);

		JLabel lblNewLabel_3_3_2 = new JLabel("เบอร์โทร");
		lblNewLabel_3_3_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_3_2.setBounds(268, 98, 61, 21);
		panel_student.add(lblNewLabel_3_3_2);

		lbMobile = new JLabel("ไม่มีข้อมูล");
		lbMobile.setHorizontalAlignment(SwingConstants.LEFT);
		lbMobile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbMobile.setBounds(345, 98, 145, 21);
		panel_student.add(lbMobile);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		panel.setBounds(10, 152, 200, 130);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("เข็มที่ 1");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(60, 11, 68, 14);
		panel.add(lblNewLabel_5);

		JLabel lb = new JLabel("ชื่อวัคซีน");
		lb.setHorizontalAlignment(SwingConstants.RIGHT);
		lb.setFont(new Font("Tahoma", Font.BOLD, 11));
		lb.setBounds(10, 47, 46, 14);
		panel.add(lb);

		lbNameVaccine1 = new JLabel("ไม่มีข้อมูล");
		lbNameVaccine1.setBounds(70, 47, 120, 14);
		panel.add(lbNameVaccine1);

		JLabel lblNewLabel_1_3 = new JLabel("วันที่ฉีด");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_3.setBounds(10, 72, 46, 14);
		panel.add(lblNewLabel_1_3);

		lbDateVaccine1 = new JLabel("ไม่มีข้อมูล");
		lbDateVaccine1.setBounds(70, 72, 120, 14);
		panel.add(lbDateVaccine1);

		JLabel lblNewLabel_1_3_1 = new JLabel("สถานะ");
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_3_1.setBounds(10, 97, 46, 14);
		panel.add(lblNewLabel_1_3_1);

		lbStatus1 = new JLabel("ไม่มีข้อมูล");
		lbStatus1.setBounds(70, 97, 120, 14);
		panel.add(lbStatus1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 235));
		panel_1.setBounds(220, 152, 200, 130);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_5_1 = new JLabel("เข็มที่ 2");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5_1.setBounds(60, 11, 68, 14);
		panel_1.add(lblNewLabel_5_1);

		lbNameVaccine2 = new JLabel("ไม่มีข้อมูล");
		lbNameVaccine2.setBounds(70, 47, 120, 14);
		panel_1.add(lbNameVaccine2);

		JLabel lblNewLabel_1_1 = new JLabel("ชื่อวัคซีน");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(10, 47, 46, 14);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_3_2 = new JLabel("วันที่ฉีด");
		lblNewLabel_1_3_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_3_2.setBounds(10, 72, 46, 14);
		panel_1.add(lblNewLabel_1_3_2);

		lbDateVaccine2 = new JLabel("ไม่มีข้อมูล");
		lbDateVaccine2.setBounds(70, 72, 120, 14);
		panel_1.add(lbDateVaccine2);

		lbStatus2 = new JLabel("ไม่มีข้อมูล");
		lbStatus2.setBounds(70, 97, 120, 14);
		panel_1.add(lbStatus2);

		JLabel lblNewLabel_1_3_1_1 = new JLabel("สถานะ");
		lblNewLabel_1_3_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_3_1_1.setBounds(10, 97, 46, 14);
		panel_1.add(lblNewLabel_1_3_1_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(135, 206, 235));
		panel_2.setBounds(430, 152, 200, 130);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_5_2 = new JLabel("เข็มที่ 3");
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5_2.setBounds(60, 11, 68, 14);
		panel_2.add(lblNewLabel_5_2);

		lbNameVaccine3 = new JLabel("ไม่มีข้อมูล");
		lbNameVaccine3.setBounds(70, 47, 120, 14);
		panel_2.add(lbNameVaccine3);

		JLabel lblNewLabel_1_4 = new JLabel("ชื่อวัคซีน");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_4.setBounds(10, 47, 46, 14);
		panel_2.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_3_3 = new JLabel("วันที่ฉีด");
		lblNewLabel_1_3_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_3_3.setBounds(10, 72, 46, 14);
		panel_2.add(lblNewLabel_1_3_3);

		lbDateVaccine3 = new JLabel("ไม่มีข้อมูล");
		lbDateVaccine3.setBounds(70, 72, 120, 14);
		panel_2.add(lbDateVaccine3);

		lbStatus3 = new JLabel("ไม่มีข้อมูล");
		lbStatus3.setBounds(70, 97, 120, 14);
		panel_2.add(lbStatus3);

		JLabel lblNewLabel_1_3_1_2 = new JLabel("สถานะ");
		lblNewLabel_1_3_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_3_1_2.setBounds(10, 97, 46, 14);
		panel_2.add(lblNewLabel_1_3_1_2);
	}
}
