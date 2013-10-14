import java.awt.Graphics;


public class Flagpole 
{
	public static int wheelstage = 0;
	public static int flagstage = 0;
	public static int flagframe = 6;
	private static long timelimitupdate = 0;
	public static int score = 0;
	public static int highscore = 0;
	
	public static void Main()
	{
		if (Constantes.timelimit == -1)
		{
			flagstage = 0;
			wheelstage = 0;
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
				if (flagstage == 36)
				{
					score++;
				}
				Constantes.timelimit--;
				timelimitupdate += 1000;
			}
			Draw.number(Constantes.graphics, Constantes.timelimit, 4, 4);
		}
		
		flagframe--;
		if (flagframe == 0)
		{
			flagframe = 6;
		}
		drawBG(Constantes.graphics);
		drawAnimated(Constantes.graphics);
	}
	
	private static void drawAnimated(Graphics g) 
	{
		int X = 0;
		int Y = 0;
		
		switch(wheelstage)
		{
		case 0 :
			X = 62;
			Y = Constantes.stageHeight - 26;
			break;
		case 1 :
			X = 62;
			Y = Constantes.stageHeight - 28;
			break;
		case 2 :
			X = 60;
			Y = Constantes.stageHeight - 28;
			break;
		case 3 :
			X = 58;
			Y = Constantes.stageHeight - 28;
			break;
		case 4 :
			X = 58;
			Y = Constantes.stageHeight - 26;
			break;
		case 5 :
			X = 58;
			Y = Constantes.stageHeight - 24;
			break;
		case 6 :
			X = 60;
			Y = Constantes.stageHeight - 24;
			break;
		case 7 :
			X = 62;
			Y = Constantes.stageHeight - 24;
			break;
		}
		g.fillRect(X, Y, 2, 2);
		
		X = 26;
		Y = 88 - (2 * flagstage);
		switch (flagframe)
		{
		case 1 :
			g.fillRect(X + 2, Y, 4, 2);
			g.fillRect(X + 6, Y + 2, 6, 2);
			g.fillRect(X + 12, Y, 6, 2);
			g.fillRect(X + 18, Y + 2, 4, 2);
			
			g.fillRect(X, Y + 2, 2, 8);
			
			g.fillRect(X, Y + 10, 4, 2);
			g.fillRect(X + 4, Y + 12, 6, 2);
			g.fillRect(X + 10, Y + 10, 6, 2);
			g.fillRect(X + 16, Y + 12, 6, 2);
			break;
		case 2 :
			g.fillRect(X + 2, Y, 6, 2);
			g.fillRect(X + 8, Y + 2, 6, 2);
			g.fillRect(X + 14, Y, 6, 2);
			g.fillRect(X + 20, Y + 2, 2, 2);
			
			g.fillRect(X + 2, Y + 2, 2, 4);
			g.fillRect(X, Y + 6, 2, 4);
			
			g.fillRect(X, Y + 10, 6, 2);
			g.fillRect(X + 6, Y + 12, 6, 2);
			g.fillRect(X + 12, Y + 10, 6, 2);
			g.fillRect(X + 18, Y + 12, 4, 2);
			break;
		case 3 :
			g.fillRect(X, Y + 2, 4, 2);
			g.fillRect(X + 4, Y, 6, 2);
			g.fillRect(X + 10, Y + 2, 6, 2);
			g.fillRect(X + 16, Y, 6, 2);
			
			g.fillRect(X, Y + 4, 2, 10);
			
			g.fillRect(X + 2, Y + 10, 6, 2);
			g.fillRect(X + 8, Y + 12, 6, 2);
			g.fillRect(X + 14, Y + 10, 6, 2);
			g.fillRect(X + 20, Y + 12, 2, 2);
			break;
		case 4 :
			g.fillRect(X, Y + 2, 6, 2);
			g.fillRect(X + 6, Y, 6, 2);
			g.fillRect(X + 12, Y + 2, 6, 2);
			g.fillRect(X + 18, Y, 4, 2);
			
			g.fillRect(X, Y + 4, 2, 4);
			g.fillRect(X + 2, Y + 8, 2, 2);
			g.fillRect(X, Y + 12, 4, 2);
			
			g.fillRect(X + 2, Y + 10, 8, 2);
			g.fillRect(X + 10, Y + 12, 6, 2);
			g.fillRect(X + 16, Y + 10, 6, 2);
			break;
		case 5 :
			g.fillRect(X + 2, Y + 2, 6, 2);
			g.fillRect(X + 8, Y, 6, 2);
			g.fillRect(X + 14, Y + 2, 6, 2);
			g.fillRect(X + 20, Y, 2 ,2);
			
			g.fillRect(X, Y + 4, 2, 8);
			
			g.fillRect(X, Y + 12, 6, 2);
			g.fillRect(X + 6, Y + 10, 6, 2);
			g.fillRect(X + 12, Y + 12, 6, 2);
			g.fillRect(X + 18, Y + 10, 4, 2);
			break;
		case 6 :
			g.fillRect(X + 2, Y, 2, 2);
			g.fillRect(X + 4, Y + 2, 6, 2);
			g.fillRect(X + 10, Y, 6, 2);
			g.fillRect(X + 16, Y + 2, 6, 2);
			
			g.fillRect(X, Y + 2, 2, 6);
			g.fillRect(X + 2, Y + 8, 2, 4);
			
			g.fillRect(X + 2, Y + 12, 6, 2);
			g.fillRect(X + 8, Y + 10, 6, 2);
			g.fillRect(X + 14, Y + 12, 6, 2);
			g.fillRect(X + 20, Y + 10, 2, 2);
			break;
		}
	}

	public static void drawBG(Graphics g)
	{
		//floor
		g.fillRect(0, Constantes.stageHeight - 18, 128, 2);
		
		//pole base
		g.fillRect(38, Constantes.stageHeight - 24, 2, 6);
		g.fillRect(40, Constantes.stageHeight - 26, 16, 2);
		g.fillRect(62, Constantes.stageHeight - 20, 2, 2);
		
		//wheel
		g.fillRect(58, Constantes.stageHeight - 30, 6, 2);
		g.fillRect(56, Constantes.stageHeight - 28, 2, 6);
		g.fillRect(64, Constantes.stageHeight - 28, 2, 6);
		g.fillRect(58, Constantes.stageHeight - 22, 6, 2);
		g.fillRect(60, Constantes.stageHeight - 26, 2, 2);
		
		//pole
		g.fillRect(48, 16, 2, 86);
		g.fillRect(52, 16, 2, 86);
		g.fillRect(48, 14, 6, 2);
		g.fillRect(48, 10, 6, 2);
		g.fillRect(46, 12, 2, 2);
		g.fillRect(54, 12, 2, 2);
	}
	
}
