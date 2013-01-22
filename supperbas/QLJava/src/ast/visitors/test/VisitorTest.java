package ast.visitors.test;

public class VisitorTest {
	
	@SuppressWarnings("unused")
	private String str;

	public VisitorTest() {
		init();
	}
	
	public void init(){
		str = 	"form Box1HouseOwning {"+
					"\"Did you sell a house in 2010?\" hasSoldHouse: boolean "+
					"\"Did you by a house in 2010?\" hasBoughtHouse: boolean "+
					"\"Did you enter a loan for maintenance/reconstruction?\" "+
					"hasMaintLoan: boolean "+
					"if (hasSoldHouse) { "+
						"\"Private debts for the sold house:\" privateDebt: money "+
						"\"Price the house was sold for:\" sellingPrice: money "+
						"\"Value residue:\" valueResidue = sellingPrice - privateDebt "+
					"}"+
				"}";
	}

}
