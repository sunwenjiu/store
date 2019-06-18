package wenjiu.magician;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;

import enemySkill.enemyFSkill;
import enemySkill.enemyFSkill2;
import heroskill.SuperClassSkill;
import mainfinall.World;



public abstract class EnemyFather {
	public static final int LIFE =0;
	public static final int DEAD = 1;
	public static final int REMOVE = 2;
	protected int state = LIFE;

	protected int x;
	protected int y;
	protected int width;
	protected int height;
	private int gague ;
	protected int x2;
	protected int y2;
	protected int speed;
	protected int heromove;


	protected int lifeFather;


	protected int life ;


	protected boolean u=false;
	protected boolean d=false;
	protected boolean r=false;
	protected boolean l=false;
	protected boolean lk=false;
	protected boolean rk=false;
	protected boolean atl=false;
	protected boolean atr=false;
	protected boolean worldkill=false;
	protected boolean killwate=true;
	protected boolean fighting=false;//近战攻击
	protected Map<Integer, Integer> enemyMap=new HashMap<Integer, Integer>();

	public EnemyFather(int x, int y, int width, int height,int lifeFather) {
this.lifeFather=lifeFather;
this.life = this.lifeFather;
		//this.x = x;
		Random ran = new Random();
		int index =ran.nextInt(2);
		if (index==0) {//在窗体左边出
			this.x=-width;
			this.heromove=ran.nextInt(10)+10;
		}else {//在窗体右边出
			this.x =World.WIDTH+width;
			this.heromove=-(ran.nextInt(10)+10);
		}

		this.y = ran.nextInt(300-height)+300;

		this.width = width;
		this.height = height;
		this.x2 = 0;
		this.y2 = 0;
		speed=1;

		this.heromove=ran.nextInt(10)+5;
	}

	//读图片
	public static  BufferedImage readImage(String fileName) {
		try{
			BufferedImage img = ImageIO.read(EnemyFather.class.getClassLoader().getResourceAsStream(fileName));
			return img;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

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
	
	


	public void getHeroXY(int x,int y) {
		this.x2=x;
		this.y2=y+1+heromove;//加一只是为了敌人的y和英雄有差别,在一起时,画敌人在上可以看到打的效果


	}

	int index =1;
	public void moveTo() {//图片尺寸是240*147
		index++;
		if (index%2==0) {//减慢小兵的移动速度
			speed=0;
		}else {
			speed=1;
		}

		if (this.x-40>x2) {
			worldkill=false;
			x-=speed;
			atr=true;
			l=true;
			atl=false;
			lk=true;
			r=false;
			if (this.x-40<=x2) {//+-40是为了在英雄右边就攻击而不是重合猜攻击:近战小兵
				l=false;
	
				//x++;
				//if (this.x==x2+40) {
					this.x=x2+40-heromove;
			//	}
				
			}
		}else {
			l=false;
		}/*if (atr&&this.x>x2) {
			x++;
			
		}*/
		if (this.x+80<x2) {//this.x<x2
			worldkill=false;
			x+=speed;
			atl=true;
			r=true;
			atr=false;
			rk=true;
			l=false;
			if (this.x+80>=x2) {//+-80是为了在英雄左边就攻击而不是重合才攻击:近战小兵
				r=false;
				
			
			//	x--;//包括下面一个if都是减慢下敌人的速度后出现的bug的修正
			//	if (this.x==x2-80) {
					this.x=x2-80+heromove;
			//	}

			}
		}else {
			r=false;
		}
		/*if (atl&&this.x<x2) {
			x--;
		}*/
		if (this.y>y2) {
			worldkill=false;

			u=true;
			d=false;
			y-=speed;
			r=false;

			if (this.y==y2) {
				u=false;
			}
		}
		if (this.y<y2) {
			worldkill=false;
			d=true;
			u=false;
			y+=speed;
			if (this.y==y2) {
				d=false;
			}
		/*
			if (this.x-40<=x2|this.x+80>=x2) {
				//攻击 
				if (atl) {
					rk=true;
				}
				if (atr) {
					lk=true;
				}
			}*/
		}
		//System.out.println("魔法师one:"+x+","+y+"英雄的:"+x2+","+y2+",atl:"+atl+",atr:"+atr);
	}

	//zxy0211
	public boolean hit(SuperClassSkill other) {
		int x1 = this.x-other.width;  
		int x2 = this.x+this.width;   
		int y1 = this.y-other.height; 
		int y2 = this.y+this.height;  
		int x = other.x;              
		int y = other.y;              
		
		return x>=x1 && x<=x2 && y>=y1 && y<=y2; 
	}

	public void goDead() {
		state=DEAD;
		
		/* 我先做成移除状态 */
		//state = REMOVE;
	}
	
	public  void paintObject(Graphics g) {

		g.drawImage(this.getImage(),this.x,this.y,null);



	}
	//改变血
	public void setGague(int gague) {
		this.gague=gague;

		if (this.gague<=0) {
			this.gague=0;
		}
	}
	public int getGague() {
		return gague;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getLife() {
		return life;
	}

	public void setLifeAir() {
	
	}
	public void setLifeBig() {
		
	}

	public int getLifeFather() {
		return lifeFather;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	//zxy begin
	/*
	 * 跟踪技能，给诸葛
	 */
	public enemyFSkill Att(int x2,int y2) {
		enemyFSkill eskill = new enemyFSkill(width,height,x,y,x2,y2);
		return eskill;
	}
	
	
	/*
	 * 飞刀技能
	 */
	public enemyFSkill2 Att2(int xhero) {
		enemyFSkill2 skill2 = new enemyFSkill2(width, height, x, y, xhero);
		return skill2;
	}
	//zxy finish

	public boolean isLk() {
		return lk;
	}

	public boolean isRk() {
		return rk;
	}

	public boolean isWorldkill() {
		return worldkill;
	}

	public void setWorldkill() {
		this.worldkill = false;
	}

	public Integer getEnemyMap(Integer inte) {
		return enemyMap.get(inte);
	}

	public void setEnemyMap1(Integer inte) {
		enemyMap.put(inte, 1);
		
	}
	public void setEnemyMap0(Integer inte) {
		enemyMap.put(inte, 0);
		
	}

	public boolean getkillwate() {
		return killwate;
	}


	public boolean getfighting() {
		return fighting;
	}
	public void setfighting() {
		fighting=false;
		
	}
	
}
