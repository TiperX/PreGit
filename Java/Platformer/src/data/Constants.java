package data;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;

public class Constants {
	public static Image image;
	public static Graphics graphics;
	
	public static int stageWidth = 4*16*16;
	public static int stageHeight = 4*16*12;
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
	public static int frameRate = 6;
	
	
	public static float gravity = 100;
	
	public static byte players = 4;
	public static int[][] controls = {{87, 83, 65, 68, 87, 69}, {38, 40, 37, 39, 38, 16}, {104, 101, 100, 102, 104, 105}, {104, 101, 102, 100, 104, 105}};
}
