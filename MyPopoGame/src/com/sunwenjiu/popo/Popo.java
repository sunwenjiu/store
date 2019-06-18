package com.sunwenjiu.popo;

import java.awt.image.BufferedImage;

public class Popo extends PopoObject {
	private static BufferedImage[] images;
	static {
		System.out.println("泡泡图片静态块");
		images = new BufferedImage[20];
		for (int i = 0; i < images.length; i++) {
			images[i]=readImage("popo"+i+".png");
		}


	}

	


	public Popo( int x, int y) {
		super(100, 100, x, y);
		
	}
	public 	void shoot(int x,int y) {
		System.out.println("泡泡三秒后炸了,子弹发射了");
	}


	public void step() {  //移动重写
		chusheng++;

	}

	int index=0;
	int indexb=16;
	int getIndex=0;
	public BufferedImage getImage() {
		getIndex++;
		if (getIndex%5==0) {
			index++;
		}
		if (index>=16) {
			index=0;
		}
			if (isLife()) {
				return  images[index];
				//return  images[index++%16];//
			}else if (isDead()) {
				BufferedImage img = images[indexb++];
				if (indexb==images.length) {
					state =REMOVE;
				}
				return img;
			}
			
	//	}
		return null;

	}
	
public PopoObject[] popoShoot() {
		
		//Bullet bs = new Bullet(this.x,this.y);
		PopoObject[] bs = new BulletEnemy[4];
			bs[0]=	new BulletEnemy(this.x,this.y);
			bs[1]=	new BulletEnemy(this.x,this.y);
			bs[2]=	new BulletEnemy(this.x,this.y);
			bs[3]=	new BulletEnemy(this.x,this.y);
		
		//System.out.println(x +","+y);
		
		
		return bs;

		
	}
	public PopoObject shoot() {
		
		//Bullet bs = new Bullet(this.x,this.y);
	//	PopoObject[] bs = new Bullet[4];
				//new Bullet(this.x,this.y);
		
		
		//System.out.println(x +","+y);
		
		
		return null;
	
	
		
	}
	@Override
	public void step0() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void step1() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void step2() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void step3() {
		// TODO Auto-generated method stub
		
	}
}
