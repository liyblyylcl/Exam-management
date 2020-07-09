package com.lhr.share;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class PlaceCenter {

	public PlaceCenter(JFrame jf) {

		Dimension displaySize = Toolkit.getDefaultToolkit().getScreenSize(); // �����ʾ����С����
		Dimension frameSize = jf.getSize(); // ��ô��ڴ�С����
		if (frameSize.width > displaySize.width)
			frameSize.width = displaySize.width; // ���ڵĿ�Ȳ��ܴ�����ʾ���Ŀ��
		if (frameSize.height > displaySize.height)
			frameSize.height = displaySize.height; // ���ڵĸ߶Ȳ��ܴ�����ʾ���ĸ߶�
		jf.setLocation((displaySize.width - frameSize.width) / 2,
				(displaySize.height - frameSize.height) / 2); // ���ô��ھ�����ʾ����ʾ
	}

}
