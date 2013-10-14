package calc.pathfinding;

import java.util.ArrayList;

public class Astar {
	
	private static ArrayList<Node> grid;
	private static ArrayList<Node> open;
	private static ArrayList<Node> closed;
	private static ArrayList<Node> path;

	public static Node start;
	public static Node end;
	
	private static int fieldHeight;
	private static int fieldWidth;
	
	public static int maxValue;
	
	public static void setField(ArrayList<Node> grid, int fieldHeight, int fieldWidth){
		Astar.grid = grid;
		Astar.open = new ArrayList<Node>();
		Astar.closed = new ArrayList<Node>();
		Astar.path = new ArrayList<Node>();
		
		Astar.fieldHeight = fieldHeight;
		Astar.fieldWidth = fieldWidth;
	}
	
	public static void findPath(Node start, Node end){
		Astar.start = start;
		Astar.start.setValues();
		Astar.end = end;
		Astar.maxValue = 0;
		find();
	}
	
	public static void findArea(int maxValue, Node start){
		Astar.start = start;
		Astar.start.setValues();
		Astar.maxValue = maxValue + Astar.start.F;
		find();
	}
	
	public static ArrayList<Node> getPath() {
		return path;
	}
	
	public static ArrayList<Node> getClosed() {
		return closed;
	}
	
	public static ArrayList<Node> getOpen() {
		return open;
	}

	private static void find() {
		addToOpen(start);//adds the startnode to the open list
		int i = 0;//to prevent me from getting duplicate var definition warning
		
		int safe = 0;//debuger or distance limiter
		
		Node node;
		
		while (open.size() > 0 && (maxValue > 0 ? true : (closed.size() > 0 ? closed.get(closed.size() - 1) != end : true))/* && safe < 999999999/**/) {	
			node = start;//sets the node to check temporarily to the starting point
			//node.F = 999999;//sets the startnodes F value to very high
			
			for (i = 0; i < open.size(); i++) {
				if (open.get(i).F < node.F || node == start) { node = open.get(i); }//checks if this node in the open list has a better F value than the node planned to be checked
			}
			switchToClosed(node);//both removes the node from the open list and adds it to the closed list
			
			if (maxValue == 0 || node.G <= maxValue){
				ArrayList<Node> surNodes = getSurroundingNodes(node.x, node.y);//returns a list with the nodes that surround the current node
			
				for (i = 0; i < surNodes.size(); i++) {
					if (!checkIfOpen(surNodes.get(i)) && !checkIfClosed(surNodes.get(i))) {//checks if the current surNode is on the open list
						addToOpen(surNodes.get(i));//if not adds it to the open list
						surNodes.get(i).parent = node;//as well as setting the nodes parent to the current node
						surNodes.get(i).setValues();//and sets the values accordingly
					}else {
						if (surNodes.get(i) != start && altG(node, surNodes.get(i)) <= surNodes.get(i).G) {//if it is check if this node will make the G value better
							surNodes.get(i).parent = node;//if so change the parent
							surNodes.get(i).setValues();//and reset the values
						}
					}
				}
			}
			safe++;//up safe by one
		}
		if (closed.get(closed.size()-1) == end && maxValue == 0){//if the last node added to the closed list is the end point
			node = end;//node gets set to the end point
			path.add(node);//and gets pushed into the path list
			while (path.get(path.size() - 1).parent != null) {//until the node that is being checked doesnt have a parent
				path.add(node.parent);//add the current nodes parent to the path list
				node = node.parent;//and make the parent the next node to check
			}
		}
	}

	private static int altG(Node n, Node n2) {
		int Gx = (n.x - n2.x) * 10;
		int Gy = (n.y - n2.y) * 10;
	
		if (Gx < 0) { Gx = -Gx; }
		if (Gy < 0) { Gy = -Gy; }
	
		return (int) (n.G + Math.sqrt(Gx * Gx + Gy * Gy));
	}

	private static boolean checkIfClosed(Node n) {
		for (int i = 0; i < closed.size(); i++) {
			if (closed.get(i) == n) { return true; }
		}
		return false;
	}

	private static boolean checkIfOpen(Node n) {
		for (int i = 0; i < open.size(); i++) {
			if (open.get(i) == n) { return true; }
		}
		return false;
	}

	private static ArrayList<Node> getSurroundingNodes(int x, int y) {
		boolean xd = (x > 0 ? true : false);
		boolean xu = (x < grid.size()/fieldHeight - 1 ? true : false);
		
		boolean yd = (y > 0 ? true : false);
		boolean yu = (y < grid.size()/fieldWidth - 1 ? true : false);
		
		ArrayList<Node> answer = new ArrayList<Node>();
		
		if (xd) {
			answer.add(grid.get((y)*fieldWidth + (x - 1))); 
			if (answer.get(answer.size() - 1).type > 0) { xd = false; }
		}
		if (xu)	{ 
			answer.add(grid.get((y)*fieldWidth + (x + 1)));
			if (answer.get(answer.size() - 1).type > 0) { xu = false; }
		}
		if (yd)	{ 
			answer.add(grid.get((y - 1)*fieldWidth + (x))); 
			if (answer.get(answer.size() - 1).type > 0) { yd = false; }
		}
		if (yu)	{ 
			answer.add(grid.get((y + 1)*fieldWidth + (x))); 
			if (answer.get(answer.size() - 1).type > 0) { yu = false; }
		}
		
		if (xd && yd)	{ answer.add(grid.get((y - 1)*fieldWidth + (x - 1))); }
		if (xd && yu)	{ answer.add(grid.get((y + 1)*fieldWidth + (x - 1))); }
		if (xu && yd)	{ answer.add(grid.get((y - 1)*fieldWidth + (x + 1))); }
		if (xu && yu)	{ answer.add(grid.get((y + 1)*fieldWidth + (x + 1))); }
		
		for (int i = answer.size() - 1; i >= 0; i--) {
			if (/*checkIfClosed(answer[i]) ||*/ answer.get(i).type > 0) { answer.remove(i); }
		}	
		return answer;
	}

	private static void switchToClosed(Node n) {
		open.remove(n);
		closed.add(n);
	}

	private static void addToOpen(Node n) {
		open.add(n);
	}
}
