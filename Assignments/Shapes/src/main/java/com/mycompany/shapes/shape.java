/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.shapes;

/**
 *
 * @author apprentice
 */
public class shape {
    
    private P2d a, b;
    //The method design a simply line that it composed by 
    //two coordinated: (x0,y0) - extreme left - and (x1,y1) - extreme right
	public Line(int x0, int y0, int x1, int y1) {
		a = new P2d(x0, y0);
		b = new P2d(x1, y1);
	}

    //To move the figure simply use the vector passed as a parameter
	@Override
	public void move(V2d v) {
		a = a.sum(v);
		b = b.sum(v);
	}

    //To return the perimeter is sufficient to calculate 
    //the distance between the point "a" and "b"
	@Override
	public double getPerim() {
		return Math.abs(P2d.distance(a, b));
	}

	@Override
	public boolean isInside(P2d p1, P2d p2) {
		if ((Math.abs(a.getX()) <= Math.abs(p1.getX())) && // left extreme X
				(Math.abs(a.getY()) >= Math.abs(p1.getY())) && // left extreme Y
				(Math.abs(b.getX()) <= Math.abs(p2.getX())) && // right extreme X
				(Math.abs(b.getY()) <= Math.abs(p2.getY()))) // right extreme Y
			return true;
		else
			return false;
	}

	@Override
	public boolean contains(P2d p) {
		// if (distance(A, C) + distance(B, C) == distance(A, B))
		// return true; // C is on the line.
		// return false; // C is not on the line.

		if (P2d.distance(a, p) + P2d.distance(b, p) == P2d.distance(a, b))
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return "Line - Point a(" + a.getX() + 
			"-" + a.getY() + ") Point b("
				+ b.getX() + "-" + b.getY() + ")";
	}
}
