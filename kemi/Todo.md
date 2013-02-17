# QL
* Refactoring / Adding comments
* Create awesome form to show off.

# QLS
* Update outliner: categorizing (like QL)
* Refactoring / Adding comments
* Create awesome stylesheet to show off.

# Issues
* In demo form: be over 18, fill in salary, go back, be under 18 , go forward: "Your salary is ... Any remarks?" still visible, due to nested conditionals.
  * I've created a small form that does the same thing (nestedbug). I've given it 
    some thought, but it will be tricky to fix. We'll discuss it tomorrow.

# Discussion
* Syntax: all datatypes in separate modules (?)
  * No, I don't think so. It will be less clear, and we won't apply it for reuse.
    * I don't agree on it being less clear, I think it will be MORE clear
      * Well, we can split it up, but that results in a shitload of files.
         What we now have is alright in my opinion. Reusable stuff is extracted, 
         and the general QL stuff (or QLS) is just in their combined QL(s) syntax
         definition file. We now make very clear what will be reused and what not. 
* blockIdent (\<questionIdent\>Block) and similars in some public function?
* QL Outliner: Does it suffice now?
  * I like it, but let's verify with Tijs
* Pages can be empty now, what to do with those? Auto skipping is "possible"..
  * Any idea how much work this will be? I think the 'need' is that it's a 
    nice bonus to have.

# BONUS:
* HTML templating
* Randomized testing for semantic checker
* Bonus exercise for Rascal variants: use SAT/SMT/Constraint solver to check for non-determinism.
