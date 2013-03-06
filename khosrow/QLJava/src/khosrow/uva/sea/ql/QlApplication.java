package khosrow.uva.sea.ql;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
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
	private static final String qlScource = "src/khosrow/uva/sea/ql/scource/QLForm3.ql";
	private static final String savePath = "src/khosrow/uva/sea/ql/scource/SavedData.xml";
	private IParse parser;
	private final List<String> errors;
	private Form form;
	private final Env env;
	private final State state;
	private JFrame frame;
	
	public static void main(String[] args) throws IOException {		
		QlApplication app = new QlApplication();
		try{
			String src = app.readScourceCode(qlScource);		
			app.form = app.parseScourceCode(src);
			app.evaluateForm();	
			app.run();
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
	
	private void evaluateForm(){
		FormEvaluator.evaluate(form.getStmts(), env, errors);
	}
	
	private void run() {
		frame = new JFrame();		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		JPanel contentPane = (JPanel)FormSwingInterpreter.interpret(form.getStmts(), state).getComponent();	
		
		JButton saveButton = new JButton("Save and exit");
		saveButton.addActionListener(new SaveListener());
		
		contentPane.add(saveButton, "gapleft 310");
		frame.setContentPane(contentPane);		
		frame.setVisible(true);
	}
	
	class SaveListener implements ActionListener {		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				QlXmlCreator.create(savePath, form, env);
				frame.dispose();
				
			} catch (IOException ex) {
				throw new RuntimeException(ex.getMessage());
			}			
		}		
	}
}
