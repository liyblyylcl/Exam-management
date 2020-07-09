package com.lhr.student;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

// ʱ���߳���
public class CountDown extends Thread {

	JTextField jtf;
	int time;
	boolean flag = true;

	public CountDown(JTextField jtf, int time) {
		this.jtf = jtf;
		this.time = time;

	}

	// run����
	public void run() {
		while ( time >=0) {
			// ��ʾ��ʣʱ��

			String str = String.format("%02d", (int) time / (60 * 60)) + ":"
					+ String.format("%02d", (int) (time / 60 % 60)) + ":"
					+ String.format("%02d", (int) time % 60);
			jtf.setText(str);

			// ��ʣʱ�����
			time--;
			if(time==0) {
				JOptionPane.showMessageDialog(null, "ʱ�䵽�����������");
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
