package heroskill;



import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public abstract class SuperClassSkill {
	public static final int LIFE = 0;   //活着的
	public static final int DEAD = 1;   //死了的
	public static final int REMOVE = 2; //
	public static final int ACTION = 3; //发动技能
	protected boolean left = true;//判断方向
	protected int state=LIFE;

	public int width;
	public int height;
	public int x;
	public int y;
	protected int idIndex=-1;
	
	public SuperClassSkill(int widht,int height,int x,int y) {
		this.width = width ;
		this.height = height;
		this.x = x;
		this.y = y;
	}
	public SuperClassSkill(int width,int height, int x, int y,int xhero) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.left = x>xhero;
	}
	
	public void step() {}

	public static BufferedImage readImage(String filename) {
		try {
			BufferedImage img = ImageIO.read(SuperClassSkill.class.getClassLoader().getResourceAsStream(filename));
			return img;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	/** �ж��Ƿ��ǻ��ŵ� */
	public boolean isAction() {
		return state==ACTION;
	}
	
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
	public void goDead() {}
	public boolean hit(SuperClassSkill other) {
		int x1 = this.x-other.width;  
		int x2 = this.x+this.width;   
		int y1 = this.y-other.height; 
		int y2 = this.y+this.height;  
		int x = other.x;              
		int y = other.y;              
		
		return x>=x1 && x<=x2 && y>=y1 && y<=y2; 
	}
	public boolean outOfBounds() {
		return this.x<=-this.width*2;
	}
	
	/** ��ͼƬ */
	public void paintObject(Graphics g) {
		g.drawImage(this.getImage(),this.x,this.y,null);
	}
	protected abstract BufferedImage getImage();

	public void setIdIndex(int idIdex) {
		this.idIndex =idIdex;
		
	}
	
	public int getIdIndex() {
		return idIndex;
	}
	
}
