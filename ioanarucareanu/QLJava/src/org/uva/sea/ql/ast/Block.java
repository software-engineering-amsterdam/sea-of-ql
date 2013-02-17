package org.uva.sea.ql.ast;

import java.util.ArrayList;
import java.util.List;

public class Block implements ASTNode {
	
	private final List<Statement> blockElements = new ArrayList<Statement>();

	public List<Statement> getBlockElements() {
		return blockElements;
	}
	
	public void addBlockElement(Statement element) {
		blockElements.add(element);
	}
}
