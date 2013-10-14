import java.awt.Color;

import javax.swing.JFrame;

import data.Constants;


public class Main {
	public static void main(String[] args){
		new Main();
	}

	public Main(){
		Constants.STAGE.setTitle("OneButton[]");
		Constants.STAGE.setUndecorated(true);
		Constants.STAGE.setVisible(true);
		Constants.STAGE.setBackground(Color.blue);
		Constants.STAGE.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Constants.STAGE.setSize(Constants.stageWidth, Constants.stageHeight);
		Constants.STAGE.setLocationRelativeTo(null);
		
		loop();
		/**/
	}
	
	private void loop() {
		Constants.running = false;
		while (Constants.running == true){
			System.exit(0);
		}
		
		
	}
}
