QL-Rascal 29/01/2012
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

TO DO
======================
Implement generator for JavaScript.
Need Changes:
-----------
  1. CompileExpression -change switch, make functions, because it's not open for extension
  2. GenerateJSvalidateFunctions  -changed by tijs--save/accept the changes, and find other relevant stuff
  3. GEnerateJSValidateFunctions - output source Code as writen bellow
  4. GEnerateJSValidateFunctions -  Change switch to Functions
  5. GenerateJSvalidateFunctions -  Remove stuff from here..External JS that provide these functions
  6. GenerateJSvalidateFunctions - Check for boolean output
  7. ExtractDependencies - use set instead of list..i don't want order, and i don't care for duplicates
  8. ExtractDependencies -Tijs provided better way..apply it..needs just return
  9. CyclicCheck - should start with false, because if env.symbols is empty, then it says that is cycclic ;)