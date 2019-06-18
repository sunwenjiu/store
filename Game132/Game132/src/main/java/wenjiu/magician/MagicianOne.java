package wenjiu.magician;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MagicianOne extends EnemyFather {

	private static BufferedImage[] images;


	static {
		images = new BufferedImage[32];
		for (int i = 0; i < images.length; i++) {

			images[i]=readImage("imageMagicianOne/magicianone"+i+".png");
		}
		/*
		 * 0-3是左攻击 * 4-7是右攻击 * 8-11左干撒 * 12-15是有干撒 
		 * * 16-19是左等待 *  * 20-23是右等待 * 24-27是左跑 * 28-31是右跑
		 */

	}

	//构造
	public MagicianOne() {
		super(500, 150,240,125 ,100);

	}

	int index =0;
	int getindex=0;
	
	public BufferedImage getImage() {
		getindex++;
		if (getindex%10==0) {
			index++;
		}
		if (index>=4) {
			index=0;
		}
		if (getindex%500==0) {
			killwate=!killwate;
		}
		//	System.out.println(index);
		/*
		 * 0-3是左攻击		 * 4-7是右攻击		 * 8-11左干撒		 * 12-15是有干撒
		 * 16-19是左等待		 * 20-23是右等待		 * 24-27是左跑		 * 28-31是右跑
		 */
		if (isLife()) {
			if (!l && !r &&!u &&!d&& !rk &&!lk &&atl) {
				//要再判断一下之前是右还是左再返回,目前先返回右看代码
				return images[index+20];
			}
			if (!l && !r &&!u &&!d&& !rk &&!lk&&atr ) {

				return images[index+16];
			}
			if (r||(atl&&d||atl&&u) ) {//|| (atl&&d||u)
				//	System.out.println("r:"+r+",atl:"+atl+",u:"+u);
				return images[index+28];
			}
			if (l || (atr&&d||atr&&u)) {//||(atr&&d||u)
				return images[index+24];
			}
			if (lk&&atr) {
				if (killwate) {
					return images[index+16];
					
				}else {
					if (index>=3) {
						killwate=true;
						worldkill=true;
					}
					return images[index];
				}
			}
			if (rk&&atl) {
				if (killwate) {
					return images[index+20];
					
				}else {
					
					if (index>=3) {
						killwate=true;
						worldkill=true;
					}
					return images[index+4];
				}
			
			}

		} else if (isDead()) {
			//BufferedImage img = images[index+8];
			//	if (index+8==images.length-1) {
			state =REMOVE;
			//}
			//return img;

		} 




		return null;
	}



	protected boolean ymove=false;
	protected int indexmove =0;


	public void moveTo() {//图片尺寸是240*147
		indexmove++;

		
		if (indexmove%1000==0) {//远程有休息时间 
			ymove=!ymove;
		}


		if (this.x>x2) {
			x-=speed;
			atr=true;
			l=true;
			atl=false;
			lk=true;
			r=false;
			if (this.x<=500) {//+-40是为了在英雄右边就攻击而不是重合猜攻击近战小兵
				l=false;
				this.x+=speed;
			}
		}
		if (this.x<x2) {
			x+=speed;
			atl=true;
			r=true;
			atr=false;
			rk=true;
			l=false;
			if (this.x>=0) {//+-80是为了在英雄左边就攻击而不是重合才攻击近战小兵
				r=false;
				this.x-=speed;
			}
		}
		if (this.y>y2 | ymove) {
			u=true;
			d=false;
			y-=speed;
			r=false;

			if (this.y==y2) {
				u=false;
			}
			if (ymove) {
				u=false;d=false;r=false;l=false;lk=false;rk=false;
			}
		}
		if (this.y<y2 | ymove) {
			d=true;
			u=false;
			y+=speed;
			if (this.y==y2) {
				d=false;
			}
			if (ymove) {
				u=false;d=false;r=false;l=false;lk=false;rk=false;
			}
		}
		//System.out.println("魔法师one:"+x+","+y+"英雄的:"+x2+","+y2+",atl:"+atl+",atr:"+atr);
	}


	public void setLifeAir() {
		life-=5;
	}
	public void setLifeBig() {
		life-=10;
	}


}
