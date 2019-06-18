package com.sunwenjiu.popo;

import java.awt.image.BufferedImage;

public class Map extends PopoObject {
	private static BufferedImage image;
	static {
		System.out.println("地图图片静态块");
		image = readImage("map.png");
		
	}
int a ;

public Map() {
	super(900, 900, 0, 0);
	this.a = a;
}

@Override
public void step() {  //移动重写
	// TODO Auto-generated method stub
	
}

public BufferedImage getImage() {
	return image;
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

	

