package main;

import java.awt.Graphics;

import entities.Player;

public class Game implements Runnable{
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private final int FPS_SET = 120;
	private Thread gameThread;
	private final int UPS_SET = 200;
	
	private Player player;
	
	public Game(){
		gamePanel = new GamePanel(this);
		gameWindow = new GameWindow(gamePanel);
		gamePanel.requestFocus();
		initClasses();
		startGameLoop();
	
		
	}
	
	private void initClasses() {
		player = new Player(200, 200);
	}

	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		
		double timePerFrame = 1000000000.0 / FPS_SET;
		double timePerUpdate = 1000000000.0 / UPS_SET;
		long lastFrame =  System.nanoTime();
		
		long previousTime= System.nanoTime();
		
		
		int frames = 0; 
		int updates = 0;
		long lastCheck = System.currentTimeMillis();
		
		double deltaU = 0;
		double deltaF = 0;
		
		while(true) {
			
			long currentTime = System.nanoTime();
			
			deltaU += (currentTime - previousTime) / timePerUpdate;
			deltaF += (currentTime - previousTime) / timePerFrame;
			previousTime = currentTime;
			
			if(deltaU >= 1) {
				update();
				updates++;
				deltaU--;
			}
			
			if(deltaF >= 1) {
				gamePanel.repaint();
				frames++;
				deltaF--;
			}
			
			
			if(System.currentTimeMillis() - lastCheck >= 1000 ) {
				lastCheck  = System.currentTimeMillis();
				System.out.println("fps " + frames + " ups" + updates);
				frames = 0;
				updates = 0;
			}
		
			
		}
		
	}

	private void update() {
		player.update();
	}
	
	public void render(Graphics g) {
		player.render(g);
	}
	
	public Player getPlayer() {
		return player;
	}
}
