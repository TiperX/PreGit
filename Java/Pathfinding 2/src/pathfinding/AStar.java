package pathfinding;

import java.util.ArrayList;

public class AStar {
	
	private static ArrayList<ArrayList<Node>> field;
	
	private static ArrayList<Node> open;
	private static ArrayList<Node> closed;
	private static ArrayList<Node> path;
	
	private static Node start;
	public static Node end;
	
	private static int range;
	
	
	public static ArrayList<Node> getOpen(){
		return open;
	}
	
	public static ArrayList<Node> getClosed(){
		return closed;
	}
	
	public static ArrayList<Node> getPath(){
		return path;
	}
	
	
	public static void setField(int[][] field){
		AStar.field = new ArrayList<ArrayList<Node>>();
		for (int i = 0; i < field.length; i++){
			AStar.field.add(new ArrayList<Node>());
			for (int j = 0; j < field[i].length; j++){
				AStar.field.get(i).add(new Node(NodeData.data[field[i][j]], i, j));
			}
		}
	}
	
	public static void path(int x, int y, int x2, int y2){
		start = field.get(x).get(y);
		end = field.get(x2).get(y2);
		calculate();
	}
	
	public static void area(int x, int y, int r){
		start = field.get(x).get(y);
		range = r;
		calculate();
	}
	
	private static void calculate(){
		open = new ArrayList<Node>();
		closed = new ArrayList<Node>();
		path = null;
		addToOpen(start);
		
		Node current;
		
		while (open.size() > 0){
			current = null;
			for (int i = 0; i < open.size(); i++){
				if ((current == null || current.f >= open.get(i).f)){
					current = open.get(i);
				}
			}
			switchToClosed(current);
			
			if (closed.get(closed.size()-1) != end){
				ArrayList<Node> surround = getSurrounding(current);
				
				for (int i = 0; i < surround.size(); i++){
					if (surround.get(i).status != "Open" && surround.get(i).status != "Closed"){
						surround.get(i).parent = current;
						surround.get(i).setValues();
						if (range > 0 ? surround.get(i).g < range*NodeData.size: true){
							addToOpen(surround.get(i));
						}
					}else if (surround.get(i).status == "Open"){
						if (testG(surround.get(i))){
							surround.get(i).parent = current;
							surround.get(i).setValues();
						}
					}else{
						if (testG2(current, surround.get(i))){
							current.parent = surround.get(i);
							current.setValues();
						}
					}
				}
				surround = null;
			}
		}
		current = null;
		
		if (end.status == "Closed")
			setPath();
	}
	
	private static boolean testG2(Node n, Node p) {
		int Gx = ((p == null ? 0 : p.x) - n.x) * NodeData.size;
		int Gy = ((p == null ? 0 : p.y) - n.y) * NodeData.size;
		
		if (Gx < 0) { Gx = -Gx; }
		if (Gy < 0) { Gy = -Gy; }
		
		int g = (int) ((p == null ? 0 : p.g) + Math.sqrt(Gx * Gx + Gy * Gy));
		Gx = 0;
		Gy = 0;
		return (g < n.g);
	}

	private static void setPath(){
		path = new ArrayList<Node>();
		Node n = end;
		path.add(n);
		int i = 0;
		while(n.parent != null){
			n = n.parent;
			if (n != null){
				path.add(n);
			}
		}
	}
	
	private static boolean testG(Node n){
		int Gx = ((n.parent == null ? 0 : n.parent.x) - n.x) * NodeData.size;
		int Gy = ((n.parent == null ? 0 : n.parent.y) - n.y) * NodeData.size;
		
		if (Gx < 0) { Gx = -Gx; }
		if (Gy < 0) { Gy = -Gy; }
		
		int g = (int) ((n.parent == null ? 0 : n.parent.g) + Math.sqrt(Gx * Gx + Gy * Gy));
		Gx = 0;
		Gy = 0;
		return (g < n.g);
	}
	
	private static ArrayList<Node> getSurrounding(Node c){
		ArrayList<Node> temp = new ArrayList<Node>();
	
		boolean up = !(c.y-1 >= 0) || c.up || AStar.field.get(c.x).get(c.y-1).down;
		boolean right = !(c.x + 1 < AStar.field.size()) || c.right || AStar.field.get(c.x+1).get(c.y).left;
		boolean down = !(c.y+1 < AStar.field.get(0).size()) || c.down || AStar.field.get(c.x).get(c.y+1).up;
		boolean left = !(c.x-1 >= 0) || c.left || AStar.field.get(c.x-1).get(c.y).right;
	
		if (!up){
			temp.add(AStar.field.get(c.x).get(c.y-1));
		}
		if (!down){
			temp.add(AStar.field.get(c.x).get(c.y+1));
		}
		if (!left){
			temp.add(AStar.field.get(c.x-1).get(c.y));
		}
		if (!right){
			temp.add(AStar.field.get(c.x+1).get(c.y));
		}
		
		boolean ul = (up || left || AStar.field.get(c.x-1).get(c.y).up || AStar.field.get(c.x).get(c.y-1).left || AStar.field.get(c.x-1).get(c.y-1).down || AStar.field.get(c.x-1).get(c.y-1).right);
		boolean ur = (up || right || AStar.field.get(c.x+1).get(c.y).up || AStar.field.get(c.x).get(c.y-1).right || AStar.field.get(c.x+1).get(c.y-1).down || AStar.field.get(c.x+1).get(c.y-1).left);
		boolean dl = (down || left || AStar.field.get(c.x-1).get(c.y).down || AStar.field.get(c.x).get(c.y+1).left || AStar.field.get(c.x-1).get(c.y+1).up || AStar.field.get(c.x-1).get(c.y+1).right);
		boolean dr = (down || right ||AStar.field.get(c.x+1).get(c.y).down || AStar.field.get(c.x).get(c.y+1).right || AStar.field.get(c.x+1).get(c.y+1).up || AStar.field.get(c.x+1).get(c.y+1).left);
		
		if (!ul){
			temp.add(AStar.field.get(c.x-1).get(c.y-1));
		}
		if (!ur){
			temp.add(AStar.field.get(c.x+1).get(c.y-1));
		}
		if (!dl){
			temp.add(AStar.field.get(c.x-1).get(c.y+1));
		}
		if (!dr){
			temp.add(AStar.field.get(c.x+1).get(c.y+1));
		}
		
		/*for (int i = temp.size()-1; i >= 0; i--){
			if (temp.get(i).status == "Closed"){
				temp.remove(i);
			}
		}/**/
		
		return temp;
	}
	
	private static void addToOpen(Node n){
		open.add(n);
		n.status = "Open";
	}
	
	private static void switchToClosed(Node n){
		open.remove(n);
		closed.add(n);
		n.status = "Closed";
	}
}
