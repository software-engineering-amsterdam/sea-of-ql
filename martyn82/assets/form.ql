form SampleForm {
    "Hoe oud bent u?" age : integer
    "Wat is uw inkomen (in hele euros)?" income : integer 
    "Hebt u een partner?" partner : boolean
    
    if ( partner && age > 18 ) {
        "Hoe oud is uw partner?" agePartner : integer
        "Wat is het inkomen van uw partner (hele euros)?" incomePartner : integer
        "Totaal inkomen:" totalPartner = income + incomePartner
    }
    else if ( age < 18 ) {
        "U bent jonger dan 18." under18 = age < 18
    }
    else {
        "Totaal inkomen:" total = income
    }
}