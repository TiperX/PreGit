package Entities;

import java.awt.Graphics;
import java.awt.Image;

import states.Game;

public class BaseBlock extends BaseEntity{
	
	public BaseBlock(float[] location, String hitboxShape, Image spriteSheet, int[] animationframes, Game parent) {
		super(location, new int[]{16, 16}, hitboxShape, spriteSheet, new int[]{16, 16}, animationframes, parent);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void update(long dt){
		
	}
	
	@Override
	public void draw(Graphics g){
		
	}
}
