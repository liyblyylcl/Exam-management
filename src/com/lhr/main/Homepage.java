package com.lhr.main;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import com.lhr.share.*;
import com.lhr.student.AePlayWave;

public class Homepage extends JFrame implements ActionListener {

	JLabel jl, jl1, background, jl2, jl3;
	JButton jb, jbexit, startjb;
	JPanel jp, jp1, imagePanel;
	ImageIcon imgBackground, im, im1;
	JTextArea textarea;
	static AePlayWave apw;

	/**
	 * ***************************���췽��*************************
	 */
	public Homepage() throws IOException {

		// ******************** ���ñ���ͼƬ ******************//
		BackgroundPicture.setJFrameBackgroundPicture(this,
				"lhr_images\\��ҳ����.jpg");
		
		ImageJPanel  imageJPanel=new ImageJPanel("lhr_images\\��ҳ����.jpg");//���ñ���ͼƬ

		// ���ñ�ǩ
		jl = new JLabel("��ӭ�������Թ���ϵͳ");
		jl.setBounds(270, 300, 600, 50);
		jl.setForeground(Color.blue);
		jl.setFont(new Font("����", Font.BOLD, 40));

		jl1 = new JLabel(
				"Welcome   to   the  examination   management   system " + "!");
		jl1.setFont(new Font("Arial", Font.BOLD, 18));
		jl1.setForeground(Color.red);
		jl1.setBounds(250, 350, 600, 50);

		jl2 = new JLabel("������ѵС�飺Sun��");
		jl2.setFont(new Font("����", Font.BOLD, 25));
		jl2.setForeground(Color.red);
		jl2.setBounds(100, 50, 600, 50);

		// ע�����
		im = new ImageIcon("lhr_images\\1020.gif");
		jb = new JButton(im);
		jb.setSize(im.getIconWidth() - 10, im.getIconHeight());
		jb.setLocation(820, 620);
		jb.setContentAreaFilled(false);
		// jb.setBorderPainted(false);//ȥ����ť�߿�
		jb.addActionListener(this);

		jbexit = new JButton("ֹͣ����");
		jbexit.setBounds(100, 620, 100, 30);
		jbexit.setContentAreaFilled(false);
		jbexit.addActionListener(this);
		jbexit.setFocusable(false);
		jbexit.setForeground(Color.BLUE);
		jbexit.setFont(new Font("����", Font.BOLD, 15));

		startjb = new JButton("��������");
		startjb.setBounds(100, 660, 100, 30);
		startjb.setContentAreaFilled(false);
		startjb.setFocusable(false);//ȡ����ý���
		startjb.addActionListener(this);
		startjb.setForeground(Color.BLUE);
		startjb.setFont(new Font("����", Font.BOLD, 15));

		/******************************* ������ **************************/
		imageJPanel.setLayout(null);
		imageJPanel.add(jl2);
		imageJPanel.add(jl1);
		imageJPanel.add(jb);
		imageJPanel.add(jbexit);
		imageJPanel.add(startjb);
		imageJPanel.add(jl);
		this.add(imageJPanel);

		//************************** ���ô������� ***************************//
		this.setIconImage((new ImageIcon("images\\У��.jpg")).getImage()); // ���ñ���ͼ��
		this.setTitle("���Թ���ϵͳ");
		this.setSize(1000, 750);
		this.setResizable(false);// ���ƴ����С
		this.setLocationRelativeTo(null);//������ʾ

//		new PlaceCenter(this);// ******* ���÷���ʹ���ھ���******//
		

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) throws IOException {

		new Homepage();
		apw = new AePlayWave("./Informations/1.wav");
		apw.start();
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == jb) {

			new SDMSlogin();
			this.dispose();
		}
		if (e.getSource() == jbexit) {
			apw.stop();

		}
		if (e.getSource() == startjb) {
			apw = new AePlayWave("./Informations/1.wav");
			apw.start();

		}

	}

}
