module lang::ql::generator::GenerateJava

import List;
import lang::ql::ast::AST;

anno str Statement@id;
anno str ElseIf@id;

// Give if-then-else statements a simple id, such that we can reference their bodies later
Form idStatements(Form form) {
	int counter = 0;
	
	return visit(form) {
		case Statement s => {
			counter += 1;
			s[@id = "<counter>"];
		}
		case ElseIf elseIf => {
			counter += 1;
			elseIf[@id = "<counter>"];
		}
	};
}

public str generateJava(Form form) { 
	form = idStatements(form);
	
	return 	"import java.awt.*;
			'import javax.swing.*;
			'
			'public class <form.name> extends JFrame {
			'	<generateInstanceVars(form)>
			'	<generateMainMethod(form)>
			'	
			'	<generateConstructor(form)>
			'}";
}

str generateInstanceVars(Form form) {
	str output = "";
	
	visit (form) {
		case computed(str identifier, _, Type tp, _):
			output += generateQuestionVar(identifier, tp);
		case noncomputed(str identifier, _, Type tp):
			output += generateQuestionVar(identifier, tp);
		case s:ifThenElse(_, _, _, _):
			output += (generatePanelVar("if<s@id>") + generatePanelVar("else<s@id>"));
		case s:ifThen(_, _, _): 
			output += generatePanelVar("if<s@id>");
		case ElseIf elseIf: 
			output += generatePanelVar("elseIf<elseIf@id>");
	};
	
	return output;
}

str generateQuestionVar(str identifier, intType()) = 
	"private SpinnerNumberModel <identifier>Model = new SpinnerNumberModel();
	'private JSpinner <identifier> = new JSpinner(<identifier>Model);\n";
	
str generateQuestionVar(str identifier, boolType()) = 
	"private JCheckBox <identifier> = new JCheckBox();\n";
	
str generateQuestionVar(str identifier, stringType()) = 
	"private JTextField <identifier> = new JTextField();\n";
	
str generatePanelVar(str name) =
	"private JPanel <name> = new JPanel();\n";
	
str generateMainMethod(Form form) = 
	"public static void main(String[] args) {
	'	EventQueue.invokeLater(new Runnable() {
    '		public void run() {
    '      		new <form.name>().setVisible(true);
  	'		}
   	'	});
	'}";
	
str generateConstructor(Form form) =
	"private <form.name>() {
	'	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  	'	setTitle(\"QL: <form.name>\");
  	'	setAlwaysOnTop(true);
  	'	setLocationByPlatform(true);
  	'	
  	'	JPanel content = new JPanel();
  	'	content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
   	'	content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
  	'	getContentPane().add(content, BorderLayout.CENTER);
  	'	<generateContent(form.body, "content")>	
  	'	pack();
	'}";
	
str generateContent(list[Statement] statements, str parentPanel) {
	str output = "";
	
	for (s <- statements) {
		if (question(Question q) := s) {
			output += generateQuestion(q, parentPanel);
		}		
		else if (s:ifThenElse(_, list[Statement] thenPart, list[ElseIf] elseIfs, list[Statement] elsePart) := s) {
			output += generatePanels(thenPart, elseIfs, elsePart, parentPanel, s@id);
		}
		else if (s:ifThen(_, list[Statement] thenPart, list[ElseIf] elseIfs) := s) {
			output += generatePanels(thenPart, elseIfs, [], parentPanel, s@id);
		}
	}
	
	return output;
}

str generateQuestion(noncomputed(str identifier, str label, _), parentPanel) = 
	generateQuestion(identifier, label, parentPanel);
	
str generateQuestion(computed(str identifier, str label, _, _), parentPanel) = 
	"<generateQuestion(identifier, label, parentPanel)>
	'<identifier>.setEnabled(false);\n";

str generateQuestion(str identifier, str label, str parentPanel) = 
	"
	'JPanel <identifier>Panel = new JPanel();
	'<identifier>Panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
   	'<identifier>Panel.setLayout(new GridLayout(1, 2, 10, 0));
   	'
	'JLabel <identifier>Label = new JLabel(<label>);
	'<identifier>Label.setHorizontalAlignment(SwingConstants.RIGHT);
	'
  	'<identifier>Panel.add(<identifier>Label);
  	'<identifier>Panel.add(<identifier>);
  	'<parentPanel>.add(<identifier>Panel);\n";
  	
str generatePanels(list[Statement] thenPart, list[ElseIf] elseIfs, list[Statement] elsePart, str parentPanel, str id) {
	str output = "";
	
	output += generatePanel(parentPanel, "if<id>");
	output += generateContent(thenPart, "if<id>");
	
	for (ElseIf elseIf <- elseIfs) {
		output += generatePanel(parentPanel, "elseIf<elseIf@id>");
		output += generateContent(elseIf.thenPart, "elseIf<elseIf@id>");
	}
	
	if (size(elsePart) > 0) {
		output += generatePanel(parentPanel, "else<id>");
		output += generateContent(elsePart, "else<id>");
	}
	
	return output;
}

str generatePanel(str parentPanel, str curPanel) = 
	"
	'<curPanel>.setLayout(new BoxLayout(<curPanel>, BoxLayout.Y_AXIS));
	'<parentPanel>.add(<curPanel>);\n";