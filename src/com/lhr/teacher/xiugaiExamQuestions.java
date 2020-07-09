package com.lhr.teacher;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.lhr.share.DBConnect;
import com.lhr.share.PlaceCenter;



public class xiugaiExamQuestions extends JFrame implements ActionListener {

	JLabel JL = new JLabel("������޸�", JLabel.CENTER);// ʹ���ı�����һ����ǩ����

	JLabel examIDjl = new JLabel("�����뿼��ID:");// ʹ���ı�����һ����ǩ����
	JTextField examIDjtf = new JTextField();// ����һ���ı������

	JLabel answerjl = new JLabel("��:"); // ʹ���ı�����һ����ǩ����
	JTextField answerjtf = new JTextField();

	JButton JBSet = new JButton("��ѯ");// ������ť����
	JButton JBNext = new JButton("����");
	JButton JBxiugai = new JButton("�޸�");
	JButton jb = new JButton("ȡ��");
	Statement stm = DBConnect.dataBaseConnect();

	public xiugaiExamQuestions() // ����SetGrade���캯��
	{
		this.setTitle("����Ա��������Ϣ�޸�");// ���ô��ڱ���
		this.setLayout(null);// ���ô��ڲ��ֹ�����
		JL.setForeground(Color.red);// ���ñ�ǩ��ǰ��ɫ
		JL.setFont(new java.awt.Font("�����п�", Font.PLAIN, 25));// ���ñ�ǩ������
		JL.setBounds(100, 30, 200, 40);// ���ñ�ǩ�ĳ�ʼλ��
		this.add(JL);// ����ǩ��ӵ�����

		examIDjl.setBounds(100, 80, 100, 20);// ����ѧ�ű�ǩ�ĳ�ʼλ��
		this.add(examIDjl);// ��ѧ�ű�ǩ��ӵ�����
		examIDjtf.setBounds(200, 80, 100, 20);// �����ı���ĳ�ʼλ��
		this.add(examIDjtf);// ���ı�����ӵ�����

		answerjl.setBounds(100, 170, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(answerjl); // ���༶��ǩ��ӵ�����
		answerjtf.setBounds(200, 170, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(answerjtf); // ���ı�����ӵ�����

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
		new PlaceCenter(this);
		this.setVisible(true);// ���ô��ڵĿɼ���
		this.setResizable(false);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == JBSet) // ����"��ѯ"�¼�
		{
			String id = examIDjtf.getText().trim();// ���ı����а������ı������ַ���snumber
			String sql = "select * from matching where ID=" + id;// ������Id����snumber�Ŀ����������Ϣ
			System.out.println("����");
			try // �쳣����
			{
		
				ResultSet rs = stm.executeQuery(sql);// ȡ�ò�ѯ���
				if (rs.next()) // �жϽ���Ƿ����
				{

					answerjtf.setText(rs.getString("answer"));

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
		if (e.getSource() == JBxiugai) // ����"�޸�"�¼�
		{

			try // �쳣����
			{
				
				String snumber = examIDjtf.getText();
				String Dno = answerjtf.getText();

				String sql2 = " update matching set answer = '" + Dno
						+ "'  where ID = " + snumber;

				int n = JOptionPane.showConfirmDialog(this, "��Ҫȷ���޸���?");

				if (n == JOptionPane.YES_OPTION) {

					int n1 = stm.executeUpdate(sql2);// �����ݿ���и���

					if (n1 > 0) {
						JOptionPane.showMessageDialog(this, "�޸ĳɹ�!");// ͨ��showMessageDialog()������ӡ��Ϣ
						examIDjtf.setText(null);// �����ı���textֵΪnull
						answerjtf.setText(null);
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
			examIDjtf.setText(null);// �����ı���textֵΪnull
			answerjtf.setText(null);

		}
		if (e.getSource() == jb)// ����"����"�¼�
		{
			this.setVisible(false);

		}

	}

	public static void main(String args[]) {
		new xiugaiExamQuestions();// ʵ����һ������
	}
}
