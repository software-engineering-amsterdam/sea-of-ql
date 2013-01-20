package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.parser.ASTVisitor;

public class TestVisitor implements ASTVisitor{

	private final Class<? extends ASTNode>[] expectedASTClasses;
	
	private int i = 0;
	
	public TestVisitor(Class<? extends ASTNode>... expectedASTClasses){
		this.expectedASTClasses = expectedASTClasses;
	}

	@Override
	public void visit(ASTNode node) {
		final String nodeName = node.getClass().getName();
		if(expectedASTClasses.length >= i+1){
			assertEquals(expectedASTClasses[i].getName(), nodeName);
			i++;
		}else{
			fail("No AST elements expected. Found: " + nodeName);
		}
	}
	
	public void finish(){
		if(i != expectedASTClasses.length){
			fail("More AST elements expected, but none found. Next expected element: " + expectedASTClasses[i].getName());
		}
	}

}
