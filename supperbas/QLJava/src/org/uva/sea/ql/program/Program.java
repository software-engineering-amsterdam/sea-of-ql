package org.uva.sea.ql.program;
import org.uva.sea.ql.checker.StatementChecker;
import org.uva.sea.ql.evaluator.StatementEvaluator;
import org.uva.sea.ql.parser.JACCParser;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.ui.UIVisitor;


public class Program {
	private org.uva.sea.ql.checker.Environment checkEnv;
	private org.uva.sea.ql.evaluator.Environment evalEnv;
	private String ql;
	private JACCParser parser;
	private UIVisitor ui;

	public Program() {
		this.checkEnv = new org.uva.sea.ql.checker.Environment();
		init();
		loadParser();
		if (!parse()) {
			this.checkEnv.printErrors();
			return;
		}
		
		this.evalEnv = new org.uva.sea.ql.evaluator.Environment(checkEnv.getTypeEnv());
		
		if (!eval()) {
			this.evalEnv.printErrors();
			return;
		}
		generateUI();
	}

	public static void main(String[] args) {
		new Program();
	}

	private void init() {
		ql = "form Box1HouseOwning { "
				+ "\"Did you sell a house in 2010?\" hasSoldHouse: boolean "
				+ "\"Did you by a house in 2010?\" hasBoughtHouse: boolean "
				+ "\"Did you enter a loan for maintenance/reconstruction?\" hasMaintLoan: boolean "
				+ "if (hasSoldHouse) { "
				+ "\"Private debts for the sold house:\" privateDebt: money "
				+ "\"Price the house was sold for:\" sellingPrice: money "
				+ "\"Value residue:\" valueResidue = sellingPrice - privateDebt "
				+ "} else {"
				+ "if (hasBoughtHouse) { "
				+ "\"Private debts for the sold house:\" privateDebt2: string "
				+ " } "
				+ "\"Price the house was sold for:\" sellingPrice2: money "
				+ " } "		
				+ "}";
		
		// replace money with integer type to prevent parse errors
		ql = ql.replaceAll(": money", ": integer");
	}

	private void loadParser() {
		parser = new JACCParser();
	}

	private boolean parse() {
		try {
			parser.parse(ql).accept(new StatementChecker(checkEnv));
			return (checkEnv.getMessages().size() == 0);
		} catch (ParseError e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return false;
	}

	private boolean eval() {
		try {
			parser.parse(ql).accept(new StatementEvaluator(evalEnv));
			return (evalEnv.getMessages().size() == 0);
		} catch (ParseError e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return false;
	}

	private boolean generateUI() {
		ui = new UIVisitor(evalEnv);
		try {
			parser.parse(ql).accept(ui);
			return (evalEnv.getMessages().size() == 0);
		} catch (ParseError e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		ui.generate();
		return true;
	}
	
}
