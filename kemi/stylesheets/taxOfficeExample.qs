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
      question hasSoldHouse {
        widget select
      }
      section "You sold a house" {
        question sellingPrice
        question privateDebt {
          widget slider
        }
        
        question valueResidue
        default money {
          width 150
          widget number
        }
        
      }
      
    }
    
    default boolean {
      widget radio
    }
    
  }
  
}
