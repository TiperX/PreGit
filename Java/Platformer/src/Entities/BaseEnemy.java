package Entities;

import java.awt.Graphics;
import java.awt.Image;

import states.Game;

public class BaseEnemy extends BaseEntity{

	public BaseEnemy(float[] location, int[] dimensions, String hitboxShape, Image spriteSheet,  int[] frameDimensions, int[] animationframes, Game parent) {
		super(location, dimensions, hitboxShape, spriteSheet, frameDimensions, animationframes, parent);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void update(long dt){
		
	}
	
	@Override
	public void draw(Graphics g){
		
	}
}
