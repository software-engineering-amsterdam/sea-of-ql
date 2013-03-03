import parser.JACCParser;
import parser.ParseError;
import visitor.Environment;
import visitor.checker.StatementChecker;
import visitor.evaluator.StatementEvaluator;
import visitor.ui.UIVisitor;

public class Program {
	private Environment environment;
	private String ql;
	private JACCParser parser;
	private UIVisitor ui;

	public Program() {
		this.environment = new Environment();
		init();
		loadParser();
		if (!parse()) {
			this.environment.printErrors();
			return;
		}
		if (!eval()) {
			this.environment.printErrors();
			return;
		}
		generateUI();
	}

	public static void main(String[] args) {
		new Program();
	}

	private void init() {
		ql = "form Box1HouseOwning { "
				//+ "\"Did you sell a house in 2010?\" hasSoldHouse: boolean "
				+ " hasSoldHouse: boolean "
				+ " hasSoldHouse: integer "
				+ "\"Did you by a house in 2010?\" hasBoughtHouse: boolean "
				+ "\"Value residue:\" hasBoughtHouse3 = hasBoughtHouse "
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
			parser.parse(ql).accept(new StatementChecker(environment));
			return (environment.getMessages().size() == 0);
		} catch (ParseError e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return false;
	}

	private boolean eval() {
		try {
			parser.parse(ql).accept(new StatementEvaluator(environment));
			return (environment.getMessages().size() == 0);
		} catch (ParseError e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return false;
	}

	private boolean generateUI() {
		ui = new UIVisitor(environment);
		try {
			parser.parse(ql).accept(ui);
			return (environment.getMessages().size() == 0);
		} catch (ParseError e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		ui.generate();
		return true;
	}
	
}
