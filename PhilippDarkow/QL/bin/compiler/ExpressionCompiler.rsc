module compiler::ExpressionCompiler

import Prelude;
import syntax::AbstractSyntax;
import compiler::Assembly;
import util::Load;

alias Instrs = list[Instr];     // We introduce Instrs as an alias for a list of assembly language instructions                  

// compile Expressions.
// The compiler consists of the functions compileExp, compileStat, compileStats, compileDecls and compileProgram.
// They all have a program fragment as argument and return the corresponding list of instructions
public Instrs compileExp(moneyCon(real M)) = [pushMon(N)];  

public Instrs compileExp(boolCon(bool B)) = [pushBool(B)];

//public Instrs compileExp(\int(int I)) = [pushInt(I)];

//public Instrs compileExp(string(str S)) = [pushStr(S)];

//Instrs compileExp(string(str S)) = [pushStr(substring(S,1,size(S)-1))];

public Instrs compileExp(id(str Id)) = [rvalue(Id)];

public Instrs compileExp(add(Expression E1, Expression E2)) =    
  [*compileExp(E1), *compileExp(E2), add2()];

public Instrs compileExp(sub(Expression E1, Expression E2)) =
  [*compileExp(E1), *compileExp(E2), sub2()];

public Instrs compileExp(mul(Expression E1, Expression E2)) =
  [*compileExp(E1), *compileExp(E2), mul2()];
  
public Instrs compileExp(div(Expression E1, Expression E2)) =
  [*compileExp(E1), *compileExp(E2), div2()];
  
public Instrs compileExp(and(Expression E1, Expression E2)) =
  [*compileExp(E1), *compileExp(E2), and2()];

public Instrs compileExp(or(Expression E1, Expression E2)) =
  [*compileExp(E1), *compileExp(E2), or2()];
  
public Instrs compileExp(lt(Expression E1, Expression E2)) =
  [*compileExp(E1), *compileExp(E2), lt2()];
  
public Instrs compileExp(leq(Expression E1, Expression E2)) =
  [*compileExp(E1), *compileExp(E2), leq2()];
  
public Instrs compileExp(gt(Expression E1, Expression E2)) =
  [*compileExp(E1), *compileExp(E2), gt2()];
  
public Instrs compileExp(geq(Expression E1, Expression E2)) =
  [*compileExp(E1), *compileExp(E2), geq2()];
  
public Instrs compileExp(eq(Expression E1, Expression E2)) =
  [*compileExp(E1), *compileExp(E2), eq2()];
  
//Instrs compileExp(conc(EXP E1, EXP E2)) =
//  [*compileExp(E1), *compileExp(E2), conc2()];
