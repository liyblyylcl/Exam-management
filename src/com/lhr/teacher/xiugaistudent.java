package com.lhr.teacher;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;
import javax.swing.event.*;

import com.lhr.share.DBConnect;
import com.lhr.share.PlaceCenter;

import java.sql.*;
import java.util.Vector;

public class xiugaistudent extends JFrame implements ActionListener {

	JLabel JL = new JLabel("ѧ����Ϣ�޸�", JLabel.CENTER);// ʹ���ı�����һ����ǩ����

	JLabel JLNumber = new JLabel("������ѧ��:");// ʹ���ı�����һ����ǩ����
	JTextField JTNumber = new JTextField();// ����һ���ı������

	JLabel JLDno = new JLabel("�ɼ�:"); // ʹ���ı�����һ����ǩ����
	JTextField JTDno = new JTextField();

	JButton JBSet = new JButton("��ѯ");// ������ť����
	JButton JBNext = new JButton("����");
	JButton JBxiugai = new JButton("�޸�");
	JButton jb = new JButton("ȡ��");
	Statement stm = DBConnect.dataBaseConnect();

	public xiugaistudent() { // ����SetGrade���캯��

		this.setTitle("����Ա��ѧ����Ϣ�޸�");// ���ô��ڱ���
		this.setLayout(null);// ���ô��ڲ��ֹ�����
		JL.setForeground(Color.red);// ���ñ�ǩ��ǰ��ɫ
		JL.setFont(new java.awt.Font("�����п�", Font.PLAIN, 25));// ���ñ�ǩ������
		JL.setBounds(100, 30, 200, 40);// ���ñ�ǩ�ĳ�ʼλ��
		this.add(JL);// ����ǩ��ӵ�����

		JLNumber.setBounds(100, 80, 100, 20);// ����ѧ�ű�ǩ�ĳ�ʼλ��
		this.add(JLNumber);// ��ѧ�ű�ǩ��ӵ�����
		JTNumber.setBounds(200, 80, 100, 20);// �����ı���ĳ�ʼλ��
		this.add(JTNumber);// ���ı�����ӵ�����

		JLDno.setBounds(100, 170, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLDno); // ���༶��ǩ��ӵ�����
		JTDno.setBounds(200, 170, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTDno); // ���ı�����ӵ�����

		JBSet.setBounds(110, 110, 80, 20);// //���ò�ѯ��ť�ĳ�ʼλ��
		this.add(JBSet);// ����ѯ��ť��ӵ�����
		JBSet.addActionListener(this);// ����ť��Ӽ�����

		JBNext.setBounds(210, 110, 80, 20);// �������ð�ť�ĳ�ʼλ��
		this.add(JBNext);// �����ð�ť��ӵ�����
		JBNext.addActionListener(this);// ����ť��Ӽ�����

		JBxiugai.setBounds(110, 140, 80, 20);// �������ð�ť�ĳ�ʼλ��
		this.add(JBxiugai);// �����ð�ť��ӵ�����
		JBxiugai.addActionListener(this);// ����ť��Ӽ�����

		jb.setBounds(210, 140, 80, 20);// �������ð�ť�ĳ�ʼλ��
		this.add(jb);// �����ð�ť��ӵ�����
		jb.addActionListener(this);// ����ť��Ӽ�����

		ImageIcon im1 = new ImageIcon("images\\У��.jpg");
		this.setIconImage(im1.getImage()); // ���ñ���ͼ��

		this.setBounds(500, 300, 400, 300);// ���ô��ڳߴ��С
		this.setVisible(true);// ���ô��ڵĿɼ���
		new PlaceCenter(this);
		this.setResizable(false);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == JBSet) { // ����"��ѯ"�¼�

			String snumber = JTNumber.getText();// ���ı����а������ı������ַ���snumber
			String sql = "select * from student where Sno='" + snumber + "'";// ������Id����snumber��ѧ����������Ϣ
			System.out.println("����");
			try // �쳣����
			{

				ResultSet rs = stm.executeQuery(sql);// ȡ�ò�ѯ���
				if (rs.next()) // �жϽ���Ƿ����
				{

					JTDno.setText(rs.getString("Grade"));

					int n = stm.executeUpdate(sql);// �����ݿ���и���
					if (n > 0)
						JOptionPane.showMessageDialog(null, "��ѯ�ɹ�!");// ͨ��showMessageDialog()������ӡ��Ϣ
					else
						JOptionPane.showMessageDialog(null, "��ѯʧ��!");
				} else {
					JOptionPane.showMessageDialog(null, "���û�������!");
				}
			} catch (Exception ee) {
			}
		}

		if (e.getSource() == JBxiugai) { // ����"�޸�"�¼�

			// �쳣����
			try {

				String snumber = JTNumber.getText();
				String Dno = JTDno.getText();

				String sql2 = " update student set Grade = '" + Dno
						+ "'  where Sno = '" + snumber + "' ";

				int n = JOptionPane.showConfirmDialog(this, "��Ҫȷ���޸���?");

				if (n == JOptionPane.YES_OPTION) {

					int n1 = stm.executeUpdate(sql2);// �����ݿ���и���

					if (n1 > 0) {
						JOptionPane.showMessageDialog(this, "�޸ĳɹ�!");// ͨ��showMessageDialog()������ӡ��Ϣ
						JTNumber.setText(null);// �����ı���textֵΪnull
						JTDno.setText(null);
					} else
						JOptionPane.showMessageDialog(this, "�޸�ʧ��!");
				} else {
					if (n == JOptionPane.NO_OPTION)
						JOptionPane.showMessageDialog(this, "δִ���޸�!");
				}
			} catch (Exception ee) {
			}
		}
		if (e.getSource() == JBNext)// ����"����"�¼�
		{
			JTNumber.setText(null);// �����ı���textֵΪnull
			JTDno.setText(null);

		}
		if (e.getSource() == jb)// ����"����"�¼�
		{
			this.setVisible(false);

		}

	}

	public static void main(String args[]) {
		new xiugaistudent();// ʵ����һ������
	}
}
