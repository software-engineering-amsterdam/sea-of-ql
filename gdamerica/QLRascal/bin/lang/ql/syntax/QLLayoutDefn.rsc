module lang::ql::syntax::QLLayoutDefn

/**
 * This module contains all the QL layout definitions   
 * @author  Gerson Delgado
 * @version 1.0, 19/01/2013
 */
 
layout Standard 
  = WhitespaceOrComment* !>> [\ \t\n\f\r] !>> "//" !>> "/*"
  ; 