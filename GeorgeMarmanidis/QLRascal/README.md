========================
||QL-Rascal 21/01/2012||
========================

GENERAL USAGE NOTES
======================
 - Use QL-Rascal to write questionnaires in QL-Language and export them to JavaScript/Java.
 - Supported variable types integer,string,boolean,money,date,float

----------------------

INSTALLATION
======================
 - You need Eclipse IDE and Rascal plugin installed to run QL Rascal
 - More info on Rascal at http://www.rascal-mpl.org/

----------------------

CONTACT
======================
 - Author : Georgios Marmanidis
 - Email  : geo.marmani@gmail.com

----------------------

KNOWN BUGS
======================

TO DO
======================
Refactoring
  Code Quality Changes:
   - General
      -  In pattern matching Type(or Variable name) is not nessesary.
      -  Check for unused imports.
      -  Change package names to lower case, files start with Upper case.
      -  One line functions can be written without {} but with =.
      -  Plugin.rsc: Create a function for annotator, not return in the register statement.
   - Package ast
       -  AST.rsc : correct variable names for lists : formItems ConditionalStatements
   - Package Semantic Check
       -  IdentDeclarationsCheck.rsc: - implement a visit to find nodes, remove everything else
                                                        - change !(x==y) with x!=y
     TypeCheck.rsc:  Make a function for required types, since it's overlapping many times
   Check also for these: 
   - IDE
   - Syntax
   - ASTTests
   - util

Bugs:
Known Bugs:
   1. Equiality must be implemented correct..== operator must check that both expr (le,re) are of the same type.
   2. Cyclic dependencies should implemented.
