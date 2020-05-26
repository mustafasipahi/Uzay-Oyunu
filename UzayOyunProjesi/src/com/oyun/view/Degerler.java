package com.oyun.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Degerler extends JPanel {

	public Degerler() {

		setLayout(new GridLayout(1, 10,1,1));
		setBackground(Color.CYAN);

		JLabel oyuncuJLabeladiJLabel = new JLabel("Oyuncu Adı :  ",JLabel.RIGHT);
		add(oyuncuJLabeladiJLabel);
		JLabel adiJLabel = new JLabel(((String) GirisEkrani.kullaniciBox.getSelectedItem()));
		add(adiJLabel);

		JLabel nickNameJLabel = new JLabel("Nick Name :  ",JLabel.RIGHT);
		add(nickNameJLabel);
		JLabel nickJLabel = new JLabel(GirisEkrani.nickField.getText());
		add(nickJLabel);

		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				JLabel süreJLabel = new JLabel("Geçen Süre :  ",JLabel.RIGHT);
				add(süreJLabel);
				String süre = String.valueOf(Oyun.gecenSure);
				JLabel süreJLabel2 = new JLabel(süre);
				add(süreJLabel2);
				
			}
		});
		thread1.start();
		
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				JLabel atesJLabel = new JLabel("Harcanan Ateş :  ",JLabel.RIGHT);
				add(atesJLabel);
				String ates = String.valueOf(Oyun.harcananAtes);
				JLabel atestoplamJLabel = new JLabel(ates);
				add(atestoplamJLabel);
			}
		});
		thread2.start();
		
		
	}
}
