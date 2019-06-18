package enemySkill;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import heroskill.SuperClassSkill;
import mainfinall.Hero;

public abstract class SuperClassSkillFollow {
	public static final int LIFE = 0;   //活着的
	public static final int DEAD = 1;   //死了的
	public static final int REMOVE = 2; //
	public static final int ACTION = 3; //发动技能
	protected boolean left = true;//判断方向
	protected int state=LIFE;

	public int width;
	public int height;
	public int xx;
	public int yy;
	public int x;
	public int y;
	public double x1;
	public double y1;
	protected double speedXY[] = new double[2];
	
	public SuperClassSkillFollow(int width,int height, int x, int y,int xhero,int yhero) {
		this.width = width;
		this.height = height;
		this.x1 =(double) x;
		this.y1 =(double) y;
		double distanceX = Math.abs(x1-xhero);
		double distanceY = Math.abs(y1-yhero);
		double time = distanceX>distanceY?distanceX:distanceY;
		speedXY[0] = distanceX/time;
		speedXY[1] = distanceY/time;
		if (x1>xhero) {
			speedXY[0]=-speedXY[0];
		}
		if (y1>yhero) {
			speedXY[1]=-speedXY[1];
		}
	}
	
	public SuperClassSkillFollow(int width,int height, int x, int y,int xhero) {
		this.width = width;
		this.height = height;
		this.xx = x;
		this.yy = y;
		this.left = x>xhero;
	}
	public void step() {}
	public void goDead() {
		state=DEAD;
	}
	public static BufferedImage readImage(String filename) {
		try {
			BufferedImage img = ImageIO.read(SuperClassSkillFollow.class.getClassLoader().getResourceAsStream(filename));
			return img;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public boolean isAction() {
		return state==ACTION;
	}
	public boolean hit(Hero other) {
		int x1 = this.xx-other.width;  
		int x2 = this.xx+this.width;   
		int y1 = this.yy-other.height; 
		int y2 = this.yy+this.height;  
		int x = other.x;              
		int y = other.y;              
		return x>=x1 && x<=x2 && y>=y1 && y<=y2; 
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
		g.drawImage(this.getImage(),(int)x1,(int)y1,null);
	}
	protected abstract BufferedImage getImage();

}
