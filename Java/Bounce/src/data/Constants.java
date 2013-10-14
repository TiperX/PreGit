package data;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.JFrame;

import TFLib.calc.Vector2D;
public class Constants {
	public static Image image;
	public static Graphics graphics;
	
	public static int stageWidth = 1280;
	public static int stageHeight = 800;
	public static float scaling = 0.5f;
	public static JFrame STAGE = new JFrame(){
									/**
									 * 
									 */
									private static final long serialVersionUID = -4191310025063605502L;

									public void paint(Graphics g){
										g.drawImage(Constants.image, 0, 0, stageWidth, stageHeight, null);
									}
								};
	public static boolean running = true;
	
	public static int floor = 0;
	
	public static Vector2D gravity = new Vector2D(0, 98.1f);
}
