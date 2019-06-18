
package com.sunwenjiu.popo;

import java.awt.image.BufferedImage;







public class BulletEnemy extends PopoObject{
	private static BufferedImage[] images;
	static {
		System.out.println("子弹图片静态块");
		images = new BufferedImage[4];
		for (int i = 0; i < images.length; i++) {
			images[i]=readImage("bulletEnemy"+i+".png");
		}
		
	}
	private int speed;
	
	
	public BulletEnemy( int x, int y) {
		super(100, 100, x, y);
		this.speed = 6;
	}
	
	public 	void shoot(int x,int y) {
		System.out.println("泡泡爆炸后子弹发射了");
	}


	public void step3() { 
		x+=speed;
	}
	public void step2() { 
		x-=speed;
	}
	public void step1() { 
		y-=speed;
	}
	public void step() {  
		
		y+=speed;
		// 数组0-3  向上下,左右
		// 假如 下表为0 就向上  用取余
		
		
		
		
		
		/*
		if (x<=0 || x>=World.WIDTH-this.width) {
			speed*=-1;
		}*/
		
	}
	int index =0;
	public BufferedImage getImage() {
		if (isLife()) {
			return images[index++%images.length];
		} else if(isDead()){
			state = REMOVE;
		}
		return null;
	}

	@Override
	public PopoObject shoot() {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean outOfBounds() {
		return this.y>=World.HEIGHT || y<=-this.y  || x>=World.HEIGHT ||x<=-this.x ;
		
	}

	@Override
	public void step0() {
		// TODO Auto-generated method stub
		
	}
	public boolean hit(PopoObject other) {
		int xl =this.x-other.width+2;
		int xr =this.x+this.width-2;
		int yt = this.y-other.height+2;
		int yd = this.y+this.height-2;
		int x = other.x;
		int y = other.y;
		
		return x>=xl && x<=xr
				&&
				y>=yt  && y<=yd;
		
	}


}
