package com.lhr.main;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.*;
import javax.swing.*;

import com.lhr.share.PlaceCenter;
import com.lhr.student.Student;
import com.lhr.teacher.TeacherMainJieMian;

public class SDMSlogin extends JFrame implements ActionListener {

	JPanel imagePanel, jp, jp1, jp2;
	JLabel jil, jl1, jl2, jl3, jl4;
	JButton jb1, jb2;
	ImageIcon background, im1;
	public static JTextField jtf;
	JPasswordField jpf;
	JComboBox jc; // ����һ����Ͽ����

	public SDMSlogin() {

		jp = new JPanel();
		jp.setBounds(280, 150, 200, 50);

		jl1 = new JLabel("��  ��  �� ��");
		jl1.setFont(new Font("���Ĳ���", Font.BOLD, 18));
		jl1.setForeground(Color.blue);
		jl1.setBounds(160, 93, 110, 40);

		jl2 = new JLabel("�û����� �� ");
		jl2.setFont(new Font("���Ĳ���", Font.BOLD, 18));
		jl2.setForeground(Color.blue);
		jl2.setBounds(160, 133, 110, 40);

		jl4 = new JLabel("�����֤ ��  ");
		jl4.setFont(new Font("���Ĳ���", Font.BOLD, 18));
		jl4.setForeground(Color.blue);
		jl4.setBounds(160, 173, 110, 40);

		jtf = new JTextField();
		jtf.setBounds(255, 100, 120, 25);
		jpf = new JPasswordField();
		jpf.setBounds(255, 140, 120, 25);
		jpf.setEchoChar('��');
		jc = new JComboBox(); // ����һ����Ͽ����
		jc.setBounds(255, 180, 120, 25); // ������Ͽ�ĳ�ʼλ��

		// ���ñ���ͼƬ
		background = new ImageIcon("lhr_images\\��¼����.jpg");// ����ͼƬ,
		// ��������ԴͼƬ����һ��ImageIcon������ʵ������ǩ
		jil = new JLabel(background); // �ѱ���ͼƬ���ڱ�ǩjil��
		jil.setBounds(0, 0, background.getIconWidth(),
				background.getIconHeight());// �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�ĸ�ʽ��ʹ֮�պ�����������
		imagePanel = (JPanel) this.getContentPane();// �����ݴ���ת��ΪJPanel,
		// �������÷���setOpaque()��ʹ���ݴ���͸��
		imagePanel.setOpaque(false);// �÷���setOpaque()��ʹ���ݴ���͸��

		// ע�����,jb1Ϊ��½
		jb1 = new JButton("��½");
		jb1.addActionListener(this);
		jb1.setBounds(165, 245, 70, 30);
		jb1.setContentAreaFilled(false);
		jb1.setForeground(Color.BLUE);
		jb1.setFont(new Font("����", Font.BOLD, 15));

		// ע�������jb2Ϊȡ��
		jb2 = new JButton("ȡ��");
		jb2.setOpaque(false);
		jb2.addActionListener(this);
		jb2.setBounds(300, 245, 70, 30);
		jb2.setContentAreaFilled(false);
		jb2.setForeground(Color.BLUE);
		jb2.setFont(new Font("����", Font.BOLD, 15));

		imagePanel.add(jl1);
		imagePanel.add(jtf);
		imagePanel.add(jl2);
		imagePanel.add(jpf);
		imagePanel.add(jl4);
		imagePanel.add(jc); // ����Ͽ������ӵ�����
		jc.addItem(new String("ѧ��")); // ����Ͽ��������
		jc.addItem(new String("����Ա"));

		jl3 = new JLabel();
		jl3.add(jb1);
		jl3.add(jb2);
		imagePanel.add(jl3);

		this.getLayeredPane().setLayout(null);
		this.getLayeredPane().add(jil, new Integer(Integer.MIN_VALUE));// �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����

		this.setTitle("���߿��Թ���ϵͳ");
		this.setSize(600, 450);
		this.setResizable(false);
		// new PlaceCenter(this);
		this.setLocationRelativeTo(null);// ���ô��ھ�����ʾ
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) {

		String username = jtf.getText();
		String password = new String(jpf.getPassword());// �������

		if (e.getSource() == jb1) {

			String box = (String) jc.getSelectedItem();// ����ǰ��ѡ����ַ���box

			if (box.equals("����Ա")) {

				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// ������������
					Connection cot = DriverManager
							.getConnection("jdbc:odbc:MS Access Database;DBQ=���ݿ��ļ�\\���Թ���ϵͳ���ݿ�.mdb");// �����ݿ����ӣ�student1Ϊ����Դ����
					Statement stm = cot.createStatement();// �ύ��ѯ
					System.out.println("��������OK�������������ݿ�OK������������������");
					String sql = "select * from AdminInformation  where username= '"
							+ username + "'";
					ResultSet rs = stm.executeQuery(sql);// ȡ�ò�ѯ���

					while (rs.next()) {
						String u = rs.getString("username");
						String p = rs.getString("Password");
						// System.out.println("u :"+u+"---------p :"+p);
						if ((username.equals(u)) && (password.equals(p))) {
							new TeacherMainJieMian();
							this.dispose();
							return;
						}
					}
					JOptionPane.showMessageDialog(this, "�û������������벻��ȷ��");
				} catch (IOException e2) {
					e2.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} else {
				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// ������������
					Connection cot = DriverManager
							.getConnection("jdbc:odbc:MS Access Database;DBQ=���ݿ��ļ�/���Թ���ϵͳ���ݿ�.mdb");// �����ݿ����ӣ�student1Ϊ����Դ����
					Statement stm = cot.createStatement();// �ύ��ѯ
					System.out.println("��������OK�������������ݿ�OK������������������");
					String sql = "select * from  student  where Sno= '"
							+ username + "'";
					ResultSet rs = stm.executeQuery(sql);// ȡ�ò�ѯ���

					while (rs.next()) {
						String u = rs.getString("Sno");
						String p = rs.getString("Password");
						// System.out.println("u :"+u+"---------p :"+p);
						if ((username.equals(u)) && (password.equals(p))) {
							new Student();
							this.dispose();
							return;
						}
					}
					JOptionPane.showMessageDialog(this, "�û������������벻��ȷ��");
				} catch (IOException e2) {
					e2.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		}

		if (e.getSource() == jb2) {
			try {
				new Homepage();
				this.dispose();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws IOException {

		new SDMSlogin();
	}
}
