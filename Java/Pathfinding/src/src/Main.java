package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import calc.pathfinding.Astar;
import calc.pathfinding.Node;

@SuppressWarnings("serial")
public class Main extends JFrame implements MouseListener
{
	private ArrayList<Node> grid = new ArrayList<Node>();
	private ArrayList<Node> path = new ArrayList<Node>();
	private ArrayList<Node> closed = new ArrayList<Node>();
	private ArrayList<Node> open = new ArrayList<Node>();
	
	public static void main(String[] args)
	{
		new Main();
	}
	
	public Main()
	{
		setTitle("PathFinding WIP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
		setBackground(Color.white);
		setSize(Constantes.stageWidth, Constantes.stageHeight);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setVisible(true);
		resetGrid();
		addMouseListener(this);
	}
	
	public void resetGrid(){
		long startTime = System.currentTimeMillis();
		grid.clear();
		path.clear();
		closed.clear();
		open.clear();
		
		for (int i = 0; i < Constantes.stageHeight / Node.size; i++)
		for (int j = 0; j < Constantes.stageWidth / Node.size; j++){
			grid.add(new Node(j, i, (int) (Math.random()*Constantes.CHANCE)));
		}
		grid.get(0).type = 0;
		grid.get(grid.size()-1).type = 0;
		//System.out.println(grid.size() + "	" + Constantes.stageWidth / Node.size * Constantes.stageHeight / Node.size);
		Astar.setField(grid, Constantes.stageHeight/Node.size, Constantes.stageWidth/Node.size);
		Astar.findPath(grid.get(0), grid.get(grid.size()-1));
		//double rand = Math.random();
		//while (grid.get((int) (rand*grid.size())).type > 0) rand = Math.random();
		//Astar.findArea(99, grid.get((int) (rand*grid.size())));/**/
		path = Astar.getPath();
		closed = Astar.getClosed();
		open = Astar.getOpen();
		System.out.println("time spent: " + Math.round((System.currentTimeMillis() - startTime)) + " millisec");
	}
	
	
	public void paint(Graphics g)
	{
		Constantes.image = createImage(Constantes.stageWidth, Constantes.stageHeight);
		Constantes.graphics = Constantes.image.getGraphics();
		
		drawgrid(Constantes.graphics);
		
		
		g.drawImage(Constantes.image, 0, 0, null);
		
		repaint();
	}

	private void drawgrid(Graphics g)
	{
		g.setColor(Color.black);
		for (int i = 0; i < grid.size(); i++){
			if (grid.get(i).type == 0){
				//g.drawRect(grid.get(i).x*Node.size, grid.get(i).y*Node.size, Node.size-1, Node.size-1);	
			}else{
				g.fillRect(grid.get(i).x*Node.size, grid.get(i).y*Node.size, Node.size, Node.size);
			}
		}
		
		if (closed.size() > 0){	
			for (int i = 1; i < closed.size(); i++){
				g.setColor(Color.magenta);
				g.fillRect(closed.get(i).x*Node.size, closed.get(i).y*Node.size, Node.size, Node.size);
				g.setColor(Color.black);
				//g.drawRect(closed.get(i).x*Node.size, closed.get(i).y*Node.size, Node.size-1, Node.size-1);
			}
			g.setColor(Color.black);
			//for (int i = 0; i < closed.size(); i++){	g.drawString("" + (closed.get(i).F), closed.get(i).x*Node.size, closed.get(i).y*Node.size+10);}
		}
		
		if (path.size() > 0){
			g.setColor(Color.blue);
			for (int i = 0; i < path.size(); i++){	g.fillRect(path.get(i).x*Node.size, path.get(i).y*Node.size, Node.size, Node.size);}
		}
		
		if (open.size() > 0){
			g.setColor(Color.cyan);
			for (int i = 0; i < open.size(); i++){	g.fillRect(open.get(i).x*Node.size, open.get(i).y*Node.size, Node.size, Node.size);}
		}
		
		g.setColor(Color.gray);
		for (int i = 0; i < grid.size(); i++){
			//if (grid.get(i).parent != null) g.drawLine(grid.get(i).x*Node.size+Node.size/2, grid.get(i).y*Node.size+Node.size/2, grid.get(i).parent.x*Node.size+Node.size/2, grid.get(i).parent.y*Node.size+Node.size/2);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		resetGrid();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
