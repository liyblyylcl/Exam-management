package com.lhr.teacher;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.lhr.share.DBConnect;
import com.lhr.share.ImageJPanel;

public class ManageExamQuestions implements ActionListener {

	JLabel JL = new JLabel("�޸Ŀ�����Ϣ", JLabel.CENTER);// ʹ���ı�����һ����ǩ����
	JLabel JLNumber = new JLabel("������Ҫ�޸ĵĿ���ID:");// ʹ���ı�����һ����ǩ����
	JTextField JTNumber = new JTextField();// ����һ���ı������

	JButton JBSet = new JButton("��ѯ");// ������ť����
	JButton JBNext = new JButton("����");
	JButton jb1 = new JButton("�޸�");

	JTextArea resultarea = new JTextArea(100, 100);
	String sql = ""; // ����һ���ַ���

	ImageJPanel jp = new ImageJPanel("lhr_images/207.jpg");
	Statement stm = DBConnect.dataBaseConnect();

	public ManageExamQuestions() // ����SetGrade���캯��
	{

		jp.setLayout(null);// ���ô��ڲ��ֹ�����
		JL.setForeground(Color.red);// ���ñ�ǩ��ǰ��ɫ
		JL.setFont(new java.awt.Font("�����п�", Font.PLAIN, 25));// ���ñ�ǩ������
		JL.setBounds(100, 30, 200, 40);// ���ñ�ǩ�ĳ�ʼλ��
		jp.add(JL);// ����ǩ��ӵ�����

		JLNumber.setBounds(80, 80, 300, 20);// ����ѧ�ű�ǩ�ĳ�ʼλ��
		jp.add(JLNumber);// ��ѧ�ű�ǩ��ӵ�����
		JLNumber.setForeground(Color.GREEN);
		JLNumber.setFont(new Font("����", Font.PLAIN, 15));
		JTNumber.setBounds(260, 80, 80, 20);// �����ı���ĳ�ʼλ��
		jp.add(JTNumber);// ���ı�����ӵ�����

		JBSet.setBounds(65, 120, 70, 20);// //���ò�ѯ��ť�ĳ�ʼλ��
		jp.add(JBSet);// ����ѯ��ť��ӵ�����
		JBSet.addActionListener(this);// ����ť��Ӽ�����
		JBNext.setBounds(175, 120, 70, 20);// �������ð�ť�ĳ�ʼλ��
		jp.add(JBNext);// �����ð�ť��ӵ�����
		JBNext.addActionListener(this);// ����ť��Ӽ�����

		jb1.setBounds(285, 120, 70, 20);// ���÷��ذ�ť�ĳ�ʼλ��
		jp.add(jb1);// �����ذ�ť��ӵ�����
		jb1.addActionListener(this);// ����ť��Ӽ�����

		jp.add(resultarea);
		resultarea.setBounds(60, 180, 300, 300);
		resultarea.setFont(new Font("����", Font.PLAIN, 15));
		resultarea.setForeground(Color.blue);
		resultarea.setEditable(false);
		resultarea.setOpaque(false);
		resultarea.setBorder(BorderFactory.createLineBorder(Color.black));
		jp.add(resultarea);

		jp.setBounds(10, 10, 500, 400);// ���ô��ڳߴ��С
		jp.setLocation(500, 300);
		jp.setVisible(true);// ���ô��ڵĿɼ���

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == JBSet) // ����"��ѯ"�¼�
		{
			String snumber = JTNumber.getText();// ���ı����а������ı������ַ���snumber

			sql = "select * from  matching  where ID=" + snumber;// ������Id����snumber��ѧ����������Ϣ

			try // �쳣����
			{
				
				ResultSet rs = stm.executeQuery(sql);// ȡ�ò�ѯ���
				System.out.println("ȡ�ý��OK��" + rs);
				if (rs.next()) // �жϽ���Ƿ����
				{
					resultarea.setText(" ��ţ�");
					resultarea.append(rs.getString("ID") + "\n" + " �𰸣�");
					resultarea.append(rs.getString("answer") + "\n");

				} else {
					JOptionPane.showMessageDialog(null, "����Ų�����!");
				}
			} catch (Exception ee) {
			}
		}
		if (e.getSource() == JBNext)// ����"����"�¼�
		{
			JTNumber.setText(null);// �����ı���textֵΪnull
			resultarea.setText(null);
		}
		if (e.getSource() == jb1) {
			new xiugaiExamQuestions();

		}
	}

}
