package heroskill;
/**
 * 英雄的大招
 */
import java.awt.image.BufferedImage;

public class Skill_1 extends SuperClassSkill {
	
	private static BufferedImage[] image;
	private static BufferedImage[] imagearr;
	static {
		image = new BufferedImage[12];
		for (int i = 0; i < image.length; i++) {
			image[i] = readImage("image/heroattackact_"+(i+1)+".png");
		}
		imagearr = new BufferedImage[12];
		for (int i = 0; i < imagearr.length; i++) {
			imagearr[i] = readImage("image/heroattackFly_"+(i+1)+".png");
		}
		
	}
	private int speed; 
	private boolean left;
	public Skill_1(int x,int y,boolean left) {
		super(175, 175,x,y);
		speed=2;
		state=ACTION;
		this.left=left;
	}
	public void step() {
		if (left) {
			x-=speed;
		}
		if (!left) {
			x+=speed;
		}
	}

	private int index;
	private int index1;

	public BufferedImage getImage() {
		if(isAction()) { 
		index1++;
			if (index1%5==0) {
				index++;
			}
			if (index>=5) {
				state=LIFE;
			} 
			if (!left) {
				return image[index];
			}else {
				return image[index+6];
			}
			 
		}else if(isLife()) { 
			index1++;
			if (index1%10==0) {
				index++;
			}
			if (index>=5) {
				index=0;
			}   
			if (!left) {
				return imagearr[index];
			}else {
				return imagearr[index+6];
			}
		}else if(isDead()) { //�����˵�
			state = REMOVE;  //��״̬�޸�ΪREMOVE
		}
		return null; //DEAD��REMOVEʱ������null
	}
	
	


}
