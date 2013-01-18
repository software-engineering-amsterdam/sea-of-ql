module compiler::Compile

import Prelude;
import syntax::AbstractSyntax;
import compiler::Assembly;
import typeChecker::Load;

alias Instrs = list[Instr];     // We introduce Instrs as an alias for a list of assembly language instructions                  

// compile Expressions.
// The compiler consists of the functions compileExp, compileStat, compileStats, compileDecls and compileProgram.
// They all have a program fragment as argument and return the corresponding list of instructions
Instrs compileExp(moneyCon(Money M)) = [pushMon(N)];  

Instrs compileExp(strCon(str S)) = [pushStr(substring(S,1,size(S)-1))];

Instrs compileExp(id(QuestionId Id)) = [rvalue(Id)];

Instrs compileExp(strQue(QuestionString qName)) = [rvalue(qName)];

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

Instrs compileStat(asgStat(QuestionId Id, QUE qName)) =
	[lvalue(Id), *compileExp(qName), assign()];
	
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
Instrs compileStats(list[STATEMENT] Stats1) =      
  [ *compileStat(S) | S <- Stats1 ];
  
// Compile declarations
// Compiling declarations allocates memory locations of the appropriate type for each declared variable.
Instrs compileDecls(list[DECL] Decls) =
  [ ((tp == natural()) ? dclNat(Id) : dclStr(Id))  |       
    decl(QuestionId Id, QUE tp) <- Decls
  ];

// Compile a Pico program

public Instrs compileProgram(PROGRAM P){
  nLabel = 0;
  if(program(EXP exp, list[DECL] Decls, list[STATEMENT] Series) := P){
     return [*compileDecls(Decls), *compileStats(Series)];
  } else
    throw "Cannot happen";
}

public Instrs compileProgram(str txt) = compileProgram(load(txt));