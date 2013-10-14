import java.awt.Graphics;
import java.awt.Image;


public class Constantes 
{
	public static int stageWidth = 128;
	public static int stageHeight = 128;
	
	public static Image image = null;
	public static Graphics graphics;
	public static int framerate = 12;
	public static long update = System.currentTimeMillis() + (1000/framerate);
	
	public static String currentscreen = "Menu";
	public static int timelimit = -1;
	
}
