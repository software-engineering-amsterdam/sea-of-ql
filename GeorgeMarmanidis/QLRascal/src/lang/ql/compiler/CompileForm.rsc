@contributor{George Marmanidis -geo.marmani@gmail.com}
module lang::ql::compiler::CompileForm

import lang::ql::ast::AST;
import IO;
import lang::ql::compiler::GenerateHTMLForm;
import lang::ql::compiler::GenerateJavaScript;

public void compileForm(f:form(ident,formBody),loc target){
	formRefrnced=setConditionalReference(formBody);
	loc htmlFile=target.parent+"<ident>.html";
	writeFile(htmlFile,generateHTMLForm(ident,formRefrnced));
	loc jsFile=target.parent+"<ident>.js";
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
