package wenjiu.gagu;

import java.awt.image.BufferedImage;

public class ActionGagueBase extends GagueObject {
	
	private static BufferedImage image;


	static {

			image=readImage("imageGagu/actionGagueBase.png");
			
	}
	
	

	//构造
	public ActionGagueBase() {
		super(0, 0,80,12 );
	
		
	}
	
	
	public BufferedImage getImage() {
		
		return image;
	}
	
	
	
	

	
	
	

}
