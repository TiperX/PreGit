import java.awt.Graphics;


public class Bowshot 
{
	public static String bowstage = "Ready";
	public static String arrowstage = "OnBow";
	public static int bowheight = 10;
	private static int bowmovement = 4;
	public static int targetheight = 0;
	private static long timelimitupdate = 0;
	public static int score = 0;
	public static int highscore = 0;
	
	public static void Main()
	{
		if (Constantes.timelimit == -1)
		{
			bowstage = "Ready";
			arrowstage = "OnBow";
			bowheight = 64;
			targetheight = (int) (2 * Math.random() * 32);
			score = 0;
			Constantes.timelimit = 3;
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
				if (bowstage == "Ready")
				{
					bowheight++;
				}
				else if (arrowstage == "Hit")
				{
					score++;
				}
				Constantes.timelimit--;
				timelimitupdate += 1000;
			}
			Draw.number(Constantes.graphics, Constantes.timelimit, 4, 4);
		}
		
		if (bowstage == "Ready")
		{
			bowheight += bowmovement;
		}
		if (bowheight >= 96 || bowheight <= 32)
		{
			bowmovement *= -1;
			bowheight += bowmovement;
		}
		drawbow(Constantes.graphics);
		drawarrow(Constantes.graphics);
		drawtarget(Constantes.graphics);
		if (bowstage == "Shot")
		{
			if (bowheight > 32 + targetheight - 6 && bowheight < 32 + targetheight + 8)
			{
				arrowstage = "Hit";
			}
			else
			{
				arrowstage = "Miss";
			}
			
		}
	}

	private static void drawtarget(Graphics g) 
	{
		g.fillRect(100, 32 + targetheight - 6, 2, 14);
		g.fillRect(104, 32 + targetheight - 6, 2, 14);
		g.fillRect(102, 32 + targetheight - 6, 2, 2);
		g.fillRect(102, 32 + targetheight - 6 + 12, 2, 2);
		
	}

	private static void drawarrow(Graphics g) 
	{
		int Y = bowheight;
		int X = 0;
		
		if (arrowstage == "OnBow")
		{
			X = 26;
		}
		else if (arrowstage == "Shot")
		{
			X = 64;
		}
		else if (arrowstage == "Miss")
		{
			X = 128;
		}
		else
		{
			X = 100;
		}
		
		g.fillRect(X - 14, Y - 2, 4, 2);
		g.fillRect(X - 14, Y + 2, 4, 2);
		
		g.fillRect(X - 12, Y, 16, 2);
		g.fillRect(X, Y - 2, 2, 6);
	}

	private static void drawbow(Graphics g) 
	{
		int Y = bowheight - 16;
		//Bow Handle
		g.fillRect(18, Y, 2, 2);
		g.fillRect(16, Y + 2, 2, 4);
		g.fillRect(18, Y + 6, 2, 4);
		g.fillRect(20, Y + 10, 2, 2);
		g.fillRect(22, Y + 12, 2, 10);
		g.fillRect(20, Y + 22, 2, 2);
		g.fillRect(18, Y + 24, 2, 4);
		g.fillRect(16, Y + 28, 2, 4);
		g.fillRect(18, Y + 32, 2, 2);
		
		if (bowstage == "Ready")
		{
			g.fillRect(14, Y + 6, 2, 6);
			g.fillRect(12, Y + 12, 2, 10);
			g.fillRect(14, Y + 22, 2, 6);
		}
		else
		{
			g.fillRect(16, Y + 6, 2, 22);
		}
	}
}
