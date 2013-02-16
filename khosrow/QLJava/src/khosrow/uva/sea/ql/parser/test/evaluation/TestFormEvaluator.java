package khosrow.uva.sea.ql.parser.test.evaluation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import khosrow.uva.sea.ql.ast.decl.Form;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.parser.jacc.JACCParser;
import khosrow.uva.sea.ql.parser.test.IParse;
import khosrow.uva.sea.ql.parser.test.ParseError;
import khosrow.uva.sea.ql.visitor.eval.FormEvaluator;
import khosrow.uva.sea.ql.visitor.interpreter.FormPrinter;

public class TestFormEvaluator {
	private static final String QLForm1 = "src/QLForm1.ql";
	private IParse parser;
	private FormEvaluator evaluator;
	private final Env env;
	
	public TestFormEvaluator(){
		parser = new JACCParser();
		env = new Env();
		evaluator = new FormEvaluator(env, new FormPrinter(env));
	}
	public static void main(String[] args) throws IOException {
	
		TestFormEvaluator tester = new TestFormEvaluator();
		try{
			String src = tester.readFile(QLForm1);			
			Form form = tester.parseForm(src);
			tester.evaluate(form);			
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			ArrayList<String> errors = (ArrayList<String>)tester.evaluator.getErrors();
			for(int i = errors.size()-1 ; i >= 0; i-- )
				System.out.println(errors.get(i));			
		}
	}
	
	private Form parseForm(String src) throws ParseError {		
		return parser.ParseForm(src);
	}
	
	private void evaluate(Form form){
		evaluator.evaluate(form);
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
