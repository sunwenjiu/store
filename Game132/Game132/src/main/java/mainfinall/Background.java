package mainfinall;

import java.awt.Graphics;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;


public class Background extends Person  {
	private static BufferedImage image;
	static {
		try {
			
			image = ImageIO.read(Background.class.getClassLoader().getResourceAsStream("image/background01.jpg"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private int speed;
	int x1;
	int x2;
	public Background() {
		super(World.WIDTH*4,World.HEIGHT,0,0);
		speed = 2;
		x1=World.WIDTH*4;
		x2=-World.WIDTH*4;
	}
	public void moveLeft() {
		
		if (x<0) {
			x+=2;
		}
		//sSystem.out.println("键被按左");
	}
	public void moveRight() {
		
		if (x>-World.WIDTH*3+400) {
			x-=2;
		}
		//System.out.println("键被按右");
	}
	
	/** 重写getImage()获取图片 */
	public BufferedImage getImage() {
		return image; //直接返回image即可
	}
	
	/** 重写paintObject()画图片 */
	public void paintObject(Graphics g) {
		g.drawImage(getImage(),x-200,y,null);
		
	}
	@Override
	public void step() {
		// TODO Auto-generated method stub
		
	}
}
	



