package org.uva.sea.ql.visitor.printer;

import java.io.IOException;
import java.io.OutputStream;

import org.uva.sea.ql.ast.statement.Statement;

public class QLPrinter extends StatementWalker {
	private final OutputStream out;

	public QLPrinter( OutputStream out ) {
		super( new ExpressionWalker() );
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
