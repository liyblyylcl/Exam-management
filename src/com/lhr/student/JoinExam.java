package com.lhr.student;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.lhr.main.SDMSlogin;

import com.lhr.share.BackgroundPicture;
import com.lhr.share.DBConnect;
import com.lhr.share.PlaceCenter;

public class JoinExam extends JFrame {

	JLabel chengxinjl, thistimejl, remainingtimejl;
	JTextArea examContentTextArea, textarea;
	JPanel jp1, jp2, jp3, jp4;
	JButton submitjb, finishjb, beforejb;
	JButton startjb = new JButton("����ʼ");
	JRadioButton jrb1, jrb2, jrb3, jrb4;
	ButtonGroup bg;
	JTextField jtf1, jtf2;
	String s;
	private int grade;
	static int i;
	CountDown tt2;
	int n = -1;

	/**
	 * ******************���췽��***********************
	 */
	public JoinExam() {

		this.setSize(646, 513);
		this.setLayout(null);

		// ���÷������ñ���ͼƬ
		BackgroundPicture.setJFrameBackgroundPicture(this, "lhr_images\\3.jpg");

		// �߿�
//		Border border = BorderFactory.createLineBorder(Color.BLUE);
		Border border = new LineBorder(Color.BLUE);

		/**************************** �������� **************************/

		chengxinjl = new JLabel("����ſ��ԡ�");
		chengxinjl.setForeground(Color.RED);
		chengxinjl.setFont(new Font("����", Font.BOLD, 20));
		chengxinjl.setBounds(280, 20, 200, 20);
		this.add(chengxinjl);

		/*********************** ��ߣ��ı���,��� ***********************/
		examContentTextArea = new JTextArea(100, 100);
		examContentTextArea.setFont(new Font("����", Font.PLAIN, 15));
		examContentTextArea.setForeground(Color.BLUE);
		examContentTextArea.setEditable(false);
		JScrollPane jsp = new JScrollPane(examContentTextArea);
		jsp.setBounds(15, 50, 400, 350);

		// ���ñ߿�
		jsp.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.BLUE), "��������",
				TitledBorder.CENTER, TitledBorder.TOP, new Font("����",
						Font.PLAIN, 15), Color.GREEN));

		jsp.setOpaque(false);
		this.add(jsp);

		/***************************** ������� ***************************/

		jp2 = new JPanel();
		jp2.setBounds(425, 70, 200, 150);
		jp2.setOpaque(false);

		// ���ñ߿�
		jp2.setBorder(BorderFactory.createTitledBorder(border, "ʱ����",
				TitledBorder.CENTER, TitledBorder.TOP, new Font("����",
						Font.PLAIN, 15), Color.GREEN));

		thistimejl = new JLabel("����ʣ��ʱ��:");
		thistimejl.setForeground(Color.BLUE);

		remainingtimejl = new JLabel("���ο���ʣ��ʱ��:");
		remainingtimejl.setForeground(Color.BLUE);

		jtf1 = new JTextField(15);
		jtf1.setFont(new Font("����", Font.BOLD, 15));
		jtf1.setForeground(Color.YELLOW);
		jtf1.setHorizontalAlignment(JTextField.CENTER);// �ı������ݾ�����ʾ
		jtf1.setOpaque(false);
		jtf1.setEditable(false);

		jtf2 = new JTextField(15);
		jtf2.setFont(new Font("����", Font.BOLD, 15));
		jtf2.setForeground(Color.YELLOW);
		jtf2.setHorizontalAlignment(JTextField.CENTER);// ���ݾ�����ʾ
		jtf2.setOpaque(false);
		jtf2.setEditable(false);

		jp2.add(thistimejl);
		jp2.add(jtf1);
		jp2.add(remainingtimejl);
		jp2.add(jtf2);

		/******************************* ������� ************************************/

		jp3 = new JPanel();

		jp3.setOpaque(false);
		jp3.setBounds(425, 240, 200, 150);
		jp3.setBorder(BorderFactory.createTitledBorder(border, "������",
				TitledBorder.CENTER, TitledBorder.TOP, new Font("����",
						Font.PLAIN, 15), Color.GREEN));

		jrb1 = new JRadioButton("A");
		jrb1.setOpaque(false);

		jrb2 = new JRadioButton("B");
		jrb2.setOpaque(false);

		jrb3 = new JRadioButton("C");
		jrb3.setOpaque(false);

		jrb4 = new JRadioButton("D");
		jrb4.setOpaque(false);

		bg = new ButtonGroup();

		// ***************************�ύ��ť********************************
		submitjb = new JButton("�ύ����");
		submitjb.setContentAreaFilled(false);// ���ð�ť͸��
		submitjb.setForeground(Color.BLUE);
		submitjb.setFont(new Font("����", Font.CENTER_BASELINE, 15));
		submitjb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (jrb1.isSelected()) {
					try {
						confirm(jrb1.getText(), i);// ���÷���������ɼ�
					} catch (Exception e1) {
						e1.printStackTrace();
					}

				} else if (jrb2.isSelected()) {
					try {
						confirm(jrb2.getText(), i);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else if (jrb3.isSelected()) {
					try {
						confirm(jrb3.getText(), i);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else if (jrb4.isSelected()) {
					try {
						confirm(jrb4.getText(), i);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(JoinExam.this,
							"��ѡ��һ��ѡ��,лл��ϣ�");
				}
				bg.clearSelection();// ȡ����ѡ��ť��ѡ��״̬

			}

		});

		// *************************��ʼ��ť**********************************

		startjb.setContentAreaFilled(false);// ���ð�ť͸��
		startjb.setForeground(Color.BLUE);
		startjb.setFont(new Font("����", Font.CENTER_BASELINE, 15));
		startjb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				i++;
				if (i == 1) {
					tt2 = new CountDown(jtf1, 300);
					tt2.start();
					startjb.setText("��һ��");
					CountDown tt1 = new CountDown(jtf2, 1800);// �����߳���
					tt1.start();// �����߳�
				}
				if (i >= 2) {
					tt2.flag = false;
					tt2 = new CountDown(jtf1, 300);
					tt2.start();
				}
				examContentTextArea.setText(null);

				try {
					BufferedReader br = new BufferedReader(new FileReader(
							"Informations\\" + i + ".txt"));
					String s = br.readLine();
					while (s != null) {
						examContentTextArea.append(s + "\n");
						s = br.readLine();
					}
					examContentTextArea.append(br.readLine());
				} catch (FileNotFoundException e0) {

					JOptionPane.showMessageDialog(null, "û������");
					e0.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				startjb.setEnabled(false);

			}

		});

		// *********************************��ɿ��԰�ť*******************************
		finishjb = new JButton("��ɿ���");
		finishjb.setContentAreaFilled(false);// ���ð�ť͸��
		finishjb.setForeground(Color.BLUE);
		finishjb.setFont(new Font("����", Font.CENTER_BASELINE, 15));
		finishjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				examContentTextArea.setText(null);
				try {
					LinkDataBase();// ��ʾ�ɼ�
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "���˳����µ�¼,лл��");
					e.printStackTrace();
				}

			}
		});

		// *****************************���ذ�ť***************************************
		beforejb = new JButton("������");
		beforejb.setContentAreaFilled(false);// ���ð�ť͸��
		beforejb.setForeground(Color.BLUE);
		beforejb.setFont(new Font("����", Font.CENTER_BASELINE, 15));
		beforejb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				try {
					new Student();
					JoinExam.this.dispose();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});

		// **************************������************************************
		bg.add(jrb1);
		bg.add(jrb2);
		bg.add(jrb3);
		bg.add(jrb4);

		jp3.add(jrb1);
		jp3.add(jrb2);
		jp3.add(jrb3);
		jp3.add(jrb4);
		jp3.add(submitjb);
		jp3.add(startjb);
		jp3.add(finishjb);
		jp3.add(beforejb);

		/************************************ ���� *************************/

		this.add(jp3);
		this.add(jp2);

		// ���÷�����ʾ������ʾ
		setTip();

		this.setIconImage(new ImageIcon("lhr_images\\У��.jpg").getImage()); // ���ñ���ͼ��
		this.setTitle("���ڿ���");
		new PlaceCenter(this);// ���÷������ô��ھ���
		this.setResizable(false);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setVisible(true);

	}

	/**
	 * ***************************�÷������ô���С��ʾ*********************
	 */

	public void setTip() {

		// �����ı���
		textarea = new JTextArea();
		textarea.setForeground(Color.black);// �����ı���������ɫ
		Font font1 = new Font("����", Font.PLAIN, 13);
		textarea.setFont(font1);
		textarea.setBounds(15, BackgroundPicture.imgBackground.getIconHeight() - 75,
				BackgroundPicture.imgBackground.getIconWidth(), 100);
		this.add(textarea);

		BufferedReader fis = null;
		String s = null;
		try {

			fis = new BufferedReader(new FileReader("Informations\\tip.txt"));
			s = fis.readLine();

			while (s != null) {
				textarea.append(s + "\n");
				s = fis.readLine();

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		textarea.setOpaque(false);
		textarea.setEditable(false); // �����ı�������
	}

	public static void main(String[] args) throws IOException {

		new JoinExam();
	}

	/**
	 * **********************�������ݿⷽ����ʵ����ʾ�ɼ�����********************
	 */

	public void LinkDataBase() throws Exception {

		String s = SDMSlogin.jtf.getText();// ��õ�¼�û���
		String sql = "select * from student  where Sno= '" + s + "'";
		ResultSet rs = DBConnect.dataBaseConnect().executeQuery(sql);// ȡ�ò�ѯ���

		while (rs.next()) {
			examContentTextArea.setText("��ѧ��: ");
			examContentTextArea.append(rs.getString("Sno") + "\n" + "���ɼ���");
			examContentTextArea.append(rs.getString("Grade") + "\n" + "��������");
			examContentTextArea.append(rs.getString("Sname") + "\n");
		}
		DBConnect.dataBaseConnect().close();
	}

	/**
	 * ************************* ����ɼ��ķ���**********************************
	 */
	public void confirm(String s, int i) throws Exception {

		System.out.println(i);

		n = JOptionPane.showConfirmDialog(JoinExam.this, "��ȷ��ѡ�� " + s + " ?");
		if (n == JOptionPane.YES_OPTION) {

			JOptionPane.showMessageDialog(null, "�ύ�ɹ�!");
			startjb.setEnabled(true);// ����һ����İ�ťΪ�ɼ���

			String sql = "select answer from matching where ID = " + i;
			ResultSet rs = DBConnect.dataBaseConnect().executeQuery(sql);// ȡ�ò�ѯ���

			if (rs.next()) {
				if (rs.getString("answer").equals(s)) {

					grade += 20;
					String sql1 = "update student set Grade = " + grade
							+ "  where Sno = '" + SDMSlogin.jtf.getText() + "'";
					DBConnect.dataBaseConnect().executeUpdate(sql1);// �����ݿ���и���
					System.out.println("�ɼ�����OK");
				}
			}
			DBConnect.dataBaseConnect().close();
		}
	}

}
