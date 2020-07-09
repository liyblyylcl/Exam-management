package com.lhr.student;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

// 时间线程类
public class CountDown extends Thread {

	JTextField jtf;
	int time;
	boolean flag = true;

	public CountDown(JTextField jtf, int time) {
		this.jtf = jtf;
		this.time = time;

	}

	// run方法
	public void run() {
		while ( time >=0) {
			// 显示所剩时间

			String str = String.format("%02d", (int) time / (60 * 60)) + ":"
					+ String.format("%02d", (int) (time / 60 % 60)) + ":"
					+ String.format("%02d", (int) time % 60);
			jtf.setText(str);

			// 所剩时间减少
			time--;
			if(time==0) {
				JOptionPane.showMessageDialog(null, "时间到，本题结束！");
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
