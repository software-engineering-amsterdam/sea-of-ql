module compiler::Assembly

import syntax::AbstractSyntax;

public data Instr =
       dclMon(str id)    // Reserve a memory location for a money variable
     | dclStr(str id)    // Reserve a memory location for a string variable
     | dclBool(str id)   // Reserve a memory location for a bool variable
     | dclInt(str id)    // Reserve a memory location for a natural variable
     | pushMon(int intCon)      // Push integer constant (money) on the stack
     | pushStr(str strCon)      // Push string constant on the stack
     | pushBool(bool boolCon)	// Push bool constant on the stack
     | rvalue(str id)    // Push the value of a variable on the stack
     | lvalue(str id)    // Push the address of a variable on the stack
     | assign()                 // Assign value on top, to variable at address top-1
     | add2()                   // Replace top two stack values by their sum
     | sub2()                   // Replace top two stack values by their difference
     | conc2()                  // Replace top two stack values by their concatenation
     | label(str label)         // Associate a label with the next instruction
     | go(str  label)           // Go to instruction with given label
     | gotrue(str label)        // Go to instruction with given label, if top equals 0
     | gofalse(str label)       // Go to instruction with given label, if top not equal to 0
     ;