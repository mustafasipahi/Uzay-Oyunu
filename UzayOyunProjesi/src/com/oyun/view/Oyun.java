package com.oyun.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.oyun.entity.Ates;
import com.oyun.entity.Roket;

public class Oyun extends JPanel implements KeyListener,ActionListener{

	Timer timer = new Timer(5, this);	
	static int harcananAtes = 0;
	static int harcananRoket = 0;
	static int gecenSure = 1;
	
	private BufferedImage image;
	
	private ArrayList<Ates> atesler = new ArrayList<Ates>();
	private ArrayList<Roket> roketler = new ArrayList<Roket>();
	
	private int atesdirY = 1;
	private int topX = 0;
	private int topdirX = 2;
	private int uzaygemisiX = 0;
	private int diruzaygemisiX = 20;	
	
	public Oyun() {
		try {
			image = ImageIO.read(new FileImageInputStream(new File("mekik.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setBackground(Color.BLACK);
		timer.start();
	}
	
	public boolean atesCarp() {
		for(Ates ates : atesler) {
			if (new Rectangle(ates.getX(),ates.getY(),10,10).intersects(new Rectangle(topX,0,15,15))) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean roketCarp() {
		for(Roket roket : roketler) {
			if (new Rectangle(roket.getX(),roket.getY(),10,10).intersects(new Rectangle(topX,0,10,10))) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		gecenSure++;
		g.drawImage(image, uzaygemisiX, 460, 70, 70, this);
		
		g.setColor(Color.RED);
		g.fillOval(topX, 0, 25, 25);
		
		g.setColor(Color.BLUE);
		
		for(Ates ates : atesler) {
			if (ates.getY() <= 0) {
				atesler.remove(ates);
			}
		}
		
		g.setColor(Color.BLUE);
		
		for(Ates ates : atesler) {
			g.fillRect(ates.getX(), ates.getY(), 5, 10);
		}
		
		for(Roket roket : roketler) {
			if (roket.getY() <= 0) {
				roketler.removeAll(roketler);
			}
		}
		
		g.setColor(Color.MAGENTA);
		
		for(Roket roket : roketler) {
			g.fillRect(roket.getX(), roket.getY(), 15, 25);
		}
		gecenSure++;	
	}

	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		super.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int x = e.getKeyCode();
		
		if (x == KeyEvent.VK_RIGHT) {
			if (uzaygemisiX >= 720) {
				uzaygemisiX = 730;
			}else {
				uzaygemisiX += diruzaygemisiX;
			}
			
		}
		else if (x == KeyEvent.VK_LEFT) {
			if (uzaygemisiX <= 3) {
				uzaygemisiX = -8;
			}
			else {
				uzaygemisiX -= diruzaygemisiX;
			}			
		}
		if (x == KeyEvent.VK_CONTROL) {
			atesler.add(new Ates(uzaygemisiX+32, 460));
			harcananAtes ++;
		}
		
		if (x == KeyEvent.VK_ALT) {
			roketler.add(new Roket(uzaygemisiX+29, 460));
			harcananRoket++;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(Ates ates : atesler) {
			ates.setY(ates.getY() - atesdirY);;
		}
		
		for(Roket roket : roketler) {
			roket.setY(roket.getY() - 8);
		}
		
		topX += topdirX;
		
		if (topX > 770) {
			topdirX = -topdirX;
		}
		if (topX < 0) {
			topdirX = -topdirX;
		}
		repaint();	
		
		if (atesCarp()) {
			timer.stop();
			String mesaj = "Tebrikler Kazandınız..\n"
							+ "Harcanan Ateş : " + harcananAtes + "\n"
							+ "Harcanan Roket : " + harcananRoket + "\n"
							+ "Geçen Süre : " + gecenSure/100 + " saniye";
			JOptionPane.showMessageDialog(null, mesaj);
		}
		
		if (roketCarp()) {
			timer.stop();
			String mesaj = "Tebrikler Kazandınız..\n"
							+ "Harcanan Ateş : " + harcananAtes + "\n"
							+ "Harcanan Roket : " + harcananRoket + "\n"
							+ "Geçen Süre : " + gecenSure/100 + " saniye";
			JOptionPane.showMessageDialog(null, mesaj);
			
			
			
			
					
		}
	}

}
