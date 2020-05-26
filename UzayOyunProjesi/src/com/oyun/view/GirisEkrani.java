package com.oyun.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GirisEkrani extends JFrame{
	
	static JComboBox kullaniciBox = null;
	static JTextField nickField = null;
	
	public GirisEkrani() {
		initPencere();
	}
	
	public void initPencere() {
		JPanel panel = initpanel();
		panel.setBorder(BorderFactory.createTitledBorder("Giriş Ekranı"));
		add(panel);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true);
	}
	
	public JPanel initpanel() {
		
		JPanel panel = new JPanel(new BorderLayout());
		
		JPanel girisJPanel = new JPanel(new GridLayout(2,2));
		JLabel kullaniciJLabel = new JLabel("Kullanıcı Seçiniz : ",JLabel.RIGHT);
		girisJPanel.add(kullaniciJLabel);
		
		ArrayList<String> kisiler = new ArrayList<String>();
		kisiler.add("Galip Sipahi");
		kisiler.add("Zehra Sipahi");
		kisiler.add("Hümeyra Sipahi");
		kisiler.add("Mustafa Sipahi");
		kisiler.add("Abdulkadir Sipahi");
		
		kullaniciBox = new JComboBox(kisiler.toArray());
		girisJPanel.add(kullaniciBox);		
		
		JLabel nickJLabel = new JLabel("Nick Name : ",JLabel.RIGHT);
		girisJPanel.add(nickJLabel);
		nickField = new JTextField(20);
		girisJPanel.add(nickField);
		
		JPanel butonJPanel = new JPanel(new GridLayout(1,2));
		JButton giriButton = new JButton("Giriş");
		butonJPanel.add(giriButton);
		JButton iptalButton = new JButton("İptal");
		butonJPanel.add(iptalButton);
		
		giriButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Hoşgeldin " + kullaniciBox.getSelectedItem() + "\n" +
													 "Kullanıcı Adı : " + nickField.getText());
				setVisible(false);
				
				String tuslar = "\t            -----Kontroller-----" + "\n"
							  + "Yukarı	:    ↑" + "\n"
							  + "Aşağı	:     ↓" + "\n"
							  + "Sağ	:        →" + "\n"
							  + "Sol	:         ←" + "\n"
							  + "Ateş	:     Ctrl" + "\n"
							  + "Roket	:    Alt";
				JOptionPane.showMessageDialog(null, tuslar);
				
				new OyunEkrani("Uzay Oyunu");						
			}
		});
		
		iptalButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
			}
		});
		
		panel.add(girisJPanel,BorderLayout.CENTER);
		panel.add(butonJPanel,BorderLayout.SOUTH);
		return panel;
	}
}
