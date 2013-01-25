package org.uva.sea.ql.interpreter.swing.panel;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.elements.Block;

public class BlockPanel extends JPanel {
	private static final long serialVersionUID = 2353016312324797192L;
	private Block block;

	public BlockPanel(Block block) {
		this.block = block;
	}

	public Block getBlock() {
		return block;
	}

}
