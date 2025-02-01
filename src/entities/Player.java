package entities;

import static utilz.Constansts.Directions.DOWN;
import static utilz.Constansts.Directions.LEFT;
import static utilz.Constansts.Directions.RIGHT;
import static utilz.Constansts.Directions.UP;
import static utilz.Constansts.PlayerConstants.GetSpriteAmount;
import static utilz.Constansts.PlayerConstants.IDLE;
import static utilz.Constansts.PlayerConstants.RUNNING;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Player extends Entity{
	private int aniTick, aniIndex, aniSpeed = 15;
	private int playerAction = IDLE;
	private int playerDir = -1;
	private boolean moving =  false;
	private BufferedImage[][] animations;
	public Player(float x, float y) {
		super(x, y);
		loadAnimations();
		
	}

	public void update() {
		updateAnimationTick();
		setAnimation();
		updatePos();
	}
	
	public void render(Graphics g) {
		g.drawImage(animations[playerAction][aniIndex], (int) x, (int) y, 258, 160, null);

	}
	
	public void setDirectiın(int direction) {
		this.playerDir = direction;
		moving = true;
	}
	
	
	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	private void updateAnimationTick() {
		aniTick++;
		if(aniTick >= aniSpeed) {
    		aniTick = 0;
			aniIndex++;
			if(aniIndex>= GetSpriteAmount(playerAction)) {
				aniIndex = 0;
			}
			
		}
		
	}
	
	private void updatePos() {
		if(moving) {
			switch(playerDir) {
			case LEFT:
				x -= 5;
				break;
			case UP:
				y -= 5;
				break;
			case RIGHT:
				x += 5;
				break;
			case DOWN:
				y += 5;
				break;
			}
		}
	}


	private void setAnimation() {
		if(moving)
			playerAction = RUNNING;
		else
			playerAction = IDLE;
	}

	
	
	private void loadAnimations() {
		InputStream is = getClass().getResourceAsStream("/player_sprites.png");
		try {
			BufferedImage img = ImageIO.read(is);
			animations = new BufferedImage[9][6];
			
			for(int j=0; j < animations.length; j++) {
				for(int i = 0; i< animations[0].length; i++) {
					animations[j][i] = img.getSubimage(i*64, j*40, 64, 40);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try { 
				is.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
