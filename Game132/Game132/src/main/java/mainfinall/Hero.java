package mainfinall;


import java.awt.Graphics;
import java.awt.image.BufferedImage;

import heroskill.GeneralSkill;
import heroskill.Skill_1;


public class Hero extends Person  {
	private static BufferedImage[] rightWaitimages;
	private static BufferedImage[] lefttWaitimages;
	private static BufferedImage[] ringhtRunimages;
	private static BufferedImage[] leftRunimages;
	private static BufferedImage[] attackleftimages;
	private static BufferedImage[] attackrightimages;
	private static BufferedImage[] attackrightreadyimages;

	//锟斤拷图片
	static {
		rightWaitimages = new BufferedImage[4];
		for (int i = 0; i < rightWaitimages.length; i++) {
			rightWaitimages[i] = readImage("image/hero1Rightwait_"+i+".png");
		}

		lefttWaitimages = new BufferedImage[4];
		for (int i = 0; i < lefttWaitimages.length; i++) {
			lefttWaitimages[i] = readImage("image/hero1wait_"+i+".png");
		}

		ringhtRunimages = new BufferedImage[4];
		for (int i = 0; i < ringhtRunimages.length; i++) {
			ringhtRunimages[i] = readImage("image/hero1RMove"+i+".png");
		}

		leftRunimages = new BufferedImage[4];
		for (int i = 0; i < leftRunimages.length; i++) {
			leftRunimages[i] = readImage("image/hero1LMove"+i+".png");
		}

		attackleftimages = new BufferedImage[5];
		for (int i = 0; i < attackleftimages.length; i++) {
			attackleftimages[i] = readImage("image/heroAttackLeft_"+(i+1)+".png");
		}
		attackrightimages = new BufferedImage[5];
		for (int i = 0; i < attackrightimages.length; i++) {
			attackrightimages[i] = readImage("image/heroAttackRight_"+(i+1)+".png");
		}
		attackrightreadyimages = new BufferedImage[6];
		for (int i = 0; i < attackrightreadyimages.length; i++) {
			attackrightreadyimages[i] = readImage("image/heroattackFly_"+(i+1)+".png");
		}

	}
	/*
	 * 锟斤拷锟截ｏ拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷贫锟斤拷锟斤拷约锟斤拷锟斤拷锟叫э拷锟�
	 * 
	 */
	private boolean butterleft = false;//锟斤拷锟斤拷锟斤拷叩目锟斤拷锟�
	private boolean butterright = true;//锟斤拷锟斤拷锟揭边的匡拷锟斤拷
	private boolean butterrun = false;
	private boolean butterrunleft = false;//锟杰诧拷锟侥匡拷锟斤拷
	private boolean butterrunright = false;
	private boolean butterattack = false;//锟斤拷锟斤拷锟侥匡拷锟斤拷
	
	//sunwenjiu
	private int lifeFather=300;
	
	//sunwenjiu-e
	private int life = lifeFather; //锟斤拷
	

	public Hero() {
		super(194, 109,110,300);

	}
	//sunwenjiu world调血
	
	
	//sunwenjiu e
	public void moveUp() {
		butterrun = true;
		if (y>200) {
			y-=1;
		}
		//System.out.println("锟斤拷锟斤拷锟斤拷锟斤拷");
	}
	public void moveDown() {
		butterrun = true;
		if (y<430) {
			y+=1;
		}
		//System.out.println("锟斤拷锟斤拷锟斤拷锟斤拷");
	}
	public void moveLeft() {
		butterrunleft = true;
		if (x>75) {
			x-=2;
		}
		//System.out.println("锟斤拷锟斤拷锟斤拷锟斤拷");
	}
	public void moveRight() {
		butterrunright = true;
		if (x<450) {
			x+=2;
		}
		//System.out.println("锟斤拷锟斤拷锟斤拷锟斤拷");
	}

	//锟斤拷锟斤拷锟斤拷锟酵放碉拷效锟斤拷
	public void offButterleft() 	{butterrunleft 	= false;}
	public void offButterright() 	{butterrunright = false;}
	public void offButterrun() 		{butterrun 		= false;butterrunleft 	= false;butterrunright = false;}
	public void offButteratt() 		{butterattack 	= false;}

	/*
	 * index锟斤拷锟斤拷图片锟斤拷锟斤拷俣鹊募锟绞憋拷锟�
	 */

	private int index5 = 0;
	private int index4 = 0;
	private int index3 = 0;
	private int index2 = 0;
	private int index1 = 0;
	private int index = 0;
	public BufferedImage getImageWaitRight() {
		index1++;
		if (index1%40==0) {
			index++;
		}
		if (index>=4) {
			index=0;
		}
		return rightWaitimages[index];

	}
	public BufferedImage getImageWaitLeft() {
		index1++;
		if (index1%40==0) {
			index++;
		}
		if (index>=4) {
			index=0;
		}
		return lefttWaitimages[index];

	}
	public BufferedImage getImageMoveRight() {

		butterright=true;
		butterrunright = true;
		butterleft=false;
		index2++;
		if (index2%40==0) {
			index++;
		}
		if (index>=4) {
			index=0;
		}
		return ringhtRunimages[index];

	}
	public BufferedImage getImageMoveLeft() {
		butterleft=true;
		butterrunleft = true;
		butterright=false;
		index3++;
		if (index3%40==0) {
			index++;
		}
		if (index>=4) {
			index=0;
		}
		return leftRunimages[index];

	}
	public BufferedImage getImageAttackLeft() {
		butterattack = true;
		index4++;
		if (index4%10==0) {
			index++;
		}
		if (index>=5) {
			index=0;
			butterattack=false;
		}
		return attackleftimages[index];

	}
	
	public BufferedImage getImageAttackRight() {
		butterattack = true;
		index5++;
		if (index5%10==0) {
			index++;
		}
		if (index>=5) {
			index=0;
			butterattack=false;
		}
		return attackrightimages[index];
	}


	public void paintObject(Graphics g) {
		//锟揭癸拷锟斤拷
		if (butterright==true) {
			if (butterattack==true) {
				g.drawImage(this.getImageAttackRight(),this.x,this.y,null);
			}else if (butterrunright==true||butterrun==true) {
				g.drawImage(this.getImageMoveRight(),this.x,this.y,null);
			}else {
				g.drawImage(this.getImageWaitRight(),this.x,this.y,null);//g.drawImage(getImageWaitLeft(), 0, 0, width, height, width,0,0, height, null);
			}
		}else if (butterleft==true) {
			if (butterattack==true) {
				g.drawImage(this.getImageAttackLeft(), this.x,this.y,null);
			}else if (butterrunleft==true||butterrun==true) {
				g.drawImage(this.getImageMoveLeft(),this.x,this.y,null);
			}else {
				g.drawImage(this.getImageWaitLeft(),this.x,this.y,null);
			}
		}
		
	}
	
	public Skill_1 AttS() {
			Skill_1 sk = new Skill_1(this.x+90,this.y-10,butterleft); 
			return sk;
	}
	
	public GeneralSkill Att() {
		int xStep = this.width; 
		int yStep = 10; 
			GeneralSkill gk = new GeneralSkill(this.x+xStep/4,this.y-yStep,butterleft);

			return gk;

		
	}
	@Override
	public void step() {}
	@Override
	protected BufferedImage getImage() {return null;}
	
	//sunwenjiu
	public int getHeroX() {
		return x;
	}
	public int getHeroY() {
		return y;
	}
	
	public int getlifeFather() {
		return lifeFather;
	}
	public int getlife() {
		return life;
	}
	//测试
	public void setLife() {
		life-=4;
	}
	public void setLifeForAirEnemy() {
		life-=2;
		
	}
	public void setLifeForBossEnemy() {
		life-=6;
		
	}
	
	
	//sunwenjiu
	
}
