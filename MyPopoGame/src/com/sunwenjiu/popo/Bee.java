package com.sunwenjiu.popo;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Bee extends PopoObject implements Award{
	private static BufferedImage image;
	static {
		System.out.println("蜜蜂图片静态块");
		image = readImage("bee.png");
		
	}
private int xSpeed;
private int ySpeed;
private int awardType;



public Bee( ) {
	super(100, 100);
	xSpeed = 1;
	ySpeed = 1;
	
	Random rand = new Random();
	awardType = rand.nextInt(2);//0 隐身,1 加生命
}


public void step() { 
	x+=xSpeed;
	//y+=ySpeed;
	if (x<=0 || x>=World.WIDTH-this.width) {
		xSpeed*=-1;
	}
	if (y<=0 || y>=World.HEIGHT-this.height) {
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
public  void step2() {
	x+=xSpeed;
	//y+=ySpeed;
	chusheng++;
	if (x<=0 || x>=World.WIDTH-this.width) {
		xSpeed*=-1;
	}
	
	
}
public void step3() {
	x-=xSpeed;
	//y+=ySpeed;
	chusheng++;
	if (x<=0 || x>=World.WIDTH-this.width) {
		xSpeed*=-1;
	}
}
public  void step0() {
	y+=ySpeed;
	chusheng++;
			if (y<=0 || y>=World.HEIGHT-this.height*2) {
				ySpeed*=-1;
			}
	
}
public  void step1() {
	y-=ySpeed;
	chusheng++;
	if (y<=0 || y>=World.HEIGHT-this.height*2) {
		ySpeed*=-1;
	}
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


public BufferedImage getImage() {
	if (isLife()) {
		return image;
	} else if(isDead()){
		state = REMOVE;
	}
	return null;
}



public int getAwardType() {
	
	return awardType;
}
	
}
