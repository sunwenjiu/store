package com.sunwenjiu.popo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tie extends PopoObject {
	private static BufferedImage image;
	static {
		System.out.println("铁图片静态块");
		image = readImage("tie.png");
	}
	
	

	public Tie( int x, int y) {
		super(100,100, x, y);
		
	}
	
	@Override
	public void step() {  //移动重写
		// TODO Auto-generated method stub
		
	}
	public BufferedImage getImage() {
		if (isLife()) {
			return image;
		} else if(isDead()){
			state = REMOVE;
		}
		return null;
	}

	@Override
	public PopoObject shoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void step0() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void step1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void step2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void step3() {
		// TODO Auto-generated method stub
		
	}

	
}
