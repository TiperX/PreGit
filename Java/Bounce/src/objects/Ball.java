package objects;
import java.awt.Color;
import java.awt.Graphics;

import data.Constants;

import TFLib.calc.Vector2D;
import TFLib.calc.Vector2DOperations;
import states.Game;
public class Ball {
	
	public Graphics graphics;
	
	int r;
	int g;
	int b;
	
	byte color = 1;
	
	private Vector2D velocity;
	private Vector2D location;
	
	private Game parent;
	
	public Ball(Game p)
	{
		parent = p;
		velocity = new Vector2D(0,0);
		location = new Vector2D(100,Constants.stageHeight*Constants.scaling-99);
		r=255;
		g=0;
		b=0;
	}
	
	public void draw(Graphics _g)
	{
		if (r == 255){
			color = 2;
		}else if (g == 255){
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
			g++;
			r--;
			break;
		case 3:
			b++;
			g--;
			break;
		}
		
		_g.setColor(new Color(r,g,b));
		_g.drawOval(100, (int)location.dy(), 32, 32);
		_g.setColor(new Color(r/2,g/2,b/2));
		_g.drawOval(101, (int)location.dy()+1, 30, 30);
		_g.drawOval(99, (int)location.dy()-1, 34, 34);
	}
	
	public float getXVelocity(){
		return velocity.dx();
	}
	
	public float getXLocation(){
		return location.dx();
	}
	
	public void addVelocity(Vector2D v){
		velocity = Vector2DOperations.add(velocity, v);
	}
	
	
	public void update(long dt)
	{
		velocity = Vector2DOperations.add(velocity, new Vector2D(0, Constants.gravity.dy()/1000*dt));
		if (velocity.dx() < 0)
			velocity.dx(0);
		location = Vector2DOperations.add(location, new Vector2D(velocity.dx()/1000*dt, velocity.dy()/1000*dt));
		
		if (location.dy() >= Constants.stageHeight*Constants.scaling-96){
			location.dy(Constants.stageHeight*Constants.scaling-96);
			velocity.dy(-(velocity.dy()-20));
			switch(parent.getTile(100).getEffect()){
			case "SpeedUp":
				velocity.dx((velocity.dx()+10)*3);
				break;
			case "Bounce":
				velocity.dy((velocity.dy()-10)*2);
				velocity.dx(velocity.dx()+50);
				break;
			default:
				velocity.dx(velocity.dx() < 300 ? velocity.dx()/4*3 : velocity.dx()-100);
				velocity.dy(velocity.dy()/10*9);
				break;
			}
		}
		
		if(velocity.dx() > 10000)
			velocity.dx(10000);
	}
}
