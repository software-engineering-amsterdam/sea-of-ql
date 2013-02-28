//test for the QL IDE
module Tests::ProgramTest

import Prelude;
import load::Parse;
import load::Implode;
import syntax::Abstract;

public test bool testProgram1() = p("form box1{soldHouse: \"did you sell a house?\"boolean}") is program;
public test bool testExampleProgram1()= ("form Box1 
	{
		hasSoldHouse:\"did you sell a house in 2010?\" boolean
		hasBoughtHouse:\"did you buy a house in 2010?\" boolean
		hasMainLoan: \"did you enter a loan for mantainence or reconstruction?\" boolean
		if(hasSoldHouse)
		{
			sellingPrice: \"price the house was sold:\"money
			privateDebt: \"Private debt for the sold house:\"money
			valueResidue: \"Value residue:\"money(sellingPrice-privateDebt)
		}
	}")is program;