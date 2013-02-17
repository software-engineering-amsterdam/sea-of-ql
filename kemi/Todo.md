# QL
* Refactoring / Adding comments
* Create awesome form to show off.

# QLS
* Update outliner: categorizing (like QL)
* Refactoring / Adding comments
* Create awesome stylesheet to show off.

# Issues
* In demo form: be over 18, fill in salary, go back, be under 18 (or actually 16, text is wrong), go forward: "Your salary is ... Any remarks?" still visible, due to nested conditionals.

# Discussion
* Syntax: all datatypes in separate modules (?)
  * No, I don't think so. It will be less clear, and we won't apply it for reuse.
    * I don't agree on it being less clear, I think it will be MORE clear
      * Well, we can split it up, but that results in a shitload of files.
         What we now have is alright in my opinion. Reusable stuff is extracted, 
         and the general QL stuff (or QLS) is just in their combined QL(s) syntax
         definition file. We now make very clear what will be reused and what not. 
* blockIdent (\<questionIdent\>Block) and similars in some public function?
* QL Outliner: Does in suffice now?
  * I like it, but let's verify with Tijs
* Maybe move the tests out of the lang::* package, and put it in tests/ql/... That way,
all tests are joined together and we can also make a single testrunner.
  * Hmmm, I don't know. I think it's quite common to have them inside the packages. Also, having a single testrunner would make QL kind of dependent on QLS.
* The slider does not work in non-chrome browser
  * Neither does the datepicker, cross-browser support is not part of this assignment.
* Pages can be empty now, what to do with those? Auto skipping is "possible"..

# BONUS:
* HTML templating
* Randomized testing for semantic checker
* Bonus exercise for Rascal variants: use SAT/SMT/Constraint solver to check for non-determinism.
