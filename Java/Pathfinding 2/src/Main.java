import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

import pathfinding.AStar;
import pathfinding.Node;
import pathfinding.NodeData;

import data.Constants;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Main();
	}
	
	public Main(){
		Constants.STAGE.setTitle("A* V2");
		Constants.STAGE.setSize(Constants.stageWidth, Constants.stageHeight);
		Constants.STAGE.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Constants.STAGE.setUndecorated(true);
		Constants.STAGE.setLocationRelativeTo(null);
		Constants.STAGE.setBackground(Color.white);
		Constants.STAGE.setVisible(true);
		
		loop();
	}
	
	int[][] field;
	
	public void loop(){
		field =  new int[][]{
				{0,0,0,0},
				{2,0,2,2},
				{0,6,0,0},
				{0,6,0,0},
				{0,5,10,0},
				{0,0,6,0},
				{0,0,6,0},
				{4,4,0,4},
				{0,0,0,0}
		};
		
		
		
		/*field = new int[Constants.stageWidth/NodeData.size][Constants.stageHeight/NodeData.size];
		
		for (int i = 0; i < field.length; i++)
		for (int j = 0; j < field[0].length; j++){
			if (Math.random()*5 > 4){
				field[i][j] = (int) (Math.random()*NodeData.data.length);
			}else{

				field[i][j] = 0;
			}
		}/**/
		
		AStar.setField(field);
		long t = System.currentTimeMillis();
		AStar.path(0, 0, field.length-1, field[0].length-1);
		System.out.println(System.currentTimeMillis() - t);
		Constants.image = Constants.STAGE.createImage(Constants.stageWidth, Constants.stageHeight);
		Constants.graphics = Constants.image.getGraphics();
		draw(Constants.graphics);
		
		t = System.currentTimeMillis();
		
		while (System.currentTimeMillis() - t < 5000){
			//waiting
		}
		loop();
	}
	
	public void draw(Graphics g){
		ArrayList<Node> open = AStar.getOpen();
		ArrayList<Node> closed = AStar.getClosed();
		ArrayList<Node> path = AStar.getPath();
		
		/*if (open != null){
			for (int i = 0; i < open.size(); i++){
				g.setColor(Color.green);
				g.fillRect(NodeData.size*open.get(i).x, NodeData.size*open.get(i).y, NodeData.size, NodeData.size);
			}
		}/**/
		
		if (closed != null){
			for (int i = 0; i < closed.size(); i++){
				g.setColor(Color.magenta);
				g.fillRect(NodeData.size*closed.get(i).x, NodeData.size*closed.get(i).y, NodeData.size, NodeData.size);
				g.setColor(Color.gray);
				if (closed.get(i).parent != null)g.drawLine(NodeData.size*closed.get(i).x + NodeData.size/2, NodeData.size*closed.get(i).y + NodeData.size/2, NodeData.size*closed.get(i).parent.x + NodeData.size/2, NodeData.size*closed.get(i).parent.y + NodeData.size/2);
			}
		}/**/
		
		if (path != null){
			for (int i = path.size()-1; i >= 0; i--){
				g.setColor(Color.cyan);
				g.fillRect(NodeData.size*path.get(i).x, NodeData.size*path.get(i).y, NodeData.size, NodeData.size);
				g.setColor(Color.gray);
				if (path.get(i).parent != null)g.drawLine(NodeData.size*path.get(i).x + NodeData.size/2, NodeData.size*path.get(i).y + NodeData.size/2, NodeData.size*path.get(i).parent.x + NodeData.size/2, NodeData.size*path.get(i).parent.y + NodeData.size/2);
			}
		}
		
		for (int i = 0; i < field.length; i++)
		for (int j = 0; j < field[0].length; j++){
			g.setColor(Color.black);
			//g.drawRect(i*NodeData.size, j*NodeData.size, NodeData.size-1, NodeData.size-1);
			if (NodeData.data[field[i][j]][0]){
				g.drawLine(i*NodeData.size, j*NodeData.size, (i+1)*NodeData.size-1, j*NodeData.size);
			}
			if (NodeData.data[field[i][j]][1]){
				g.drawLine((i+1)*NodeData.size-1, j*NodeData.size, (i+1)*NodeData.size-1, (j+1)*NodeData.size-1);
			}
			if (NodeData.data[field[i][j]][2]){
				g.drawLine(i*NodeData.size, (j+1)*NodeData.size-1, (i+1)*NodeData.size-1, (j+1)*NodeData.size-1);
			}
			if (NodeData.data[field[i][j]][3]){
				g.drawLine(i*NodeData.size, j*NodeData.size, i*NodeData.size, (j+1)*NodeData.size-1);
			}
		}
	
		
		Constants.STAGE.repaint();
	}

}
