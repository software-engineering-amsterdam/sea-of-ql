module Compiler::Compile

import Prelude;
import syntax::abstractSyntax;
import Compiler::Assembly;
import load::Load;

alias Instrs = list[Instr];     //For a list of assembly language instructions                  
 
//unique label generation *PICO*

private int nLabel = 0;                            

private str nextLabel() 
{
  nLabel += 1;
  return "L<nLabel>";
}
//compile stats
Instrs compileStats(list[Statement] Stats1) = [ *compileStat(S) | S <- Stats1 ];  

//compile an if statement
Instrs compileStatement(ifStat(Expression exp, list[Statement] Stat))
{
	endLab = nextLabel();
	return[*compileExp(exp),gofalse(endLab),*compileStatement(Statement),go(endLab),label(endLab) ];
}

//Compile if else statement

Instrs compileStat(ifElseStat(Expression exp,list[Statements] Stat1, list[Statement] Stat2))
{  
  elseLab = nextLabel();
  endLab = nextLabel();  
  return [*compileExp(exp),gofalse(elseLab),*compileStatement(Stat1),go(endLab),label(elseLab),*compileStatement(Stat2),label(endLab)];
}

// Method to compile a computed Question

Instrs compileQuestion(question:computedQuestion(str id, str labelQuestion, Type tp, Expression exp))
{
/***********/	
}

// Method to compile an uncomputedQuestion
Instrs compileQuestion(question:uncomputedQuestion(str id, str labelQuestion, Type tp))
{
	switch(tp)
	{
		case money() : 
		{
			return [ dclMon(Id) |
	  		uncmputedQuestion(str Id, str questionLabel, Type tp) <- [question]];
		}
		case boolean() : return [ dclBool(Id) |uncomputedQuestion(str Id, str questionLabel, Type tp) <- [question]];
		case string() : return aa = [ dclStr(Id) |uncomputedQuestion(str Id, str questionLabel, Type tp) <- [question]];
	};

}

//compile the expresions 

public Instrs compileExp(moneyCon(real M)) = [pushMon(N)];  

public Instrs compileExp(boolCon(bool B)) = [pushBool(B)];

Instrs compileExp(stringCon(str S)) = [pushStr(substring(S,1,size(S)-1))];

public Instrs compileExp(id(str Id)) = [rvalue(Id)];

public Instrs compileExp(add(Expression Exp1, Expression Exp2)) = [*compileExp(Exp1), *compileExp(Exp2), add2()];

public Instrs compileExp(sub(Expression Exp1, Expression Exp2)) = [*compileExp(Exp1), *compileExp(Exp2), sub2()];

public Instrs compileExp(mul(Expression Exp1, Expression Exp2)) = [*compileExp(Exp1), *compileExp(Exp2), mul2()];
  
public Instrs compileExp(div(Expression Exp1, Expression Exp2)) = [*compileExp(Exp1), *compileExp(Exp2), div2()];
  
public Instrs compileExp(and(Expression Exp1, Expression Exp2)) = [*compileExp(Exp1), *compileExp(Exp2), and2()];

public Instrs compileExp(or(Expression Exp1, Expression Exp2)) = [*compileExp(Exp1), *compileExp(Exp2), or2()];
  
public Instrs compileExp(lt(Expression Exp1, Expression Exp2)) = [*compileExp(Exp1), *compileExp(Exp2), lt2()];
  
public Instrs compileExp(leq(Expression Exp1, Expression Exp2)) =[*compileExp(Exp1), *compileExp(Exp2), leq2()];
  
public Instrs compileExp(gt(Expression Exp1, Expression Exp2)) = [*compileExp(Exp1), *compileExp(Exp2), gt2()];
  
public Instrs compileExp(geq(Expression Exp1, Expression Exp2)) = [*compileExp(Exp1), *compileExp(Exp2), geq2()];
  
public Instrs compileExp(eq(Expression Exp1, Expression Exp2)) = [*compileExp(Exp1), *compileExp(Exp2), eq2()];
  
public Instrs compileExp(not(Expression Exp1)) = [*compileExp(Exp1), not1()];
  

// Compile the QL program
public Instrs compileProgram(Program P)
{
	nLabel = 0;
  	if(program(Expression exp, list[Statement] Stats) := P)
  	{
    	return [*compileStat(Statement)];
  	}
  	else
    throw "Cannot happen";
}

public Instrs compileProgram(str txt) = compileProgram(load(txt));