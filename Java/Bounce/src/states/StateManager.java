package states;

import java.awt.Color;
import java.util.ArrayList;

import data.Constants;
import data.LevelGenerator;
import data.Listener;

public class StateManager {
	
	public static enum gameStates{
		menu, game;
	}
	
	public static ArrayList<State> stateList = new ArrayList<State>();
	
	public static void launch() {
		stateList.add(new Menu());
		Listener l = new Listener();
		Constants.STAGE.addKeyListener(l);
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
		default:
			break;
		}
	}
	
	private static void loop(){
		long dt = 0;
		long last = System.currentTimeMillis();
		while (Constants.running){
			dt = System.currentTimeMillis() - last;
			if (dt > 10){
				last = System.currentTimeMillis();
				
				if (stateList.size() != 0)stateList.get(stateList.size()-1).update(dt);
				
				Constants.image = Constants.STAGE.createImage((int)(Constants.stageWidth * Constants.scaling), (int)(Constants.stageHeight * Constants.scaling));
				Constants.graphics = Constants.image.getGraphics();
				
				if (stateList.size() != 0)stateList.get(stateList.size()-1).draw(Constants.graphics);
				Constants.STAGE.repaint();
			}
		}
	}
}
