package objects.levelTiles;

import java.awt.Color;
import java.awt.Graphics;

import data.Constants;

public class SpeedTile extends BaseTile {
	
	@Override
	public String getEffect(){
		return "SpeedUp";
	}
	
	@Override
	public void draw(Graphics g){
		g.setColor(Color.green);
		g.drawLine((int)x, (int)(Constants.stageHeight*Constants.scaling-64), (int)x+64, (int)(Constants.stageHeight*Constants.scaling-64));
		g.setColor(new Color(0, 128, 0));
		g.drawLine((int)x+1, (int)(Constants.stageHeight*Constants.scaling-63), (int)x+63, (int)(Constants.stageHeight*Constants.scaling-63));
		g.drawLine((int)x+1, (int)(Constants.stageHeight*Constants.scaling-65), (int)x+63, (int)(Constants.stageHeight*Constants.scaling-65));
	}
}
