package org.uva.sea.ql.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.interpreter.Value;
import org.uva.sea.ql.output.CSVWriter;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.test.ParseError;
import org.uva.sea.ql.ui.components.BaseComponent;


@SuppressWarnings("serial")
public class TestPanel extends JFrame {

	public static void main(String[] args){
		createPanel();
	}
	
	public static void createPanel(){
		JPanel panel = new JPanel(new MigLayout("hidemode 3"));
		panel.setVisible(true);
		JFrame frame = new JFrame();		
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		
		final Env testEnv = new Env(new HashMap<Ident,org.uva.sea.ql.ast.type.Type>(), new HashMap<Ident,Value>()); 
		final Form testForm = getHardForm();
		testForm.initTypes(testEnv);
		
		for(BaseComponent comp : testForm.getUIComponents(testEnv, testForm)){
			panel.add(comp.getComponent(), comp.getArgs());
		}
		
		JButton pickSaveLocation = new JButton();
		pickSaveLocation.setText("Save form");
		
		pickSaveLocation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) { 
					String saveLocation = chooser.getSelectedFile()+ "\\test.csv";
				//	CSVWriter.writeForm(testForm.getName(), testEnv, saveLocation);
				}
				else {
					new ErrorScreen("No directory selected, file not saved.");
				}
			}
		});
		
		panel.add(pickSaveLocation);
		frame.pack();
		frame.setVisible(true);
		testForm.eval(testEnv);
	}
	
	public static Form getEasyForm(){
		ANTLRParser parser = new ANTLRParser();
		Form form1 = null;
		try {
			form1 = parser.parseForm(
					"form Box1HouseOwning {" +
						"hasSoldHouse: \"how much sold\" boolean " +
						"hasBoughtHouse: \"How much bought\" boolean " +
						"hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\"" +
						"string " +
						"finalPric: \"integer spent : \" boolean(hasSoldHouse && hasBoughtHouse) " +
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
						"hasSoldHouse: \"Did you sell a house in 2010?\" boolean " +
						"hasBoughtHouse: \"Did you by a house in 2010?\" string " +
						"hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\"" +
						"boolean " +
						"if (hasSoldHouse) {" +
							"sellingPrice: \"Price the house was sold for:\" integer " +
							"privateDebt: \"Private debts for the sold house:\" integer " +
							"valueResidue: \"Value residue:\" integer(sellingPrice - 5) " +
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
								"sellingPrice: \"Price the house was sold for:\" integer " +
								"privateDebt: \"Private debts for the sold house:\" integer " +
								"valueResidue: \"Value residue:\" integer(privateDebt - sellingPrice) " +
								"} " +
							"else { sellingPrice: \"lastquestion:\" integer " +
									"happyness : \"are you happy with your house?\" string " + 
								"} " +
							"}");
		} catch (ParseError e) {
			e.printStackTrace();
		}
		
		return form1;
	}
	
}
