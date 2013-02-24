package khosrow.uva.sea.ql;

import java.awt.FlowLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import khosrow.uva.sea.ql.ast.decl.Form;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.parser.jacc.JACCParser;
import khosrow.uva.sea.ql.parser.test.IParse;
import khosrow.uva.sea.ql.parser.test.ParseError;
import khosrow.uva.sea.ql.ui.State;
import khosrow.uva.sea.ql.visitor.eval.FormEvaluator;
import khosrow.uva.sea.ql.visitor.interpreter.FormSwingInterpreter;

public class QlApplication {
	private static final String QlScource = "src/khosrow/uva/sea/ql/scource/QLForm3.ql";
	private IParse parser;
	private final List<String> errors;
	private final Env env;
	private final State state;
	
	public static void main(String[] args) throws IOException {		
		QlApplication app = new QlApplication();
		try{
			String src = app.readScourceCode(QlScource);		
			Form form = app.parseScourceCode(src);
			app.evaluateForm(form);	
			app.run(form);
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());			
			for(int i = app.errors.size() - 1 ; i >= 0; i-- )
				System.out.println(app.errors.get(i));	
		}	
	}
	
	private QlApplication() {
		parser = new JACCParser();
		errors = new ArrayList<String>();
		env = new Env();
		state = new State(env);
	}
	
	private String readScourceCode(String src) throws IOException {
		return QlFileReader.read(src);
	}
	
	private Form parseScourceCode(String src) throws ParseError {		
		return parser.ParseForm(src);
	}
	
	private void evaluateForm(Form form){
		FormEvaluator.evaluate(form.getStmts(), env, errors);
	}
	
	private void run(Form form) {
		JFrame frame = new JFrame();		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		JPanel mainPanel = new JPanel( new FlowLayout(FlowLayout.CENTER, 0, 0) );
		JPanel contentPane = (JPanel)FormSwingInterpreter.interpret(form.getStmts(), state).getComponent();	
		mainPanel.add(contentPane);
		frame.setContentPane(mainPanel);		
		frame.setVisible(true);
	}

}
