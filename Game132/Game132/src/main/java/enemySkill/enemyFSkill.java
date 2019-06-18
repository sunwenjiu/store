package enemySkill;

import java.awt.image.BufferedImage;

import mainfinall.Hero;


/**
 * 法师的技能：
 * 风系魔法
 * @author zhouxingyu
 *
 */
public class enemyFSkill extends SuperClassSkillFollow {
	public enemyFSkill(int weight, int height,int x, int y,int x1,int y1) {
		super(175,175,x, y, x1, y1);
		
	}
	private static BufferedImage[] images = {};
	static {
		images = new BufferedImage[8];
		for (int i = 0; i < images.length; i++) {
			images[i] = readImage("image/sk2_"+(i+1)+".png");
		}
	}
	private int index1;
	private int index;
	public void step() {
		x1 = x1+speedXY[0];
		y1 = y1+speedXY[1];
	}
	
	protected BufferedImage getImage() {
		if(isLife()) { 
		index1++;
		if (index1%8==0) {
			index++;
		}
		if (index>=6) {
			index=4;
		}   
		return images[index]; 
		}else if(isDead()) { 
			state = REMOVE;  
		}
		return null; 
	}
	public boolean hit(Hero other) {
		int x1 = (int)this.x1-other.width;  
		int x2 = (int)this.x1+this.width;   
		int y1 = (int)this.y1-other.height; 
		int y2 = (int)this.y1+this.height;  
		int x = other.x;              
		int y = other.y;              
		return x>=x1 && x<=x2 && y>=y1 && y<=y2; 
	}
}
