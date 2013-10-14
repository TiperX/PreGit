package Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import states.Game;

import TFLib.TFCollider;

import data.Constants;

public class Player extends BaseEntity{
	public float[] velocity;
	private boolean up = false;
	private boolean down = false;
	private boolean left = false;
	private boolean right = false;
	private boolean ground = false;
	private boolean dJump = false;
	private boolean attack = false;
	private int attackdelay = 0;
	private int[] controls;
	public int damage;
	private int side;
	public Color color;
	public int lives = 3;
	
	
	public Player(float[] location, int[] dimensions, String hitboxShape, Image spriteSheet,  int[] frameDimensions, int[] animationframes, Color c, Game parent) {
		super(location, dimensions, hitboxShape, spriteSheet, frameDimensions, animationframes, parent);
		velocity = new float[]{0, 0};
		color = c;
		damage = 0;
		name = "Player";
	}
	
	public void setControls(int[] controls){
		this.controls = controls;
	}
	
	public void setControls(int up, int down, int left, int right, int jump, int attack){
		controls = new int[]{up, down, left, right, jump, attack};
	}
	
	@Override
	public void update(long dt){
		lastFrameUpdate += dt;
		if (lastFrameUpdate >= 1000 / Constants.frameRate){
			lastFrameUpdate -= 1000 / Constants.frameRate;
			currentframe = (currentframe+1 >= animationframes[currentAnimation] ? 0 : currentframe+1);
		}
		if (right && velocity[0] < 50){
			velocity[0] += 500*dt/1000;
		}else if (left && velocity[0] > -50){
			velocity[0] -= 500*dt/1000;
		}else if (velocity[0] != 0){
			velocity[0] += (velocity[0] > 0 ? -500*dt/1000 : 500*dt/1000);
		}
		attackdelay -= dt;
		if (attack && attackdelay <= 0){
			attackdelay = 1000;
			if (up){
				parent.attacks.add(new Attack(new float[]{location[0] + 1, location[1] - 4}, new int[]{dimensions[0] - 2, 4}, "box", null, null, null, (velocity[1] < 0 ? 15 : 3), 10, this));
			}else if (down){
				if(ground){
					parent.attacks.add(new Attack(new float[]{location[0] + 1, location[1] + dimensions[1] - 4}, new int[]{dimensions[0] - 2,4}, "box", null, null, null, 3, 10, this));
				}else{
					parent.attacks.add(new Attack(new float[]{location[0] + 1, location[1] + dimensions[1]}, new int[]{dimensions[0] - 2,4}, "box", null, null, null, (velocity[1] > 0 ? 15 : 3), 10, this));	
				}
			}else{
				if (side == 0){
					parent.attacks.add(new Attack(new float[]{location[0] - 4, location[1] + 6}, new int[]{12, dimensions[1] - 12}, "box", null, null, null, velocity[0] < 0 ? 15 : 3, 10, this));
				}else if (side == 1){
					parent.attacks.add(new Attack(new float[]{location[0] + dimensions[0] - 8, location[1] + 6}, new int[]{12, dimensions[1] - 12}, "box", null, null, null, velocity[0] > 0 ? 15 : 3, 10, this));
				}
			}
		}
		
		velocity[1] += Constants.gravity*dt/1000;
		
		location[0] += velocity[0] * dt / 1000;
		location[1] += velocity[1] * dt / 1000;
		
		hitbox.x = (int) location[0];
		hitbox.y = (int) location[1];
		
		if (TFCollider.mapCollisionB(parent.map, hitbox, 16)){
			int[] temp = TFCollider.mapCollision(parent.map, hitbox, 16);
			if (temp[0] == 0){
				hitbox.x += temp[0];	
				hitbox.y += temp[1];
				velocity[1] = -velocity[1];	
			}else if (temp[1] == 0){
				hitbox.x += temp[0];
				hitbox.y += temp[1];
				velocity[0] = -velocity[0];
			}else{
				if (Math.abs(temp[0]) < Math.abs(temp[1])){
					hitbox.x += temp[0];
					velocity[0] = -velocity[0];
				}else{
					hitbox.y += temp[1];
					velocity[1] = -velocity[1];	
				}
			}
			location[0] = hitbox.x;
			location[1] = hitbox.y;
		}
		
		for (BaseEntity e : parent.entities){
			if (e.getName() != "Player"){
				
			}
		}
		for (int i = parent.attacks.size()-1; i >= 0; i--){
			int[] temp = TFCollider.collide(this.hitbox, parent.attacks.get(i).hitbox);
			if (temp != null && (temp[1] != 0 || temp[0] != 0)){
				//System.out.println(temp[0] + " : " + temp[1]);
				parent.attacks.get(i).CollisionReaction(this, temp);
			}
		}
		
		hitbox.y++;
		if (TFCollider.mapCollisionB(parent.map, hitbox, 16) && velocity[1] >= 0){
			velocity[1] -= (velocity[1] > 100 ? 100 : velocity[1]);
			ground = true;
			dJump = true;
		}else{
			ground = false;
		}
		hitbox.y--;
		
		if (this.location[0] > 20*16 || this.location[0] < -4*16 || this.location[1] < -10*16 || this.location[1] > 16*16){
			if (this.lives > 0){
				this.velocity = new float[]{0,0};
				this.location = new float[]{7.5f*16, 32};
				this.damage = 0;
				this.lives --;
			}else{
				this.velocity = new float[]{0,0};
				this.location = new float[]{-200, -200};
				this.damage = 0;
			}
		}
	}
	
	@Override
	public void draw(Graphics g){
		g.setColor(color);
		g.drawRect((int)location[0], (int)location[1], dimensions[0]-1, dimensions[1]-1);
		
		//g.drawImage(spriteSheet, (int)location[0], (int)location[1], (int)location[0] + frameDimensions[0], (int)location[1] + frameDimensions[1], frameDimensions[0] * currentframe, frameDimensions[1] * currentAnimation, frameDimensions[0] * (currentframe+1), frameDimensions[1] * (currentAnimation+1), null);
	}
	
	public void keyDown(KeyEvent ke) {
		if(ke.getKeyCode() == controls[2]){
			left = true;
			side = 0;
			//location[0] --;
		}
		if (ke.getKeyCode() == controls[0]){
			up = true;
			//location[1] --;
		}
		if(ke.getKeyCode() == controls[3]){
			right = true;
			side = 1;
			//location[0] ++;
		}
		if (ke.getKeyCode() == controls[1]){
			down = true;
			//location[1] ++;
		}
		if (ke.getKeyCode() == controls[4]){
			if (ground || dJump)/**/{
				if (!ground){
					dJump = false;
				}
				velocity[1] = -Constants.gravity;
			}
		}
		if (ke.getKeyCode() == controls[5]){
			attack = true;
		}
	}

	public void keyUp(KeyEvent ke) {
		if(ke.getKeyCode() == controls[2]){
			left = false;
		}
		if (ke.getKeyCode() == controls[0]){
			up = false;
		}
		if(ke.getKeyCode() == controls[3]){
			right = false;
		}
		if (ke.getKeyCode() == controls[1]){
			down = false;
		}
		if (ke.getKeyCode() == controls[5]){
			attack = false;
		}
	}

	public void addDamage(int damage) {
		this.damage += damage;
	}

	public void knockback(int knockback, int[] displacement) {
		velocity[0] -= displacement[0]*(knockback + (knockback*damage/100));
		velocity[1] -= displacement[1]*(knockback + (knockback*damage/100));
	}
}
