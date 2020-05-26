package com.oyun.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class OyunEkrani extends JFrame{

	public OyunEkrani(String baslik) {
		
		setLayout(new BorderLayout());
		setTitle(baslik);
		setResizable(false);
		setFocusable(false);
		setSize(800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);		
		
		Oyun oyun = new Oyun();
		oyun.requestFocus(); //Oyun Panele Odaklanmak için
		oyun.addKeyListener(oyun); // Klavye Değerlerini Alabilmek İçin
		oyun.setFocusable(true); //Oyun Paneline Focus Olmak İçin
		oyun.setFocusTraversalKeysEnabled(false);
		
		JPanel altJPanel = new JPanel(new BorderLayout());		
		Degerler degerler = new Degerler();		
		Not not = new Not();
		
		altJPanel.add(degerler,BorderLayout.CENTER);
		altJPanel.add(not,BorderLayout.SOUTH);
		
		add(oyun,BorderLayout.CENTER);
		add(altJPanel,BorderLayout.SOUTH);
		setVisible(true);
	}
}
