package pathfinding;

public class Node {
	public int x;
	public int y;
	
	public float f;
	public float g;
	public float h;
	
	public boolean up;
	public boolean down;
	public boolean right;
	public boolean left;
	
	public String status = null;
	public Node parent = null;
	
	public Node(boolean[] collisionData, int x, int y){
		up = 	collisionData[0];
		right = collisionData[1];
		down = 	collisionData[2];
		left = 	collisionData[3];
		this.x = x;
		this.y = y;
	}

	public void setValues() {
		int Hx = (AStar.end == null ? 0 : this.x - AStar.end.x) * NodeData.size;
		int Hy = (AStar.end == null ? 0 : this.y - AStar.end.y) * NodeData.size;
		
		if (Hx < 0) { Hx = -Hx; }
		if (Hy < 0) { Hy = -Hy; }
		
		this.h = Hx + Hy;
		
		int Gx = ((parent == null ? 0 : this.parent.x) - this.x) * NodeData.size;
		int Gy = ((parent == null ? 0 : this.parent.y) - this.y) * NodeData.size;
		
		if (Gx < 0) { Gx = -Gx; }
		if (Gy < 0) { Gy = -Gy; }
		
		this.g = (int) ((parent == null ? 0 : this.parent.g) + Math.sqrt(Gx * Gx + Gy * Gy));
		
		this.f = this.g + this.h;
	}
	
	
}
