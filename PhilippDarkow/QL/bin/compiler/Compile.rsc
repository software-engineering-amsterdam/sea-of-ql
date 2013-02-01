module compiler::Compile

import Prelude;
import syntax::AbstractSyntax;
import compiler::Assembly;
import util::Load;
import compiler::ExpressionCompiler;

alias Instrs = list[Instr];     // We introduce Instrs as an alias for a list of assembly language instructions                  

//public Instrs compileExp(\int(int I)) = [pushInt(I)];

//public Instrs compileExp(string(str S)) = [pushStr(S)];
 
// Unique label generation

private int nLabel = 0;                            

private str nextLabel() {
  nLabel += 1;
  return "L<nLabel>";
}

// Compile a statement	
// Compile a list of statements  Compiling a list of statements conveniently uses a list comprehension and list splicing.
Instrs compileStats(list[Statement] Stats1) =      
  [ *compileStat(S) | S <- Stats1 ];
  

/** Method to compile an if statement
* @param ifStat the if Statement
* @return Instrs of an if Statement
* @author Philipp
*/
Instrs compileStatement(ifStat(Expression exp, list[Body] Body)){
	println("in compile statement <exp>");
	endLab = nextLabel();
	return[*compileExp(exp),
			gofalse(endLab),
			*compileBody(Body),
			go(endLab),
			label(endLab) ];
	
}

/** Method to compile an if else statement
* @param ifElseStat the if else Statement
* @return Instrs of an if else Statement
* @author Philipp
*/
Instrs compileStat(ifElseStat(Expression exp,list[Body] Body1, list[Body] Body2)){  
  elseLab = nextLabel();
  endLab = nextLabel();  
  return [*compileExp(exp), 
          gofalse(elseLab), 
          *compileBody(Body1),  
          go(endLab), 
          label(elseLab), 
          *compileBody(Body2), 
          label(endLab)];
}

/** Method to compile a computed Question  --> NOT DONE
* @param question the computed question
* @return Instrs of a computed question
* @author Philipp
*/
Instrs compileQuestion(question:computedQuestion(str id, str labelQuestion, Type tp, Expression exp)){
	println("in compile computed question <question>");
	
}

/** Method to compile an easy Question
* @param question the easy question
* @return Instrs of an easy question
* @author Philipp
*/
Instrs compileQuestion(question:easyQuestion(str id, str labelQuestion, Type tp)){
	println("in compile question <question>");
	// get the type of the question
	switch(tp){
		case money() : {
			return [ dclMon(Id) |
	  		easyQuestion(str Id, str questionLabel, Type tp) <- [question]
	  		];
		}
		case boolean() : return [ dclBool(Id) |
	  		easyQuestion(str Id, str questionLabel, Type tp) <- [question]];
		case string() : return aa = [ dclStr(Id) |
	  		easyQuestion(str Id, str questionLabel, Type tp) <- [question]];
	};
		
	//visit(q){
	//	case Type tp : {
	//		println("TP : <tp>");
	//		if(tp == money()){
	//			Instrs aa = [ dclMon(Id) |
	//  			easyQuestion(str Id, str questionLabel, Type tp) <- [q]
	//  			];
	//  			println("AA : <aa>");
	//  			return aa;
	//		}else if(tp == string()){
	//			Instrs aa = [ dclStr(Id) |
	//  			easyQuestion(str Id, str questionLabel, Type tp) <- [q]
	//  			];
	//  			return aa;
	//		}else if(tp == boolean()){
	//			Instrs aa = [ dclBool(Id) |
	//  			easyQuestion(str Id, str questionLabel, Type tp) <- [q]
	//  			];
	//  			return aa;
	//		} 
	//	}
	//};
}

/** Method to compile the Body fragment of the QL program
* @param Body the Body fragment
* @return Instrs
* @author Philipp
*/
Instrs compileBody(list[Body] Body){
	Instrs questionResult = [];
	Instrs statementResult = [];
	visit(Body){
		case Question q : {
			questionResult += [*compileQuestion(q)];
		}
		case Statement s : {
			statementResult += [*compileStatement(s)];
		}
	}
	return [*questionResult,*statementResult];
}

// Compile a QL program
public Instrs compileProgram(Program P){
  nLabel = 0;
  if(program(Expression exp, list[Body] Body) := P){
     println("Body in COMPILE : <Body>");
     return [*compileBody(Body)];
  } else
    throw "Cannot happen";
}

public Instrs compileProgram(str txt) = compileProgram(load(txt));