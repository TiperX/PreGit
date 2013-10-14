package states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import Entities.*;

import data.Constants;
import data.Images;
import data.Maps;
import java.util.ArrayList;

public class Game extends State{
	public ArrayList<BaseEntity> entities = new ArrayList<BaseEntity>();
	public ArrayList<Attack> attacks = new ArrayList<Attack>();
	public int[][] map;
	public Game(){
		map = Maps.world1;
		entities.add(new Player(new float[]{2*16, 48}, new int[]{15, 15}, "box", null, new int[]{40, 52}, new int[]{4}, Color.red, this));
		((Player) entities.get(0)).setControls(Constants.controls[0]);
		entities.add(new Player(new float[]{13*16, 48}, new int[]{15, 15}, "box", null, new int[]{40, 52}, new int[]{4}, Color.blue, this));
		((Player) entities.get(1)).setControls(Constants.controls[1]);
		if (Constants.players > 2){
			entities.add(new Player(new float[]{10*16, 48}, new int[]{15, 15}, "box", null, new int[]{40, 52}, new int[]{4}, Color.green, this));
			((Player) entities.get(2)).setControls(Constants.controls[2]);	
		}
		if (Constants.players > 3){
			entities.add(new Player(new float[]{5*16, 48}, new int[]{15, 15}, "box", null, new int[]{40, 52}, new int[]{4}, Color.yellow, this));
			((Player) entities.get(3)).setControls(Constants.controls[3]);
		}
	}

	@Override
	public void update(long dt){
		for (BaseEntity e : entities){
			e.update(dt);
		}
		for (int i = attacks.size()-1; i >= 0; i--){
			attacks.get(i).update(dt);
		}
		//System.out.println();
	}
	
	@Override
	public void draw(Graphics g){
		for (int i = 0; i < Maps.world1.length; i++)
		for (int j = 0; j < Maps.world1[0].length; j++){
			Maps.draw(j, i, g);
		}
		for (BaseEntity e : entities){
			e.draw(g);
		}
		for (Attack a : attacks){
			a.draw(g);
		}
		
		g.setColor(((Player)(entities.get(0))).color);
		g.drawString(((Player)(entities.get(0))).damage + "%", 32, 16);
		for (int i = 0; i < ((Player)(entities.get(0))).lives; i++){
			g.drawRect(32 + 2*i, 17, 0, 0);
		}

		g.setColor(((Player)(entities.get(1))).color);
		g.drawString(((Player)(entities.get(1))).damage + "%", 208, 16);
		for (int i = 0; i < ((Player)(entities.get(1))).lives; i++){
			g.drawRect(208 + 2*i, 17, 0, 0);
		}
		
		if (Constants.players > 2){
			g.setColor(((Player)(entities.get(2))).color);
			g.drawString(((Player)(entities.get(2))).damage + "%", 160, 16);
			for (int i = 0; i < ((Player)(entities.get(2))).lives; i++){
				g.drawRect(160 + 2*i, 17, 0, 0);
			}
		}
		if (Constants.players > 3){
			g.setColor(((Player)(entities.get(3))).color);
			g.drawString(((Player)(entities.get(3))).damage + "%", 80, 16);
			for (int i = 0; i < ((Player)(entities.get(3))).lives; i++){
				g.drawRect(80 + 2*i, 17, 0, 0);
			}
		}
	}
	
	@Override
	public void keyDown(KeyEvent ke) {
		((Player)entities.get(0)).keyDown(ke);
		((Player)entities.get(1)).keyDown(ke);
		if (Constants.players > 2){
			((Player) entities.get(2)).keyDown(ke);	
		}
		if (Constants.players > 3){
			((Player) entities.get(3)).keyDown(ke);
		}
	}

	@Override
	public void keyUp(KeyEvent ke) {
		if (ke.getKeyCode() == 27){
			StateManager.change(StateManager.gameStates.menu);
		}else{
			((Player)entities.get(0)).keyUp(ke);
			((Player)entities.get(1)).keyUp(ke);
			if (Constants.players > 2){
				((Player)entities.get(2)).keyUp(ke);	
			}
			if (Constants.players > 3){
				((Player)entities.get(3)).keyUp(ke);
			}
		}
	}
}
