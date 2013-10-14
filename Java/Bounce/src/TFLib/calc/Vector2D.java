package TFLib.calc;

import java.util.ArrayList;

public class Vector2D {
	private float _dx;
	private float _dy;
	private float _r;
	private float _angle;
	
	public Vector2D(float dx, float dy){
		this._dx = dx;
		this._dy = dy;
		this._r = this.pole(dx, dy)[0];
		this._angle = this.pole(dx, dy)[1];
	}

	public <get> float dx(){
		return _dx;
	}
	
	public <get> float dy(){
		return _dy;
	}
	
	public <get> float r(){
		return _r;
	}
	
	public <get> float angle(){
		return _angle;
	}
	
	public <set> void dx(float dx){
		_dx = dx;
		this._r = this.pole(_dx, _dy)[0];
		this._angle = this.pole(_dx, _dy)[1];
	}
	
	public <set> void dy(float dy){
		_dy = dy;
		this._r = this.pole(_dx, _dy)[0];
		this._angle = this.pole(_dx, _dy)[1];
	}
	
	public <set> void r(float r){
		_r = r;
		_dx = aPole(_r, _angle)[0];
		_dy = aPole(_r, _angle)[1];
	}
	
	public <set> void angle(float angle){
		_angle = angle;
		_dx = aPole(_r, _angle)[0];
		_dy = aPole(_r, _angle)[1];
	}
	
	private float[] pole(float dx, float dy){
		float[] answer = new float[2];
		answer[0] = (float) Math.sqrt((dx*dx)+(dy*dy));
		answer[1] = (float) Math.atan2(dy, dx);
		return answer;
	}
	
	private float[] aPole(float r, float angle){
		float[] answer = new float[2];
		answer[0] = (float) (r*Math.cos(angle));
		answer[1] = (float) (r*Math.sin(angle));
		return answer;
	}
}
