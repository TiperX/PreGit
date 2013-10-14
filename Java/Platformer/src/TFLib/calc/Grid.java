package TFLib.calc;

public class Grid {
	public static int[] gridToPixel(int x, int y, int baseX, int baseY, int tileWidth, int tileHeight){
		int[] answer = new int[]{0,0};
		
		answer[0] = (int) Math.floor(baseX + x * tileWidth);
		answer[1] = (int) Math.floor(baseY + y * tileHeight);
		
		return answer;
	}
	
	public static int[] pixelToGrid(int x, int y, int baseX, int baseY, int tileWidth, int tileHeight){
		int[] answer = new int[]{0,0};

		answer[0] = (int) Math.floor((x - baseX) / tileWidth);
		answer[1] = (int) Math.floor((y - baseY) / tileHeight);
		
		return answer;
	}
	
	public static int[] isoDiamondGridToPixel(int x, int y, int baseX, int baseY, int tileWidth, int tileHeight){
		int[] answer = new int[]{0,0};
		
		answer[0] = baseX + x * (tileWidth/2) - ((y+1) * tileWidth/2);
		answer[1] = baseY + x * (tileHeight/2) + y * (tileHeight/2);
		
		return answer;
	}
	
	public static int[] isoDiamondPixelToGrid(int x, int y, int baseX, int baseY, int tileWidth, int tileHeight){
		int[] answer = new int[]{0,0};
		
		answer[0] = (int)Math.round(-(baseX-x)/tileWidth-(baseY-y)/tileHeight);
		answer[1] = (int)Math.round((y-baseY)/tileHeight-(x-baseX)/tileWidth);
		
		return answer;
	}
	
	public static int[] isoStaggeredGridToPixel(int x, int y, int baseX, int baseY, int tileWidth, int tileHeight){
		int[] answer = new int[]{0,0};
		
		answer[0] = baseX + x * tileWidth / 2;
		answer[1] = baseY + y * tileHeight + (x%2)*tileHeight/2;
		
		return answer;
	}
	
	public static int[] isoStaggeredPixelToGrid(int x, int y, int baseX, int baseY, int tileWidth, int tileHeight){
		int[] answer = new int[]{0,0};
		
		answer[0] = (2*(x-baseX))/tileWidth;
		answer[1] = (y - baseY - ((x%2) * (tileHeight/2)))/tileHeight;
		
		return answer;
	}
}
