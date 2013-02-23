package khosrow.uva.sea.ql.parser.test.evaluation;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import khosrow.uva.sea.ql.ast.decl.Form;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.parser.jacc.JACCParser;
import khosrow.uva.sea.ql.parser.test.IParse;
import khosrow.uva.sea.ql.parser.test.ParseError;
import khosrow.uva.sea.ql.ui.State;
import khosrow.uva.sea.ql.visitor.eval.FormEvaluator;
import khosrow.uva.sea.ql.visitor.interpreter.FormPrinter;
import khosrow.uva.sea.ql.visitor.interpreter.FormSwingInterpreter;

public class TestFormInterpreters {
	private static final String QLForm1 = "src/QLForm1.ql";
	private IParse parser;
	private final List<String> errors;
	private final Env env;
	private final State state;
	
	public TestFormInterpreters(){
		parser = new JACCParser();
		errors = new ArrayList<String>();
		env = new Env();
		state = new State(env);
	}
	public static void main(String[] args) throws IOException {
	
		TestFormInterpreters tester = new TestFormInterpreters();
		try{
			String src = tester.readFile(QLForm1);			
			Form form = tester.parseForm(src);
			tester.evaluate(form);	
			tester.interpretByFormPrinter(form);
			tester.interpretSwingInterpreter(form);
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());			
			for(int i = tester.errors.size()-1 ; i >= 0; i-- )
				System.out.println(tester.errors.get(i));			
		}
	}
	
	private Form parseForm(String src) throws ParseError {		
		return parser.ParseForm(src);
	}
	
	private void evaluate(Form form){
		FormEvaluator.evaluate(form.getStmts(), env, errors);
	}
	
	private void interpretByFormPrinter(Form form) {
		FormPrinter.interpret(form.getStmts(), env);
	}
	
	private JFrame interpretSwingInterpreter(Form form) {
		JFrame frame = new JFrame();		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		JPanel contentPane = (JPanel)FormSwingInterpreter.interpret(form.getStmts(), state).getComponent();
		contentPane.setAlignmentX(0);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane );
		frame.setVisible(true);
		return frame;
	}
		
	private String readFile( String file ) throws IOException {	   
		BufferedReader reader = new BufferedReader( new FileReader (file));
		try {
			String line = null;
			StringBuilder stringBuilder = new StringBuilder();
			String ls = System.getProperty("line.separator");

			while((line = reader.readLine()) != null ) {
				stringBuilder.append( line );
				stringBuilder.append( ls );
			}
			return stringBuilder.toString();
	    }
	    catch(Exception ex){
	    	throw new RuntimeException(ex);
	    }
	    finally{
	    	if (reader != null)
	    		reader.close();
	    }
	}	
}
