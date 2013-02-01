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

//Instrs compileStat(asgStat(str Id, QUE qName)) =
//	[lvalue(Id), *compileExp(qName), assign()];
	
Instrs compileStat(ifElseStat(EXP Exp,              
                              list[STATEMENT] Stats1,
                              list[STATEMENT] Stats2)){
  
  elseLab = nextLabel();
  endLab = nextLabel();  
  return [*compileExp(Exp), 
          gofalse(elseLab), 
          *compileStats(Stats1),  
          go(endLab), 
          label(elseLab), 
          *compileStats(Stats2), 
          label(endLab)];
}

// Compile a list of statements  Compiling a list of statements conveniently uses a list comprehension and list splicing.
Instrs compileStats(list[Statement] Stats1) =      
  [ *compileStat(S) | S <- Stats1 ];
  
// Compile declarations
// Compiling declarations allocates memory locations of the appropriate type for each declared variable.
Instrs compileDecls(list[Body] Body) =
  [ ((tp == natural()) ? dclNat(Id) : dclStr(Id))  |       
    decl(str Id, QUE tp) <- Body
  ];

//Instrs compileStatement(Statement s){
//	println("in compile statement <[s]>");
//	
//}

Instrs compileStatement(ifStat(Expression exp, list[Body] Body)){
	println("in compile statement <exp>");
	endLab = nextLabel();
	return[*compileExp(exp),
			gofalse(endLab),
			*compileBody(Body),
			go(endLab),
			label(endLab) ];
	
}


Instrs compileQuestion(Question q){
	println("in compile question <[q]>");
	// get the type of the question
	visit(q){
		case Type tp : {
			println("TP : <tp>");
			if(tp == money()){
				Instrs aa = [ dclMon(Id) |
	  			easyQuestion(str Id, str questionLabel, Type tp) <- [q]
	  			];
	  			println("AA : <aa>");
	  			return aa;
			}else if(tp == string()){
				Instrs aa = [ dclStr(Id) |
	  			easyQuestion(str Id, str questionLabel, Type tp) <- [q]
	  			];
	  			return aa;
			}else if(tp == boolean()){
				Instrs aa = [ dclBool(Id) |
	  			easyQuestion(str Id, str questionLabel, Type tp) <- [q]
	  			];
	  			return aa;
			} 
		}
	};
}

//Instrs compileQuestion(list[Question] Ques){
//	println("in compile question");
//	Instrs aa = [ ((tp == integer()) ? dclStr(Id) : dclInt(Id)) |
//	  question(str Id, str questionLabel, Type tp) <- Ques
//	  ];
//	  println("AA : <aa>");
//}


Instrs compileBody(list[Body] Body){
	Instrs questionResult = [];
	Instrs statementResult = [];
	visit(Body){
		case Question q : {
			println("IN Q : <q>");
			questionResult += [*compileQuestion(q)];
		}
		case Statement s : {
			println("In S : <s>");
			statementResult += [*compileStatement(s)];
			println("statementResult : <statementResult>");
		}
	}
	return questionResult;
}

// Compile a QL program
public Instrs compileProgram(Program P){
  nLabel = 0;
  if(program(Expression exp, list[Body] Body) := P){
     //println("EXP in COMPILE : <exp>");
     println("Body in COMPILE : <Body>");
     return [*compileBody(Body)];
  } else
    throw "Cannot happen";
}

public Instrs compileProgram(str txt) = compileProgram(load(txt));