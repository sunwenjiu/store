package com.sunwenjiu.popo;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Bigbos extends PopoObject implements Enemy{
	private static BufferedImage[] images;
	static {
		System.out.println("大敌机图片静态块");
		images = new BufferedImage[8];
		for (int i = 0; i < images.length; i++) {
			images[i]=readImage("big"+i+".png");
		}
		
		
	}
private 	int xSpeed;
	private int ySpeed;
	

	
	public Bigbos(  ) {
		
		super(100, 100);
		this.xSpeed = 1;
		this.ySpeed = 1;
	}
	/*andom rand =new Random();
	int type =rand.nextInt(9);
	int type1 =rand.nextInt(9);
	
	int[] xCS=zuobiao();
	
	int yCS=zuobiao[type];*/
	

	public void BigbosMoveTo(int xSpeed,int ySpeed) {
		this.xSpeed =xSpeed;
		this.ySpeed = ySpeed;
	}
	
	public Popo shoot() {
		
		//System.out.println("小敌人放泡泡了");
		
	
		//System.out.println(x +","+y);
	//Bullet[] buts = new Bullet(this.x, this.y);
	/*Bullet[] buts= new  Bullet[4];
		buts[0]= new Bullet(this.x, this.y);
		buts[1]= new Bullet(this.x, this.y);
		buts[2]= new Bullet(this.x, this.y);
		buts[3]= new Bullet(this.x, this.y);*/
		
		
	//return buts;
	Popo popo = new Popo(this.x,this.y);
		return popo;
	
	
}
	
	public void step() { 
		//x+=xSpeed;
		y+=ySpeed;
		if (x<=0 || x>=World.WIDTH-this.width) {
			xSpeed*=-1;
		}
		if (y<=0 || y>=World.HEIGHT-this.height*2) {
			ySpeed*=-1;
		}
		
		/*if (World.moveFanxiang==0) {
			x++;
		}
		if (World.moveFanxiang==1) {
			x--;
		}
		if (World.moveFanxiang==2) {
			y++;
		}
		if (World.moveFanxiang==3) {
			y--;
		}
*/
	}
	public  void step1() {
		x+=xSpeed;
		//y+=ySpeed;
		chusheng++;
		if (x<=0 || x>=World.WIDTH-this.width) {
			xSpeed*=-1;
		}
		
		
	}
	public void step2() {
		x-=xSpeed;
		//y+=ySpeed;
		chusheng++;
		if (x<=0 || x>=World.WIDTH-this.width) {
			xSpeed*=-1;
		}
	}
	public  void step3() {
		y+=ySpeed;
		chusheng++;
				if (y<=0 || y>=World.HEIGHT-this.height*2) {
					ySpeed*=-1;
				}
		
	}
	public  void step0() {
		y-=ySpeed;
		chusheng++;
		if (y<=0 || y>=World.HEIGHT-this.height*2) {
			ySpeed*=-1;
		}
	}
	

	
	int index = 0;
	int index2=4;
	public BufferedImage getImage() {
		if (isLife()) {
			return images[index++%4];
		} else if(isDead()) {
			BufferedImage img = images[index2++];
			if (index2==images.length) {
				state =REMOVE;
			}
			return img;
		}

		return null;
	}

	public int getScore() {

		return 3;
	}
	

}
