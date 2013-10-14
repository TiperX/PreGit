package Entities;

import java.awt.Graphics;
import java.awt.Image;

import states.Game;

import TFLib.ColliderObject;

public class BaseEntity {
	protected float[] location;
	protected int[] dimensions;
	protected ColliderObject hitbox;
	protected Image spriteSheet;
	protected int[] animationframes;
	protected int[] frameDimensions;
	protected int currentframe;
	protected int currentAnimation;
	protected long lastFrameUpdate;
	protected Game parent;
	protected String name;
	
	public BaseEntity(float[] location, int[] dimensions, String hitboxShape, Image spriteSheet, int[] frameDimensions, int[] animationframes, Game parent){
		this.location = location;
		this.dimensions = dimensions;
		hitbox = new ColliderObject((int)location[0], (int)location[1], dimensions[0], dimensions[1], hitboxShape);
		this.spriteSheet = spriteSheet;
		this.animationframes = animationframes;
		currentAnimation = 0;
		lastFrameUpdate = 0;
		this.frameDimensions = frameDimensions;
		this.parent = parent;
		name = "BaseEntity";
	}
	
	public String getName(){
		return name;
	}
	
	public <get> ColliderObject hitbox(){
		return hitbox;
	}
	
	public <get> float[] location(){
		return location;
	}
	
	public <get> int[] dimensions(){
		return dimensions;
	}
	
	public void update(long dt){
		
	}
	
	public void draw(Graphics g){
		
	}
}
