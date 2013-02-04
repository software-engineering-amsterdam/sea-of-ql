module lang::ql::generator::GenerateJavaContent

import List;
import lang::ql::ast::AST;
import lang::ql::generator::GenerateJava;

public str generateContent(list[Statement] statements, str parentPanel) {
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

str generateQuestion(noncomputed(str identifier, str label, Type tp), parentPanel) = 
	generateQuestion(identifier, label, tp, parentPanel);
	
str generateQuestion(computed(str identifier, str label, Type tp, _), parentPanel) = 
	"<generateQuestion(identifier, label, tp, parentPanel)>
	'<identifier>.setEnabled(false);\n";

str generateQuestion(str identifier, str label, Type tp, str parentPanel) = 
	"
	'<if(stringType() := tp){ ><identifier>.addFocusListener(this);<} else {><identifier>.addChangeListener(this);<}>
	'
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
	
	if (!isEmpty(elsePart)) {
		output += generatePanel(parentPanel, "else<id>");
		output += generateContent(elsePart, "else<id>");
	}
	
	return output;
}

str generatePanel(str parentPanel, str curPanel) = 
	"
	'<curPanel>.setLayout(new BoxLayout(<curPanel>, BoxLayout.Y_AXIS));
	'<parentPanel>.add(<curPanel>);\n";