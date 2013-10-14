import java.awt.Graphics;


public class Draw 
{
	public static void Menu(Graphics g) 
	{	
		//Play Button
		
		//Border
		BtnBorder(g, 26, 30);
		//P
		letter(g, "P", 30, 34);
		//l
		letter(g, "l", 40 ,34);
		//a
		letter(g, "a", 44 ,34);
		//y
		letter(g, "y", 52 ,34);
		//G
		letter(g, "G", 62, 34);
		//a
		letter(g, "a", 72, 34);
		//m
		letter(g, "m", 80, 34);
		//e
		letter(g, "e", 92, 34);
		
		//Help Button
		
		//Border
		BtnBorder(g, 26, 52);
		//H
		letter(g, "H", 50, 56);
		//e
		letter(g, "e", 60, 56);
		//l
		letter(g, "l", 68, 56);
		//p
		letter(g, "p", 72, 56);
		
		//Quit Button
		
		//Border
		BtnBorder(g, 26, 74);
		
		//Q
		letter(g, "Q", 30, 78);
		//u
		letter(g, "u", 40, 78);
		//i
		letter(g, "i", 48, 78);
		//t
		letter(g, "t", 52, 78);
		//G
		letter(g, "G", 62, 78);
		//a
		letter(g, "a", 72, 78);
		//m
		letter(g, "m", 80, 78);
		//e
		letter(g, "e", 92, 78);
	}

	public static void cursor(Graphics g) 
	{
		int X = 0;
		int Y = 0;
		int width = 0;
		int height = 0;
		switch(Main.selectable[Main.selected])
		{
			case "Play Game" :
			case "FlagPole" :
			case "List" :
			case "Catch" :
				X = 24;
				Y = 28;
				width = 80;
				height = 22;
				break;
			case "Help" :
			case "BowShot" :
			case "Back2" :
				X = 24;
				Y = 50;
				width = 80;
				height = 22;
				break;
			case "Quit Game" :
			case "Back" :
			case "Next" :
				X = 24;
				Y = 72;
				width = 80;
				height = 22;
				break;
		}
		g.fillRect(X, Y, width, 2);
		g.fillRect(X, Y + height - 2, width, 2);
		g.fillRect(X, Y, 2, height);
		g.fillRect(X + width - 2, Y, 2, height);
		
	}
	
	public static void BtnBorder(Graphics g, int X, int Y)
	{
		g.fillRect(X, Y, 74, 2);
		g.fillRect(X, Y + 16, 74, 2);
		g.fillRect(X, Y, 2, 18);
		g.fillRect(X + 74, Y, 2, 18);
	}
	
	public static void letter(Graphics g, String letter, int X, int Y)
	{
		switch (letter)
		{
			case "a" :
				
				g.fillRect(X,		Y + 4,  2, 6);
				g.fillRect(X + 4,	Y + 4, 	2, 6);
				g.fillRect(X, 		Y + 6, 	6, 2);
				g.fillRect(X + 2, 	Y + 2, 	2, 2);
				
				break;
			case "B" :
				
				g.fillRect(X, Y, 2, 10);
				g.fillRect(X + 2, Y, 4, 2);
				g.fillRect(X + 2, Y + 4, 4, 2);
				g.fillRect(X + 2, Y + 8, 4, 2);
				g.fillRect(X + 6, Y + 2, 2, 2);
				g.fillRect(X + 6, Y + 6, 2, 2);
				
				break;
				
			case "b" :
				
				g.fillRect(X, Y, 2, 10);
				g.fillRect(X + 2, Y + 4, 2, 2);
				g.fillRect(X + 2, Y + 8, 4, 2);
				g.fillRect(X + 4, Y + 6, 2, 2);
				
				break;
			case "C" :
				
				g.fillRect(X, Y + 2, 2, 6);
				g.fillRect(X + 2, Y, 4, 2);
				g.fillRect(X + 6, Y + 2, 2, 2);
				g.fillRect(X + 2, Y + 8, 4, 2);
				g.fillRect(X + 6, Y + 6, 2, 2);
				
				break;
			case "c" :
				
				g.fillRect(X + 2, Y + 2, 4, 2);
				g.fillRect(X, Y + 4, 2, 4);
				g.fillRect(X + 2, Y + 8, 4, 2);
				
				break;
			case "d" :
				
				g.fillRect(X, Y + 6, 2, 4);
				g.fillRect(X + 2, Y + 4, 2, 2);
				g.fillRect(X + 2, Y + 8, 2, 2);
				g.fillRect(X + 4, Y, 2, 10);
				
				break;
			case "e" :
				
				g.fillRect(X + 2,  	Y + 2, 2, 2);
				g.fillRect(X + 4,  	Y + 4, 2, 2);
				g.fillRect(X + 4,  	Y + 8, 2, 2);
				g.fillRect(X,		Y + 4, 2, 4);
				g.fillRect(X + 2, 	Y + 6, 2, 4);
				
				break;
			case "f" :
				
				g.fillRect(X, Y + 2, 2, 8);
				g.fillRect(X + 2, Y, 2, 2);
				g.fillRect(X + 2, Y + 4, 2, 2);
				
				break;
			case "F" :
				
				g.fillRect(X, Y, 2, 10);
				g.fillRect(X + 2, Y, 4, 2);
				g.fillRect(X + 2, Y + 4, 2, 2);
				
				break;
			case "g" :
				
				g.fillRect(X + 2, Y + 2, 4, 2);
				g.fillRect(X, Y + 4, 2, 2);
				g.fillRect(X + 4, Y + 4, 2, 6);
				g.fillRect(X + 2, Y + 6, 2, 2);
				g.fillRect(X, Y + 10, 4, 2);
				
				break;
			case "G" :
				
				g.fillRect(X, 		Y + 2,	2, 6);
				g.fillRect(X + 2, 	Y,		4, 2);
				g.fillRect(X + 2, 	Y + 8,	4, 2);
				g.fillRect(X + 6, 	Y + 4, 	2, 4);
				g.fillRect(X + 4, 	Y + 4, 	2, 2);
				
				break;
			case "h" :
				
				g.fillRect(X, Y, 2, 10);
				g.fillRect(X + 2, Y + 4, 2, 2);
				g.fillRect(X + 4, Y + 6, 2, 4);
				
				break;
			case "H" :
				
				g.fillRect(X, 		Y, 		2, 10);
				g.fillRect(X + 6, 	Y, 		2, 10);
				g.fillRect(X + 2, 	Y + 4, 	4, 2);
				
				break;
			case "i" :
				
				g.fillRect(X, Y + 6, 2, 4);
				g.fillRect(X, Y + 2, 2, 2);
				
				break;
			case "j" :
				
				g.fillRect(X + 2, Y + 2, 2, 2);
				g.fillRect(X + 2, Y + 6, 2, 4);
				g.fillRect(X, Y + 10, 2, 2);
				
				break;
			case "k" :
				
				g.fillRect(X, Y + 2, 2, 8);
				g.fillRect(X + 2, Y + 4, 2, 2);
				g.fillRect(X + 4, Y + 2, 2, 2);
				g.fillRect(X + 4, Y + 6, 2, 4);
				
				break;
			case "L" :
				
				g.fillRect(X, Y, 2, 8);
				g.fillRect(X, Y + 8, 6, 2);
				
				break;
			case "l" :
				
				g.fillRect(X, Y, 2, 10);
				
				break;
			case "m" :
				
				g.fillRect(X, 		Y + 4, 2, 6);
				g.fillRect(X + 4, 	Y + 4, 2, 6);
				g.fillRect(X + 8, 	Y + 4, 2, 6);
				g.fillRect(X + 2, 	Y + 2, 2, 2);
				g.fillRect(X + 6, 	Y + 2, 2, 2);
				
				break;
			case "N" :
				
				g.fillRect(X, Y, 2, 10);
				g.fillRect(X + 6, Y, 2, 10);
				g.fillRect(X + 2, Y + 2, 2, 2);
				g.fillRect(X + 4, Y + 4, 2, 2);
				
				break;
			case "n" :
				
				g.fillRect(X, Y + 4, 2, 6);
				g.fillRect(X + 2, Y + 4, 2, 2);
				g.fillRect(X + 4, Y + 6, 2, 4);
				
				break;
			case "o" :
				
				g.fillRect(X + 2, Y + 2, 2, 2);
				g.fillRect(X, Y + 4, 2, 4);
				g.fillRect(X + 4, Y + 4, 2, 4);
				g.fillRect(X + 2, Y + 8, 2, 2);
				
				break;
			case "p" :
				
				g.fillRect(X, 		Y + 2, 	2, 10);
				g.fillRect(X + 2, 	Y + 2, 	2, 2);
				g.fillRect(X + 2, 	Y + 6, 	2, 2);
				g.fillRect(X + 4, 	Y + 4, 	2, 2);
				
				break;
			case "P" :
				
				g.fillRect(X, 		Y, 		2, 10);
				g.fillRect(X, 		Y, 		6, 2);
				g.fillRect(X + 6, 	Y + 2, 	2, 2);
				g.fillRect(X, 		Y + 4, 	6, 2);
				
				break;
			case "q" :
				
				g.fillRect(X, Y + 2, 2, 2);
				g.fillRect(X + 2, Y, 2, 2);
				g.fillRect(X + 2, Y + 4, 2, 2);
				g.fillRect(X + 4, Y, 2, 10);
				
				break;
			case "Q" :
				
				g.fillRect(X, 		Y + 2, 	2, 6);
				g.fillRect(X + 2, 	Y, 		4, 2);
				g.fillRect(X + 2, 	Y + 8, 	4, 2);
				g.fillRect(X + 6, 	Y + 2, 	2, 8);
				g.fillRect(X + 4, 	Y + 6, 	2, 2);
				
				break;
			case "r" :
				
				g.fillRect(X, Y + 2, 2, 8);
				g.fillRect(X + 2, Y + 4, 2, 2);
				g.fillRect(X + 4, Y + 2, 2, 2);
				
				break;
			case "s" :
				
				g.fillRect(X + 2, Y + 2, 4, 2);
				g.fillRect(X, Y + 4, 2, 2);
				g.fillRect(X + 4, Y + 6, 2, 2);
				g.fillRect(X, Y + 8, 4, 2);
				
				
				break;
			case "S" :
				g.fillRect(X + 2, Y + 4, 2, 2);
				g.fillRect(X, Y + 8, 4, 2);
				g.fillRect(X + 2, Y, 4, 2);
				g.fillRect(X + 4, Y + 6, 2, 2);
				g.fillRect(X, Y + 2, 2, 2);
				break;
			case "T" :
				
				g.fillRect(X, Y, 10, 2);
				g.fillRect(X + 4, Y + 2, 2, 8);
				
				break;
			case "t" :
				
				g.fillRect(X, 		Y, 		2, 8);
				g.fillRect(X + 2, 	Y + 2, 	2, 2);
				g.fillRect(X + 2, 	Y + 8, 	2, 2);
				
				break;
			case "u" :
				
				g.fillRect(X, 		Y + 2, 2, 6);
				g.fillRect(X + 2,	Y + 8, 4, 2);
				g.fillRect(X + 4, 	Y + 2, 2, 6);
				
				break;
			case "v" :
				
				g.fillRect(X, Y + 2, 2, 6);
				g.fillRect(X + 4, Y + 2, 2, 6);
				g.fillRect(X + 2, Y + 8, 2, 2);
				
				break;
			case "w" :
				
				g.fillRect(X, Y + 2, 2, 6);
				g.fillRect(X + 4, Y + 2, 2, 6);
				g.fillRect(X + 8, Y + 2, 2, 6);
				g.fillRect(X + 2, Y + 8, 2, 2);
				g.fillRect(X + 6, Y + 8, 2, 2);
				
				break;
			case "x" :
				
				g.fillRect(X, Y + 2, 2, 2);
				g.fillRect(X + 4, Y + 2, 2, 2);
				g.fillRect(X + 2, Y + 4, 2, 2);
				g.fillRect(X, Y + 6, 2, 4);
				g.fillRect(X + 4, Y + 6, 2, 4);
				
				break;
			case "y" :
				
				g.fillRect(X, 		Y, 		2, 4);
				g.fillRect(X + 4,	Y, 		2, 8);
				g.fillRect(X + 2,	Y + 4, 	4, 2);
				g.fillRect(X,	 	Y + 8, 	4, 2);
				
				break;
			case "z" :
				
				g.fillRect(X, Y + 2, 6, 2);
				g.fillRect(X + 4, Y + 4, 2, 2);
				g.fillRect(X, Y + 6, 2, 2);
				g.fillRect(X, Y + 8, 6, 2);
				
				
				break;
		}
	}
	
	public static void number (Graphics g, int number, int X, int Y)
	{
		switch (number)
		{
		case 0 :
			
			g.fillRect(X + 2, Y, 2, 2);
			g.fillRect(X, Y + 2, 2, 6);
			g.fillRect(X + 4, Y + 2, 2, 6);
			g.fillRect(X + 2, Y + 8, 2, 2);
			
			break;
		case 1 :
			
			g.fillRect(X + 4, Y, 2, 8);
			g.fillRect(X + 2, Y + 2, 2, 2);
			g.fillRect(X + 2, Y + 8, 6, 2);
		
			break;
		case 2 :
			
			g.fillRect(X + 2, Y, 2, 2);
			g.fillRect(X, Y + 2, 2, 2);
			g.fillRect(X + 4, Y + 2, 2, 4);
			g.fillRect(X + 2, Y + 6, 2, 2);
			g.fillRect(X, Y + 8, 6, 2);
			
			break;
		case 3 :
			
			g.fillRect(X, Y, 4, 2);
			g.fillRect(X + 4, Y + 2, 2, 2);
			g.fillRect(X + 2, Y + 4, 2, 2);
			g.fillRect(X + 4, Y + 6, 2, 2);
			g.fillRect(X, Y + 8, 4, 2);
			
			break;
		case 4 :
			
			g.fillRect(X, Y + 6, 6, 2);
			g.fillRect(X + 4, Y, 2, 10);
			g.fillRect(X, Y + 4, 2, 2);
			g.fillRect(X + 2, Y + 2, 2, 2);
			
			break;
		case 5 :
			
			g.fillRect(X, Y, 6, 2);
			g.fillRect(X, Y + 2, 2, 4);
			g.fillRect(X + 2, Y + 4, 2, 2);
			g.fillRect(X + 4, Y + 6, 2, 2);
			g.fillRect(X, Y + 8, 4, 2);
			
			break;
		case 6 :
		case 7 :
		case 8 :
		case 9 :
		}
	}

	public static void Instructions(Graphics g) 
	{
		int X = 44;
		
		letter(g, "P", X ,30);
		letter(g, "r", X + 10, 30);
		letter(g, "e", X + 18, 30);
		letter(g, "s", X + 26, 30);
		letter(g, "s", X + 34, 30);
		
		X = 30;
		letter(g, "S", X, 50);
		letter(g, "p", X + 8, 50);
		letter(g, "a", X + 16, 50);
		letter(g, "c", X + 24, 50);
		letter(g, "e", X + 32, 50);
		letter(g, "b", X + 40, 50);
		letter(g, "a", X + 48, 50);
		letter(g, "r", X + 56, 50);
	}

	public static void system(Graphics g)
	{
		//Screen Border
		g.drawRect(0, 0, Constantes.stageWidth - 1, Constantes.stageHeight - 1);
		
		//Hold indicator
		g.fillRect(60, 6, 2, 6);
		g.fillRect(60, 6, 6, 2);
		g.fillRect(66, 6, 2, 8);
		g.fillRect(60, 12, 6, 2);
		
		if(Main.hold)
		{
			g.fillRect(62, 8, 4, 4);
		}
	}
	
	public static void gamemodes(Graphics g)
	{
		BtnBorder(g, 26, 30);
		
		int X = 52;
		
		letter(g, "L", X, 34);
		letter(g, "i", X + 8, 34);
		letter(g, "s", X + 12, 34);
		letter(g, "t", X + 20, 34);
		
		BtnBorder(g, 26, 74);
		
		X = 48;
		
		letter(g, "B", X, 78);
		letter(g, "a", X + 10, 78);
		letter(g, "c", X + 18, 78);
		letter(g, "k", X + 26, 78);
	}
	
	public static void games(Graphics g)
	{
		BtnBorder(g, 26, 30);
		BtnBorder(g, 26, 52);
		BtnBorder(g, 26, 74);
		
		int X = 0;
		if (Main.selectable[0] == "FlagPole")
		{
			X = 36;
		
			letter(g, "F", X, 34);
			letter(g, "l", X + 8, 34);
			letter(g, "a", X + 12, 34);
			letter(g, "g", X + 20, 34);
			letter(g, "p", X + 28, 34);
			letter(g, "o", X + 36, 34);
			letter(g, "l", X + 44, 34);
			letter(g, "e", X + 48, 34);
			
			number(g, Flagpole.highscore, X + 72, 34);
			
			
			X = 34;
			
			letter(g, "B", X, 56);
			letter(g, "o", X + 10, 56);
			letter(g, "w", X + 18, 56);
			letter(g, "s", X + 30, 56);
			letter(g, "h", X + 38, 56);
			letter(g, "o", X + 46, 56);
			letter(g, "t", X + 54, 56);
			
			number(g, Bowshot.highscore, X + 74, 56);
			
			
			
		}
		else if (Main.selectable[0] == "Catch")
		{
			X = 46;
			
			letter(g, "C", X, 34);
			letter(g, "a", X + 10, 34);
			letter(g, "t", X + 18, 34);
			letter(g, "c", X + 24, 34);
			letter(g, "h", X + 32, 34);
			
			number(g, Catch.highscore, X + 62, 34);
			
			X = 48;
			
			letter(g, "B", X, 56);
			letter(g, "a", X + 10, 56);
			letter(g, "c", X + 18, 56);
			letter(g, "k", X + 26, 56);
		}
		
		X = 48;
			
		letter(g, "N", X, 78);
		letter(g, "e", X + 10, 78);
		letter(g, "x", X + 18, 78);
		letter(g, "t", X + 26, 78);
		
	}

	public static void copyright(Graphics g) 
	{
		int X = 12;
		int Y = 110;
		
		g.fillRect(X, Y + 2, 2, 6);
		g.fillRect(X + 2, Y, 2, 2);
		g.fillRect(X + 2, Y + 8, 2, 2);
		g.fillRect(X + 4, Y - 2, 6, 2);
		g.fillRect(X + 4, Y + 10, 6, 2);
		g.fillRect(X + 10, Y, 2, 2);
		g.fillRect(X + 10, Y + 8, 2, 2);
		g.fillRect(X + 12, Y + 2, 2, 6);
		
		g.fillRect(X + 4, Y + 2, 4, 2);
		g.fillRect(X + 4, Y + 4, 2, 2);
		g.fillRect(X + 4, Y + 6, 4, 2);
		
		letter(g, "T", X + 14, Y);
		letter(g, "r", X + 24, Y);
		letter(g, "a", X + 30, Y);
		letter(g, "v", X + 38, Y);
		letter(g, "i", X + 46, Y);
		letter(g, "s", X + 50, Y);
		
		letter(g, "F", X + 60, Y);
		letter(g, "u", X + 66, Y);
		letter(g, "l", X + 74, Y);
		letter(g, "l", X + 78, Y);
		letter(g, "m", X + 82, Y);
		letter(g, "i", X + 94, Y);
		letter(g, "n", X + 98, Y);
		
	}
}
