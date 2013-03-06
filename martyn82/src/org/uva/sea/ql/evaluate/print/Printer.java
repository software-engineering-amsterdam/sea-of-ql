package org.uva.sea.ql.evaluate.print;

import java.io.IOException;
import java.io.OutputStream;

import org.uva.sea.ql.ast.statement.Statement;

abstract public class Printer extends StatementToString {
	private final OutputStream out;

	public Printer( OutputStream out ) {
		super( new ExpressionToString() );
		this.out = out;
	}

	private String getTreeAsString( Statement statement ) {
		return statement.accept( this );
	}

	public void print( Statement statement ) throws IOException {
		String tree = this.getTreeAsString( statement );
		this.out.write( tree.getBytes() );
	}
}
