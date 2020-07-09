package com.lhr.share;

import java.awt.*;
import javax.swing.*;

/**
 * 
 * ΪJPanel��ӱ���ͼƬ����д���ñ���ͼƬ�������ʵ�����ñ���ͼƬ
 * 
 */

public class ImageJPanel extends JPanel {

	private Image img;
	private String filePath;

	
	/*
	 * ���췽��.����Ĳ�����Image���ļ�·��
	 */
	public ImageJPanel(String filePath) {
		this.img = new ImageIcon(filePath).getImage();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);// ��G ��Image������
	}
}
