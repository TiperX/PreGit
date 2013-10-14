package data;

import java.awt.Graphics;

public class Maps {
	public static int[] world1coords = {0, 0};
	public static int[][] world1 = {
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,1,1,0,0,0,0,0,0,1,1,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
		};

	public static void draw(int x, int y, Graphics g) {
		boolean u = (y-1 < 0 || world1[y-1][x] != 0);
		boolean l = (x-1 < 0 || world1[y][x-1] != 0);
		boolean r = (x+1 >= world1[y].length || world1[y][x+1] != 0);
		int _x = l ? (r ? 2 : 3) : (r ? 1 : 0);
		int _y = u ? 1 : 0;
		
		if (world1[y][x] != 0)g.drawImage(Images.tileset, 16*x - world1coords[0], 16*y - world1coords[1], 16*(x+1) - world1coords[0], 16*(y+1) - world1coords[1], 16*_x, 16*_y, 16*(_x+1), 16*(_y+1), null);
	}
}
