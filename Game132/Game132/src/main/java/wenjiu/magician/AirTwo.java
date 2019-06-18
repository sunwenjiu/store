package wenjiu.magician;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class AirTwo extends EnemyFather {
	
	private static BufferedImage[] images;


	static {
		images = new BufferedImage[32];
		for (int i = 0; i < images.length; i++) {
			
			images[i]=readImage("imageMagicianOne/airtwo"+i+".png");
		}
/*
 * 0-3是左攻击 * 4-7是右攻击 * 8-11左干撒 * 12-15是有干撒 
 * * 16-19是左等待 *  * 20-23是右等待 * 24-27是左跑 * 28-31是右跑
 */
			
	}
	
	//构造
	public AirTwo() {
		super(500, 150,240,125,50 );

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
		if (getindex%200==0) {
			killwate=!killwate;
		}
		
	//	System.out.println(index);
		/*
		 * 0-3是左攻击		 * 4-7是右攻击		 * 8-11左干撒		 * 12-15是有干撒
		 * 16-19是左等待		 * 20-23是右等待		 * 24-27是左跑		 * 28-31是右跑
		 */
		if (isLife()) {
			if (!l && !r &&!u &&!d&& !rk &&!lk ) {
				//要再判断一下之前是右还是左再返回,目前先返回右看代码
				return images[index+20];
			}
			
			if (r||(atl&&d||atl&&u) ) {//|| (atl&&d||u)
			//	System.out.println("r:"+r+",atl:"+atl+",u:"+u);
			
				return images[index+28];
			}
			if (l || (atr&&d||atr&&u)) {//||(atr&&d||u)
			
				return images[index+24];
			}
			if (lk&&atr&&!l&&!r) {
				if (killwate) {
					fighting=false;
					return images[index+16];
					
				}else {
					if (index>=3) {
						killwate=true;
						worldkill=true;
						fighting=true;
					}
					return images[index];
				}
			}
			if (rk&&atl&&!l&&!r) {
				
				if (killwate) {
					fighting=false;
					return images[index+20];
					
				}else {
					if (index>=3) {
						killwate=true;
						worldkill=true;
						fighting=true;
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
	
	
	public void setLifeAir() {
		life-=5;
	}
	public void setLifeBig() {
		life-=10;
	}
	
	

}
