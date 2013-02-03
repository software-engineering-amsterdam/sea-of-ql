module compiler::Compile

import Prelude;
import syntax::AbstractSyntax;
import compiler::Assembly;
import util::Load;

alias Instrs = list[Instr];     // We introduce Instrs as an alias for a list of assembly language instructions                  

// compile Expressions.
// The compiler consists of the functions compileExp, compileStat, compileStats, compileDecls and compileProgram.
// They all have a program fragment as argument and return the corresponding list of instructions
Instrs compileExp(moneyCon(Money M)) = [pushMon(N)];  

//Instrs compileExp(string(str S)) = [pushStr(substring(S,1,size(S)-1))];

Instrs compileExp(id(QuestionId Id)) = [rvalue(Id)];

public Instrs compileExp(add(EXP E1, EXP E2)) =    
  [*compileExp(E1), *compileExp(E2), add2()];

Instrs compileExp(sub(EXP E1, EXP E2)) =
  [*compileExp(E1), *compileExp(E2), sub2()];

//Instrs compileExp(conc(EXP E1, EXP E2)) =
//  [*compileExp(E1), *compileExp(E2), conc2()];


  
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

Instrs compileQuestion(Question q){
	println("in compile question <[q]>");
	Instrs aa = [ ((tp == integer()) ? dclInt(Id) : dclStr(Id)) |
	  easyQuestion(str Id, str questionLabel, Type tp) <- [q]
	  ];
	  println("AA : <aa>");
	  return aa;
}

//Instrs compileQuestion(list[Question] Ques){
//	println("in compile question");
//	Instrs aa = [ ((tp == integer()) ? dclStr(Id) : dclInt(Id)) |
//	  question(str Id, str questionLabel, Type tp) <- Ques
//	  ];
//	  println("AA : <aa>");
//}


Instrs compileBody(list[Body] Body){
	visit(Body){
		case Question q : {
			println("IN Q : <q>");
			return [*compileQuestion(q)];
		}
	}
}

//Instrs compileBody(list[Body] Body){
//			return [*compileQuestion(Body)];
//}

// Compile a Pico program

public Instrs compileProgram(Program P){
  nLabel = 0;
  if(program(Expression exp, list[Body] Body) := P){
     //println("EXP in COMPILE : <exp>");
     println("Body in COMPILE : <Body>");
     return [*compileBody(Body)];   //*compileDecls(Body), *compileStats(Series)
  } else
    throw "Cannot happen";
}

public Instrs compileProgram(str txt) = compileProgram(load(txt));