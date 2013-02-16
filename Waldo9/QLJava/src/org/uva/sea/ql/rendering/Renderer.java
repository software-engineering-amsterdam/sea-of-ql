package org.uva.sea.ql.rendering;

public class Renderer {

	public static void main(String[] args) {
		RenderingVisitor renderingVisitor = new RenderingVisitor();
		renderingVisitor.testRender();
	}

}
