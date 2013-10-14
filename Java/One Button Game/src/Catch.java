import java.awt.Graphics;


public class Catch
{
	public static String cranestage = "Closed";
	public static String pistonstage = "Open";
	public static String stickstage = "inCrane";
	public static int stickheight = 7;
	public static long drop = 0;
	private static long timelimitupdate = 0;
	public static int score = 0;
	public static int highscore = 0;
	
	
	
	public static void Main() 
	{
		if (Constantes.timelimit == -1)
		{
			drop = (long) (System.currentTimeMillis() + (1000 + (Math.random() * 3000)));
			cranestage = "Closed";
			pistonstage = "Open";
			stickstage = "inCrane";
			stickheight = 12;
			score = 0;
			Constantes.timelimit = 5;
			timelimitupdate = System.currentTimeMillis() + 1000;
		}
		else if (Constantes.timelimit == 0)
		{
			if (highscore < score)
			{
				highscore = score;
			}
			Draw.number(Constantes.graphics, score, 116, 4);
		}
		else
		{
			if (timelimitupdate <= System.currentTimeMillis())
			{
				if (stickstage == "Caught")
				{
					score++;
				}
				Constantes.timelimit--;
				timelimitupdate += 1000;
			}
			Draw.number(Constantes.graphics, Constantes.timelimit, 4, 4);
		}
		
		
		if (stickstage == "Falling")
		{
			stickheight += 6;
		}
		
		
		if (cranestage == "Open" && stickstage == "inCrane")
		{
			stickstage = "Falling";
		}
		
		if (drop <= System.currentTimeMillis())
		{
			cranestage = "Open";
		}
		
		drawCrane(Constantes.graphics);
		drawPistons(Constantes.graphics);
		drawStick(Constantes.graphics);
		
		
	}



	private static void drawCrane(Graphics g)
	{
		g.fillRect(60, 0, 2, 6);
		g.fillRect(66, 0, 2, 6);
		g.fillRect(62, 14, 4, 4);
		g.fillRect(60, 18, 8, 2);
		g.fillRect(56, 20, 4, 2);
		g.fillRect(68, 20, 4, 2);
		
		if (cranestage == "Closed")
		{
			g.fillRect(54, 22, 2, 6);
			g.fillRect(72, 22, 2, 6);
			g.fillRect(56, 28, 4, 2);
			g.fillRect(68, 28, 4, 2);
			g.fillRect(60, 26, 2, 6);
			g.fillRect(66, 26, 2, 6);
		}
		else
		{
			g.fillRect(54, 22, 2, 2);
			g.fillRect(72, 22, 2, 2);
			g.fillRect(52, 24, 2, 4);
			g.fillRect(74, 24, 2, 4);
			g.fillRect(54, 28, 2, 2);
			g.fillRect(72, 28, 2, 2);
			g.fillRect(56, 30, 2, 2);
			g.fillRect(70, 30, 2, 2);
			g.fillRect(58, 28, 2, 6);
			g.fillRect(68, 28, 2, 6);
		}
	}



	private static void drawPistons(Graphics g) 
	{
		g.fillRect(0, 96, 26, 2);
		g.fillRect(0, 104, 26, 2);
		g.fillRect(24, 98, 2, 6);
		
		g.fillRect(102, 96, 26, 2);
		g.fillRect(102, 104, 26, 2);
		g.fillRect(102, 98, 2, 6);
		
		if (pistonstage == "Open")
		{
			g.fillRect(26, 98, 2, 2);
			g.fillRect(26, 102, 2, 2);
			g.fillRect(28, 98, 2, 6);
			
			g.fillRect(30, 100, 2, 2);
			g.fillRect(32, 98, 2, 6);
			
			
			g.fillRect(100, 98, 2, 2);
			g.fillRect(100, 102, 2, 2);
			g.fillRect(98, 98, 2, 6);
			
			g.fillRect(96, 100, 2, 2);
			g.fillRect(94, 98, 2, 6);
		}
		else
		{
			g.fillRect(26, 98, 20, 2);
			g.fillRect(26, 102, 20, 2);
			g.fillRect(46, 98, 2, 6);
			
			g.fillRect(48, 100, 12, 2);
			g.fillRect(60, 98, 2, 6);
			
			
			g.fillRect(82, 98, 20, 2);
			g.fillRect(82, 102, 20, 2);
			g.fillRect(80, 98, 2, 6);
			
			g.fillRect(68, 100, 12, 2);
			g.fillRect(66, 98, 2, 6);
		}
	}



	private static void drawStick(Graphics g) 
	{
		int Y = stickheight * 2;
		g.fillRect(62, Y, 4, 16);
	}

}
