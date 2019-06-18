package com.sunwenjiu.popo;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SingleSelectionModel;



import  java.awt.event.MouseAdapter;
import  java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.TimerTask;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class World extends JPanel {
	public static final int WIDTH= 900; //宽高
	public static final int HEIGHT= 900;
	public static final int START =0;
	public static final int RUNNING=1;
	public static final int PAUSE =2;
	public static final int GAME_OVER =3;
	private int state = START;

	private static BufferedImage start;
	private static BufferedImage pause;
	private static BufferedImage gameover;
	static {
		start =PopoObject.readImage("start.png");
		pause =PopoObject.readImage("pause.png");
		gameover =PopoObject.readImage("gameover.png");
	}

	private Hero hero = new Hero();
	private  PopoObject[] enemies = {
			/*new Airbos(100,200),
			new Bigbos(300,500),
			new Bee(500,300),*/

	};
	private  Map map= new Map();
	private Popo[] popo = {
			/*	new Popo(400, 300)*/
	};
	private PopoHero[] popoHero = {
			/*new Popo(400, 200)*/
	};

	private BulletEnemy[] bullet = {
			/*new Bullet(200, 100)*/
	};
	private Bullet[] bulletHero = {
			/*new Bullet(200, 200)*/
	};

	private Tie[] tie = {
			/*		new Tie(500, 200),
				new Tie(100,600),*/
	};  


	//s生成敌人
	public PopoObject enxtOne() {
		Random rand = new Random();
		int type = rand.nextInt(20);
		//long a=System.currentTimeMillis();

		if (type<2) {
			return new Bee();
		}else if (type<12) {
			return new Airbos( );
		}else {
			return new Bigbos(  );
		}
	}

	//敌人出场
	int  enterIndex=200;

	public void enterAction() {
		enterIndex++;
		if (enterIndex%300==0) {
			PopoObject  obj = enxtOne();
			enemies =Arrays.copyOf(enemies, enemies.length+1);
			enemies[enemies.length-1]=obj;
		//	System.out.println("敌人的数量"+enemies.length);



		}

	}
	

	int stepIndex=0;
	 int ranIndex =0;
	public void stepAction() {
		stepIndex++;
		//英雄移动
		if (stepIndex%1==0 && hero.getMoveRight()) {
			hero.moveRight();
		}
		if (stepIndex%1==0 && hero.getMoveDown()) {
			hero.moveDown();
		}
		if (stepIndex%1==0 && hero.getMoveLeft()) {
			hero.moveLeft();
		}
		if (stepIndex%1==0 && hero.getMoveUp()) {
			hero.moveUp();
		}
		


		//敌人移动

		if (stepIndex%300==0) {
			Random rand= new Random();
			ranIndex=rand.nextInt(4);
		}
		if (ranIndex==0) {
			for (int i = 0; i < enemies.length; i++) {
				enemies[i].step0();// 加ranIndex
			}
		}
		if (ranIndex==1) {
			for (int i = 0; i < enemies.length; i++) {
				enemies[i].step1();// 加ranIndex
			}
		}
		if (ranIndex==2) {
			for (int i = 0; i < enemies.length; i++) {
				enemies[i].step2();// 加ranIndex
			}
		}
		if (ranIndex==3) {
			for (int i = 0; i < enemies.length; i++) {
				enemies[i].step3();// 加ranIndex
			}
		}



		//子弹移动
		for (int i = 0; i < bullet.length; i++) {
			if (i%4==0) {
				bullet[i].step();
			}
			if (i%4==1) {
				bullet[i].step1();
			}
			if (i%4==2) {
				bullet[i].step2();
			}
			if (i%4==3) {
				bullet[i].step3();
			}

		}
		for (int i = 0; i < bulletHero.length; i++) {
			if (i%4==0) {
				bulletHero[i].step();
			}
			if (i%4==1) {
				bulletHero[i].step1();
			}
			if (i%4==2) {
				bulletHero[i].step2();
			}
			if (i%4==3) {
				bulletHero[i].step3();
			}

		}
//泡泡移动方法只用来出生值添加
		for (int i = 0; i < popo.length; i++) {
			popo[i].step();
			//System.out.println("看泡泡的出生值"+popo[i].chusheng);
		}
		for (int i = 0; i < popoHero.length; i++) {
			popoHero[i].step();
		}

		// 调用移动结束的大括号下面这个
	}



	//英雄放泡泡了  
	//int heroFanIndex=0;
	public void heroFanAction(){
		boolean cf=true;
			PopoHero  pohero =(PopoHero) hero.shoot();
			//遍历原来的泡泡,如果新的泡泡的坐标和之前的泡泡已经重合,这个泡泡不要,没有重合就要\
			if (popoHero.length==0) {
				popoHero =Arrays.copyOf(popoHero, popoHero.length+1);
				popoHero [popoHero.length-1]=pohero;
			}
			else{
				for (int i = 0; i < popoHero.length; i++) {
					
					PopoHero ch =popoHero[i];
					if ((ch.x==pohero.x)&& (ch.y==pohero.y) ) {
						cf=false;
						//只要有一次能对上,就证明位置重复了.这个泡泡不能要了
					}
				}
				if (cf) {
					popoHero =Arrays.copyOf(popoHero, popoHero.length+1);
					popoHero [popoHero.length-1]=pohero;
				}
			}
		//	popoHero =Arrays.copyOf(popoHero, popoHero.length+1);
		//	popoHero [popoHero.length-1]=pohero;
			
		//	System.out.println("英雄放泡泡不能轴到里面吗");
			//System.out.println("英雄泡泡的长下"+popoHero.length);

		
	}
	//敌人放泡泡
	int enemiesFanIndex2=0;
	public void enemiesFanAction() {//敌人放泡泡了
		enemiesFanIndex2++;
		/*for (int i = 0; i < enemies.length; i++) {
			System.out.println("看敌人的出生值"+enemies[i].chusheng);
		}*/
		//if (enemiesFanIndex2%1000==0) {
		for (int i = 0; i < enemies.length; i++) {
			if (enemies[i].chusheng%600==0 && enemies[i].isLife()) {
				Popo po= (Popo) enemies[i].shoot();
				popo=Arrays.copyOf(popo, popo.length+1);
				popo[popo.length-1]=po;
			}
		}
		//	}
	}
	// 英雄的泡泡射击了爆炸了
	int popoHeroChusheng=300;
	public  void popoHeroShootAction() {
		for (int i = 0; i < popoHero.length; i++) {
			Bullet [] bs =(Bullet[]) popoHero[i].popoShoot();
			//System.out.println("英雄泡泡的出生值"+popoHero[i].chusheng);
			if (popoHero[i].chusheng%popoHeroChusheng==0) {
				bulletHero=Arrays.copyOf(bulletHero, bulletHero.length+bs.length);
				System.arraycopy(bs,0, bulletHero, bulletHero.length-bs.length, bs.length);
			}
		}
	}
	//泡泡射击了 就是泡泡炸了
	//int enemiesFanIndex=0;
	int popoChusheng=300;
	public void popoShootAction() {
		//	enemiesFanIndex++;
		//	if (enemiesFanIndex%1000==0) {
		for (int i = 0; i < popo.length; i++) {
			if (popo[i].chusheng%popoChusheng==0) {
				BulletEnemy[] bs= (BulletEnemy[]) popo[i].popoShoot();
				bullet=Arrays.copyOf(bullet, bullet.length+bs.length);
				System.arraycopy(bs,0, bullet, bullet.length-bs.length, bs.length);
				//System.out.println("子弹的长度"+bullet.length);
			}

		}
		//	}
	}

	/*//敌人直接射击成子弹了  放子弹了之前版本
	int enemiesFanIndex=0;
	public void popoShootAction() {
		enemiesFanIndex++;
		if (enemiesFanIndex%1000==0) {

			for (int i = 0; i < enemies.length; i++) {
				  Bullet[] bs= (Bullet[]) enemies[i].shoot();
				 // System.out.println("bs长度"+bs.length);
				  bullet=Arrays.copyOf(bullet, bullet.length+bs.length);
				  System.arraycopy(bs,0, bullet, bullet.length-bs.length, bs.length);
				System.out.println("子弹的长度"+bullet.length);
			for (int i = 0; i < enemies.length; i++) {
			  Bullet[] po= (Bullet[]) enemies[i].shoot();
			  bullet=Arrays.copyOf(bullet, bullet.length+1);
			  bullet[bullet.length-1]=po;
			}
		}
	}*/
	/*Bullet01[] bs = hero.shoot();
	bullet =Arrays.copyOf(bullet, bullet.length+bs.length);
	System.arraycopy(bs,0, bullet, bullet.length-bs.length, bs.length);*/



	//英雄的子弹越界删除  
	int outoFIndex3=0;
	public void herooutOfBoundsAction() {
		int index =0;
		//遍历子弹数组  假如数组的子弹的 x y 都出界,那就执行一次删除, 只要有一个子弹没有出界,就不执行删除
		for (int i = 0; i < bulletHero.length; i++) {
			if (bulletHero[i].outOfBounds()) {
				outoFIndex3++; //假如这个子弹出界了,我就记录一次
			}
		}
		//假如outoFIndex2++  和子弹数组的长度相等,那就执行一次删除
		if (outoFIndex3==bulletHero.length) {

			//System.out.println("删除前子弹的长度"+bullet.length);//
			Bullet [] bulletLives = new Bullet[bulletHero.length];
			//System.out.println("删除前活着的子弹的长度"+bulletLives.length);//
			for (int i = 0; i < bulletHero.length; i++) {

				Bullet  b = bulletHero[ i];
				if (!b.outOfBounds()) {
					bulletLives[index]=b;
					index++;
				}
			}
			bulletHero=Arrays.copyOf(bulletLives, index);
			//	System.out.println("删除英雄子弹后的数组长度"+bulletHero.length+"+1");
		}

		outoFIndex3=0; //归零后重新计算,不归零就会出错 ,以后子弹就不会进行删除
		//System.out.println("子弹的数组长度"+bullet.length+"+2");
	}

	//子弹越界删除  优化完毕
	int outoFIndex2=0;
	public void outOfBoundsAction() {
		int index =0;
		//遍历子弹数组  假如数组的子弹的 x y 都出界,那就执行一次删除, 只要有一个子弹没有出界,就不执行删除
		for (int i = 0; i < bullet.length; i++) {
			if (bullet[i].outOfBounds()) {
				outoFIndex2++; //假如这个子弹出界了,我就记录一次
			}
		}
		//假如outoFIndex2++  和子弹数组的长度相等,那就执行一次删除
		if (outoFIndex2==bullet.length) {

			//System.out.println("删除前子弹的长度"+bullet.length);//
			BulletEnemy [] bulletLives = new BulletEnemy[bullet.length];
			//System.out.println("删除前活着的子弹的长度"+bulletLives.length);//
			for (int i = 0; i < bullet.length; i++) {

				BulletEnemy  b = bullet[ i];
				if (!b.outOfBounds()) {
					bulletLives[index]=b;
					index++;
				}
			}
			bullet=Arrays.copyOf(bulletLives, index);

			//	System.out.println("删除子弹后的数组长度"+bullet.length+"+1");
		}

		outoFIndex2=0; //归零后重新计算,不归零就会出错 ,以后子弹就不会进行删除
		//System.out.println("子弹的数组长度"+bullet.length+"+2");
	}
	//子弹越界删除  被优化前的备份
	/*	int outoFIndex2=0;
	public void outOfBoundsAction() {
		outoFIndex2++;
		if (outoFIndex2%1000==0) {

			int index =0;
			Bullet [] bulletLives = new Bullet[bullet.length];
			for (int i = 0; i < bullet.length; i++) {
				Bullet  b = bullet[ i];
				if (!b.outOfBounds()) {
					bulletLives[index]=b;
					index++;
				}
			}
			bullet=Arrays.copyOf(bulletLives, index);
			System.out.println("删除子弹后的数组长度"+bullet.length);
		}

	}*/
	//英雄泡泡打完后消失了
	public void popoHerooutOfBoundsAction() {
		int index =0;
		PopoHero [] popoLives = new PopoHero[popoHero.length];
		for (int i = 0; i < popoHero.length; i++) {
			PopoHero  b = popoHero[ i];
			if (b.chusheng<popoHeroChusheng+2) {
				popoLives[index]=b;
				index++;
			}
		}
		popoHero=Arrays.copyOf(popoLives, index);

	}


	//泡泡打完子弹后删除了
	public void popooutOfBoundsAction() {//泡泡打完子弹后删除了
		//if (outoFIndex2%200==0) {
		int index =0;
		Popo [] popoLives = new Popo[popo.length];
		for (int i = 0; i < popo.length; i++) {
			Popo  b = popo[ i];
			if (b.chusheng<popoChusheng+2) {
				//popo[i].goDead();
				popoLives[index]=b;
				index++;
			}
		}
		popo=Arrays.copyOf(popoLives, index);
		//System.out.println("删除泡泡后的数组长度"+popo.length);
		//	}

	}



	//英雄的子弹和敌人碰撞 
	int score=0;
	public void heroBulletBangAction()	{

		for (int i = 0; i < bulletHero.length; i++) {
			Bullet b = bulletHero[i];
			for (int j = 0; j < enemies.length; j++) {
				PopoObject f = enemies[j];
				if (b.isLife() && f.isLife() && b.hit(f)) {
					b.goDead();
					f.goDead();

					if (f instanceof Enemy) {
						Enemy e =(Enemy) f;
						score += e.getScore();
						//System.out.println("得分:"+score);

					}
					if (f instanceof Award) {
						Award a = (Award) f;
						int type =a.getAwardType();

						switch (type) {
						case Award.DOUBLE_FIRE:	
							hero.addLife();
							//	hero.addDoubleFire();
							break;

						case Award.LIFE:
							hero.addLife();
							break;


						}
					}

				}
			}
		}
	}
	////英雄的子弹和自己碰撞
	public void heroBulletToSelfBangAction() {
		for (int i = 0; i < bulletHero.length; i++) {
			Bullet b=bulletHero[i];
			if (b.isLife()&& b.hit(hero)) {
				hero.subtractLife();//英雄减去生命
				b.goDead();
			}
			
		}
	}
	//敌人的子弹和英雄碰撞
	public void enemiesBulletToHeroBangAction() {
		for (int i = 0; i < bullet.length; i++) {
			BulletEnemy b= bullet[i];
			if (b.isLife()&& b.hit(hero)) {
				hero.subtractLife();//英雄减去生命
				b.goDead();
			}
		}
		
	}
	
	
	//删除remove的敌人(不会再出现了)
	public void enemiesRemoveAction() {//删除remove的敌人(不会再出现了)
		int index = 0;
		PopoObject[] enemiesLive=new PopoObject[enemies.length];
		for (int i = 0; i < enemies.length; i++) {
			PopoObject f =enemies[i];
			if (!enemies[i].isRemove()) {
				enemiesLive[index]=f;
				index++;
			}
		}
		enemies = Arrays.copyOf(enemiesLive, index);
		
		
	}
	//键盘方法开始
public void processRunningKey(int key) {
	switch(key){
	case KeyEvent.VK_RIGHT:moveRightAction();break;
	case KeyEvent.VK_LEFT:moveLeftAction();break;
	case KeyEvent.VK_DOWN:moveDownAction();break;
	case KeyEvent.VK_UP:moveUpAction();break;
	//case KeyEvent.VK_Z:rotateLeftAction();break;
	case KeyEvent.VK_SPACE:heroFanAction();break;
	//case KeyEvent.VK_Q:System.exit(0);break;
	//case KeyEvent.VK_P:state=PAUSE;break;
	}
	
}
// 键盘控制向右移动
public void moveRightAction() {
	//hero.moveRight();
	hero.moveMoveRight();
}
//键盘控制左移
public void moveLeftAction() {
	hero.moveMoveLeft();
//	hero.moveLeft();
}
//键盘控制下移
public void moveDownAction(){
	hero.moveMoveDown();
	//hero.moveDown();
}
//键盘上移动
public void moveUpAction() {
	hero.moveMoveUp();
	//hero.moveUp();
}
public void checkGameOverAction() {
	if (hero.getLife()<=0) {
		state = GAME_OVER;
	}
}
	public void action(){
		
		MouseAdapter l = new MouseAdapter() {
			public void mouseMoved(MouseEvent e) {
				int x=e.getX();
				int y = e.getY();
				//hero.moveTo(x, y);//英雄随鼠标移动了
			}
			//重写点击事件
			public void mouseClicked(MouseEvent e) {
				switch(state) {
				case START:
					state =RUNNING;
					break;
				case GAME_OVER:
					score =0;
					
					hero =new Hero();
					enemies=new PopoObject[0];
					popo= new Popo[0];
					bullet =new  BulletEnemy[0];
					bulletHero =new Bullet[0];
					popoHero = new PopoHero[0];
					
					
					state=START;
					break;
				}
			}
			//重写鼠标移除事件
			public void mouseExited(MouseEvent e) {
				if (state == RUNNING) {
					state=PAUSE;
				}
			}
			//重写鼠标移入事件
			public void mouseEntered(MouseEvent e) {
				if (state==PAUSE) {
					state=RUNNING;
				}
			}
		};
		this.addMouseListener(l);//处理鼠标操作
		this.addMouseMotionListener(l);//处理滑动
		/**
		 * 键盘开始处理
		 */
		KeyListener ll = new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (state ==RUNNING) {
					
					processRunningKey(key);
				}
				
				repaint();
			}
		};
		this.addKeyListener(ll);
		this.setFocusable(true);
		this.requestFocus();
		
		//键盘结束

		Timer timer =new Timer();
		int interval = 10;
		timer.schedule(new  TimerTask() {
			public void run() {//定时器入口
				if (state == RUNNING) {
					
					enterAction();//敌人入场
					stepAction();//移动了
					enemiesFanAction();  	//敌人放泡泡了
					popoShootAction();//泡泡射击
					outOfBoundsAction();//越界删除子弹
					popooutOfBoundsAction();//泡泡打完子弹后删除了
					popoHerooutOfBoundsAction();//英雄泡泡打完后删除了
					
					//heroFanAction();	//英雄放泡泡了,换到键盘控制了,现在这里只是标记一下,好找这个方法,这里也是定时器用的方法
					popoHeroShootAction(); //英雄的泡泡射击了
					herooutOfBoundsAction();//英雄的越界子弹删除了
					heroBulletBangAction()		;		//y英雄的子弹和敌人和自己碰撞
					heroBulletToSelfBangAction();//英雄的子弹和自己碰撞
					enemiesBulletToHeroBangAction();//敌人的子弹和英雄碰撞
					enemiesRemoveAction();//删除remove的敌人(不会再出现了)
					
					checkGameOverAction();//检测游戏结束
				}



				repaint();


			}
		}, interval, interval);




	}

	public void paint(Graphics g) {
		map.paintObject(g);
	

	
		
		
			
			for (int i = 0; i < popo.length; i++) {
			popo[i].paintObject(g);
			//System.out.println("popo的XY:"+popo[i].x+","+popo[i].y);
			//	System.out.println("泡泡出现了几个,画板里面"+popo.length);//测试87个泡泡后出现 
			//	Exception in thread "AWT-EventQueue-0" java.lang.NullPointerException
			//	at com.sunwenjiu.popo.World.paint(World.java:155)
			//at javax.swing.JComponent.paintToOffscreen(JComponent.java:5210)
		
		}
		for (int i = 0; i < tie.length; i++) {
			tie[i].paintObject(g);
		}
		for (int i = 0; i < bullet.length; i++) {
			bullet[i].paintObject(g);
		}
		for (int i = 0; i < popoHero.length; i++) {

			popoHero[i].paintObject(g);
		}
		for (int i = 0; i < bulletHero.length; i++) {
			bulletHero[i].paintObject(g);
		}
		for (int i = 0; i < enemies.length; i++) {
			enemies[i].paintObject(g);
		}
		hero.paintObject(g);
		g.drawString("生命: "+hero.getLife(), 10, 30);
		g.drawString("得分: "+score, 10, 50);
		
		switch (state) {
		case START:
			g.drawImage(start,0,0,null);
			break;
		case PAUSE:
			g.drawImage(pause,0,0,null);
			break;
		case GAME_OVER:
			g.drawImage(gameover,0,0,null);
			break;



		}
		
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		World world = new World();
		frame.add(world);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH	,HEIGHT);
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true); 


		world.action();
		/*	World world = new World();
		world.action();*/


	}

}
