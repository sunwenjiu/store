package wenjiu.gagutoenemy;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ActionGague extends GagueObject {
	private static BufferedImage image;


	static {

			image=readImage("imageGagu/actionGague.png");
			
	}
	
	private int gague ;

	//构造
	public ActionGague() {
		super(0, 0,80,12 );
	this.gague=80;
		
	}
	
	//改变血
	public void setGague(int gague) {
		this.gague=gague;
		// System.out.println("gague"+gague);
		 if (this.gague<=0) {
			 this.gague=0;
		}
	}
	public int getGague() {
		return gague;
	}
	
	
	public BufferedImage getImage() {
		
		return image;
	}
	
	public  void paintObject(Graphics g) {
		
		g.drawImage(getImage(), x , y ,x+gague, y+12, 0, 0, gague,12,null);
	//	g.drawImage(getImage(),x,y,null);

	
}
	
	

	
	
	

}
