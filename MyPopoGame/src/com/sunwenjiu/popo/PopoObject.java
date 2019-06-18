package com.sunwenjiu.popo;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;



public abstract class PopoObject {
	public static final int LIFE =0;
	public static final int DEAD = 1;
	public static final int REMOVE = 2;
	protected int state = LIFE;
	
	protected int width;
	protected int height;
	protected int x;
	protected int y;
	protected int chusheng=1;

	public PopoObject(int width, int height, int x, int y) {
		//英雄,小敌,
		this.width = width;
		this.height = height;
	
		this.x = x;
		this.y =y;
	}

	
	public PopoObject(int width, int height) {
		//敌人,铁,木
		this.width = width;
		this.height = height;
		
		int[] xCS=zuobiao();
		Random rand =new Random();
		int type =rand.nextInt(6)+1;//在最后一个会卡着不动了,试试不到最后一格
		int type1 =rand.nextInt(6)+1;
		this.x = xCS[type];
		this.y =xCS[type1] ;
		
	}

	public PopoObject() {
		// TODO Auto-generated constructor stub
	}

public abstract void step();//移动入口
public abstract void step0();
public abstract void step1();
public abstract void step2();
public abstract void step3();
	
//射击  
	public abstract 	PopoObject shoot() ;
	//泡泡射击
public PopoObject[] popoShoot() {
		
		//Bullet bs = new Bullet(this.x,this.y);
		PopoObject[] bs = new Bullet[4];
			bs[0]=	new Bullet(this.x,this.y);
			bs[1]=	new Bullet(this.x,this.y);
			bs[2]=	new Bullet(this.x,this.y);
			bs[3]=	new Bullet(this.x,this.y);
		
		//System.out.println(x +","+y);
		
		
		return bs;

		
	}
		
	//敌人出生了,可以开始计时了.
		int chushengIndex=0;
		public int chusheng() {
			chushengIndex++;
			if (chushengIndex%1000==0) {
				chusheng++;
			}
			System.out.println("出生:"+chusheng);
			return chusheng;
		}

	// 加100的排列,取  x和y   900*900像素
	public int[] zuobiao= new int[9];
	public  int[] zuobiao() { 
		//int[] zuobiao =new int[9];
		int sum =0;
		for (int i = 0; i < 9; i++) {
			zuobiao[i]=sum;
			sum+=100;
		//	System.out.println(zuobiao[i]);
		}
		return zuobiao;
	
	}
	/*Random rand =new Random();
	int type =rand.nextInt(9);
	int type1 =rand.nextInt(9);
	int xCS=zuobiao[type];
	int yCS=zuobiao[type];*/
	

	//读取图片
	public static  BufferedImage readImage(String fileName) {
		try{
			BufferedImage img = ImageIO.read(PopoObject.class.getResource(fileName));
			return img;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	
	//获取图片
	public abstract BufferedImage getImage();
	
	public boolean isLife() {
		return state == LIFE;
	}
	public boolean isDead() {
		return state == DEAD;
	}
	public boolean isRemove() {
		return state == REMOVE;
	}
	public void paintObject(Graphics g) {
		g.drawImage(this.getImage(),this.x,this.y,null);
		
	}
	public boolean hit(PopoObject other) {
		int xl =this.x-other.width+5;
		int xr =this.x+this.width-5;
		int yt = this.y-other.height+5;
		int yd = this.y+this.height-5;
		int x = other.x;
		int y = other.y;
		
		return x>=xl && x<=xr
				&&
				y>=yt  && y<=yd;
		
	}
	public void  goDead() {
		state = DEAD;
	}

}
