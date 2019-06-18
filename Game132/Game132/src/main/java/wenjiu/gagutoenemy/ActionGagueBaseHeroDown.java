package wenjiu.gagutoenemy;

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
	
	
	public BufferedImage getImage() {
		
		return image;
	}
	
	
	
	public  void paintObject(Graphics g) {

		g.drawImage(this.getImage(),this.x+5,this.y+120,null);

	
}

	
	
	

}
