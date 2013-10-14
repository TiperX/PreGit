package Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import states.Game;

public class Attack extends BaseEntity {
	
	private Player parent2;
	private int power;
	private int knockback;
	private int counter;

	public Attack(float[] location, int[] dimensions, String hitboxShape,
			Image spriteSheet, int[] frameDimensions, int[] animationframes, int power, int kb, 
			Player parent) {
		super(location, dimensions, hitboxShape, spriteSheet, frameDimensions,
				animationframes, parent.parent);
		parent2 = parent;
		this.power = power;
		this.knockback = kb;
	}
	
	@Override
	public void update(long dt){
		counter += dt;
		
		this.location[0] += parent2.velocity[0]*dt/1000;
		this.location[1] += parent2.velocity[1]*dt/1000;
		
		hitbox.x = (int)location[0];
		hitbox.y = (int)location[1];
		
		if(counter >= 200)
		{
			parent.attacks.remove(this);
		}
	}
	
	@Override
	public void draw(Graphics g){
		g.setColor(parent2.color);
		g.fillRect(hitbox.x, hitbox.y, hitbox.w, hitbox.h);
		g.setColor(Color.white);
		g.drawRect(hitbox.x, hitbox.y, hitbox.w-1, hitbox.h-1);
	}
	
	public void CollisionReaction(Player p, int[] displacement){
		if(p != parent2){
			p.addDamage(power);
			p.knockback(knockback, displacement);
			parent.attacks.remove(this);
		}
	}
}
