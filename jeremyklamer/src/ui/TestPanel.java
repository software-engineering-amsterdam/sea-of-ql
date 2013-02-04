package ui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.test.ParseError;

@SuppressWarnings("serial")
public class TestPanel extends JFrame {

	public static void main(String[] args){
		createPanel();
	}
	
	public static void createPanel(){
		JPanel panel = new JPanel(new MigLayout());
		panel.setSize(500, 500);
		
		panel.setBackground(Color.cyan);
		panel.setVisible(true);
				
		JFrame frame = new JFrame();
		
		frame.setAlwaysOnTop(true);		
		frame.add(panel);
		
		frame.setLocationRelativeTo(null);	
		for(UIComponent comp : getHardForm().getUIComponents()){
			panel.add(comp.getComponent(), comp.getArgs());
		}
		frame.pack();
		frame.setVisible(true);
	}
	
	public static Form getEasyForm(){
		ANTLRParser parser = new ANTLRParser();
		Form form1 = null;
		try {
			form1 = parser.parseForm(
					"form Box1HouseOwning {" +
						"hasSoldHouse: \"Did you sell a house in 2010?\" money " +
						"hasBoughtHouse: \"Did you by a house in 2010?\" string " +
						"hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\"" +
						"boolean " +	
						"}");
		} catch (ParseError e) {
			e.printStackTrace();
		}
		
		return form1;
	}
	
	public static Form getNormalForm(){
		ANTLRParser parser = new ANTLRParser();
		Form form1 = null;
		try {
			form1 = parser.parseForm(
					"form Box1HouseOwning {" +
						"hasSoldHouse: \"Did you sell a house in 2010?\" money(15 + 18) " +
						"hasBoughtHouse: \"Did you by a house in 2010?\" string " +
						"hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\"" +
						"boolean " +
						"if (hasSoldHouse) {" +
							"sellingPrice: \"Price the house was sold for:\" money " +
							"privateDebt: \"Private debts for the sold house:\" money " +
							"valueResidue: \"Value residue:\" money(13 - 5) " +
							"} " +
						"}");
		} catch (ParseError e) {
			e.printStackTrace();
		}
		
		return form1;
	}
	
	public static Form getHardForm(){
		ANTLRParser parser = new ANTLRParser();
		Form form1 = null;
		try {
			form1 = parser.parseForm(
					"form Box1HouseOwning {" +
							"hasSoldHouse: \"Did you sell a house in 2010?\" boolean " +
							"hasBoughtHouse: \"Did you by a house in 2010?\" boolean " +
							"hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\"" +
							"boolean " +
							"if (hasSoldHouse) {" +
								"sellingPrice: \"Price the house was sold for:\" money " +
								"privateDebt: \"Private debts for the sold house:\" money " +
								"valueResidue: \"Value residue:\" money(13 - 5) " +
								"} " +
							"else { sellingPrice: \"lastquestion:\" money " +
								"} " +
							"}");
		} catch (ParseError e) {
			e.printStackTrace();
		}
		
		return form1;
	}
	
}
