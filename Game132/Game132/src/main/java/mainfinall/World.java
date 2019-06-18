package mainfinall;

import javax.swing.JFrame;
import javax.swing.JPanel;

import enemySkill.SuperClassSkillFollow;
import enemySkill.enemyFSkill;
import enemySkill.enemyFSkill2;
import heroskill.GeneralSkill;
import heroskill.Skill_1;
import heroskill.SuperClassSkill;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import wenjiu.gagu.ActionGague;
import wenjiu.gagu.ActionGagueBase;
import wenjiu.gagu.ActionGagueBaseHeroDown;
import wenjiu.gagu.Ceshi;
import wenjiu.gagu.Ceshi2;
import wenjiu.gagu.GagueObject;
import wenjiu.magician.AirOne;
import wenjiu.magician.AirTwo;
import wenjiu.magician.BossOne;
import wenjiu.magician.EnemyFather;
import wenjiu.magician.MagicianOne;
import wenjiu.magician.MagicianTwo;
import wenjiu.sound.Sound;

public class World extends JPanel implements KeyListener{
	public static final int WIDTH = 750;
	public static final int HEIGHT = 600;
	private boolean leftmove = false;
	private boolean rightmove = false;
	private boolean upmove = false;
	private boolean downmove = false;
	private boolean att = false;
	private boolean attaction = false;
	private int skilltime = 500;
	private int skilltime2 = 100;

	protected static JFrame frame = new JFrame();
	private Background background =new Background();
	private Hero hero = new Hero();
	private SuperClassSkill skill[] = {};
	private SuperClassSkillFollow skillfollow[] = {};
	//sunwenjiu
	//生命英雄血的对象e
	private EnemyFather magicianone=new BossOne();

	private EnemyFather[] enemies= {};


	private GagueObject gagueHero=new ActionGagueBase();
	private GagueObject gagueHeroRed=new ActionGague();
	private GagueObject gagueHerodown=new ActionGagueBaseHeroDown();

	//敌人画血数组
	private GagueObject[] gagueEnemy=new ActionGagueBase [0];
	private GagueObject[] gagueEnemyRed= new ActionGague[0];
	private int score = 0; 

	//private GagueObject ceshi =new Ceshi() ;
	//private GagueObject ceshi2 =new Ceshi2(hero.getHeroX(), hero.getHeroY()) ;
	private static  Sound mu=new Sound("32.wav");
	//hit

	//孙结束
	//sunwenjiu
	//播放音乐
	int indexmu=388;
	public void music() {
		indexmu++;
		if (indexmu%400==0) {
System.out.println("音乐");
			mu.play();
		}
	}
	//生成敌人
	public EnemyFather nextOne() {
		Random rand = new Random();
		int type = rand.nextInt(50);
		if (type<20) {
			return new AirOne();
		} else if(type<40){
			return new AirTwo();
		}else if(type<44){
			return new MagicianOne();
		}else if(type<48) {
			return new MagicianTwo();

		}else {
			return new BossOne();

		}

	}

	int enterIndex =0;
	
	public void enterAction() {
		enterIndex++;
		if (enterIndex%600==0) {
			
			EnemyFather obj = nextOne();
			//新出的敌人检查是否有技能,如果有,给敌人增加唯一标示,没有就过,让技能生成时再取给敌人增加标识 
			if(skill.length>0) {
				for (int i = 0; i < skill.length; i++) {
					int id=skill[i].getIdIndex();
					obj.setEnemyMap1(id);
					
				}
			}
			
			enemies = Arrays.copyOf(enemies, enemies.length+1);
			enemies[enemies.length-1] =obj;
		}			
	}



	//sunwenjiu- e


	public void paint(Graphics g) {
		background.paintObject(g);  //画天空

		for (int i = 0; i < skill.length; i++) {
			skill[i].paintObject(g);
		}
		//zxy0122,增加跟踪技能数组
		for (int i = 0; i < skillfollow.length; i++) {
			skillfollow[i].paintObject(g);
		}
		//zxy finish

		//sunwenjiu
		//画英雄和敌人的血
		gagueEveryOne(g);

		//新建两个数组,一个用来装大于英雄的,一个用来装小于英雄的
		EnemyFather[] enemiesx= {};
		EnemyFather[] enemiesd= {};
		for (int i = 0; i < enemies.length; i++) {
			int a=enemies[i].getY();
			int b=hero.getHeroY();
			if (a>=b) {
				enemiesd=Arrays.copyOf(enemiesd, enemiesd.length+1);
				enemiesd[enemiesd.length-1]=enemies[i];		
			}else {
				enemiesx=Arrays.copyOf(enemiesx,  enemiesx.length+1);
				enemiesx[enemiesx.length-1]=enemies[i];
			}
			//	enemies[i].paintObject(g);
		}
		for (int j = 0; j < enemiesx.length; j++) {
			enemiesx[j].paintObject(g);
		}
		hero.paintObject(g);
		for (int j = 0; j < enemiesd.length; j++) {
			enemiesd[j].paintObject(g);
		}


		/*	if (hero.getHeroY()>=magicianone.getY()) {
			magicianone.paintObject(g);
			//画英雄血
			hero.paintObject(g);
		}else {
			hero.paintObject(g);
			magicianone.paintObject(g);
		}*/


		//	ceshi.paintObject(g);
		//	ceshi2.paintObject(g);
		
		
		g.drawString("得分: "+score, 50, 50);

		//sunwenjiu

	}
	//画血
	public void gagueEveryOne(Graphics g) {
		//英雄的血
		gagueHero.moveTo(hero.getHeroX(), hero.getHeroY(),hero.getWidth(),hero.getHeight());
		gagueHeroRed.moveTo(hero.getHeroX(), hero.getHeroY(),hero.getWidth(),hero.getHeight());
		gagueHerodown.moveTo(hero.getHeroX(), hero.getHeroY(),hero.getWidth(),hero.getHeight());
		gagueHero.paintObject(g);
		gagueHeroRed.paintObject(g);
		gagueHerodown.paintObject(g);

		//画敌人的血
		//血背地扩容复制
		//初始化敌人的血
		GagueObject [] indexEnemy= {};//敌人删除后,用来复制的数组依然是从0开始,画血数组不用删除
		gagueEnemy=Arrays.copyOf(indexEnemy, enemies.length);
		for (int i = 0; i < gagueEnemy.length; i++) {
			gagueEnemy[i]=new ActionGagueBase();
		}

		gagueEnemyRed=Arrays.copyOf(indexEnemy, enemies.length);
		for (int i = 0; i < gagueEnemyRed.length; i++) {
			gagueEnemyRed[i]=new ActionGague();
		}

		//画每一个敌人的血
		for (int i = 0; i < enemies.length; i++) {

			gagueEnemy[i].moveTo(enemies[i].getX(), enemies[i].getY(),enemies[i].getWidth(),enemies[i].getHeight());
			gagueEnemy[i].paintObject(g);

			gagueEnemyRed[i].moveTo(enemies[i].getX(), enemies[i].getY(),enemies[i].getWidth(),enemies[i].getHeight());
			double a=1;
			int gague=(int)(80*((enemies[i].getLife()*a)/enemies[i].getLifeFather()));
			gagueEnemyRed[i].setGague(gague);
			//enemies[i].setGague(gague);
			gagueEnemyRed[i].paintObject(g);
		}


	}

	protected void processRunningKey (int key) {
		switch (key) {
		case KeyEvent.VK_W:		upmove=true;break;
		case KeyEvent.VK_S:		downmove = true;break;
		case KeyEvent.VK_A:		leftmove = true;break;
		case KeyEvent.VK_D:		rightmove=true;break;
		case KeyEvent.VK_H:		
			if (skilltime2>=100) {
				att = true;
				skilltime2=0;
			}
			break;
		case KeyEvent.VK_J:		
			if (skilltime>=500) {
				attaction=true;
				skilltime=0;
			}
			break;
		}
	}

	protected void offKey (int key) {
		switch (key) {
		case KeyEvent.VK_W:hero.offButterrun();			upmove=false;break;
		case KeyEvent.VK_S:hero.offButterrun();			downmove = false;break;
		case KeyEvent.VK_A:hero.offButterleft();		leftmove = false;break;
		case KeyEvent.VK_D:hero.offButterright();		rightmove=false;break;
		//case KeyEvent.VK_H:hero.offButteratt();         att = false;break;			

		}

	}

	public void outOfBoundsAction() { 
		int index = 0; 
		EnemyFather[] enemyLives = new EnemyFather[enemies.length]; 
		for(int i=0;i<enemies.length;i++) { 
			EnemyFather f = enemies[i]; 
			if(!f.isRemove()) { 
				enemyLives[index] = f; 
				index++; 
			}
		}
		enemies = Arrays.copyOf(enemyLives, index); 

		index = 0; 
		SuperClassSkill[] skillLives = new SuperClassSkill[skill.length];
		for(int i=0;i<skill.length;i++) {
			SuperClassSkill b = skill[i];
			if(!b.outOfBounds() && !b.isRemove()) {
				skillLives[index] = b;
				index++;
			}
		}
		skill = Arrays.copyOf(skillLives,index);
	}

	

	public void enemyBangAction() { 
		for(int i=0;i<skill.length;i++) { 
			SuperClassSkill b = skill[i]; 
			//获取技能的id
			int skillIdIndex=skill[i].getIdIndex();
			for(int j=0;j<enemies.length;j++) { 
				//EnemyFather f = enemies[j]; 
				//用技能的id得到敌人map对应id的值
				int enemvalue=enemies[j].getEnemyMap(skillIdIndex);
				
				if(b.isLife() &&enemies[j].isLife() && enemies[j].hit(b)) { 
					//b.goDead(); 
					//f.goDead();
					if ((b instanceof GeneralSkill)&&enemvalue==1) {
						System.out.println("发送碰撞");
						enemies[j].setLifeAir();
						System.out.println(enemies[j].getLife());
						enemies[j].setEnemyMap0(skillIdIndex);
					}
					if ((b instanceof Skill_1)&&enemvalue==1)
					{
						enemies[j].setLifeBig();
						enemies[j].setEnemyMap0(skillIdIndex);
					}
					
					
					//					if(f instanceof EnemyFather) { 
					//						EnemyFather e = (EnemyFather)f;  
					//						score += e.getScore(); //��ҵ÷�
					//					}
					//					if(f instanceof Award) { //����ײ����Ϊ����
					//						Award a = (Award)f;  //����ײ����ǿתΪ�����ӿ�
					//						int type = a.getAwardType(); //��ȡ��������
					//						switch(type) { //���ݽ�����������ȡ��ͬ�Ľ���
					//						case Award.DOUBLE_FIRE:   //����������Ϊ����ֵ
					//							hero.addDoubleFire(); //��Ӣ�ۻ�������
					//							break;
					//						case Award.LIFE:    //����������Ϊ��
					//							hero.addLife(); //��Ӣ�ۻ�����
					//							break;
					//						}
					//					}
				}
			}
		}
	}
	public void heroBangAction() { 
		for(int i=0;i<skillfollow.length;i++) { 
			SuperClassSkillFollow f = skillfollow[i]; 
			if(hero.isLife() && f.isLife() && f.hit(hero)) { 
				f.goDead(); 
				hero.setLife();
				System.out.println("英雄被打了！！！！！");
			}
		}
	}

	private void AttackAction() {
		if (att == true) {
			hero.getImageAttackRight();
			hero.getImageAttackLeft();
			//hero.attackrightreadyimages();

		}
		if (attaction==true) {
			


		}
	}

	private void moveLeftAction() {
		if (leftmove == true) {
			if (hero.x<=75) {
				//background.moveLeft();
			}
			hero.getImageMoveLeft();
			hero.moveLeft();

		}
	}

	private void moveRightAction() {
		if (rightmove==true) {
			if (hero.x>=450) {
				//background.moveRight();
			}
			hero.getImageMoveRight();
			hero.moveRight();

		}

	}

	private void moveUpAction() {
		if (upmove==true) {
			hero.moveUp();

		}
	}

	private void moveDownAction() {
		if (downmove==true) {
			hero.moveDown();

		}
	}

	//zxy20190119
	int indexkill=0;
	public void enemyskillaction() {
		indexkill++;
		if (indexkill%3==0) {

			for (int i = 0; i < enemies.length; i++) {
				if (enemies[i] instanceof MagicianOne) {
					if (enemies[i].isWorldkill()) {
						enemyFSkill2 sk2 = enemies[i].Att2(hero.getHeroX());
						skillfollow = Arrays.copyOf(skillfollow,skillfollow.length+1); //扩容
						skillfollow[skillfollow.length-1]=sk2;	
						
						enemies[i].setWorldkill();
					}
				}
				if (enemies[i] instanceof MagicianTwo) {
					if (enemies[i].isWorldkill()) {
						enemyFSkill eskill = enemies[i].Att(hero.getHeroX(), hero.getHeroY());
						skillfollow = Arrays.copyOf(skillfollow,skillfollow.length+1); //扩容
						skillfollow[skillfollow.length-1]=eskill;

						enemies[i].setWorldkill();
					}

				}
			}

		}
	}

	/** 技能特效入场 */
public int idindexword=0;
	public void skillAction() { 
		skilltime++;
		if (attaction==true) {
			Skill_1 skillatt = hero.AttS(); //获取技能对象
			idindexword++;
			skillatt.setIdIndex(idindexword);
			//gei给敌人添加唯一标识
			if (enemies.length>0) {
				for (int i = 0; i < enemies.length; i++) {
					enemies[i].setEnemyMap1(idindexword);
				}
				
				
			}
			
			
			skill = Arrays.copyOf(skill,skill.length+1); //扩容
			skill[skill.length-1]=skillatt;
			attaction=false;

		}

	}
	public void gskillAction() {
		skilltime2++;
		if (att==true) {
			GeneralSkill skillatt = hero.Att();
			idindexword++;
			skillatt.setIdIndex(idindexword);
			//gei给敌人添加唯一标识
			if (enemies.length>0) {
				for (int i = 0; i < enemies.length; i++) {
					enemies[i].setEnemyMap1(idindexword);
				}
				
				
			}
			skill = Arrays.copyOf(skill,skill.length+1); //扩容
			skill[skill.length-1]=skillatt;
			att=false;
		}

	}

	/** 飞行物移动 */
	public void stepAction() { //每10毫秒走一次
		for(int i=0;i<skill.length;i++) { //遍历所有子弹
			skill[i].step(); //子弹动
		}
		for (int i = 0; i < skillfollow.length; i++) {
			skillfollow[i].step();
		}
	}

	//sunwenjiu 
	//获取英雄的血 画英雄的血
	public void heroGague() {
		double a=1;
		int gague=(int)(80*((hero.getlife()*a)/hero.getlifeFather()));
		//	System.out.println("gague"+gague);
		gagueHeroRed.setGague(gague);




	}
	//测试英雄的掉血  删除
	int heroAddGagueindex=0;
	public void 	heroAddGague() {
		heroAddGagueindex++;
		if (heroAddGagueindex%100==0) {
			hero.setLife();
			//测试敌人掉血
			for (int i = 0; i < enemies.length; i++) {
				//enemies[i].setLife();
			}


		}

	}

	//测试的参照物可以删除
	int indexceshi=98;
	public void 	ceshiGetHeroXY() {
		indexceshi++;
		if (indexceshi%100==0) {
			magicianone.getHeroXY(hero.getHeroX(), hero.getHeroY());
			for (int i = 0; i < enemies.length; i++) {
				enemies[i].getHeroXY(hero.getHeroX(), hero.getHeroY());
			}

		}

	}


	public void ceshiMoveToHero() {

		magicianone.moveTo();
		//ceshi.moveTo();
		//	ceshi2.moveTo();
		for (int i = 0; i < enemies.length; i++) {
			enemies[i].moveTo();
		}
	}
	//删除敌人
	public void deleteEnemyGagu() {
		//先设置敌人的gague
		for (int i = 0; i < enemies.length; i++) {
			double a=1;
			int gague=(int)(80*((enemies[i].getLife()*a)/enemies[i].getLifeFather()));
			enemies[i].setGague(gague);
		}
		
		int index=0;
		
		for (int i = 0; i < enemies.length; i++) {
		//	System.out.println(enemies[i].getGague());
			//System.out.println(enemies[i].getGague()<=0);
			if (enemies[i].getGague()<=0) {
			//	System.out.println(enemies.length);
				enemies[i].goDead();
				if ((enemies[i] instanceof MagicianTwo) || (enemies[i] instanceof MagicianOne) ) {
					
					score+=50;
				}else if((enemies[i] instanceof AirOne) || (enemies[i] instanceof AirTwo) ){
					score+=10;
				}else {
					score+=100;
				}
				
				
			}
			
		}
		
		
		//
		EnemyFather[] enemylive=new EnemyFather[enemies.length];
		
		for (int i = 0; i < enemies.length; i++) {
			
			EnemyFather f=enemies[i];
			if (enemies[i].isLife()) {
				enemylive[index]=f;
				index++;
			}
			
		}
		enemies=Arrays.copyOf(enemylive, index);
		
	}
	int indexcheshi=0;
	public void airAndBossHitHero() {
		for (int i = 0; i < enemies.length; i++) {
		
			if ((enemies[i] instanceof AirOne) || (enemies[i] instanceof AirTwo)) {
				if(enemies[i].getfighting()) {
					indexcheshi++;
					hero.setLifeForAirEnemy();
					enemies[i].setfighting();
					//System.out.println(hero.getlife()+"小");
					System.out.println("被砍了"+indexcheshi+"次,英雄的血是:"+hero.getlife());
				
				}
				
			}
			if ((enemies[i] instanceof BossOne) &&enemies[i].getfighting()) {
				indexcheshi++;
					hero.setLifeForBossEnemy();
					enemies[i].setfighting();
				//	System.out.println(hero.getlife()+"大");
					System.out.println("被砍了"+indexcheshi+"次,英雄的血是:"+hero.getlife());

				
				
				
			}
			
			
		}
		
		
	}


	//sunwenjiu e

	public void action() { 

		KeyListener l = new KeyAdapter() {

			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				processRunningKey(key);

			}
			public void keyReleased(KeyEvent e) {
				int keyoff = e.getKeyCode();
				offKey(keyoff);

			}

		};

		this.addKeyListener(l);
		this.setFocusable(true);
		this.requestFocus();


		Timer timer = new Timer(); //定时器对象
		int interval = 10; //定时间隔(以毫秒为单位)
		timer.schedule(new TimerTask() {
			public void run() { //定时干的事--每10毫秒走一次
				music();//测试音乐
				AttackAction();
				moveRightAction();
				moveUpAction();
				moveDownAction();
				moveLeftAction();
				skillAction();//技能特效
				gskillAction();//普通攻击
				enemyskillaction();//跟踪技能
				stepAction();
				enemyBangAction();//碰撞
				outOfBoundsAction();//越界删除
				heroBangAction();
				//System.out.println("skill:"+skill.length+"enemies"+enemies.length);

				//sunwenjiu
				heroGague();//画英雄的血
				//heroAddGague();//测试英雄减去血,要删除

				//测试追随英雄
				ceshiGetHeroXY();
				ceshiMoveToHero();

			
				enterAction();//生成敌人
				
				airAndBossHitHero();
				deleteEnemyGagu();//删除血为0的敌人
				//sunwenjiu e

				repaint();
				//重画(重新调用paint()方法)
			}
		},interval,interval); //定时计划表

	}

	public static void main(String[] args) {
		World world = new World();
		frame.add(world);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true); //1)设置窗口可见  2)尽快调用paint()
		world.action();


	}
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}	
