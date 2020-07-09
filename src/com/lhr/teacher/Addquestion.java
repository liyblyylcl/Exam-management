package com.lhr.teacher;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

import java.util.*;
import javax.swing.event.*;

import com.lhr.share.DBConnect;
import com.lhr.share.ImageJPanel;

import java.sql.*;

public class Addquestion extends JFrame implements ActionListener {

	JLabel JL = new JLabel("��ӿ���", JLabel.CENTER);// ʹ���ı�����һ����ǩ����

	JLabel idjl = new JLabel("����ID:"); // ʹ���ı�����һ����ǩ����
	JTextField idjtf = new JTextField(); // ����һ���ı������

	JLabel answerjl = new JLabel("�����:"); // ʹ���ı�����һ����ǩ����
	JTextField answerjtf = new JTextField(); // ����һ���ı������

	JButton JBAdd = new JButton("���"); // ������ť����
	JButton JBNext = new JButton("����");

	JLabel jl = new JLabel("��������:");
	JTextArea examContentjta = new JTextArea(10, 10);

	ImageJPanel jp = new ImageJPanel("lhr_images/202.jpg");

	String sql = ""; // ����һ���ַ���

	// ���ñ�ǩ����ɫ������
	public void setjl(JLabel jl) {

		jl.setForeground(Color.black);
		jl.setFont(new Font("����", Font.BOLD, 15));
	}

	public Addquestion() // ����AddStudent���캯��
	{

		jp.setLayout(null);
		JL.setBounds(100, 30, 200, 40); // ���ñ�ǩ�ĳ�ʼλ��
		jp.add(JL); // ����ǩ��ӵ�����

		idjl.setBounds(80, 80, 200, 20); // ����ѧ�ű�ǩ�ĳ�ʼλ��
		setjl(idjl);
		jp.add(idjl); // ��ѧ�ű�ǩ��ӵ�����
		idjtf.setBounds(160, 80, 150, 20); // �����ı���ĳ�ʼλ��
		jp.add(idjtf); // ���ı�����ӵ�����

		jl.setBounds(80, 120, 100, 20); // ����ѧ�ű�ǩ�ĳ�ʼλ��
		setjl(jl);
		jp.add(jl); // ��ѧ�ű�ǩ��ӵ�����
		examContentjta.setBounds(160, 120, 150, 200); // �����ı���ĳ�ʼλ��
		jp.add(examContentjta); // ���ı�����ӵ�����

		answerjl.setBounds(80, 340, 200, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		setjl(answerjl);
		jp.add(answerjl); // ���༶��ǩ��ӵ�����
		answerjtf.setBounds(160, 340, 150, 20); // �����ı���ĳ�ʼλ��
		jp.add(answerjtf);

		JBAdd.setBounds(110, 380, 70, 20); // ������Ӱ�ť�ĳ�ʼλ��
		jp.add(JBAdd); // ����Ӱ�ť��ӵ�����
		JBAdd.addActionListener(this); // ����ť��Ӽ�����

		JBNext.setBounds(210, 380, 70, 20); // �������ð�ť�ĳ�ʼλ��
		jp.add(JBNext); // �����ð�ť��ӵ�����
		JBNext.addActionListener(this); // ����ť��Ӽ�����

		JL.setForeground(Color.red);// ���ñ�ǩ��ǰ��ɫ
		JL.setFont(new java.awt.Font("�����п�", Font.PLAIN, 25));// ���ñ�ǩ������

		jp.setBounds(500, 200, 450, 500); // ���ô��ڳߴ��С
		jp.setVisible(true); // ���ô��ڵĿɼ���

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == JBAdd)// ����"���"�¼�
		{
			String Sno = idjtf.getText().trim();// ���ı����а������ı������ַ���snumber

			try // �쳣����
			{

				sql = "select ID from matching where ID =" + Sno;
				ResultSet rs = DBConnect.dataBaseConnect().executeQuery(sql);// ȡ�ò�ѯ���
				System.out.println("ȡ�ý��OK��" + rs.hashCode());

				if (rs.next())// �жϽ���Ƿ����
					JOptionPane.showMessageDialog(jp, "������Ѿ�����,�����ظ����!");// ͨ��showMessageDialog()������ӡ��Ϣ
				else {

					sql = "insert into matching (ID,answer) values('" + Sno
							+ "','" + answerjtf.getText().trim() + "')";
					System.out.println("OK");

					int i = DBConnect.dataBaseConnect().executeUpdate(sql); // �����ݿ���и���
					if (i > 0)
						JOptionPane.showMessageDialog(null, "��ӳɹ�!");
					else
						JOptionPane.showMessageDialog(null, "ɾ��ʧ��!");
				}

				DBConnect.dataBaseConnect().close();
			} catch (Exception ee) {
			}

			//���ɿ����ļ�
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(
						"./Informations/" + idjtf.getText() + ".txt"));
				String s = examContentjta.getText();
				bw.write(s);
				bw.flush();// ���������е��ļ�д���ļ���

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		if (e.getSource() == JBNext)// ����"����"�¼�
		{

			idjtf.setText(null);// �����ı���textֵΪnull
			examContentjta.setText(null);
			answerjtf.setText(null);

		}
	}

}
