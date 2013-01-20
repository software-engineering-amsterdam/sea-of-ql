package org.uva.sea.ql.parser;

import org.uva.sea.ql.ast.ASTNode;

public class BasicVisitor implements ASTVisitor {
	
	int level = 0;

	public void inc(){
		level ++;
	}
	
	public void dec(){
		level --;
	}
	
	public void print(String s){

		for(int i = 0; i < level; i++){
			System.out.print(' ');
		}
		System.out.print(s);
		System.out.print('\n');
	}

	@Override
	public void visit(ASTNode node) {
		System.out.print(node.getClass().getName());
		System.out.print('\n');
		
	}
	
}
