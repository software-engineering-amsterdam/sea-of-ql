package org.uva.sea.ql.ast;

import java.util.ArrayList;

import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.statements.Statement;

public class Form implements ASTNode {
	private final Ident ident;
	private final ArrayList<Statement> stms;
	
	public Form(Ident ident, ArrayList<Statement> stms) {
		this.ident = ident;
		this.stms = stms;
	}
	
	public Ident getIdent() {
		return ident;
	}
	
	public ArrayList<Statement> getStms() {
		return stms;
	}
}