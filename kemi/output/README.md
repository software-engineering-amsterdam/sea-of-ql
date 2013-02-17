Form output
===========

# Quick overview
* Compile a form
* Copy the folders
* Use the questionaire

# Introduction
The ql language allows you to create pages with forms without having knowledge 
of the technical implementation of these pages.

# Examples
Example forms (some of them with seeded errors) can be found [here](../examples/).

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

# Deployment
The resulting folder is a self-contained copy of the questionaire. Just copy the
folder to a webserver able to execute PHP scripts, and you can start using it.
The questionaire itself is the index.html, so normally it will be shown when 
the folder is accessed via a browser.  
