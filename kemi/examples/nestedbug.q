form nestedbug { 
  "True"
    boolean t
  if(t) { 
    "T2" 
      boolean t2
    if(t2) {
      "You can't touch this if"
          string nif
    } else {
      "You can't touch this else"
        string nelse
    }
  } else {
    "Outer conditional is false"
      string outer
  }
}
