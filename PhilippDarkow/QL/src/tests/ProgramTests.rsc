module tests::ProgramTests

import util::Parse;
import util::Implode;
import syntax::AbstractSyntax;
import Prelude;

private Program p(str src) = implodeProgram(parseProgram(src, |file:///testProgram.q|));

// Tests for easy Questions
public test bool testProgram1() = p("form Box1 { soldHouse: \"Did you sold a house?\" boolean } ") is program;
public test bool testExampleProgram1() = p("form Box1 { 
	hasSoldHouse: \"Did you sell a house in 2010?\" boolean 
	hasBoughtHouse: \"Did you by a house in 2010?\" boolean
	hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean 
	  if (hasSoldHouse) {
	    sellingPrice: \"Price the house was sold for:\" money
	    privateDebt: \"Private debts for the sold house:\" money
	    valueResidue: \"Value residue:\" money(sellingPrice - privateDebt)
	    }
	  } ") is program;