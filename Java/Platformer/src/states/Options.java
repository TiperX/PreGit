package states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import data.Constants;

public class Options extends State {
	int current = 0;
	boolean setting = false;
	int currentPlayer = 0;
	public Options(){
		
	}
	
	public void update(long dt){
		
	}
	
	public void draw(Graphics g){
		g.setColor(Color.white);
		
		g.drawOval(13, 33 + 10 * current, 5, 5);
		
		switch(currentPlayer){
		case 0 :
			g.drawString("Number of players : " + Constants.players, 20, 40);
			g.drawString("Player 1", 20, 50);
			g.drawString("Player 2", 20, 60);
			g.drawString("Player 3", 20, 70);
			g.drawString("Player 4", 20, 80);
			break;
		case 1 :
			g.drawString("Player 1 up:	", 20, 40);
			g.drawString("Player 1 down:		", 20, 50);
			g.drawString("Player 1 left:	", 20, 60);
			g.drawString("Player 1 right:	", 20, 70);
			g.drawString("Player 1 jump:	", 20, 80);
			g.drawString("Player 1 attack:	", 20, 90);
			
			g.drawString(KeyEvent.getKeyText(Constants.controls[0][0]), 130, 40);
			g.drawString(KeyEvent.getKeyText(Constants.controls[0][1]), 130, 50);
			g.drawString(KeyEvent.getKeyText(Constants.controls[0][2]), 130, 60);
			g.drawString(KeyEvent.getKeyText(Constants.controls[0][3]), 130, 70);
			g.drawString(KeyEvent.getKeyText(Constants.controls[0][4]), 130, 80);
			g.drawString(KeyEvent.getKeyText(Constants.controls[0][5]), 130, 90);
			break;
		case 2 :
			g.drawString("Player 2 up:	", 20, 40);
			g.drawString("Player 2 down:		", 20, 50);
			g.drawString("Player 2 left:	", 20, 60);
			g.drawString("Player 2 right:	", 20, 70);
			g.drawString("Player 2 jump:	", 20, 80);
			g.drawString("Player 2 attack:	", 20, 90);
			
			g.drawString(KeyEvent.getKeyText(Constants.controls[1][0]), 130, 40);
			g.drawString(KeyEvent.getKeyText(Constants.controls[1][1]), 130, 50);
			g.drawString(KeyEvent.getKeyText(Constants.controls[1][2]), 130, 60);
			g.drawString(KeyEvent.getKeyText(Constants.controls[1][3]), 130, 70);
			g.drawString(KeyEvent.getKeyText(Constants.controls[1][4]), 130, 80);
			g.drawString(KeyEvent.getKeyText(Constants.controls[1][5]), 130, 90);
			break;
		case 3 :
			g.drawString("Player 3 up:	", 20, 40);
			g.drawString("Player 3 down:		", 20, 50);
			g.drawString("Player 3 left:	", 20, 60);
			g.drawString("Player 3 right:	", 20, 70);
			g.drawString("Player 3 jump:	", 20, 80);
			g.drawString("Player 3 attack:	", 20, 90);
			
			g.drawString(KeyEvent.getKeyText(Constants.controls[2][0]), 130, 40);
			g.drawString(KeyEvent.getKeyText(Constants.controls[2][1]), 130, 50);
			g.drawString(KeyEvent.getKeyText(Constants.controls[2][2]), 130, 60);
			g.drawString(KeyEvent.getKeyText(Constants.controls[2][3]), 130, 70);
			g.drawString(KeyEvent.getKeyText(Constants.controls[2][4]), 130, 80);
			g.drawString(KeyEvent.getKeyText(Constants.controls[2][5]), 130, 90);
			break;
		case 4 :
			g.drawString("Player 4 up:	", 20, 40);
			g.drawString("Player 4 down:		", 20, 50);
			g.drawString("Player 4 left:	", 20, 60);
			g.drawString("Player 4 right:	", 20, 70);
			g.drawString("Player 4 jump:	", 20, 80);
			g.drawString("Player 4 attack:	", 20, 90);
			
			g.drawString(KeyEvent.getKeyText(Constants.controls[3][0]), 130, 40);
			g.drawString(KeyEvent.getKeyText(Constants.controls[3][1]), 130, 50);
			g.drawString(KeyEvent.getKeyText(Constants.controls[3][2]), 130, 60);
			g.drawString(KeyEvent.getKeyText(Constants.controls[3][3]), 130, 70);
			g.drawString(KeyEvent.getKeyText(Constants.controls[3][4]), 130, 80);
			g.drawString(KeyEvent.getKeyText(Constants.controls[3][5]), 130, 90);
			break;
		}
	}
	
	private boolean checkKeyCode(int code){
		switch (code){
		case 8 :
		case 27 :
			return false;
		default :
			for (int i = 0; i < Constants.controls.length; i++){
				for (int j = 0; j < Constants.controls[0].length; j++){
					if (code == Constants.controls[i][j]){
						Constants.controls[i][j] = 0;
					}
				}
			}
			break;
		}
		return true;
	}
	
	@Override
	public void keyUp(KeyEvent ke){
		if (setting){
			if(checkKeyCode(ke.getKeyCode())){
				Constants.controls[currentPlayer-1][current] = ke.getKeyCode();
			}
			setting = false;
		}else{
			switch(currentPlayer){
			case 0 :
				if (ke.getKeyCode() == 40){
					current = (current < 4 ? current+1 : 0);
				}else if (ke.getKeyCode() == 38){
					current = (current > 0 ? current-1 : 4);
				}else if (ke.getKeyCode() == 10){
					if (current == 0){
						if (Constants.players >= 4){
							Constants.players = 2;
						}else{
							Constants.players++;
						}
					}else{
						currentPlayer = current;
						current = 0;
					}
				}else if (ke.getKeyCode() == 27){
					System.exit(0);
				}else if (ke.getKeyCode() == 8){
					StateManager.change(StateManager.gameStates.game);
				}
				break;
			case 1 :
				if (ke.getKeyCode() == 40){
					current = (current < 5 ? current+1 : 0);
				}else if (ke.getKeyCode() == 38){
					current = (current > 0 ? current-1 : 5);
				}else if (ke.getKeyCode() == 10){
					setting = true;
				}else if (ke.getKeyCode() == 27){
					currentPlayer = 0;
				}
				break;
			case 2 :
				if (ke.getKeyCode() == 40){
					current = (current < 5 ? current+1 : 0);
				}else if (ke.getKeyCode() == 38){
					current = (current > 0 ? current-1 : 5);
				}else if (ke.getKeyCode() == 10){
					setting = true;
				}else if (ke.getKeyCode() == 27){
					currentPlayer = 0;
				}
				break;
			case 3 :
				if (ke.getKeyCode() == 40){
					current = (current < 5 ? current+1 : 0);
				}else if (ke.getKeyCode() == 38){
					current = (current > 0 ? current-1 : 5);
				}else if (ke.getKeyCode() == 10){
					setting = true;
				}else if (ke.getKeyCode() == 27){
					currentPlayer = 0;
				}
				break;
			case 4 :
				if (ke.getKeyCode() == 40){
					current = (current < 5 ? current+1 : 0);
				}else if (ke.getKeyCode() == 38){
					current = (current > 0 ? current-1 : 5);
				}else if (ke.getKeyCode() == 10){
					setting = true;
				}else if (ke.getKeyCode() == 27){
					currentPlayer = 0;
				}
				break;
			}
		}
	}
}
