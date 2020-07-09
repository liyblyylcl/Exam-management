package com.lhr.student;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


import com.lhr.main.SDMSlogin;
import com.lhr.share.ImageJPanel;
import com.lhr.share.PlaceCenter;

public class Student extends JFrame {

	JLabel jl;
	JButton jb1, jb2, jb3;
	JPanel jp1;
	ImageIcon im, im1, im2;

	public Student() throws IOException {

		// **************** ���÷������ñ���ͼƬ *********************
		ImageJPanel jp = new ImageJPanel("lhr_images/1.jpg");	
		jp.setLayout(null);

		// ********************* ���ñ�ǩ **************************
		jl = new JLabel("��ӭ�������߿���ϵͳ");
		jl.setBounds(180, 0, 500, 100);
		jl.setForeground(Color.RED);
		jl.setFont(new Font("������Բ", Font.BOLD, 30));

		// *********************** �μӿ��԰�ť ********************
		im = new ImageIcon("lhr_images\\�μӿ���.gif");
		jb1 = new JButton(im);
		jb1.setBounds(270, 400, im.getIconWidth(), im.getIconHeight());
		jb1.setToolTipText("����������߿���ϵͳ");
		jb1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				new JoinExam();
				Student.this.dispose();

			}
		});

		// *********************** ��ѯ������ť ********************
		im2 = new ImageIcon("lhr_images\\��ѯ����.gif");
		jb2 = new JButton(im2);
		jb2.setBounds(270, 450, im2.getIconWidth(), im2.getIconHeight());
		jb2.setToolTipText("������Բ�ѯ�����ĳɼ�");
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new QueryGrade();
				Student.this.dispose();

			}
		});

		// ***************** ���ذ�ť *************************
		jb3 = new JButton(new ImageIcon("lhr_images\\1168.gif"));
		jb3.setContentAreaFilled(false);
		jb3.setBounds(570, 450, 100, 45);
		jb3.setToolTipText("������Է��ص���һҳ");
		jb3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new SDMSlogin();
				Student.this.dispose();

			}
		});

		// ******************** ������ *************************
		jp.add(jl);
		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);
		this.add(jp);

		// ********************** ����jframe������ ******************
		this.setIconImage((new ImageIcon("lhr_images\\У��.jpg")).getImage()); // ���ñ���ͼ��
		this.setTitle("����ϵͳ");
		
		this.setSize(700,550);
		this.setResizable(false);// ���ƴ����С
		this.setLocationRelativeTo(null);//������ʾ
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/*
	 * *************** ������ ****************************
	 */
	public static void main(String[] args) throws IOException {

		new Student();
	}

}
