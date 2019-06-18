package heroskill;

import java.awt.image.BufferedImage;

public class GeneralSkill extends SuperClassSkill {
	private int speed; 
	private boolean left;
	public GeneralSkill(int x,int y,boolean left) {
		super(175, 175,x,y);
		if (left) {
			this.x=x-100;
		}
		speed=3;
		this.left=left;
	}

	private static BufferedImage[] images;

	static {
		images = new BufferedImage[6];
		for (int i = 0; i < images.length; i++) {
			images[i] = readImage("image/heroattrightaction"+(i+1)+".png");
		}

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
		if (isLife()) {
			index1++;
			if (index1%10==0) {
				index++;
			}
			if (index>=3) {
				index=0;
			}
			if (!left) {
				return images[index];
			}else if (left) {
				return images[index+3];
			}
			
		
		return null; //DEAD��REMOVEʱ������null
		}else {
			return null;
		}
		
	}
	public void goDead() {
		//state = REMOVE;  
	}






}




