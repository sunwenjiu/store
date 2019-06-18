package wenjiu.gagu;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * 对比的直线  不是正确的,可以删除
 * 
 * @author soft01
 *
 */
public class Ceshi extends GagueObject {
	
	private static BufferedImage image;


	static {

			image=readImage("imageGagu/herodown.png");
			
	}
	
	private  int x2;
	private int y2;
	

	//构造
	public Ceshi() {
		super(0, 0,60,31 );
		
		this.x2=0;
		this.y2=0;
	
		
	}
	
	
	public BufferedImage getImage() {
		
		return image;
	}
	
	
	public void getHeroXY(int x,int y) {
		this.x2=x;
		this.y2=y;

	}
	public void moveTo() {
	
		if (this.x>x2) {
			x--;
			
		}
		if (this.x<x2) {
			x++;
		}
		if (this.y>y2) {
			y--;
		}
		if (this.y<y2) {
			y++;
		}

	}
	

	
	


	
	
	

}
