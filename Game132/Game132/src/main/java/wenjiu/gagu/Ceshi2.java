package wenjiu.gagu;


import java.awt.Graphics;

import java.awt.image.BufferedImage;
/**
 * 正确的直线移动
 * 
 * @author soft01
 *
 */

public class Ceshi2 extends GagueObject {
	
	private static BufferedImage image;


	static {

			image=readImage("imageGagu/herodown.png");
			
	}
	
	private  int x2;
	private  int y2;
	private double y3;
	

	//构造
	public Ceshi2(int x,int y) {
		super(600, 150,60,31 );
		
		this.x2=x;
		this.y2=y;
		this.y3=y1;
	
		
	}
	
	
	public BufferedImage getImage() {
		
		return image;
	}
	
	
	/*public void getHeroXY(int x,int y) {
		this.x2=x;
		this.y2=y;

	}*/
	public void moveTo() {
		//在第一项现
		x-=steep;
		y3+=Math.abs(y2-y1)*1.0/(Math.abs(x2-x1)/steep);
		//判断象现
	
		//
	//	System.out.println(y3+","+y2);
	
	}
	
	public  void paintObject(Graphics g) {

		g.drawImage(this.getImage(),this.x,(int)this.y3,null);

	
}
	
	
	
	

}
