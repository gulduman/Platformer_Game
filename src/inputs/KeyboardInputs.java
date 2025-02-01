package inputs;

import java.awt.event.KeyEvent;
import static utilz.Constansts.Directions.*;
import java.awt.event.KeyListener;

import main.GamePanel;

public class KeyboardInputs implements KeyListener{

	private GamePanel gamePanel;
	public KeyboardInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			gamePanel.getGame().getPlayer().setDirectiın(LEFT);
			break;
		case KeyEvent.VK_UP:
			gamePanel.getGame().getPlayer().setDirectiın(UP);
			break;
		case KeyEvent.VK_DOWN:
			gamePanel.getGame().getPlayer().setDirectiın(DOWN);
			break;
		case KeyEvent.VK_RIGHT:
			gamePanel.getGame().getPlayer().setDirectiın(RIGHT);
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_UP:
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_RIGHT:
			gamePanel.getGame().getPlayer().setMoving(false);
			break;
		}
		
	}
	
	
}
