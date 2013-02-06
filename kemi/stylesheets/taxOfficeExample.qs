stylesheet taxOfficeExample {
  page "Housing" {
    section "Buying" {
      question hasBoughtHouse {
        widget checkbox
      }
      
    }
    
    section "Loaning" {
      question hasMaintLoan
    }
    
    section "Selling" {
      question hasSoldHouse
      section "You sold a house" {
        question sellingPrice
        question privateDebt
        question valueResidue
        default money {
          width 150
        }
        
      }
      
    }
    
    default boolean {
      widget radio
    }
    
  }
  
}
