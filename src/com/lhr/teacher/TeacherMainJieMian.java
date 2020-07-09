package com.lhr.teacher;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.lhr.main.SDMSlogin;
import com.lhr.share.BackgroundPicture;
import com.lhr.share.PlaceCenter;

/**
 * 
 * @author ���
 * @version 1.0
 * 
 **/
public class TeacherMainJieMian extends JFrame {

	// ������ߵ�2�����
	JPanel studentjp, teacherjp;

	// �ָ�����
	JSplitPane leftJsplitpane, mainJsplitpane;

	// �������İ�ť
	JButton addstudentjb, deletestudentjb, xiugaistudentjb, findstudentjb;

	// ��ʦ���İ�ť
	JButton addteacherjb, deleteteacherjb, xiugaiteacherjb, findteacherjb;

	// ���ذ�ť
	JButton returnjb;

	// �ұ��ı���
	JTextArea textarea;

	/**
	 * ******************** ���췽�� *************************
	 */

	public TeacherMainJieMian() throws IOException {

		final Border border = BorderFactory.createLineBorder(Color.yellow);
		
		// ���÷������ñ���ͼƬ
		BackgroundPicture.setJFrameBackgroundPicture(this, "lhr_images\\100.jpg");

		/******************************** ������� *******************************/

		final JPanel jpp = new JPanel();
		jpp.setLayout(null);
		jpp.setOpaque(false);

		studentjp = new JPanel();

		// �������ı߿�
		studentjp.setBorder(BorderFactory.createTitledBorder(border, "������Ϣ",
				TitledBorder.CENTER, TitledBorder.TOP, new Font("����",
						Font.PLAIN, 15), Color.GREEN));

		studentjp.setOpaque(false);
		studentjp.setBounds(10, 20, 200, 200);
		studentjp.setOpaque(false);
		studentjp.setLayout(new GridLayout(4, 1, 10, 10));

		// *************************** ���ӿ�����ť *********************
		addstudentjb = new JButton("���ӿ���");
		set(addstudentjb);
		enterAndExit(addstudentjb);
		addstudentjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				AddStudent ta = new AddStudent();
				ta.jp.setOpaque(false);

				mainJsplitpane.remove(2);
				mainJsplitpane.add(ta.jp, 2);
				mainJsplitpane.setDividerLocation(220);
			}
		});

		// ********************************* ɾ��������ť **********************
		deletestudentjb = new JButton("ɾ������");
		set(deletestudentjb);
		enterAndExit(deletestudentjb);
		deletestudentjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				DeleteStudent t = new DeleteStudent();
				t.jp.setOpaque(false);

				mainJsplitpane.remove(2);
				mainJsplitpane.add(t.jp, 2);
				mainJsplitpane.setDividerLocation(220);

			}
		});

		// ************************** �޸Ŀ�����Ϣ *******************************
		xiugaistudentjb = new JButton("�޸���Ϣ");
		set(xiugaistudentjb);
		enterAndExit(xiugaistudentjb);
		xiugaistudentjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ManageStudent t = new ManageStudent();
				t.jp.setOpaque(false);

				mainJsplitpane.remove(2);
				mainJsplitpane.add(t.jp, 2);
				mainJsplitpane.setDividerLocation(220);

			}
		});

		// **************************��ѯ������Ϣ********************************
		findstudentjb = new JButton("��ѯ����");
		set(findstudentjb);
		enterAndExit(findstudentjb);
		findstudentjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				FindStudent t = new FindStudent();
				t.jp.setOpaque(false);

				mainJsplitpane.remove(2);
				mainJsplitpane.add(t.jp, 2);
				mainJsplitpane.setDividerLocation(220);

			}
		});

		// ***************************��Ӱ�ť������ѧ�����*****************
		studentjp.add(addstudentjb);
		studentjp.add(deletestudentjb);
		studentjp.add(xiugaistudentjb);
		studentjp.add(findstudentjb);

		// ���ѧ����嵽������
		jpp.add(studentjp);

		/************************ ������� *********************/

		JPanel jpp1 = new JPanel();
		jpp1.setLayout(null);
		jpp1.setOpaque(false);

		teacherjp = new JPanel();
		// ���ñ߿�
		teacherjp.setBorder(BorderFactory.createTitledBorder(border, "������Ϣ",
				TitledBorder.CENTER, TitledBorder.TOP, new Font("����",
						Font.PLAIN, 15), Color.GREEN));

		teacherjp.setOpaque(false);
		teacherjp.setLayout(new GridLayout(4, 1, 10, 10));
		teacherjp.setBounds(10, 20, 200, 200);

		// *******************�������ⰴť********************************
		addteacherjb = new JButton("���ӿ���");
		set(addteacherjb);
		enterAndExit(addteacherjb);
		addteacherjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Addquestion tAddquestion = new Addquestion();
				tAddquestion.jp.setOpaque(false);

				mainJsplitpane.remove(2);
				mainJsplitpane.add(tAddquestion.jp, 2);
				mainJsplitpane.setDividerLocation(220);

			}
		});

		// ************************ɾ�����ⰴť***************************
		deleteteacherjb = new JButton("ɾ������");
		set(deleteteacherjb);
		enterAndExit(deleteteacherjb);
		deleteteacherjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				DeleteExamQuestions deleteExamQuestions = new DeleteExamQuestions();
				deleteExamQuestions.jp.setOpaque(false);

				mainJsplitpane.remove(2);
				mainJsplitpane.add(deleteExamQuestions.jp, 2);
				mainJsplitpane.setDividerLocation(220);

			}
		});

		// ************************�޸Ŀ��ⰴť***************************
		xiugaiteacherjb = new JButton("�޸Ŀ���");
		set(xiugaiteacherjb);
		enterAndExit(xiugaiteacherjb);
		xiugaiteacherjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ManageExamQuestions manageExamQuestions = new ManageExamQuestions();
				manageExamQuestions.jp.setOpaque(false);

				mainJsplitpane.remove(2);
				mainJsplitpane.add(manageExamQuestions.jp, 2);
				mainJsplitpane.setDividerLocation(220);

			}
		});

		// *****************************��ѯ���ⰴť*********************
		findteacherjb = new JButton("��ѯ����");
		set(findteacherjb);
		enterAndExit(findteacherjb);
		findteacherjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				FindExamQuestions findExamQuestions = new FindExamQuestions();
				findExamQuestions.jp.setOpaque(false);

				mainJsplitpane.remove(2);
				mainJsplitpane.add(findExamQuestions.jp, 2);
				mainJsplitpane.setDividerLocation(220);

			}
		});

		// ******************* ����"����"��ť������ ********************
		returnjb = new JButton("����");
		set(returnjb);
		returnjb.setBorder(border);
		returnjb.setBounds(13, 230, 195, 40);
		enterAndExit(returnjb);
		returnjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				new SDMSlogin();
				TeacherMainJieMian.this.setVisible(false);
			}
		});

		// ******************** ��Ӱ�ť *********************************
		teacherjp.add(addteacherjb);
		teacherjp.add(deleteteacherjb);
		teacherjp.add(xiugaiteacherjb);
		teacherjp.add(findteacherjb);

		jpp1.add(teacherjp);
		jpp1.add(returnjb);

		/******************************** ������ ***********************/

		// ************* ������߷ָ���Ϊ��ֱ�ָ�������ֱ���ӵ��ϡ�������****************
		leftJsplitpane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, jpp,
				jpp1);
		leftJsplitpane.setOneTouchExpandable(true);
		leftJsplitpane.setOpaque(false);
		leftJsplitpane.setBorder(null);
		leftJsplitpane.setDividerSize(5);// ���÷ָ����Ĵ�С
		leftJsplitpane.setDividerLocation(240);// ���÷ָ�����λ��

		/**************************** �ұ���� ****************************/

		// *****************�����ı���**********
		JTextArea textarea = new JTextArea();
		textarea.setForeground(Color.GREEN);// �����ı���������ɫ
		Font font1 = new Font("����", Font.PLAIN, 13);
		textarea.setFont(font1);
		BufferedReader fis = new BufferedReader(new FileReader(
				"Informations\\����˵��.txt")); // ��ȡ�ļ�
		String s = fis.readLine();
		while (s != null) {

			textarea.append(s + "\n");
			s = fis.readLine();
		}
		textarea.setOpaque(false);
		textarea.setEditable(false); // �����ı�������

		/*************************** ���ָ���� *************************************/

		// *************���÷ָ���Ϊˮƽ�ָleftJsplitpane��textarea�ֱ���ӵ���������***********
		mainJsplitpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true);
		mainJsplitpane.setOneTouchExpandable(true);
		mainJsplitpane.add(leftJsplitpane);
		mainJsplitpane.add(textarea);

		mainJsplitpane.setOpaque(false);
		mainJsplitpane.setDividerSize(5);// ���÷ָ����Ĵ�С
		mainJsplitpane.setDividerLocation(220);

		this.add(mainJsplitpane);

		/**************************** �������������� ******************************/

		this.setSize(646, 560);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		new PlaceCenter(this);// ���ھ�����ʾ
		this.setResizable(false);
		this.setTitle("����Ա����");
		this.setVisible(true);

	}

	/**
	 * *************************�˷������ð�ť������**************************
	 */

	public void set(Component c) {

		((AbstractButton) c).setContentAreaFilled(false);
		c.setForeground(Color.RED);
		c.setFont(new Font("����", Font.BOLD, 20));
		c.setEnabled(false);
	}

	/**
	 * *******************�˷�������������ָ������ʱ������ʾ********************
	 */

	public void enterAndExit(final JButton jb) {

		jb.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				jb.setEnabled(false);

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				jb.setEnabled(true);

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
	}

	/**
	 * 
	 * ������������һ��ʵ��
	 * 
	 */
	public static void main(String[] args) throws Exception {

		new TeacherMainJieMian();

	}

}
