package states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import TFLib.calc.Vector2D;

import data.LevelGenerator;

import objects.Ball;
import objects.levelTiles.BaseTile;

public class Game extends State{
	public Ball ball = new Ball(this);
	public BaseTile[] floor1;
	public BaseTile[] floor2;
	public boolean beforeLaunch = true;
	public Vector2D launchSpeed;
	public float launchPower;
	public Vector2D launchAngle = new Vector2D(0,60);
	private String score;
	private String speed;
	
	int r;
	int g;
	int b;
	byte color = 1;
	
	public Game(){
		floor1 = LevelGenerator.generate();
		for (int i = 0; i < floor1.length; i++){
			floor1[i].x = i*64;
		}
		floor2 = LevelGenerator.generate();
		for (int j = 0; j < floor1.length; j++){
			floor2[j].x = 640+j*64;
		}
		
		r=0;
		g=255;
		b=0;
	}
	
	public void update(long dt){
		if(!beforeLaunch){
			ball.update(dt);
			for (int i = 0; i < floor1.length; i++){
				floor1[i].x -= ball.getXVelocity()/1000*dt;
			}
			for (int i = 0; i < floor1.length; i++){
				floor2[i].x -= ball.getXVelocity()/1000*dt;
			}
			if (floor1[floor1.length-1].x <= -64){
				floor1 = LevelGenerator.generate();
				for (int i = 0; i < floor1.length; i++){
					floor1[i].x = floor2[floor2.length-1].x+64+i*64;
				}
			}else if (floor2[floor2.length-1].x <= -64){
				floor2 = LevelGenerator.generate();
				for (int i = 0; i < floor2.length; i++){
					floor2[i].x = floor1[floor1.length-1].x+64+i*64;
				}
			}
		}
		else{
			if(launchSpeed == null){
				if(launchPower < 100){
					launchPower+=dt/11;
				}else{
					launchPower=-100;
				}
			}else{
				//launchAngle.angle(0);
				if(launchAngle.angle() < (Math.PI/2)){
					launchAngle.angle(launchAngle.angle()+dt*0.0020f);
				}else{
					launchAngle.angle((float)-Math.PI/2);
				}
			}
		}
		score = Float.toString((int)(ball.getXLocation())/64);
		speed = Float.toString((int)(ball.getXVelocity()));
	}
	
	public void draw(Graphics g){
		ball.draw(g);
		for (int i = 0; i < floor1.length; i++){
			floor1[i].draw(g);
		}
		for (int i = 0; i < floor1.length; i++){
			floor2[i].draw(g);
		}
		if(beforeLaunch){
			if (r == 255){
				color = 2;
			}else if (this.g == 255){
				color = 3;
			}else if (b == 255){
				color = 1;
			}
			
			switch(color){
			case 1:
				r++;
				b--;
				break;
			case 2:
				this.g++;
				r--;
				break;
			case 3:
				b++;
				this.g--;
				break;
			}
			
			g.setColor(new Color(r,this.g,b));
			if(launchSpeed == null){
				g.drawRect(30, 150 -Math.abs((int)(launchPower)), 30, Math.abs((int)(launchPower)));
				g.drawRect(30, 50, 30, 100);
			}else{
				g.drawLine(30, 150, 30+Math.abs((int)launchAngle.dx()), 150 - Math.abs((int)launchAngle.dy()));
				g.drawLine(30, 150, 30, 90);
				g.drawLine(30, 150, 90, 150);
			}
		}
		g.setColor(Color.RED);
		if(score != null){
			g.drawString(score, 300, 30);
			g.drawString("score = ", 250, 30);
			g.drawString(speed, 300, 60);
			g.drawString("speed = ", 250, 60);
		}
	}
	
	public BaseTile getTile(float x){
		for (int i = 0; i < floor1.length; i++){
			if (floor1[i].x <= x && floor1[i].x+64 >= x){
				return floor1[i];
			}
		}
		for (int i = 0; i < floor1.length; i++){
			if (floor2[i].x <= x && floor2[i].x+64 >= x){
				return floor2[i];
			}
		}
		return null;
	}
	
	@Override
	public void keyDown(KeyEvent ke) {
		switch (ke.getKeyCode())
		{
		case 32:
			if(beforeLaunch)
			{
				if (launchSpeed == null){
					launchSpeed = new Vector2D(Math.abs(launchPower*10),0);
				}else{
					launchSpeed.angle(-Math.abs(launchAngle.angle()));
					ball.addVelocity(launchSpeed);
					beforeLaunch = false;
				}
			}
			break;
		}
	}
}
