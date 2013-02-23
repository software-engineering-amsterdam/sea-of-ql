package org.uva.sea.ql.test;

import java.io.IOException;

import org.uva.sea.ql.ast.statements.Block;
import org.uva.sea.ql.parser.ANTLRParser;
import org.uva.sea.ql.rendering.Renderer;
import org.uva.sea.ql.typechecking.StatementTypeCheckingVisitor;

public class RenderDemo {

	public static void main(String[] args) throws ParseError, IOException {
		IParse parser = new ANTLRParser();
		QLFileReader qlFileReader = new QLFileReader();			
		Block mainBlock = parser.parseForm(qlFileReader.readQLFile("QLTestcase1.ql")).getBlock();
		StatementTypeCheckingVisitor typeChecker = new StatementTypeCheckingVisitor();
		if (mainBlock.accept(typeChecker)) {
			Renderer renderer = new Renderer();
			renderer.render(mainBlock);
		}
		else {
			System.out.println("Type errors have been found!");
			System.out.println("==========================================================");
			for (String error : typeChecker.getErrorMessages())				
				System.out.println(error);
		}
	}

}
