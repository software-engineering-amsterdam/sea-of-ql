package org.uva.sea.extensions;

public class Tuple<Left, Right> {
	private Left l;
	private Right r;
	public Tuple(Left l, Right r) {
		this.l = l;
		this.r = r;
	}
	
	public void setLeft(Left l) {
		this.l = l;
	}
	
	public void setRight(Right r) {
		this.r = r;
	}
	
	public Left getLeft() {
		return l;
	}
	
	public Right getRight() {
		return r;
	}
}
