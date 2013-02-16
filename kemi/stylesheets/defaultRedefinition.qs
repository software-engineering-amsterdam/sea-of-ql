stylesheet defaultRedefinition {
  page "P1" {
    question bool
  
    default money {
      width 100
    }
    
    default money {
      widget number
    }
  }
  
  section "S1" {
    question int
    
    default integer {
      width 100
    }
    
    default integer {
      widget number
    }
  }

  default boolean {
    widget checkbox
  }
  default boolean {
    widget radio
  }
  
  default integer {
    width 200
  }
}
