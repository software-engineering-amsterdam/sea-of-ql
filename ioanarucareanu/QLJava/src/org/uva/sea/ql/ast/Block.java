package org.uva.sea.ql.ast;

import java.util.ArrayList;
import java.util.List;

public class Block<T extends Statement> {
	
	private final List<T> blockElements = new ArrayList<T>();

	public List<T> getBlockElements() {
		return blockElements;
	}
	
	public void addBlockElement(T element) {
		blockElements.add(element);
	}
}
