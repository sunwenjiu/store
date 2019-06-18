package wenjiu.gagutoenemy;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;



public abstract class GagueObject {
	
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	private int gague ;
	protected int x2;
	protected int y2;
	//直线移动用
	protected final int x1;
	protected final int y1;
	protected double steep=1;
	
	
	
	public GagueObject(int x, int y, int width, int height) {
		
		this.x = x;
		 this.x1=x;
		this.y = y;
		this.y1=y;
		this.width = width;
		this.height = height;
		this.x2 = 0;
		this.y2 = 0;
		
	}

	//读图片
	public static  BufferedImage readImage(String fileName) {
		try{
			BufferedImage img = ImageIO.read(GagueObject.class.getClassLoader().getResourceAsStream(fileName));
			return img;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public abstract BufferedImage getImage();
	
	//移动坐标
	public void moveTo(int x,int y) {
		this.x=x+60;
		this.y=y-this.height;
	
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

}
