package ast;

import ast.expression.value.Ident;
import ast.statement.Block;
import ast.visitor.PrintExpressionVisitor;

public class Form implements ASTNode {
	
	private final Ident ident;
	private final Block content;
	
	public Form(Ident ident, Block content){
		this.ident = ident;
		this.content = content;
	}

	public Ident getIdent() {
		return ident;
	}

	public Statement getContent() {
		return content;
	}

	public void accept(PrintExpressionVisitor printExpressionVisitor) {
		printExpressionVisitor.visit(this);
		
	}


}
