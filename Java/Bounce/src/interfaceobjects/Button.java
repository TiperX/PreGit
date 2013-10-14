package interfaceobjects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;


public class Button {
	public enum states{
		normal,
		over,
		down
	}
	private states state = states.normal;
	
	public boolean clicked = false;
	
	public int[] coords = new int[2];
	public int[] dimensions = new int[2];
	
	public Image normalImage;
	public Image mouseOver;
	public Image down;
	
	private boolean over = false;
	
	public Button(int x, int y, int w, int h){
		coords[0] = x;
		coords[1] = y;
		dimensions[0] = w;
		dimensions[1] = h;
	}
	
	public void setImages(Image normal, Image over, Image down){
		normalImage = normal;
		mouseOver = over;
		this.down = down;
	}
	
	public void draw(Graphics g){
		switch (state){
		case down:
			if (down != null){
				g.drawImage(down, coords[0], coords[1], dimensions[0], dimensions[1], null);
				break;
			}
		case over:
			if (mouseOver != null){
				g.drawImage(mouseOver, coords[0], coords[1], dimensions[0], dimensions[1], null);
				break;
			}
		case normal:
			if (normalImage != null){
				g.drawImage(normalImage, coords[0], coords[1], dimensions[0], dimensions[1], null);
			}
			break;
		}
	}
	
	public void mouseMoved(MouseEvent me){
		if (me.getX() > coords[0] && me.getX() < coords[0] + dimensions[0] && me.getY() > coords[1] && me.getY() < coords[1] + dimensions[1]){
			over = true;
			if (state != states.down)state = states.over;
		}else{
			over = false;
			state = states.normal;
		}
	}
	
	public void mouseUp(MouseEvent me){
		if (over){
			state = states.over;
			clicked = true;
		}else{
			state = states.normal;
		}
	}
	
	public void mouseDown(MouseEvent me){
		if (over){
			state = states.down;
		}else{
			state = states.normal;
		}
	}
}
