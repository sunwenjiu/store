package com.sunwenjiu.popo;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;





public class Airbos extends PopoObject implements Enemy{
	private static BufferedImage[] images;
	static {
		System.out.println("小敵機图片静态块");
		images = new BufferedImage[12];
		for (int i = 0; i < images.length; i++) {
			images[i]=readImage("air"+i+".png");
		}
	}
	private 	int xSpeed;
	private int ySpeed;
	private int r;
	private int l;
	private int u;
	private int d;

	public Airbos( ) {
		super(100, 100 );
		xSpeed = 1;
		ySpeed = 2;
		r=0;
		l=0;
		u=0;
		d=0;


	}




	public void AirbosMoveTo(int xSpeed,int ySpeed) {
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
	/*//敌人出生了,可以开始计时了.
	int chushengIndex=0;
	public int chusheng() {
		chushengIndex++;
		if (chushengIndex%100==0) {
			chusheng++;
		}

		return chusheng;
	}*/


	public void step() { 
		x+=xSpeed;
		//y+=ySpeed;
		if (x<=0 || x>=World.WIDTH-this.width) {
			xSpeed*=-1;
		}
		if (y<=0 || y>=World.HEIGHT-this.height) {
			ySpeed*=-1;
		}
		/*	
		if (World.moveFanxiang==0) {
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
	public  void step0() {

		x+=xSpeed;
		chusheng++;
		//y+=ySpeed;
		if (x<=0 || x>=World.WIDTH-this.width) {
			//this.x=World.WIDTH-this.width;
			xSpeed*=-1;
		}
		if (xSpeed>0) {
			r=1;
		}else {
			l=1;
		}



	}
	public void step1() {

		x-=xSpeed;
		//y+=ySpeed;
		chusheng++;
		if (x<=0 || x>=World.WIDTH-this.width) {
			//this.x=0;
			xSpeed*=-1;
		}
		if (xSpeed>0) {
			l=1;
		} else {
			r=1;
		}
	}
	public  void step2() {

		y+=ySpeed;
		chusheng++;
		if (y<=0 || y>=World.HEIGHT-this.height*2) {
			//	this.y=World.HEIGHT-this.height*2;
			ySpeed*=-1;
		}
		if (ySpeed>0) {
			d=1;
		} else {
			u=1;
		}

	}
	public  void step3() {
		
		//u=1;
		y-=ySpeed;
		chusheng++;
		if (y<=0 || y>=World.HEIGHT-this.height*2) {
			//	this.y=0;
			ySpeed*=-1;

		}
		if (ySpeed>0) {
			u=1;
		} else {
			d=1;
		}
	}



	int index = 0;
	int getIndex=0;
	public BufferedImage getImage() {
		getIndex++;
		if (getIndex%10==0) {
			index++;
		}
		if (index>=4) {
			index=0;
		}
		if (isLife()) {
		
			if ((l==1&&u==0&&d==0&&r==0) ||(u==1&&d==0&&r==0&&l==0)) {
				this.l=0;
				this.u=0;
				this.r=0;
				this.d=0;
				return images[index];
				
			}else

			if ((l==0&&u==0&&d==0&&r==1) ||(u==0&&d==1&&r==0&&l==0)) {
				this.l=0;
				this.u=0;
				this.r=0;
				this.d=0;
				return images[index+4];
			}else {
				this.l=0;
				this.u=0;
				this.r=0;
				this.d=0;
				return images[index+4];
			}


		} else if(isDead()) {
			BufferedImage img = images[index+8];
			if (index+8==images.length-1) {
				state =REMOVE;
			}
			return img;
		}

		return null;
	}





	public int getScore() {

		return 1;
	}


}
