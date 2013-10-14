package data;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import states.StateManager;

public class Listener implements KeyListener, MouseListener, MouseMotionListener{

	@Override
	public void mouseDragged(MouseEvent me) {
		StateManager.stateList.get(StateManager.stateList.size()-1).mouseMoved(me);
	}

	@Override
	public void mouseMoved(MouseEvent me) {
		StateManager.stateList.get(StateManager.stateList.size()-1).mouseMoved(me);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent me) {
		StateManager.stateList.get(StateManager.stateList.size()-1).mouseDown(me);
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		StateManager.stateList.get(StateManager.stateList.size()-1).mouseUp(me);
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		StateManager.stateList.get(StateManager.stateList.size()-1).keyDown(ke);
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		StateManager.stateList.get(StateManager.stateList.size()-1).keyUp(ke);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
