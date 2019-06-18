package com.sunwenjiu.popo;

import java.awt.image.BufferedImage;

public class Hero extends PopoObject {
	private static BufferedImage[] images;
	static {
		System.out.println("英雄图片静态块");
		images = new BufferedImage[12];
		for (int i = 0; i < images.length; i++) {
			images[i]=readImage("self"+i+".png");
		}
		
		
	}
	private  int life;
	private int steep;
	private boolean moveR=false;
	private boolean moveL=false;
	private boolean moveU=false;
	private boolean moveD=false;
	 
	 
	 public Hero() {
		super(100, 100,400,400);
		life = 3;
		steep=5;
	}
	
	 
	public void moveTo(int x ,int y) {
		this.x= x-this.width/2;
		this.y=y-this.height/2;

		
	 }
	public 	void shoot(int x,int y) {
		System.out.println("英雄放泡泡了");
}
	
	@Override
	public void step() {  //移动重写
		// TODO Auto-generated method stub
		
	}


int index =0;
int getIndex=0;
	public BufferedImage getImage() {
		getIndex++;
		if (getIndex%10==0) {
			index++;
		}
		if (index>=4) {
			index=0;
		}
		if (isLife()  ) {
			if (!moveD &&!moveR &&!moveL && !moveU) {
				return images[index];
			}
			if (moveR || moveD) {
				return images[index+8];
			}
			if (moveU || moveL) {
				return images[index+4];
			}
			
		} 

		return null;
	}
	
	//英雄右移
	public void moveRight() {
		x+=steep;
		//x+=100;
		if (x%100==0) {
			//移动改为停止
			moveR=false;
		}
		if (x>=World.WIDTH-100) {
			x=World.WIDTH-100;
			moveR=false;
		}
	}
	
	public void moveMoveRight() {
		moveR=true;
	}
	public boolean getMoveRight() {
		return moveR;
	}
	//左移
	public void moveLeft() {
	x-= steep;
	if (x%100==0) {
		moveL=false;
	}
		//x-=100;
		if (x<=0) {
			x=0;
			moveL=false;
		}
	}
	public void moveMoveLeft() {
		moveL=true;
	}
	public boolean getMoveLeft() {
		return moveL;
	}
	
	//下移
 public void moveDown() {
	 y+=steep;
		if (y%100==0) {
			//移动改为停止
			moveD=false;
		}
	 
	//y+=100;
	if (y>=World.HEIGHT-200) {
		y=World.HEIGHT-200;
		moveD=false;
	}
}
 public void moveMoveDown() {
		moveD=true;
	}
	public boolean getMoveDown() {
		return moveD;
	}
 
 //上移动
public void moveUp() {
	y-=steep;
	if (y%100==0) {
		moveU=false;
	}
	//y-=100;
	if (y<=0) {
		y=0;
		moveU=false;
	}
}
public void moveMoveUp() {
	moveU=true;
}
public boolean getMoveUp() {
	return moveU;
}

//英雄的生命
public int getLife() {
	return life;
}


	public PopoHero shoot() {
		if (!moveD && !moveR && !moveL && !moveU ) {
			 
			PopoHero popo = new PopoHero(this.x,this.y);
			return popo;
		}
		if (moveR) {
			int x1 =(this.x+100)/100*100;
			int y1= this.y/100*100;
			PopoHero popo = new PopoHero(x1,y1);
			return popo;
		}
		if (moveD) {
			int x1 =this.x/100*100;
			int y1= (this.y+100)/100*100;
			PopoHero popo = new PopoHero(x1,y1);
			return popo;
		}
		if (moveL) {
			int x1 =(this.x+100)/100*100-100;
			int y1= this.y/100*100;
			PopoHero popo = new PopoHero(x1,y1);
			return popo;
		}
		if (moveU) {
			int x1 =this.x/100*100;
			int y1= (this.y+100)/100*100-100;
			PopoHero popo = new PopoHero(x1,y1);
			return popo;
		}
		
		
		
		
		return null;
		
	}
/*	public PopoHero shoot() {
		PopoHero popo = new PopoHero(this.x,this.y);
		return popo;
	}*/


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
	
	public void addLife() {
		life++;
	}
	public int geiLife() {
		return life;
		
	}
	public void subtractLife() {
		life--;
	}
	
	
}
