package enemySkill;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * 远程的技能2：
 * 飞刀
 * 
 *
 */
public class enemyFSkill2 extends SuperClassSkillFollow {

	private int speed;
	public enemyFSkill2(int width,int height, int x, int y,int xhero) {
		super(87, 87,x,y,xhero);
		speed = 3;
		state=3;
	}
	private static BufferedImage[] images = {};
	static {
		images = new BufferedImage[22];
		for (int i = 0; i < images.length; i++) {
			images[i] = readImage("image/sk3_"+(i+1)+".png");
		}
	}
	private int index1;
	private int index;
	public void step() {
		if (left&&isLife()) {
			this.xx-=speed;
		}
		if (!left&&isLife()) {
			this.xx+=speed;
		}
	}
	public void paintObject(Graphics g) {
		g.drawImage(this.getImage(),xx,yy,null);
	}

	protected BufferedImage getImage() {
		index1++;
		if (index1%15==0) {
			index++;
		}
		if (index>3) {
			index=0;
		}
		if (left) {
			//左边攻击
			if (isAction()) {
				if (index==3) {
					state=LIFE;
					
				}
				return images[index+12];
			}
			if (isLife()) {
				return images[index+14];
			}
			if (isDead()) {
				if (index==3) {
					state=REMOVE;
				}
				return images[index+8];

			}
			
		}else {
			//右边攻击
			if (isAction()) {
				if (index==3) {
					state=LIFE;
				}
				return images[index];
			}
			if (isLife()) {
				return images[index+3];
			}
			if (isDead()) {
				if (index==3) {
					state=REMOVE;
				}
				return images[index+18];
			}
		}
		return null; 
	}
}
