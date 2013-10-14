package data;

import objects.levelTiles.BaseTile;
import objects.levelTiles.BounceTile;
import objects.levelTiles.SpeedTile;

public class LevelGenerator {
	
	public static BaseTile[] generate(){
		BaseTile[] list = new BaseTile[12];
		double seed = Math.random()*1000;
		double i = 1000;
		
		for (int j = 0; j < list.length; j++){
			i = 1000/Math.pow(10, j);
			int t = (int) (seed/i);
			//stuff
			list[j] = getTile(t);
			
			seed -= i*t;
		}
		return list;
	}

	private static BaseTile getTile(int i) {
		BaseTile tile = null;
		
		if (i%8 > 0){
			tile = new BaseTile();
		}else{
			switch (i){
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
				tile = new BounceTile();
				break;
			default:
				tile = new SpeedTile();
				break;
			}
		}
		
		return tile;
	}
}
