package mainfinall;




import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public abstract class Person {
	public static final int LIFE = 0;   //���ŵ�
	public static final int DEAD = 1;   //���˵�
	public static final int REMOVE = 2; //ɾ����
	public int state = LIFE; //��ǰ״̬(Ĭ��Ϊ���ŵ�)
	
	public int width;
	public int height;
	public int x;
	public int y;
	
	public Person(int width,int height) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}
	public Person(int width,int height,int x,int y) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}
	
	public abstract void step() ;
	public static BufferedImage readImage(String filename) {
		try {
			BufferedImage img = ImageIO.read(Person.class.getClassLoader().getResourceAsStream(filename));

			return img;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	/** �ж��Ƿ��ǻ��ŵ� */
	public boolean isLife() {
		return state==LIFE; //��ǰ״̬ΪLIFE����ʾ����Ϊ���ŵ�
	}
	/** �ж��Ƿ������˵� */
	public boolean isDead() {
		return state==DEAD; //��ǰ״̬ΪDEAD����ʾ����Ϊ���˵�
	}
	/** �ж��Ƿ���ɾ���� */
	public boolean isRemove() {
		return state==REMOVE; //��ǰ״̬ΪREMOVE����ʾ����Ϊɾ����
	}
	/** ��ͼƬ */
	public void paintObject(Graphics g) {
		g.drawImage(this.getImage(),this.x,this.y,null);
	}
	protected abstract BufferedImage getImage();
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
}
