import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

import states.StateManager;

import data.Constants;


public class Main {
	public static void main(String[] args){
		new Main();
	}

	public Main(){
		Constants.STAGE.setTitle("Bounce");
		Constants.STAGE.setUndecorated(true);
		Constants.STAGE.setVisible(true);
		Constants.STAGE.setBackground(Color.black);
		Constants.STAGE.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Constants.STAGE.setSize(Constants.stageWidth, Constants.stageHeight);
		Constants.STAGE.setLocationRelativeTo(null);
		
		StateManager.launch();
		/**/
	}
}
