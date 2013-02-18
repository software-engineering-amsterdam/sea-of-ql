module lang::ql::compiler::CompileForm

import ParseTree;
import lang::ql::ast::AST;
import IO;
import Node;
import util::ValueUI;
import lang::ql::compiler::GenerateHTMLForm;
import lang::ql::compiler::GenerateJavaScript;

anno str ConditionalStatement@ref;
anno str ElseIf@ref;
anno str FormBodyItem@ref;

public void compileForm(f:form(ident,formBody)){
	formRefrnced=setConditionalReference(formBody);
	print(ok);	
	loc htmlFile=|project://SofConsrt/<ident>.html|;
	writeFile(htmlFile,generateHTMLForm(ident,formRefrnced));
	loc jsFile=|project://SofConsrt/<ident>.js|;
	writeFile(jsFile,generateJavaScipt(formRefrnced));	   
}
	
//Sets a reference variable to conditional statements to refer to them
list[FormBodyItem] setConditionalReference(list[FormBodyItem] f){
	int reference=0;
		
	list[FormBodyItem] referList= 
		visit(f){
			case ConditionalStatement cs=> {
				reference+=1; 
				cs[@ref="<reference>"];
			}
		};
		
	return visit(referList){
		case q:ifElseIfCond(_,_,list[ElseIf] elseifBranch,_) => setConditionalReference(q,q@ref)
	};
}

ConditionalStatement setConditionalReference(q:ifElseIfCond(_,_,list[ElseIf] elseifBranch,_),str parentRef){
	int counter=0;
	
	return visit(q){
		case ElseIf elf => {
			counter+=1;
			elf[@ref="<parentRef>e<counter>"];
		}	
	}
}	
