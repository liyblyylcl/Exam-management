package com.lhr.share;

import java.awt.*;
import javax.swing.*;

/**
 * 
 * 为JPanel添加背景图片，重写设置背景图片的面板来实现设置背景图片
 * 
 */

public class ImageJPanel extends JPanel {

	private Image img;
	private String filePath;

	
	/*
	 * 构造方法.传入的参数是Image的文件路径
	 */
	public ImageJPanel(String filePath) {
		this.img = new ImageIcon(filePath).getImage();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);// 用G 把Image画出来
	}
}
