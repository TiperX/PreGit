package calc.pathfinding;

public class Node {

	public int G;
	public int type = 0;
	public static final int size = 4;
	public int x = 0;
	public int y = 0;
	
	public Node parent = null;
	public int F;
	public int H;
	public static int totalTypes = 2;

	public Node(int x, int y, int type) {
		this.x = 0;
		this.y = 0;
		this.type = 0;
		
		this.x += x;
		this.y += y;
		
		this.type += type;
		
		if (this.type > totalTypes-1){this.type = 0;}
	}

	public void setValues() {
		int Hx = (Astar.end == null ? 0 : this.x - Astar.end.x) * 10;
		int Hy = (Astar.end == null ? 0 : this.y - Astar.end.y) * 10;
		
		if (Hx < 0) { Hx = -Hx; }
		if (Hy < 0) { Hy = -Hy; }
		
		this.H = Hx + Hy;
		
		int Gx = ((parent == null ? 0 : this.parent.x) - this.x) * 10;
		int Gy = ((parent == null ? 0 : this.parent.y) - this.y) * 10;
		
		if (Gx < 0) { Gx = -Gx; }
		if (Gy < 0) { Gy = -Gy; }
		
		this.G = (int) ((parent == null ? 0 : this.parent.G) + Math.sqrt(Gx * Gx + Gy * Gy));
		
		this.F = this.G + this.H;
	}
}
