# QL Interpreter

* Has a parser generator for QL.
* Has separate test runners for forms and expressions.
* Has a pretty printer that should render the textual representation from the AST.
* Has a semantic checker that finds all kinds of errors in the form definitions.
* Has a dynamic graphical user interface presenter for forgiving end-users.

## Building.

Use `make` to compile everything (this will generate classfiles next to the
sources).

## Running.

Run the parser generator

	make run/rats

Run the parser tests

	make run/testexpr
	make run/testform

### Pretty printer.

Run the pretty printer for a sample form

	make run/pretty

### Semantics checker.

Run the semantics checker for a sample form

	make run/check

It will check for these problems:

* type inconsistencies in expressions
* using the same question name with different data types
* using the same question name as calculated and user input
* undefined names in calculations
* duplicate form names

### Interpreter.

Run the interpreter for a sample form

	make run/interpret

## References.

*Assignment and AST*

* [Assignment](https://github.com/software-engineering-amsterdam/software-construction/wiki)
* [Workbench assignment](http://www.languageworkbenches.net/images/5/53/Ql.pdf)
* <http://sourcemaking.com/design_patterns/composite>
* <http://sourcemaking.com/design_patterns/interpreter>
* <http://lukaszwrobel.pl/blog/interpreter-design-pattern>

*Tools*

* [JUnit on GitHub](https://github.com/KentBeck/junit/wiki)

*Rats!*

* [Rats! Intro](http://cs.nyu.edu/rgrimm/xtc/rats-intro.html)

*Java etc.*

* [Joel on Exceptions](http://www.joelonsoftware.com/items/2003/10/13.html)
* [Packages](http://www.developer.com/java/other/article.php/10936_604651_1)
* [Naming packages](http://docs.oracle.com/javase/tutorial/java/package/namingpkgs.html)
