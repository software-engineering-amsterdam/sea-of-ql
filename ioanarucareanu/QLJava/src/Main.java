import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.uva.sea.ql.ast.ql.QLForm;
import org.uva.sea.ql.parser.antlr.QLLexer;
import org.uva.sea.ql.parser.antlr.QLParser;
import org.uva.sea.ql.semanticchecker.SemanticVisitor;
import org.uva.sea.ql.semanticchecker.ValidationReport;

abstract class Home {
	
}
class House extends Home {
	
}
class Appartment extends Home {

}

class Visitor {
	void visit(Home home) {
		System.out.println("Home visiting");
	}
	void visit(House house) {
		System.out.println("House visiting");
	}
	void visit(Appartment appartment) {
		System.out.println("Appartment visiting");
	}	
}

interface AcceptingVisit<T extends Home> { 
	
	void act(T visitableElement, Visitor visitor);
}

class HouseAcceptingVisit implements AcceptingVisit<House> {
	@Override
	public void act(House visitableElement, Visitor visitor) {
		visitor.visit(visitableElement);
	}
}

class AppartmentAcceptingVisit implements AcceptingVisit<Appartment> {
	@Override
	public void act(Appartment visitableElement, Visitor visitor) {
		visitor.visit(visitableElement);
	}
	
}

public class Main {
	
	public static void main(String[] args) throws ClassNotFoundException {
		CharStream stream = new ANTLRStringStream(
				"form Box1HouseOwning {\n"
						+ "hasSoldHouse: \"Did you sell a house in 2010?\" boolean\n"
						+ "hasBoughtHouse: \"Did you by a house in 2010?\" boolean\n"
						+ "hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean\n"
						+ "if (hasSoldHouse) {\n"
						+ "sellingPrice: \"Price the house was sold for:\" int\n"
						+ "privateDebt: \"Private debts for the sold house:\" int\n"
						+ "valueResidue: \"Value residue:\" int(sellingPrice - privateDebt)\n"
						+ "}\n" + "}");
		QLLexer lexer = new QLLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokenStream);
		QLForm form = null;
		try {
			form = parser.qlform();
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SemanticVisitor visitor = new SemanticVisitor();		
		ValidationReport validationReport = visitor.start(form); 
		for (String error : validationReport.getErrors()) {
			System.out.println(error);
		}
	}
}
