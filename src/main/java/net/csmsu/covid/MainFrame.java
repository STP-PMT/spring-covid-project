package net.csmsu.covid;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.csmsu.covid.entity.Register;
import net.csmsu.covid.service.ServiceRegister;

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

@Component
public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	
	@Autowired
	ServiceRegister service_register;
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
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 784, 47);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Covid Vaccination Project For Students");
		lblNewLabel.setBounds(10, 11, 279, 25);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.WHITE);
		
		textField = new JTextField();
		textField.setForeground(Color.LIGHT_GRAY);
		textField.setText("ค้นหา");
		textField.setBounds(541, 15, 233, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 204, 255));
		panel_1.setBounds(0, 47, 132, 414);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("รายชื่อนักเรียน");
		btnNewButton.setBounds(10, 11, 112, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ลงทะเบียน");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.err.println(service_register);
				LoadDataRegister();
			}
		});
		btnNewButton_1.setBounds(10, 42, 112, 23);
		panel_1.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(142, 120, 632, 330);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
		
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
		table.setModel(model);
	}

}
