package states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Pause extends State{
	@Override
	public void draw(Graphics g){
		g.setColor(Color.white);
		g.drawString("PAUSE", 300, 300);
	}
	
	@Override
	public void keyUp(KeyEvent ke){
		StateManager.remove();
	}
}
