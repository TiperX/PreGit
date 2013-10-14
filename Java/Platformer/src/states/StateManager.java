package states;

import java.util.ArrayList;

import data.Constants;
import data.Listener;

public class StateManager {
	
	public static enum gameStates{
		menu, game, options, pause;
	}
	
	public static ArrayList<State> stateList = new ArrayList<State>();
	
	public static void launch() {
		stateList.add(new Menu());
		Listener l = new Listener();
		Constants.STAGE.addKeyListener(l);
		Constants.STAGE.addMouseMotionListener(l);
		Constants.STAGE.addMouseListener(l);
		loop();
	}
	
	public static void change(gameStates id) {
		if (stateList.size() > 0){
			remove();
			add(id);
		}
	}
	
	public static void remove(){
		if (stateList.size() > 0){
			stateList.remove(stateList.size()-1);
		}
	}
	
	public static void add(gameStates id){
		switch(id){
		case game:
				stateList.add(new Game());
			break;
		case menu:
				stateList.add(new Menu());
			break;
		case options:
				stateList.add(new Options());
			break;
		case pause:
				stateList.add(new Pause());
		default:
			break;
		}
	}
	
	private static void loop(){
		long dt = 0;
		long last = System.currentTimeMillis();
		while (Constants.running){
			dt = System.currentTimeMillis() - last;
			if (dt >= 10){
				last = System.currentTimeMillis();
				
				if (stateList.size() != 0)stateList.get(stateList.size()-1).update(dt);
				
				Constants.image = Constants.STAGE.createImage(Constants.stageWidth/4, Constants.stageHeight/4);
				Constants.graphics = Constants.image.getGraphics();
				
				if (stateList.size() != 0)stateList.get(stateList.size()-1).draw(Constants.graphics);
				
				Constants.STAGE.repaint();
			}
		}
	}
}
