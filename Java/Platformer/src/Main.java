import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOError;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import TFLib.TFSound;

import states.StateManager;

import data.*;


public class Main {
	public static void main(String[] args){
		new Main();
	}
	
	public Main(){
		Constants.STAGE.setTitle("Platformer");
		//Constants.STAGE.setUndecorated(true);
		Constants.STAGE.setVisible(true);
		Constants.STAGE.setBackground(Color.black);
		Constants.STAGE.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Constants.STAGE.setSize(Constants.stageWidth, Constants.stageHeight);
		Constants.STAGE.setLocationRelativeTo(null);
		
		
		
		String url;
		File f;
		
		url = "//home//" + System.getProperty("user.name") + "//TFImages//SuperSmashBloks//";
		f = new File(url + "tileset.png");
		if (!f.exists()){	
			url = "C://Users//" + System.getProperty("user.name") + "//TFImages//SuperSmashBloks//";
			f = new File(url + "tileset.png");
		}
		if (!f.exists()){
			url = "C://Gebruikers//" + System.getProperty("user.name") + "//TFImages//SuperSmashBloks//";
			f = new File(url + "tileset.png");
		}
		if (!f.exists()){	
			url = "/Users//" + System.getProperty("user.name") + "//TFImages//SuperSmashBloks//";
			f = new File(url + "tileset.png");
		}
		if (f.exists()){
			try{
				Images.tileset = ImageIO.read(new File(url + "tileset.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		StateManager.launch();
	}
}
