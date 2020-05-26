package com.oyun.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Not extends JPanel {

	public Not() {

		setBackground(Color.YELLOW);	

		JLabel notJLabel = new JLabel("Roket Kullanmak Motoru Kitler. Açmak İçin Tekrar Roket Tuşuna Basınız!" + "     (" + "→" + "," + "←" + "," + "↓" + ","+ "↑" + "," + "Cntrl" + "," + "Alt" + ")");
		add(notJLabel);

	}
}
