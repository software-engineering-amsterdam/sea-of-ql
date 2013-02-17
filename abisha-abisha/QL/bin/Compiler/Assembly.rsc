//Example in PICO

module Compiler::Assembly

import syntax::abstractSyntax;  				

public data Instr = dclNat(QuestionId Id)    // Reserve a memory location for a natural variable
     | dclMon(QuestionId Id)					// Reserve a memory location for a money variable
     | dclBool(QuestionId Id)				// Reserve a memory location for a bolean variable
     | dclStr(QuestionId Id)    				// Reserve a memory location for a string variable
     | pushNat(int intCon)  					// Push integer constant on the stack
     | pushMon(int intCon)						// Push money constant on the stack
     | pushStr(str strCon)  					// Push string constant on the stack
     | rvalue(QuestionId Id)    				// Push the value of a variable on the stack
     | lvalue(QuestionId Id)    				// Push the address of a variable on the stack
     | assign()             					// Assign value on top, to variable at address top-1
     | add2()               					// Replace top two stack values by their sum
     | sub2()               					// Replace top two stack values by their difference
     | conc2()              					// Replace top two stack values by their concatenation
     | label(str label)     					// Associate a label with the next instruction
     | go(str  label)       					// Go to instruction with given label
     | gotrue(str label)    					// Go to instruction with given label, if top equals 0
     | gofalse(str label)   					// Go to instruction with given label, if top not equal to 0
     ;