package wenjiu.gagu;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ActionGagueBaseHeroDown extends GagueObject {
	
	private static BufferedImage image;


	static {

			image=readImage("imageGagu/herodown.png");
			
	}
	
	

	//构造
	public ActionGagueBaseHeroDown() {
		super(0, 0,60,31 );
	
		
	}
	public void moveTo(int x,int y,int width,int height) {
		this.x=x+width/2-this.width/2-5;
		this.y=y+height-this.height/2-5;
	
	}
	
	
	public BufferedImage getImage() {
		
		return image;
	}
	
	
	
	public  void paintObject(Graphics g) {

		g.drawImage(this.getImage(),this.x,this.y,null);

	
}

	
	
	

}
