package TFLib;

import data.Maps;

import TFLib.calc.Grid;
import TFLib.ColliderObject;

public class TFCollider {
	//returns a boolean on whether you're colliding with the map or not
	public static boolean mapCollisionB(int[][] map, ColliderObject e, int cellsize){
		return (mapCollision(map, e, cellsize) != null);
	}
	
	//returns either a displacements vector for the collision or null
	public static int[] mapCollision(int[][] map, ColliderObject e, int cellsize){
		int[][] answer = new int[2][2];
		int[] gc = Grid.pixelToGrid(e.x, e.y, Maps.world1coords[0], Maps.world1coords[1], cellsize, cellsize);//calculates the grid coordinates for e
		int[] gc2 = Grid.pixelToGrid(e.x+e.w, e.y+e.h, Maps.world1coords[0], Maps.world1coords[1], cellsize, cellsize);
		boolean[][] co = new boolean[gc2[1] - gc[1] + 1][gc2[0] - gc[0] + 1];
		int[] tc = Grid.gridToPixel(gc[0], gc[1], Maps.world1coords[0], Maps.world1coords[1], cellsize, cellsize);//calculates the screen coordinates of the grid coordinate for e
		
		
		for (int j = 0; j < co.length; j++){
			for (int i = 0; i < co[0].length; i++){
				if (gc[0] >= 0 && gc2[0] < map[0].length && gc[1] >= 0 && gc2[1] < map.length && map[gc[1]+j][gc[0]+i] != 0){
					co[j][i] = true;
				}
			}
		}
		/*for (int j = 0; j < co.length; j++){
			for (int i = 0; i < co[0].length; i++){
				System.out.print(co[j][i] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
		/**/
		if (co.length == 2){
			if (co[0].length == 1){
				if (co[0][0]){
					answer[0] = collide(new ColliderObject(tc[0]-cellsize/2, tc[1], cellsize*2, cellsize, "box"), e);
				}else if (co[1][0]){
					answer[0] = collide(new ColliderObject(tc[0]-cellsize/2, tc[1]+cellsize, cellsize*2, cellsize, "box"), e);
				}
			}else if (co[0].length == 2){
				if (co[0][0]){
					if (co[1][0] && co[0][1]){
						answer[0] = collide(new ColliderObject(tc[0], tc[1], cellsize, cellsize*2, "box"), e);
						answer[1] = collide(new ColliderObject(tc[0], tc[1], cellsize*2, cellsize, "box"), e);
						
					}else if (co[1][0]){
						answer[0] = collide(new ColliderObject(tc[0], tc[1], cellsize, cellsize*2, "box"), e);
					}else if (co[0][1]){
						answer[1] = collide(new ColliderObject(tc[0], tc[1], cellsize*2, cellsize, "box"), e);
					}else{
						answer[0] = collide(new ColliderObject(tc[0], tc[1], cellsize, cellsize, "box"), e);
					}
				}else if (co[1][1]){
					if (co[1][0] && co[0][1]){
						answer[0] = collide(new ColliderObject(tc[0]+cellsize, tc[1], cellsize, cellsize*2, "box"), e);
						answer[1] = collide(new ColliderObject(tc[0], tc[1]+cellsize, cellsize*2, cellsize, "box"), e);
						
					}else if (co[0][1]){
						answer[0] = collide(new ColliderObject(tc[0]+cellsize, tc[1], cellsize, cellsize*2, "box"), e);
					}else if (co[1][0]){
						answer[1] = collide(new ColliderObject(tc[0], tc[1]+cellsize, cellsize*2, cellsize, "box"), e);
					}else{
						answer[0] = collide(new ColliderObject(tc[0]+cellsize, tc[1]+cellsize, cellsize, cellsize, "box"), e);
					}
				}else if (co[0][1]){
					answer[0] = collide(new ColliderObject(tc[0]+cellsize, tc[1], cellsize, cellsize, "box"), e);
				}else if (co[1][0]){
					answer[0] = collide(new ColliderObject(tc[0], tc[1]+cellsize, cellsize, cellsize, "box"), e);
				}
			}else{
				
			}
		}else if(co[0].length == 2){
			if (co.length == 1){
				if (co[0][0]){
					answer[0] = collide(new ColliderObject(tc[0], tc[1]-cellsize/2, cellsize, cellsize*2, "box"), e);
				}else if (co[0][1]){
					answer[0] = collide(new ColliderObject(tc[0]+cellsize, tc[1]-cellsize/2, cellsize, cellsize*2, "box"), e);
				}
			}else{
				
			}
		}else{
			if (co.length == 1){
				
			}else if (co[0].length == 1){
				
			}else{
				
			}
		}
		
		
		//System.out.println(answer[0][0] + " : " + answer[0][1] + "	" + answer[1][0] + " : " + answer[1][1]);
		return (answer[0][0] != 0 || answer[0][1] != 0 || answer[1][0] != 0 || answer[1][1] != 0 ? new int[]{answer[0][0] == 0 ? answer[1][0] : answer[0][0], answer[0][1] == 0 ? answer[1][1] : answer[0][1]} : null);
	}
	
	
	
	private static String getShape(int x, int y, int[][] map) {
		return "box";
		/*if (x < 0 || y < 0 || x >= map[0].length || y >= map.length){
			return "box";
		}else{
			boolean u = (x < 0 || x >= map[0].length || y-1 < 0 				|| map[y-1][x] > 0);
			boolean d = (x < 0 || x >= map[0].length || y+1 >= map.length 		|| map[y+1][x] > 0);
			boolean l = (y < 0 || y >= map.length 	 || x-1 < 0 				|| map[y][x-1] > 0);
			boolean r = (y < 0 || y >= map.length 	 || x+1 >= map[0].length 	|| map[y][x+1] > 0);
			
			return (u ? (d ? "box" : (l ? "roofSlope2" : (r ? "roofSlope1" : "box"))) : (d ? (l ? "slope1" : (r ? "slope2" : "box")) : "box"));
		}*/
	}

	public static int[] collide(ColliderObject o, ColliderObject e){
			return boxCollision(o, e);
	}

	private static int[] boxCollision(ColliderObject o, ColliderObject e) {
		int[] op1 = {o.x, o.y};
		int[] op2 = {o.x + o.w, o.y + o.h};
		
		int[][] answer = new int[4][2];
		
		int[] ep = {e.x, e.y};//top left
		if (ep[0] >= op1[0] && ep[0] <= op2[0] && ep[1] >= op1[1] && ep[1] <= op2[1]){
			answer[0][0] = op2[0] - ep[0];
			answer[0][1] = op2[1] - ep[1];
		}
		//System.out.println(answer[0][0] + " : " + answer[0][1]);

		ep = new int[]{e.x + e.w, e.y};//top right
		if (ep[0] >= op1[0] && ep[0] <= op2[0] && ep[1] >= op1[1] && ep[1] <= op2[1]){
			answer[1][0] = op1[0] - ep[0];
			answer[1][1] = op2[1] - ep[1];
		}
		//System.out.println(answer[1][0] + " : " + answer[1][1]);
		
		ep = new int[]{e.x + e.w, e.y + e.h};//bottom right
		if (ep[0] >= op1[0] && ep[0] <= op2[0] && ep[1] >= op1[1] && ep[1] <= op2[1]){
			answer[2][0] = op1[0] - ep[0];
			answer[2][1] = op1[1] - ep[1];
		}
		//System.out.println(answer[2][0] + " : " + answer[2][1]);
		
		ep = new int[]{e.x, e.y + e.h};//bottom left
		if (ep[0] >= op1[0] && ep[0] <= op2[0] && ep[1] >= op1[1] && ep[1] <= op2[1]){
			answer[3][0] = op2[0] - ep[0];
			answer[3][1] = op1[1] - ep[1];
		}
		//System.out.println(answer[3][0] + " : " + answer[3][1]);
		
		int[] answer2 = new int[2];
		
		if (answer[0][0] != 0 || answer[0][1] != 0){
			if(answer[1][0] != 0 || answer[1][1] != 0){
				answer2 = new int[]{0, answer[0][1]};
			}else if (answer[3][0] != 0 || answer[3][1] != 0){
				answer2 = new int[]{answer[0][0], 0};
			}else{
				answer2 = answer[0];
				if (answer2[0] == 0){
					answer2[0]++;
				}else if (answer2[1] == 0){
					answer2[1]++;
				}
			}
		}else if (answer[2][0] != 0 || answer[2][1] != 0){
			if(answer[1][0] != 0 || answer[1][1] != 0){
				answer2 = new int[]{answer[2][0], 0};
			}else if (answer[3][0] != 0 || answer[3][1] != 0){
				answer2 = new int[]{0, answer[2][1]};
			}else{
				answer2 = answer[2];
				if (answer2[0] == 0){
					answer2[0]--;
				}else if (answer2[1] == 0){
					answer2[1]--;
				}
			}
		}else if(answer[1][0] != 0 || answer[1][1] != 0){
			answer2 = answer[1];
			if (answer2[0] == 0){
				answer2[0]--;
			}else if (answer2[1] == 0){
				answer2[1]++;
			}
		}else if(answer[3][0] != 0 || answer[3][1] != 0){
			answer2 = answer[3];
			if (answer2[0] == 0){
				answer2[0]++;
			}else if (answer2[1] == 0){
				answer2[1]--;
			}
		}
		
		return answer2;
	}
}