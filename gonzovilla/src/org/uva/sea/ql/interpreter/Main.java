package org.uva.sea.ql.interpreter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.stat.Block;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.qlsource.QLReader;
import org.uva.sea.ql.test.IParse;
import org.uva.sea.ql.test.ParseError;
import org.uva.sea.ql.ast.visitor.CheckStat;

public class Main {

	public static void main(String[] args) throws ParseError, IOException {
		
		final Map<String, Type> typeEnv = new HashMap<String, Type>();
		final List<String> messages = new ArrayList<String>();

		IParse parser = new ANTLRParser();
		QLReader qlReader = new QLReader();			
		Block form = parser.parseForm(qlReader.read("InputForm.ql")).getBody();
		CheckStat checkStat = new CheckStat(typeEnv, messages);
		if (form.accept(checkStat)) {
			Renderer renderer = new Renderer();
			renderer.render(form);
		}
		else {
			System.out.println("Errors:");
			checkStat.printErrMsg();
		}
	}

}