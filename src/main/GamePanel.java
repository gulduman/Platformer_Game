package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;
import static utilz.Constansts.PlayerConstants.*;
import static utilz.Constansts.Directions.*;

public class GamePanel extends JPanel{
	private MouseInputs mouseInputs;
	private Game game;
	
	
	public GamePanel(Game game) {
	
		mouseInputs = new MouseInputs(this);
		this.game = game;
		setPanelSize();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
	}
	
	
	
	private void setPanelSize() {
		Dimension size = new Dimension(1280,800);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
		
	}
	
	
	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		game.render(g);
	}



	public void updateGame() {
	
	}
	



	public Game getGame() {
		return game;
	}
	


	


}
