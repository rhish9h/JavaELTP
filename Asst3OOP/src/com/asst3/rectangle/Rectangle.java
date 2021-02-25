package com.asst3.rectangle;

public class Rectangle {
	double length, breadth;
	
	Rectangle() {
		length = 0;
		breadth = 0;
	}
	
	Rectangle(double length, double breadth) {
		this.length = length;
		this.breadth = breadth;
	}
	
	public double calcArea() {
		return length * breadth;
	}
	
	public String toString() {
		return "length = " + this.length + " - " + "breadth = " + this.breadth;
	}
	
	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getBreadth() {
		return breadth;
	}

	public void setBreadth(double breadth) {
		this.breadth = breadth;
	}

}
