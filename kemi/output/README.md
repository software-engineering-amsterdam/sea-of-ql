Form output
===========

# Introduction
The ql language allows you to create pages with forms without having knowledge 
of the technical implementation of these pages.

Example forms (some of them with seeded errors) can be found [here](../forms/).

# Compilation
* When creating forms, complilations can be triggered by hand by using the right 
click menu on the form. The result will be in this folder.
* When a file is saved, compilation is also automatically triggered. The output
form wil also be in this filder 

# Form contents
Each form consists of a few items:

* An index.html file with the questionaire;
* A checking.js file to do clientside checking, validation and control flow 
operations;
* A qls.js file, ensuring proper styling of the form;
* A form.php script, to check and recalculate questions, which produces JSON 
of the questionaire output;
* A minified [JQuery 1.9.1](http://code.jquery.com/jquery-1.9.1.min.js);
* A [JQuery-validation plugin](https://github.com/jzaefferer/jquery-validation).

These files are all contained within a folder with the same name of the 
questionaire. Copying this folder is enough to start using it.
 
