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
 * @author 李华荣
 * @version 1.0
 * 
 **/
public class TeacherMainJieMian extends JFrame {

	// 定义左边的2个面板
	JPanel studentjp, teacherjp;

	// 分隔窗格
	JSplitPane leftJsplitpane, mainJsplitpane;

	// 考试区的按钮
	JButton addstudentjb, deletestudentjb, xiugaistudentjb, findstudentjb;

	// 教师区的按钮
	JButton addteacherjb, deleteteacherjb, xiugaiteacherjb, findteacherjb;

	// 返回按钮
	JButton returnjb;

	// 右边文本域
	JTextArea textarea;

	/**
	 * ******************** 构造方法 *************************
	 */

	public TeacherMainJieMian() throws IOException {

		final Border border = BorderFactory.createLineBorder(Color.yellow);
		
		// 调用方法设置背景图片
		BackgroundPicture.setJFrameBackgroundPicture(this, "lhr_images\\100.jpg");

		/******************************** 左上面板 *******************************/

		final JPanel jpp = new JPanel();
		jpp.setLayout(null);
		jpp.setOpaque(false);

		studentjp = new JPanel();

		// 设置面板的边框
		studentjp.setBorder(BorderFactory.createTitledBorder(border, "考生信息",
				TitledBorder.CENTER, TitledBorder.TOP, new Font("宋体",
						Font.PLAIN, 15), Color.GREEN));

		studentjp.setOpaque(false);
		studentjp.setBounds(10, 20, 200, 200);
		studentjp.setOpaque(false);
		studentjp.setLayout(new GridLayout(4, 1, 10, 10));

		// *************************** 增加考生按钮 *********************
		addstudentjb = new JButton("增加考生");
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

		// ********************************* 删除考生按钮 **********************
		deletestudentjb = new JButton("删除考生");
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

		// ************************** 修改考生信息 *******************************
		xiugaistudentjb = new JButton("修改信息");
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

		// **************************查询考生信息********************************
		findstudentjb = new JButton("查询考生");
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

		// ***************************添加按钮到左上学生面板*****************
		studentjp.add(addstudentjb);
		studentjp.add(deletestudentjb);
		studentjp.add(xiugaistudentjb);
		studentjp.add(findstudentjb);

		// 添加学生面板到左边面板
		jpp.add(studentjp);

		/************************ 左下面板 *********************/

		JPanel jpp1 = new JPanel();
		jpp1.setLayout(null);
		jpp1.setOpaque(false);

		teacherjp = new JPanel();
		// 设置边框
		teacherjp.setBorder(BorderFactory.createTitledBorder(border, "试题信息",
				TitledBorder.CENTER, TitledBorder.TOP, new Font("宋体",
						Font.PLAIN, 15), Color.GREEN));

		teacherjp.setOpaque(false);
		teacherjp.setLayout(new GridLayout(4, 1, 10, 10));
		teacherjp.setBounds(10, 20, 200, 200);

		// *******************增加试题按钮********************************
		addteacherjb = new JButton("增加考题");
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

		// ************************删除试题按钮***************************
		deleteteacherjb = new JButton("删除考题");
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

		// ************************修改考题按钮***************************
		xiugaiteacherjb = new JButton("修改考题");
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

		// *****************************查询考题按钮*********************
		findteacherjb = new JButton("查询考题");
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

		// ******************* 设置"返回"按钮的属性 ********************
		returnjb = new JButton("返回");
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

		// ******************** 添加按钮 *********************************
		teacherjp.add(addteacherjb);
		teacherjp.add(deleteteacherjb);
		teacherjp.add(xiugaiteacherjb);
		teacherjp.add(findteacherjb);

		jpp1.add(teacherjp);
		jpp1.add(returnjb);

		/******************************** 左边面板 ***********************/

		// ************* 设置左边分隔板为垂直分割，两个面板分别添加到上、下区域****************
		leftJsplitpane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, jpp,
				jpp1);
		leftJsplitpane.setOneTouchExpandable(true);
		leftJsplitpane.setOpaque(false);
		leftJsplitpane.setBorder(null);
		leftJsplitpane.setDividerSize(5);// 设置分隔条的大小
		leftJsplitpane.setDividerLocation(240);// 设置分隔条的位置

		/**************************** 右边面板 ****************************/

		// *****************设置文本域**********
		JTextArea textarea = new JTextArea();
		textarea.setForeground(Color.GREEN);// 设置文本域字体颜色
		Font font1 = new Font("宋体", Font.PLAIN, 13);
		textarea.setFont(font1);
		BufferedReader fis = new BufferedReader(new FileReader(
				"Informations\\操作说明.txt")); // 读取文件
		String s = fis.readLine();
		while (s != null) {

			textarea.append(s + "\n");
			s = fis.readLine();
		}
		textarea.setOpaque(false);
		textarea.setEditable(false); // 控制文本域内容

		/*************************** 主分割面板 *************************************/

		// *************设置分隔板为水平分割，leftJsplitpane和textarea分别添加到左、右区域***********
		mainJsplitpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true);
		mainJsplitpane.setOneTouchExpandable(true);
		mainJsplitpane.add(leftJsplitpane);
		mainJsplitpane.add(textarea);

		mainJsplitpane.setOpaque(false);
		mainJsplitpane.setDividerSize(5);// 设置分隔条的大小
		mainJsplitpane.setDividerLocation(220);

		this.add(mainJsplitpane);

		/**************************** 主窗口属性设置 ******************************/

		this.setSize(646, 560);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		new PlaceCenter(this);// 窗口居中显示
		this.setResizable(false);
		this.setTitle("管理员界面");
		this.setVisible(true);

	}

	/**
	 * *************************此方法设置按钮的属性**************************
	 */

	public void set(Component c) {

		((AbstractButton) c).setContentAreaFilled(false);
		c.setForeground(Color.RED);
		c.setFont(new Font("宋体", Font.BOLD, 20));
		c.setEnabled(false);
	}

	/**
	 * *******************此方法设置鼠标进入指定区域时高亮显示********************
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
	 * 主方法，生成一个实例
	 * 
	 */
	public static void main(String[] args) throws Exception {

		new TeacherMainJieMian();

	}

}
