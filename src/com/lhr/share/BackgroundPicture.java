package com.lhr.share;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BackgroundPicture {

	public static ImageIcon imgBackground;
	public static JLabel background;
	public static JPanel imagePanel;

	public static  void setJFrameBackgroundPicture(JFrame jf, String s) {

		imgBackground = new ImageIcon(s);// ����ͼƬ,
		// ��������ԴͼƬ����һ��ImageIcon������ʵ������ǩ
		background = new JLabel(imgBackground); // �ѱ���ͼƬ���ڱ�ǩjil��
		background.setBounds(0, 0, imgBackground.getIconWidth(), imgBackground
				.getIconHeight());// �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�ĸ�ʽ��ʹ֮�պ�����������
		imagePanel = (JPanel) jf.getContentPane();// �����ݴ���ת��ΪJPanel,�������÷���setOpaque()��ʹ���ݴ���͸��
		imagePanel.setOpaque(false);// �÷���setOpaque()��ʹ���ݴ���͸��
		jf.getLayeredPane().setLayout(null);
		jf.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));// �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����

	}

}
