import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;


public class Main extends JFrame implements KeyListener
{

	/**
	 * CopyRight Travis Fullmin
	 */
	private static final long serialVersionUID = 1L;
	
	public static boolean press = false;
	public static boolean hold = false;
	public static String[] selectable = new String[]{"Play Game", "Help", "Quit Game"};
	public static int selected = 0;

	public static void main(String[] args) 
	{
		new Main();

	}
	
	private Main()
	{
		setTitle("OBG");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
		setSize(Constantes.stageWidth, Constantes.stageHeight);
		setBackground(Color.white);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setVisible(true);
		
		addKeyListener(this);
	}
	
	public void paint(Graphics g)
	{
		if(Constantes.update <= System.currentTimeMillis())
		{
			Constantes.update = System.currentTimeMillis() + (1000 / Constantes.framerate);
			
			Constantes.image = createImage(Constantes.stageWidth, Constantes.stageHeight);
			Constantes.graphics = Constantes.image.getGraphics();
			
			g.setColor(Color.black);
			
			Draw.system(Constantes.graphics);
			
			switch (Constantes.currentscreen)
			{
			case "Menu" :
				
				Draw.Menu(Constantes.graphics);
				Draw.cursor(Constantes.graphics);	
				
				break;
			case "Help" :
				
				Draw.Instructions(Constantes.graphics);
				Draw.copyright(Constantes.graphics);
				
				break;
			case "GameModes" :
				
				Draw.gamemodes(Constantes.graphics);
				Draw.cursor(Constantes.graphics);
				
				break;
			case "Games" :
				
				Draw.games(Constantes.graphics);
				Draw.cursor(Constantes.graphics);
				
				break;
			case "FlagPole" :
				
				Flagpole.Main();
				
				break;
			case "BowShot" :
				
				Bowshot.Main();
				
				break;
			case "Catch" :
				
				Catch.Main();
				
				break;
			}
			
			g.drawImage(Constantes.image, 0, 0, null);
		}
		repaint();
	}
	
	@Override
	public void keyPressed(KeyEvent ke) 
	{
		if(ke.getKeyCode() == 32)
		{
			if (press)
			{
				hold = true;
			}
			else
			{
				press = true;
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent ke) 
	{
		if (hold)
		{
			switch(Constantes.currentscreen)
			{
				case "Menu" :
					
					if (selectable[selected] == "Quit Game")
					{
						System.exit(0);
						break;
					}
					else if (selectable[selected] == "Help")
					{
						Constantes.currentscreen = "Help";
						break;
					}
					else if (selectable[selected] == "Play Game")
					{
						selected = 0;
						selectable = new String[]{"List", "Back"};
						Constantes.currentscreen = "GameModes";
					}
					
					break;
				case "Help" :
					
					selected = 0;
					Constantes.currentscreen = "Menu";
					
					break;
				case "GameModes" :
					
					if (selectable[selected] == "List")
					{
						selected = 0;
						selectable = new String[]{"FlagPole", "BowShot", "Next"};
						Constantes.currentscreen = "Games";
					}
					else if (selectable[selected] == "Back")
					{
						Constantes.currentscreen = "Menu";
						selectable = new String[]{"Play Game", "Help", "Quit Game"};
						selected = 0;
					}
					
					break;
				case "Games" :
					
					if (selectable[selected] == "Back" || selectable[selected] == "Back2")
					{
						Constantes.currentscreen = "GameModes";
						selectable = new String[]{"List", "Back"};
						selected = 0;
					}
					else if (selectable[selected] == "FlagPole")
					{
						Constantes.currentscreen = "FlagPole";
					}
					else if (selectable[selected] == "BowShot")
					{
						Constantes.currentscreen = "BowShot";
					}
					else if (selectable[selected]== "Catch")
					{
						Constantes.currentscreen = "Catch";
					}
					else if (selectable[selected] == "Next")
					{
						selected = 0;
						switch(selectable[0])
						{
						case "FlagPole" :
							
							selectable = new String[]{"Catch", "Back2", "Next"};
							
							break;
						case "Catch" :
							
							selectable = new String[]{"FlagPole", "BowShot", "Next"};
							
							break;
						}
					}
					
					break;
				case "FlagPole" :
				case "BowShot" :
				case "Catch" :
					
					if (Constantes.timelimit == 0)
					{
						Constantes.timelimit = -1;
						Constantes.currentscreen = "Games";
						selected = 0;
					}
					
					break;
			}
			
		}
		else if (press)
		{
			if (Constantes.currentscreen == "Help")
			{
				Constantes.currentscreen = "Menu";
				selected = 0;
			}
			else if (Constantes.currentscreen == "FlagPole" && Constantes.timelimit > 0)
			{
				Flagpole.wheelstage++;
				if (Flagpole.wheelstage == 8)
				{
					Flagpole.wheelstage = 0;
				}
				
				if (Flagpole.flagstage < 36)
				{
					Flagpole.flagstage += 1;
				}
			}
			else if (Constantes.currentscreen ==  "BowShot" && Constantes.timelimit > 0 && Bowshot.bowstage != "Shot")
			{
				Bowshot.bowstage = "Shot";
				Bowshot.arrowstage = "Shot";
			}
			else if (Constantes.currentscreen == "Catch" && Constantes.timelimit > 0 && Catch.pistonstage == "Open")
			{
				Catch.pistonstage = "Closed";
				if (Catch.stickheight * 2 + 16 > 98 && Catch.stickheight < 106)
				{
					Catch.stickstage = "Caught";
				}
			}
			
			if (selected < selectable.length - 1)
			{
				selected++;
			}
			else
			{
				selected = 0;
			}
			
		}
		press = false;
		hold = false;
	}

	@Override
	public void keyTyped(KeyEvent ke) 
	{
		
	}

}
